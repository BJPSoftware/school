Ext.define("core.rbac.system.store.DeptStore",{
	extend:"Ext.data.TreeStore",
	defaultRootId:"ROOT",
	model:factory.ModelFactory.getModelByName("com.zd.core.domain.extjs.JSONTreeNode","checked").modelName,
	proxy:{
		type:"ajax",
		//url:"/rbac/deptAction!getTree.action",
		extraParams :{excludes: 'checked'},
		reader:{
			type:"json"
		},
		writer:{
			type:"json"
		}
	},
	autoLoad:true
 });