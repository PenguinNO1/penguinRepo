package com.lpj.penguin.common.bean;

import java.io.Serializable;

/**
 * 用户登录对象
 * Created by free9 on 15/12/7.
 */
public class AuthUserBean implements Serializable {
    /**
     * 员工ID
     */
    private Long empId;
    /**
     * 组织ID
     */
    private Long orgId;
    /**
     * 职位ID
     */
    private Long posId;
    /**
     * 员工姓名
     */
    private String empName;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getPosId() {
        return posId;
    }

    public void setPosId(Long posId) {
        this.posId = posId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
