package com.zd.hr.controller.desktop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zd.core.controller.ExtJSBaseController;
import com.zd.hr.domain.sys.SysUser;

@Controller
@RequestMapping("/desktop")
public class DesktopController extends ExtJSBaseController<SysUser> {

    @RequestMapping("/desktop")
    public ModelAndView desktop(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ModelAndView mav = new ModelAndView("/desktop/desktop");
        return mav;
    }

}
