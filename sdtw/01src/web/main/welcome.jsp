<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo==null){
	out.print("<meta http-equiv='refresh' content='0;url="+ HeadConst.root_url_path + "/main/logon.jsp'>");
    return;
} 
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="images/skin/<%=userInfo.getSkinId()%>/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script language="JavaScript" type="text/javascript" src="js/tab.js"></script>
<script language="JavaScript" type="text/javascript" src="js/tab1.js"></script>
<script src="js/index.js" type="text/javascript"></script>
<script>
flag = getCookie("refreshFlag");
setTimeout(function(){
	if($.browser.version == "7.0" && flag == ""){
    	location.reload();
    	setCookie("refreshFlag","1" );
    }
},1000);
</script>
<style>
.right{ position:relative; float:right; width:1010px; height:auto; overflow:auto; border:0px; margin:0px;padding:0px ;}
.welcome_gzgl{ position:relative; float:right; width:1010px; height:400px; overflow:auto; border:0px; margin:0px;padding:0px; background-image:url(images/welcome.png); background-repeat:no-repeat;}
.welcome_text{ position:relative; float:left; margin:70px 10px 0px 10px; width:300px; height:300px; overflow: hidden; background-color:#FFFFFF; background-image:url(images/welcome_text.jpg); background-repeat:no-repeat;}
.welcome_text ul{ width:260px; height:200px; margin:20px; margin-top:100px; border:0px; padding:0px;}
.welcome_text ul li{ width:260px; margin:0px; border:0px; height:30px; line-height:30px; list-style:none; overflow:hidden; background-image:url(/images/dot.jpg); background-repeat: no-repeat; background-position:0px 15px; text-indent:14px; border-bottom:1px solid #efefef;}
.welcome_back{ position:relative; float:right; margin:20px 10px 0px 10px; width:100px; height:30px; overflow: hidden;}
</style>
</head>

<body>

		    <table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td align="center"><img src="images/welcome.png" /></td>
      </tr>
    </table>
</body>
</html>
