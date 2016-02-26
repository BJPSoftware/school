Ext.define("core.rbac.system.controller.DeptUserController",{
	extend:"Ext.app.Controller",
	mixins: {
		suppleUtil:"core.util.SuppleUtil",
		messageUtil:"core.util.MessageUtil",
		formUtil:"core.util.FormUtil",
		treeUtil:"core.util.TreeUtil",
		gridActionUtil:"core.util.GridActionUtil"
	},
	init:function(){
		var self=this
		//事件注册
		this.control({
			"panel[xtype=rbac.depttree]":{
				itemclick:function(tree,record,item,index,e,eOpts){
					var mainLayout=tree.up("panel[xtype=rbac.mainlayout]");
					var deptForm=mainLayout.down("panel[xtype=rbac.deptform]");
					var deptTree=mainLayout.down("panel[xtype=rbac.depttree]");
					var formObj=deptForm.getForm();
					formObj.findField("deptName").setValue(record.get("text"));
					formObj.findField("deptCode").setValue(record.get("code"));
					formObj.findField("deptId").setValue(record.get("id"));
					formObj.findField("orderIndex").setValue(record.get("orderIndex"));
					var treechildIns=deptTree.down("button[ref=treechildIns]");
					treechildIns.setDisabled(false);
					var treeDel=deptTree.down("button[ref=treeDel]");
					treeDel.setDisabled(false);
					
				}
			},
			"panel[xtype=rbac.depttree] button[ref=treeIns]":{
				click:function(btn){
					var tree=btn.up("panel[xtype=rbac.depttree]");
					var root=tree.getRootNode();
					var params={
						layer:root.getDepth()+1,
						nodeInfo:"Department",
						parentId:root.get("id"),
						nodeType:"LEAF"
					}
					var resObj=self.ajax({url:"/rbac/deptAction!doSave.action",params:params});
					if(resObj.success){
						var deptObj=resObj.obj;
						var nodeObj={
							id:deptObj.deptId
						}					
						params.parent=params.parentId;
						params.id=deptObj.deptId;
						params.leaf=true;
						var node=root.appendChild(params);
						tree.fireEvent("itemclick",tree.getView(),node);	
					}
				}
			},
			"panel[xtype=rbac.depttree] button[ref=treechildIns]":{
				click:function(btn){
					var tree=btn.up("panel[xtype=rbac.depttree]");
					var records=tree.getSelectionModel().getSelection();
					if(records.length<=0){
						alert("请选中节点!");
						return;
					}
					var parent=records[0];
					var params={
						layer:parent.getDepth()+1,
						nodeInfo:"Department",
						parentId:parent.get("id"),
						nodeType:"LEAF"
					}
					var resObj=self.ajax({url:"/rbac/deptAction!doSave.action",params:params});
					if(resObj.success){
						var deptObj=resObj.obj;
						var nodeObj={
							id:deptObj.deptId
						}
						params.parent=params.parentId;
						params.id=deptObj.deptId;
						params.leaf=true;
						parent.data.leaf=false;
						parent.commit();
						var node=parent.appendChild(params);
						tree.fireEvent("itemclick",tree.getView(),node);	
					}
				}
			},
			"panel[xtype=rbac.depttree] button[ref=treeDel]":{
				click:function(btn){
					var tree=btn.up("panel[xtype=rbac.depttree]");
					var records=tree.getSelectionModel().getSelection();
					if(records.length<=0){
						alert("请选中节点!");
						return;
					}
					var node=records[0];
					var resObj=self.ajax({url:"/rbac/deptAction!doRemove.action",params:{ids:node.get("id")}});
					if(resObj.success){
						tree.getStore().load();
						self.msgbox(resObj.obj);
					}else{
						alert(resObj.obj);
					}
				}
				
			}
		});
	},
	views:[
		"core.rbac.system.view.MainLayout",
		"core.rbac.system.view.DeptTree",
		"core.rbac.system.view.CenterLayout",
		"core.rbac.system.view.DeptForm",
		"core.rbac.system.view.UserLayout",
		"core.rbac.system.view.UserGrid"
	],
	stores:[
		//"core.rbac.system.store.DeptStore",
		//"core.rbac.system.store.UserStore"
	]
});