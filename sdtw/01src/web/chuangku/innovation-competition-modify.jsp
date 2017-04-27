<%@ page contentType="text/html;charset=utf-8" %>
<%@ page session="true"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*" %> 
<%@page import="com.xietong.software.sdtw.db.BaseUserCode"%>
<%@page import="com.xietong.software.common.UserInfo"%>
<%@page import="com.xietong.software.util.Tool"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@page import="com.xietong.software.sdtw.db.*"%>






<%

String f1="\10";
String f2="\20";
//接收客户端提交的数据

String production_code="",production_name="", projectname="",academy="",declarer="", production_type="",declarer_role="",leader="",leaderid="",team="",teamid="",remark="", addfilelist="";

 %>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="../css/linestable.css">
<link rel="stylesheet" type="text/css" href="../css/common-student.css">
<link rel="stylesheet" type="text/css" href="../css/searchwnd.css">
<script src="../js/jquery.min.js"></script> 
<script src="../js/personlistorder.js"></script> 

<script type="text/javascript">
// 通过form99提交用户输入(同时提取form1数据、form2数据)
function form99submit(){
  // 取form1表单数据,到form99隐藏框
  if(!form1datacheck()){
    return false;
  }

  document.form99.production_code.value =  document.form1.production_code.value;
  document.form99.production_name.value =  document.form1.production_name.value;
  document.form99.projectname.value =  document.form1.projectname.value;
  document.form99.academy.value =  document.form1.academy.value;   
  document.form99.declarer.value =  document.form1.declarer.value; 
  document.form99.production_type.value =  document.form1.production_type.value;
  document.form99.declarer_role.value =  document.form1.declarer_role.value;
  document.form99.leader.value =  document.form1.leader.value;
  document.form99.leaderid.value =  document.form1.leaderid.value;
  document.form99.team.value =  document.form1.team.value;  
  document.form99.teamid.value =  document.form1.teamid.value;  
  document.form99.remark.value =  document.form1.remark.value;
  
  	// 取form2表单数据，即iframe中的文件列表,存储已有的附件信息 
  	var iframestr = document.filelistbox.document.body.innerText;
  	if (iframestr.length==0){
		alert("必须上传申请书！");  
		return false;
  }
    document.form99.addfilelist.value = iframestr.substring(0,iframestr.indexOf("#"));

  // 提交form99数据
  var len=document.form99.elements.length;
  var i;
  for (i=0;i<len;i++){
    document.form99.elements[i].disabled = false;
  } 
  document.form99.submit();
}

function form1datacheck(){  
 	if (document.form1.production_code.value==""){
    	alert("作品编码不能为空！");
    	document.form1.production_code.focus();
    	return false;
  	}
  	if(document.form1.production_name.value == ""){
        alert("作品名称不能为空！");
        document.form1.production_name.focus();
        return false;
  	}
  	if(document.form1.academy.value == ""){
        alert("学院全称不能为空！");
        document.form1.academy.focus();
        return false;
  	}
  	if(document.form1.declarer.value == ""){
        alert("申报者姓名（集体名称）不能为空！");
        document.form1.declarer.focus();
        return false;
  	}
    getteamperson();
    
  return true;
}

//显示之前保存的团队成员
var teampersonid = 0;

</script>
</head>
<body onload="showteam();">

<%
UserInfo userInfo = Tool.getUserInfo(request);
Map xynamemaps=CEditConst.getAcademyNameMap(userInfo);
Map usercnmamemaps=CEditConst.getUserCnNameMap(userInfo);
Map production_typemaps=CEditConst.getProductionTypeMap(userInfo);
Map checkmaps=CEditConst.getCancleCheckFlagMap(userInfo);
String strposition = "创新创业管理>>竞赛管理";
String strfunction = "竞赛作品详细信息";
String strhelpwords = "竞赛作品详细信息。";
int  id=ParamUtils.getIntParameter(request, "Id", -1);

InnovationCompetition ic= new InnovationCompetition();
ic=ic.getById(id);
production_code=ic.getProductionCode();
production_name=ic.getProductionName();

if(ic.getAcademy()!=""){
	academy=(String)xynamemaps.get(ic.getAcademy());

}
projectname=ic.getProjectName();
declarer=ic.getDeclarer();
production_type=(String)production_typemaps.get(ic.getProductionType());
declarer_role=ic.getDeclarerRole();
leader=(String)usercnmamemaps.get(ic.getLeaderId());

