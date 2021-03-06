/**
 * 程序主控制器
 */
Ext.define("core.app.contoller.ButtonController", {
    extend: "Ext.app.Controller",
    initBtn: function() {
        var self = this;
        var btnCtr = {
            /**
             * 通用表格添加进表单
             */
            "basegrid button[ref=gridInsertF]": {
                click: function(btn) {
                    var baseGrid = btn.up("basegrid");
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    var baseForm = basePanel.down("baseform[itemId=" + funCode + "_baseform]");
                    var funData = basePanel.funData;
                    var defaultObj = funData.defaultObj;
                    var formObj = baseForm.getForm();
                    var insertObj = self.getDefaultValue(defaultObj);
                    for (var field in insertObj) {
                        var value = insertObj[field];
                        // @createTime@ @createUser@ @createDept@
                        var f = formObj.findField(field);
                        if (f) {
                            f.setValue(value);
                        }
                    }
                    baseForm.show();
                    baseGrid.hide();
                    // 执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            },
            /**
             * 通用表格添加事件
             */
            "basegrid button[ref=gridInsert]": {
                click: function(btn) {
                    // 得到组件
                    var baseGrid = btn.up("basegrid");
                    var store = baseGrid.getStore();
                    // 得到编辑插件
                    var edit = baseGrid.editing;
                    // 得到模型
                    var Model = store.model;
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    // 得到配置信息
                    var funData = basePanel.funData;
                    var defaultObj = funData.defaultObj;
                    // 处理特殊默认值
                    var insertObj = self.getDefaultValue(defaultObj);

                    var resObj = self.ajax({
                        url: funData.action,
                        params: insertObj
                    });
                    if (resObj.success) {
                        var obj = new Model(resObj.obj);
                        edit.cancelEdit(); // 取消其他插件的编辑活动
                        store.insert(0, obj);
                        obj.commit();
                        // 设置第一行第二列编辑
                        edit.startEditByPosition({
                            row: 0,
                            column: 2
                        });
                        var editBtn = baseGrid.down("button[ref=gridEdit]");
                        if (editBtn) {
                            editBtn.setDisabled(false);
                        }
                        self.msgbox("添加成功");

                    } else {
                        alert(resObj.obj);
                    }
                    // 执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }

                }
            },
            /**
             * 通用表格编辑事件
             */
            "basegrid button[ref=gridEdit]": {
                click: function(btn) {
                    // 得到组件
                    var baseGrid = btn.up("basegrid");
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    var baseForm = basePanel.down("baseform[itemId=" + funCode + "_baseform]");
                    // 得到选中数据
                    var rescords = baseGrid.getSelectionModel().getSelection();
                    if (rescords.length == 0) {
                        self.msgbox("请选择数据");
                    } else if (rescords.length > 1) {
                        self.msgbox("只能修改一条数据,请重新选择!");
                    } else  if (rescords[0].get("isDelete")==1) {
                        self.msgbox("当前记录为删除状态，不能再修改");
                    } else {
                        alert(rescords[0].get("isDelete"));
                        var data = rescords[0].data;
                        // 表单赋值
                        self.setFormValue(baseForm.getForm(), data);
                        baseForm.show();
                        baseGrid.hide();
                    }

                    // 执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            },
            /**
             * 通用表格删除事件
             */
            "basegrid button[ref=gridDelete]": {
                click: function(btn) {
                    // 得到组件
                    var baseGrid = btn.up("basegrid");
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    // 得到配置信息
                    var funData = basePanel.funData;
                    var pkName = funData.pkName;
                    // 得到选中数据
                    var records = baseGrid.getSelectionModel().getSelection();
                    if (records.length > 0) {
                        // 封装ids数组
                        var ids = new Array();
                        Ext.each(records, function(rec) {
                            var pkValue = rec.get(pkName);
                            ids.push(pkValue);
                        });
                        // 发送ajax请求
                        var resObj = self.ajax({
                            url: funData.action + "/dodelete",
                            params: {
                                ids: ids.join(","),
                                pkName: pkName
                            }
                        });
                        if (resObj.success) {
                            baseGrid.getStore().load();
                            self.msgbox(resObj.obj);
                        } else {
                            self.msgbox(resObj.obj);
                        }
                    } else {
                        self.msgbox("请选择数据!");
                    }
                    // 执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            },
            /**
             * 通用表格保存事件
             */
            "basegrid button[ref=gridSave]": {
                click: function(btn) {
                    // 得到组件
                    var baseGrid = btn.up("basegrid");
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    // 得到配置信息
                    var funData = basePanel.funData;
                    var pkName = funData.pkName;
                    var cmd = funData.cmd;
                    var store = baseGrid.getStore();
                    // 得到修改的记录
                    var records = store.getUpdatedRecords();
                    if (records.length > 0) {
                        // 封装修改的字段数组
                        var updates = new Array();
                        Ext.each(records, function(rec) {
                            var obj = rec.getChanges();
                            obj[pkName] = rec.get(pkName);
                            updates.push(obj);
                        });
                        //得到更新的字符串
                        var strData = self.getUpdateSql(updates,
                            funData.modelName, funData.pkName);
                        //发送ajax
                        var resObj = self.ajax({
                            url: funData.action + "/dosave",
                            params: {
                                strData: strData,
                                cmd: cmd
                            }
                        });
                        if (resObj.success) {
                            self.msgbox(resObj.obj);
                        } else {
                            alert(resObj.obj);
                        }
                    } else {
                        self.msgbox("没有要保存的数据");
                    }
                    //执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }

                }
            },
            /**
             * 通用表格还原已删除事件
             */
            "basegrid button[ref=gridRestore]": {
                click: function(btn) {
                    // 得到组件
                    var baseGrid = btn.up("basegrid");
                    var funCode = baseGrid.funCode;
                    var basePanel = baseGrid.up("basepanel[itemId=" + funCode + "_basepanel]");
                    // 得到配置信息
                    var funData = basePanel.funData;
                    var pkName = funData.pkName;
                    // 得到选中数据
                    var records = baseGrid.getSelectionModel().getSelection();
                    if (records.length>0){
                        //封装ids数组
                        var ids = new Array();
                        Ext.each(records, function(rec) {
                            var pkValue = rec.get(pkName);
                            ids.push(pkValue);
                        }); 
                        // 发送ajax请求
                        var resObj = self.ajax({
                            url: funData.action + "/dorestore",
                            params: {
                                ids: ids.join(","),
                                pkName: pkName
                            }
                        });  
                        if (resObj.success) {
                            baseGrid.getStore().load();
                            self.msgbox(resObj.obj);
                        } else {
                            self.msgbox(resObj.obj);
                        }                                                                     
                    }
                    else {
                        self.msgbox("请选择要还原的记录");
                    }
                    // 执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            },            
            /**
             * 表单的保存
             */
            "baseform button[ref=formSave]": {
                click: function(btn) {
                    //拿到组件和配置信息
                    var baseForm = btn.up("baseform");
                    var funCode = baseForm.funCode;
                    var basePanel = baseForm.up("basepanel[itemId=" + funCode + "_basepanel]");
                    var baseGrid = basePanel.down("basegrid[itemId=" + funCode + "_basegrid]");
                    var funData = basePanel.funData;
                    var pkName = funData.pkName;
                    //拿到formObj对象
                    var formObj = baseForm.getForm();
                    var pkField = formObj.findField(pkName);
                    //判断当前是保存还是修改操作
                    var act = Ext.isEmpty(pkField.getValue()) ? "doadd" : "doupdate";
                    if (!formObj.isValid()) {
                        var errors = ["前台验证失败，错误信息："];
                        formObj.getFields().each(
                            function(f) {
                                if (!f.isValid()) {
                                    errors.push("<font color=red>" + f.fieldLabel + "</font>:" + f.getErrors().join(
                                        ","));
                                }
                            });
                        self.msgbox(errors.join("<br/>"));
                    };
                    formObj.submit({
                            url: funData.action + "/" + act,
                            params: {},
                            //可以提交空的字段值
                            submitEmptyText: true,
                            //成功回调函数
                            success: function(form, action) {
                                var obj = action.result.obj;
                                if (action.result.success) {
                                    //对象成功后处理
                                    //刷新表单
                                    self.setFormValue(formObj, obj);
                                    //load表格
                                    baseGrid.getStore().load();
                                    if (act == "doadd") {
                                        self.msgbox("数据添加成功");
                                    } else {
                                        self.msgbox("数据保存成功");
                                    }
                                } else {
                                    self.msgbox(obj);
                                }
                            },
                            //错误信息处理
                            failure: function(form, action) {
                                //前台表单校验错误
                                var obj = action.result.obj;
                                self.msgbox(obj);
                            }
                        })
                        //执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            },
            /**
             *  通用表单返回事件
             */
            "baseform button[ref=formReturn]": {
                click: function(btn) {
                    var baseForm = btn.up("baseform");
                    var funCode = baseForm.funCode;
                    var basePanel = baseForm.up("basepanel[itemId=" + funCode + "_basepanel]");
                    var baseGrid = basePanel.down("basegrid[itemId=" + funCode + "_basegrid]");
                    baseForm.hide();
                    baseGrid.show();
                    //执行回调函数
                    if (btn.callback) {
                        btn.callback();
                    }
                }
            }
        }
        Ext.apply(self.ctr, btnCtr);
    }
});