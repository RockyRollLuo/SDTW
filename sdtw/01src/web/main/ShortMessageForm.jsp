<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.common.HttpTool"%>
<%@page import="com.xietong.software.util.ParamUtils"%>
<%@page import="com.xietong.software.common.HtmlTool"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java"%>
<%--站内信--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ShortMessage.class);
	String msg = (String) request.getAttribute("msg");
	if ((msg != null)) {
		out.print(HtmlTool.msgBox(request, msg));
		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	System.out.println("cmd="+cmd);
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ShortMessage v = (ShortMessage) request.getAttribute("fromBean");
	if (v == null) {
		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
		return;
	}
	log.debug(request.getAttribute("classname") + "Form");
	String[] dickeys = (String[]) request.getAttribute("dickeys");
	String[][] dicvalues = (String[][]) request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i++) {
		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	Map extMaps = (Map) request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List) paras.get(0);
	List forms = (List) paras.get(1);
	urls.addAll((List) paras.get(2));
	forms.addAll((List) paras.get(3));
	
     
	
	String url = Tool.join("&", urls);

	System.out.println(url+"wangzhi");
	UserInfo userInfo = Tool.getUserInfo(request);
	BaseUserCode user = new BaseUserCode();
	int userId;

	if (userInfo == null) {
		out.print(HtmlTool.msgBox(request, "请先登录"));
		return;
	} else {

		user = userInfo.getUserCode();
		userId =user.getId();
		System.out.println("用户ID" + userId);

	}
	InputStream contentStream =v.getContent();
    BufferedReader a = new BufferedReader(new InputStreamReader(contentStream));
    String contentStr ="";
    String content="";
    while ((contentStr = a.readLine()) != null) {
    	content = content.concat(contentStr);  //最后以String的形式得到
    }
    content = content.replaceAll("\r\n", "");
    content = content.replaceAll("\r", "");
    content = content.replaceAll("\n", "");
    content = content.replaceAll("\"", "'");
	
	/*
	if (v.getContent() != null) {
		InputStream inputStr = v.getContent();
		System.out.println("contentStr----------" + v.getId());
		BufferedReader a = new BufferedReader(new InputStreamReader(inputStr));
		String infocontentStr = "";
		while ((infocontentStr = a.readLine()) != null) {
			contentStr = contentStr.concat(infocontentStr);
			//contentStr=a.readLine();
		}
	
		inputStr.close();
	}
	*/
	String back = "";
	if(v.getSendId()==userId&&v.getSmsStyle()==1){
		back = "ShortMessageAction.jsp?shoujian=2&_SmsStyle_=1";
	}
	else{
		back = "ShortMessageAction.jsp?shoujian=3&_SmsStyle_=2";
	}
	
	System.out.println("contentStr----------" + contentStr);
	//默认值定义
	List MsgGradeoptions = (List) request.getAttribute("MsgGradeoptions");
	List MsgPropoptions = (List) request.getAttribute("MsgPropoptions");
	List YesNooptions = (List) request.getAttribute("YesNooptions");
	List UserNameoptions = (List) request.getAttribute("UserNameoptions");