%>


<table id="maintable" class="table_frame" cellspacing="0" width="97%">
<tr height="45">
  <td class="table_topic" colspan="8" align="left">
    <table width="100%" height="30" border="0"  cellpadding="0" cellspacing="3">
      <tr height="10">
        <td width="800" rowspan="2" class="table_topic_label"> <font color="#FF3401">【修改竞赛作品】</font>
        </td>
        <td colspan="3" align="center"><br></td>
      </tr>
    </table>
  </td>
</tr>

<form name="form1" method="post" action="teaching-project-save.jsp">
<tr height="40">
  <td  align="right" width="22%"><font color="red">*</font>作品编码：</td>
  <td ><input type="text" name="production_code" size="35" value="<%=production_code%>" maxlength="20"></td>
</tr>   
<tr height="40">
  <td  align="right"><font color="red">*</font>作品名称：</td>
  <td ><input type="text" name="production_name" size="35" value="<%=production_name%>" maxlength="100"></td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>所属项目：</td>
  <td >
  	<select name="projectname" style="width:250px;">
	
		<script type="text/javascript">$("select[name='projectname']").val("<%=projectname%>");</script>
  </td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>学院全称：</td>     
  <td ><input type="text" name="academy"  maxlength="100" size="35" value="<%=academy%>"></td>
</tr>
<tr height="40">
  <td  align="right"><font color="red">*</font>申报者姓名（集体名称）：</td>     
  <td ><input type="text" name="declarer"  maxlength="45" size="35" value="<%=declarer%>"></td>
</tr>
<tr height="40">
	<td  align="right"><font color="red">*</font>作品类别：</td>
  	<td   >
    	<select name="production_type" style="width:245px;">
	      	<option value="自然科学类学术论文">自然科学类学术论文</option>
	      	<option value="哲学社会科学类社会调查报告和学术论文">哲学社会科学类社会调查报告和学术论文</option>
	      	<option value="科技发明制作A类">科技发明制作A类</option>
	      	<option value="科技发明制作B类">科技发明制作B类</option>
    	</select>
		<script type="text/javascript">$("select[name='production_type']").val("<%=production_type%>");</script>
  	</td>
</tr> <tr height="40">
	<td  align="right"><font color="red">*</font>申报类别：</td>
  	<td   >
    	<select name="declarer_role" style="width:245px;">
	      	<option value="学院申报">学院申报</option>
	      	<option value="个人申报">个人申报</option>
    	</select>
		<script type="text/javascript">$("select[name='declarer_role']").val("<%=declarer_role%>");</script>
  	</td>
</tr> 
<tr height="40">
  <td  align="right" ><font color="red">*</font>负责人：</td>
  <td   id="leadertd">
    	<input type="text" id="leader" name="leader" value="<%=leader %>"  size="35" readonly="readonly"/>&nbsp;&nbsp;&nbsp;
	  	<input type="hidden" id="leaderid" name="leaderid" value="" />
  </td>
</tr>
<tr height="40">
  <td   align="right">团队成员：<br><a href="#" onclick="addItem();return false;">修改</a></td>     
  <td   id="teamtd">
 	<table id="teamtable" style="width:100%;font-size:12px;text-align:center;">
			<tr>
				<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td>
			</tr>
		<%
		String snoids="";
		if(ic.getId()!=-1){
			InnovationCompetitionMembers  vpt= new 	InnovationCompetitionMembers();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			String vppid= ic.getId()+"";
			cdt2.add("productionid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(	InnovationCompetitionMembers)list2.get(i);
					snoidlist.add(vpt.getName());
				
				}
			}
		snoids=Tool.join(",", snoidlist);
		System.out.println(snoids+"sssssssssssssssssss");
			BaseUserCode stu= new BaseUserCode();
			List list3= new ArrayList();
			List cdt3= new ArrayList();
			cdt3.add("id in ("+snoids+")");
			String xueyuan="";
			String duty="";
			list3=stu.query(cdt3);
			if(list3.size()>0){
				for(int i=0;i<list3.size();i++){
				stu = (BaseUserCode)list3.get(i)	;
				 xueyuan=(String)CEditConst.getAcademyNameMap(userInfo).get(stu.getDeptId()+"");
				
				%>
				<tr id='deleteSponsor_<%=stu.getId()%>'><td><%=stu.getName() %></td><td><%=stu.getCnName() %></td><td><%=xueyuan %></td><td><%=stu.getPhone() %></td></tr>
				<% 
				}
			}
		}
		
		%>	
			
		</table>
  </td>
