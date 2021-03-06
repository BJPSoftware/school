/**
 * 表格控制器
 */
Ext.define("core.app.contoller.GridController", {
    extend: "Ext.app.Controller",
    initGrid: function() {
        var self = this;
        var gridCtr = {
            "basegrid": {
                /**
                 * 表格的render事件
                 */
                render: function(grid) {
                    var basePanel = grid.up("basepanel");
                    var funCode = basePanel.funCode;
                    grid.funCode = funCode;
                    grid.itemId = funCode + "_basegrid";
                },
                /**
                 * 表格的双击事件
                 */
                itemdblclick: function(grid, record, item, index, e, eOpts) {
                    var basePanel = grid.up("basepanel");
                    var funCode = basePanel.funCode;
                    var baseForm = basePanel.down("baseform[itemId=" + funCode + "_baseform]");
                    var baseGrid = basePanel.down("basegrid[itemId=" + funCode + "_basegrid]");
                    if (record.data.isDelete == "0") {
                        // 表单赋值
                        self.setFormValue(baseForm.getForm(), record.data);
                        baseGrid.hide();
                        baseForm.show();
                    } else {
                        self.msgbox("当前记录为删除状态，不能再修改");
                    }
                },
                /**
                 * 表格单击事件
                 */
                itemclick: function(grid, record, item, index, e, eOpts) {
                    var basePanel = grid.up("basepanel");
                    var funCode = basePanel.funCode;
                    var baseGrid = basePanel.down("basegrid[itemId=" + funCode + "_basegrid]");
                    var records = baseGrid.getSelectionModel().getSelection();
                    var btn = baseGrid.down("button[ref=gridEdit]");
                    if (!btn) {
                        return;
                    }
                    if (records.length == 1) {
                        btn.setDisabled(false);
                    } else {
                        btn.setDisabled(true);
                    }
                }
            }
        }
        Ext.apply(self.ctr, gridCtr);
    }
});