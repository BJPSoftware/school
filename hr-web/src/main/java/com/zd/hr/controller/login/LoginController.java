package com.zd.hr.controller.login;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zd.hr.domain.sys.SysUser;
import com.zd.hr.service.sys.SysUserService;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private SysUserService sysUserService;   
    
    @RequestMapping("/login")
    public ModelAndView login (SysUser sysUserModel, HttpServletRequest request, HttpServletResponse response) throws Exception{
        
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("uerPwd");
        String userCh = request.getParameter("userCh");
        
        Date now = new Date();
        SysUser sysUser = new SysUser();
        sysUser.setUserName(sysUserModel.getUserName());
        sysUser.setUserPwd(sysUserModel.getUserPwd());
        sysUser.setUserCh(sysUserModel.getUserCh());
   
        //sysUserService.persist(sysUser);
        
        SysUser sysUserOld = sysUserService.get("8a8a88265278488c0152784a97480000");
        sysUserOld.setUserName(sysUserModel.getUserName());
        sysUserOld.setUserPwd(sysUserModel.getUserPwd());
        sysUserOld.setUserCh(sysUserModel.getUserCh());
        sysUserService.update(sysUserOld);
        //sysUserService.update(sysUserOld, "8a8a88265278465a015278465c450000");
        
        
        ModelAndView mav = null;
        if ("portal".equals(userCh)){
            mav = new ModelAndView("/desktop/portal");
            mav.addObject("常规界面", " hello  "+userName);

        } else {
            mav = new ModelAndView("/desktop/desktop");
            mav.addObject("desktop界面", " hello  "+userName);
        }
        
        return mav;        
    }
}
