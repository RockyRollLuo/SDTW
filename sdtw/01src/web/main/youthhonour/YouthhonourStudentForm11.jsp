<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.xietong.software.base.Power"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" %>
<%--五四评比表彰申请表--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.xietong.software.sdtw.*,com.xietong.software.sdtw.db.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="com.xietong.software.sdtw.club.CurrentSemester"%>
<%@ page import="com.xietong.software.sdtw.youthhonour.YouthhonourUtil"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="/main/js/jsheader.jsp"%>
<%
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	//学号
	String sno=userInfo.getUserCode().getCode();
	
	//noticeid,id,type,cmd
	int noticeid=ParamUtils.getIntParameter(request, "noticeid", -1);//只有申请时noticeid
	int id=ParamUtils.getIntParameter(request, "id", -1);
	int type=ParamUtils.getIntParameter(request, "type", -1);
	String cmd = ParamUtils.getParameter(request, "cmd", "");
	
	Youthhonour_notice yhNotice=new Youthhonour_notice();
	yhNotice=yhNotice.getById(noticeid);
	
	YouthhonourUtil yhUtil=new YouthhonourUtil();
	YouthHonour v = new YouthHonour();
	if("create".equals(cmd)){//申请
		
	}
	if("update".equals(cmd)||"view".equals(cmd)){//修改
		v=yhUtil.getOneYouthhonour(id);
		noticeid=v.getNoticeid();
	}
	if("view".equals(cmd)){//查看
		//给所有input加上disabled
		//没有保存键
	}
	
	//academyname
	Map academynamemap=CEditConst.getAcademyNameMap(userInfo);
	String myacademyname=(String)academynamemap.get(userInfo.getDeptId()+"");
