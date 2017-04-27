<%@page import="com.xietong.software.sdtw.db.InnovationCompetitionProject"%>
<%@page import="com.xietong.software.sdtw.db.InnovationCompetition"%>
<%@page import="com.xietong.software.sdtw.db.InnovationCompetitionMembers"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page pageEncoding="utf-8" %>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.base.Power"%>
<%@ page import="java.sql.*" %>



<%!
ResultSet rs=null;
int rowscount;
int numsperpage=10,pagecount,pagenum,gopage,i,j;
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script> 
<script src="../js/jquery.min.js"></script> 
<script src="../js/personlistorder.js"></script> 
</head>

<body>
<%
String strposition = "创新创业管理>>竞赛管理";
String strfunction = "竞赛管理列表";
String strhelpwords = "创新创业管理之竞赛管理，申请者（队长）可以进行修改，其他团队成员只能进行查看。";
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userInfo != null) {
		userInfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode stu= userInfo.getUserCode();
int sno=stu.getId();
InnovationCompetitionMembers icm= new InnovationCompetitionMembers ();
int proid=ParamUtils.getIntParameter(request, "proid",-1);
List cdt= new ArrayList();
List list= new ArrayList();
cdt.add("sno="+sno);
list=icm.query(cdt);
String sid ="(";
if(list.size()>0){
	for(int i=0;i<list.size();i++){
		icm=(InnovationCompetitionMembers)list.get(i);
		if(i==0){
			sid+=icm.getProductionId();
		}else{
			sid+=","+icm.getProductionId();
		}
	}
	sid+=")";
}
System.out.println(sid);
InnovationCompetitionProject  icp= new InnovationCompetitionProject();
if(proid!=-1){
	   icp=icp.getById(proid);}

%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>>创业竞赛>><%=icp.getProjectName()%>申请列表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr >
  <td  height="35px" align="right">
   <%
   
  String timeend= icp.getTimeEnd();
  java.util. Date time=Tool.stringToDate(timeend);
  java.util. Date now =new java.util. Date();
  if((time.getTime()+86400000)<=now.getTime()){
	  %>  
	 <font color="red"> 活动日期:<%=icp.getTimeStart()+"~" +timeend%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
	    <a href="#"  >报名截止</a>
	<% 
  }else{
   %>
         <a href="innovation-competition-add.jsp?proid=<%=proid%>">添加</a>
         <%} %>
         
        <a href="innovation-competition-project-list.jsp"  >返回</a>
    
  </td>
</tr>
</table>

<table class="content-table">

<tr height="35">
  <th width="5%">序号</th>
   <th width="20%">竞赛项目名称</th>
  <th width="20%">作品名称</th>
  <th width="10%">学院</th>
  <th width="13%">申报者</th>
  <th width="10%">作品类别</th>
  <th width="8%">学院审核</th>
  <th width="8%">学校审核</th>
  <th colspan="3">操作</th>
</tr>
<%




Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);
Map usercnmamemaps=CEditConst.getUserCnNameMap(userInfo);
Map production_typemaps=CEditConst.getProductionTypeMap(userInfo);
Map checkmaps=CEditConst.getAuditMap(userInfo);
System.out.println(checkmaps);
String jingsai="";
String istr="",production_name="",academy="",declarer="",production_type="",leaderid="",detailhref="",modihref="",delehref="",applyedit="",submithref="", xystate="", twstate="";
int id, checkflag,studentstate;
int biaohao=1;
InnovationCompetition ic= new InnovationCompetition();
List cdt1= new ArrayList();
List list1= new ArrayList();

if(proid>-1){
	cdt1.add("projectname ="+proid);
}
cdt1.add(" addperson="+stu.getId());
cdt1.add("order by id desc");
list1=ic.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		jingsai="<a href='innovation-competition-project-detail.jsp?id="+icp.getId()+"'>"+icp.getProjectName()+"</a>";

		delehref="";modihref="";delehref="";
		ic=(InnovationCompetition)list1.get(i);
		biaohao+=i;
		detailhref="<a href='innovation-competition-detail.jsp?Id="+ic.getId()+"'>"+ic.getProductionName()+"</a>";
		if(ic.getAcademy()!=""){
			academy=(String)xynamemaps.get(ic.getAcademy());
		
		}
		
		declarer=(String)usercnmamemaps.get(ic.getLeaderId());
		production_type=(String)production_typemaps.get(ic.getProductionType());
		xystate=(String)checkmaps.get(ic.getCheckFlagXy()+"");
		twstate=(String)checkmaps.get(ic.getCheckFlagTw()+"");
		if(ic.getLeaderId().equals(stu.getId()+"")){
			modihref="";
			delehref="<a href='InnovationCompetitionAction.jsp?cmd=delete&Id="+ic.getId()+"'>"+"删除</a>";
		submithref="";
		}
		if(ic.getCheckFlagTw()==1||ic.getCheckFlagXy()==1){
			modihref="";
			delehref="";
			submithref="";
		}
%>
<tr>
  <td th><%=biaohao%>&nbsp;</td>
  <td ><%=jingsai%></td>   
  <td ><%=detailhref%></td>   
  <td  align="left"><%=academy%></td>
  <td th><%=declarer%>&nbsp;</td> 
  <td th><%=production_type%>&nbsp;</td> 
  <td th><%=xystate %>&nbsp;</td>
  <td th><%=twstate %>&nbsp;</td>


  <td th><%=modihref %>&nbsp;</td>
  <td th><%=delehref %>&nbsp;</td> 
  <td th><%=submithref%></td> 

</tr>
<%}} %>
<tr height="50">
  <td  style="background-color:#F7FBFF" width="100%" colspan="12" align="left">
    【说明】列表中列出您作为负责人或者团队成员参与的创新创业竞赛，作为负责人的竞赛，您应负责对竞赛进行维护。对于未审核的竞赛，可以进行修改、删除操作；其他情况为审核中，不允许操作。
  </td>
</tr>
<form name="mygo" method="post" action="innovation-competition-list.jsp" target="_self">
<%-- <%@ include file="../pubpro/pagebottom-changepage.jsp" %> --%>
</form>

</table>
</body>
</html>