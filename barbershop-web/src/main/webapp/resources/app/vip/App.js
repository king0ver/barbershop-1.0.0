Ext.define("VIP.App",{
	extend: 'Ext.ux.desktop.Module',
	
	id : 'VIP-window',
	title : '会员管理',
	
    init : function(){
        this.launcher = {
            text: this.title,
            iconCls:'bogus',
            handler : this.createWindow,
            scope: this,
        };
    },
    
    createWindow : function(){
    	var desktop = this.app.getDesktop();
    	var win = desktop.getWindow(this.id);
    	
    	if(!win){
    		win = this.launchVip(desktop);
    	}
    	
    	win.show();
    	return win;
    },
    
    launchVip : function(desktop){
    	    	
    	var win = desktop.createWindow({
    				id: 'VIP-window',
                    title:'Grid Window',
                    width:800,
                    height:600,
                    iconCls: '会员管理',
                    animCollapse:false,
                    constrainHeader:true,
                    layout: 'fit',
                    items :[
                       {
                    	   xtype : 'VIP.view.VipList'
                       }
                    ]
    			});
    	
    	win.show();
    	
    	return win;
    }
	
});