%>
<head>
<title><%=request.getAttribute("describe")%></title>
<jsp:include page="/main/jqueryui.jsp" flush="true" />
<link rel="stylesheet" type="text/css"
	href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
	<script language="JavaScript"
		src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
	<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
	<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
	<script language="JavaScript"
		src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
	<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
	<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>

	<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String) request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[]) request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[]) request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
			}
			//短息提交审核
	  /*       function tableCheck(){
				var ok=true;
	        	var subejct=$("#Subject").val();
	        	var shouxinren=$("#SendId")。val();
	        	var duanxinjibie=$("#MsgGrade").val();
	        	if(subejct=""){
	        		alert("标题不能为空")
	        		ok=false;
	        	}
	        	if(subject.length>25){alert("标题长度不能超过25")}
	        	if (shouxinren==""){alert("收件人不能为空")
	        		ok=false;}
	        	if (duanxinjibie==""){alert("信件级别不能为空")
	        		ok=false;}
	        	return ok;
	        	
	        }
	         */
	        
			function sendmessage(){
				var ok=true;
	        	var subejct=$("#Subject").val();
	        	/*
	        	var shouxinren=$("#SendId")。val();
	        	var duanxinjibie=$("#MsgGrade").val();
	        	if(subejct=""){
	        		alert("标题不能为空")
	        		ok=false;
	        	}
	        	if(subject.length>25){alert("标题长度不能超过25")}
	        	if (shouxinren==""){alert("收件人不能为空")
	        		ok=false;}
	        	if (duanxinjibie==""){alert("信件级别不能为空")
	        		ok=false;} */
	        	if(document.postForm.Subject.value==""){
		 			alert("未添加标题");
		 			return;
		  		   }
		 		if(document.postForm.ReceiveIds.value==""){
		 			alert("未添加接受人");
		 			ok=false;
		  		 }
			  if(ok){
		 		
		  		
					$('#SmsStyle').val(1);;
					document.postForm.submit();
					 alert("发送完毕");
				
		 	}
		
			}	
			 function savemessage(){
					var ok=true;
					if(document.postForm.Subject.value==""){
			 			alert("未添加标题");
			 			ok=false;
			  		   }
			 		if(document.postForm.ReceiveIds.value==""){
			 			alert("未添加接受人");
			 			ok=false;
			  		 }
		           
				 if(ok){
			
				 $('#SmsStyle').val(2);
				 document.postForm.submit(); 
				 alert("保存草稿成功")
				 
				 } 
			   }
			function fanhui() {
				document.postForm.cmd.value="update";
				$('#IfSee').val(1);
				
				document.postForm.submit();
				
			}
		
			function sendmessage1(){
				var ok=true;
	        /* 	var subejct=$("#Subject").val();
	        	var shouxinren=$("#SendId")。val();
	        	var duanxinjibie=$("#MsgGrade").val();
	        	if(subejct=""){
	        		alert("标题不能为空")
	        		ok=false;
	        	}
	        	if(subject.length>25){alert("标题长度不能超过25")}
	        	if (shouxinren==""){alert("收件人不能为空")
	        		ok=false;}
	        	if (duanxinjibie==""){alert("信件级别不能为空")
	        		
	        		ok=false;} */
				if(document.postForm.Subject.value==""){
		 			alert("未添加标题");
		 			return;
		  		   }
		 		if(document.postForm.ReceiveIds.value==""){
		 			alert("未添加接收人");
		 			return;
		  		 }
				
				
				$('#SmsStyle').val(1);
				document.postForm.submit();
		       
				
				
		  	
		  
			   alert("发送完毕");
				
			}
			
			
			function jieshouren(){
				//location.href="BaseUserCodeAction.jsp";
			openWindow("BaseUserCodeAction.jsp?values="+$('#ReceiveIds').val(),"703,400")
			}
          function setRole(name,id){
        	  var id1=$('#ReceiveIds').val()+""+id;
        	  $('#ReceiveIds').val(id);
        	  var name1=$('#uid').val()+name;
        	  if(name.startsWith(",")){
        	  name=name.substring(1,name.length)
        	  }
        	  $('#uid').val(name);
          }
          
		</script>
