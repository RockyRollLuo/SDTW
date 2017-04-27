/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-07 09:06:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.common;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.sdtw.db.BaseDeptCode;
import com.xietong.software.sdtw.db.BaseMoudle;
import com.xietong.software.base.*;
import com.xietong.software.util.*;
import com.xietong.software.common.*;
import org.apache.commons.logging.*;
import java.util.*;
import java.lang.reflect.*;

public final class Rpc_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

private static Log log = LogFactory.getLog(Tool.class);

private void init(String clsName, String dbname, String tname)
{
    try {
        Class cls = Class.forName(clsName);
        Constructor con = cls.getConstructor(new Class[]{String.class, String.class});
        Object obj = con.newInstance(new Object[]{dbname, tname});
        Method method = cls.getMethod("init", new Class[]{});
        method.invoke(obj, new Object[]{});
    }
    catch (Exception e) {
        log.debug("error:" + e);
    }
}
private void duplicate(String clsName, String sourcedbname, String targetdbname, String tname, List cdt)
{
    try {
        Class cls = Class.forName(clsName);
        Constructor con = cls.getConstructor(new Class[]{String.class, String.class});
        Object obj = con.newInstance(new Object[]{targetdbname, tname});
        Method method = cls.getMethod("duplicate", new Class[]{String.class, List.class});
        method.invoke(obj, new Object[]{sourcedbname, cdt});
    }
    catch (Exception e) {
        log.debug("error:" + e);
    }
}
private String renderTextarea(Map map)
{
    StringBuffer rtn = new StringBuffer();
    if (map != null) {
        for (Iterator it = map.keySet().iterator(); it.hasNext();) {
            String key = (String)it.next();
            String val = (String)map.get(key);
            rtn.append("<textarea name=\"" + key + "\">" + val + "</textarea>");
        }
    }
    return rtn.toString();
}





private String getModuleToMap(javax.servlet.http.HttpServletRequest request)
{
    int id = ParamUtils.getIntParameter(request, "id", -1);
    int orgid = ParamUtils.getIntParameter(request, "orgid", -1);
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    UserInfo ui = Tool.getUserInfo(request);
    BaseMoudle com = new BaseMoudle();
    com = com.getById(id);
    Map map = com.toMap();
    map.put("_cmd", cmd);
    Map moudlemap = CEditConst.getMoudleNameMap(ui);
    if(moudlemap.get(com.getPid()+"")!=null){
    	map.put("Pid",moudlemap.get(com.getPid()+""));
    }
    Map typemap = CEditConst.getMoudleOrFunMap(ui);
    if(typemap.get(com.getMoudleType()+"")!=null){
    	map.put("MoudleType",typemap.get(com.getMoudleType()+""));
    }
    return renderTextarea(map);
}




public String duplicateOa(HttpServletRequest request) {
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    String cname = ParamUtils.getParameter(request, "cname", "");
    List cdt = new ArrayList();
    String sourcedbname = Tool.getUserInfo(request).getDbname();
    String targetdbname = sourcedbname + "bak";
    duplicate("com.xietong.software.oa.db." + cname, sourcedbname, targetdbname, cname, cdt);
    Map map = new HashMap();
    map.put("prompt", "duplicate " + cname + " success!");
    map.put("_cmd", cmd);
    return renderTextarea(map);
}

public String changeRole(HttpServletRequest request, HttpServletResponse response) {
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    int id = ParamUtils.getIntParameter(request, "id", -1);
    UserInfo ui = Tool.getUserInfo(request);
    int oldid = ui.getUserCode().getId();
    ui.changeUser(request, response, id);
    Map map = new HashMap();
    map.put("_cmd", cmd);
    map.put("oldId", "" + oldid);
    map.put("Id", "" + ui.getUserCode().getId());
    return renderTextarea(map);
}
public String getProgressMap(HttpServletRequest request) {
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    UploadProgressListener upl = (UploadProgressListener)request.getSession().getAttribute("Progress");
    Map map = new HashMap();
    if (upl != null) {
        map = upl.getUploadInfoMap();
    }
    map.put("_cmd", cmd);
    return renderTextarea(map);
}


private String getDeptCodeToMap(javax.servlet.http.HttpServletRequest request)
{
    int id = ParamUtils.getIntParameter(request, "id", -1);
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    Map map = new HashMap();
    int i = 0;
    BaseDeptCode v = new BaseDeptCode();
   	v = v.getById(id);
   	map = v.toMap();
    return renderTextarea(map);
}


public String main(javax.servlet.http.HttpServletRequest request, HttpServletResponse response)
{
    String cmd = ParamUtils.getParameter(request, "cmd", "");
    log.debug("cmd=" + cmd);
    if (cmd.equals("DeptCodeToMap")) {
        return getDeptCodeToMap(request);
    }
    if (cmd.equals("MoudleToMap")) {
        return getModuleToMap(request);
    }

    if (cmd.equals("changeRole")) {
        return changeRole(request, response);
    }
    if (cmd.equals("Progress")) {
        return getProgressMap(request);
    }
    
   
    return "";
}

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
      out.write("\r\n");
      out.write(' ');
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");

      out.write("\r\n");
      out.write("<form name=\"rpc\">\r\n");

log.debug("Rpc");
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo!=null) {
    out.print(main(request, response));
}

      out.write("\r\n");
      out.write("</form>");
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
