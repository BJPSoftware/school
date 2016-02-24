Ext.define("core.test.view.TestGrid",{
	extend:"core.app.base.BaseGrid",
	alias:"widget.testgrid",
	columns:[{
		xtype:"rownumberer",
		width : 35,
		text :'No.',
		align : 'center'
	},{
		text:"角色名称",
		dataIndex:"roleName",
		field:{
			xtype:"textfield"
		}
	},{
		text:"角色编码",
		dataIndex:"roleCode",
		field:{
			xtype:"textfield"
		}
	},{
		text:"角色说明",
		dataIndex:"roleDesc",
		field:{
			xtype:"textfield"
		}		
	}],
	store:Ext.create("Ext.data.Store",{
		fields:[
			{name:"roleName",type:"string"},
			{name:"roleCode",type:"string"},
			{name:"roleDesc",type:"string"}
			]
	})
});