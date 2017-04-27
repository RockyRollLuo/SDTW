<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<%-- <script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/jquery-1.7.1.min.js"></script>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/themes/blue/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery-ui-1.8.4.custom.min.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/external/jquery.bgiframe-2.1.1.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.core.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.widget.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.tabs.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.mouse.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.button.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.draggable.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.position.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.dialog.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.accordion.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.effects.core.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.effects.blind.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.effects.explode.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jqueryui/jquery.ui.autocomplete.js"></script> --%>
		<link rel="stylesheet" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery.ui.all.css">
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/blue/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		
		<script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/jquery-ui-1.10.2/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.core.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.widget.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.tabs.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.mouse.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.button.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.draggable.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.position.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.dialog.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.accordion.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.effect.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.effect-blind.js"></script> 
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.effect-explode.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.menu.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.autocomplete.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/ui/jquery.ui.datepicker.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url%>/main/js/nyroModal-1.6.2/jquery.nyroModal-1.6.2.pack.js"></script>
        <script src="<%=HeadConst.apache_url %>/main/js/json2.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/jquery-ui-1.10.2/ui/jquery.ui.progressbar.js" type="text/javascript"></script>
        <%-- <script type="text/javascript" src="<%=HeadConst.apache_url %>/main/js/artDialog/artDialog.min.js"></script>
		<script type="text/javascript" src="<%=HeadConst.apache_url %>/main/js/artDialog/artDialog.plugins.min.js"></script>
		<link href="<%=HeadConst.apache_url%>/main/js/artDialog/skins/black.css" rel="stylesheet" />
		<script>
		(function (d) {
		    d['okValue'] = '确定';
		    d['cancelValue'] = '取消';
		    d['title'] = '消息';
		    // [more..]
		})(art.dialog.defaults); --%>
		</script>		
		