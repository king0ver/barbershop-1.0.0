Ext.define("LOGIN.controller.LoginController",{
	extend : 'Ext.app.Controller',
	views : ['LoginPanel'],
	
	init : function(){
		this.control({
			'loginPanel button[id=login]' : {
				click : function(button){	
					var myForm = button.ownerCt.ownerCt;
					var data = myForm.getValues();
					
					Ext.Ajax.request({
						url : '../user/login',
						method : 'POST',
						params : data,
						success:function(response){
							var data = Ext.JSON.decode(response.responseText);
							if(data.scode == '-1'){
								Ext.MessageBox.alert("提示","密码错误!");
							}else{
								window.location.href = "/barbershop/user/index";
							}
						}
					});					
				}				
			}
		});
	},

});
