/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-07 06:53:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.youthhonour;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.Power;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import com.xietong.software.sdtw.club.CurrentSemester;
import com.xietong.software.sdtw.youthhonour.YouthhonourUtil;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class YouthhonourStudentForm14_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/main/js/jsheader.jsp", Long.valueOf(1485156249000L));
    _jspx_dependants.put("/student/pagetop-positionandhelp.jsp", Long.valueOf(1487123456000L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("var GBasePath = \"");
      out.print(HeadConst.root_url_path);
      out.write("\";\r\n");
      out.write("var GResPath = \"");
      out.print(HeadConst.apache_url);
      out.write("/main\";\r\n");
{
      out.write("var GImagePath = \"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
UserInfo ui = Tool.getUserInfo(request); if (ui == null) out.print("blue"); else out.print(ui.getSkinId());
      out.write('"');
      out.write(';');
}
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write('\r');
      out.write('\n');

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

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/common-student.css\">\r\n");
      out.write("\t\t<script src=\"../../js/tablelist.js\"></script> \r\n");
      out.write("\t\t<script src=\"../js/jquery.min.js\"></script> \r\n");
      out.write("\t\t<script src=\"");
      out.print(userInfo.getRootUrl());
      out.write("/main/js/formfunction.js\"></script>\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/ajaxfileupload.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t上传文档格式过滤\r\n");
      out.write("\t\t\t*/\r\n");
      out.write("\t\t\tfunction checkDocType(){//上传文档格式过滤\r\n");
      out.write("\t\t\t\tvar file=document.getElementById('OtherAttach').value;\r\n");
      out.write("\t\t\t\tif(file){\r\n");
      out.write("\t\t\t\t\tvar allowType = {\"doc\":\"\", \"xls\":\"\", \"docx\":\"\", \"xlsx\":\"\",\"pdf\":\"\"};\r\n");
      out.write("\t\t\t\t\tvar filename=file.replace(/.*(\\/|\\\\)/, \"\");//jquery获得文件名\r\n");
      out.write("\t\t\t\t\tvar fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : '';//jquery获得后缀名\r\n");
      out.write("\t\t\t\t\tif((fileExt+\"\").toLowerCase() in allowType){\r\n");
      out.write("\t\t\t\t\t\tuploadOtherAttatch();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\talert(\"上传文件格式不符合要求，请重新选择！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction checkFile(){//过滤重复上传附件\r\n");
      out.write("\t\t\t\tvar file=document.getElementById('OtherAttach').value;\r\n");
      out.write("\t\t\t\tif(file){\r\n");
      out.write("\t\t\t\t\tvar filename = file.replace(/.*(\\/|\\\\)/, \"\");\r\n");
      out.write("\t\t\t\t\tif(document.postForm.Attachids.value.indexOf(filename)!=-1){\r\n");
      out.write("\t\t\t\t\t\talert('上传附件名相同，请修改名称后再上传!');\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\t\r\n");
      out.write("\t\t\t\t\t\tuploadOtherAttatch();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction uploadOtherAttatch(){//上传其他附件\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t    $(\"#load1\").ajaxStart(function(){\r\n");
      out.write("\t\t\t        $(this).show();\r\n");
      out.write("\t\t\t    }).ajaxComplete(function(){\r\n");
      out.write("\t\t\t        $(this).hide();\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t  \t\r\n");
      out.write("\t\t\t    $.ajaxFileUpload\r\n");
      out.write("\t\t\t    (\r\n");
      out.write("\t\t\t        {\r\n");
      out.write("\t\t\t            url:'YouthHonourAction.jsp?cmd=otherattach&type=");
      out.print(type);
      out.write("',\r\n");
      out.write("\t\t\t            secureuri:false,\r\n");
      out.write("\t\t\t            fileElementId:'OtherAttach',\r\n");
      out.write("\t\t\t            dataType: 'json',\r\n");
      out.write("\t\t\t            success: function (data, status)\r\n");
      out.write("\t\t\t            {\r\n");
      out.write("\t\t\t                if(typeof(data.error) != 'undefined')\r\n");
      out.write("\t\t\t                {\r\n");
      out.write("\t\t\t                    if(data.error != '')\r\n");
      out.write("\t\t\t                    {                    \r\n");
      out.write("\t\t\t                        alert(data.error);\r\n");
      out.write("\t\t\t                    }else\r\n");
      out.write("\t\t\t                    {\r\n");
      out.write("\t\t                         \tvar be = data.url.indexOf(\"=\");\r\n");
      out.write("\t\t                         \tvar en = data.url.lastIndexOf(\"/\");\r\n");
      out.write("\t\t                        \t\r\n");
      out.write("\t\t                        \tvar attachidlen=$('#Attachids').val();\r\n");
      out.write("\t\t                        \tif(attachidlen.length>0){\r\n");
      out.write("\t\t\t                         \tdocument.postForm.Attachids.value=attachidlen+\",\"+data.ids;\r\n");
      out.write("\t\t                        \t}else{\r\n");
      out.write("\t\t                         \t\tdocument.postForm.Attachids.value= data.ids;\r\n");
      out.write("\t\t                        \t}\r\n");
      out.write("\t\t                        \t\r\n");
      out.write("// \t\t                         \tdocument.postForm.Attachids.value= data.ids;\r\n");
      out.write("\t\t\t                        var table = document.getElementById('ShowFiles');\r\n");
      out.write("\t\t\t                        var num = table.rows.length;\r\n");
      out.write("\t\t\t                        var row = table.insertRow(num);\r\n");
      out.write("\t\t\t                        var filename = data.url.replace(/.*(\\/|\\\\)/, \"\");\r\n");
      out.write("\t\t\t                       \r\n");
      out.write("\t\t\t                        var cell = row.insertCell(0);\r\n");
      out.write("\t\t\t                        ");

			                        	if(cmd.equals("update")){
			                        
      out.write("\r\n");
      out.write("\t\t\t                        row.id = data.ids;//修改时以防和之前重名\r\n");
      out.write("\t\t\t\t\t                        cell.innerHTML =  '<img src=\\'../images/file1.gif\\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\\'../images/delete.gif\\' alt=\\'删除\\' title=\\'删除\\' onclick=\\'deleteUpdateFile(\"tempnew'+filename+'\",'+data.url.substring(be+1,en)+');\\' style=\"cursor:point;\"/>';\r\n");
      out.write("\t\t\t                        ");

			                        	}else{
			                        
      out.write("\r\n");
      out.write("\t\t\t                        row.id = data.ids;//修改时以防和之前重名\r\n");
      out.write("\t\t\t\t\t                        cell.innerHTML =  '<img src=\\'../images/file1.gif\\'/> '+filename+'&nbsp;&nbsp;&nbsp;&nbsp;<img src=\\'../images/delete.gif\\' alt=\\'删除\\' title=\\'删除\\' onclick=\\'deleteUpdateFile(\"'+filename+'\",'+data.url.substring(be+1,en)+');\\' style=\"cursor:point;\"/>';\r\n");
      out.write("\t\t\t                        ");

			                        	}
			                        
      out.write("\r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                }\r\n");
      out.write("\t\t\t            },\r\n");
      out.write("\t\t\t            error: function (data, status, e)\r\n");
      out.write("\t\t\t            {\r\n");
      out.write("\t\t\t                alert(\"上传文件失败，请重新上传！\");\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    )\r\n");
      out.write("\t\t\t} \r\n");
      out.write("\r\n");
      out.write("\t\t\tfunction deleteUpdateFile(name,id){//删除修改时上传附件\r\n");
      out.write("\t\t\t\tif(confirm('是否确定删除？')){\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\ttype:\"post\",\t\t\t\r\n");
      out.write("\t\t\t\t\t\turl:\"YouthHonourAction.jsp?cmd=delAttach&type=");
      out.print(type);
      out.write("&did=\"+id,\r\n");
      out.write("\t\t\t\t\t\tdataType:\"json\",\r\n");
      out.write("\t\t\t\t\t\tbeforeSend:function(){\r\n");
      out.write("\t\t\t\t\t\t\t$(\"#load1\").show();\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tsuccess:function(data, status, e){\r\n");
      out.write("\t\t\t\t        \tif(typeof(data.error) != 'undefined'){\r\n");
      out.write("\t\t\t                    if(data.error != '')\r\n");
      out.write("\t\t\t                    {\r\n");
      out.write("\t\t\t                        alert(data.error);\r\n");
      out.write("\t\t\t                    }else\r\n");
      out.write("\t\t\t                    {\r\n");
      out.write("\t\t\t                    \t$(\"#load1\").hide();\r\n");
      out.write("\t\t\t        \t\t\t\tvar row = document.getElementById(name);\r\n");
      out.write("\t\t\t        \t\t\t\tfor(var i=0;i<row.cells.length;i++){\r\n");
      out.write("\t\t\t        \t\t\t\t\trow.deleteCell(i);\r\n");
      out.write("\t\t\t        \t\t\t\t}\r\n");
      out.write("\t\t\t        \t\t\t\tvar files = document.postForm.Attachids.value;\r\n");
      out.write("\t\t\t        \t\t\t\t//alert(files+\" \"+id+\" \"+files.indexOf(id))\r\n");
      out.write("\t\t\t        \t\t\t\tif(files.indexOf(id)!=-1){\r\n");
      out.write("\t\t\t        \t\t\t\t\t//替换删掉的附件id\r\n");
      out.write("\t\t\t        \t\t\t\t\tfiles = \",\"+files+\",\";\r\n");
      out.write("\t\t\t        \t\t\t\t\tfiles = files.replace(\",\"+id+\",\",',');\r\n");
      out.write("\t\t\t        \t\t\t\t\t//没有附件的情况\r\n");
      out.write("\t\t\t        \t\t\t\t\tif(files.indexOf(\",\")==files.lastIndexOf(\",\"))\r\n");
      out.write("\t\t\t        \t\t\t\t\t\tfiles = \"\";\r\n");
      out.write("\t\t\t        \t\t\t\t\telse{\r\n");
      out.write("\t\t\t        \t\t\t\t\t\tfiles = files.substring(1,files.length-1);\r\n");
      out.write("\t\t\t        \t\t\t\t\t}\r\n");
      out.write("\t\t\t        \t\t\t\t\tdocument.postForm.Attachids.value = files;\r\n");
      out.write("\t\t\t        \t\t\t\t}\r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                }\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t             },\r\n");
      out.write("\t\t\t            error: function (data, status, e){\r\n");
      out.write("\t\t\t            \t$(\"#load1\").hide();\r\n");
      out.write("\t\t\t                alert(\"上传文件失败，请重新上传！\");\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//图片\r\n");
      out.write("\t\t\tfunction deletePic(){\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tdocument.postForm.Attachids.value=\"\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"FrequencyPic\").style.display = \"none\";\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"deletePic\").style.display = \"none\";\r\n");
      out.write("\t\t\t\talert(\"图片已成功删除\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction ajaxFileUpload(){//上传示意图片 \r\n");
      out.write("\t\t\t\tvar Attachids;//保存上传成功后 图片在服务器上的路径\r\n");
      out.write("\t\t\t\tvar fileElement;//保存本地要上传的文件 的 地址\r\n");
      out.write("\t\t\t\tvar picPath;//在form页  上传后显示示\r\n");
      out.write("// \t\t\t\tImageInfo = document.postForm.ImageInfo.value;\r\n");
      out.write("\t\t\t\tAttachids = document.postForm.Attachids.value;\r\n");
      out.write("\t\t\t\t//alert(ImageInfo);\r\n");
      out.write("\t\t\t\t\tfileElement='FrequencyInfo';\r\n");
      out.write("\t\t\t\t\tpicPath='FrequencyPic';\r\n");
      out.write("\t\t\t    $(\"#load\")\r\n");
      out.write("\t\t\t    .ajaxStart(function(){\r\n");
      out.write("\t\t\t        $(this).show();\r\n");
      out.write("\t\t\t    })\r\n");
      out.write("\t\t\t    .ajaxComplete(function(){\r\n");
      out.write("\t\t\t        $(this).hide();\r\n");
      out.write("\t\t\t    });\r\n");
      out.write("\t\t\t    $.ajaxFileUpload\r\n");
      out.write("\t\t\t    (\r\n");
      out.write("\t\t\t        {\r\n");
      out.write("\t\t\t            url:'YouthhonourStudentForm-save.jsp?cmd=upPic&Attachids='+Attachids,\r\n");
      out.write("\t\t\t            secureuri:false,\r\n");
      out.write("\t\t\t            fileElementId:fileElement,\r\n");
      out.write("\t\t\t            dataType: 'json',\r\n");
      out.write("\t\t\t            success: function (data, status)\r\n");
      out.write("\t\t\t            {\r\n");
      out.write("\t\t\t           \r\n");
      out.write("\t\t\t                if(typeof(data.error) != 'undefined')\r\n");
      out.write("\t\t\t                {\r\n");
      out.write("\t\t\t                    if(data.error != '')\r\n");
      out.write("\t\t\t                    {\r\n");
      out.write("\t\t\t                        alert(data.error);\r\n");
      out.write("\t\t\t                    }else\r\n");
      out.write("\t\t\t                    {\r\n");
      out.write("\t\t\t                        var pic = document.getElementById(picPath);\r\n");
      out.write("\t\t\t                        pic.src = '");
      out.print(HeadConst.apache_url);
      out.write("'+data.url+'?time='+new Date();\r\n");
      out.write("\t\t\t                        pic.style.display = '';\r\n");
      out.write("// \t\t\t                        \tdocument.postForm.ImageInfo.value = data.url;    \r\n");
      out.write("\t\t\t                        \tdocument.postForm.Attachids.value = data.url;    \r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                }\r\n");
      out.write("\t\t\t            },\r\n");
      out.write("\t\t\t            error: function (data, status, e)\r\n");
      out.write("\t\t\t            {\r\n");
      out.write("\t\t\t                alert(\"上传文件失败，请重新上传！\");\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    )\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction checkType(){//上传图片格式过滤\r\n");
      out.write("\t\t\t\tvar file=document.getElementById('FrequencyInfo').value;\r\n");
      out.write("\t\t\t\tif(file){\r\n");
      out.write("\t\t\t\t\tvar allowType = {\"gif\":\"\", \"jpg\":\"\", \"jpeg\":\"\", \"bmp\":\"\", \"png\":\"\"};\r\n");
      out.write("\t\t\t\t\tvar filename=file.replace(/.*(\\/|\\\\)/, \"\");//jquery获得文件名\r\n");
      out.write("\t\t\t\t\tvar fileExt=(/[.]/.exec(filename)) ? /[^.]+$/.exec(filename.toLowerCase()) : ''; //jquery获得后缀名\r\n");
      out.write("\t\t\t\t\tif((fileExt+\"\").toLowerCase() in allowType){\r\n");
      out.write("\t\t\t\t\t\tajaxFileUpload();\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\telse{\r\n");
      out.write("\t\t\t\t\t\talert(\"上传文件格式不符合要求，请重新选择！\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t");

	String strposition = "组织建设>>五四评比表彰>>";
	String strfunction =yhUtil.youthhonourName.get(type);
	String strhelpwords = "申请表。";
	
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table class=\"location-table\">\r\n");
      out.write("<tr height=\"35\">\r\n");
      out.write("\t<td class=\"location-title\" >您的位置：");
      out.print(strposition );
      out.write("\r\n");
      out.write("\t\t<span style=\"cursor:pointer;\" onclick=\"showorhide_div('helpdiv')\">");
      out.print(strfunction );
      out.write("</span>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"helpdiv\" style=\"display:none;\">\r\n");
      out.write("<table \tclass=\"location-help\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" >\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\">系统帮助：</td>\r\n");
      out.write("   \t<td width=\"30\"> \r\n");
      out.write("\t\t<a align=\"right\" href=\"#\" onclick=\"showorhide_div('helpdiv')\"><font face='Webdings' color='#FF0000' style='font- size:32pt'>r</font></a>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr height=\"20\">\r\n");
      out.write("\t<td align=\"left\">");
      out.print(strhelpwords );
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function showorhide_div(menu){\r\n");
      out.write("    $(\"#\"+menu).toggle();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<table class=\"command-table\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td><a href=\"YouthhonourStudentList.jsp?noticeid=");
      out.print(noticeid);
      out.write("\" >返回</a></td>\r\n");
      out.write("\t</tr>    \r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"YouthhonourStudentForm-save.jsp\" method=\"post\" name=\"postForm\" id=\"postForm\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"cmd\" value=\"");
      out.print(cmd);
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"Id\" value=\"");
      out.print(v.getId());
      out.write("\"/>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<input type=\"hidden\" name=\"Noticeid\" value=\"");
      out.print(noticeid);
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"noticeid\" value=\"");
      out.print(noticeid);
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"Type\" value=\"");
      out.print(type);
      out.write("\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"hidden\" name=\"Addaccount\" value=\"");
      out.print(v.getAddaccount());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"Addtime\" value=\"");
      out.print(v.getAddtime());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"XyCheckDate\" value=\"");
      out.print(v.getXyCheckDate());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"TwCheckDate\" value=\"");
      out.print(v.getTwCheckDate());
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"SchoolYear\"  value=\"");
      out.print(v.getSchoolYear());
      out.write("\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"hidden\" name=\"AyCheckFlag\" id=\"AyCheckFlag\" value=\"");
      out.print(v.getAyCheckFlag());
      out.write("\"/>\r\n");
      out.write("  \t<input type=\"hidden\" name=\"TwCheckFlag\" id=\"TwCheckFlag\" value=\"");
      out.print(v.getTwCheckFlag());
      out.write("\"/>\r\n");
      out.write("  \t<input type=\"hidden\" name=\"ModifyFlag\" id=\"ModifyFlag\" value=\"");
      out.print(v.getModifyFlag());
      out.write("\"/>\r\n");
      out.write("    <input type=\"hidden\" name=\"XyReport\" id=\"XyReport\" value=\"");
      out.print(v.getXyReport());
      out.write("\"/>\r\n");
      out.write(" \t<input type=\"hidden\" name=\"TwReport\" id=\"TwReport\" value=\"");
      out.print(v.getTwReport());
      out.write("\"/>\r\n");
      out.write("\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val9\" id=\"Val9\" value=\"");
      out.print(v.getVal9());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val10\" id=\"Val10\" value=\"");
      out.print(v.getVal10());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val11\" id=\"Val11\" value=\"");
      out.print(v.getVal11());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val12\" id=\"Val12\" value=\"");
      out.print(v.getVal12());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val13\" id=\"Val13\" value=\"");
      out.print(v.getVal13());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val14\" id=\"Val14\" value=\"");
      out.print(v.getVal14());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val15\" id=\"Val15\" value=\"");
      out.print(v.getVal15());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val16\" id=\"Val16\" value=\"");
      out.print(v.getVal16());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val17\" id=\"Val17\" value=\"");
      out.print(v.getVal17());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val18\" id=\"Val18\" value=\"");
      out.print(v.getVal18());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val19\" id=\"Val19\" value=\"");
      out.print(v.getVal19());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val20\" id=\"Val20\" value=\"");
      out.print(v.getVal20());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val21\" id=\"Val21\" value=\"");
      out.print(v.getVal21());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Val22\" id=\"Val22\" value=\"");
      out.print(v.getVal22());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Text3\" id=\"Text3\" value=\"");
      out.print(v.getText3());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Text4\" id=\"Text4\" value=\"");
      out.print(v.getText4());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Text5\" id=\"Text5\" value=\"");
      out.print(v.getText5());
      out.write("\"/>\r\n");
      out.write(" \t\t\t\t\t<input type=\"hidden\" name=\"Text6\" id=\"Text6\" value=\"");
      out.print(v.getText6());
      out.write("\"/>\t\r\n");
      out.write("\t<table class=\"content-table\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th colspan=\"2\" align=\"left\">");
      out.print(yhUtil.youthhonourName.get(type));
      out.write("</th>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">所属单位</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("\t\t\t");
      out.print(myacademyname);
      out.write("\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"BelongAcademy\" id=\"BelongAcademy\" disabled=\"disabled\" value=\"");
      out.print(v.getBelongAcademy());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">姓名</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val1\" id=\"Val1\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal1());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">性别</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val2\" id=\"Val2\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal2());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">出生年月</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val3\" id=\"Val3\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal3());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("  \t<tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">民族</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val4\" id=\"Val4\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal4());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">政治面貌</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val5\" id=\"Val5\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal5());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">联系电话</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val6\" id=\"Val6\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal6());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td align=\"right\" class=\"form_label\">所在单位</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val7\" id=\"Val7\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal7());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    \t<td align=\"right\" class=\"form_label\">职务</td>\r\n");
      out.write("  \t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t<input name=\"Val8\" id=\"Val8\" size=\"45\" maxsize=\"45\" value=\"");
      out.print(v.getVal8());
      out.write("\"/>\r\n");
      out.write("    \t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\r\n");
      out.write("    \t\t\t<tr>\r\n");
      out.write("    \t\t\t\t<td align=\"right\" class=\"form_label\">主要事迹</td>\r\n");
      out.write("  \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t\t\t\t<textarea name=\"Text1\" id=\"Text1\" cols=\"80\" rows=\"6\">");
      out.print(v.getText1());
      out.write("</textarea>\r\n");
      out.write("    \t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("    \t\t\t<tr>\r\n");
      out.write("    \t\t\t\t<td align=\"right\" class=\"form_label\">获奖情况</td>\r\n");
      out.write("  \t\t\t<td align=\"left\"  bgcolor=\"#ffffff\">\r\n");
      out.write("    \t\t\t\t\t<textarea name=\"Text2\" id=\"Text2\" cols=\"80\" rows=\"6\">");
      out.print(v.getText2());
      out.write("</textarea>\r\n");
      out.write("    \t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("<!--图片-->\r\n");
      out.write("<tr id=\"postFormAttachIds\" >\r\n");
      out.write("\t<td class=\"form_label\" align=\"right\">上传照片</td>\r\n");
      out.write(" \t<td bgcolor=\"#FFFFFF\"  align=\"left\">\r\n");
      out.write(" \t\t<input type=\"hidden\" name=\"Attachids\" id=\"Attachids\" value=\"");
      out.print(v.getAttachids());
      out.write("\"/>\r\n");
      out.write("\t    \r\n");
      out.write("\t");

if(cmd.equals("update")||"view".equals(cmd)){
	String cid = v.getAttachids();
	if(!cid.equals("-1")&&!cid.equals("")){
      out.write("\r\n");
      out.write("\t<img id=\"FrequencyPic\" name=\"FrequencyPic\" src=\"");
      out.print(HeadConst.apache_url+cid);
      out.write("\" alt=\"照片\" title=\"照片\" onload=\"javascript:DrawImage(this,200,200)\" height=\"200\" width=\"200\"/>\r\n");
      out.write("\t");
}else{
      out.write("\r\n");
      out.write("\t<img id=\"FrequencyPic\" name=\"FrequencyPic\" src=\"\" alt=\"照片\" title=\"照片\" style=\"display:none\"  onload=\"javascript:DrawImage(this,200,200)\" height=\"200\" width=\"200\"/>\r\n");
      out.write("\t<a href=\"javascript: deletePic();\" ><img id=\"deletePic\" name=\"deletePic\" src='../../images/delete.gif' alt='删除' title='删除' border=\"0\" style=\"display:none\"/></a>\r\n");
	}
}else{
      out.write("\r\n");
      out.write("\t<img id=\"FrequencyPic\" name=\"FrequencyPic\" src=\"\" alt=\"照片\" title=\"照片\" style=\"display:none\"  onload=\"javascript:DrawImage(this,200,200)\" height=\"200\" width=\"200\"/>\r\n");
      out.write("\t<a href=\"javascript: deletePic();\" ><img id=\"deletePic\" name=\"deletePic\" src='../../images/delete.gif' alt='删除' title='删除' border=\"0\" style=\"display:none\"/></a>\r\n");
}
if(!"view".equals(cmd)){
      out.write("\r\n");
      out.write("\t\t<br/>\r\n");
      out.write("\t\t<input type=\"file\" name=\"FrequencyInfo\" id=\"FrequencyInfo\" size=\"40\"/> \r\n");
      out.write("\t    <input type=\"button\" value=\"上传\"  onclick=\"checkType();\"/>\r\n");
      out.write("\t    <div style=\"color:red\">\r\n");
      out.write("\t    \t支持以下格式的文件：.gif、.jpg、.jpeg、.bmp、.png;文件最大3M。\r\n");
      out.write("\t    \t<img style=\"display:none\" id=\"load\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/loading.gif\"/>\r\n");
      out.write("\t    </div>\r\n");
}
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<!--end pic-->\r\n");
      out.write(" \t\t\t<tr>\r\n");
      out.write("\t\t    <th  colspan=\"4\" align=\"center\">\r\n");
      out.write("\t\t    ");

		    if("view".equals(cmd)){
      out.write("\r\n");
      out.write("\t\t    \t<a href=\"#\" onclick=\"history.go(-1)\" >返回</a>\r\n");
      out.write("\t\t    ");
}else{
      out.write("\r\n");
      out.write("\t\t        <input type=\"button\" class=\"button\" value=\"保存\" name=\"btn1\" onclick=\"javascript:document.postForm.submit()\"/>&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t    ");
}
		    
      out.write("\r\n");
      out.write("\t\t    </th>\r\n");
      out.write("\t\t\t</tr> \r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
