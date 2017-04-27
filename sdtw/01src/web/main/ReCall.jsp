<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.sdfz.XtUtil"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--短消息信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.xtoa.*,com.xietong.software.xtoa.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.xtoa.main.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="com.xietong.software.xtoa.main.db.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="ueditor" uri="http://sdxietong.com" %> 
<%@ include file="../js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(ShortMessage.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	
	UserCode usercode=new UserCode();
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	ShortMessage v = (ShortMessage)request.getAttribute("fromBean");
	if (v == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	
   int recallid=ParamUtils.getIntParameter(request,"recallid",-1);
	 v=v.getById(recallid);
	 v.setIfSee(1);
	 v.update();
	 v.setSendDate(new Date());
	 v.setSaveDate(new Date());
	usercode=usercode.getById(v.getSendId());
	CShortMessage cm=new CShortMessage(request);
    String Content="";
    Content="===内容:<br>"+cm.getNoWordContent(recallid)+"<br>=========发送人："+usercode.getCnName()+"<br>";
	
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
   int userId = userInfo.getUserCode().getId();
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}

	List YesNooptions = (List)request.getAttribute("YesNooptions");
	List UserNameoptions = (List)request.getAttribute("UserNameoptions");
	List MsgPropoptions = (List)request.getAttribute("MsgPropoptions");
	List MsgGradeoptions = (List)request.getAttribute("MsgGradeoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/comjs.jsp" />
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css"/>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/main.js"></script>
		<script src="<%=Tool.getUserInfo(request).getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script src="<%=HeadConst.apache_url%>/main/js/xmlHttp.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
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
			var allowType = {".gif":"", ".jpg":""};
					
function uploadOtherAttatch(){//上传其他附件
    $("#load1")
    .ajaxStart(function(){
        $(this).show();
    })
    .ajaxComplete(function(){
        $(this).hide();
    });
    $.ajaxFileUpload
    (
        {
            url:'<%=request.getAttribute("classname")%>Action.jsp?cmd=otherattach',
            secureuri:false,
            fileElementId:'OtherAttach',
            dataType: 'json',
            success: function (data, status)
            {
                if(typeof(data.error) != 'undefined')
                {
                    if(data.error != '')
                    {                    
                        alert(data.error);
                    }else
                    {
                    // alert(document.postForm.AttachIds.value);
                        if(document.postForm.AttachIds.value==""){
                        	var be = data.url.indexOf("=");
                        	var en = data.url.lastIndexOf("/");
                        	document.postForm.AttachIds.value = data.url.substring(be+1,en);
                        }else{
                        	var be = data.url.indexOf("=");
                        	var en = data.url.lastIndexOf("/");
                        	document.postForm.AttachIds.value += ","+data.url.substring(be+1,en);
                        }
                        var table = document.getElementById('ShowFiles');
                        var num = table.rows.length;
                        var row = table.insertRow(num);
                        var filename = data.url.replace(/.*(\/|\\)/, "");
                       
                        var cell = row.insertCell(0);
                        <%
                        	if(cmd.equals("update")){
                        %>
		                        row.id = 'tempnew' + filename;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("tempnew'+filename+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/>';
                        <%
                        	}else{
                        %>
		                        row.id = filename;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/>';
                        <%
                        	}
                        %>
                    }
                }
            },
            error: function (data, status, e)
            {
                alert("上传文件失败，请重新上传！");
            }
        }
    )
}  

/*
上传文档格式过滤
*/
function checkDocType(){//上传文档格式过滤
	var file=document.getElementById('OtherAttach').value;
	if(file){
		var allowType = {"doc":"", "xls":""};
		var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
		var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';//jquery获得后缀名
		if((fileExt+"").toLowerCase() in allowType){
			uploadOtherAttatch();
		}
		else{
			alert("上传文件格式不符合要求，请重新选择！");
		}
	}
	return false;
}
function checkFile(){//过滤重复上传附件
	var file=document.getElementById('OtherAttach').value;
	if(file){
		var filename = file.replace(/.*(\/|\\)/, "");
		if(document.postForm.AttachIds.value.indexOf(filename)!=-1){
			alert('上传附件名相同，请修改名称后再上传!');
		}
		else{	
			uploadOtherAttatch();
		}
	}
	return false;
}
function deleteUpdateFile(name,id){//删除修改时上传附件
	if(confirm('是否确定删除？')){
		$.ajax({
		    url:"<%=request.getAttribute("classname")%>Action.jsp?cmd=delAttach&did="+id,
			type:"post",
			dataType:"json",
			beforeSend:function(){
				$("#load1").show();
			},
		success:function(data, status, e){
	        	if(typeof(data.error) != 'undefined'){
                    if(data.error != '')
                    {
                        alert(data.error);
                    }else
                    {
                    	$("#load1").hide();
        				var row = document.getElementById(name);
        				for(var i=0;i<row.cells.length;i++){
        					row.deleteCell(i);
        				}
        				var files = document.postForm.AttachIds.value;
        				//alert(files+" "+id+" "+files.indexOf(id))
        				if(files.indexOf(id)!=-1){
        					//替换删掉的附件id
        					files = ","+files+",";
        					files = files.replace(","+id+",",',');
        					//没有附件的情况
        					if(files.indexOf(",")==files.lastIndexOf(","))
        						files = "";
        					else{
        						files = files.substring(1,files.length-1);
        					}
        					document.postForm.AttachIds.value = files;
        				}
                    }
                }
             },
            error: function (data, status, e){
            	$("#load1").hide();
                alert("删除文件失败，请重新上传！");
            }
		});
	}
	return false;
}

function deleteFile(id){//删除创建时上传附件
	var row = document.getElementById(id);
	for(var i=0;i<row.cells.length;i++){
		row.deleteCell(i);
	}
	var files = document.postForm.AttachIds.value;
	<%
		if(cmd.equals("update")){   //区分原来附件和刚上传附件重名的情况%> 
			var temp = '|/upload/frequency/'+id.replace('tempnew','');
			files = files.replace(temp,'');
	<%
		}else{
	%>
			files = files.replace('|/upload/frequency/'+id,'');
	<%
		}	
	%>
	document.postForm.AttachIds.value = files;
	return false;
}

function savemessage(){
document.postForm.SmsStyle.value=1;
document.postForm.submit();
}
function sendmessage(){
 if(document.postForm.Subject.value==""){
  document.postForm.Subject.value="未添加标题"
  }
if(document.postForm.SmsStyle.value==1){
document.postForm.cmd.value="update";
document.postForm.SmsStyle.value=2;
document.postForm.submit();
}else{ 
   if(document.postForm.ReceiveId.value==""){
   alert("接收人不能为空");
   }else{
document.postForm.SmsStyle.value=2;
document.postForm.submit();
  }
 }
}

function sendmessage1(){
 if(document.postForm.Subject.value==""){
  document.postForm.Subject.value="未添加标题"
  }
if(document.postForm.SmsStyle.value==1){
document.postForm.cmd.value="update";
document.postForm.SmsStyle.value=2;
document.postForm.submit();
}else{ 
   if(document.postForm.ReceiveId.value==""){
   alert("接收人不能为空");
   }else{
document.postForm.SmsStyle.value=2;
document.postForm.submit();
alert("发送完毕");
window.close();
  }
 }
}

//function receiveId(){
//openWindow("<%=HeadConst.root_url_path%>/main/common/ChoiceAction.jsp?cmd=SendMessage","600,400","1");
//}
function choice(name)
			{
			    var dic = {"ReceiveIds": "OrgDeptUser", "RoleOwner": "OrgRole", "GroupOwner": "OrgGroup", "FormFlow": "FormFlow","FormFlow2":"FormFlow"};
			    if (name == "FormFlow"){
			        openWindow("<%=HeadConst.root_url_path%>/main/common/ChoiceAction.jsp?_OrgId_=" + postForm.OrgId.value + "&cmd=" + dic[name] , "600,500");

			    }
			    else if (name == "FormFlow2"){
			        openWindow("<%=HeadConst.root_url_path%>/main/common/ChoiceAction.jsp?_OrgId_=<%=HeadConst.SDUNICOMID%>" + "&cmd=" + dic[name] , "600,500");

			    }else{			  
			        openWindow("<%=HeadConst.root_url_path%>/main/common/ChoiceAction.jsp?type=1&id=" + 1 + "&cmd=" + dic[name] + "&checked_ids=" + document.postForm[name].value, "600,500");
			    }
			}
//定义当前处理人
			function getDialogReturn(rtn){
			    var getChecked = function(items, id, name) {
			        var ids = [];
			        var names = [];
			        var j = 0;
			        for (var i in items) {
			            if (items[i].checked == "1") {
			                ids[j] = items[i][id];
			                names[j] = items[i][name];
			                j ++;
			            }
			        }
			        return {"ids": ids, "names": names};
			    };
			    if (rtn.name == "OrgDeptUser") {
			        var checkedDic = getChecked(rtn.items, 'id', 'cnname');
			        document.postForm.ReceiveIds.value = checkedDic.ids.join(",");
			        document.getElementById("ReceiveId").value = checkedDic.names.join(",");
			        return;
			    }
			    if (rtn.name == "OrgRole") {
			        var checkedDic = getChecked(rtn.items, 'id', 'name');
			        document.postForm.RoleOwner.value = checkedDic.ids.join(",");
			        document.getElementById("RoleOwnerNames").value = checkedDic.names.join(",");
			        return;
			    }
			    if (rtn.name == "OrgGroup") {
			        var checkedDic = getChecked(rtn.items, 'id', 'name');
			        document.postForm.GroupOwner.value = checkedDic.ids.join(",");
			        document.getElementById("GroupOwnerNames").value = checkedDic.names.join(",");
			        return;
			    }
			    //showObject(rtn);
			    if (rtn.name == "FormFlow") {
			        var checkedDic = getChecked(rtn.items, 'id', 'name');
			        document.postForm.s_flowid.value =  rtn.item.id;
			        //document.getElementById("GroupOwnerNames").value = checkedDic.names.join(",");
			        document.postForm.submit();
			    }
			}	
		</script>
	    <link href="../images/skin/blue/css.css" rel="stylesheet" type="text/css" />
	</head>
	<body onload="init();">

	   <script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>

		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			
			<tr> 
				
				<td valign="top">
					<table width="100%" border="0" cellspacing="1" cellpadding="0">
  	 					<tr>
      						<td valign="top">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td height="26" background="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/xxdhbj.png">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
              										<td>
		              									<div class="browsetitle title_css">
														    <div class="browsetitleleft">
													            <div class="browsetitle001">发送短消息</div>
														        <div class="browsetitle002"><%=XtUtil.getSpell("发送短消息") %></div>
															</div>
														    <div class="browsetitleright">
															    <ul>
																	<li><a href="ShortMessageAction.jsp?cmd=list&_SmsStyle_=2&_orsee_=6&_ReceiveIds_=<%=userId%>" >返回</a></li>
																    <li><a href="javascript:void(0);" onclick="javascript:sendmessage()">发送</a></li>
																    <li class="browsetitle_lang"><a href="javascript:void(0);" onclick="javascript:savemessage()">保存草稿箱</a></li>
																</ul>
															</div>
													    </div>
              										</td>
              									</tr>
            								</table>
										</td>
          							</tr>
          							<tr>
            							<td valign="top"> 
              								<table width="100%" border="0" cellspacing="0" cellpadding="6">
                								<tr>
                  									<td>
														<div id="errorDiv" style="color:red;font-weight:bold"></div>
														<div id="form" class="browsetable">
															<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
																<input type="hidden" name="cmd" value="save"/>
																<input type="hidden" name="page" value="<%=currpage%>"/>
																<input type="hidden" name="SmsStyle" id="SmsStyle" value="<%=v.getSmsStyle()%>"/>
																<input type="hidden" name="SendId" id="SendId" value="<%=userInfo.getId()%>"/>
																<input type="hidden" name="IfSee" id="IfSee" value="0"/>
																  <%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" cellspacing="0" cellpadding="0">
                      												<tr>
                        												<td height="2"></td>
                      												</tr>
                    											</table>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#D2D2D2">
																	<input type="hidden" name="Id" value="<%=v.getId()%>"/>	
                    												<tr>
                    													<td align="right" bgcolor="#FFFFFF" class="form_label">短消息标题</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input name="Subject" cols="80" size="40" rows="4" value="'Re:'<%=v.getSubject()%>" />                    													</td>
													  				</tr>
													  				
													  				<tr>
                    													<td align="right" bgcolor="#FFFFFF" class="form_label">接收人</td>
														    			<td bgcolor="#FFFFFF" align="left">
                    														<input type="hidden" name="ReceiveIds" cols="40" rows="2" value="<%=v.getSendId() %>"/>
                    														<textarea  id="ReceiveId" name="ReceiveId" cols="50" rows="2" readonly><%=usercode.getCnName()%></textarea>                    													</td>
													  				</tr>
													  				
                    												<tr>
                    													<td align="right" bgcolor="#FFFFFF" class="form_label">短消息级别</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(MsgGradeoptions, "" + v.getMsgGrade(), "MsgGrade", "-1")%>                    													</td>
													  				</tr>
													  				
                    											<%--  
                    												<tr>
                    													<td bgcolor="#FFFFFF" align="right">是否回执</td>
														    			<td bgcolor="#FFFFFF" align="left">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getReceipt(), "Receipt", "-1")%>
                    													</td>
													  				</tr>
													  				--%>
							<input type="hidden" name="SaveDate" size="0" value="<%=Tool.stringOfDateTime(v.getSaveDate())%>"/>
                    		<input type="hidden" name="SendDate" size="0" value="<%=Tool.stringOfDateTime(v.getSendDate())%>"/>	
                            <input  type="hidden" name="AttachIds" cols="40" rows="2" value="<%=v.getAttachIds()%>" />
                                     <tr>
                                     <td align="right" bgcolor="#FFFFFF" class="form_label">内容</td>
                                     <td bgcolor="#FFFFFF" align="left">
                                     <ueditor:editor instanceName="Content" basePath="/main/js/ueditor" width="690" height="200" value="<%=Content%>" toolbars="[['FullScreen', 'Source', 'Undo', 'Redo','Bold','test']]"></ueditor:editor>
                                     </td>	
									  </tr>
									  						<tr>
																<td align="right" bgcolor="#FFFFFF" class="form_label">
																	上传其他相关附件																</td>
															<td bgcolor="#FFFFFF" colspan="1">
															<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> <input type="button"  value="上传" onclick="return checkDocType();"/><img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
															<div style="color:red">请上传doc或xls格式文件，文件最大1M</div>
																	<table id="ShowFiles">
    <%
	if(v.getId()!=-1){
		ClientAttach ca = new ClientAttach();
		String ids = v.getAttachIds();
		if(ids!=null&&ids.trim().length()>0){
			String[] idArray = Tool.split(",",ids);
			for(int i=0;i<idArray.length;i++){
			ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
				if(ca1!=null){
     %>
<tr id="<%=ca1.getUploadName()+ca1.getId() %>"><td bgcolor="#FFFFFF" colspan="1"><a href="<%=HeadConst.apache_url %>/servlet/attach?type=attach&id=<%=ca1.getId() %>" target="_blank"><img src='<%=HeadConst.apache_url %>/main/images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<img src='<%=HeadConst.apache_url %>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()+ca1.getId() %>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
<%				}//删除无效id
				else{
					ids = (","+ids+",").replace(","+idArray[i]+",",",");
					if(ids.length()==1){
						ids = "";
					}else{
						ids = ids.substring(1,ids.length()-1);
					}
					v.setAttachIds(ids);
					v.update();
				}
			}
		}
	}
%>
															</table>														</td>
														</tr>
                    											</table>
															</form>
														</div>
													</td>
                								</tr>
              								</table>
					                	</td>
          							</tr>
        						</table> 
							</td>
    					</tr>
  					</table>
				</td>
				
			</tr>
			<tr> 
				<td colspan="3" height="13"></td>
			</tr>
		</table>
	</body>

