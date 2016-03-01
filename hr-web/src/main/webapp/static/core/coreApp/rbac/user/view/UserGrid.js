Ext.define("core.rbac.user.view.UserGrid", {
	extend: "core.app.base.BaseGrid",
	alias: "widget.rbac.usergrid",
	tbar: [{
		xtype: 'button',
		text: '添加',
		ref: 'gridInsertF',
		iconCls: 'table_add'
	}, {
		xtype: 'button',
		text: '删除',
		ref: 'gridDelete',
		iconCls: 'table_remove'
	}],
	columns: [{
		xtype: "rownumberer",
		width: 35,
		text: '序号',
		align: 'center'
	}, {
		text: "主键",
		dataIndex: "userId",
		hidden: true
	}, {
		text: "用户名",
		dataIndex: "userName",
		field: {
			xtype: "textfield"
		}
	}, {
		text: "用户姓名",
		dataIndex: "userCh",
		field: {
			xtype: "textfield"
		}
	}, {
		text: "当前状态",
		dataIndex: "userStatu"
	}, {
		text: "最后登录时间",
		dataIndex: "lastLoginTime",
		field:{
			xtype:"datetimefield",
			dateType:"date"
		}		
	}],
	store: "core.rbac.user.store.UserStore",
	bbar: {
		xtype: 'pagingtoolbar',
		store: 'core.rbac.user.store.UserStore',
		dock: 'bottom',
		displayInfo: true
	}
});