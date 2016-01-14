package com.lpj.penguin.dal.project.domain;

import java.io.Serializable;

/**
 * 返利品项DO
 * Created by sliu15 on 15/12/5.
 */
public class RebatesCategoryDO implements Serializable {

    /**
     * 主键
     * */
    private Long id;

    /**
     * 返利项目id
     * */
    private Long projectId;

    /**
     * 产品类型
     * */
    private String categorySort;

    /**
     * 品项id
     * */
    private Integer categoryId;

    /**
     * 返利类型：1=返利点，2=数量（冗余字段）
     * */
    private Integer type;

    /**
     * 比例 返利类型为返利点时使用
     * */
    private Integer proportion;

    /**
     * 箱数 返利类型为数量时使用
     * */
    private Integer box;

    /**
     * 瓶数 返利类型为数量时使用
     * */
    private Integer bottle;

    public RebatesCategoryDO() {

    }

    public RebatesCategoryDO(Long projectId, String categorySort, Integer categoryId, Integer type, Integer proportion,
                             Integer box, Integer bottle) {
        this.projectId = projectId;
        this.categorySort = categorySort;
        this.categoryId = categoryId;
        this.type = type;
        this.proportion = proportion;
        this.box = box;
        this.bottle = bottle;
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

    public String getCategorySort() {
        return categorySort;
    }

    public void setCategorySort(String categorySort) {
        this.categorySort = categorySort;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getProportion() {
        return proportion;
    }

    public void setProportion(Integer proportion) {
        this.proportion = proportion;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public Integer getBottle() {
        return bottle;
    }

    public void setBottle(Integer bottle) {
        this.bottle = bottle;
    }
}
