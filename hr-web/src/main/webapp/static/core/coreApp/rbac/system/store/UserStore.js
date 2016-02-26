Ext.define("core.rbac.system.store.UserStore",{
	extend:"Ext.data.Store",
	model:factory.ModelFactory.getModelByName("com.zd.hr.domain.sys.SysUser","checked").modelName,
	proxy:{
		type:"ajax",
		//url:"/rbac/userAction!load.action",
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