<%@page import="com.xietong.software.sdtw.db.StudentUnionMember"%>
<%@page import="com.xietong.software.sdtw.db.StudentUnionDept"%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@page import="com.xietong.software.util.*"%>
<%@page import="com.xietong.software.common.*"%>
<%@page import="java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>
<style type="text/css">
body,html{
	margin:0;
	padding:0;
}
.minfo{
	display:inline-block;
	width:60px;
}
.xinfo{
	display:inline-block;
	width:120px;
}


</style>

<%
UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
String space4="&nbsp;&nbsp;&nbsp;&nbsp;";
UserInfo userInfo = Tool.getUserInfo(request);
Map cnnamemap=CEditConst.getUserCnNameMap(userInfo);

String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};

String deptname="",principal="",contact="",listorder="",deptprofile="",functionstr="",addfilelist = "",addtime="",addaccount="";
int  id =ParamUtils.getIntParameter(request, "Id", 1);
StudentUnionDept  sud=new StudentUnionDept();
List list= new ArrayList();
List cdt= new ArrayList();
cdt.add("id="+id);
list =sud.query(cdt);
if(list.size()>0){
	sud=(StudentUnionDept)list.get(0);
	deptname=sud.getDeptName();
	if(sud.getAddaccount()!=""){
	principal=(String)cnnamemap.get(sud.getAddaccount()+"");}
	contact=sud.getContact();
	deptprofile=sud.getDeptprofile()==null?"":sud.getDeptprofile();
	functionstr=sud.getFunctionstr();
	
}
%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>

</head>
<body>

<table class="content-table" style="width:100%">
<tr>
	<td width="25%" align="right">部门名称：</td>
	<td align="left"><strong><%=deptname%></strong></td>
</tr>
<tr>
	<td align="right">负责人：</td>
 	<td align="left"><%=principal%></td>

</tr>
<tr>
   	<td align="right">联系方式：</td>
   	<td align="left"><%=contact%></td>
</tr>

<tr>
   	<td align="right">部门简介：</td>
   	<td align="left"><%=deptprofile%></td>
</tr>
<tr>
   	<td align="right">主要职能：</td>
   	<td align="left"><%=functionstr%></td>
</tr>
<tr>
   	<td align="right">主要成员：</td>
   	<td align="left">
<%
String sno = "",sname = "",sacademy="",grade="",campus="",ssex="",duty = "",phone="",remark = "";   	
StudentUnionMember sum= new  StudentUnionMember ();
Map dutymap=CEditConst.getStuDutyMap(userInfo);
Map xynamemap= CEditConst.getAcademyNameMap(userInfo);
Map nianjimap= CEditConst.getGradeNameMap(userInfo);
Map orgname=CEditConst.getOrgCityNameMap(userInfo);
List list1= new ArrayList();
List cdt1= new ArrayList();
cdt1.add("deptid="+id);
list1=sum.query(cdt1);
if(list1.size()>0){
	for(int i=0;i<list1.size();i++){
	sum=(StudentUnionMember)list1.get(i);
	duty=(String)dutymap.get(sum.getDuty()+"")==null?"":(String)dutymap.get(sum.getDuty()+"");
	sname=sum.getSNo();
	grade=(String)nianjimap.get(sum.getSchoolYear())==null?"":(String)nianjimap.get(sum.getSchoolYear());
	phone=sum.getPhone();
	sacademy=(String)xynamemap.get(sum.getChargeDept())==null?"":(String)xynamemap.get(sum.getChargeDept());
	remark=sum.getRemark();
	if(sum.getCampus()!=""){
	campus=(String)orgname.get(sum.getCampus())==null?"":(String)orgname.get(sum.getCampus());
	}
%>
			<p>
				<span class="minfo"><%=duty%></span>
				<span class="minfo"><%=sname%></span>
				<span class="minfo"><%=ssex%></span>
				<span class="xinfo"><%=sacademy%></span>
				<span class="minfo"><%=grade%></span>
				<span class="xinfo"><%=campus%></span>
				<span class="xinfo"><%=phone%></span>
				<span class="xinfo"><%=remark%></span>
			</p>
			
<%}} %>			
   	
   	</td>
</tr>
<tr>
   	<td align="right">附件资料：</td>
   	<td align="left">
<%
if(addfilelist!=""){
	String[] addfilelistarry=addfilelist.split("\10");
	for(int i=0;i<addfilelistarry.length;i++){
		String[] filestr=addfilelistarry[i].split("\20");
%>
		<p><a href="../datafile/stuorg/<%=filestr[3] %>"><%=filestr[1]%>(<%=filestr[2]%>)</a></p>
<%
	}
}else{
%>
		无附件资料
<%	
}
%>   	
   	
   	</td>
</tr>
<tr>
	 <td  align="right">添加时间：</td>
	 <td align="left"><%=addtime%></td>
</tr>

</table>
</body>
</html>
