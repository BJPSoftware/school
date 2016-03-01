<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">  
  <title>智慧校园人力资源管理系统</title>
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/resources/css/ext-all.css" />
  <!--  <link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/ext-theme-neptune/ext-theme-neptune-all.css" /> -->
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/examples/shared/example.css" />
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/examples/ux/css/TabScrollerMenu.css" />
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/ext/examples/ux/css/CheckHeader.css" />
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/MyDesktop/css/Desktop.css" />
  <link rel="stylesheet" type="text/css" href="${contextPath}/static/core/css/comm.css" />
  <script type="text/javascript" src="${contextPath}/static/ext/ext-all-debug.js"></script>
  <script type="text/javascript" src="${contextPath}/static/ext/locale/ext-locale-zh_CN.js"></script>
  <script type="text/javascript" src="${contextPath}/static/ext/examples/shared/examples.js"></script>
  <script type="text/javascript" src="${contextPath}/static/core/coreApp/util/overrideUtil.js"></script>
  <script type="text/javascript" src="${contextPath}/static/core/coreApp/util/comm.js"></script>
  <script type="text/javascript" src="${contextPath}/static/core/loader.js"></script>
  <script type="text/javascript" src="${contextPath}/static/core/app.js"></script>
</head>
<body>
	<script type="text/javascript">
			<!--加载分辨率大小-->
			var clientWidth = document.body.clientWidth;
			var clientHeight = document.body.clientHeight;
			var screenWidth = document.body.scrollWidth;
			var screenHeight = document.body.scrollHeight;
			var resolutionHeight = window.screen.height;
			var resolutionWidth = window.screen.width;
			comm.add("clientWidth",clientWidth);
			comm.add("clientHeight",clientHeight);
			comm.add("screenWidth",screenWidth);
			comm.add("screenHeight",screenHeight);
			comm.add("resolutionWidth",resolutionWidth);
			comm.add("resolutionHeight",resolutionHeight);   
           <!--改造窗体的层次-->
           Ext.override(Ext.ZIndexManager, {
               tempHidden: [],
               show: function () {
                   var comp, x, y;
                   while (comp = this.tempHidden.shift()) {
                       x = comp.x;
                       y = comp.y;
                       comp.show();
                       comp.setPosition(x, y);
                   }
               }
           });
           <!--加载程序-->
           Ext.Loader.setConfig({
                 enabled: true,
                 paths: {
                     'Ext.ux.desktop': '${contextPath}/static/MyDesktop/js',
                       'MyDesktop': '${contextPath}/static/MyDesktop'
                 }
             });
           <!--引用类-->
           Ext.require([
                   'MyDesktop.App'
                   ]);
            <!--实例化-->
           var myDesktopApp;
           Ext.onReady(function () {
               myDesktopApp = new MyDesktop.App();
           });
       </script>
	
</body>
</html>