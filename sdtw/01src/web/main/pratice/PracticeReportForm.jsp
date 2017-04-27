<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdtw.pratice.PracticeUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社会实践结题书表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(PracticeReport.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	PracticeReport v = (PracticeReport)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	forms.addAll((List)paras.get(3));
	String url = Tool.join("&", urls);
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
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
	
	int DeclareId = ParamUtils.getIntParameter(request,"_DeclareId_",-1);//立项id
	Practice p = new Practice();//立项表
	if (DeclareId!=-1&&p.getById(DeclareId)!=null) {
		p = p.getById(DeclareId);
	}
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script>
		$('.ui-button-text').text("关闭");
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
		</script>
	</head>
	<body onload="init();">
		<%-- <jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001"><%=p.getPracticeName() %>结题书</div>
				<div class="browsetitle002"><%=XtUtil.getSpell(p.getPracticeName()+"结题书") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<%-- <li><a href="PracticeReportAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li> --%>
						<!-- <li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li> -->
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				
                <input name="SubmitFlag" id="SubmitFlag" value="<%=v.getSubmitFlag()%>" type="hidden">
				<input type="hidden" name="Id" value="<%=v.getId()%>">
				<%=Tool.join("\n", forms)%>
<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;background-color: #e3e5e8">
                    											
<tr>
	<td class="form_label"align="right">所属学院</td>
    <td align="left" bgcolor="#ffffff">
    <%=AcademyNameMap.get(v.getAcademy()+"")%>
    </td>

    <td class="form_label" align="right">课题名称</td>
    <td align="left" bgcolor="#ffffff">
    <%=v.getReport3()%>
    </td>
    <td class="form_label" align="right">申报类别</td>
    <td align="left" bgcolor="#ffffff">
    <%=v.getType()==1?"集体申报":"个人申报"%>
    </td>
</tr>
<%
if (v.getType()==1) {%>
	<tr>
<td class="form_label" align="right">团队名称</td>
	<%
	PracticeDeclareTeam team = new PracticeDeclareTeam();
	team = util.getTeamDetail(v.getId());
	%>
    <td align="left" bgcolor="#ffffff">
    <%=team.getTeamName()%>
    </td>
    <td class="form_label" align="right">团队类别</td>
    <td align="left" bgcolor="#ffffff" colspan="3">
      	<%=HtmlTool.renderSelect(TermTypeOptions,""+team.getPracticeReportTeamType(),"Report4","1",true) %>
    </td>
</tr>
<tr>
<td class="form_label" align="right">实践主题</td>
    <td align="left" bgcolor="#ffffff">
		<div id="div1" >
    	<span id="PracticeThemespan1">
    	<%=HtmlTool.renderSelect(PracticeThemeOptions1,""+v.getReport5(),"Report5","",true) %>
    	</span>
    </td>

    <td class="form_label" align="right" >立项类别</td>
    <td align="left" bgcolor="#ffffff" colspan="3">
    	<%=HtmlTool.renderSelect(getReport6Options,""+v.getReport6(),"Report6","1",true) %>
    </td>
</tr>
<tr>
	<td align="right" class="form_label">成员信息
	</td>
    <td align="left" bgcolor="#ffffff" colspan="5">
    <%
    List TeamList = util.getTeamList(v.getId(),"1",1);
    %>
	<!-- 研究生添加 -->
    <table id="teamtable" style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;background-color: #e3e5e8;">
    	<tr style="background-color:#f7f9fc;">
			<td style="width: 10%">学号</td><td style="width: 10%">姓名</td><td style="width: 10%">性别</td>
			<td style="width: 10%">院系</td><td style="width: 10%">学历</td><td style="width: 10%">年级</td>
			<td style="width: 10%">联系方式</td><td style="width: 10%">承担工作</td><!-- <td style="width: 10%">操作</td> -->
		</tr>
		<%
		List sexOptions = CEditConst.getsexOptions(userInfo);
		List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo);
		List IdentityOptions = CEditConst.getIdentityOptions(userInfo);
		List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo);
		Map IdentityMap = CEditConst.getIdentityMap(userInfo);
		List DutyOPtions = util.getDutyOPtions();
		Map DutyMap = util.getDutyMap();
		List tids = new ArrayList();
		if (TeamList.size()>0) {
			for(int i=0;i<TeamList.size();i++) {
				PracticeDeclareTeammember m = new PracticeDeclareTeammember();
				m = (PracticeDeclareTeammember)TeamList.get(i);
				tids.add((i+1)+"");
				%>
				<tr id=del<%=i+1 %> class=odd>
				<td style="width: 10%">
				<input style="width: 100%" id="Id_t<%=i+1%>" name="Id_t<%=i+1%>" value="<%=m.getId()%>" type="hidden"/>
				<input style="width: 100%" id="Sno_t<%=i+1%>" name="Sno_t<%=i+1%>" value="<%=m.getSno()%>" type="hidden"/><%=m.getSno()%>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="SName_t<%=i+1%>" name="SName_t<%=i+1%>" value="<%=m.getSName()%>" type="hidden"/><%=m.getSName()%>
				</td>
				<td style="width: 10%">
				 <select id="Sex_t<%=i+1%>" name="Sex_t<%=i+1%>" style="width: 100%;display: none;">
				<%=HtmlTool.renderMulSelectOption(sexOptions,""+m.getSex(),"Sex_t"+(i+1)) %>
				</select> 
				<%=sexMap.get(m.getSex())==null?"":sexMap.get(m.getSex()) %>
				<%-- <input style="width: 100%" id="Sex_t<%=m.getId()%>" name="Sex_t<%=m.getId()%>" value="<%=m.getSex()%>"/> --%>
				</td>
				<td style="width: 10%">
				<select id="Academy_t<%=m.getId()%>" name="Academy_t<%=m.getId()%>" style="width: 100%;display: none;">
				<%=HtmlTool.renderMulSelectOption(AcademyNameOptions,""+m.getAcademy(),"Academy_t"+(i+1)) %>
				</select>
				<%=AcademyNameMap.get(m.getAcademy())==null?"":AcademyNameMap.get(m.getAcademy()) %>
				</td>
				<td style="width: 10%">
				<select id="Identity_t<%=m.getId()%>" name="Identity_t<%=m.getId()%>" style="width: 100%;display: none">
				<%=HtmlTool.renderMulSelectOption(IdentityOptions,""+m.getIdentity(),"Identity_t"+(i+1)) %>
				</select>
				<%=IdentityMap.get(m.getIdentity())==null?"":IdentityMap.get(m.getIdentity()) %>
				</td>
				<td style="width: 10%">
				<select id="Grade_t<%=m.getId()%>" name="Grade_t<%=m.getId()%>"  style="width: 100%;display: none">
				<%=HtmlTool.renderMulSelectOption(GradeNameOptions,""+m.getGrade(),"Grade_t"+(i+1)) %>
				</select>
				<%=GradeNameMap.get(m.getGrade())==null?"":GradeNameMap.get(m.getGrade()) %>
				</td>
				<td style="width: 10%">
				<input style="width: 100%" id="Phone_t<%=i+1%>" name="Phone_t<%=(i+1)%>" value="<%=m.getPhone() %>" type="hidden"/><%=m.getPhone() %>
				</td>
				<td style="width: 10%">
				<%-- <select id="Duty_t<%=i+1%>" name="Duty_t<%=i+1%>"  style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+m.getDuty(),"Duty_t"+(i+1)) %>
				</select> --%>
				<%=DutyMap.get(m.getDuty()+"") %>
				</td>
				<%-- <td style='width:10%;'><img  style='cursor:point;' src='../main/images/delete.gif' onclick=javascript:deleteSponsor2('del<%=i+1 %>',<%=i+1 %>) alt=删除  title=删除  border=0></td> --%>
				</tr>
			<%}
		}
		%>
 <input type="hidden" id="Nums" name="Nums" value="<%=tids.size()>0?Tool.join(",",tids):"" %>"/>
	</table>
    <table  id="SName" style="border-collapse: separate;border-spacing: 1px;width:100%;font-size:12px;text-align:center;" cellpadding="1px;" cellspacing="1px;">
	<%
	List sidsList = new ArrayList();
	if (v.getId()!=-1) {
		PracticeDeclareTeammember member = new PracticeDeclareTeammember();		
		List list = new ArrayList();
		list = util.getTeamList(v.getId(),"1",0);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				//}
				member = (PracticeDeclareTeammember)list.get(i);
				sidsList.add(member.getSName()+"");
				%>
				<tr id="deleteSponsor_<%=member.getSName()%>">
				<input id="SName<%=member.getSName()%>" name="SName<%=member.getSName()%>" value="<%=member.getSName()%>" type="hidden"/>
				<td style="width: 10%"><%=member.getSno()%></td>
				<td style="width: 10%"><%=UserCnNameMap.get(member.getSName())==null?"":UserCnNameMap.get(member.getSName()) %></td>
				<td style="width: 10%"><%=sexMap.get(member.getSex())==null?"":sexMap.get(member.getSex()) %></td>
				<td style="width: 10%"><%=AcademyNameMap.get(member.getAcademy())==null?"":AcademyNameMap.get(member.getAcademy()) %></td>
				<td style="width: 10%">本科</td>
				<td style="width: 10%"><%=GradeNameMap.get(member.getGrade())==null?"":GradeNameMap.get(member.getGrade()) %></td>
				<td style="width: 10%"><%=member.getPhone() %></td>
				<td style="width: 10%">
				<%-- <select id="Duty<%=member.getSName()%>" name="Duty<%=member.getSName()%>" style="width: 100%">
				<%=HtmlTool.renderMulSelectOption(DutyOPtions,""+member.getDuty(),"Duty"+member.getSName()) %>
				</select> --%>
				<%=DutyMap.get(member.getDuty()+"") %>
				</td>
				</tr>
			<%}
		}
	}
	%>
	<input id="SId" name="SId" value="<%=Tool.join(",",sidsList)%>" type="hidden"/>
	</table>
    </td>
