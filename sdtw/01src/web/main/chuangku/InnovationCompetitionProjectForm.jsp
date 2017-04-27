<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--创业项目--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%@page import="com.xietong.software.base.Power"%>

<%
	Log log = LogFactory.getLog(InnovationCompetitionProject.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	InnovationCompetitionProject v = (InnovationCompetitionProject)request.getAttribute("fromBean");
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
	BaseUserCode user= userInfo.getUserCode();
List ProductionNameoptions = (List)request.getAttribute("ProductionNameoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
				<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
		
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
			<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
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
			/*
			上传文档格式过滤
			*/
			function checkDocType(){//上传文档格式过滤
				var file=document.getElementById('OtherAttach').value;
				if(file){
					var allowType = {"doc":"", "xls":"", "docx":"", "xlsx":"","pdf":""};
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
			                    	// if(document.postForm.AddFileList.value==""){
		                         	var be = data.url.indexOf("=");
		                         	var en = data.url.lastIndexOf("/");
		                        
		                        	var addfile=document.postForm.AddFilelist.value;
		                         	if(addfile==""){
		                         		document.postForm.AddFilelist.value=data.ids;
		                         	
		                         	}else{
		                         		document.postForm.AddFilelist.value= data.ids+","+addfile;
		                         	}
		                         
		                        	
		                        /*  }else{
		                         	var be = data.url.indexOf("=");
		                         	var en = data.url.lastIndexOf("/");
		                         	document.postForm.AddFileList.value += ","+data.ids;
		                         }  */
			                        var table = document.getElementById('ShowFiles');
			                        var num = table.rows.length;
			                        var row = table.insertRow(num);
			                        var filename = data.url.replace(/.*(\/|\\)/, "");
			                        var realname=data.name;
			                        var cell = row.insertCell(0);
			                        <%
			                        	if(cmd.equals("update")){
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+realname+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("tempnew'+realname+data.ids+'",'+data.ids+');\' style="cursor:point;"/>';
			                        <%
			                        	}else{
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+realname+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+realname+data.ids+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/><tr>';
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

			function deleteUpdateFile(name,id){//删除修改时上传附件
				if(confirm('是否确定删除？')){
					$.ajax({
						type:"post",			
						url:"<%=request.getAttribute("classname")%>Action.jsp?cmd=delAttach&did="+id,
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
			        				var row = document.getElementById(id);
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
			                alert("上传文件失败，请重新上传！");
			            }
					});
				}
				return false;
			}
		</script>
	</head>
	<body onload="init();">
		
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">创业项目</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("创业项目") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="InnovationCompetitionProjectAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<% 	  if(v.getId() ==-1||v.getAddPerson().equals(user.getId()+"")){
													           %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%} %>
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
<%if(v.getId()==-1){ %>
<input type="hidden" name="AddPerson" value="<%=user.getId()%>">
<%}else{ %>

<input type="hidden" name="AddPerson" value="<%=v.getAddPerson()%>">
<%} %>
                    												<tr>
                    													<td align="right" class="form_label">项目名称</td>
														    			<td align="left"  bgcolor="#ffffff">

	<input name="ProjectName" id="ProjectName" size="45" maxsize="45" value="<%=v.getProjectName()%>">
                    													</td>
                    												
                    													<td align="right" class="form_label">立项单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectUnit" id="ProjectUnit" size="45" maxsize="45" value="山大团委" readonly="readonly">
                    													</td>
													  				</tr>
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">项目编码</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectId" id="ProjectId" size="45" maxsize="45" value="<%=v.getProjectId()%>">
                    													</td>
                    													
													  				</tr>
                    												<tr>
                    												<%-- 	<td align="right" class="form_label">启动时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeStart" id="TimeStart" size="45" maxsize="45" value="<%=v.getTimeStart()%>">
                    													</td>
                    												<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="TimeEnd" id="TimeEnd" size="45" maxsize="45" value="<%=v.getTimeEnd()%>">
                    													</td>	 --%>
                    													
                    														<td align="right" class="form_label">启动时间</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			
                    														<%-- <input name="Starttime" id="Starttime" size="0" value="<%=Tool.stringOfDateTime(v.getStarttime())%>"> --%>
                    														
																						
																						<input value="<%=v.getTimeStart()%>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'%y-%M-%d %H:00:00',onpicked:function(){}})"  name="TimeStart" id="TimeStart" size="0">
                    													</td>
                    													<td align="right" class="form_label">结束时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    												
                    																
																						
																						<input  value="<%=v.getTimeEnd()%>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'#F{$dp.$D(\'TimeStart\')}',onpicked:function(){}})"  name="TimeEnd" id="TimeEnd" size="0">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    														<td align="right" class="form_label">项目负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ProjectLeader" id="ProjectLeader" size="45" maxsize="45" value="<%=v.getProjectLeader()%>">
                    													</td>
                    													<td align="right" class="form_label">负责人电话</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="LeaderPhone" id="LeaderPhone" size="45" maxsize="45" value="<%=v.getLeaderPhone()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    													<td align="right" class="form_label">项目详情</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="4">
                    														<textarea name="ProjectDetail" id="ProjectDetail" cols="150" rows="5"><%=v.getProjectDetail()%></textarea>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">备注</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="4">
                    														<textarea name="Remark" id="Remark" cols="150" rows="5"><%=v.getRemark()%></textarea>
                    													</td>
													  				</tr>
                    											
<input type="hidden" name="AddTime" value="<%=v.getAddTime()%>">

<input type="hidden" name="ModiTime" value="<%=v.getModiTime()%>">
<input type="hidden" name="ModiPerson" value="<%=v.getModiPerson()%>">
<input id="AddFilelist" name="AddFilelist" type="hidden" >
                    											</table>
                    											 <!-- 上传其他附件 -->
                    												<div id="form" class="browsetable">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2">
																	<tr id="postFormBookedBooths"><td  class="form_label">
																	<div  align="right" style="color:#ffffff">上传其他相关附件</div>
																	</td>
																	<td bgcolor="#FFFFFF" colspan="3">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2" id="ShowFiles">
																	<%
																		if(v.getId()!=-1){
																			ClientAttach ca = new ClientAttach();
																			String ids = v.getAddFilelist();
																			if(ids!=null&&ids.trim().length()>0){
																				String[] idArray = Tool.split(",",ids);
																				for(int i=0;i<idArray.length;i++){
																				ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
																					if(ca1!=null){
																	%>
																					<tr  id="<%=ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca1.getId() %>" target="_blank"><img src='../images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()+ca1.getId() %>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
																	<%				}//删除无效id
																					else{
																	ids = (","+ids+",").replace(","+idArray[i]+",",",");
																	if(ids.length()==1){
																		ids = "";
																	}else{
																		ids = ids.substring(1,ids.length()-1);
																	}
																	v.setAddFilelist(ids);
																	v.update();
																}
															}
														}
													}
												%>
															</table>
															<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> <input type="button"  value="上传" onclick="return checkDocType();"/><img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
															<div style="color:red">请上传doc、docx、xls、xlsx或pdf格式文件，文件最大5M</div>
															</td></tr>
														</table>
													</div>
			</form>
		</div>
	</body>
</html>
