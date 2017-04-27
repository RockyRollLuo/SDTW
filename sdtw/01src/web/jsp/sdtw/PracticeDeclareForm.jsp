<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--社会实践项目报名表-学生素质拓展培养认证单-实践服务--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(PracticeDeclare.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	PracticeDeclare v = (PracticeDeclare)request.getAttribute("fromBean");
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
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
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
				<div class="browsetitle001">社会实践项目报名表-学生素质拓展培养认证单-实践服务</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("社会实践项目报名表-学生素质拓展培养认证单-实践服务") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="PracticeDeclareAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    												<tr>
                    													<td align="right" class="form_label">类别</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Type" id="Type" value="<%=v.getType()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">立项表id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="DeclareId" id="DeclareId" value="<%=v.getDeclareId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院设置荣誉</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyHonour" id="XyHonour" size="45" maxsize="45" value="<%=v.getXyHonour()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">提交状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Submitflag" id="Submitflag" value="<%=v.getSubmitflag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyCheckFlag" id="XyCheckFlag" value="<%=v.getXyCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加用户</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addaccount" id="Addaccount" size="45" maxsize="45" value="<%=v.getAddaccount()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="45" maxsize="45" value="<%=v.getAddtime()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">课题名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare1" id="Declare1" size="45" maxsize="45" value="<%=v.getDeclare1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare2" id="Declare2" size="45" maxsize="45" value="<%=v.getDeclare2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实践主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare5" id="Declare5" size="45" maxsize="45" value="<%=v.getDeclare5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare8" id="Declare8" size="45" maxsize="45" value="<%=v.getDeclare8()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接受单位（个人）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare6" id="Declare6" size="45" maxsize="45" value="<%=v.getDeclare6()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接收单位负责人或接收个人姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare7" id="Declare7" size="45" maxsize="45" value="<%=v.getDeclare7()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare9" id="Declare9" size="45" maxsize="45" value="<%=v.getDeclare9()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接受单位个人简介</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare10" id="Declare10" cols="40" rows="2"><%=v.getDeclare10()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动计划主题</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare11" id="Declare11" cols="40" rows="2"><%=v.getDeclare11()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动计划背景及意义</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare12" id="Declare12" cols="40" rows="2"><%=v.getDeclare12()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare13" id="Declare13" cols="40" rows="2"><%=v.getDeclare13()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">活动地点及路线</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare14" id="Declare14" cols="40" rows="2"><%=v.getDeclare14()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目预期成果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare15" id="Declare15" cols="40" rows="2"><%=v.getDeclare15()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">宣讲会</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare16" id="Declare16" size="45" maxsize="45" value="<%=v.getDeclare16()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">讲座</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare17" id="Declare17" size="45" maxsize="45" value="<%=v.getDeclare17()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业培训</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare18" id="Declare18" size="45" maxsize="45" value="<%=v.getDeclare18()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">调研报告</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare19" id="Declare19" size="45" maxsize="45" value="<%=v.getDeclare19()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">支教受益人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare20" id="Declare20" size="45" maxsize="45" value="<%=v.getDeclare20()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">文体演出</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare21" id="Declare21" size="45" maxsize="45" value="<%=v.getDeclare21()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">捐赠（价值）</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare22" id="Declare22" size="45" maxsize="45" value="<%=v.getDeclare22()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">咨询场次</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare23" id="Declare23" size="45" maxsize="45" value="<%=v.getDeclare23()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否建立实践基地</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare24" id="Declare24" size="45" maxsize="45" value="<%=v.getDeclare24()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其它实践成果</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare25" id="Declare25" size="45" maxsize="45" value="<%=v.getDeclare25()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实践中团队是否拍摄DV</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare26" id="Declare26" size="45" maxsize="45" value="<%=v.getDeclare26()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">前期准备工作</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare27" id="Declare27" cols="40" rows="2"><%=v.getDeclare27()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">新闻媒体联系报道</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare28" id="Declare28" cols="40" rows="2"><%=v.getDeclare28()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">实践期间完成的任务、详细活动计划及日程安排</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare29" id="Declare29" cols="40" rows="2"><%=v.getDeclare29()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队安全应急预案</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare30" id="Declare30" cols="40" rows="2"><%=v.getDeclare30()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare31" id="Declare31" size="45" maxsize="45" value="<%=v.getDeclare31()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否随从队伍</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare32" id="Declare32" size="45" maxsize="45" value="<%=v.getDeclare32()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">工作单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare33" id="Declare33" size="45" maxsize="45" value="<%=v.getDeclare33()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">职务职称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare34" id="Declare34" size="45" maxsize="45" value="<%=v.getDeclare34()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare35" id="Declare35" size="45" maxsize="45" value="<%=v.getDeclare35()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare36" id="Declare36" size="45" maxsize="45" value="<%=v.getDeclare36()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">指导老师邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare37" id="Declare37" size="45" maxsize="45" value="<%=v.getDeclare37()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare38" id="Declare38" size="45" maxsize="45" value="<%=v.getDeclare38()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队工作单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare39" id="Declare39" size="45" maxsize="45" value="<%=v.getDeclare39()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队职务名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare40" id="Declare40" size="45" maxsize="45" value="<%=v.getDeclare40()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare41" id="Declare41" size="45" maxsize="45" value="<%=v.getDeclare41()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare42" id="Declare42" size="45" maxsize="45" value="<%=v.getDeclare42()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare43" id="Declare43" size="45" maxsize="45" value="<%=v.getDeclare43()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare44" id="Declare44" size="45" maxsize="45" value="<%=v.getDeclare44()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2学院</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare45" id="Declare45" size="45" maxsize="45" value="<%=v.getDeclare45()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2专业</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare46" id="Declare46" size="45" maxsize="45" value="<%=v.getDeclare46()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2年级</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare47" id="Declare47" size="45" maxsize="45" value="<%=v.getDeclare47()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2学历</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare48" id="Declare48" size="45" maxsize="45" value="<%=v.getDeclare48()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare49" id="Declare49" size="45" maxsize="45" value="<%=v.getDeclare49()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2手机</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare50" id="Declare50" size="45" maxsize="45" value="<%=v.getDeclare50()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">领队2邮箱</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare51" id="Declare51" size="45" maxsize="45" value="<%=v.getDeclare51()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">总人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare52" id="Declare52" size="45" maxsize="45" value="<%=v.getDeclare52()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">专业老师</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare53" id="Declare53" size="45" maxsize="45" value="<%=v.getDeclare53()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">政工干部</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare54" id="Declare54" size="45" maxsize="45" value="<%=v.getDeclare54()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">本专科学生</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare55" id="Declare55" size="45" maxsize="45" value="<%=v.getDeclare55()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">研究生</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare56" id="Declare56" size="45" maxsize="45" value="<%=v.getDeclare56()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">交通费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare57" id="Declare57" size="45" maxsize="45" value="<%=v.getDeclare57()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">住宿费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare58" id="Declare58" size="45" maxsize="45" value="<%=v.getDeclare58()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">其他费用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Declare59" id="Declare59" cols="40" rows="2"><%=v.getDeclare59()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">费用总计</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare60" id="Declare60" size="45" maxsize="45" value="<%=v.getDeclare60()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队自筹费用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare61" id="Declare61" size="45" maxsize="45" value="<%=v.getDeclare61()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请学校立项经费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare62" id="Declare62" size="45" maxsize="45" value="<%=v.getDeclare62()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学校配套经费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare63" id="Declare63" size="45" maxsize="45" value="<%=v.getDeclare63()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">接收单位（个人）支持经费</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Declare64" id="Declare64" size="45" maxsize="45" value="<%=v.getDeclare64()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">附件</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddFileList" id="AddFileList" size="45" maxsize="45" value="<%=v.getAddFileList()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark1" id="Remark1" size="45" maxsize="45" value="<%=v.getRemark1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark2" id="Remark2" size="45" maxsize="45" value="<%=v.getRemark2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备用</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Remark3" id="Remark3" size="45" maxsize="45" value="<%=v.getRemark3()%>">
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
