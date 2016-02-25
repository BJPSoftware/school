Ext.define("core.rbac.system.view.MainLayout",{
	extend:"Ext.panel.Panel",
	alias : 'widget.rbac.mainlayout',
	layout : 'border',
	items : [{
		xtype:"rbac.depttree",
		region:"west",
		width:comm.get("clientWidth")*0.18
	},{
		xtype:"rbac.centerlayout",
		region:"center"
	}]
})