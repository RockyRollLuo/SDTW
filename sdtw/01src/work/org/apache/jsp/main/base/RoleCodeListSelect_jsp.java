/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-06 06:41:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.base;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class RoleCodeListSelect_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	private static Log log = LogFactory.getLog(com.xietong.software.common.PageControl.class);

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/main/js/jsheader.jsp", Long.valueOf(1485156249000L));
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
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
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
      out.write('\r');
      out.write('\n');

	log.debug("List");
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "list");
	StringBuffer str = new StringBuffer();
	List rows = (List)request.getAttribute("List");
	if (rows == null) {
    		out.print(HtmlTool.msgBox(request, "请先调用Action.jsp！"));
    		return;
	}
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	Map extMaps = (Map)request.getAttribute("Ext");
	List paras = HttpTool.getSavedUrlForm(request, "Ext");
	List urls = (List)paras.get(0);
	List forms = (List)paras.get(1);
	urls.addAll((List)paras.get(2));
	String url = Tool.join("&", urls);
	PageControl pagecontrol = (PageControl)request.getAttribute("PageControl");
	if (pagecontrol == null) {
    		pagecontrol = new PageControl(0, 1, 1);
	}
	String[] dickeys = (String[])request.getAttribute("dickeys");
	String[][] dicvalues = (String[][])request.getAttribute("dicvalues");
	List diclist = new ArrayList();
	for (int i = 0; i < dickeys.length; i ++) {
    		diclist.add("\"" + dickeys[i] + "\": [\"" + Tool.join("\", \"", dicvalues[i]) + "\"]");
	}
	//默认值定义
	UserInfo userInfo = Tool.getUserInfo(request);
	if(userInfo == null){
    		out.print(HtmlTool.msgBox(request, "请先登录"));
    		return;
	}
	String values = ParamUtils.getParameter(request,"values","");

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css_blue.css\">\r\n");
      out.write("\t\t<title> ");
      out.print(request.getAttribute("describe"));
      out.write(" </title>\r\n");
      out.write("\t\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tvar curr_orderby = [\"");
      out.print(HttpTool.getString(extMaps, "orderfield", ""));
      out.write("\", \"");
      out.print(HttpTool.getString(extMaps, "ordertype", ""));
      out.write("\"];\r\n");
      out.write("\t\t\tvar url_para = \"");
      out.print(url);
      out.write("\";\r\n");
      out.write("\t\t\tvar dic = {");
      out.print(Tool.join(", ", diclist));
      out.write("};\r\n");
      out.write("\t\t\tvar keyfield = \"");
      out.print((String)request.getAttribute("keyfield"));
      out.write("\";\r\n");
      out.write("\t\t\tvar allfields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("allfields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar fields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("fields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar queryfields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("queryfields")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar queryvalues = [\"");
      out.print(Tool.join("\", \"", (List)request.getAttribute("queryvalues")));
      out.write("\"];\r\n");
      out.write("\t\t\tvar rows = [");
      out.print(Tool.join(", ", rows));
      out.write("];\r\n");
      out.write("\t\t\tvar hidefields = [\"");
      out.print(Tool.join("\", \"", (String[])request.getAttribute("hidefields")));
      out.write("\"];\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("    \t\t\t\tshowList(\"");
      out.print(request.getAttribute("classname"));
      out.write('"');
      out.write(',');
      out.write(' ');
      out.print(pagecontrol.getCurrPage());
      out.write(", url_para);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction showList1(className, currpage, url_para, aHasCheckbox, cmd, haveSelect,curId,showEdit) {\r\n");
      out.write("\t\t\t    var getRow = function (str, field) {\r\n");
      out.write("\t\t\t        if (str == \"\" || str == \"null\") {\r\n");
      out.write("\t\t\t            str = \"&nbsp;\";\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        var desc = [\"string\", \"\", \"0\", \"text\", \"\"];\r\n");
      out.write("\t\t\t        if (field != undefined) {\r\n");
      out.write("\t\t\t            desc = dic[field];\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        var dalign = desc[0] || \"control\";\r\n");
      out.write("\t\t\t        return \"<td bgcolor=\\\"#FFFFFF\\\" class=\\\"xxybgx1\\\" align='\" + data_align[dalign] + \"'>\" + str + \"</td>\\n\";\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t\t    var getRow1 = function (str, field) {\r\n");
      out.write("\t\t\t        if (str == \"\" || str == \"null\") {\r\n");
      out.write("\t\t\t            str = \"&nbsp;\";\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        var desc = [\"string\", \"\", \"0\", \"text\", \"\"];\r\n");
      out.write("\t\t\t        if (field != undefined) {\r\n");
      out.write("\t\t\t            desc = dic[field];\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        var dalign = desc[0] || \"control\";\r\n");
      out.write("\t\t\t        return \"<td bgcolor=\\\"#FFFFFF\\\" class=\\\"xxybgx\\\" align='\" + data_align[dalign] + \"'>\" + str + \"</td>\\n\";\r\n");
      out.write("\t\t\t    };\r\n");
      out.write("\t\t\t    var hasCheckbox = (aHasCheckbox == undefined) ? true: aHasCheckbox;\r\n");
      out.write("\t\t\t    var showfields = new Array();\r\n");
      out.write("\t\t\t    var showhidefields = new Array();\r\n");
      out.write("\t\t\t    var keyindex = getFieldIndex(keyfield);\r\n");
      out.write("\t\t\t    //var str = showQuery(className, currpage, url_para);\r\n");
      out.write("\t\t\t    var str = \"\";\r\n");
      out.write("\t\t\t    if (typeof(curId) == \"undefined\") {var curId = \"\";}\r\n");
      out.write("\t\t\t    if (typeof(isSelect) == \"undefined\") var isSelect=0;\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    var titlecolor = (isSelect == \"1\") ? \"data_bgcolor_odd\" : \"title_bgcolor\";\r\n");
      out.write("\t\t\t    str = str + \"<table width=\\\"100%\\\" border=\\\"0\\\" align=\\\"center\\\" cellpadding=\\\"2\\\" cellspacing=\\\"1\\\" bgcolor=\\\"#D2D2D2\\\" ><tr>\\n\";\r\n");
      out.write("\t\t\t    if (hasCheckbox) {\r\n");
      out.write("\t\t\t        str = str + \"<td background=\\\"\"+GImagePath+\"/xxybgbg.gif\\\" bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\"><input type=\\\"checkbox\\\" onclick=\\\"selectAll(this);\\\" onchange=\\\"selectAll(this);\\\"></td>\\n\";\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    for (var i = 0; i < fields.length; i ++) {\r\n");
      out.write("\t\t\t        var title = dic[fields[i]][1];\r\n");
      out.write("\t\t\t        title = title.replace(/\\(.*\\)/, \"\");\r\n");
      out.write("\t\t\t        if (title == \"\") title = \"&nbsp;\";\r\n");
      out.write("\t\t\t        str = str + \"<td align=\\\"center\\\" background=\\\"\"+GImagePath+\"/xxybgbg.gif\\\" bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\" onclick=\\\"javascript:setOrderBy('\" + fields[i] + \"', '\" + url_para + \"')\\\" class=\\\"button\\\" nowrap>\" + title;\r\n");
      out.write("\t\t\t        if (curr_orderby != undefined) {\r\n");
      out.write("\t\t\t            if (curr_orderby[0] == fields[i]) {\r\n");
      out.write("\t\t\t                str = str + \"<img src=\\\"\" + order_image[curr_orderby[1]] + \"\\\">\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        str = str + \"</td>\\n\";\r\n");
      out.write("\t\t\t        showfields[i] = getFieldIndex(fields[i]);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    for (var i = 0; i < hidefields.length; i ++) {\r\n");
      out.write("\t\t\t        showhidefields[i] = getFieldIndex(hidefields[i]);\r\n");
      out.write("\t\t\t    }    \r\n");
      out.write("\t\t\t    if(showEdit == \"1\"){\r\n");
      out.write("\t\t\t    \tstr = str + \"<td background=\\\"\"+GImagePath+\"/xxybgbg.gif\\\" bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\" class=\\\"button\\\" nowrap>编辑</td>\\n\";\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    str = str + \"</tr>\\n\";\r\n");
      out.write("\t\t\t    if (rows.length == 0) {\r\n");
      out.write("\t\t\t        str = str + \"<tr><td colspan=\" + (showfields.length + 2) + \" align=\\\"center\\\" bgcolor=\\\"#FFFFFF\\\" class=\\\"xxybgx1\\\">没有记录！</td></tr>\\n\";\r\n");
      out.write("\t\t\t    } \r\n");
      out.write("\t\t\t    else {\r\n");
      out.write("\t\t\t        for (i = 0; i < rows.length; i ++) {\r\n");
      out.write("\t\t\t            var color = (i % 2 != 0) ? \"data_bgcolor_odd\" : \"data_bgcolor_even\";\r\n");
      out.write("\t\t\t            if (rows[i][keyindex] == curId){\r\n");
      out.write("\t\t\t            \tstr = str + \"<tr onMouseOver=\\\"this.bgColor='#7DCDE6';\\\"  onMouseOut=\\\"this.bgColor='';\\\" bgcolor='#7DCDE6'>\\n\";\r\n");
      out.write("\t\t\t            }else{\r\n");
      out.write("\t\t\t            \tstr = str + \"<tr onMouseOver=\\\"this.bgColor='#7DCDE6';\\\"  onMouseOut=\\\"this.bgColor='';\\\">\\n\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t            if (hasCheckbox) {\r\n");
      out.write("\t\t\t            \tif (haveSelect == \"1\" ){\r\n");
      out.write("\t\t\t            \t\tvar selectRowsIdsStr = (selectRowsIds == undefined) ? \"\" : selectRowsIds;\r\n");
      out.write("\t\t\t                \tif (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\"><input type=checkbox name=chk1 checked value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}else{\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\"><input type=checkbox name=chk1 value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                }else{\r\n");
      out.write("\t\t\t                \tvar selectValue = \"");
      out.print(values);
      out.write("\";\r\n");
      out.write("\t\t\t                \tif(selectValue!=\"\"){\r\n");
      out.write("\t\t\t                \t\tselectValue = \",\"+selectValue+\",\";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                \tif(selectValue.length>2&&selectValue.indexOf(\",\"+rows[i][getCodeIndex(\"Id\")]+\",\")>=0){\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\"><input type=checkbox name=chk1 checked=true value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}else{\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td bgcolor=\\\"#FFFFFF\\\" align=\\\"center\\\"><input type=checkbox name=chk1 value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                }\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t             var atitle = \"\";\r\n");
      out.write("\t\t\t            for (var j = 0; j < fields.length; j ++) {\r\n");
      out.write("\t\t\t                var k = showfields[j];\r\n");
      out.write("\t\t\t                if(allfields[k]==\"Id\" ||allfields[k]==\"OrderNo\" ||allfields[k]==\"Name\" || allfields[k]==\"Subject\" || allfields[k] == \"Email\"){\r\n");
      out.write("\t\t\t                \tfor (m = 0; m < showhidefields.length; m++){\r\n");
      out.write("\t\t\t                \t\tvar n = showhidefields[m];\r\n");
      out.write("\t\t\t                \t    atitle = atitle + dic[hidefields[m]][1] + \":\" + rows[i][n] + \" || \";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                \tif (rows[i][k] == \"\" || rows[i][k] == \"null\") {\r\n");
      out.write("\t\t\t                \t\trows[i][k] = \"&nbsp;\";\r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                    if(j==0)\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow1(\"<a class=visit style='cursor:hand' href=javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>\"+rows[i][k]+\"</a>\", fields[j]);\r\n");
      out.write("\t\t\t                \telse\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow(\"<a class=visit style='cursor:hand' href=javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>\"+rows[i][k]+\"</a>\", fields[j]);\r\n");
      out.write("\t\t\t                }else{\r\n");
      out.write("\t\t\t                \tif(j==0)\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow1(rows[i][k], fields[j]);\r\n");
      out.write("\t\t\t                \telse\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow(rows[i][k], fields[j]);\r\n");
      out.write("\t\t\t                }                \r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t            if(showEdit == \"1\"){\r\n");
      out.write("\t\t\t            \tstr = str + \"<td bgcolor=\\\"#FFFFFF\\\" class=\\\"xxybgx2\\\" onclick=\\\"javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"')\\\">&nbsp;</td>\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t            str = str + \"</tr>\\n\";\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    str = str + '</table>';\r\n");
      out.write("\t\t\t    document.getElementById(\"list\").innerHTML = str;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tfunction selectRole(){\r\n");
      out.write("\t\t\t\tvar chks = document.getElementsByName(\"chk1\");\r\n");
      out.write("\t\t\t    if (!url_para)\r\n");
      out.write("\t\t\t        url_para = \"\";\r\n");
      out.write("\t\t\t    var chkeds = new Array();\r\n");
      out.write("\t\t\t    var rowIndex = new Array();\r\n");
      out.write("\t\t\t    for (var i = 0; i < chks.length; i ++) {  //当前页面上有多条记录时\r\n");
      out.write("\t\t\t        if (chks[i].checked == true) {\r\n");
      out.write("\t\t\t            chkeds.push(chks[i].value);\r\n");
      out.write("\t\t\t            rowIndex.push(i);\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    if (chkeds.length > 0) {\r\n");
      out.write("\t\t\t    \tvar reName = \"\";\r\n");
      out.write("\t\t\t    \tvar reId = \"\";\r\n");
      out.write("\t\t\t\t\tfor(var i =0;i<rowIndex.length;i++){\r\n");
      out.write("\t\t\t\t\t\tif(reName==\"\"){\r\n");
      out.write("\t\t\t\t\t\t\treName = rows[rowIndex[i]][getCodeIndex('Name')];\r\n");
      out.write("\t\t\t\t\t\t\treId = rows[rowIndex[i]][getCodeIndex('Id')];\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\telse{ \r\n");
      out.write("\t\t\t\t\t\t\treName += \",\"+rows[rowIndex[i]][getCodeIndex('Name')];\r\n");
      out.write("\t\t\t\t\t\t\treId += \",\"+rows[rowIndex[i]][getCodeIndex('Id')];\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t    \twindow.opener.setRole(reName,reId);\r\n");
      out.write("\t\t\t    \twindow.close();\r\n");
      out.write("\t\t\t    } else {\r\n");
      out.write("\t\t\t    \treName='';\r\n");
      out.write("\t\t\t    \treId='';\r\n");
      out.write("\t\t\t    \twindow.opener.setRole(reName,reId);\r\n");
      out.write("\t\t\t    \twindow.close();\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//获得代码的位置\r\n");
      out.write("\t\t\tfunction getCodeIndex(colu){\r\n");
      out.write("\t\t\t\tfor(var k=0;k<allfields.length;k++){\r\n");
      out.write("\t\t\t\t\tif(allfields[k]==colu){\r\n");
      out.write("\t\t\t\t\t\treturn k;\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr><td colspan=\"3\" height=\"13\"></td></tr>\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td width=\"25\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"1\" cellpadding=\"0\" bgcolor=\"#33577B\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td bgcolor=\"#FFFFFF\" valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td height=\"26\" background=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbj.png\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td width=\"26\"><div align=\"center\"><img src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanl.gif\"></div></td>\r\n");
      out.write("         \t\t\t\t\t\t\t\t\t\t\t<td width=\"100\"><b class=\"bt\">[角色表]</b></td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td width=\"24\"><div align=\"center\"><img src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanr1.png\"></div></td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td width=\"55\" class=\"bt\"><a href=\"javascript:document.query.submit();\">查询</a></td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td width=\"24\"><div align=\"center\"><img src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/xxdhbjanr2.png\"></div></td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t\t<td width=\"55\" class=\"bt\"><a href=\"javascript:selectRole();\">选中</a></td>\r\n");
      out.write("\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<form action=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" name=\"query\" id=\"postForm\" method=\"post\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td  class=\"cxbj\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"select\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<table border=0 cellspacing=3 cellpadding=5 width=\"100%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">角色名</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"_Name_\" value=\"");
      out.print(ParamUtils.getParameter(request, "_Name_", ""));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div align=\"right\">角色代码</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<input name=\"_Code_\" value=\"");
      out.print(ParamUtils.getParameter(request, "_Code_", ""));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\">&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t<table width=\"99%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("          \t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t \t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t    \t\t\t\t<td height=\"3\" class=\"topline\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("            \t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("              \t\t\t\t\t\t\t\t\t\t\t\t<tr><td height=\"2\"></td></tr>\r\n");
      out.write("            \t\t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
//=(("listall".equals(cmd)))? "": pagecontrol.getControl1((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/images/skin/"+userInfo.getSkinId())
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t                \t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td width=\"25\">&nbsp;</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr><td colspan=\"3\" height=\"13\"></td></tr>\r\n");
      out.write("\t\t</table>\r\n");
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
