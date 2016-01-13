package com.nfsq.xs.rebates.common.enums;

/**
 * Created by sliu15 on 15/12/5.
 */
public enum RebatesTypeEnum {

    POINT(1, "返利点"),

    NUMBER(2, "数量");

    private int code;

    private final String desc;

    private RebatesTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }
}
