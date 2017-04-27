<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
//文件名字：logoff.jsp
//功能说明：注销登录,然后返回登录页面.    
//关键算法说明：无
//其他：        无
UserInfo ui = Tool.getUserInfo(request);
if (ui != null) {
    ui.removeCookie(response);
}
session.removeAttribute("UserInfo");
%>
<script type="text/javascript" src="<%=HeadConst.apache_url %>/js/jquery-ui-1.10.2/jquery-1.9.1.js"></script>
<script language=javascript>
  window.opener = null;
  window.location="<%=HeadConst.apache_url%>/index.jsp";
</script>
