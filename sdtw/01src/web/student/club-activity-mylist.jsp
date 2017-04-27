<%@page import="java.util.Date"%>
<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="com.xietong.software.common.PageControl"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivityParticipate"%>
<%@page import="java.util.Map"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.sdtw.db.ClubActivities"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@ page pageEncoding="utf-8"%>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	return ;
}
int active = ParamUtils.getIntParameter(request,"active",0);
int page1 = ParamUtils.getIntParameter(request,"page",1);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/main/jqueryui.jsp" flush="true" />
<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="js/upload.js"></script>
<script>
function addApply(activityid,clubname,active){
	$.ajax({
        type: "get",
        ///sdfz/01src/web
        url: "club-activity-save.jsp",
        data: {"cmd":"addApply","activityid":activityid,"clubname":clubname},
        dataType: "json",
        cache: false,
        success: function(data){
                  if(data.msg=="ok"){
                	  alert("报名成功！")
                	  window.location.href='club-activity-mylist.jsp?active='+active;
                	  return;
                  }
                  if(data.msg="exist"){
                	  alert("已报名！")
                	  window.location.href='club-activity-mylist.jsp?active='+active;
                	  return;
                  }
                  if(data.meg=="error"){
                	  alert("申请失败，请重新申请！");
                	  window.location.href='club-activity-mylist.jsp?active='+active;
                	  return;
                  }
                 },
                 error : function() { 
                             alert( "异常！"); 
				}
    });
}


</script>
<style>
.content-table th {padding: 0px;}
.content-table td {padding: 0px;}
.ui-tabs .ui-tabs-nav li a {padding: 3;font-size: 14px;}
/*a  upload */
.a-upload {
    padding: 4px 10px;
    height: 15px;
    line-height: 15px;
    position: relative;
    cursor: pointer;
    color: #888;
    background: #fafafa;
    border: 1px solid #ddd;
    border-radius: 10px;
    overflow: hidden;
    display: inline-block;
    *display: inline;
    *zoom: 1
}

.a-upload  input {
    position: absolute;
    font-size: 100px;
    right: 0;
    top: 0;
    opacity: 0;
    filter: alpha(opacity=0);
    cursor: pointer
}

.a-upload:hover {
    color: #444;
    background: #eee;
    border-color: #ccc;
    text-decoration: none
}
#tabs-1 table{
width: 100%;
}
#tabs-2 table{
width: 100%;
}
</style>
</head>

<body>
	<%
