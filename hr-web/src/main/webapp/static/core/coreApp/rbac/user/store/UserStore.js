function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}
Ext.define("core.rbac.user.store.UserStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("com.zd.hr.domain.sys.SysUser","checked").modelName,
	proxy:{
		type:"ajax",
		url:getContextPath() + "/sysuser/deptuserlist",
		extraParams :{whereSql: " and deptId in('ROOT')"},
		reader:{
			type:"json",
			root:"rows",
			totalProperty :'totalCount'
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
})