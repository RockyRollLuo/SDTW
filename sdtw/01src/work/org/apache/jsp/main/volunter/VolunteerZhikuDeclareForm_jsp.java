/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-20 06:40:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.volunter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
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

public final class VolunteerZhikuDeclareForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

	Log log = LogFactory.getLog(VolunteerZhikuDeclare.class);
	String msg = (String)request.getAttribute("msg");
	if ((msg != null)) {
    		out.print(HtmlTool.msgBox(request, msg));
    		return;
	}
	String cmd = ParamUtils.getParameter(request, "cmd", "insert");
	int currpage = ParamUtils.getIntParameter(request, "page", 1);
	VolunteerZhikuDeclare v = (VolunteerZhikuDeclare)request.getAttribute("fromBean");
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
	List zhuguanoptions=CEditConst.getAcademyNameOptions(userInfo);
List ZkProjectTypeoptions = (List)request.getAttribute("ZkProjectTypeoptions");
List NoticeNameoptions = (List)request.getAttribute("NoticeNameoptions");
List AcademyNameoptions = (List)request.getAttribute("AcademyNameoptions");
Map zkmaps=CEditConst.getZkProjectTypeMap(userInfo);
String cd1=v.getName(),cd2=v.getTeamname(),cd3=v.getAcademy(),cd4=(String)zkmaps.get(v.getType()),cd5=v.getIntention(),cd6=v.getProcess(),cd7=v.getArrange(),cd8=v.getExpectresults(),cd9=v.getResults(),cd10=v.getCost1(),cd11=v.getCost2(),cd12=v.getCost3(),cd13=v.getCost4(),cd14=v.getCost5(),cd15=v.getCost6(),cd16=v.getTotalcost();
String cdteam="",addfilelist="";
String ids=v.getAddfilelist();

      out.write("\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<title>");
      out.print(request.getAttribute("describe"));
      out.write("</title>\r\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/images/skin/");
      out.print(userInfo.getSkinId());
      out.write("/css.css\">\r\n");
      out.write("\t\t<script language=\"JavaScript\" src=\"");
      out.print(HeadConst.apache_url);
      out.write("/main/js/validation-framework.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t\tValidationFramework.init(\"");
      out.print(request.getAttribute("classname"));
      out.write("_validation.xml\");\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t<link href=\"../css/common.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<script src=\"../js/tablelist.js\"></script>\r\n");
      out.write("<script src=\"../js/jquery.min.js\"></script>\r\n");
      out.write("\t\t<script src=\"");
      out.print(userInfo.getRootUrl());
      out.write("/main/js/formfunction.js\"></script>\r\n");
      out.write("\t\t<script>\r\n");
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
      out.write("\t\t\tvar options= {");
      out.print(HtmlTool.getJsOptions(request));
      out.write("};\r\n");
      out.write("\t\t\tfunction init() {\r\n");
      out.write("    \t\t\t\tprepareForm(\"");
      out.print(request.getAttribute("classname"));
      out.write("\", dic, \"");
      out.print(userInfo.getPower());
      out.write("\");\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t</head>\r\n");
      out.write("\t<body onload=\"init();\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/main/jqueryui.jsp", out, true);
      out.write("\r\n");
      out.write("\t\t<div class=\"browsetitle\">\r\n");
      out.write("\t\t\t<div class=\"browsetitleleft\">\r\n");
      out.write("\t\t\t\t<div class=\"browsetitle001\">山大志库</div>\r\n");
      out.write("\t\t\t\t<div class=\"browsetitle002\">");
      out.print(XtUtil.getSpell("山大志库") );
      out.write("</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"browsetitleright\">\r\n");
      out.write("\t\t\t\t<div class=\"anniulist2\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t <li> <a href=\"#\" onclick=\"history.go(-1);\">返回</a></li> \r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"errorDiv\" style=\"color:red;font-weight:bold\"></div>\r\n");
      out.write("\t\t<div class=\"browsetable\" id=\"form\">\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getAttribute("classname"));
      out.write("Action.jsp\" method=\"post\" name=\"postForm\" id=\"postForm\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"cmd\" value=\"");
      out.print(cmd);
      out.write("\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"page\" value=\"");
      out.print(currpage);
      out.write("\">\r\n");
      out.write("\t\t\t\t");
      out.print(Tool.join("\n", forms));
      out.write("\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("<table class=\"content-table\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"3\" align=\"left\">“山大志库”申请表</th> \r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td width=\"27%\" align=\"right\">项目名称</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd1);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">团队名称</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd2);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">所属单位</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(HtmlTool.renderSelect(zhuguanoptions, "" + cd3, "Academy", "-1",true));
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目分组</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd4);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">活动背景及目的</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd5);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">活动时间安排</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd6);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">活动流程</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd7);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">预期成果</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd8);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">已取得成果（选填）</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">");
      out.print(cd9);
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\"><p>团队组成情况<p/></td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">\r\n");
      out.write("\t\t<table id=\"teamtable\" style=\"width:100%;font-size:12px;text-align:center;\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>学号</td><td>姓名</td><td>学院</td><td>联系方式</td><td>团队分工</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t");

		String snoids="";
		if(v.getId()!=-1){
			VolunteerZhikuTeammember vpt= new VolunteerZhikuTeammember();
			List list2= new ArrayList();
			List cdt2= new ArrayList();
			List snoidlist= new ArrayList();
			List dutylist=new ArrayList();
			String vppid= v.getId()+"";
			cdt2.add("zhikudeclareid="+vppid);
			cdt2.add("order by id ");
			list2= vpt.query(cdt2);
			BaseUserCode stu= new BaseUserCode();
			String xueyuan="";
			Map xueyuanmap =CEditConst.getAcademyNameMap(userInfo);
			if(list2.size()>0){
				for(int i=0;i<list2.size();i++){
					vpt=(VolunteerZhikuTeammember)list2.get(i);
					stu=stu.getById(Integer.parseInt(vpt.getSno()));
					if(stu.getDeptId()!=-1){
					xueyuan=(String)xueyuanmap .get(stu.getDeptId()+"");
					}
				
      out.write("\r\n");
      out.write("\t\t\t\t<tr id='deleteSponsor_");
      out.print(stu.getId());
      out.write("'><td>");
      out.print(stu.getName() );
      out.write("</td><td>");
      out.print(stu.getCnName() );
      out.write("</td><td>");
      out.print(xueyuan );
      out.write("</td><td>");
      out.print(vpt.getPhone() );
      out.write("</td><td>");
      out.print(vpt.getDuty() );
      out.write("</td></tr>\r\n");
      out.write("\t\t\t\t");
 
				}
			
		}
		}
		
      out.write("\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">项目情况</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"2\">\r\n");
      out.write("\t\t<p><span class=\"itemname\">交通费  </span>");
      out.print(cd10);
      out.write("</p>\r\n");
      out.write("\t\t<p><span class=\"itemname\">住宿费  </span>");
      out.print(cd11);
      out.write("</p>\r\n");
      out.write("\t\t<p><span class=\"itemname\">其它（请说明）  </span>");
      out.print(cd12);
      out.write("</p>\r\n");
      out.write("\t\t<p><span class=\"itemname\">其它（请说明）  </span>");
      out.print(cd13);
      out.write("</p>\r\n");
      out.write("\t\t<p><span class=\"itemname\">其它（请说明）  </span>");
      out.print(cd14);
      out.write("</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<p><span class=\"itemname\">共计  </span>");
      out.print(cd16);
      out.write("</p>\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td align=\"right\">附件</td>\r\n");
      out.write("\t<td align=\"left\">\r\n");
      out.write(" ");

 ClientAttach ca1=new ClientAttach();
 ClientAttach ca = new ClientAttach();

 if(ids!=null&&ids.trim().length()>0){
 	String[] idArray = Tool.split(",",ids);
 	System.out.println(idArray);
 	for(int i=0;i<idArray.length;i++){
 	ca1= ca.getById(Tool.StrToInt(idArray[i]));
 	 
      out.write("\r\n");
      out.write(" \t <a href=\"");
      out.print(HeadConst.apache_url );
      out.write("/servlet/attach?type=clientattach&id=");
      out.print(ca1.getId() );
      out.write("\" target=\"_blank\"><img src='");
      out.print(HeadConst.apache_url );
      out.write("/main/images/file1.gif' border=\"0\"/>下载文件");
      out.print(ca1.getUploadName() );
      out.write("\r\n");
      out.write(" \t</a> \r\n");
      out.write(" \t");

 	}
 }



      out.write(" \r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<th colspan=\"2\">\r\n");
      out.write("\t</th>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("                    \t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
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
