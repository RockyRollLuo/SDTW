<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="com.xietong.software.sdtw.db.Students"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.common.COptionConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page pageEncoding="utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*" %>
<%@ include file="/main/js/jsheader.jsp"%>
<%! 

int rowscount,i;
int numsperpage=10,pagecount,pagenum,gopage;
%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	//out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}
List cdt = cdt = new ArrayList();
cdt.add("RecruitmentCheckflag=1");
List ClubNameOptions = COptionConst.getClubNameOptions(userInfo,"-1",cdt);
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
int selectType = ParamUtils.getIntParameter(request,"selectType",0);
String cmd = ParamUtils.getParameter(request,"cmd","list");
String ClubName = ParamUtils.getParameter(request,"ClubName","");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script> 
<script src="../js/jquery.min.js"></script> 
<link rel="stylesheet" href="../css/jqueryUI/jquery-ui.css">
<script src="../js/jqueryUI/jquery-ui.js"></script>
<script src="<%=HeadConst.apache_url%>/main/js/listfunction_win8.js"></script>
<script type="text/javascript">
$(function(){
	$("#selectType").selectable();
});

function changeorder(){
	document.formselect.selectedType.value=$("#selectType").find("option:selected").val();
	document.formselect.submit();
}
</script>
</head>

<body>
<%
String strposition = "学生社团工作>>学生社团信息>>";
String strfunction = "学生社团列表";
String strhelpwords = "社团列表。";
%>
<%@ include file="pagetop-positionandhelp.jsp" %>

<table class="content-table" id="table2">
<tr>
<form name="formselect" method="post" action="club-all-list.jsp">
<input type="hidden" id="cmd" name="cmd" value="<%=ParamUtils.getParameter(request,"cmd","")%>"/>
	<td colspan="13"  align="left">
	社团名称：<input name="ClubName" type="text" value="<%=ClubName %>" size="20" onchange="changeorder();">&nbsp;
		选择：<input name="selectedType" type="hidden" value="" >
 		<select name="selectType" id="selectType" onchange="changeorder();">
	  		<option value="0">所有社团</option>
	  		<option value="1">我加入的</option>
	  		<option value="2">正在纳新</option>
  		</select>
  	<script type="text/javascript">$("select[name='selectType']").val("<%=selectType%>");</script>
	</td>
</form>
</tr>
<tr>
  <th width="5%">序号</th>
  <th width="18%">社团名称</th>
  <th width="18%">纳新时段</th>
  <th width="8%">申请书</th>
  <th width="10%">负责人情况</th>
  <th width="8%">指导教师情况</th>
  <!-- <th width="8%">财务公开</th> -->
  <th width="6%">会员人数</th>
  <th width="6%">申请人数</th>
  <!-- <th width="8%">审核情况</th> -->
  <th>操作</th>
