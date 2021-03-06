Ext.define("core.app.base.BaseForm",{
	extend:"Ext.form.Panel",
	alias:"widget.baseform",
	frame:true,
	layout:{
		type:"vbox",
		align:"center"
	},
	defaults:{
		xtype:"textfield",
		columnWidth:.4
	},
	tbar:[
		{xtype:"button",text:"保存",ref:"formSave",iconCls:"table_save"},
		{xtype:"button",text:"返回",ref:"formReturn",iconCls:"return"}
		]
});