String strposition = "学生社团工作>>社团活动列表>>";
String strfunction = "社团活动列表";
String strhelpwords = "社团活动列表。";
%>
	<%@ include file="pagetop-positionandhelp.jsp"%>

	<!-- <table class="command-table">
		<tr>
			<td><span style="float: left; color: red;">若为校外活动,请会长填写承诺书,成员填写校外活动安全监督书.</span>
				<a href="../datawork/templates/club-activity-safeinstructor.doc">学生社团校外活动安全指导书（右击—另存为）</a>
			</td>
		</tr>
	</table> -->
	<div id="tabs" style="width: 89%;margin: 0 auto;">
		<ul>
			<li><a href="#tabs-1">校内活动</a>
			</li>
			<li><a href="#tabs-2">校外活动</a>
			</li>
		</ul>
		<%
		ClubActivities v = new ClubActivities();
		ClubUtil util = new ClubUtil();
		Map ClubNameMap = CEditConst.getClubNameMap(userInfo);
		Map YesNoMap = CEditConst.getYesNoMap(userInfo);
		Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
		//Map CheckFlagMap = util.getCheckFlagMap();
		List list = new ArrayList();//校内
		list = util.getclubActivities(userInfo.getUserCode().getName(),request,1,0);
		Map<String,ClubActivityParticipate> clubactivitiesmap = new HashMap<String,ClubActivityParticipate>();
		List acList = new ArrayList();
		List clubList = new ArrayList();
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				v = (ClubActivities)list.get(i);
				acList.add(v.getId()+"");
				clubList.add(v.getClubName());
			}
			
		}
		List list2 = new ArrayList();//校外
		list2 = util.getclubActivities(userInfo.getUserCode().getName(),request,0,1);
		if(list2.size()>0){
			for(int i=0;i<list2.size();i++){
				v = (ClubActivities)list2.get(i);
				acList.add(v.getId()+"");
				clubList.add(v.getClubName());
			}
		}
		//判断是否已经报名
		clubactivitiesmap = util.getCheckClubActivits(Tool.join(",",acList));
		Map <String,List<String>> ClubSponsorMap = new HashMap();//负责人
		Map <String,List<String>> ClubTeacherMap = new HashMap();//指导教师
		ClubSponsorMap = util.getCheckClubSponsor(Tool.join(",",clubList));
		ClubTeacherMap = util.getCheckClubTeacher(Tool.join(",",clubList));
		
		%>
		<div id="tabs-1" style="border: 0px;padding:0px; width: 100%">
			<table class="content-table" style="width: 100%">
				<tr>
					<th width="5%">序号</th>
					<th width="16%">社团名称</th>
					<th width="15%">活动名称</th>
					<th width="7%">是否校内</th>
					<th width="22%">时间</th>
					<th width="12%">地点</th>
					<th width="9%">负责人</th>
					<th width="5%">指导教师</th>
					<th>操作</th>
				</tr>
				<%
	for(int i=0;i<list.size();i++){
	v = (ClubActivities)list.get(i);
	if(v.getIsatSchool().equals("1")){
	%>
				<tr>
					<td><%=i+1 %></td>
					<td><a href="club-setup-add.jsp?cmd=viewlist&id=<%=v.getClubName()%>&backurl=<%=request.getRequestURI()%>&active=0"><%=ClubNameMap.get(v.getClubName()) %></a></td>
					<td><a href="club-activity-detail.jsp?id=<%=v.getId()%>&active=0&page=<%=page1%>"><%=v.getActivityName() %></a></td>
					<td><%=YesNoMap.get(v.getIsatSchool()) %></td>
					<td><%=Tool.stringOfDate(Tool.stringToDate(v.getTimeStart()))%> ~ <%=Tool.stringOfDate(Tool.stringToDate(v.getTimeEnd()))%></td>
					<td><%=v.getActivityPlace() %></td>
					<td>
						<%
						//社团负责人
					  List<String>mlist = new ArrayList<String>();
					  if(ClubSponsorMap.get(v.getClubName())!=null){
						  mlist = ClubSponsorMap.get(v.getClubName());
						  for(int j=0;j<mlist.size();j++){%>
								<a href='club-setup-manager-modify.jsp?cmd=viewlist&active=0&MemberName=<%=mlist.get(j) %>&MemberClubname=<%=v.getClubName()%>&state=3'><%=UserCnNameMap.get(mlist.get(j)) %></a>&nbsp;&nbsp;  
						  <%} 
					  }%>
					</td>
					<td>
					<%
					//指导教师
					ClubTeacher teacher = new ClubTeacher();
					  List<String>tList = new ArrayList<String>();
					  if(ClubTeacherMap.get(v.getClubName()+"")!=null){
						  tList = ClubTeacherMap.get(v.getClubName()+"");
						  for(int j=0;j<tList.size();j++){%>
							  <a href='club-setup-teacher-modify.jsp?cmd=viewlist&active=0&ClubName=<%=v.getClubName() %>&TeaName=<%=tList.get(j)%>&state=3'><%=tList.get(j) %></a>&nbsp;&nbsp;  
						  <%}
					  }%>
					<td>
						<%
						System.out.println(v.getId()+"_"+userInfo.getId());
		if(clubactivitiesmap.get(v.getId()+"_"+userInfo.getId())!=null){
			ClubActivityParticipate cap = new ClubActivityParticipate();
			cap = clubactivitiesmap.get(v.getId()+"_"+userInfo.getId());%><%
			if(cap.getCheckflag()==1){%> 您是该活动成员 
			<%}else{%>
			 已报名,等待审核
			 <%}%> 
			 <%-- <%if(v.getIsatSchool().equals("0")){//校外活动%> <a
						href='club-activity-safeadd.jsp?id=<%=cap.getId()%>&clubname=<%=v.getClubName()%>&activityid=<%=v.getId() %>&cmd=view'>查看安全监督书</a>
						<%}%>  --%>
						<%}else{%> 
						<%//if(v.getIsatSchool().equals("0")){//校外活动%> 
						<%-- <a href="club-activity-safeadd.jsp?clubname=<%=v.getClubName()%>&activityid=<%=v.getId() %>">提交安全监督书</a> --%>
						<%//}else{%>
						<%
						if(Tool.stringToDateTime(v.getTimeStart()).getTime()<=new Date().getTime()&&Tool.stringToDateTime(v.getTimeEnd()).getTime()>=new Date().getTime()){
						%>
						 <a href="javascript:;"	onclick="addApply(<%=v.getId()%>,<%=v.getClubName()%>,0)">申请参加</a> 
						<%//}%>
						<%}else{%>
							活动已开始或结束
						<%}
						}
		%>
					</td>
				</tr>
				<%}
				}
	//clubactivitiesmap.clear();

