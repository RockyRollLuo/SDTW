<%@ page contentType="text/html;charset=UTF-8"%>
<%@page import="com.xietong.software.sdtw.db.ClientAttach"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeam"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.sdtw.db.PracticeDeclareTeammember"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.sdtw.db.PracticeReport"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*"%>
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
PracticeUtil util = new PracticeUtil();
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);
List TermTypeOptions = util.getTermTypeOptions();
List PracticeThemeOptions1 = util.getPracticeThemeOptions1();
List PracticeThemeOptions2 = util.getPracticeThemeOptions2();
List getReport6Options = util.getReport6Options();
List YesNoOptions = CEditConst.getYesNoOptions(userInfo,"-1");
Map UserCnNameMap = CEditConst.getUserCnNameMap(userInfo);
Map sexMap = CEditConst.getsexMap(userInfo);
Map GradeNameMap = CEditConst.getGradeNameMap(userInfo);
PracticeReport v = new PracticeReport();
int id = ParamUtils.getIntParameter(request,"id",-1);
int DeclareId = ParamUtils.getIntParameter(request,"DeclareId",-1);
if (id!=-1&&v.getById(id)!=null) {
	v = v.getById(id);
}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<script src="../js/jquery.min.js"></script>
<script src="../js/tablelist.js"></script>
<script src="../js/personlistorder.js"></script>
<script src="../main/js/common.js"></script>
<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script language="JavaScript" src="js/upload.js"></script>
<script type="text/javascript">
function submitthis(Submitflag) {
	var Report3 = $('#Report3').val();
	if (Report3=="") {
		alert("请录入课题名称！");
		$('#Report3').focus();
		return;
	}
	var Report6 = $('#Report6').val();
	if (Report6=="-1") {
		alert("请选择立项类别！");
		$('#Report6').focus();
		return;
	}
	var AddFilelist = $('#AddFilelist').val();
	if (AddFilelist=="") {
		alert("请上传附件！");
		$('#AddFilelist').focus();
		return;
	}
	$('#SubmitFlag').val(Submitflag);
	$('#postForm').submit();
}
function cancelthis() {
	location="pratice-activity-list.jsp";
}
</script>
</head>
<body>
<%
String strposition = "社会实践  >>社会实践项目>> ";
String strfunction = "社会实践结题书-个人申请";
String strhelpwords= "1.各级各类实践立项申报团队均需填写此表，其中团队成员总数一般在10人以内;<br/>"
					+"2.两个以上学院合作组织的团队，需两个学院协商配套经费、共同签署意见;<br/>"
					+"3.若对申请书填写有不清楚的地方，请咨询0531-88369964。";
%>
<%@ include file="../student/pagetop-positionandhelp.jsp" %>

<table class="command-table">
<tr>
	<td>
 	   <a href="pratice-activity-list.jsp"><!-- <img src="../images/commandico/back.png"> -->返回</a>
	</td>
</tr>
</table>

<form name="postForm" id="postForm" action="pratice-project-addsave.jsp" method="post">
<input id="Type" name="Type" value="2" type="hidden"/>
<input id="cmd" name="cmd" value="savePersonal" type="hidden"/>
<input id="SubmitFlag" name="SubmitFlag" value="<%=v.getSubmitFlag()%>" type="hidden"/>
<input id="DeclareId" name="DeclareId" value="<%=DeclareId%>" type="hidden"/>
<input id="Id" name="Id" value="<%=v.getId()%>" type="hidden"/>
<table class="content-table">
<tr>
	<td width="20%" align="right">所属学院：</td>
    <td align="left">
    <input id="Report2" name="Report2" value="<%=userInfo.getDeptId()%>" type="hidden"/>
    <%=AcademyNameMap.get(userInfo.getDeptId()+"")%>
    </td>
</tr>
<tr>
    <td width="20%" align="right">课题名称：</td>
    <td align="left"><input type="text" name="Report3" id="Report3" size="50"  value="<%=v.getReport3()%>"/></td><!-- placeholder="专题调研、社会调查、科研攻关或科技开发课题名称" -->
</tr>
<tr>
    <td width="20%" align="right" >立项类别：</td>
    <td align="left">
    	<!-- <input type="radio" name="Report6" value="重点立项"/>重点立项&nbsp;&nbsp;
    	<input type="radio" name="Report6" value="一般立项"/>一般立项&nbsp;&nbsp;
    	<input type="radio" name="Report6" value="自筹经费立项"/>自筹经费立项&nbsp;&nbsp;  -->
    	<%=HtmlTool.renderSelect(getReport6Options,""+v.getReport6(),"Report6","1") %>
    </td>
</tr>
<tr id="ClientAttach">
  		<td align="right" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="3">
  		<input type="hidden" id="AddFilelist" name="AddFilelist" value="<%=v.getAddFilelist()%>"/>
		<table width="100%" border="0" cellspacing="0" id="ShowFilesAddFilelist">
				<%
				int caid = v.getId();
				if (!"".equals(v.getAddFilelist().trim())) {
					String caids[] = v.getAddFilelist().split(",");
					for(int i=0;i<caids.length;i++){
						caid = Tool.StrToInt(caids[i]);
						ClientAttach ca = new ClientAttach();
						if (caid!=-1&&ca.getById(caid)!=null) {
							ca = ca.getById(caid);
				%>
			     <tr id="<%=ca.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca.getId() %>" target="_blank">
				<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<img  src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca.getUploadName()%>','<%=ca.getId() %>')" style="cursor:point;"/></td>
				</tr>
					<%}
					}
				}
				%>
			</table>
				<%
				//if(v.getCheckFlag()!=1){%>
				<input  type="file" name="OtherAttachAddFilelist" id="OtherAttachAddFilelist" size="40"/> 
				<input type="button" value="上传" id="btn_up"  onclick="checkFileType(14,'Practice_Report','AddFilelist');" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
				<img style="display:none" id="load1AddFilelist" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
				<%//}
				%>
			    <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div>
			</td>
  		</tr>
</table>
</form>
<table class="content-table" style="margin-top:-15px">
<tr>
  <th  colspan="3" >
  <%
  if (v.getSubmitFlag()==-1) {%>
	  <input class="button" type="button" value="保存" name="btn1" onclick="submitthis(-1)">&nbsp;&nbsp;&nbsp;
    <input class="button" type="button" value="提交" name="btn1" onclick="submitthis(1)">&nbsp;&nbsp;&nbsp;
  <%}
  %>
    <input class="button" type="button" value="取消" name="btn2" onclick="cancelthis()">&nbsp;&nbsp;&nbsp;
  </th>
</tr>
</table>
</body>
</html>