</tr>
<tr>
	<td align="right" rowspan="3" class="form_label">组队情况</td>
    <td align="left" bgcolor="#ffffff" colspan="5">
    	<p>活动地点、路线：<%=v.getReport12()%></p>
    </td>
</tr>
<tr>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<p>本科学生：<%=v.getReport13()%>人&nbsp;&nbsp;
		硕士研究生：<%=v.getReport14()%>人&nbsp;&nbsp;
		博士研究生：<%=v.getReport15()%>人</p>
	</td>
</tr>
<tr>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<p>活动起止日期：<%=v.getStartTime()%>~<%=v.getEndTime()%>
		&nbsp;&nbsp;&nbsp;&nbsp;活动天数：<%=v.getReport17()%>天</p>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">接收单位对团队活动的评价</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<p><%=v.getReport18() %></p>
		<p>回访联系人：<%=v.getReport19()%>
		&nbsp;&nbsp;&nbsp;&nbsp;回访电话：<%=v.getReport20()%></p>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">团队活动小结</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<%=team.getReport21() %>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">团队主要成绩成果</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<%=team.getReport22() %>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">专题调研、社会调查、科研攻关及科技开发报告情况</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<p>报告题目：<%=v.getReport23()%></p>
		<p>报告类别：<%=v.getReport24()%>
		&nbsp;&nbsp;&nbsp;&nbsp;报告字数：<%=v.getReport25()%></p>
		<p>对地方经济、社会和文化发展或企业成长的实际作用:</p>
		<%=v.getReport26() %>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">指导教师工作总结</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<%=v.getReport27() %>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">主要宣传报道情况</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<%=v.getReport28() %>
		<p>宣传报道数量：<%=v.getReport29() %></p>
	</td>
</tr>
<tr>
	<td align="right" class="form_label">安全工作落实情况总结</td>
	<td align="left" bgcolor="#ffffff" colspan="5">
		<%=v.getReport30() %>
	</td>
</tr>
<%}
%>

<tr id="ClientAttach">
  		<td align="right" class="form_label">附件</td>
  		<td bgcolor="#ffffff" align="left" colspan="5">
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
			    <!-- <div style="color:red">说明：请上传格式为:doc、docx格式文件，文件最大5M</div> -->
			</td>
  		</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
