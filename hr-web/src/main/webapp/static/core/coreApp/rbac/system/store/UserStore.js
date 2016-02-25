Ext.define("core.rbac.system.store.UserStore",{
	extend:"Ext.data.Store",
	//model:factory.ModelFactory.getModelByName("com.desktop.rbac.model.EndUser","checked").modelName,
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