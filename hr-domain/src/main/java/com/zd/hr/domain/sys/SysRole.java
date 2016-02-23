package com.zd.hr.domain.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.zd.core.annotation.FieldInfo;
import com.zd.core.support.ExtJSBaseParameter;

/**
 * 
 * <p>
 * Project: Credo's Base
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright (c) 2016 YmpcSoft.All Rights Reserved.
 * </p>
 * 
 * @author <a href="autumnal_wind@yeah.net">LuoYiBo</a>
 */
@Entity
@Table(name = "HR_SYS_ROLE")
public class SysRole extends ExtJSBaseParameter {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    @FieldInfo(name="主键")
    @Column(name = "ROLE_ID")
    private String roleId;
    
    @FieldInfo(name="角色名称")
    @Column(name="ROLE_NAME")
    private String roleName;
    
    @FieldInfo(name="角色代码")
    @Column(name="ROLE_CODE")
    private String roleCode;
    
    @FieldInfo(name="角色说明")
    @Column(name="ROLE_DESC")
    private String roleDesc;
    
    @FieldInfo(name="创建时间")
    @Column(name = "CREATE_TIME", nullable = false, columnDefinition = "datetime", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime = new Date();
    
    @FieldInfo(name="最后修改时间")
    @Column(name = "UPDATE_TIME", nullable = false, columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime = new Date();
    
    @FieldInfo(name="版本")
    @Version
    @Column(name="VERSION")
    private int version;

    public SysRole() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
        result = prime * result + ((roleCode == null) ? 0 : roleCode.hashCode());
        result = prime * result + ((roleDesc == null) ? 0 : roleDesc.hashCode());
        result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
        result = prime * result + ((roleName == null) ? 0 : roleName.hashCode());
        result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
        result = prime * result + version;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SysRole other = (SysRole) obj;
        if (createTime == null) {
            if (other.createTime != null)
                return false;
        } else if (!createTime.equals(other.createTime))
            return false;
        if (roleCode == null) {
            if (other.roleCode != null)
                return false;
        } else if (!roleCode.equals(other.roleCode))
            return false;
        if (roleDesc == null) {
            if (other.roleDesc != null)
                return false;
        } else if (!roleDesc.equals(other.roleDesc))
            return false;
        if (roleId == null) {
            if (other.roleId != null)
                return false;
        } else if (!roleId.equals(other.roleId))
            return false;
        if (roleName == null) {
            if (other.roleName != null)
                return false;
        } else if (!roleName.equals(other.roleName))
            return false;
        if (updateTime == null) {
            if (other.updateTime != null)
                return false;
        } else if (!updateTime.equals(other.updateTime))
            return false;
        if (version != other.version)
            return false;
        return true;
    }
    
    
    
}
