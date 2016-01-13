package com.nfsq.xs.rebates.common.mybatis;

/**
 * Created by free9 on 14/12/19.
 */
public abstract class Dialect {

    public static enum Type {
        MYSQL,
        ORACLE
    }

    /**
     * 处理分页
     * @param sql
     * @param skipResults
     * @param maxResults
     * @return
     */
    public abstract String getLimitString(String sql, int skipResults, int maxResults);

}