</head>
<body onload="init();">
	

	<%
		if (v.getId()!=-1) {
	%>
	<div class="browsetitle">
		<div class="browsetitleleft">
			<div class="browsetitle001">站内信</div>
			<div class="browsetitle002"><%=XtUtil.getSpell("站内信")%></div>
		</div>
		<div class="browsetitleright">
			<div class="anniulist2">
				<ul>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
					<li><a href="#" onclick="history.go(-1);">返回</a></li>

				</ul>
			</div>
		</div>
	</div>
	<div id="errorDiv" style="color: red; font-weight: bold"></div>
	<div class="browsetable" id="form">
		<form action="<%=request.getAttribute("classname")%>Action.jsp"
			method="post" name="postForm" id="postForm">
			<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
					<table width="100%" border="0" align="center" cellpadding="4"
						cellspacing="1">
						<input type="hidden" name="Id" value="<%=v.getId()%>">
							<tr>
								<td align="right" class="form_label">短消息标题</td>
								<td align="left" bgcolor="#ffffff"><textarea
										style="margin:" name="Subject" id="Subject" cols="40" rows="2"><%=v.getSubject()%></textarea>
									
							</tr>
							<tr>
							
							<td align="right" class="form_label">接收人</td>
									<td align="left" bgcolor="#ffffff"><input type="text"
										id="SendId" name="SendId" value="<%=CEditConst.getUserCnNameMap(userInfo).get(v.getReceiveIds())%>" /></td>
								<tr/>
								
									<td style="display: none" align="right" class="form_label">短消息收藏时间</td>
									<td style="display: none" align="left" bgcolor="#ffffff">
										<input name="CollectDate" id="CollectDate" size="0"
										value="<%=Tool.stringOfDateTime(v.getCollectDate())%>">
									</td>
									<td align="right" class="form_label">短消息保存时间</td>
									<td align="left" bgcolor="#ffffff"><input name="SaveDate"
										id="SaveDate" size="0"
										value="<%=Tool.stringOfDateTime(v.getSaveDate())%>"></td>
								</tr>

                                

								<tr style="display: none">
								  <input type="hidden"
										 name="ReceiveIds" id="ReceiveIds"
										value="<%=v.getReceiveIds()%>" />
									<td  align="right" class="form_label">短消息发送时间</td>
									<td align="left" bgcolor="#ffffff"><input name="SendDate"
										id="SendDate" size="0"
										value="<%=new Date()%>"></td>
									<td align="right" class="form_label">短消息级别</td>
									<td align="left"
										bgcolor="#ffffff">
										<input  name="SmsStyle" id="SmsStyle"      />
									</td>
								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">相关附件ids</td>
									<td align="left" bgcolor="#ffffff"><textarea
											name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAttachIds()%></textarea>
									</td>
								</tr>
								<tr style="display: none">
								
								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">RemindSys</td>
									<td align="left" bgcolor="#ffffff"></td>
								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">是否可用</td>
									<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
									</td>
									<td align="right" class="form_label">短消息级别</td>
									<td align="left" bgcolor="#ffffff"><input name="SmsStyle"
										id="SmsStyle" type="text"  value=<%=v.getSmsStyle() %>/></td>
								</tr>
								<tr>
									<td align="right" class="form_label">短消息内容</td>
									<td align="left" colspan="3" bgcolor="#ffffff"><textarea
											name="RemUrl" id="RemUrl" style="width: 100%;" rows="8"><%=v.getRemUrl()%></textarea>
									</td>
								</tr>

								<tr style="display: none">

									<td align="right" class="form_label">是否查看</td>
									<%-- 	<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getIfSee(), "IfSee", "1")%> --%>
									<input type="hidden" id="IfSee" name="IfSee" value="0" />
									</td>
									<td align="right" class="form_label">是否回执</td>
									<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getReceipt(), "Receipt", "-1")%>
									</td>
								</tr>
								<input type="hidden" name="RemindType"
									value="<%=v.getRemindType()%>"> <input type="hidden"
									name="RemindSys" />
					</table>
		</form>
	</div>
	<%
		} else {
	%>
	<div class="browsetitle">
		<div class="browsetitleleft">
			<div class="browsetitle001">站内信</div>
			<div class="browsetitle002"><%=XtUtil.getSpell("站内信")%></div>
		</div>
		<div class="browsetitleright">
			<div class="anniulist2">
				<ul>
					<li><a
						href="<%=back %>" onclick="fanhui();">返回</a></li>
					<li><a href="" onclick="savemessage()">存入草稿</a></li>
					<li><a href="" onclick="sendmessage()">发送信息</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div id="errorDiv" style="color: red; font-weight: bold"></div>
	<div class="browsetable" id="form">
		<form action="<%=request.getAttribute("classname")%>Action.jsp"
			method="post" name="postForm" id="postForm">
			<input type="hidden" name="cmd" value="<%=cmd%>"> <input
				type="hidden" name="page" value="<%=currpage%>"> <%=Tool.join("\n", forms)%>
					<table width="100%" border="0" align="center" cellpadding="4"
						cellspacing="1">
						<input type="hidden" name="Id" value="<%=v.getId()%>">
							<tr>
								<td calign="right" class="form_label">短消息标题</td>
								<td colspan="3" align="left" bgcolor="#ffffff"><textarea
										style="margin:" name="Subject" id="Subject" cols="40" rows="2"><%=v.getSubject()%></textarea>
									<td style="display: none" align="right" class="form_label">发送人</td>
									<td style="display: none" align="left" bgcolor="#ffffff">
										<input type="text" name="SendId" id="SendId"
										value="<%=userId%>" />

								</td></td>
							</tr>
							<tr>
								<tr style="display: none">
									<td align="right" class="form_label">短消息发送时间</td>
									<td align="left" bgcolor="#ffffff"><input name="SendDate"
										id="SendDate" size="0"
										value="<%=Tool.stringOfDateTime(new Date())%>"></td>
									<td style="display: none" align="right" class="form_label">短消息收藏时间</td>
									<td style="display: none" align="left" bgcolor="#ffffff">
										<input name="CollectDate" id="CollectDate" size="0"
										value="<%=Tool.stringOfDateTime(v.getCollectDate())%>">
									</td>
									<td align="right" class="form_label">短消息保存时间</td>
									<td align="left" bgcolor="#ffffff"><input name="SaveDate"
										id="SaveDate" size="0"
										value="<%=Tool.stringOfDateTime(new Date())%>"></td>
								</tr>
								<tr>
									<td align="right" class="form_label">短消息级别</td>
									<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(MsgGradeoptions, "" + v.getMsgGrade(), "MsgGrade", "-1")%>

									</td>

									<td align="right" class="form_label">接收人</td>
									<td align="left" bgcolor="#ffffff"><textarea name="uid"
											id="uid" cols="40" rows="2"><%=v.getReceiveIds()%></textarea>
										<input type="button" value="添加" onclick="jieshouren()" /></td>

								</tr>


								<tr style="display: none">

									<td align="right" class="form_label">是否查看</td>
									<%-- 	<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getIfSee(), "IfSee", "1")%> --%>
									<input type="hidden" name="IfSee" id="IfSee" value="0" />
									</td>
									<td align="right" class="form_label">是否回执</td>
									<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getReceipt(), "Receipt", "-1")%>
									</td>
								</tr>

								<tr style="display: none">
									<td align="right" class="form_label">短消息级别</td>
									<td align="left" bgcolor="#ffffff"><input name="SmsStyle"
										id="SmsStyle" type="text" /> <%=HtmlTool.renderSelect(MsgPropoptions, "" + v.getSmsStyle(), "SmsStyle", "-1")%>
									</td>
								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">相关附件ids</td>
									<td align="left" bgcolor="#ffffff"><textarea
											name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAttachIds()%></textarea>
									</td>
								</tr>
								<tr style="display: none">
								

								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">RemindSys</td>
									<td align="left" bgcolor="#ffffff"></td>
								</tr>
								<tr style="display: none">
									<td align="right" class="form_label">是否可用</td>
									<td align="left" bgcolor="#ffffff"><%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsEnable(), "IsEnable", "-1")%>
									</td>
								</tr>
								<tr>
									<td align="right" class="form_label">短消息内容</td>
									<td align="left" colspan="3" bgcolor="#ffffff"><textarea
											name="RemUrl" id="RemUrl" style="width: 100%;" rows="8"><%=v.getRemUrl()%></textarea>
									</td>
								</tr>

								<input type="hidden" name="RemindType"
									value="<%=v.getRemindType()%>"> <input type="hidden"
									name="RemindSys" /> <input type="hidden" name="ReceiveIds"
									id="ReceiveIds" />
					</table>
		</form>


	</div>

	<%
		}
	%>
</body>
</html>
