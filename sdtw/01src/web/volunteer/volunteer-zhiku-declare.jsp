<%@ page pageEncoding="utf-8" %>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*,java.util.*,jxl.*,jxl.write.*,java.math.BigDecimal"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.common.HeadConst"%>
<%@page import="com.xietong.software.base.Power"%>
<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<%@page import="com.xietong.software.common.CEditConst"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@page import="com.xietong.software.sdtw.db.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="../css/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../js/tablelist.js"></script>
<script src="../js/jquery.min.js"></script>
<script language="JavaScript" src="../main/js/ajaxfileupload.js"></script>
<script src="../main/js/common.js"></script>
<style type="text/css">
.itemname{
	display:inline-block;
	width:100px;
	text-align:center;
}
</style>
<%String cmd = ParamUtils.getParameter(request,"cmd",""); %>
<script type="text/javascript">





function form1submit(){
	
		if(form1datacheck()){document.form1.submit();}
		
		
	
}
function jisuan(){
	var cost1=$("#Cost1").val();
	var cost2=$("#Cost2").val();
	var cost3=$("#Cost3").val();
	var cost4=$("#Cost4").val();
	var cost5=$("#Cost5").val();
	var zongji=Number(cost1)+Number(cost2)+Number(cost3)+Number(cost4)+Number(cost5);
	//alert(zongji);
	$("#Totalcost").val(zongji);
}
function form99cancel(){
	window.location.href="volunteer-zhiku-list.jsp";
}
function uploadOtherAttatch(){//上传其他附件
	//debugger;
	var name=document.getElementById('OtherAttach').value;
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
            url:'VolunteerZhikuDeclareAction.jsp?cmd=otherattach',
            secureuri:false,
            fileElementId:'OtherAttach',
            type:'post',	
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
                    	//alert(data.ids);
                    	// if(document.postForm.AddFileList.value==""){
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.form1.Addfilelist.value = data.ids;
                        
                        /*  }else{
                         	var be = data.url.indexOf("=");
                         	var en = data.url.lastIndexOf("/");
                         	document.postForm.AddFileList.value += ","+data.ids;
                         }  */
                         
                        var table = document.getElementById('ShowFiles');
                        var num = table.rows.length;
                        var row = table.insertRow(num);
                        var filename = data.url.replace(/.*(\/|\\)/, "");
                        filename = data.name;
                        
                        var cell = row.insertCell(0);
                        <%
                        	if(cmd.equals("update")){
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
                        <%
                        	}else{
                        %>
		                        row.id = data.ids;//修改时以防和之前重名
		                        cell.innerHTML =  '<img src=\'<%=HeadConst.apache_url %>/main/images/file1.gif\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\'<%=HeadConst.apache_url %>/main/images/delete.gif\' alt=\'删除\' title=\'删除\' onclick=\'deleteUpdateFile("'+filename+'",'+data.ids+');\' style="cursor:point;"/>';
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
function checkFileType(){//上传文档格式过滤
	var file=document.getElementById('OtherAttach').value;
	if(file){
		var allowType = {"doc":"", "xls":"", "docx":"", "xlsx":""};
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
function addItem(){

	openWindow("BaseUserCodeAction.jsp?values="+$("#SId").val(),"703,400");


	}
	function setRole(pName,pId){
		$("#teamtable").append(pName);
		$("#SId").val(pId);
	}
function deleteUpdateFile(name,id){//删除修改时上传附件
	if(confirm('是否确定删除？')){
		$.ajax({
			type:"post",			
			url:"club-setup-addsave.jsp?cmd=delAttach&did="+id,
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
        				
        				var files = document.form1.AddFileList.value;
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
        					document.form1.AddFileList.value = files;
        				}
                    }
                }
             },
            error: function (data, status, e){
            	$("#load1").hide();
                alert("删除文件失败!");
            }
		});
	}
	return false;
}
function deleteSponsor(trid,id){
	$('#'+trid).remove();
	var files = document.form1.SId.value;
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
		document.form1.SId.value = files;
	}
}
</script>
</head>
<%
String ckid=request.getParameter("id");
VolunteerZhikuDeclare vzd=new VolunteerZhikuDeclare();
String useraccount=(String)session.getAttribute("useraccount");

