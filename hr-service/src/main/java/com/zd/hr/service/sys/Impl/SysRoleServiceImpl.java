package com.zd.hr.service.sys.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.core.service.BaseServiceImpl;
import com.zd.hr.dao.sys.SysRoleDao;
import com.zd.hr.domain.sys.SysRole;
import com.zd.hr.service.sys.SysRoleService;

@Service
public class SysRoleServiceImpl extends BaseServiceImpl<SysRole> implements SysRoleService{
    @Resource
    public void setSysRoleDao(SysRoleDao sysRoleDao) {
        this.dao = sysRoleDao;
    }

}
