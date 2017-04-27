<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--参加山大创库作品表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ChuangkuDeclare.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ChuangkuDeclare v = (ChuangkuDeclare)request.getAttribute("fromBean");
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
List CkProjectGroupoptions = (List)request.getAttribute("CkProjectGroupoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List CkProjectTypeoptions = (List)request.getAttribute("CkProjectTypeoptions");
List Auditoptions = (List)request.getAttribute("Auditoptions");
List CkProjectStageoptions = (List)request.getAttribute("CkProjectStageoptions");
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
				<div class="browsetitle001">参加山大创库作品表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("参加山大创库作品表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="ChuangkuDeclareAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">参与的创库通知的id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CkId" id="CkId" value="<%=v.getCkId()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">上传文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AddFilelist" id="AddFilelist" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">添加描述</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%=v.getAddAccount()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">
                    												<tr>
                    													<td align="right" class="form_label">审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(Auditoptions, "" + v.getCheckFlag(), "CheckFlag", "0")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人姓名</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cdp1" id="Cdp1" size="45" maxsize="45" value="<%=v.getCdp1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getCdp2(), "Cdp2", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人学号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cdp3" id="Cdp3" size="45" maxsize="45" value="<%=v.getCdp3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cdp4" id="Cdp4" size="45" maxsize="45" value="<%=v.getCdp4()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd1" id="Cd1" size="45" maxsize="45" value="<%=v.getCd1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目分类</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(CkProjectTypeoptions, v.getCd2(), "Cd2", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目分组</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(CkProjectGroupoptions, v.getCd3(), "Cd3", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">技术可行性分析</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Cd4" id="Cd4" cols="40" rows="2"><%=v.getCd4()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">市场可行性分析</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Cd5" id="Cd5" cols="40" rows="2"><%=v.getCd5()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目推进时间分析</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Cd6" id="Cd6" cols="40" rows="2"><%=v.getCd6()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">项目阶段</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(CkProjectStageoptions, v.getCd7(), "Cd7", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否有社会资金</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd8" id="Cd8" size="45" maxsize="45" value="<%=v.getCd8()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">社会资金额度</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd9" id="Cd9" size="45" maxsize="45" value="<%=v.getCd9()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">计划注册资本金额</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd10" id="Cd10" size="45" maxsize="45" value="<%=v.getCd10()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">创业团队自有资金</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd11" id="Cd11" size="45" maxsize="45" value="<%=v.getCd11()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团队已经经营该项目时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd12" id="Cd12" size="45" maxsize="45" value="<%=v.getCd12()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">盈利情况</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Cd13" id="Cd13" size="45" maxsize="45" value="<%=v.getCd13()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Cd14" id="Cd14" cols="40" rows="2"><%=v.getCd14()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
