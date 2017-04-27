<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.SdtwConst"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--志愿活动--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="ueditor" uri="http://sdxietong.com"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<jsp:include page="/main/jqueryui.jsp" flush="true"/>
<%
	Log log = LogFactory.getLog(VolunteerActivity.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerActivity v = (VolunteerActivity)request.getAttribute("fromBean");
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
	BaseUserCode user=new BaseUserCode();
	user= userInfo.getUserCode();
List UserNameoptions = (List)request.getAttribute("UserNameoptions");
List ActivityLeveloptions = (List)request.getAttribute("ActivityLeveloptions");
List cdt1= new ArrayList();
List  xynameoptions=COptionConst.getAcademyNameOptions(userInfo,cdt1);
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
List ActivitykindTypeoptions = (List)request.getAttribute("ActivitykindTypeoptions");
Map AcademyNameMap = CEditConst.getAcademyNameMap(userInfo);

/* /* List cdt = new ArrayList();
cdt.add("roles="+SdtwConst.USER_TYPE_STU);
List UserCnNameoptions= COptionConst.getUserCnNameOptions(userInfo,"请选择", cdt);
cdt.clear();
cdt.add("roles in (1,2)");
List checkTypeoptions=(List)request.getAttribute("checkoptions");
 */
String check="";
String fabudanwei=""; 
if(true){
	check="2";
	fabudanwei=user.getDeptId()+"";
}else{
	check="1";
	fabudanwei=user.getDeptId()+"";
}
List OrgNameoptions=CEditConst.getOrgCityNameOptions(userInfo);

%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="<%=HeadConst.apache_url%>/main/images/skin/<%=userInfo.getSkinId()%>/css.css">
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/validation-framework.js"></script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
		<script src="jquery.multi-select.js"></script>
			<script language="JavaScript"
			src="<%=HeadConst.apache_url%>/main/js/datepicker/WdatePicker.js"></script>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		
			<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/chosen/chosen.css" rel="stylesheet"/>
		<script language="javascript" src="<%=HeadConst.apache_url+"/main/" %>/js/chosen/chosen.jquery.js"></script>
		
		
		<style>
.content-table{
	width:100%;
	padding-right:10px;
	font-size:12px;
	border-collapse:collapse;/*合并边框间隙*/
	empty-cells:show;
	text-align:center;  /*让所有格中的元素居中*/
	/*margin-top:-5px;*/   

}

.content-table tr{          /*行高*/
	height:35px;	
}

.content-table th{			/*表头*/
	padding:.5em;
	border:1px solid #fff;
	color:#fff;                                 
	background:#3992d0;
}
.content-table td{			/*单元格*/
	padding:.5em;
	border:1px solid #fff;
}

.content-table tr.even td{  /*表格颜色隔行显示*/
	background:#e5f1f4;   /*深色*/
}
.content-table tr.odd td{
	background:#f8fbfc; /*浅色*/
}

.content-table .button{     /*蓝底白字透明按钮，用于input样式类*/
	background:transparent;   
	border:none;
	color:#fff;
	font-weight:bold;
	cursor:pointer;
}

td a:link,td a:visited,td a:active{ /*表格中可点的链接*/
	color:#3992d0;
	text-decoration:none;
}

td a:hover{                 /*超链接鼠标经过变色*/
	color:red;
	cursor:pointer;
}

th a:link,th a:visited,th a:active{/*蓝底白字的链接*/
	color:#fff;
	text-decoration:none;
}

th a:hover{                 /*超链接鼠标经过变色*/
	color:red;
}
</style>
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
			<link type="text/css" href="<%=HeadConst.apache_url+"/main/" %>js/jquery-ui-1.10.2/themes/base/jquery-ui-1.8.4.custom.css" rel="stylesheet"/>
		<script>
			var url_para = "<%=url%>";
			var dic = {<%=Tool.join(", ", diclist)%>};
			var keyfield = "<%=(String)request.getAttribute("keyfield")%>";
			var allfields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("allfields"))%>"];
			var fields = ["<%=Tool.join("\", \"", (String[])request.getAttribute("fields"))%>"];
			var options= {<%=HtmlTool.getJsOptions(request)%>};
			function init() {
    				prepareForm("<%=request.getAttribute("classname")%>", dic, "<%=userInfo.getPower()%>");
    				$("#ApplicationRangeTypeshow").chosen({width:'350px;',placeholder_text_single:'请选择 ',no_results_text:"没有找到"});

		}
          
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
			function suoyou(){
			$('#ApplicationRangeTypeshow').val('-1');
			$("#ApplicationRangeTypeshow").trigger("chosen:updated");
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
					//alert("11111111111111")
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
		                         	var addfile=document.postForm.AddFilelist.value;
		                         	if(addfile==""){
		                         		document.postForm.AddFilelist.value=data.ids;
		                         	
		                         	}else{
		                         		document.postForm.AddFilelist.value= data.ids+","+addfile;
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
		
			function submitthis() {
				$('#ApplicationRangeType').val($('#ApplicationRangeTypeshow').val());
				document.postForm.submit();
			}
		</script>
		<script>
			ValidationFramework.init("<%=request.getAttribute("classname")%>_validation.xml");
		</script>
	</head>
	<body  onload="init();">
	<%-- 	<jsp:include page="/main/jqueryui.jsp" flush="true"/> --%>
		<div class="browsetitle">
			<div class="browsetitleleft">
				<div class="browsetitle001">志愿活动:</div>
				
			</div>
			<div class="browsetitleright">
				<div class="anniulist2">
					<ul>
						<li><a href="VolunteerActivityAction.jsp?cmd=list&page=<%=currpage%><%=((url.length() == 0) ? "" : "&" + url)%>" >返回</a></li>
												<%if(v.getAddAccount().equals(user.getId()+"")||v.getId() ==-1) {%>
						
						<li><a href="javascript:void(0);" onclick="javascript:if(doValidate('postForm')) submitthis();">保存</a></li>
						<%} %>
					</ul>
				</div>
			</div>
		</div>
		<div id="errorDiv" style="color:red;font-weight:bold"></div>
		<div class="browsetable" id="form">
			
			<form action="<%=request.getAttribute("classname")%>Action.jsp" method="post" name="postForm" id="postForm">
			<input type="hidden" name="ApplicationRangeType"  id="ApplicationRangeType"/>
				<input type="hidden" name="cmd" value="<%=cmd%>">
				<input type="hidden" name="page" value="<%=currpage%>">
				<%if(v.getId() ==-1){ %>
				<input type="hidden" name="AddAccount" value="<%=user.getId()%>">
				<%}else{ %>
				<input  type="hidden" name="AddAccount" id="AddAccount" size="45" maxsize="45" value="<%=v.getAddAccount()%>">
				<%} %>
				<%=Tool.join("\n", forms)%>
				<div id="tabs-1" style="border: 0px;">
		
				<% 
				
				
				
				if(v.getId()!=-1){ %>
                    											<table   width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
	<tr>
                    												<td   width="15%" align="right" class="form_label">活动名称</td>
														    			<td width="15%"  align="left"  bgcolor="#ffffff">
                    														<input name="Activityname" id="Activityname" size="35" maxsize="35" value="<%=v.getActivityname()%>">
                    													</td>
                    													<td align="right" class="form_label">活动类别</td>
														    			<td align="left"  bgcolor="#ffffff">
														    				<input name="ActivityKind" id="ActivityKind" size="35" maxsize="35" value="<%=v.getActivityKind()%>">
                  
                                                                       
	

                    													</td>
                    													<td align="right" class="form_label">活动级别</td>
														    			<td   calign="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "",true)%>
                    													</td>
													  				</tr>
                    												<tr style="display: none;">
                    													<td  align="right" class="form_label">上传文件列表</td>
														    			
													  				</tr>
                    											
                    								<input type="hidden" name="AddFilelist" id="AddFilelist" value="<%=v.getAddFilelist()%>"/>			
                    												<tr>
                    											
                    													
                    														<td align="right" class="form_label">报名截止日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    														
																						<input value="<%=Tool.stringOfDate(v.getDeadline())%>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',onpicked:function(){}})"  name="Deadline" id="Deadline" size="0">
                    													</td>
                    													<td align="right" class="form_label">活动开始日期</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			
                    														<%-- <input name="Starttime" id="Starttime" size="0" value="<%=Tool.stringOfDateTime(v.getStarttime())%>"> --%>
                    														
																						
																						<input value="<%=Tool.stringOfDate(v.getStarttime())%>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',onpicked:function(){}})"  name="Starttime" id="Starttime" size="0">
                    													</td>
                    													<td align="right" class="form_label">活动结束日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    												
                    																
																						
																						<input  value="<%=Tool.stringOfDate(v.getEndtime())%>" readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'#F{$dp.$D(\'Starttime\')}',onpicked:function(){}})"  name="Endtime" id="Endtime" size="0">
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人</td>
														    					<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPrincipal" id="ActivityPrincipal" size="25" maxsize="25" value="<%=v.getActivityPrincipal()%>">

                    													</td>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPlace" id="ActivityPlace" size="25" maxsize="25" value="<%=v.getActivityPlace()%>">
                    													</td>
                    													<td align="right" class="form_label">所需人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonNumber" id="PersonNumber" value="<%=v.getPersonNumber()%>">
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    												<td align="right" class="form_label">申办单位</td>
                    												<%if(v.getLaunchAcademy().equals("-1")) {
                    													
                    													%>
                    													<td align="left"  bgcolor="#ffffff">
                    														
                    														团委
                    													</td>
                    													<input type="hidden" name="LaunchAcademy" value="<%=v.getLaunchAcademy()%>"></input>
                    													<% 
                    													
                    												}else{%>
                    												
                    												
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    														<%=HtmlTool.renderSelect(AcademyNameoptions, v.getLaunchAcademy(), "LaunchAcademy", "",true)%>
                    													</td>
                    													<%} %>
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Contact" id="Contact" size="25" maxsize="25" value="<%=v.getContact()%>">
                    													</td>
                    													<td align="right" class="form_label">指导教师</td>
														    			<td align="left"  bgcolor="#ffffff">
	<input name="GuideTeacher" id="GuideTeacher" size="25" maxsize="25" value="<%=v.getGuideTeacher()%>">
                    													</td>
													  				</tr>
													  				
													  				<tr>
													  				
													  				
													  				<td   colspan="1" align="right" class="form_label">申请范围(学院)</td>
													  				
													  				
													  				<td colspan="6"   align="left"  bgcolor="#ffffff">
													 
	   		
	  			<select name="ApplicationRangeTypeshow" id="ApplicationRangeTypeshow" multiple="multiple" data-placeholder="请选择" >				 
	   						<%=HtmlTool.renderSelectOption(xynameoptions, v.getApplicationRangeType(), ""+v.getApplicationRangeType()) %>
	   		
	  	        </select>
													  			<input type="button" onclick="suoyou();" value="所有学院"></input>			
													  				
													  				</td>
													  				
													  				
													  				
													  				
													  				
													  				</tr>
													  						<tr>
													  				
													  				
													  				<td   colspan="1" align="right" class="form_label">申请范围(校区)</td>
													  				
													  				
													  				
												
   		
   					<td align="left"  bgcolor="#ffffff" colspan="5">
<%=HtmlTool.renderCheckBox(OrgNameoptions, v.getApplicationRange(), "ApplicationRange", "")%>
													  				
													  				
													  				
													  				
													  				
													  				
													  				
													  				
													  				</td>
													  				
													  				
													  				
													  				
													  				
													  				</tr>
													  				
                    											
                    											
													  					
													  		
													  					
													  				<tr>

																				<td align="right" class="form_label">活动描述</td>

																				<td colspan="6" style="padding: 0px;"><ueditor:editor
																				       
																						autoFloat="false" instanceName="ActivityExplain"
																						basePath="/main/js/ueditor" width="99.9%"
																						height="240px" toolbars="toolbar_society"
																						value="<%=v.getActivityExplain() %>"></ueditor:editor></td>

																			</tr>
                    											
													  	
				
													  				
                    											
                    												<tr style="display: none;">
                    																<td align="right" class="form_label">审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()==1?"未审核":(v.getCheckFlag()==2?"审核通过":"审核未通过")%>">
                    														
                    													</td>
                    												<td align="right" class="form_label">审核标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=v.getCheckFlag()%>">
                    													</td>
                    													<td align="right" class="form_label">荣誉列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HonourList" id="HonourList" cols="40" rows="2"><%=v.getHonourList()%></textarea>
                    													</td>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="0" value="<%=Tool.stringOfDateTime(v.getAddtime())%>">
                    													</td>
                    													<td align="right" class="form_label">添加账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    													</td>
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyTime" id="ModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getModifyTime())%>">
                    													</td>
                    													<td align="right" class="form_label">修改账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyAccount" id="ModifyAccount" size="45" maxsize="45" value="<%=v.getModifyAccount()%>">
                    													</td>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
                    													</td>
                    													<td align="right" class="form_label">审核账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckAccount" id="CheckAccount" size="45" maxsize="45" value="<%=v.getCheckAccount()%>">
                    													</td>
                    													<td align="right" class="form_label">置顶标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Settop" id="Settop" value="<%=v.getSettop()%>">
                    													</td>
                    													<td align="right" class="form_label">所属学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
                    												<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
                    												
                    										
                    												
													  				</tr>
                    												
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
													<iframe name=upload style="height:0%; WIDTH: 100%;display:none" scrolling=auto frameborder=1 src=""></iframe>
       											  </table>
       											  
                    											<%}else{ %>
                    											
                    											<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
<input type="hidden" name="Id" value="<%=v.getId()%>">
                    												<tr style="display: none;">
                    													<td align="right" class="form_label">上传文件列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
                    													<td align="right" class="form_label">申办单位</td>
                    													<td align="left"  bgcolor="#ffffff">
                    														
                    														<%=HtmlTool.renderSelect(AcademyNameoptions, v.getLaunchAcademy(), "LaunchAcademy",fabudanwei,true)%>
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    												<td align="right" class="form_label">活动名称</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Activityname" id="Activityname" size="25" maxsize="25" value="<%=v.getActivityname()%>">
                    													</td>
                    													<td align="right" class="form_label">活动类别</td>
														    			<td align="left"  bgcolor="#ffffff">
                                                                       <select  name="ActivityKind">
   			<option value="选择活动类别">选择活动类别</option>
   			<option value="关爱农民工子女（专项）">关爱农民工子女（专项）</option>
   			<option value="庆典赛事">庆典赛事</option>
   			<option value="专项服务">专项服务</option>
   			<option value="公益创新">公益创新</option>
   			<option value="科普传播">科普传播</option>
   			<option value="帮残助困">帮残助困</option>
   			<option value="支农支教">支农支教</option>
   			<option value="社区服务">社区服务 </option>
   			<option value="其他">其他</option>
   		</select>
                                                                       
	

                    													</td>
                    													<td align="right" class="form_label">活动级别</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(ActivityLeveloptions, v.getActivityLevel(), "ActivityLevel", "")%>
                    													</td>
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">报名截止日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														
                    														
																						<input readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',onpicked:function(){}})"  name="Deadline" id="Deadline" size="0">
                    													</td>
                    													<td align="right" class="form_label">活动开始日期</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			
                    														<%-- <input name="Starttime" id="Starttime" size="0" value="<%=Tool.stringOfDateTime(v.getStarttime())%>"> --%>
                    														
																						
																						<input readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',onpicked:function(){}})"  name="Starttime" id="Starttime" size="0">
                    													</td>
                    													<td align="right" class="form_label">活动结束日期</td>
														    			<td align="left"  bgcolor="#ffffff">
                    												
                    																
																						
																						<input readonly class="date" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd ',minDate:'#F{$dp.$D(\'Starttime\')}',onpicked:function(){}})"  name="Endtime" id="Endtime" size="0">
                    													</td>
                    												
                    												
													  				</tr>
                    												<tr>
                    													<td align="right" class="form_label">负责人</td>
														    			
                    														
                    															<td align="left"  bgcolor="#ffffff">
                    														<input name="ActivityPrincipal" id="ActivityPrincipal" size="25" maxsize="25" value="<%=v.getActivityPrincipal()%>">

                    													</td>
                    													</td>
                    													<td align="right" class="form_label">活动地点</td>
														    			<td align="left"  bgcolor="#ffffff">
														    			
                    														<input name="ActivityPlace" id="ActivityPlace" size="25" maxsize="25" value="<%=v.getActivityPlace()%>">
                    													</td>
                    													<td align="right" class="form_label">所需人数</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="PersonNumber" id="PersonNumber" >
                    				
                    													</td>
													  				</tr>
                    											
                    												<tr>
                    												
														    			
                    													<td align="right" class="form_label">联系方式</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Contact" id="Contact" size="25" maxsize="25" value="<%=v.getContact()%>">
                    													</td>
                    													<td align="right" class="form_label">指导教师</td>
														    			<td colspan="3"  align="left"  bgcolor="#ffffff">
<input name="GuideTeacher" id="GuideTeacher" size="25" maxsize="25" value="<%=v.getGuideTeacher()%>">
                    													</td>
													  				</tr>
													  				<tr>
													  				
													  				
													  				<td   colspan="1" align="right" class="form_label">申请范围(学院)</td>
													  				
													  				
													  				<td colspan="6"   align="left"  bgcolor="#ffffff">
								<select name="ApplicationRangeTypeshow" id="ApplicationRangeTypeshow" multiple="multiple" data-placeholder="请选择">				 
	   						<%=HtmlTool.renderSelectOption(xynameoptions, v.getApplicationRangeType(), ""+v.getApplicationRangeType()) %>
	   					
	   		
	  	        </select>	
			
				
										<input type="button" onclick="suoyou();" value="所有学院"></input>		  				
													  				
													  				</td>
													  				
													  				
													  				
													  				
													  				
													  				</tr>
													  						<tr>
													  				
													  				
													  				<td   colspan="1" align="right" class="form_label">申请范围(校区)</td>
													  				
													  				
													  	
   					<td align="left"  bgcolor="#ffffff" colspan="5">
<%=HtmlTool.renderCheckBox(OrgNameoptions, v.getApplicationRange(), "ApplicationRange", "")%>
													  					
													  				
													  				
													  				
													  				
													  				
													  				
													  				
													  				</td>
													  				
													  				
													  				
													  				
													  				
													  				</tr>
													  				
													  				
													  				
                    			
                    											
													  					
													  				<tr>

																				<td align="right" class="form_label">活动描述</td>

																				<td colspan="6" style="padding: 0px;"><ueditor:editor
																				       
																						autoFloat="false" instanceName="ActivityExplain"
																						basePath="/main/js/ueditor" width="99.9%"
																						height="240px" toolbars="toolbar_society"
																						value="<%=v.getActivityExplain() %>"></ueditor:editor></td>

																			</tr>
                    											
													  	
				
													  				
                    											
                    												<tr style="display: none;">
                    																<td  align="right" class="form_label">审核状态</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckFlag" id="CheckFlag" value="<%=check%>">
                    													</td>
                    											<input type="hidden"  name="AddFilelist" id="AddFilelist"  value="<%=v.getAddFilelist()%>"/>		
                    													<td align="right" class="form_label">荣誉列表</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<textarea name="HonourList" id="HonourList" cols="40" rows="2"><%=v.getHonourList()%></textarea>
                    													</td>
                    													<td align="right" class="form_label">添加时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Addtime" id="Addtime" size="0" value="<%=Tool.stringOfDateTime(v.getAddtime())%>">
                    													</td>
                    													<td align="right" class="form_label">添加账号</td>
														    			
                    													<td align="right" class="form_label">修改时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyTime" id="ModifyTime" size="0" value="<%=Tool.stringOfDateTime(v.getModifyTime())%>">
                    													</td>
                    													<td align="right" class="form_label">修改账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="ModifyAccount" id="ModifyAccount" size="45" maxsize="45" value="<%=v.getModifyAccount()%>">
                    													</td>
                    													<td align="right" class="form_label">审核时间</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckTime" id="CheckTime" size="0" value="<%=Tool.stringOfDateTime(v.getCheckTime())%>">
                    													</td>
                    													<td align="right" class="form_label">审核账号</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="CheckAccount" id="CheckAccount" size="45" maxsize="45" value="<%=v.getCheckAccount()%>">
                    													</td>
                    													<td align="right" class="form_label">置顶标志</td>
														    			<td align="left"  bgcolor="#ffffff">
                    														<input name="Settop" id="Settop" value="<%=v.getSettop()%>">
                    													</td>
                    													<td align="right" class="form_label">所属学院</td>
														    			<td align="left"  bgcolor="#ffffff">
<%=HtmlTool.renderSelect(AcademyNameoptions, v.getAcademy(), "Academy", "")%>
                    													</td>
                    												
                    										<td align="left"  bgcolor="#ffffff">
                    														<textarea name="AttachIds" id="AttachIds" cols="40" rows="2"><%=v.getAddFilelist()%></textarea>
                    													</td>
                    												
													  				</tr>
                    												
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
													<iframe name=upload style="height:0%; WIDTH: 100%;display:none" scrolling=auto frameborder=1 src=""></iframe>
       											  </table>
       											 
                    											<%} %>
                    	</div>		
  
                   


                   
   


                   
                   
                   
                        </div>	
      			
			</form>
			</div>
			
		</div>
		
				<script>
	$(function() {
		$( "#tabs" ).tabs();
		$("#tabs").tabs('option','active', 0); 
		<%   String xuanzhong= v.getApplicationRangeType();  
		 if((!xuanzhong.equals("-1"))&&(v.getId()!=-1)){
			 
			 %>

		             var xuanzhong ='<%= xuanzhong%>';
		           //  alert(xuanzhong);
		             $("#ApplicationRangeTypeshow").val(xuanzhong.split(','));
					
				<%}%>
	});

	</script>
	</body>
</html>
