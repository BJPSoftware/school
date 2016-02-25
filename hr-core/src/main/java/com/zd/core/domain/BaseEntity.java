package com.zd.core.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

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
    @Column(name = "CREATE_TIME", nullable = false, columnDefinition = "datetime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();

    @FieldInfo(name="创建人")
    @Column(name="CREATE_USER")
    private String createUser;
    
    @FieldInfo(name="最后修改时间")
    @Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();
    
    @FieldInfo(name="修改人")
    @Column(name="MODIFY_USER")
    private String modifyUser;
    
    @FieldInfo(name="版本")
    @Version
    @Column(name="VERSION")
    private int version;

    @FieldInfo(name="是否删除")
    @Column(name="ISDELETE")
    private int isDelete=0;

    @FieldInfo(name="排序字段")
    @Column(name="ORDER_INDEX")
    private Integer orderIndex;
    
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
    
}
