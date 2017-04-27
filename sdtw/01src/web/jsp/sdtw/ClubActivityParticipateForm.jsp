<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社团活动报名--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ClubActivityParticipate.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ClubActivityParticipate v = (ClubActivityParticipate)request.getAttribute("fromBean");
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
List ClubNameoptions = (List)request.getAttribute("ClubNameoptions");
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
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">社团活动报名</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社团活动报名") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ClubActivityParticipateAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
<input type="hidden" name="Clubid" value="<%=v.getClubid()%>">
                    												<tr>
                    													<td align="right" class="form_label">社团名称</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ClubNameoptions, v.getClubname(), "Clubname", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Activityid" id="Activityid" size="45" maxsize="45" value="<%=v.getActivityid()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Activityname" id="Activityname" cols="40" rows="2"><%=v.getActivityname()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sno" id="Sno" size="45" maxsize="45" value="<%=v.getSno()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Sname" id="Sname" size="45" maxsize="45" value="<%=v.getSname()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Applytime" id="Applytime" size="0" value="<%=Tool.stringOfDateTime(v.getApplytime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Checktime" id="Checktime" size="0" value="<%=Tool.stringOfDateTime(v.getChecktime())%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Checkaccount" id="Checkaccount" size="45" maxsize="45" value="<%=v.getCheckaccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Checkflag" id="Checkflag" value="<%=v.getCheckflag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">issafe</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Issafe" id="Issafe" value="<%=v.getIssafe()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">交通工具</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Traffictool" id="Traffictool" cols="40" rows="2"><%=v.getTraffictool()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动程序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Activityprocedure" id="Activityprocedure" cols="40" rows="2"><%=v.getActivityprocedure()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">安全保障措施</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Activitysecurity" id="Activitysecurity" cols="40" rows="2"><%=v.getActivitysecurity()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否将本次活动的详细情况告知了父母</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Istell" id="Istell" size="10" maxsize="10" value="<%=v.getIstell()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">和父母商议是否购买保险</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Isbuy" id="Isbuy" size="10" maxsize="10" value="<%=v.getIsbuy()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">告知父母的方式(面谈/电话/信件)</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Tellway" id="Tellway" size="10" maxsize="10" value="<%=v.getTellway()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">父母是否知道这次活动是自愿参加</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Iswilling" id="Iswilling" size="10" maxsize="10" value="<%=v.getIswilling()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">父母是否知道这次活动是由学生社团自发组织</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Isvoluntary" id="Isvoluntary" size="10" maxsize="10" value="<%=v.getIsvoluntary()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">如万一在活动中发生任何意外情况，父母是否同意责任自负</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Isresponsible" id="Isresponsible" size="10" maxsize="10" value="<%=v.getIsresponsible()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">safetime</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Safetime" id="Safetime" size="0" value="<%=Tool.stringOfDateTime(v.getSafetime())%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
