/*!
 * Ext JS Library
 * Copyright(c) 2006-2014 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('Hr.Settings', {
    extend: 'Ext.window.Window',

    uses: [
        'Ext.tree.Panel',
        'Ext.tree.View',
        'Ext.form.field.Checkbox',
        'Ext.layout.container.Anchor',
        'Ext.layout.container.Border',

        'Ext.ux.desktop.Wallpaper',

        'Hr.model.Wallpaper'
    ],

    layout: 'anchor',
    title: '桌面背景',
    modal: true,
    width: 640,
    height: 480,
    border: false,

    initComponent: function() {
        var me = this;

        me.selected = me.desktop.getWallpaper();
        me.stretch = me.desktop.wallpaper.stretch;

        me.preview = Ext.create('widget.wallpaper');
        me.preview.setWallpaper(me.selected);
        me.tree = me.createTree();

        me.buttons = [{
            text: '确定',
            handler: me.onOK,
            scope: me
        }, {
            text: '取消',
            handler: me.close,
            scope: me
        }];

        me.items = [{
            anchor: '0 -30',
            border: false,
            layout: 'border',
            items: [
                me.tree, {
                    xtype: 'panel',
                    title: '预览',
                    region: 'center',
                    layout: 'fit',
                    items: [me.preview]
                }
            ]
        }, {
            xtype: 'checkbox',
            boxLabel: '平铺',
            checked: me.stretch,
            listeners: {
                change: function(comp) {
                    me.stretch = comp.checked;
                }
            }
        }];

        me.callParent();
    },

    createTree: function() {
        var me = this;

        function child(img) {
            return {
                img: img,
                text: me.getTextOfWallpaper(img),
                iconCls: '',
                leaf: true
            };
        }

        var tree = new Ext.tree.Panel({
            title: '图片',
            rootVisible: false,
            lines: false,
            scrollable: true,
            width: 150,
            region: 'west',
            split: true,
            minWidth: 100,
            listeners: {
                afterrender: {
                    fn: this.setInitialSelection,
                    delay: 100
                },
                select: this.onSelect,
                scope: this
            },
            store: new Ext.data.TreeStore({
                model: 'Hr.model.Wallpaper',
                root: {
                    text: 'Wallpaper',
                    expanded: true,
                    children: [{
                            text: "无",
                            iconCls: 'asterisk_orange',
                            leaf: true
                        }, child('blue.jpg'),
                        child('blue-curtain.jpg'),
                        child('fields-of-peace.jpg'),
                        child('fresh-morning.jpg'),
                        child('colorado-farm.jpg'),
                        child('blue-swirl.jpg'),
                        child('desk.jpg'),
                        child('desktop.jpg'),
                        child('desktop2.jpg'),
                        child('sky.jpg'),
                        child('19201080.jpg'),
                        child('FGHJ_079020.jpg'),
                        child('cloud.jpg')
                    ]
                }
            })
        });

        return tree;
    },

    getTextOfWallpaper: function(path) {
        var text = path,
            slash = path.lastIndexOf('/');
        if (slash >= 0) {
            text = text.substring(slash + 1);
        }
        var dot = text.lastIndexOf('.');
        text = Ext.String.capitalize(text.substring(0, dot));
        text = text.replace(/[-]/g, ' ');
        return text;
    },

    onOK: function() {
        var me = this;
        if (me.selected) {
            me.desktop.setWallpaper(me.selected, me.stretch);
        }
        me.destroy();
    },

    onSelect: function(tree, record) {
        var me = this;

        if (record.data.img) {
            me.selected = '../static/resources/images/wallpapers/' + record.data.img;
        } else {
            me.selected = Ext.BLANK_IMAGE_URL;
        }

        me.preview.setWallpaper(me.selected);
    },

    setInitialSelection: function() {
        var s = this.desktop.getWallpaper();
        if (s) {
            var path = '/Wallpaper/' + this.getTextOfWallpaper(s);
            this.tree.selectPath(path, 'text');
        }
    }
});