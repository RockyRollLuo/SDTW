/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-19 03:39:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.pratice;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.base.Power;
import com.xietong.software.sdtw.*;
import com.xietong.software.sdtw.db.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.io.*;
import java.util.*;
import com.xietong.software.common.UserInfo;
import com.xietong.software.common.HeadConst;
import com.xietong.software.util.Tool;

public final class PracticeList_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("\t\t<title> ");
      out.print(request.getAttribute("describe"));
      out.write(" </title>\r\n");
      out.write("\t\t<script src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/listfunction_win8.js\"></script>\r\n");
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
      out.write("\t\t\t\r\n");
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
      out.write("\t\t\t        return \"<td  align='\" + data_align[dalign] + \"' class=\\\"browsetable005\\\">\" + str + \"</td>\\n\";\r\n");
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
      out.write("\t\t\t        return \"<td align='\" + data_align[dalign] + \"' class=\\\"browsetable005\\\">\" + str + \"</td>\\n\";\r\n");
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
      out.write("\t\t\t    str = str + \"<table width=\\\"100%\\\" border=\\\"0\\\" align=\\\"center\\\" cellpadding=\\\"2\\\" cellspacing=\\\"1\\\">\\n\";\r\n");
      out.write("\t\t\t    \r\n");
      out.write("\t\t\t    if (hasCheckbox) {\r\n");
      out.write("\t\t\t        str = str + \"<td bgcolor=\\\"#3992d0\\\"><div class=\\\"browsetable004\\\"><input type=\\\"checkbox\\\" onclick=\\\"selectAll(this);\\\" onchange=\\\"selectAll(this);\\\"></div></td>\\n\";\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    if(showEdit == \"1\"){\r\n");
      out.write("\t\t\t    \t//str = str + \"<td bgcolor=\\\"#3992d0\\\" nowrap><div class=\\\"browsetable004\\\">编辑</div></td>\\n\";\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    for (var i = 0; i < fields.length; i ++) {\r\n");
      out.write("\t\t\t        var title = dic[fields[i]][1];\r\n");
      out.write("\t\t\t        title = title.replace(/\\(.*\\)/, \"\");\r\n");
      out.write("\t\t\t        if (title == \"\") title = \"&nbsp;\";\r\n");
      out.write("\t\t\t        str = str + \"<td bgcolor=\\\"#3992d0\\\" onclick=\\\"javascript:setOrderBy('\" + fields[i] + \"', '\" + url_para + \"')\\\" nowrap><div class=\\\"browsetable004\\\">\" + title;\r\n");
      out.write("\t\t\t        if (curr_orderby != undefined) {\r\n");
      out.write("\t\t\t            if (curr_orderby[0] == fields[i]) {\r\n");
      out.write("\t\t\t                str = str + \"<img src=\\\"\" + order_image[curr_orderby[1]] + \"\\\">\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t        str = str + \"</div></td>\\n\";\r\n");
      out.write("\t\t\t        showfields[i] = getFieldIndex(fields[i]);\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    str+=\"<td bgcolor=\\\"#3992d0\\\" onclick=\\\"javascript:setOrderBy('\" + fields[i] + \"', '\" + url_para + \"')\\\" nowrap><div class=\\\"browsetable004\\\">经费</div></td>\"\r\n");
      out.write("\t\t\t    str+=\"<td bgcolor=\\\"#3992d0\\\" onclick=\\\"javascript:setOrderBy('\" + fields[i] + \"', '\" + url_para + \"')\\\" nowrap><div class=\\\"browsetable004\\\">结题书</div></td>\"\r\n");
      out.write("\t\t\t    for (var i = 0; i < hidefields.length; i ++) {\r\n");
      out.write("\t\t\t        showhidefields[i] = getFieldIndex(hidefields[i]);\r\n");
      out.write("\t\t\t    }    \r\n");
      out.write("\t\t\t  /*  if(showEdit == \"1\"){\r\n");
      out.write("\t\t\t    \tstr = str + \"<td bgcolor=\\\"#3992d0\\\" nowrap><div class=\\\"browsetable004\\\">编辑</div></td>\\n\";\r\n");
      out.write("\t\t\t    }*/\r\n");
      out.write("\t\t\t    str = str + \"</tr>\\n\";\r\n");
      out.write("\t\t\t    if (rows.length == 0) {\r\n");
      out.write("\t\t\t        str = str + \"<tr><td colspan=\" + (showfields.length + 2) + \" bgcolor=\\\"#FFFFFF\\\" ><div class=\\\"browsetable006\\\">没有记录！</div></td></tr>\\n\";\r\n");
      out.write("\t\t\t    } \r\n");
      out.write("\t\t\t    else {\r\n");
      out.write("\t\t\t        for (i = 0; i < rows.length; i ++) {\r\n");
      out.write("\t\t\t            var color = (i % 2 != 0) ? \"data_bgcolor_odd\" : \"data_bgcolor_even\";\r\n");
      out.write("\t\t\t            if (rows[i][keyindex] == curId){\r\n");
      out.write("\t\t\t            \tstr = str + \"<tr onMouseOver=\\\"addClass(this,'data_bgcolor_over');\\\"  onMouseOut=\\\"removeClass(this,'data_bgcolor_over');\\\" class='\"+color+\"'>\\n\";\r\n");
      out.write("\t\t\t            }else{\r\n");
      out.write("\t\t\t            \tstr = str + \"<tr onMouseOver=\\\"addClass(this,'data_bgcolor_over');\\\"  onMouseOut=\\\"removeClass(this,'data_bgcolor_over');\\\" class='\"+color+\"'>\\n\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t            \r\n");
      out.write("\t\t\t            if (hasCheckbox) {\r\n");
      out.write("\t\t\t            \tif (haveSelect == \"1\" ){\r\n");
      out.write("\t\t\t            \t\tvar selectRowsIdsStr = (selectRowsIds == undefined) ? \"\" : selectRowsIds;\r\n");
      out.write("\t\t\t                \tif (selectRowsIdsStr.indexOf(rows[i][keyindex])>-1){\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td class=\\\"browsetable001\\\"><input type=checkbox name=chk1 checked value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}else{\r\n");
      out.write("\t\t\t                \t\tstr = str + \"<td class=\\\"browsetable001\\\"><input type=checkbox name=chk1 value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                }else{\r\n");
      out.write("\t\t\t                \tstr = str + \"<td class=\\\"browsetable001\\\"><input type=checkbox name=chk1 value=\" + rows[i][keyindex] + \" /></td>\";\r\n");
      out.write("\t\t\t                }\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t            if(showEdit == \"1\"){\r\n");
      out.write("\t\t\t            \t//str = str + \"<td class=\\\"xxybgx2\\\"  onclick=\\\"javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"')\\\">&nbsp;</td>\";\r\n");
      out.write("\t\t\t            }\r\n");
      out.write("\t\t\t             var atitle = \"\";\r\n");
      out.write("\t\t\t            for (var j = 0; j < fields.length; j ++) {\r\n");
      out.write("\t\t\t                var k = showfields[j];\r\n");
      out.write("\t\t\t                if(allfields[k]==\"Id\" ||allfields[k]==\"OrderNo\" ||allfields[k]==\"Name\" || allfields[k]==\"Subject\" || allfields[k] == \"Email\"|| allfields[k] == \"PracticeName\"){\r\n");
      out.write("\t\t\t                \tfor (m = 0; m < showhidefields.length; m++){\r\n");
      out.write("\t\t\t                \t\tvar n = showhidefields[m];\r\n");
      out.write("\t\t\t                \t    atitle = atitle + dic[hidefields[m]][1] + \":\" + rows[i][n] + \" || \";\r\n");
      out.write("\t\t\t                \t}\r\n");
      out.write("\t\t\t                \tif (rows[i][k] == \"\" || rows[i][k] == \"null\") {\r\n");
      out.write("\t\t\t                \t\trows[i][k] = \"&nbsp;\";\r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                    if(j==0){\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow1(\"<a class=visit style='cursor:hand' href=javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>\"+rows[i][k]+\"</a>\", fields[j]);\r\n");
      out.write("\t\t\t                    } else {\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow(\"<a class=visit style='cursor:hand' href=javascript:modifyRecord1('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>\"+rows[i][k]+\"</a>\", fields[j]);\r\n");
      out.write("\t\t\t                    }\r\n");
      out.write("\t\t\t                }else{\r\n");
      out.write("\t\t\t                \tif(j==0)\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow1(rows[i][k], fields[j]);\r\n");
      out.write("\t\t\t                \telse\r\n");
      out.write("\t\t\t                \t\tstr = str + getRow(rows[i][k], fields[j]);\r\n");
      out.write("\t\t\t                }                \r\n");
      out.write("\t\t\t            }        \r\n");
      out.write("\t\t\t            str = str + \"<td><a class=visit style='cursor:hand' href=javascript:modifyRecordjf('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>查看经费</a></td>\";\r\n");
      out.write("\t\t\t            str = str + \"<td><a class=visit style='cursor:hand' href=javascript:modifyRecordsqs('\" + className + \"','\" + rows[i][keyindex] + \"','\" + currpage + \"','\" + url_para + \"','\" + cmd + \"'); title='\" + atitle + \"'>查看结题书</a></td></tr>\\n\";\r\n");
      out.write("\t\t\t        }\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t    str = str + '</table>';\r\n");
      out.write("\t\t\t    document.getElementById(\"list\").innerHTML = str;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction modifyRecordsqs(className, id, currpage, url_para,cmd) {\r\n");
      out.write("\t\t   \twindow.location = \"PracticeReportAction.jsp?_DeclareId_=\"+id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction modifyRecordjf(className, id, currpage, url_para,cmd) {\r\n");
      out.write("\t\t   \twindow.location = \"AcademyMoneyNums.jsp?_Remark_=\"+id;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction setHonor() {\r\n");
      out.write("\t\t\tvar url = \"");
      out.print(HeadConst.apache_url);
      out.write("/main/pratice/PracticeDeclareTeammemberAction.jsp?cmd=AllMembers\";\r\n");
      out.write("          \t//openWindow(url,\"900,600\");\r\n");
      out.write("\t\t\tvar height = window.screen.availHeight;\r\n");
      out.write("\t\t\tvar width = window.screen.availWidth;\r\n");
      out.write("\t\t\tvar arg = {}; // 可通过该参数给模态窗口传递参数\r\n");
      out.write("\t\t\tvar window_parameter = 'dialogHeight=' + height + ';dialogWidth=' + width + ';resizable=no;location=no;menubar=no;status:no;';\r\n");
      out.write("\t\t\twindow.showModalDialog(url, arg, window_parameter);\r\n");
      out.write("\r\n");
      out.write("\t\t}\t\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr> \r\n");
      out.write("\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td height=\"26\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("                               <tr>\r\n");
      out.write("                                   <td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t            <div class=\"browsetitle title_css\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t            <div class=\"browsetitleleft\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle001\">社会实践项目团委立项表</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitle002\">");
      out.print(XtUtil.getSpell("社会实践项目团委立项表"));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t          <div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              <div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t           <ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");

														            if (userInfo.hasFunPower(Power.ADMINPOWER)||userInfo.hasFunPower(Power.SHSJ)) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!-- <li class=\"browsetitle_lang\"><a href=\"javascript:javascript:document.query.cmd.value = 'excel'; document.query.submit();\">导出Excel</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:deleteList('");
      out.print(request.getAttribute("classname"));
      out.write("', url_para);\">删除</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <li><a href=\"javascript:addNew('");
      out.print(request.getAttribute("classname"));
      out.write("', url_para);\">增加</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            <!-- <li><a href=\"javascript:document.query.submit();\">查询</a></li> -->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
}
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t            ");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t            </ul>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t              </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t           </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t            </div>\t                                   </td>\r\n");
      out.write("                                </tr>    \t\t\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t<form action=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" name=\"query\" id=\"postForm\" method=\"post\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("                               <div class=\"browsetable2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"list\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("                               </div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("    \t\t\t\t\t\t\t\t\t<td valign=\"top\">\r\n");
      out.write("      \t\t\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"2\" cellspacing=\"0\">\r\n");
      out.write("        \t\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("          \t\t\t\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"list\" class=\"browsetable\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
      out.print((("listall".equals(cmd)))? "": pagecontrol.getControl_win8((String)request.getAttribute("classname") + "Action.jsp?cmd=list" + ((url.length() == 0) ? "" : "&" + url),  HeadConst.apache_url+"/main/images/skin/"+userInfo.getSkinId()));
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
      out.write("\t\t\t</tr>\r\n");
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
