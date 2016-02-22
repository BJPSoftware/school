package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"zh-cn\">\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\r\n");
      out.write("\t\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t\t<title>智慧校园人力资源管理平台 - 登录</title>\r\n");
      out.write("\r\n");
      out.write("\t\t<meta name=\"description\" content=\"Java企业通用开发平台框架 |登录页面\" />\r\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- bootstrap & fontawesome -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/bootstrap.css\" />\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/font-awesome.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- text fonts -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/ace-fonts.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- ace styles -->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/ace.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if lte IE 9]>\r\n");
      out.write("\t\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/ace-part2.css\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/ace-rtl.css\" />\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if lte IE 9]>\r\n");
      out.write("\t\t  <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/css/ace-ie.css\" />\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("\t\t<!--[if lt IE 9]>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/html5shiv.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/respond.js\"></script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t</head>\r\n");
      out.write("\r\n");
      out.write("\t<body class=\"login-layout light-login\">\r\n");
      out.write("\t\t<div class=\"main-container\">\r\n");
      out.write("\t\t\t<div class=\"main-content\">\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-sm-10 col-sm-offset-1\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"login-container\">\r\n");
      out.write("\t\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h1>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"red\">&nbsp;</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t</h1>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"position-relative\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"login-box\" class=\"login-box visible widget-box no-border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"header blue lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-coffee green\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t登录智慧校园人力资源管理平台\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<form id=\"validationLoginForm\" method=\"post\" action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <input id=\"loginEmail\" name=\"email\" type=\"text\" class=\"form-control\" placeholder=\"邮箱\" data-rel=\"tooltip\" title=\"邮箱作为账号\" data-placement=\"right\" /> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"loginEmail\" name=\"userName\" type=\"text\" class=\"form-control\" placeholder=\"账号\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-user\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"loginPassword\" name=\"userPwd\" type=\"password\" class=\"form-control\" placeholder=\"密码\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-lock\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"loginTip\" style=\"color:#A94442\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"space\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"inline\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"rememberMe\" name=\"rememberMe\" type=\"checkbox\" class=\"ace\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"lbl\">下次自动登录</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button id=\"loginButton\" type=\"button\" class=\"width-35 pull-right btn btn-sm btn-primary\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-key\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"bigger-110\">登录</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-4\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div><!-- /.widget-main -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<div id=\"forgot-box\" class=\"forgot-box widget-box no-border\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"widget-body\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"widget-main\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<h4 class=\"header red lighter bigger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-key\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t找回密码\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</h4>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<div class=\"space-6\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<p>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t输入您的电子邮箱\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</p>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<form id=\"validationRetrieveForm\" method=\"post\" action=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input id=\"retrieveEmail\" name=\"email\" type=\"email\" class=\"form-control\" placeholder=\"邮箱\" title=\"邮箱作为用户名\" />\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-envelope\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<label class=\"block clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"block input-icon input-icon-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span id=\"retrieveTip\" style=\"color:#A94442\"></span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</label>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<button id=\"retrieveButton\" type=\"button\" class=\"width-35 pull-right btn btn-sm btn-danger\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-lightbulb-o\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"bigger-110\">发送</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</button>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div><!-- /.widget-main -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"toolbar center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\" data-target=\"#login-box\" class=\"back-to-login-link\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t登录\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<i class=\"ace-icon fa fa-arrow-right\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div><!-- /.widget-body -->\r\n");
      out.write("\t\t\t\t\t\t\t\t</div><!-- /.forgot-box -->\r\n");
      out.write("\t\t\t\t\t\t\t</div><!-- /.position-relative -->\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"navbar-fixed-top align-right\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a id=\"btn-login-dark\" href=\"#\">花瓣</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"blue\">/</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a id=\"btn-login-blur\" href=\"#\">风车</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"blue\">/</span>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<a id=\"btn-login-light\" href=\"#\">阳光</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t&nbsp; &nbsp; &nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div><!-- /.col -->\r\n");
      out.write("\t\t\t\t</div><!-- /.row -->\r\n");
      out.write("\t\t\t</div><!-- /.main-content -->\r\n");
      out.write("\t\t\t<div class=\"footer\">\r\n");
      out.write("                <div class=\"footer-inner\">\r\n");
      out.write("                    <!-- #section:basics/footer -->\r\n");
      out.write("                    <div class=\"footer-content-nobordertop\">\r\n");
      out.write("                        <span class=\"bigger-120\">\r\n");
      out.write("                            <span class=\"blue bolder\">\r\n");
      out.write("                                                                                                深圳圳道电子科技有限公司\r\n");
      out.write("                            </span>\r\n");
      out.write("                            &copy; \r\n");
      out.write("                            2015-2017\r\n");
      out.write("                        </span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!-- /section:basics/footer -->\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t</div><!-- /.main-container -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!-- basic scripts -->\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if !IE]> -->\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\twindow.jQuery || document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/jquery.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<!-- <![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t\t<!--[if IE]>\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write(" \t\t\twindow.jQuery || document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/jquery1x.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<![endif]-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t\tif('ontouchstart' in document.documentElement) document.write(\"<script src='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/jquery.mobile.custom.js'>\"+\"<\"+\"/script>\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/jquery.validate.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/tooltip.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/date-time/bootstrap-datepicker.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/date-time/locales/bootstrap-datepicker.zh-CN.js\"></script>\r\n");
      out.write("\t\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/static/assets/js/custom/login.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("contextPath");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
