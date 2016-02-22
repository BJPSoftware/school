/**
 * 程序主控制器
 */
Ext.define("core.app.contoller.ButtonController",{
	extend:"Ext.app.Controller",
	initBtn:function(){
		var self=this;
		var btnCtr={
			"basegrid button[ref=gridInsertF]":{
					click:function(btn){
						var baseGrid=btn.up("basegrid");
						var funCode=baseGrid.funCode;
						var basePanel=baseGrid.up("basepanel[itemId="+funCode+"_basepanel]");
						var baseForm=basePanel.down("baseform[itemId="+funCode+"_baseform]");
						var funData=basePanel.funData;
						var defaultObj=funData.defaultObj;
						var formObj=baseForm.getForm();
						for(var field in defaultObj){
							var value=defaultObj[field];
							//@createTime@   @createUser@  @createDept@
							if(value.indexOf("@")>=0){
								if(value=="@createUser@"){
									value="zsp";
								}else if(value=="@createUserName@"){
									value="张帅鹏";
								}else if(value=="@createDept@"){
									value="yfb";
								}else if(value=="@createDeptName@"){
									value="研发部"
								}else if(value=="@createTime@"){
									value=new Date();
								}								
							}
							var f=formObj.findField(field);
							if(f){
								f.setValue(value);
							}
						}
						baseForm.show();
						baseGrid.hide();
					}
			},
			"basegrid button[ref=gridInsert]":{
					click:function(btn){
						
						alert("表格添加按钮")
					}
			},
			"basegrid button[ref=gridEdit]":{
					click:function(btn){
						alert("表格编辑按钮")
					}
			},
			"basegrid button[ref=gridDelete]":{
					click:function(btn){
						alert("表格删除按钮")
					}
			},
			"basegrid button[ref=gridSave]":{
					click:function(btn){
						alert("表格保存按钮")
					}
			},
			"baseform button[ref=formSave]":{
					click:function(btn){
						alert("表单保存按钮")
					}
			},
			"baseform button[ref=formReturn]":{
					click:function(btn){
						var baseForm=btn.up("baseform");
						var funCode=baseForm.funCode;
						var basePanel=baseForm.up("basepanel[itemId="+funCode+"_basepanel]");
						var baseGrid=basePanel.down("basegrid[itemId="+funCode+"_basegrid]");
						baseForm.hide();
						baseGrid.show();
					}
			}
		}
		Ext.apply(self.ctr,btnCtr);
	}
});