<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--资讯信息--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>

<%@ include file="/main/js/jsheader.jsp"%>
<%@ taglib prefix="ueditor" uri="http://sdxietong.com"%>
<%
	Log log = LogFactory.getLog(Information.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Information v = (Information)request.getAttribute("fromBean");
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
	BaseUserCode user = new BaseUserCode();
	user=userInfo.getUserCode();
	List DeptNameoptions = (List)request.getAttribute("DeptNameoptions");
	List xyNameoptions=(List)request.getAttribute("xyNameoptions");
List YesNooptions = (List)request.getAttribute("YesNooptions");
List UserNameCnoptions = (List)request.getAttribute("UserCnNameoptions");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
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
			//=========================================================================================================================================================
			function checkType(){//上传图片格式过滤
				var file=document.getElementById('FrequencyInfo').value;
				if(file){
					var allowType = {"gif":"", "jpg":"", "jpeg":"", "bmp":"", "png":""};
					var filename=file.replace(/.*(\/|\\)/, "");//jquery获得文件名
					var fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; //jquery获得后缀名
					if((fileExt+"").toLowerCase() in allowType){
						ajaxFileUpload();
					}
					else{
						alert("上传文件格式不符合要求，请重新选择！");
					}
				}
				return false;
			}

			function ajaxFileUpload(){//上传示意图片 
				var ImageInfo;//保存上传成功后 图片在服务器上的路径
				var fileElement;//保存本地要上传的文件 的 地址
				var picPath;//在form页  上传后显示示
				ImageInfo = document.postForm.ImageInfo.value;
					fileElement='FrequencyInfo';
					picPath='FrequencyPic';
			    $("#load")
			    .ajaxStart(function(){
			        $(this).show();
			    })
			    .ajaxComplete(function(){
			        $(this).hide();
			    });
			     
			    $.ajaxFileUpload
			    (
			        {
			            url:'<%=request.getAttribute("classname")%>Action.jsp?cmd=upPic&ImageInfo='+ImageInfo,
			            secureuri:false,
			            fileElementId:fileElement,
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
			                        var pic = document.getElementById(picPath);
			                        pic.src = '<%=HeadConst.apache_url%>'+data.url+'?time='+new Date();
			                        pic.style.display = '';
			                        	document.postForm.ImageInfo.value = data.url;    
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
			//====================================================================================================================================================

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
			                alert("上传文件失败，请重新上传！");
			            }
					});
				}
				return false;
			}
		</script>
	</head>
	<body  width="100%"onload="init();">
		
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">资讯信息</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("资讯信息") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="InformationAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<% if(v.getUserId()==user.getId()||v.getSubject().equals("")){ %>
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) document.postForm.submit();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<%
		if(v.getSubject()!=""){
		%>
		<div  width="100%"class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">

                    												
                    												<tr>
                    													<td align="right" class="form_label">标题</td>
														    			<td align="left" colspan="3"   bgcolor="#ffffff">
                    															<input  style="width:300px;height: 30px" name="Subject" id="Subject" value="<%=v.getSubject()%>"/>
                    													</td>
                    													<%-- <td align="right" class="form_label">描述</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="InfoDesc" id="InfoDesc" cols="40" rows="2"><%=v.getInfoDesc()%></textarea>
                    													</td> --%>
                    													
                    												<tr style="display: none">
                    												 <td align="right" class="form_label">发布部门</td>
														    			<td align="left" width="40%"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(xyNameoptions, "" + v.getDept(), "dept", "-1")%>
													  			
                    													<td align="right" class="form_label">图片信息</td>
                    													
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ImageInfo" id="ImageInfo" cols="40" rows="2"><%=v.getImageInfo()%></textarea>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    												   
                    														
                    										<%-- 	<input name="NewDate" id="NewDate" size="0" value="<%=Tool.stringOfDateTime(v.getNewDate())%>">	 --%>	
                    													<td align="right" class="form_label">发表人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameCnoptions, "" + user.getId(), "UserId", "-1",true)%>
                    													</td>
                    													<td align="right" class="form_label">是否置顶</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsFocus(), "IsFocus", "-1")%>
                    													</td>
													  				</tr>
                    												<tr  style="display: none">
                    												  <td align="right" class="form_label">发布部门</td>
														    			<td align="left" width="40%"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(xyNameoptions, "" + user.getDeptId(), "Dept", "-1")%>
                    													<td align="right" class="form_label">创建时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="NewDate" id="NewDate" size="0" value="<%=Tool.stringOfDateTime(v.getNewDate())%>">
                    													</td>
													  				</tr>
