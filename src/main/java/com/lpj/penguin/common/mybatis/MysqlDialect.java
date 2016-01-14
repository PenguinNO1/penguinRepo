package com.lpj.penguin.common.mybatis;

/**
 * Created by free9 on 15/4/10.
 * mysql 使用的物理分页
 */
public class MysqlDialect extends Dialect {

    /**
     *
     * @param str
     * @param offset
     * @param limit
     * @return
     */
    public String getLimitString(String str, int offset, int limit) {
        String sql = str.trim();
        StringBuilder pagingSelect = new StringBuilder(sql.length() + 100);

        pagingSelect.append(sql);
        pagingSelect.append(" limit ").append(offset).append(",").append(limit);

        return pagingSelect.toString();
    }

}
