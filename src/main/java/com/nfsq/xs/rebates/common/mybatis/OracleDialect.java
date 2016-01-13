package com.nfsq.xs.rebates.common.mybatis;

/**
 * Created by free9 on 14/12/19.
 * oracle 使用的物理分页
 */
public class OracleDialect extends Dialect {

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

        pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");

        pagingSelect.append(sql);

        pagingSelect.append(" ) row_ ) where rownum_ > ").append(offset).append(" and rownum_ <= ").append(offset + limit);

        return pagingSelect.toString();
    }

}
