package com.zd.hr.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.zd.core.controller.ExtJSBaseController;
import com.zd.core.util.JsonBuilder;
import com.zd.hr.domain.sys.SysRole;
import com.zd.hr.service.sys.SysRoleService;


@Controller
@RequestMapping("/role")
public class SysRoleController extends ExtJSBaseController<SysRole> {

    @Resource
    private SysRoleService sysRoleService;
    
    @RequestMapping("/add")
    public void addRole(SysRole sysRoleModule,HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        SysRole sysRole = new SysRole();
        sysRole.setRoleName(sysRoleModule.getRoleName());
        sysRole.setRoleCode(sysRoleModule.getRoleCode());
        sysRole.setRoleDesc(sysRoleModule.getRoleDesc());
        
        sysRoleService.persist(sysRole);
        
        writeJSON(response, JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(sysRoleModule)));
    }

}
