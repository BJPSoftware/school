/**
 * 
 */
package com.zd.hr.service.sys.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zd.core.service.BaseServiceImpl;
import com.zd.hr.dao.sys.SysUserDao;
import com.zd.hr.domain.sys.SysUser;
import com.zd.hr.service.sys.SysUserService;

/**

 * @author luoyibo
 *
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    
    @Resource
    public void setSysUserDao(SysUserDao sysUserDao) {
        this.dao = sysUserDao;
    }
}