</tr>
<tr height="40">     
  <td  align="right">备注：</td>
  <td >
  <textarea name="remark" rows="3" cols="60"><%=remark %></textarea>
  </td>
</tr> 
<input type="hidden"  name="AddFilelist" id="AddFilelist" value="<%=ic.getAddFilelist()%>"/>
<tr id="postFormBookedBooths">
	<td class="form_label"  width="14%" >
	<div align="right">相关附件：</div>
	</td>
		<td bgcolor="#FFFFFF" colspan="3" align="left">
		<table width="100%" border="0" cellspacing="0" id="ShowFiles">
			<%
				if(ic.getId()!=-1){
					ClientAttach ca = new ClientAttach();
					//ca.setDataBase("sdtw");
					String ids = ic.getAddFilelist();
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
		<%if(ic.getId()==-1){%>
		<input type="file" name="OtherAttach" id="OtherAttach" size="40"/> 
		<input type="button" value="上传" id="btn_up"  onclick="checkFileType();" class="formbtn" style="color:black;background-color: #e3e5e8;"/>
		<%} %>
		<img style="display:none" id="load1" src="<%=HeadConst.apache_url%>/main/images/loading.gif"/>
	    <div style="color:red">请上传doc、docx、xlsx或xls格式文件，文件最大1M</div>
	</td>
</tr>
</form>

<%
String filepath = "/datafile/innovation/";
String filenamecode = "";
String mytip = "（如：申请书等）";
boolean needAcademy = false;
String moduleapp = "../role-student/innovation-competition-list.jsp";
%>

<script language="javascript">
	showaddfilelist("<%=addfilelist%>")
</script>

<form name="form99" method="post" action="innovation-competition-modifysave.jsp?id=<%=id%>">
  <input type="hidden" name="production_code" value="">
  <input type="hidden" name="production_name" value="">
  <input type="hidden" name="projectname" value="">
  <input type="hidden" name="academy" value="">
  <input type="hidden" name="declarer" value="">
  <input type="hidden" name="production_type" value="">
  <input type="hidden" name="declarer_role" value="">
  <input type="hidden" name="leader" value="">
  <input type="hidden" name="leaderid" value="">
  <input type="hidden" name="team" value="">
  <input type="hidden" name="teamid" value="">
  <input type="hidden" name="remark" value="">
  <input type="hidden" name="addfilelist" value="">
  <tr height="45">
  <td  colspan="6" align="center">
    <input type="button" value="确定" name="btn1" onclick="form99submit()">&nbsp;&nbsp;&nbsp;
    <input type="button" value="取消" name="btn2" onclick="form99cancel()">&nbsp;&nbsp;&nbsp;
  </td>
</tr>
</form>
</table>

<script type="text/javascript">
  $("select[name='t_academy']").val("<%=academy%>");
  $("input[name='academy']").val("<%=academy%>");
  function form99cancel(){
	modifycancel("'<%=addfilelist%>'");
    window.location.href = "<%=moduleapp%>";
  }
  
  $("input[name='academy']").bind("focusout", function(){
    academystr = $(this).val();
    if(academystr=="") return false;

    ln = academystr.length;
    if(academystr[ln-1]=="；"){
      academystr = academystr.substring(0, academystr.length-2);
    }
        
    if(academystr.length==0) {
      $(this).val("");
      return false;
    }
    academylist = academystr.split(/[:;,，；： ]+/);
    academystr = "";
    for (i=0; i<academylist.length; i++){
      if(academylist[i]=="") continue;
      $.ajax({
        type: "GET",
        url: "../pubpro/academysearch.jsp?academy=" + academylist[i],
        async: false
      }).done(
        function(data){
          data = data.trim();
          if(data.length>0){
              academystr += (data + "；");
          }
          else{
              alert("不存在学院：" + academylist[i]);
          }
      });
    }
    academystr = academystr.substring(0, academystr.length-1);
    $(this).val(academystr);
  });
</script>
</body>
</html>