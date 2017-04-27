<%@page import="com.xietong.software.sdtw.db.ChuangKu"%>
<%@page import="com.xietong.software.sdtw.db.ChuangkuDeclare"%>
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
int proid=ParamUtils.getIntParameter(request, "Ckid",-1);
ChuangKu  ck= new ChuangKu ();
if(proid!=-1){

ck=ck.getById(proid);
}
%>
<table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>创新创业>>山大创库>><%=ck.getCk1() %>申请列表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr >

  <td  height="35px" align="right">
     <%
   
  String timeend= ck.getAddTime();
  java.util. Date time=Tool.stringToDate(timeend);
  java.util. Date now =new java.util. Date();
  if((time.getTime()+86400000)<=now.getTime()){
	  %>  
	 <font color="red"> 活动日期:<%=Tool.stringOfDate(ck.getCk2())+"~" +timeend%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
	    <a href="#"  >报名截止</a>
	<% 
  }else{
   %>
         <a href="innovation-chuangku-declare.jsp?chuangkuid=<%=proid%>">添加</a>
         <%} %>
         
        <a href="innovation-chuangku-list.jsp"  >返回</a> 
   
  </td>
</tr>
</table>

<table class="content-table">

<tr height="35">
  <th width="5%">序号</th>
   <th width="20%">创库名称</th>
  <th width="20%">作品名称</th>
 
  <th width="17%">项目分类</th>
  <th width="17%">项目分组</th>

  
  
  
  <th width="8%">学校审核</th>
  <th colspan="3">操作</th>
</tr>
<%




Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);

Map zhongleiOptions=CEditConst.getCkProjectTypeMap(userInfo);
Map chuangyefenzuOptions=CEditConst.getCkProjectGroupMap(userInfo);
Map checkmaps=CEditConst.getAuditMap(userInfo);
System.out.println(checkmaps);
String istr="",production_name="",academy="",cd2="",cd3="",detailhref="",cd4="",cd5="",chuangku="";
int biaohao=1;
String namehref="";
ChuangkuDeclare ic= new ChuangkuDeclare();
List cdt1= new ArrayList();
List list1= new ArrayList();
if(proid>-1){
	cdt1.add("ckid ="+proid);
}

cdt1.add("addaccount ="+sno);
cdt1.add("order by id desc");
list1=ic.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
		
		ic=(ChuangkuDeclare)list1.get(i);
		if(ck!=null){
			chuangku=ck.getCk1();
		}
		 namehref="<a href='innovation-chuangku-details.jsp?id="+ck.getId()+"'>"+ck.getCk1()+"</a>";
		biaohao+=i;
		detailhref="<a href='innovation-chuangku-declaredetail.jsp?Id="+ic.getId()+"'>"+ic.getCd1()+"</a>";
		if(ic.getAcademy()!=""){
			academy=(String)xynamemaps.get(ic.getAcademy());
		
		}
		if(ic.getCd2()!=""){
			cd2=(String)zhongleiOptions.get(ic.getCd2());
			}
			if(ic.getCd3()!=""){
			cd3=(String)chuangyefenzuOptions.get(ic.getCd3()+"");
			}
		cd4=(String)checkmaps.get(ic.getCheckFlag()+"");
		
		cd5="<a href='ChuangkuDeclareAction.jsp?cmd=delete&&Id="+ic.getId()+"'>删除"+"</a>";
		if(ic.getCheckFlag()==1){
			cd5=""	;
		}
		
%>
<tr>
  <td ><%=biaohao%>&nbsp;</td>
  <td><%=namehref%></td>
  <td ><%=detailhref%></td>   
 <td ><%=cd2%></td>
 <td ><%=cd3%></td>
 <td ><%=cd4%></td>
  <td colspan="2" ><%=cd5%></td>
  
  <td >&nbsp;</td>


</tr>
<%}} %>
<tr height="50">
  <td  style="background-color:#F7FBFF" width="100%" colspan="12" align="left">
    【说明】列表中列出您作为负责人参与的山大创库作品列表，已经通过审核的，不允许删除。
  </td>
</tr>
<form name="mygo" method="post" action="innovation-competition-list.jsp" target="_self">
<%-- <%@ include file="../pubpro/pagebottom-changepage.jsp" %> --%>
</form>

</table>
</body>
</html>