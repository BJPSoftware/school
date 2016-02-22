/**
 * 程序外部组件引用
 */
function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}
 //初始化Ext.QuickTips，以使得tip提示可用
Ext.QuickTips.init();
//初始化提示工具框
Ext.tip.QuickTipManager.init();
//启动动态加载机制
Ext.Loader.setConfig({
	enabled:true,
	paths:{
		baseUx: getContextPath() + "/static/core/ux/base"
	}
})
//同步加载
Ext.syncRequire([
        "baseUx.form.datetime.DateTimePicker",
        "baseUx.form.datetime.DateTime"
]);
