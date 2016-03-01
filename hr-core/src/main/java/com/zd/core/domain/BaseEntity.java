package com.zd.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.aspectj.weaver.patterns.HasMemberTypePattern;

import com.zd.core.annotation.FieldInfo;

/**
 * 
 * <p>Project: Credo's Base</p>
 * <p>Description: 实体基类,系统所有实体都需要继承的基类</p>
 * <p>Copyright (c) 2016 YmpcSoft.All Rights Reserved.</p>
 * @author <a href="autumnal_wind@yeah.net">LuoYiBo</a>
 */
@MappedSuperclass
public class BaseEntity implements Serializable{
    
    private static final long serialVersionUID = 5941508938567597928L;

    @FieldInfo(name="创建时间")
    @Column(name = "CREATE_TIME",  columnDefinition = "datetime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @FieldInfo(name="创建人")
    @Column(name="CREATE_USER")
    private String createUser;
    
    @FieldInfo(name="最后修改时间")
    @Column(name = "UPDATE_TIME", columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();
    
    @FieldInfo(name="修改人")
    @Column(name="MODIFY_USER")
    private String modifyUser;
    
    @FieldInfo(name="版本")
    @Version
    @Column(name="VERSION")
    private Integer version;

    @FieldInfo(name="是否删除")
    @Column(name="ISDELETE")
    private Integer isDelete=0;

    @FieldInfo(name="排序字段")
    @Column(name="ORDER_INDEX")
    private Integer orderIndex;
    
    /**以下字段将不持久到数据库中*/
    /**第几页*/
    @Transient
    protected Integer start=Integer.valueOf(0);
    
    /**每页几条*/
    @Transient
    protected Integer limit=Integer.valueOf(30);
    
    /**排序*/
    @Transient
    protected String sort;
    
    /**查询条件*/
    @Transient
    protected String whereSql="";
    
    /**主功能过滤条件*/
    @Transient
    protected String parentSql="";
    
    @Transient
    protected String querySql="";
    
    /** 排序条件*/
    @Transient
    protected String orderSql="";
    
    @Transient
    private Map<String, Object> queryDynamicConditions = new HashMap<String, Object>(4);
    
    @Transient
    private Map<String, String> sortedConditions = new LinkedHashMap<String, String>(2);

    @Transient
    private Map<String, Object> dynamicProperties = new HashMap<String, Object>(4);
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }

    public String getParentSql() {
        return parentSql;
    }

    public void setParentSql(String parentSql) {
        this.parentSql = parentSql;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public String getOrderSql() {
        return orderSql;
    }

    public void setOrderSql(String orderSql) {
        this.orderSql = orderSql;
    }

    public Map<String, Object> getQueryDynamicConditions() {
        return queryDynamicConditions;
    }

    public void setQueryDynamicConditions(Map<String, Object> queryDynamicConditions) {
        this.queryDynamicConditions = queryDynamicConditions;
    }

    public Map<String, String> getSortedConditions() {
        return sortedConditions;
    }

    public void setSortedConditions(Map<String, String> sortedConditions) {
        this.sortedConditions = sortedConditions;
    }

    public Map<String, Object> getDynamicProperties() {
        return dynamicProperties;
    }

    public void setDynamicProperties(Map<String, Object> dynamicProperties) {
        this.dynamicProperties = dynamicProperties;
    }   
}
