package com.lpj.penguin.dal.project.mapper;

import com.lpj.penguin.dal.project.domain.RebatesCategoryDO;

import java.util.List;

/**
 * 返利品项Mapper
 * Created by sliu15 on 15/12/5.
 */
public interface RebatesCategoryMapper {

    /**
     * 新增返利品项
     * @param rebatesCategoryDO
     * @return
     * */
    int insert(RebatesCategoryDO rebatesCategoryDO);

    /**
     * 根据返利项目id查询返利品项集合
     * @param projectId 返利项目id
     * @return 返回返利品项集合
     * */
    List<RebatesCategoryDO> queryByProjectId(Long projectId);
}
