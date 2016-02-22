function getContextPath() {
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0, index + 1);
    return result;
}

Ext.onReady(function(){
	Ext.application({
		name:"core",//引用的名称
		scope :this,
        appFolder : getContextPath() + "/static/core/coreApp",//应用的目录
        launch:function(){//当前页面加载完成执行的函数
        	
        },
        controllers:[
         "core.app.contoller.MainController"          //装载主控制器
        ]

	})
});