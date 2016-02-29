Ext.define("core.rbac.user.store.UserStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("com.zd.hr.domain.sys.SysUser","checked").modelName,
	proxy:{
		type:"ajax",
		url:"/sysuser/",
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