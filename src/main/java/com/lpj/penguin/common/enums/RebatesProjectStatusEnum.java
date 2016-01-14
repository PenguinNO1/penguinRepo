package com.lpj.penguin.common.enums;

/**
 * Created by sliu15 on 15/12/5.
 */
public enum RebatesProjectStatusEnum {

    CLOSE(0, "关闭"),

    OPEN(1, "开启");

    private int code;

    private final String desc;

    private RebatesProjectStatusEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
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