String cd4="";
String cd5="";

UserInfo userinfo = Tool.getUserInfo(request);
if(!userinfo.hasFunPower(Power.USERSTUDENTPOWER)){
	out.print(HtmlTool.msgBox(request, "请先登录"));
	if (userinfo != null) {
		userinfo.removeCookie(response);
	}
	session.removeAttribute("UserInfo");
	return ;
}
BaseUserCode user=userinfo.getUserCode();

%>
<body>
<%
String strposition = "志愿服务>>山大志库>>";
String strfunction = "申请表";
String strhelpwords = "填写申请表。";
VolunteerZhiku vz= new VolunteerZhiku();
vz=vz.getById(Integer.parseInt(ParamUtils.getParameter(request, "zhikuId", "")));
%>
 <table class="location-table">
<tr height="35">
	<td class="location-title" >您的位置>>志愿服务>>山大志库>><%=vz.getNoticeName() %>申请表
		<span style="cursor:pointer;" onclick="showorhide_div('helpdiv')"></span>
	</td>
</tr>
</table>

<table class="command-table">
<tr height="35px">
	<td>
		<a href="volunteer-zhiku-list.jsp">返回</a>
	</td>
</tr>    
</table>


<form name="form1" method="post" action="VolunteerZhikuDeclareAction.jsp?cmd=save1">
<table class="content-table">
<tr>
	<th colspan="8" align="left">“山大志库”项目入库申请表</th> 
</tr>

<tr>
	<td width="27%" align="right">项目名称</td>
	<td align="left" colspan="2"><input type="text" name="Name" size="40"/></td>
	<input type="hidden" name="ZhikuId" size="40" value="<%=ParamUtils.getParameter(request, "zhikuId", "")%>"/>
	<input type="hidden" name="AddAccount" size="40" value="<%=user.getName()%>"/>
	<input type="hidden" name="Addtime" size="40" value="<%=new Date()%>"/>
	<input type="hidden" name="SId"  id="SId" />
	</td>
</tr>
<%
UserInfo userInfo = Tool.getUserInfo(request);
List ZkProjectTypeOptions= CEditConst.getZkProjectTypeOptions(userInfo);
List zhuguanoptions=CEditConst.getAcademyNameOptions(userInfo);
%>
<tr>
	<td align="right">团队名称</td>
	<td align="left" colspan="2"><input type="text" name="Teamname" size="40"/></td>
</tr>
<tr>
	<td align="right">所属单位</td>
	<td align="left" colspan="2"><%=HtmlTool.renderSelect(zhuguanoptions, "" + "", "Academy", "-1")%></td>
</tr>

<tr>
	<td align="right">项目分组</td>
	<td align="left" colspan="2">
	
		<%=HtmlTool.renderSelect(ZkProjectTypeOptions,"", "Type", "")%>
	</td>
</tr>
<tr>
	<td align="right">活动背景及目的</td>
	<td align="left" colspan="2"><textarea name="Intention" cols="100" rows="10" placeholder=""></textarea></td>
</tr>
<tr>
	<td align="right">活动时间安排</td>
	<td align="left" colspan="2"><textarea name="Arrange" cols="100" rows="10" placeholder=""></textarea></td>
</tr>
<tr>
	<td align="right">活动流程</td>
	<td align="left" colspan="2"><textarea name="Process" cols="100" rows="10" placeholder="前期准备、活动实施、后期阶段"></textarea>
	</td>
</tr>
<tr>
	<td align="right">预期成果</td>
	<td align="left" colspan="2"><textarea name="Expectresults" cols="100" rows="10" placeholder=""></textarea></td>
</tr>
<tr>
	<td align="right">已取得成果（选填）</td>
	<td align="left" colspan="2"><textarea name="Results" cols="100" rows="10" placeholder=""></textarea></td>
	<input type="hidden" name="Cost6" id="Cost6"/>
</tr>

<tr>
	<td align="right"><p>团队组成情况<p/><a href="#" onclick="addItem();return false;">添加</a></td>
	<td align="left" colspan="2">
	
		<table id="teamtable"   style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td >姓名</td><td>学院</td><td>联系方式</td><td>团队分工</td>
			</tr>
			

		</table>
		
	</td>
