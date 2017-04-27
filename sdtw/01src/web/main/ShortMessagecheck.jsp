<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">


<script type="text/javascript">

$(function(){
	$(".ui-button-text").text('关闭');
	$('#ui-button-text').hide();
})

</script>
</head>

<body>
<%
String strposition = "系统公告管理  >> ";
String strfunction = "系统公告";
String strhelpwords= "给出了系统公告的详细信息。";
%>
<%-- <%@ include file="../pubpro/pagetop-positionandhelp.jsp" %> --%>


<table class="content-table">

<%
ShortMessage ifm= new ShortMessage();
List list = new ArrayList();
List cdt= new ArrayList();
String infId=ParamUtils.getParameter(request, "id", "");
System.out.println("duanxinxiid"+infId);
cdt.add("id="+infId);
list=ifm.query(cdt);
UserInfo userinfo=Tool.getUserInfo(request);

BaseUserCode user = new BaseUserCode();
if(userinfo == null){
		out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
		return;
}else{
	user = userinfo.getUserCode();
}
Map UserNameMap=  CEditConst.getUserCnNameMap(userinfo);
String biaoti="";
String neirong="";
String fabuyonghu="";
String fabiaoshijian="";
String ids="";
ClientAttach ca1=new ClientAttach(); ;
if(list.size()>=1){
	ifm=(ShortMessage)list.get(0);
	biaoti=ifm.getSubject();
	neirong=ifm.getRemUrl();
	
	fabuyonghu=(String)UserNameMap.get(ifm.getSendId()+"");

	ClientAttach ca = new ClientAttach();
	ids = ifm.getAttachIds();
	


%>


<tr>
     
     <td align="center" colspan="3"><font size="2" ><%=neirong %></font></td>
</tr>
<tr>
  <td width="25%" align="left"><font size="2" >  </font></td>
  <td align="left">
  <%	if(ids!=null&&ids.trim().length()>0){
		String[] idArray = Tool.split(",",ids);
		for(int i=0;i<idArray.length;i++){
		ca1= ca.getById(Tool.StrToInt(idArray[i]));
}

	 %>
<a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/>下载文件<%=ca1.getUploadName() %>
</a>
<%
  }
  } %>
  </td>
</tr>

</table>
</body>
</html>
