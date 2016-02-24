function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}
Ext.define("core.test.view.TestPanel", {
    extend: "core.app.base.BasePanel",
    alias: "widget.testpanel",
    funCode: "testmodule_main",
    funData: {
        //action: "/test/testAction", // 请求Action
        action : getContextPath() + "/role/add",
        whereSql: "", // 表格查询条件
        orderSql: "", // 表格排序条件
        pkName: "roleId",
        modelName: "com.zd.hr.domian.sys.SysRole", // 实体全路径
        tableName: "", // 表名
        defaultObj: {
            roleName: "管理员",
            roleCode: "ROLE_RESTRICTED_ADMIN",
            roleDesc: "这是普通管理员"
        }, // 默认信息，用于表格添加的时候字段默认值
        childFun: []
    },
    items: [{
        xtype: "testgrid"
    }, {
        xtype: "testform",
        hidden: true
    }]
});