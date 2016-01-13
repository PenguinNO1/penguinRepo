package com.nfsq.xs.rebates.dal.project.mapper;

import com.nfsq.xs.rebates.dal.project.domain.RebatesOrgDO;

import java.util.List;

/**
 * 返利项目执行办事处Mapper
 * Created by sliu15 on 15/12/5.
 */
public interface RebatesOrgMapper {

    /**
     * 新增返利项目执行办事处
     * @param rebatesOrgDO
     * @return
     * */
    int insert(RebatesOrgDO rebatesOrgDO);

    /**
     * 根据返利项目id查询返利项目执行办事处
     * @param projectId 返利项目id
     * @result 返利返利项目执行办事处集合
     * */
    List<RebatesOrgDO> queryByProjectId(Long projectId);
}
