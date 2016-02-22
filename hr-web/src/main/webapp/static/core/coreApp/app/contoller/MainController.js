/**
 * 程序主控制器
 */
Ext.define("core.app.contoller.MainController",{
	extend:"Ext.app.Controller",
	mixins: {
		btnCtr:"core.app.contoller.ButtonController"
	},
	ctr:{},
	init:function(){
		var self=this;
		coreApp=self;
		self.initBtn();
		//注册事件
		this.control(self.ctr);
	},
	views:[
		"core.app.base.BaseGrid",
		"core.app.base.BaseForm",
		"core.app.base.BasePanel"
		]
});