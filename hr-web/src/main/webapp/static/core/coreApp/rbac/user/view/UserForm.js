Ext.define("core.rbac.user.view.UserForm", {
    extend: "core.app.base.BaseForm",
    alias: "widget.rbac.userform",
    layout: "auto",
    align: "left",
    frame: true,
    fieldDefaults: { //统一设置表单字段默认属性
        labelSeparator: '：', //分隔符
        labelWidth: 80, //标签宽度
        msgTarget: 'side',
        width: 300
    },
    items: [{
        xtype: "textfield",
        fieldLabel: "主键",
        name: "userId",
        hidden: true
    }, {
        xtype: "textfield",
        fieldLabel: "默认密码",
        name: "userPwd",
        hidden: true
    }, {
        xtype: "textfield",
        fieldLabel: "登录账号",
        name: "userName",
        allowBlank: false,
        emptyText : '登录账号',
        blankText: "登录账号不能为空"
    }, {
        xtype: "textfield",
        fieldLabel: "用户姓名",
        name: "userCh",
        allowBlank: false,
        emptyText : '用户姓名',
        blankText: "用户姓名不能为空"
    }, {
        xtype: "textfield",
        fieldLabel: "用户状态",
        name: "userStatu"
    }, {
        xtype: "textfield",
        fieldLabel: "部门ID",
        name: "deptId",
        hidden: true
    }, {
        xtype: "textfield",
        fieldLabel: "部门名称",
        name: "deptName",
        readOnly: true
    }, {
        xtype: "textfield",
        fieldLabel: "部门代码",
        name: "deptCode",
        readOnly: true
    }]
});