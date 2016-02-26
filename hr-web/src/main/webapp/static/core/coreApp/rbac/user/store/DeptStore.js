function getContextPath() {
	var pathName = document.location.pathname;
	var index = pathName.substr(1).indexOf("/");
	var result = pathName.substr(0, index + 1);
	return result;
}
Ext.define("core.rbac.user.store.DeptStore", {
	extend: "Ext.data.TreeStore",
	defaultRootId: "ROOT",
	model: factory.ModelFactory.getModelByName("com.zd.core.domain.extjs.JSONTreeNode", "checked").modelName,
	proxy: {
		type: "ajax",
		url: getContextPath() + "/sysdept/getDeptTree",
		extraParams: {
			excludes: 'checked'
		},
		reader: {
			type: "json"
		},
		writer: {
			type: "json"
		}
	},
	autoLoad: true
});