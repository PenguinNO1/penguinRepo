package com.lpj.penguin.common.mybatis.interceptor;

import com.lpj.penguin.common.mybatis.Dialect;
import com.lpj.penguin.common.mybatis.MysqlDialect;
import com.lpj.penguin.common.mybatis.OracleDialect;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.RowBounds;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by free9 on 14/12/19.
 * mybatis 分页拦截器
 */
@Intercepts({@Signature(type=StatementHandler.class,method="prepare",args={Connection.class})})
public class PaginationInterceptor implements Interceptor {

    private String dialectName;

    /**
     * 拦截器方法
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler)invocation.getTarget();

        MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);

        RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
        if(rowBounds == null || rowBounds == RowBounds.DEFAULT) {
            return invocation.proceed();
        }

        String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

        Dialect dialect = null;
        switch(dialectName.toUpperCase()){
            case "ORACLE":
                dialect = new OracleDialect();
                break;
            case "MYSQL":
                dialect = new MysqlDialect();
                break;
            default:
                break;
        }

        if (dialect != null) {
            metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
            metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
            metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties arg0) {

    }

    public void setDialectName(String dialectName) {
        this.dialectName = dialectName;
    }

}
