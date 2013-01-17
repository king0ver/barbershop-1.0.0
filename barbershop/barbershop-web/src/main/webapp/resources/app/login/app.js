Ext.onReady(function(){
	Ext.QuickTips.init();
	
	Ext.Loader.setConfig({
	   enabled:true
    });
	
	Ext.application({
		name : 'LOGIN',
		appFolder : '../resources/app/login',
		
		launch : function(){
			Ext.create("Ext.container.Viewport",{
				layout : 'auto',
				frame: true,
				baseCls : 'desktop_000',
				items : [{
					xtype : 'loginPanel'
				}],
			});
		},
		
		controllers : [
		   'LoginController'
		]
	});
	
	
	
});