<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>羞花发艺</title>
<link rel="stylesheet" type="text/css" href="extjs4/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css" href="desktop/css/desktop.css" />
<script type="text/javascript" src="extjs4/ext-all.js"></script>
<script type="text/javascript">
      Ext.Loader.setPath({
          'Ext.ux.desktop': 'desktop/js',
          MyDesktop: 'desktop'
      });
	  Ext.Loader.setConfig({
		  enabled:true
	  });

      Ext.require('MyDesktop.App');

      var myDesktopApp;
      Ext.onReady(function () {
          myDesktopApp = new MyDesktop.App();
      });
</script>
</head>
<body>

</body>
</html>