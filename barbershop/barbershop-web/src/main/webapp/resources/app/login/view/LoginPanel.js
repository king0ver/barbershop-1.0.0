Ext.define("LOGIN.view.LoginPanel",{
	extend : 'Ext.form.Panel',
	alias: 'widget.loginPanel',
	title : '登录',
    defaultType : 'textfield',
	width : 450,
	height : 200,
	frame : true,
	margin : '150 450',
	bodyPadding : '30 40',
	defaults : {
	   allowBlank : false,
	   selectOnFocus : true,
	   labelWidth : 50,
	   height : 30
	},
	items : [
	   {
		   fieldLabel : '用户名',
		   name : 'userName',
		   width : 230,
		   blankText  :'用户名不能为空',
		   id : 'userName',
		   validateOnChange : false,
		   validator : function(inputValue){
			   var result = null;
			   if(inputValue.length > 0){	
					Ext.Ajax.request({
						url : '../user/existed/'+inputValue,
						method : 'POST',
						async : false,
						success:function(response){
							var data = Ext.JSON.decode(response.responseText);
							if(data.scode == '-1'){
								result = "用户不存在";
							}else{
								result = true;
							}
						}
					});
				}
			   return result;
		   }
	   },{
		   fieldLabel : '密码',
		   inputType : 'password',
		   name : 'password',
		   width : 230,
		   blankText :'密码不能为空'
	   }],
	 buttons : [{
     	 id : 'login',	 
		 text : '登录',
		 height : 30 
   }]
});

