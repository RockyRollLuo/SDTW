/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-03-30 02:10:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.stuUnion;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import com.xietong.software.sdtw.db.*;
import java.util.*;

public final class stuorg_002dstudentunion_002dintro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html >\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"../css/common-student.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".text{\r\n");
      out.write("\tfont-family:楷体;\r\n");
      out.write("\tfont-size: 19px;\r\n");
      out.write("\twidth:89%;\r\n");
      out.write("\tmargin:0 auto;\r\n");
      out.write("}\r\n");
      out.write("h3{\r\n");
      out.write("\talign:center;\r\n");
      out.write("}\r\n");
      out.write(".text td{\r\n");
      out.write("\tbackground:#fff;\r\n");
      out.write("}\r\n");
      out.write("p{\r\n");
      out.write("\ttext-indent:2em;  /*首行缩进2个当前字符*/\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function form1submit(){\r\n");
      out.write("\tdocument.form1.myunionprofile.value =CKEDITOR.instances.unionprofile.getData();\r\n");
      out.write("\tdocument.form1.submit();\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function form1modify(){\r\n");
      out.write("\tdocument.getElementById(\"editorarea1\").style.display=\"none\";\r\n");
      out.write("\tdocument.getElementById(\"editorarea2\").style.display=\"block\";\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
 
//接受各种参数 从session或者其他对象中 




String[] unionnamearry={"校学生会","校研究生会","院学生会","院研究生会"};
ResultSet rs=null;
String unionprofile="",unionprofilestr="";

String uniontype=ParamUtils.getParameter(request, "uniontype", "1");

UserInfo userinfo=Tool.getUserInfo(request);
if(userinfo==null){
	return;
}
BaseUserCode user=userinfo.getUserCode();
int  deptId=user.getDeptId();
StudentUnion sud= new StudentUnion ();
List cdt= new ArrayList();
String unionid="";
List list= new ArrayList();
if(uniontype.equals("1")){
	unionid="1";
	cdt.add("id=1");
	
}
if(uniontype.equals("2")){
	unionid="2";
	cdt.add("id=2");
	
}
if(uniontype.equals("3")){
	
	cdt.add("academy="+deptId);
	cdt.add("uniontype="+uniontype);

	
}
if(uniontype.equals("4")){


	cdt.add("academy="+deptId);
	cdt.add("uniontype="+uniontype);
	
}
list=sud.query(cdt);
if(list.size()>0){
	sud=(StudentUnion)list.get(0);
	unionprofile=sud.getUnionprofile();
}
	System.out.println("bbbbbbbbbbbbbbbbbbbbbb"+uniontype);
	
//    String strposition = "学生组织建设 >> 组织信息管理 >>";
	
// 	String strhelpwords = "学生会介绍。";

      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<table class=\"text\" style=\"width:100%\">\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td>\r\n");
      out.write("\t\t");
      out.print(unionprofile);
      out.write("\r\n");
      out.write("\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("<tr height=\"30px\">\r\n");
      out.write("  <th colspan=\"6\" align=\"center\">\r\n");
      out.write("  </th>\t\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
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
