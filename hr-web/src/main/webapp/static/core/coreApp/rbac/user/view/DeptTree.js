Ext.define("core.rbac.user.view.DeptTree",{
	extend:"Ext.tree.Panel",
	alias : "widget.rbac.depttree",
	displayField : "text",
	rootVisible : false,
	store : "core.rbac.user.store.DeptStore",
	title:"用户部门"
})