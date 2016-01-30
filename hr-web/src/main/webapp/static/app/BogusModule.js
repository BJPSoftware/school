/*!
 * Ext JS Library
 * Copyright(c) 2006-2014 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */
Ext.define('Hr.BogusModule', {
    extend: 'Ext.ux.desktop.Module',

    init: function() {
        this.launcher = {
            text: ' ' ,
            iconCls: 'bogus',
            handler: this.createWindow,
            scope: this,
            windowId: ''
        }
    },

    createWindow: function(src) {
        var me = src;
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(me.windowId);
        if (!win) {
            win = desktop.createWindow({
                id: me.windowId,
                title: me.text,
                width: 1024,
                height: 768,
                iconCls: me.iconCls,
                animCollapse: false,
                constrainHeader: true,
                layout: 'fit',
                items:[
                     Ext.create(me.url)
                ]
            });
        }
        win.show();
        return win;
    }
});