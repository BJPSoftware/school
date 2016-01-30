/*!
 * Ext JS Library
 * Copyright(c) 2006-2014 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

/**
 * @class Ext.ux.desktop.TaskBar
 * @extends Ext.toolbar.Toolbar
 */
Ext.define('Ext.ux.desktop.TaskBar', {
    // This must be a toolbar. we rely on acquired toolbar classes and inherited toolbar methods for our
    // child items to instantiate and render correctly.
    extend: 'Ext.toolbar.Toolbar',

    requires: [
        'Ext.button.Button',
        'Ext.resizer.Splitter',
        'Ext.menu.Menu',

        'Ext.ux.desktop.StartMenu'
    ],

    alias: 'widget.taskbar',

    cls: 'ux-taskbar',

    /**
     * @cfg {String} startBtnText
     * The text for the Start Button.
     */
    startBtnText: '开始',

    initComponent: function () {
        var me = this;
        
        me.startMenu = new Ext.ux.desktop.StartMenu(me.startConfig);

        me.quickStart = new Ext.toolbar.Toolbar(me.getQuickStart());

        me.windowBar = new Ext.toolbar.Toolbar(me.getWindowBarConfig());

        me.tray = new Ext.toolbar.Toolbar(me.getTrayConfig());

        me.items = [
            {
                xtype: 'button',
                cls: 'ux-start-button',
                iconCls: 'ux-start-button-icon',
                menu: me.startMenu,
                menuAlign: 'bl-tl',
                text: me.startBtnText
            },
            me.quickStart,
            {
                xtype: 'splitter', html: '&#160;',
                height: 14, width: 2, // TODO - there should be a CSS way here
                cls: 'x-toolbar-separator x-toolbar-separator-horizontal'
            },
            me.windowBar,
            '-',
            me.tray
        ];

        me.callParent();
    },

    afterLayout: function () {
        var me = this;
        me.callParent();
        me.windowBar.el.on('contextmenu', me.onButtonContextMenu, me);
    },

			/**
			 * This method returns the configuration object for the Quick Start
			 * toolbar. A derived class can override this method, call the base
			 * version to build the config and then modify the returned object
			 * before returning it.
			 */
			getQuickStart : function() {
				var me = this, ret = {
					minWidth : 120,
					width : 120,
					items : [],
					enableOverflow : true
				};

        Ext.each(this.quickStart, function (item) {
            ret.items.push({
                tooltip: { text: item.name, align: 'bl-tl' },
                //tooltip: item.name,
                overflowText: item.name,
                iconCls: item.iconCls,
                module: item.module,
                handler: me.onQuickStartClick,
                scope: me
            });
        });

        return ret;
    },

			/**
			 * This method returns the configuration object for the Tray
			 * toolbar. A derived class can override this method, call the base
			 * version to build the config and then modify the returned object
			 * before returning it.
			 */
			getTrayConfig : function() {
				var ret = {
					width : 90,

					items : this.trayItems
				};
				delete this.trayItems;
				return ret;
			},

    getWindowBarConfig: function () {
        return {
            flex: 1,
            cls: 'ux-desktop-windowbar',
            items: [ '&#160;' ],
            layout: { overflowHandler: 'Scroller' }
        };
    },

    getWindowBtnFromEl: function (el) {
        var c = this.windowBar.getChildByElement(el);
        return c || null;
    },

			onQuickStartClick : function(btn) {
				var module = this.app.getModule(btn.module);
				if (module) {
					module.createWindow();
				}
			},

			onButtonContextMenu : function(e) {
				var me = this, t = e.getTarget(), btn = me
						.getWindowBtnFromEl(t);
				if (btn) {
					e.stopEvent();
					me.windowMenu.theWin = btn.win;
					me.windowMenu.showBy(t);
				}
			},

			onWindowBtnClick : function(btn) {
				var win = btn.win;

				if (win.minimized || win.hidden) {
					win.show();
				} else if (win.active) {
					win.minimize();
				} else {
					win.toFront();
				}
			},

			addTaskButton : function(win) {
				var config = {
					iconCls : win.largeIconCls,
					enableToggle : true,
					scale : 'medium',
					toggleGroup : 'all',
					width : 150,
					text : Ext.util.Format.ellipsis(win.title, 20),
					listeners : {
						click : this.onWindowBtnClick,
						scope : this
					},
					win : win
				};

        var cmp = this.windowBar.add(config);
        cmp.toggle(true);
        return cmp;
    },

    removeTaskButton: function (btn) {
        var found, me = this;
        me.windowBar.items.each(function (item) {
            if (item === btn) {
                found = item;
            }
            return !found;
        });
        if (found) {
            me.windowBar.remove(found);
        }
        return found;
    },

    setActiveButton: function(btn) {
        if (btn) {
            btn.toggle(true);
        } else {
            this.windowBar.items.each(function (item) {
                if (item.isButton) {
                    item.toggle(false);
                }
            });
        }
    }
});

/**
 * @class Ext.ux.desktop.TrayClock
 * @extends Ext.toolbar.TextItem
 * This class displays a clock on the toolbar.
 */
Ext.define('Ext.ux.desktop.TrayClock', {
    extend: 'Ext.toolbar.TextItem',

			alias : 'widget.trayclock',
			tooltip : {
				text : '时钟',
				align : 'bl-tl'
			},
			timeFormat : 'H:i',
			iconCls : 'clock',
			GetWeek : function() {
				var d, day, x
				var x = new Array("星期日", "星期一", "星期二");
				var x = x.concat("星期三", "星期四", "星期五");
				var x = x.concat("星期六");
				d = new Date();
				day = d.getDay();
				return (x[day]);
			},
			initComponent : function() {
				var me = this;
				me.callParent();
			},

    afterRender: function () {
        var me = this;
        Ext.Function.defer(me.updateTime, 100, me);
        me.callParent();
    },

    onDestroy: function () {
        var me = this;

        if (me.timer) {
            window.clearTimeout(me.timer);
            me.timer = null;
        }

        me.callParent();
    },

			updateTime : function() {

				var me = this, time = me.GetWeek() + '&nbsp;'
						+ Ext.Date.format(new Date(), me.timeFormat), text = time
				if (me.lastText != text) {
					me.setText(text);
					me.lastText = text;
				}
				me.timer = Ext.Function.defer(me.updateTime, 1000, me);
			}
		});