%>
	<head>
		<title><%=request.getAttribute("describe")%></title>
		<jsp:include page="/main/jqueryui.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="../css/common-student.css">
		<script src="../../js/tablelist.js"></script> 
		<script src="../js/jquery.min.js"></script> 
		<script src="<%=userInfo.getRootUrl()%>/main/js/formfunction.js"></script>
		<script language="JavaScript" src="<%=HeadConst.apache_url%>/main/js/ajaxfileupload.js"></script>
		<script>
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
					if(document.postForm.Attachids.value.indexOf(filename)!=-1){
						alert('上传附件名相同，请修改名称后再上传!');
					}
					else{	
						uploadOtherAttatch();
					}
				}
				return false;
			}
			function uploadOtherAttatch(){//上传其他附件
				
			    $("#load1").ajaxStart(function(){
			        $(this).show();
			    }).ajaxComplete(function(){
			        $(this).hide();
			    });
			  	
			    $.ajaxFileUpload
			    (
			        {
			            url:'YouthHonourAction.jsp?cmd=otherattach&type=<%=type%>',
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
		                         	var be = data.url.indexOf("=");
		                         	var en = data.url.lastIndexOf("/");
		                        	
		                        	var attachidlen=$('#Attachids').val();
		                        	if(attachidlen.length>0){
			                         	document.postForm.Attachids.value=attachidlen+","+data.ids;
		                        	}else{
		                         		document.postForm.Attachids.value= data.ids;
		                        	}
		                        	
// 		                         	document.postForm.Attachids.value= data.ids;
			                        var table = document.getElementById('ShowFiles');
			                        var num = table.rows.length;
			                        var row = table.insertRow(num);
			                        var filename = data.name;
									var cell = row.insertCell(0);
									cell.align="left";
			                        <%
			                        	if(cmd.equals("update")){
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
					                        cell.innerHTML =  '<img src=\'../images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'../images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("tempnew'+filename+'",'+data.url.substring(be+1,en)+');\' style="cursor:point;"/>';
			                        <%
			                        	}else{
			                        %>
			                        row.id = data.ids;//修改时以防和之前重名
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

			function deleteUpdateFile(name,id){//删除修改时上传附件
				if(confirm('是否确定删除？')){
					$.ajax({
						type:"post",			
						url:"YouthHonourAction.jsp?cmd=delAttach&type=<%=type%>&did="+id,
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
			        				var files = document.postForm.Attachids.value;
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
			        					document.postForm.Attachids.value = files;
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
			
			//图片
			function deletePic(){
				
				document.postForm.Attachids.value="";
				document.getElementById("FrequencyPic").style.display = "none";
				document.getElementById("deletePic").style.display = "none";
				alert("图片已成功删除");
			}
			
			function ajaxFileUpload(){//上传示意图片 
				var Attachids;//保存上传成功后 图片在服务器上的路径
				var fileElement;//保存本地要上传的文件 的 地址
				var picPath;//在form页  上传后显示示
// 				ImageInfo = document.postForm.ImageInfo.value;
				Attachids = document.postForm.Attachids.value;
				//alert(ImageInfo);
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
			            url:'YouthhonourStudentForm-save.jsp?cmd=upPic&Attachids='+Attachids,
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
// 			                        	document.postForm.ImageInfo.value = data.url;    
			                        	document.postForm.Attachids.value = data.url;    
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
			
			function formSubmit(){
				var val1=$("#Val1").val();
				var val2=$("#Val2").val();
				var val6=$("#Val6").val();
				
				if(val1==""){
					$("#Val1").focus();
					alert("不能为空!");
					return;
				}
				if(val2==""){
					$("#Val2").focus();
					alert("不能为空!");
					return;
				}
				if(val6!=""){
					var myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
					if(!myreg.test(val6)){
						$("#Val6").focus();
						alert("联系方式格式有误，请输入正确格式！");
						return;
					}
				}
				document.postForm.submit();
			}
		</script>
	</head>
	<body>
	<%
	String strposition = "组织建设>>五四评比表彰>>";
	String strfunction =yhUtil.youthhonourName.get(type);
	String strhelpwords = "申请表。";
	%>
	<%@ include file="/student/pagetop-positionandhelp.jsp" %>
	
	<table class="command-table">
	<tr>
		<td><a href="YouthhonourStudentList.jsp?noticeid=<%=noticeid%>" >返回</a></td>
	</tr>    
	</table>
	
	<form action="YouthhonourStudentForm-save.jsp" method="post" name="postForm" id="postForm">
	<input type="hidden" name="cmd" value="<%=cmd%>"/>
	<input type="hidden" name="Id" value="<%=v.getId()%>"/>
	
<%--<input type="hidden" name="Noticeid" value="<%=v.getNoticeid()%>"/> 
	<input type="hidden" name="Type" value="<%=v.getType()%>"/>--%>
	<input type="hidden" name="Noticeid" value="<%=noticeid%>"/>
	<input type="hidden" name="noticeid" value="<%=noticeid%>"/>
	<input type="hidden" name="Type" value="<%=type%>"/>
	
	<input type="hidden" name="Addaccount" value="<%=v.getAddaccount()%>"/>
	<input type="hidden" name="Addtime" value="<%=v.getAddtime()%>"/>
	<input type="hidden" name="XyCheckDate" value="<%=v.getXyCheckDate()%>"/>
	<input type="hidden" name="TwCheckDate" value="<%=v.getTwCheckDate()%>"/>
	<input type="hidden" name="SchoolYear"  value="<%=v.getSchoolYear()%>" />
	
	<input type="hidden" name="AyCheckFlag" id="AyCheckFlag" value="<%=v.getAyCheckFlag()%>"/>
  	<input type="hidden" name="TwCheckFlag" id="TwCheckFlag" value="<%=v.getTwCheckFlag()%>"/>
  	<input type="hidden" name="ModifyFlag" id="ModifyFlag" value="<%=v.getModifyFlag()%>"/>
    <input type="hidden" name="XyReport" id="XyReport" value="<%=v.getXyReport()%>"/>
 	<input type="hidden" name="TwReport" id="TwReport" value="<%=v.getTwReport()%>"/>
	
	<table class="content-table">
	<tr>
		<th colspan="2" align="left"><%=yhNotice.getNotice()%>:<%=yhUtil.youthhonourName.get(type)%></th>
	</tr>


    <tr>
    	<td align="right" class="form_label" width="30%">所属单位</td>
  		<td align="left"  bgcolor="#ffffff">
			<%=myacademyname%>
			<input type="hidden" name="BelongAcademy" id="BelongAcademy" disabled="disabled" value="<%=v.getBelongAcademy()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">姓名</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val1" id="Val1" size="45" maxsize="45" value="<%=v.getVal1()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">性别</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val2" id="Val2" size="45" maxsize="45" value="<%=v.getVal2()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">出生年月</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val3" id="Val3" size="45" maxsize="45" value="<%=v.getVal3()%>"/>
    	</td>
	</tr>
  	<tr>
    	<td align="right" class="form_label">民族</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val4" id="Val4" size="45" maxsize="45" value="<%=v.getVal4()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">政治面貌</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val5" id="Val5" size="45" maxsize="45" value="<%=v.getVal5()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">联系电话</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val6" id="Val6" size="45" maxsize="45" value="<%=v.getVal6()%>"/>
    	</td>
	</tr>
    <tr>
    <td align="right" class="form_label">所在团支部</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val7" id="Val7" size="45" maxsize="45" value="<%=v.getVal7()%>"/>
    	</td>
	</tr>
    <tr>
    	<td align="right" class="form_label">职务</td>
  		<td align="left"  bgcolor="#ffffff">
    		<input name="Val8" id="Val8" size="45" maxsize="45" value="<%=v.getVal8()%>"/>
    	</td>
	</tr>
    			
    			<tr>
    				<td align="right" class="form_label">主要事迹</td>
  			<td align="left"  bgcolor="#ffffff">
    					<textarea name="Text1" id="Text1" cols="80" rows="6"><%=v.getText1()%></textarea>
    				</td>
			</tr>
    			<tr>
    				<td align="right" class="form_label">获奖情况</td>
  			<td align="left"  bgcolor="#ffffff">
    					<textarea name="Text2" id="Text2" cols="80" rows="6"><%=v.getText2()%></textarea>
    				</td>
			</tr>

<!--图片-->
<tr id="postFormAttachIds" >
	<td class="form_label" align="right">上传照片</td>
 	<td bgcolor="#FFFFFF"  align="left">
 		<input type="hidden" name="Attachids" id="Attachids" value="<%=v.getAttachids()%>"/>
	    
	<%
if(cmd.equals("update")||"view".equals(cmd)){
	String cid = v.getAttachids();
	if(!cid.equals("-1")&&!cid.equals("")){%>
	<img id="FrequencyPic" name="FrequencyPic" src="<%=HeadConst.apache_url+cid%>" alt="照片" title="照片" onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<%}else{%>
	<img id="FrequencyPic" name="FrequencyPic" src="" alt="照片" title="照片" style="display:none"  onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<a href="javascript: deletePic();" ><img id="deletePic" name="deletePic" src='../../images/delete.gif' alt='删除' title='删除' border="0" style="display:none"/></a>
<%	}
}else{%>
	<img id="FrequencyPic" name="FrequencyPic" src="" alt="照片" title="照片" style="display:none"  onload="javascript:DrawImage(this,200,200)" height="200" width="200"/>
	<a href="javascript: deletePic();" ><img id="deletePic" name="deletePic" src='../../images/delete.gif' alt='删除' title='删除' border="0" style="display:none"/></a>
<%}
if(!"view".equals(cmd)){%>
		<br/>
		<input type="file" name="FrequencyInfo" id="FrequencyInfo" size="40"/> 
	    <input type="button" value="上传"  onclick="checkType();"/>
	    <div style="color:red">
	    	支持以下格式的文件：.gif、.jpg、.jpeg、.bmp、.png;文件最大3M。
	    	<img style="display:none" id="load" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    </div>
<%}%>
	</td>
</tr>

<!-- 附件、图片end -->
 			<tr>
		    <th  colspan="4" align="center">
		    <%
		    if("view".equals(cmd)){%>
		    	<a href="#" onclick="history.go(-1)" >返回</a>
		    <%}else{%>
		        <input type="button" class="button" value="保存" name="btn1" onclick="formSubmit()"/>&nbsp;&nbsp;&nbsp;
		    <%}
		    %>
		    </th>
			</tr> 
			</table>
		</form>
	</body>
</html>
