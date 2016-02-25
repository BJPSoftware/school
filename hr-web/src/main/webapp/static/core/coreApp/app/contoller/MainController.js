/**
 * 程序主控制器
 */
Ext.define("core.app.contoller.MainController",{
	extend:"Ext.app.Controller",
	mixins: {
		btnCtr:"core.app.contoller.ButtonController",
		formCtr:"core.app.contoller.FormController",
		gridCtr:"core.app.contoller.GridController",
		panelCtr:"core.app.contoller.PanelController",
		gridActionUtil:"core.util.GridActionUtil",
		suppleUtil:"core.util.SuppleUtil",
		messageUtil:"core.util.MessageUtil",
		formUtil:"core.util.FormUtil",
		sqlUtil:"core.util.SqlUtil"
	},
	ctr:{},
	init:function(){
		var self=this;
		coreApp=self;
		self.initBtn();
		self.initForm();
		self.initGrid();
		self.initPanel();
		//console.log(Ext.create(factory.ModelFactory.getModelByName("com.zd.hr.domain.sys.SysDept","check").modelName))
		//注册事件
		this.control(self.ctr);
	},
	views:[
		"core.app.base.BaseGrid",
		"core.app.base.BaseForm",
		"core.app.base.BasePanel"
		]
});