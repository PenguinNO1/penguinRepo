package com.nfsq.xs.rebates.dal.project.mapper;

import com.nfsq.xs.rebates.dal.project.domain.RebatesProjectDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * 返利项目 Mapper
 * Created by free9 on 15/12/5.
 */
public interface RebatesProjectMapper {

    /**
     * 新增返利项目
     * @param rebatesProjectDO
     * @return
     * */
    int insert(RebatesProjectDO rebatesProjectDO);

    /**
     * 根据projectId查询返利项目
     * @param projectId
     * @return
     */
    RebatesProjectDO queryById(Long projectId);

    /**
     * 根据执行年月和组织查询返利项目
     * @param executeDate 执行年月
     * @param orgId 大区id
     * @return
     * */
    List<RebatesProjectDO> queryByExecuteDateAndOrg(RowBounds rowBounds, @Param("executeDate")Integer executeDate,
                                              @Param("orgId")Long orgId);

    /**
     * 根据返利项目id切换状态
     * @param projectId 返利项目id
     *
     * */
    int updateStatus(Long projectId);

}
