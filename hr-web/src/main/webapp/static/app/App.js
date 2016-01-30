/*!
 * Ext JS Library
 * Copyright(c) 2006-2014 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('Hr.App', {
    extend: 'Ext.ux.desktop.App',
    requires: [
        'Ext.window.MessageBox',
        'Ext.form.Panel',
        'Ext.ux.desktop.ShortcutModel',

        // 'Hr.SystemStatus',
        // 'Hr.VideoWindow',
        // 'Hr.GridWindow',
        // 'Hr.TabWindow',
        // 'Hr.AccordionWindow',
        // 'Hr.Notepad',
        'Hr.OrganModule',
        'Hr.BogusMenuModule',
        'Hr.BogusModule',
        // 'Hr.ModuleInstance',
        'Hr.system.SysUser',
        'Hr.system.SysRole',

        //        'Desktop.Blockalanche',
        'Hr.Settings'
    ],

    init: function() {
        // custom logic before getXYZ methods get called...

        this.callParent();
        Ext.QuickTips.init();  
        // now ready...
    },

    getModules: function() {
        return [
            new Hr.OrganModule(),
            //new Desktop.Blockalanche(),
            // new Hr.SystemStatus(),
            //new Hr.GridWindow(),
            // new Hr.TabWindow(),
            // new Hr.AccordionWindow(),
            // new Hr.Notepad(),
            new Hr.BogusMenuModule(),
            //new Hr.BogusModule(),
            //new Hr.system.SysUser()
        ];
    },

    getDesktopConfig: function() {
        var me = this,
            ret = me.callParent();

        return Ext.apply(ret, {
            //cls: 'ux-desktop-black',

            contextMenuItems: [{
                text: '桌面背景',
                handler: me.onSettings,
                scope: me
            }],

            shortcuts: Ext.create('Ext.data.Store', {
                model: 'Ext.ux.desktop.ShortcutModel',
                data: [{
                    name: '用户管理',
                    iconCls: 'grid-shortcut',
                    module: 'grid-win'
                }, {
                    name: 'Accordion Window',
                    iconCls: 'accordion-shortcut',
                    module: 'acc-win'
                }, {
                    name: 'Notepad',
                    iconCls: 'notepad-shortcut',
                    module: 'notepad'
                }, {
                    name: 'System Status',
                    iconCls: 'cpu-shortcut',
                    module: 'systemstatus'
                }]
            }),

            wallpaper: '../static/resources/images/wallpapers/FGHJ_079020.jpg',
            wallpaperStretch: false
        });
    },

    // config for the start menu
    getStartConfig: function() {
        var me = this,
            ret = me.callParent();

        return Ext.apply(ret, {
            title: '管理员',
            iconCls: 'user',
            height: 300,
            toolConfig: {
                width: 100,
                items: [{
                        text: '背景',
                        iconCls: 'settings',
                        handler: me.onSettings,
                        scope: me
                    },
                    '-', {
                        text: '退出',
                        iconCls: 'logout',
                        handler: me.onLogout,
                        scope: me
                    }
                ]
            }
        });
    },

    getTaskbarConfig: function() {
        var ret = this.callParent();

        return Ext.apply(ret, {
            quickStart: [{
                name: '显示桌面',
                iconCls: 'mymac',
                handler: function() {
                    this.app.getDesktop().showDesktop();
                }
            }, {
                name: '规则排列窗口',
                iconCls: 'pl',
                handler: function() {
                    this.app.getDesktop().cascadeWindows();
                }
            }, {
                name: '关闭所有窗体',
                iconCls: 'Close',
                handler: function() {
                    this.app.getDesktop().closeAllWinows();
                }
            }],
            trayItems: [{
                xtype: 'trayclock',
                flex: 1
            }]
        });
    },

    onLogout: function() {
        Ext.Msg.confirm('退出', '你确定退出系统吗?', function(btn) {
            if (btn == 'yes') {
                window.opener = null;
                window.open(' ', '_self', ' ');
                window.close();
            }
        });
    },

    onSettings: function() {
        var dlg = new Hr.Settings({
            desktop: this.desktop
        });
        dlg.show();
    }
});