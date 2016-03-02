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
		text: '修改',
		ref: 'gridEdit',
		iconCls: 'table_edit'
	}, {
		xtype: 'button',
		text: '删除',
		ref: 'gridDelete',
		iconCls: 'table_remove'
	}, {
		xtype: 'button',
		text: '还原',
		ref: 'gridRestore',
		tooltip: '还原已删除的数据',
		iconCls: 'table_restore'
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
		text: "账户状态",
		dataIndex: "userStatu",
		renderer: function(value) {
			return (value == 0) ? '<font color=green>正常</font>' : '<font color=red>锁定</font>';
		}
	}, {
		text: "最后登录时间",
		dataIndex: "lastLogin",
		//xtype: 'datecolumn',
		//format : 'Y-m-d'
		renderer: function(value) {
			//return new Date(value).format("Y-m-d H:i:s");
			//return Ext.util.Format.date(value, 'Y-m-d');
			return Ext.Date.format(value, 'Y-m-d');
		}
	}, {
		text: "记录状态",
		dataIndex: "isDelete",
		renderer: function(value) {
			return (value == 0) ? '<font color=green>有效</font>' : '<font color=red>删除</font>';
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