</tr>
<%
ClubUtil util = new ClubUtil();
List list = new ArrayList();
list = util.getClubList(selectType,userInfo.getId(),ClubName,request);
List clubList = new ArrayList();
if(list.size()>0){
	List sidsList = new ArrayList();
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		String sids = club.getId()+"";
		sidsList.add(sids);
	}
	//判断社团是否注册
	Map<String,Boolean> checkregMap = new HashMap<String,Boolean>();
	checkregMap =util.getCheckClubRegistTime(Tool.join(",",sidsList));
	//Map<String,List<ClubMembers>> ClubMemberMap = new HashMap<String,List<ClubMembers>>();
	Map <String,List<String>> ClubSponsorMap = new HashMap();
	Map <String,List<String>> ClubTeacherMap = new HashMap();
	Map <String,Integer>ClubMemberNumsMap = util.getClubMemberNumsMap();
	Map CheckFlagMap = util.getCheckFlagMap();
	Map CheckJoinClubMap = util.getCheckJoinClub(Tool.join(",",sidsList));
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		//members.getId()+"_"+members.getMemberClubname()
		clubList.add(club.getId()+"");
	}
	ClubSponsorMap = util.getCheckClubSponsor(Tool.join(",",clubList));
	ClubTeacherMap = util.getCheckClubTeacher(Tool.join(",",clubList));
	//ClubMemberMap = util.getClubMemberMap(Tool.join(",",clubList));
	for(int i=0;i<list.size();i++){
		Club club = new Club();
		club = (Club)list.get(i);
		//String sids[] = club.getChairman().split(",");
		if(checkregMap.get(club.getId()+"")!=null){
			boolean chekregist = checkregMap.get(club.getId()+"");
			if(chekregist){
	%>
		<tr>
		<td><%=i+1 %></td>
		<td><%=club.getClubName() %></td>
		<td><%=Tool.stringOfDate(club.getRecruitmentStart()) %> 到  <%=Tool.stringOfDate(club.getRecruitmentStop()) %></td>
		<td><a href="club-setup-add.jsp?cmd=viewlist&id=<%=club.getId()%>&backurl=<%=request.getRequestURI()%>">申请书查看</a></td>
		<td>
		
		<%
	  List<String>mlist = new ArrayList<String>();
	  if(ClubSponsorMap.get(club.getId()+"")!=null){
		  mlist = ClubSponsorMap.get(club.getId()+"");
		  for(int j=0;j<mlist.size();j++){
			//  if(!SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){
				//  if((userInfo.getId()+"").equals(club.getAddPerson())){%>
				<a href='club-setup-manager-modify.jsp?cmd=viewlist&MemberName=<%=mlist.get(j) %>&MemberClubname=<%=club.getId()%>&state=<%=club.getCheckFlag()%>'><%=UserCnNameMap.get(mlist.get(j)) %></a>&nbsp;&nbsp;  
				  <%//}
			 // }
		  %>
		  <%} 
	  }%>
		
		</td>
		<td>
		<%ClubTeacher teacher = new ClubTeacher();
	  List<String>tList = new ArrayList<String>();
	  if(ClubTeacherMap.get(club.getId()+"")!=null){
		  tList = ClubTeacherMap.get(club.getId()+"");
		  for(int j=0;j<tList.size();j++){%>
			  <a href='club-setup-teacher-modify.jsp?cmd=viewlist&ClubName=<%=club.getId() %>&TeaName=<%=tList.get(j)%>&state=<%=club.getCheckFlag()%>'><%=tList.get(j) %></a>&nbsp;&nbsp;  
		  <%}
	  }%>
		</td>
		<td><%=ClubMemberNumsMap.get(club.getId()+"_1")==null?"0":ClubMemberNumsMap.get(club.getId()+"_1")%>
		</td>
		<td>
		<%=ClubMemberNumsMap.get(club.getId()+"")==null?"0":ClubMemberNumsMap.get(club.getId()+"")%>
		</td> 
		<%-- <td>
		<%=CheckFlagMap.get(club.getCheckFlag()+"") %>
		</td> --%>
		<td>
		<%
		if(CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId()+"_Cy")!=null){
			ClubMembers members = new ClubMembers();
			members = (ClubMembers)CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId()+"_Cy");
		%>
		<a href="club-recruitment-add.jsp?cmd=viewlist&id=<%=club.getId()%>&MemId=<%=members.getId()%>">您是该社团成员</a>
		<%}else{%>
			<%
		if(CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId())==null){
			if(club.getRecruitmentCheckflag()==1){
			if(club.getRecruitmentStart().getTime()<=new Date().getTime()&&club.getRecruitmentStop().getTime()>=new Date().getTime()){%>
				<a href="club-recruitment-add.jsp?id=<%=club.getId()%>">申请加入</a>
			<%}else{%>
				停止纳新
			<%}
			%>
			<%}else{%>
				未开启纳新
			<%}
		%>
			
		<%}else{
		ClubMembers members = new ClubMembers();
		members = (ClubMembers)CheckJoinClubMap.get(club.getId()+"_"+userInfo.getId());
		%>
		<a href="club-recruitment-add.jsp?cmd=viewlist&id=<%=club.getId()%>&MemId=<%=members.getId()%>">已申请</a>
		<%}%>
		<%}
		%>
		</td>
		</tr>
		<%} 
		}
		%>
	<%}
	checkregMap.clear();
	ClubMemberNumsMap.clear();
	ClubSponsorMap.clear();
	ClubTeacherMap.clear();
	CheckFlagMap.clear();
	CheckJoinClubMap.clear();
}else{%>
	<tr>
	<td colspan="10">没有信息</td>
</tr>
<%}
%>
</table>
<%
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	%>
	<%=pagecontrol.getControl_win8_("club-all-list.jsp?cmd=list&selectType="+selectType+"&ClubName="+ClubName,  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
</body>
</html>

