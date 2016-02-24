/**
 * 增加按钮的点击前点击后事件
 */
Ext.override(Ext.button.Button, {
    initComponent: function() {
        var me = this;
        if (!Ext.isEmpty(me.handler) && Ext.isString(me.handler)) {
            me.handler = eval(me.handler);
        }
        me.addEvents('beforeclick', 'clicked');
        me.callParent(arguments);
    },
    onClick: function(e) {
        var me = this;
        if (me.preventDefault || (me.disabled && me.getHref()) && e) {
            e.preventDefault();
        }
        if (e.button !== 0) {
            return;
        }
        if (!me.disabled) {
            if (me.enableToggle && (me.allowDepress !== false || !me.pressed)) {
                me.toggle();
            }
            if (me.menu && !me.hasVisibleMenu() && !me.ignoreNextClick) {
                me.showMenu();
            }
            var flag = me.fireEvent('beforeclick', me, e); //单击前
            if (flag != false) {
                me.fireEvent('click', me, e);
                if (me.handler) {
                    me.handler.call(me.scope || me, me, e);
                }
                me.onBlur();
            }
            me.fireEvent('clicked', me, e); //单击后
        }
    }
});