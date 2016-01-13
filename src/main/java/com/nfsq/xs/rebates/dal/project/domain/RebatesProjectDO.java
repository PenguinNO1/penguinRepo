package com.nfsq.xs.rebates.dal.project.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 返利项目DO
 * Created by free9 on 15/12/5.
 */
public class RebatesProjectDO implements Serializable{

    /**
     * 返利项项目id
     * */
    private Long projectId;

    /**
     * 返利项目名称
     * */
    private String name;

    /**
     * 执行时间
     * */
    private Integer executeDate;

    /**
     * 大区id
     * */
    private Long orgId;

    /**
     * 返利类型：1=返利点，2=数量
     * */
    private Integer type;

    /**
     * 返利点 选择数量是默认为0
     * */
    private Integer point;

    /**
     * 状态：0=关闭，1=开启
     * */
    private Integer status;

    /**
     *创建日期
     * */
    private Date createTime;

    /**
     * 修改日期
     * */
    private Date updateTime;

    /**
     * 操作人
     * */
    private Long operId;

    public RebatesProjectDO(){
    }

    public RebatesProjectDO(String name, Integer executeDate, Long orgId, Integer type, Integer point, Integer status,
                            Date createTime, Date updateTime, Long operId) {
        this.name = name;
        this.executeDate = executeDate;
        this.orgId = orgId;
        this.type = type;
        this.point = point;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.operId = operId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExecuteDate() {
        return executeDate;
    }

    public void setExecuteDate(Integer executeDate) {
        this.executeDate = executeDate;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getOperId() {
        return operId;
    }

    public void setOperId(Long operId) {
        this.operId = operId;
    }
}

