package com.nfsq.xs.rebates.dal.project.domain;

import java.io.Serializable;

/**
 * 返利项目执行办事处DO
 * Created by sliu15 on 15/12/5.
 */
public class RebatesOrgDO implements Serializable {

    /**
     * 主键
     * */
    private Long id;

    /**
     * 返利项目id
     * */
    private Long projectId;

    /**
     * 组织（办事处）id
     * */
    private Long orgId;

    /**
     * 是否显示到前端 0-不显示 1－显示
     * */
    private Integer isShow;

    public RebatesOrgDO() {

    }

    public RebatesOrgDO(Long projectId, Long orgId, Integer isShow) {
        this.projectId = projectId;
        this.orgId = orgId;
        this.isShow = isShow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }
}
