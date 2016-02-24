package com.zd.hr.dao.sys.Impl;

import org.springframework.stereotype.Repository;

import com.zd.core.dao.BaseDaoImpl;
import com.zd.hr.dao.sys.SysRoleDao;
import com.zd.hr.dao.sys.SysUserDao;
import com.zd.hr.domain.sys.SysRole;
import com.zd.hr.domain.sys.SysUser;

@Repository

public class SysRoleDaoImpl extends BaseDaoImpl<SysRole> implements SysRoleDao {

    public SysRoleDaoImpl() {
        // TODO Auto-generated constructor stub
        super(SysRole.class);
    }

}
