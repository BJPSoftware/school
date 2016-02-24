package com.zd.hr.test.sys;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zd.hr.dao.sys.SysRoleDao;
import com.zd.hr.domain.sys.SysRole;
import com.zd.hr.service.sys.SysRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class SysRoleTest {

    @Resource
    SysRoleService sysRoleService;
    
    @Resource
    SysRoleDao sysRoleDao;
    
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public final void testRoleSave() {
//        SysRole sysRole = new SysRole();
//        sysRole.setRoleName("超级管理员");
//        sysRole.setRoleCode("ROLE_ADMIN");
//        sysRole.setRoleDesc("这是超级管理员");
//        
//        sysRoleService.persist(sysRole);
    }
    
    @Test
    public final void testRoleUpdate(){
//        SysRole sysRole = sysRoleService.get("8a8a883453111e020153111e04c00000");
//        sysRole.setRoleDesc("超级管理员修改");
//        
//        sysRoleService.merge(sysRole);
    }

}
