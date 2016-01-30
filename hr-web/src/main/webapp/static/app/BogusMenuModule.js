/*!
 * Ext JS Library
 * Copyright(c) 2006-2014 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('Hr.BogusMenuModule', {
    extend: 'Hr.BogusModule',

    init: function() {

        this.launcher = {
            text: '系统管理',
            iconCls: 'bogus',
            handler: function() {
                return false;
            },
            menu: {
                items: []
            }
        };
        this.launcher.menu.items.push({
            text: '用户管理 ',
            iconCls: 'bogus',
            handler: this.createWindow,
            scope: this,
            windowId: "sysuser",
            url:'Hr.system.SysUser'
        });
        this.launcher.menu.items.push({
            text: '角色管理 ',
            iconCls: 'bogus',
            handler: this.createWindow,
            scope: this,
            windowId: "sysrole",
            url:'Hr.system.SysRole'
        }); 
        this.launcher.menu.items.push({
            text: '菜单管理 ',
            iconCls: 'bogus',
            handler: this.createWindow,
            scope: this,
            windowId: "sysmenu"
        }); 
        this.launcher.menu.items.push({
            text: '角色权限 ',
            iconCls: 'bogus',
            handler: this.createWindow,
            scope: this,
            windowId: "rolemenu"
        });
    }
});