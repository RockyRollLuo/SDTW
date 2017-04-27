<%@page import="com.xietong.software.sdtw.db.ClubTeacher"%>
<%@page import="com.xietong.software.sdtw.db.ClubMembers"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.base.SdtwConst"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.sdtw.db.Club"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@page import="java.util.List"%>
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.sdtw.club.ClubUtil"%>
<%@ page pageEncoding="utf-8" %>
<%
UserInfo userInfo = Tool.getUserInfo(request);
if(!userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/tablelist.js"></script> 
<script src="../js/jquery.min.js"></script> 
<script>
function deleteList(id){
	if (confirm("确实要删除吗?")) {
	location = 'club-setup-addsave.jsp?cmd=del&id='+id;
	}
}
function shangbao(id){
	
	$.ajax({
        type: "post",
        ///sdfz/01src/web
        url: "club-setup-addsave.jsp",
        data: {id:id,cmd:"checkSave"},
        dataType: "json",
        cache: false,
        success: function(data){
                   if (data.msg=="ok") {
                		if (confirm("确实要提交吗?")) {
                		location = 'club-setup-addsave.jsp?id='+id+'&cmd=shangbao';
                		}
                   }
                   if (data.msg=="fzrno") {
                	   alert("请添加社团负责人!");
                	   return;
                   }
                   if (data.msg=="jsno") {
                	   alert("请添加指导教师!");
                	   return;
                   }
                 },
                 error : function() { 
                             // view("异常！"); 
                             alert( "异常！"); 
	}
    });
	
}
</script>
</head>

<body>
<%
BaseUserCode user = new BaseUserCode();
if(userInfo == null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
if(userInfo.hasFunPower(Power.USERSTUDENTPOWER)){
	user = userInfo.getUserCode();
}
String strposition = "学生社团工作>>社团成立申请>>";
String strfunction = "申请列表";
String strhelpwords = "社团成立申请列表。";
ClubUtil util = new ClubUtil();
List list = util.getClubListByUser(user.getId());
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
%>
<%@ include file="pagetop-positionandhelp.jsp" %>
<%
if(list.size()<1){%>
	<div id="table4">
<table class="frame-table" align="center">
  <tr height="40px"><th>系统提示</th></tr>
  <tr>
    <td>您尚未申请成立社团！</td>
  </tr>
  <tr height="40px">
  <th>
    <a href="club-setup-add.jsp?&backurl=<%=request.getRequestURI()%>" target="_self">申请成立社团</a>
  </th>
  </tr>
</table>
</div>
<%}else{%>
	<table class="command-table" id="table1">
<tr class="odd">
  <td>
    <a href="club-setup-add.jsp?backurl=<%=request.getRequestURI()%>" >申请成立</a>
  </td>
</tr>    
</table>

<table class="content-table" id="table2" border="1px;">
<tr>
  <th width="5%">序号</th>
  <th width="18%">社团名称</th>
  <th width="9%">社团编号</th>
  <th width="8%">申请书</th>
  <th width="8%">审核</th>
  <th width="15%">负责人</th>
  <th width="8%">指导教师</th>
  <th width="21%">操作</th>
</tr>
<%
Map checkFlagMap = new HashMap<String,String>();
checkFlagMap = util.getCheckFlagMap();
Map <String,List<String>> ClubSponsorMap = new HashMap();
Map <String,List<String>> ClubTeacherMap = new HashMap();
List cids = new ArrayList();
for(int i=0;i<list.size();i++){
	Club club = new Club();
	club = (Club)list.get(i);
	cids.add(club.getId()+"");
}
ClubSponsorMap = util.getCheckClubSponsor(Tool.join(",",cids));
ClubTeacherMap = util.getCheckClubTeacher(Tool.join(",",cids));
for(int i=0;i<list.size();i++){
	Club club = new Club();
	club = (Club)list.get(i);%>
	<tr>
	  <td><%=i+1 %></td>
	  <td><%=club.getClubName() %></td>
	  <td><%=club.getClubId() %></td>
	  <td><a href="club-setup-add.jsp?cmd=view&id=<%=club.getId()%>&backurl=<%=request.getRequestURI()%>">点击查看</a></td>
	  <td><%=(String)checkFlagMap.get(club.getCheckFlag()) %></td>
	  <td><%
	  ClubMembers members = new ClubMembers();
	  List<String>mlist = new ArrayList<String>();
	  if(ClubSponsorMap.get(club.getId()+"")!=null){
		  mlist = ClubSponsorMap.get(club.getId()+"");
		  for(int j=0;j<mlist.size();j++){
			  if(!SdtwConst.CHECKFLAG_XXTG.equals(club.getCheckFlag())){
				  if((userInfo.getId()+"").equals(club.getAddPerson())){%>
				<a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberName=<%=mlist.get(j) %>&MemberClubname=<%=club.getId()%>&state=<%=club.getCheckFlag()%>'><%=UserCnNameMap.get(mlist.get(j))==null?mlist.get(j):UserCnNameMap.get(mlist.get(j)) %></a>&nbsp;&nbsp;  
				  <%}
			  }else{%>
				  <a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberName=<%=mlist.get(j) %>&MemberClubname=<%=club.getId()%>&state=<%=club.getCheckFlag()%>'><%=UserCnNameMap.get(mlist.get(j))==null?mlist.get(j):UserCnNameMap.get(mlist.get(j)) %></a>&nbsp;&nbsp;
			  <%}
		  %>
		  <%} 
	  } else {%>
		 <% if(SdtwConst.CHECKFLAG_WSB.equals(club.getCheckFlag())&&(userInfo.getId()+"").equals(club.getAddPerson())){%>
			   <a href='club-setup-manager-modify.jsp?cmd=saveOrUpdate&MemberClubname=<%=club.getId()%>'>添加负责人</a>
		  <%	}
		  
	  }%>
	 </td>
	  <td>
	  <%
	  ClubTeacher teacher = new ClubTeacher();
	  List<String>tList = new ArrayList<String>();
	  if(ClubTeacherMap.get(club.getId()+"")!=null){
		  tList = ClubTeacherMap.get(club.getId()+"");
		  for(int j=0;j<tList.size();j++){%>
			  <a href='club-setup-teacher-modify.jsp?cmd=saveOrUpdate&ClubName=<%=club.getId() %>&TeaName=<%=tList.get(j)%>&state=<%=club.getCheckFlag()%>'><%-- <%=UserCnNameMap.get(tList.get(j)) %> --%><%=tList.get(j) %></a>&nbsp;&nbsp;  
		  <%}
	  }else{%>
	  <a href='club-setup-teacher-modify.jsp?cmd=saveOrUpdate&ClubName=<%=club.getId() %>'>添加指导教师</a>
	  <%} %>
	  </td>
	  <td>
	  <%
	  if(SdtwConst.CHECKFLAG_WSB.equals(club.getCheckFlag())){%>
		  <a href="club-setup-add.jsp?id=<%=club.getId()%>&cmd=update&backurl=<%=request.getRequestURI()%>">修改</a>&nbsp;&nbsp;
		  <a href="javascript:deleteList(<%=club.getId()%>)">删除</a>&nbsp;&nbsp;
		  <a href="javascript:shangbao(<%=club.getId()%>)">上报</a>
	 <%}
	  %>
	   <%
	  if(SdtwConst.CHECKFLAG_XYWTG.equals(club.getCheckFlag())){%>
		  <a href="club-setup-add.jsp?id=<%=club.getId()%>&cmd=update&backurl=<%=request.getRequestURI()%>">修改</a>&nbsp;&nbsp;
		  <a href="javascript:shangbao(<%=club.getId()%>)">上报</a>
	 <%}
	  %>
	  <%
	  if(SdtwConst.CHECKFLAG_XXWTG.equals(club.getCheckFlag())){%>
		  <a href="club-setup-add.jsp?id=<%=club.getId()%>&cmd=update&backurl=<%=request.getRequestURI()%>">修改</a>&nbsp;&nbsp;
		  <a href="javascript:shangbao(<%=club.getId()%>)">上报</a>
	 <%}
	  %>
	  <%
	  if(SdtwConst.CHECKFLAG_SB.equals(club.getCheckFlag())){%>
		 已上报,不允许修改
	 <%}
	  %>
	  </td>
	</tr>
<%}
ClubSponsorMap.clear();
ClubTeacherMap.clear();
%>
<tr><th colspan="11" align="left">
&nbsp;说明：1.学生社团负责人和指导教师信息都填写完整后才可以上报数据。<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
2.学校审核通过之后，可以用社团编号作为账号登陆社团官方账号，初始密码为111111。

</th></tr>
</table>
<%}
%>

<script type="text/javascript">
/*   document.getElementById("table1").style.display="block";
  document.getElementById("table2").style.display="block"; */
 // document.getElementById("table4").style.display="none";
</script>

 </body>
</html>