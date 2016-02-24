package com.zd.hr.test.sys;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zd.hr.dao.sys.SysRoleDao;
import com.zd.hr.domain.sys.SysRole;
import com.zd.hr.service.sys.SysRolerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class SysRoleTest {

    @Resource
    SysRolerService sysRolerService;
    
    @Resource
    SysRoleDao sysRoleDao;
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public final void testRoleSave() {
        SysRole sysRole = new SysRole();
        sysRole.setRoleName("超级管理员");
        sysRole.setRoleCode("ROLE_ADMIN");
        sysRole.setRoleDesc("这是超级管理员");
        
        sysRolerService.persist(sysRole);
    }

}
