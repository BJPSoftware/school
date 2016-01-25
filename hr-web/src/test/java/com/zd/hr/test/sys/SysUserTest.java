package com.zd.hr.test.sys;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zd.hr.dao.sys.SysUserDao;
import com.zd.hr.domain.sys.SysUser;
import com.zd.hr.service.sys.SysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class SysUserTest {
    @Resource
    SysUserService sysUserService;

    @Resource
    SysUserDao sysUserDao;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public final void testUserSave() {
        SysUser sysUser = new SysUser();
        sysUser.setUserName("admin");
        sysUser.setUserPwd("888888");
        sysUser.setUserCh("超级管理员");

        sysUserService.persist(sysUser);

    }
}
