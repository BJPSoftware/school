Ext.define("core.rbac.system.view.UserLayout",{
	extend:"core.app.base.BasePanel",
	alias : 'widget.rbac.userlayout',
	funCode:"usermodule_main",
	funData:{
	        action:"/rbac/userAction", //����Action
	        whereSql:"",//����ѯ����
	        orderSql:" order by orderIndex",//�����������
	        pkName:"userId",
	        modelName:"com.desktop.rbac.model.EndUser",//ʵ��ȫ·��
	        tableName:"EndUser",//����
	        defaultObj:{password:"123456"}
	},
	items :{
		xtype:"rbac.usergrid"
	}
})