%>
			</table>
			<%
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl0");
	%>
	<%=pagecontrol.getControl_win8_("club-activity-mylist.jsp?active=0&page="+page1,  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
		</div>
		<div id="tabs-2" style="border: 0px;padding:2px; width: 100%">
		<table class="command-table">
		<tr >
			<td style="height: 30px;"><!-- <span style="float: left; color: red;">若为校外活动,请会长填写承诺书,成员填写校外活动安全监督书.</span> -->
				<a href="../datawork/templates/club-activity-safeinstructor.doc">学生社团校外活动安全指导书（右击—另存为）</a>
			</td>
		</tr>
	</table>
		<table class="content-table" style="width: 100%">
				<tr>
					<th width="5%">序号</th>
					<th width="16%">社团名称</th>
					<th width="15%">活动名称</th>
					<th width="7%">是否校内</th>
					<th width="22%">时间</th>
					<th width="12%">地点</th>
					<th width="9%">负责人</th>
					<th width="5%">指导教师</th>
					<th>操作</th>
				</tr>
				<%
	for(int i=0;i<list2.size();i++){
	v = (ClubActivities)list2.get(i);
	if(v.getIsatSchool().equals("0")){
	%>
				<tr>
					<td><%=i+1 %></td>
					<td><a href="club-setup-add.jsp?cmd=viewlist&id=<%=v.getClubName()%>&backurl=<%=request.getRequestURI()%>&active=1"><%=ClubNameMap.get(v.getClubName()) %></a></td>
					<td><a href="club-activity-detail.jsp?id=<%=v.getId()%>&active=1&page=<%=page1%>"><%=v.getActivityName() %></a></td>
					<td><%=YesNoMap.get(v.getIsatSchool()) %></td>
					<td><%=v.getTimeStart() %> ~ <%=v.getTimeEnd() %></td>
					<td><%=v.getActivityPlace() %></td>
					<td>
						<%
						//社团负责人
					  List<String>mlist = new ArrayList<String>();
					  if(ClubSponsorMap.get(v.getClubName())!=null){
						  mlist = ClubSponsorMap.get(v.getClubName());
						  for(int j=0;j<mlist.size();j++){%>
								<a href='club-setup-manager-modify.jsp?cmd=viewlist&active=1&MemberName=<%=mlist.get(j) %>&MemberClubname=<%=v.getClubName()%>&state=3'><%=UserCnNameMap.get(mlist.get(j)) %></a>&nbsp;&nbsp;  
						  <%} 
					  }%>
					</td>
					<td>
					<%
					//指导教师
					ClubTeacher teacher = new ClubTeacher();
					  List<String>tList = new ArrayList<String>();
					  if(ClubTeacherMap.get(v.getClubName()+"")!=null){
						  tList = ClubTeacherMap.get(v.getClubName()+"");
						  for(int j=0;j<tList.size();j++){%>
							  <a href='club-setup-teacher-modify.jsp?cmd=viewlist&active=1&ClubName=<%=v.getClubName() %>&TeaName=<%=tList.get(j)%>&state=3'><%=tList.get(j) %></a>&nbsp;&nbsp;  
						  <%}
					  }%>
					</td>
					<td>
						<%
						System.out.println(v.getId()+"_"+userInfo.getId());
		if(clubactivitiesmap.get(v.getId()+"_"+userInfo.getId())!=null){
			ClubActivityParticipate cap = new ClubActivityParticipate();
			cap = clubactivitiesmap.get(v.getId()+"_"+userInfo.getId());
			ClientAttach attach = new ClientAttach();
			 attach = util.getClientAttach(cap.getId()); 
			if(cap.getCheckflag()==1){ %>您是该活动成员 
			<%if(!"".equals(attach.getUploadName())){
			%>
			,查看安全指导书<a href="../servlet/attach?type=otherattach&id=<%=cap.getId()%>"><%=attach.getUploadName() %></a>
			<%} %>
			<%}else{%>
			 已报名,等待审核 <br/>
			 <span id="tr<%=cap.getId()%>">
			 <%
			 if(attach.getId()!=-1){%>
				<!--  <img src='../main/images/file1.gif'/> -->
				 <a href="../servlet/attach?type=otherattach&id=<%=attach.getId()%>"><%=attach.getUploadName() %></a>
				 <img src='../main/images/delete.gif' alt='删除' title='删除' onclick="deleteUpdateFile('\'<%=attach.getUploadName() %>\'','<%=attach.getId() %>','<%=cap.getId() %>');" style="cursor:point;"/>
			 <%}
			 %>
			 </span><br/>
			 <a href="javascript:;" class="a-upload">
   			 <input type="file" name="OtherAttach" id="OtherAttach" onchange="checkFileType(4,'clubactivitiesParticipate','<%=cap.getId()%>');">上传指导书
			</a>
			<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
			 <%}%> 
			 <%-- <%if(v.getIsatSchool().equals("0")){//校外活动%> <a
						href='club-activity-safeadd.jsp?id=<%=cap.getId()%>&clubname=<%=v.getClubName()%>&activityid=<%=v.getId() %>&cmd=view'>查看安全监督书</a>
						<%}%>  --%>
						<%}else{%> 
						<%//if(v.getIsatSchool().equals("0")){//校外活动%> 
						<%-- <a href="club-activity-safeadd.jsp?clubname=<%=v.getClubName()%>&activityid=<%=v.getId() %>">提交安全监督书</a> --%>
						<%//}else{%>
						<%
						if(Tool.stringToDateTime(v.getTimeStart()).getTime()<=new Date().getTime()&&Tool.stringToDateTime(v.getTimeEnd()).getTime()>=new Date().getTime()){
						%>
						 <a href="javascript:;"	onclick="addApply(<%=v.getId()%>,<%=v.getClubName()%>,1)">申请参加</a> 
						<%//}%>
						<%}
						}
		%>
					</td>
				</tr>
				<%}
				}
	clubactivitiesmap.clear();
	ClubSponsorMap.clear();
	ClubTeacherMap.clear();
%>
			</table>
			<%
	PageControl pagecontrol1 = (PageControl)request.getAttribute("PageControl1");
	%>
	<%=pagecontrol1.getControl_win8_("club-activity-mylist.jsp?active=1&page="+page1,  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId())%>
			</div>
	</div>

<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', <%=active%>); 
	});
	</script>
</body>
</html>