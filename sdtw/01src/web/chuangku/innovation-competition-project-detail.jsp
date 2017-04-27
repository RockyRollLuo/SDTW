<%@page import="com.xietong.software.sdtw.db.InnovationCompetitionProject"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %> 
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>
<%!
ResultSet rs = null;
//保存数据使用的分隔符
String f1="\10";
String f2="\20";
%>
<%
//接收客户端提交的数据

String projectname= "",  projectid= "",  projectleader= "",leaderphone= "", projectunit="", timestart="", timeend="", projectdetail="", remark = "", addfilelist="";

%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
</head>

<body>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
String strposition = "创新创业列表>>创业项目管理>>";
String strfunction = "创业项目详细信息";
String strhelpwords = "创业项目详细信息。";
int id=ParamUtils.getIntParameter(request, "id", -1);
InnovationCompetitionProject  icp = new InnovationCompetitionProject ();
icp= icp.getById(id);
projectname=icp.getProjectName();
projectid=icp.getProjectId();
projectleader=icp.getProjectLeader();
leaderphone=icp.getLeaderPhone();
projectunit=icp.getProjectUnit();
timeend=icp.getTimeEnd();
timestart=icp.getTimeStart();
projectdetail=icp.getProjectDetail();
remark=icp.getRemark();
%>

 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>创业竞赛>><%=icp.getProjectName() %>
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>
<table class="command-table">
<tr>
<td><a href="innovation-competition-project-list.jsp">返回</a></td>
</tr>
</table>


<table class="content-table">
<tr height="35">
	<th colspan="2" align="left">创业项目详细信息</th>
</tr>
<tr height="40">
	<td  align="right" width="20%">&nbsp;项目名称：</td>
   	<td align="left"><%=projectname%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;项目编码：</td>
   	<td align="left"><%=projectid%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;负责人：</td>
   	<td align="left"><%=projectleader%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;联系方式：</td>
   	<td align="left"><%=leaderphone%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;立项单位：</td>
   	<td align="left"><%=projectunit%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;开始时间：</td>
   	<td align="left"><%=timestart%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;截止时间：</td>
   	<td align="left"><%=timeend%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;项目详情：</td>
   	<td align="left"><%=projectdetail%>&nbsp;</td>
</tr>
<tr height="40">
	<td  align="right">&nbsp;备注：</td>
   	<td align="left"><%=remark%>&nbsp;</td>
</tr>
<tr height=40>
  <td  align="right">上传附件：</td>
  <td  align="left">
<%
// 生成附件所在路径
String path = request.getContextPath(); 
path = path + "/datafile/innovation/";

if (addfilelist == null || addfilelist.equals("null"))
  addfilelist = "";
   
String[] s1,s2;
if (addfilelist.length()>0){
  s1 = addfilelist.split(f1);
  for(int k = 0; k < s1.length; k++){
    s2 = s1[k].split(f2); 
    out.print("<a href='" + path+"/"+ s2[2] + "'>" + s2[1] +"</a>");
    if (k < s1.length - 1) out.print("<br>");
  }
}else{
  out.print("　");
}%>
</tr>
<tr height="35">
  <th  width="100%" colspan="2" align="center">
    <a href="#" onclick="history.go(-1)">返回</a>
  </th>
</tr>
</table>
</body>
</html>
