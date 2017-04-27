<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.util.Tool"%><script>
var GBasePath = "<%=HeadConst.root_url_path%>";
var GResPath = "<%=HeadConst.apache_url%>/main";
<%{%>var GImagePath = "<%=HeadConst.apache_url%>/main/images/skin/<%UserInfo ui = Tool.getUserInfo(request); if (ui == null) out.print("blue"); else out.print(ui.getSkinId());%>";<%}%>

</script>
