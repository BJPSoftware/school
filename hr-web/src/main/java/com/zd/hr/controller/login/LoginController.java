package com.zd.hr.controller.login;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.apache.shiro.crypto.hash.Sha256Hash;

import com.zd.core.controller.BaseController;
import com.zd.core.util.JsonBuilder;
import com.zd.hr.domain.sys.SysUser;
import com.zd.hr.service.sys.SysUserService;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController<SysUser> {
    @Resource
    private SysUserService sysUserService;   
    
    @RequestMapping("/login")
    public void login (SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws Exception{
        Map<String, Object> result = new HashMap<String, Object>();
        SysUser sysUser = sysUserService.getByProerties("userName", sysUserModel.getUserName());
        if (sysUser == null) { // 用户名有误或已被禁用
            result.put("result", -1);
            //writeJSON(response, result);
            writeJSON(response, JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(result)));
            return;
        }
       
        if (!sysUser.getUserPwd().equals(new Sha256Hash(sysUserModel.getUserPwd()).toHex())) { // 密码错误
            result.put("result", -2);
            //writeJSON(response, result);
            writeJSON(response, JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(result)));
            return;
        }
//        sysUser.setLastLoginTime(new Date());
//        sysUserService.merge(sysUser);
//        Subject subject = SecurityUtils.getSubject();
//        subject.login(new UsernamePasswordToken(sysUserModel.getEmail(), sysUserModel.getPassword(), sysUserModel.isRememberMe()));
//        Session session = subject.getSession();
//        session.setAttribute(SESSION_SYS_USER, sysUser);
//        session.setAttribute("ROLE_KEY", sysUser.getRoles().iterator().next().getRoleKey());
        result.put("result", 1);
        //writeJSON(response, result);
        writeJSON(response, JsonBuilder.getInstance().returnSuccessJson(JsonBuilder.getInstance().toJson(result)));
    }
    @RequestMapping("/desktop")
    public String desktop(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "index";
    }
}