</tr>
<tr>
	<td align="right">项目情况</td>
	<td align="left" colspan="2">
		<p><span class="itemname">交通费  </span><input  id="Cost1" name="Cost1"><!-- onblur="jisuan()"仅能输入整数或者小数 --></p>
		<p><span class="itemname">住宿费  </span><input  id="Cost2"name="Cost2"><!-- 仅能输入整数或者小数 --></p>
		<p><span class="itemname">其它（请说明）  </span><input id="Cost3"name="Cost3" ><!-- 仅能输入整数或者小数 --></p>
		<p><span class="itemname">其它（请说明）  </span><input id="Cost4" name="Cost4"><!-- 仅能输入整数或者小数 --></p>
		<p><span class="itemname">其它（请说明）  </span><input  id="Cost5"name="Cost5"><!-- 仅能输入整数或者小数 --></p>
	
		<p><span class="itemname">共计  </span><input type="text" name="Totalcost" id="Totalcost" ></p>
	</td>
</tr>
			<tr height="35"><td colspan="4" class="blocktitle">附件上传</td></tr>
<input type="hidden" name="Addfilelist" id="Addfilelist" value="<%=vzd.getAddfilelist()%>"/>
<input type="hidden" name="Id" id="Id"value="<%=vzd.getId()%>"/>
<tr id="postFormBookedBooths">
	<td class="form_label"  width="14%" >
	<div align="right">相关附件：</div>
	</td>
		<td bgcolor="#FFFFFF" colspan="3" align="left">
		<table width="100%" border="0" cellspacing="0" id="ShowFiles">
			<%
				if(vzd.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = vzd.getAddfilelist();
					if(ids!=null&&ids.trim().length()>0){
						String[] idArray = Tool.split(",",ids);
						for(int i=0;i<idArray.length;i++){
							ClientAttach ca1 = ca.getById(Tool.StrToInt(idArray[i]));
							if(ca1!=null){
								%>
								<tr id="<%=ca1.getId() %>"><td><a href="<%=HeadConst.apache_url %>/servlet/attach?type=otherattach&id=<%=ca1.getId() %>" target="_blank">
								<img src='<%=HeadConst.apache_url%>/main/images/file1.gif' border="0"/> <%=ca1.getUploadName() %></a>&nbsp;&nbsp;&nbsp;&nbsp;
								<img src='<%=HeadConst.apache_url%>/main/images/delete.gif' alt='删除' title='删除' border="0" onclick="javascript:deleteUpdateFile('<%=ca1.getUploadName()%>','<%=ca1.getId() %>')" style="cursor:point;"/></td></tr>
								<%	}
								}
							}
						}
					%>
		</table>
		<%if(vzd.getId()==-1){%>
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
		<%} %>
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大5M</div>
	</td>
</tr>


<tr>
	<th colspan="3">
		<input class="button" type="button" value="提交" name="btn1" onclick="form1submit()">&nbsp;&nbsp;&nbsp;
    	<input class="button" type="button" value="取消" name="btn2" onclick="form99cancel()">&nbsp;&nbsp;&nbsp;
	</th>
</tr>
</table>
 
</form>

<script type="text/javascript">
function form1datacheck()
{   
	
	if (document.form1.Name.value==""){
		alert("项目名称不能为空！");
		document.form1.Name.focus();
		return false;
	}
	if (document.form1.Teamname.value==""){
		alert("团队名称不能为空！");
		document.form1.Teamname.focus();
		return false;
	}
	if (document.form1.Type.value==""){
		alert("项目分组不能为空！");
		document.form1.Type.focus();
		return false;
	}
	if (document.form1.Intention.value==""){
		alert("活动背景与目的不能为空！");
		document.form1.Intention.focus();
		return false;
	}
	if (document.form1.Arrange.value==""){
		alert("活动时间安排不能为空！");
		document.form1.Arrange.focus();
		return false;
	}
	if (document.form1.Process.value==""){
		alert("活动流程不能为空！");
		document.form1.Process.focus();
		return false;
	}
	if (document.form1.Expectresults.value==""){
		alert("预期成果不能为空！");
		document.form1.Expectresults.focus();
		return false;
	}
	return true;
}
</script>

</body>
</html>