<%@page import="com.xietong.software.sdtw.db.BaseDeptCode"%>
<%@page import="com.xietong.software.sdtw.db.BaseMoudle"%>
<%@ page language="java" %>
<%--Rpc--%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="com.xietong.software.base.*"%>
<%@ page import="com.xietong.software.util.*,com.xietong.software.common.*"%>
<%@ page import="org.apache.commons.logging.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.lang.reflect.*"%>
<%!private static Log log = LogFactory.getLog(Tool.class);

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
%> 
<%
response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
%>
<form name="rpc">
<%
log.debug("Rpc");
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo!=null) {
    out.print(main(request, response));
}
%>
</form>