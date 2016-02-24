/**
 * �����������
 */
Ext.define("core.test.controller.TestController",{
	extend:"Ext.app.Controller",
	init:function(){
		var self=this
		//事件注册
		this.control({
			//注册添加按钮的回调函数
			"testgrid button[ref=gridInsert]":{
				beforeclick:function(btn){
					btn.callback=function(){
						alert("当前触发的是点击后的事件："+btn.text);
					}
					return true;
				}
			},
			"testform button[ref=formSave]":{
				beforeclick:function(btn){
					btn.callback=function(){
						
					}
				}
			}
		});
	},
	views:[
	"core.test.view.TestGrid",
	"core.test.view.TestForm",
	"core.test.view.TestPanel"
	]
});