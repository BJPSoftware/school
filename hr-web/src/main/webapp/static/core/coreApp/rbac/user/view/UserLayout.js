function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
Ext.define("core.rbac.user.view.UserLayout",{
	extend:"core.app.base.BasePanel",
	alias : 'widget.rbac.userlayout',
	funCode:"usermodule_main",
	funData:{
		action: getContextPath() + "/sysuser", //请求Action
		cmd: "edit",
		whereSql: "", //表格查询条件
		orderSql: " order by orderIndex", //表格排序条件
		pkName: "userId",
		modelName: "com.zd.hr.domain.sys.SysUser", //实体全路径
		tableName: "HR_SYS_USER", //表名
		defaultObj: {
			userPwd: "888888",
			userStatu:"0"
		}
	},
	items: [{
		xtype: "rbac.usergrid"
	},{
		xtype: "rbac.userform"
	}]
})