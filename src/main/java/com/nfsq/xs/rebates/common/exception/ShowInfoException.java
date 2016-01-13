package com.nfsq.xs.rebates.common.exception;

import java.io.Serializable;

/**
 * 类名:		NFSQException
 * 描述:		用于异常的封装
 * @author 	guoquanyao
 *
 */
public class ShowInfoException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -6844582544527740853L;

    private String            errorCode;

    private String            message;

    private Object[]          args;

    /**
     * NFSQException构造函数
     *
     * @param errorCode
     */
    public ShowInfoException(String errorCode) {
        this.errorCode = errorCode;
    }

    public ShowInfoException(String errorCode, Object... args) {
        this.errorCode = errorCode;
        this.args = args;
    }

    /**
     * @return 返回变量errorCode的值
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode 设置errorCode的值
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return 返回变量args的值
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * @param args 设置args的值
     */
    public void setArgs(Object... args) {
        this.args = args;
    }

    /**
     * @return 返回变量message的值
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message 设置message的值
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
