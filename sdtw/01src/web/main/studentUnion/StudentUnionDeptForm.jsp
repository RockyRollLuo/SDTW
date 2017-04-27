<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--学生会部门--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@page import="com.xietong.software.base.Power"%>

<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	Log log = LogFactory.getLog(StudentUnionDept.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	StudentUnionDept v = (StudentUnionDept)request.getAttribute("fromBean");
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
	int unionid=ParamUtils.getIntParameter(request, "_UnionId_", -1);
BaseUserCode  user= userInfo.getUserCode();
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
							<script src="<%=HeadConst.apache_url%>/main/js/common.js"></script>
		
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				
        			$("#Addaccount").change(function(){
        				var id=$(this).val();
        				//alert($(this).val())
        				 $.ajax({
        						url:"zhanghaochaxun.jsp?cmd=chaxun&Id="+id,
        						type: "post",
        						dataType:"json",
        						async:false,
        						success:function(data){
        						
        							if(data.msg=="error"){
        								alert("错误");
        								
        								return;
        							}
        							if(data.msg=="ok"){
        						$("#Contact").val(data.phone)
        							
        							}
        							if(data.msg=="no"){
        								alert("222222222222222")
        							} 
        							
        						},
        						error: function (error) {
        				            alert("信息出错！");
        				        }
        						
        					});
        			})	
    			
			}
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
			    //alert("111111111111")
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
		                         	var addfile=document.postForm.Addfilelist.value;
		                         	if(addfile==""){
		                         		document.postForm.Addfilelist.value=data.ids;
		                         	
		                         	}else{
		                         		document.postForm.Addfilelist.value= data.ids+","+addfile;
		                         	}
		                        	//alert(data.ids);
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
			                       var i
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
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+realname+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+realname+data.ids+'",'+data.ids+');\' style="cursor:point;"/>';
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
			function tianjia(){
				openWindow("BaseUserCodeAction2.jsp?values="+$('#Addtime').val(),"703,400")	
			}
		
		    function setRole(name,id){
	        	  var id1=$('#Addtime').val()+""+id;
	        	  $('#Addtime').val(id);
	        	  var name1=$('#xingming').val()+name;
	        	  if(name.startsWith(",")){
	        	  name=name.substring(1,name.length)
	        	  }
	        	  $('#xingming').val(name);
	          }
		</script>
	</head>
	<body onload="init();">
		
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">学生会部门</div>
				<div class="browsetitle002"><%=XtUtil.getSpell("学生会部门") %></div>
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="StudentUnionDeptAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
						<%if(v.getAddaccount().equals(user.getId()+"")||v.getId()==-1){ %>
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
<input type="hidden" id="Addtime"  name="Addtime" value="<%=v.getAddtime()%>">
<input type="hidden" id="Addaccount"  name="Addaccount" value="<%=user.getId()%>">
                    												
                    												
                    												<tr>
                    													<td align="right" class="form_label">部门 </td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    											           <input name="DeptName" id="DeptName" size="25" maxsize="25" value="<%=v.getDeptName()%>">
                    													</td>
                    															<td align="right" class="form_label">负责人</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			<%
														    			String mingzi="";
														    			if(v.getId()!=-1){
														    				user=user.getById(Integer.parseInt(v.getAddtime()));
														    				mingzi=user.getCnName();
														    			}
														    			
														    			%>
               								<input onclick="tianjia()"  size="15" maxsize="15" name="xingming" id="xingming" size="0" value="<%=mingzi%>" readonly="readonly">	
                    													
                    														
                    													</td>
                    															<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			
                    														<input name="Contact" id="Contact" size="25" maxsize="25" value="<%=v.getContact()%>">
                    													</td>
                    													
													  				</tr>
                    												<tr>
                    												
                    															<td align="right" class="form_label">部门排序</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			
                    														<input name="ListOrder" id="ListOrder" size="25" maxsize="25" value="<%=v.getListOrder()%>">
                    													</td>
                    												
                    												</tr>
                    											
													  					<tr>
                    													<td align="right" class="form_label">部门简介</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
														    			<textarea name="Deptprofile" id="Deptprofile" style="height: 150px;width: 930px" ><%=v.getDeptprofile()%></textarea>
                    													
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">主要职能</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														
                    														<textarea name="Functionstr" id="Functionstr" style="height: 150px;width: 930px" ><%=v.getFunctionstr()%></textarea>
                    													</td>
													  				</tr>
                    											
                    												
													  				<input type="hidden" name="UnionId" id="UnionId" value="<%=ParamUtils.getParameter(request, "_UnionId_", "-1") %>">
                    												<tr style="display: none;">
                    													
													  				<td align="right" class="form_label">发布人</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Principal" id="Principal" size="0" value="<%=Tool.stringOfDateTime(v.getPrincipal())%>">
                    													</td>
                    												
                    													<td width="100px" align="right" class="form_label">校级院级学生会id</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    													</td>
                    													<td align="right" class="form_label">附件</td>
														    			<td align="left"  bgcolor="#ffffff" colspan="5">
                    														<input name="Addfilelist" id="Addfilelist" size="20" maxsize="20" value="<%=v.getAddfilelist()%>">
                    													</td>
													  				</tr>
                    											</table>
                    											 <!-- 上传其他附件 -->
                    												<div id="form" class="browsetable">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2">
																	<tr id="postFormBookedBooths">
																	<td align="right" class="form_label">附件</td>
																	
																	<td bgcolor="#FFFFFF" colspan="5">
																	<table width="100%" border="0" cellspacing="0" bgcolor="D2D2D2" id="ShowFiles">
																	<%
																		if(v.getId()!=-1){
																			ClientAttach ca = new ClientAttach();
																			String ids = v.getAddfilelist();
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
																	v.setAddfilelist(ids);
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