<input type="hidden" name="UserType" value="<%=v.getUserType()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">相关附件ids</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAttachIds()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="VideoPath" value="<%=v.getVideoPath()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">是否推荐</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsRecommond(), "IsRecommond", "-1")%>
                    													</td>
													  				</tr>
                    												
                    												
                    													
													  				
                    												
                    												<tr style="display: none">
                    												<td align="right" class="form_label">接受单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Dept" id="Dept" size="50" maxsize="50" value="<%=v.getDept()%>">
                    													</td>
                    													<td align="right" class="form_label">是否删除</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsDel(), "IsDel", "-1")%>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OrderNum" id="OrderNum" value="<%=v.getOrderNum()%>">
                    													</td>
													  				</tr>
													  				
													  				
													  				<tr>

																				<td align="right" class="form_label">公告描述</td>

																				<td colspan="3" style="padding: 0px;"><ueditor:editor
																				       
																						autoFloat="false" instanceName="InfoDesc"
																						basePath="/main/js/ueditor" width="99.9%"
																						height="280px" toolbars="toolbar_society"
																						value="<%=v.getInfoDesc() %>"></ueditor:editor></td>

																			</tr>
																
																    <!-- 上传其他附件 -->
                    												<div id="form" class="browsetable">
																	<table width="100%" border="0" cellspacing="1" bgcolor="D2D2D2">
																	<tr id="postFormBookedBooths"><td  class="form_label">
																	<div  align="right" style="color:#ffffff">上传其他相关附件</div>
																	</td>
																	<td bgcolor="#FFFFFF" colspan="3">
																	<table width="100%" border="0" cellspacing="1" bgcolor="D2D2D2" id="ShowFiles">
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
																					<tr id="<%=ca1.getUploadName()+ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='../images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()+ca1.getId() %>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
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
															</table>
															<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> <input type="button"  value="上传" onclick="return checkDocType();"/><img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
															<div style="color:red">请上传doc、docx、xls、xlsx或pdf格式文件，文件最大5M</div>
															</td></tr>
														</table>
													</div>
													<iframe name=upload style="height:0%; WIDTH: 100%;display:none" scrolling=auto frameborder=1 src=""></iframe>
       											  </table>
       											  </div>
																			
        <%} else{%>
                  										
            <div class="browsetable" id="form">
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%=Tool.join("\n", forms)%>
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">

                    												
                    												<tr>
                    													<td align="right" class="form_label">标题</td>
														    			<td align="left" colspan="3"  bgcolor="#ffffff">
                    														
                    														<input style="width:300px;" name="Subject" id="Subject" />
                    													</td>
                    													<%-- <td align="right" class="form_label">描述</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="InfoDesc" id="InfoDesc" cols="40" rows="2"><%=v.getInfoDesc()%></textarea>
                    													</td> --%>
                    												
													  				</tr>
                    												<tr style="display: none">
                    													 <td align="right" class="form_label">发布部门</td>
														    			<td align="left" width="40%"  bgcolor="#ffffff">
														    			<%=HtmlTool.renderSelect(xyNameoptions, "" + user.getDeptId(), "Dept", "-1")%>
                    													<td align="right" class="form_label">图片信息</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="ImageInfo" id="ImageInfo" cols="40" rows="2"></textarea>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    												   
                    														
                    													
                    													<td align="right" class="form_label">发表人</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(UserNameCnoptions, "" + user.getId(), "UserId", "-1",true)%>
                    													</td>
                    													
													  				</tr>
                    												<tr  style="display: none">
                    												<td align="right" class="form_label">是否置顶</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsFocus(), "IsFocus", "-1")%>
                    													</td>
                    										
                    													<td align="right" class="form_label">创建时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="NewDate" id="NewDate" size="0" value="<%=Tool.stringOfDateTime(new Date())%>">
                    													</td>
													  				</tr>
<input type="hidden" name="UserType" value="<%=v.getUserType()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">相关附件ids</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAttachIds()%></textarea>
                    													</td>
													  				</tr>
<input type="hidden" name="VideoPath" value="<%=v.getVideoPath()%>">
                    												<tr style="display: none">
                    													<td align="right" class="form_label">是否推荐</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsRecommond(), "IsRecommond", "-1")%>
                    													</td>
													  				</tr>
                    												
                    												
                    													
													  				
                    												
                    												<tr style="display: none">
                    												<td align="right" class="form_label">接受单位</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Dept" id="Dept" size="50" maxsize="50" value="<%=v.getDept()%>">
                    													</td>
                    													<td align="right" class="form_label">是否删除</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(YesNooptions, "" + v.getIsDel(), "IsDel", "-1")%>
                    													</td>
													  				</tr>
                    												<tr style="display: none">
                    													<td align="right" class="form_label">排序</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="OrderNum" id="OrderNum" value="<%=v.getOrderNum()%>">
                    													</td>
													  				</tr>
													  				
													  				
													  				<tr>

																				<td align="right" class="form_label">公告描述</td>

																				<td colspan="3" style="padding: 0px;"><ueditor:editor
																				       
																						autoFloat="false" instanceName="InfoDesc"
																						basePath="/main/js/ueditor" width="99.9%"
																						height="280px" toolbars="toolbar_society"
																						value="<%=v.getInfoDesc() %>"></ueditor:editor></td>

																			</tr>
																
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
																			String ids = v.getAttachIds();
																			if(ids!=null&&ids.trim().length()>0){
																				String[] idArray = Tool.split(",",ids);
																				for(int i=0;i<idArray.length;i++){
																				ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
																					if(ca1!=null){
																	%>
																					<tr  id="<%=ca1.getUploadName()+ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=clientattach&id=<%=ca1.getId() %>" target="_blank"><img src='../images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()+ca1.getId() %>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
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
															</table>
															<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> <input type="button"  value="上传" onclick="return checkDocType();"/><img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
															<div style="color:red">请上传doc、docx、xls、xlsx或pdf格式文件，文件最大5M</div>
															</td></tr>
														</table>
													</div>
													<iframe name=upload style="height:0%; WIDTH: 100%;display:none" scrolling=auto frameborder=1 src=""></iframe>
       											  </table>
       											  </div>
																        											
                    											
                    											
       <%} %>          											
		
			
			
	</body>
</html>
