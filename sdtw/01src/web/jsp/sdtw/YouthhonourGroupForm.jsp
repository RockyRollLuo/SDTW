<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--五四评比表彰团体申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="com.xietong.software.base.XtUtil"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(YouthhonourGroup.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	YouthhonourGroup v = (YouthhonourGroup)request.getAttribute("fromBean");
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
				<div class="browsetitle001">五四评比表彰团体申请表</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("五四评比表彰团体申请表") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="YouthhonourGroupAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
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
                    													<td align="right" class="form_label">学年</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="SchoolYear" id="SchoolYear" size="45" maxsize="45" value="<%=v.getSchoolYear()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">申请表类型</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Type" id="Type" value="<%=v.getType()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="Addaccount" value="<%=v.getAddaccount()%>">
<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>">
                    												<tr>
                    													<td align="right" class="form_label">学院审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="AyCheckFlag" id="AyCheckFlag" value="<%=v.getAyCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">是否可修改标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyFlag" id="ModifyFlag" value="<%=v.getModifyFlag()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">学院提交标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="XyReport" id="XyReport" value="<%=v.getXyReport()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">团委发布标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TwReport" id="TwReport" value="<%=v.getTwReport()%>">
                    													</td>
													  				</tr>
<input type="hidden" name="XyCheckDate" value="<%=v.getXyCheckDate()%>">
<input type="hidden" name="TwCheckDate" value="<%=v.getTwCheckDate()%>">
                    												<tr>
                    													<td align="right" class="form_label">所属单位</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getBelongAcademy(), "BelongAcademy", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val1" id="Val1" size="45" maxsize="45" value="<%=v.getVal1()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va2</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val2" id="Val2" size="45" maxsize="45" value="<%=v.getVal2()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va3</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val3" id="Val3" size="45" maxsize="45" value="<%=v.getVal3()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va4</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val4" id="Val4" size="45" maxsize="45" value="<%=v.getVal4()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va5</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val5" id="Val5" size="45" maxsize="45" value="<%=v.getVal5()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va6</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val6" id="Val6" size="45" maxsize="45" value="<%=v.getVal6()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va7</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val7" id="Val7" size="45" maxsize="45" value="<%=v.getVal7()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va8</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val8" id="Val8" size="45" maxsize="45" value="<%=v.getVal8()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va9</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val9" id="Val9" size="45" maxsize="45" value="<%=v.getVal9()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va10</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val10" id="Val10" size="45" maxsize="45" value="<%=v.getVal10()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va11</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val11" id="Val11" size="45" maxsize="45" value="<%=v.getVal11()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va12</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val12" id="Val12" size="45" maxsize="45" value="<%=v.getVal12()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va13</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val13" id="Val13" size="45" maxsize="45" value="<%=v.getVal13()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va14</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val14" id="Val14" size="45" maxsize="45" value="<%=v.getVal14()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va15</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val15" id="Val15" size="45" maxsize="45" value="<%=v.getVal15()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va16</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val16" id="Val16" size="45" maxsize="45" value="<%=v.getVal16()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va17</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val17" id="Val17" size="45" maxsize="45" value="<%=v.getVal17()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va18</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val18" id="Val18" size="45" maxsize="45" value="<%=v.getVal18()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va19</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val19" id="Val19" size="45" maxsize="45" value="<%=v.getVal19()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">va20</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Val20" id="Val20" size="45" maxsize="45" value="<%=v.getVal20()%>">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">text1</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text1" id="Text1" cols="40" rows="2"><%=v.getText1()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">text2</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text2" id="Text2" cols="40" rows="2"><%=v.getText2()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">text3</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text3" id="Text3" cols="40" rows="2"><%=v.getText3()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">text4</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="Text4" id="Text4" cols="40" rows="2"><%=v.getText4()%></textarea>
                    													</td>
													  				</tr>
                    											</table>
			</form>
		</div>
	</body>
</html>
