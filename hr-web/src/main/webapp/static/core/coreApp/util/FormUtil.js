Ext.define("core.util.FormUtil",{
	/**
	 * 设置表单的值
	 * @param {} formObj
	 * @param {} obj
	 */
	setFormValue:function(formObj,obj){
		var fields=formObj.getFields().items;
		Ext.each(fields,function(field){
			var value=Ext.value(obj[field.name],null);
			formObj.findField(field.name).setValue(value);
		});
	}
});