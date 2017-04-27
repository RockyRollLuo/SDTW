/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-26 07:29:10 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.studentUnion;

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
import jxl.*;
import jxl.write.*;
import java.math.BigDecimal;

public final class StudentUnionDeptAction_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


private static Log log = LogFactory.getLog(StudentUnionDept.class);
private static final String[] allFormNames = {"cmd", "page", "idlist", "Id", "UnionId", "ListOrder", "DeptName", "Principal", "Contact", "Functionstr", "Deptprofile", "Addfilelist", "Addtime", "Addaccount"};
private String[] DicKeys = {"Id", "UnionId", "ListOrder", "DeptName", "Principal", "Contact", "Functionstr", "Deptprofile", "Addfilelist", "Addtime", "Addaccount"};
private String[][] DicValues = {{"int", "Id", "0", "hidden", ""}, {"int", "校级院级学生会id", "0", "text", ""}, {"string", "排序", "200", "text", ""}, {"string", "部门", "200", "text", ""}, {"date", "发布时间", "0", "text", ""}, {"string", "主要成员", "45", "text", ""}, {"string", "主要职能", "45", "hidden", ""}, {"string", "部门简介", "45", "hidden", ""}, {"string", "附件", "45", "hidden", ""}, {"string", "添加时间", "45", "hidden", ""}, {"string", "负责人", "45", "hidden", ""}};
private String KeyField = "Id";
private String[] AllFields = {"Id", "UnionId", "ListOrder", "DeptName", "Principal", "Contact", "Functionstr", "Deptprofile", "Addfilelist", "Addtime", "Addaccount"};
private String[] ListFields = {  "DeptName", "Functionstr", "Deptprofile", "Addaccount",  "Contact"};
private String[] FormFields = {"UnionId", "ListOrder", "DeptName", "Principal", "Contact", "Functionstr", "Deptprofile", "Addfilelist", "Addtime", "Addaccount"};
private String[] QueryFields = {""};
private String[] HideFields = {"Id"};
private StudentUnionDept getByParameterDb(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentUnionDept v = new StudentUnionDept();
    v.setId(ParamUtils.getIntParameter(request, "Id", -1));
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    if (cmd.equals("update")) {
        v = v.getById(v.getId());
        v.paramId(request, "Id");
        v.paramUnionId(request, "UnionId");
        v.paramListOrder(request, "ListOrder");
        v.paramDeptName(request, "DeptName");
        v.paramPrincipal(request, "Principal");
        v.paramContact(request, "Contact");
        v.paramFunctionstr(request, "Functionstr");
        v.paramDeptprofile(request, "Deptprofile");
        v.paramAddfilelist(request, "Addfilelist");
        v.paramAddtime(request, "Addtime");
        v.paramAddaccount(request, "Addaccount");
    }
    else {
        v.setId(ParamUtils.getIntParameter(request, "Id", -1));
        v.setUnionId(ParamUtils.getIntParameter(request, "UnionId", -1));
        v.setListOrder(ParamUtils.getParameter(request, "ListOrder", ""));
        v.setDeptName(ParamUtils.getParameter(request, "DeptName", ""));
        v.setPrincipal(ParamUtils.getDateTimeParameter(request, "Principal", java.sql.Date.valueOf("0001-01-01")));
        v.setContact(ParamUtils.getParameter(request, "Contact", ""));
        v.setFunctionstr(ParamUtils.getParameter(request, "Functionstr", ""));
        v.setDeptprofile(ParamUtils.getParameter(request, "Deptprofile", ""));
        v.setAddfilelist(ParamUtils.getParameter(request, "Addfilelist", ""));
        v.setAddtime(ParamUtils.getParameter(request, "Addtime", ""));
        v.setAddaccount(ParamUtils.getParameter(request, "Addaccount", ""));
    }
    return v;
}
private List getListRows(javax.servlet.http.HttpServletRequest request, StudentUnionDept pv, List cdt)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    //查询符合条件的资料
    List vs = pv.query(cdt);
    List rows = new ArrayList();
    Map usercnnamemap= CEditConst.getUserCnNameMap(userInfo);
    for (Iterator it = vs.iterator(); it.hasNext();) {
        StudentUnionDept v = (StudentUnionDept)it.next();
        List row = new ArrayList();
        row.add("" + v.getId());
        row.add("" + v.getUnionId());
        row.add(Tool.jsSpecialChars(v.getListOrder()));
        row.add(Tool.jsSpecialChars(v.getDeptName()));
        row.add(Tool.stringOfDate(v.getPrincipal()));
        row.add("<a href='StudentUnionMemberAction.jsp?cmd=list"+"&_uniontype_="+ParamUtils.getParameter(request, "_uniontype_", "")+"&_UnionId_="+ParamUtils.getParameter(request, "_UnionId_", "-1")+"&_deptid_="+v.getId()+"'>点击查看<a/>");
        row.add(Tool.jsSpecialChars(v.getFunctionstr()));
        row.add(Tool.jsSpecialChars(v.getDeptprofile()));
        row.add(Tool.jsSpecialChars(v.getAddfilelist()));
        row.add(Tool.jsSpecialChars(v.getAddtime()));
        row.add(usercnnamemap.get(v.getAddtime()+""));
        rows.add(row);
    }
    return rows;
}
private void setListData(javax.servlet.http.HttpServletRequest request, StudentUnionDept pv, List cdt)
{
    List rows = new ArrayList();
    for (Iterator it = getListRows(request, pv, cdt).iterator(); it.hasNext();) {
        List row = (List)it.next();
        rows.add("[\"" + Tool.join("\",\"", row) + "\"]");
    }
    request.setAttribute("List", rows);
}
private List getListCondition(javax.servlet.http.HttpServletRequest request, StudentUnionDept pv, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    int shownum = ParamUtils.getIntParameter(request, "shownum", userInfo.getDispNum());
    String orderfield = ParamUtils.getParameter(request, "orderfield", "Id");
    String ordertype = ParamUtils.getParameter(request, "ordertype", "desc");
    List cdt = new ArrayList();
    String qval = "";
    List QueryValues = new ArrayList();
    qval=ParamUtils.getParameter(request, "_UnionId_", "-1");
    if(qval.length()!=0&&qval!="-1"){
    	cdt.add("unionid="+qval);
    	cdt.add("order by listorder");
    }
    QueryValues.add(qval);
    if (!isAll) {
        int currpage = ParamUtils.getIntParameter(request, "page", 1);
        com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(pv.getCount(cdt), currpage, shownum);
        cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
        request.setAttribute("PageControl", pc);
    }
    String cname = pv.getFieldByProperty(orderfield);
    if (cname.length() != 0) {
        cdt.add("order by " + cname + " " + ordertype);
        log.debug("order by " + cname + " " + ordertype);
    }
    request.setAttribute("queryfields", QueryFields);
    request.setAttribute("queryvalues", QueryValues);
    return cdt;
}
private void setList(javax.servlet.http.HttpServletRequest request)
{
    setList(request, false);
request.setAttribute("hidefields", HideFields);}
private void setList(javax.servlet.http.HttpServletRequest request, boolean isAll)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentUnionDept pv = new StudentUnionDept();
    setListData(request, pv, getListCondition(request, pv, isAll));
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", ListFields);
    request.setAttribute("classname", "StudentUnionDept");
    request.setAttribute("describe", "学生会部门");
    System.out.println(ParamUtils.getParameter(request, "UnionId", "-1")+"xxxxxxxxxxxxxx");
   /*  request.setAttribute("UnionId", ParamUtils.getParameter(request, "UnionId", "-1")); */
}
private void writeExcel(HttpServletRequest request, String filename) {
    UserInfo userInfo = Tool.getUserInfo(request);
    StudentUnionDept pv = new StudentUnionDept();
    try {
        WorkbookSettings ws = new WorkbookSettings();
        ws.setLocale(new Locale("zh", "CN"));
        WritableWorkbook workbook = Workbook.createWorkbook(new File(filename), ws);
        WritableSheet s1 = workbook.createSheet("Sheet1", 0);
        for (int k = 0; k < DicValues.length; k ++) {
            Label lr = new Label(k, 0, DicValues[k][1]);
            s1.addCell(lr);
        }
        int i = 1;
        List condition = getListCondition(request, pv, true);
        int num = pv.getCount(condition);
        for (int pos = 0; pos < num; pos += 100) {
            List cdt = new ArrayList(condition);
            for (Iterator it = condition.iterator(); it.hasNext();) {
                cdt.add(new String((String)it.next()));
            }
            cdt.add("limit " + pos + ",100");
            for (Iterator rit = getListRows(request, pv, cdt).iterator(); rit.hasNext(); i ++) {
                List row = (List)rit.next();
                int j = 0;
                for (Iterator cit = row.iterator(); cit.hasNext(); j ++) {
                    Label lr = new Label(j, i, (String)cit.next());
                    s1.addCell(lr);
                }
            }
        }
        workbook.write();
        workbook.close();
    }
    catch (IOException e) {
    }
    catch (WriteException e) {
    }
}
private void setForm(javax.servlet.http.HttpServletRequest request, StudentUnionDept form)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    //默认值定义
    request.setAttribute("dickeys", DicKeys);
    request.setAttribute("dicvalues", DicValues);
    request.setAttribute("keyfield", KeyField);
    request.setAttribute("allfields", AllFields);
    request.setAttribute("fields", FormFields);
    request.setAttribute("classname", "StudentUnionDept");
    request.setAttribute("describe", "学生会部门");
    /* System.out.println(ParamUtils.getParameter(request, "UnionId", "-1")+"xxxxxxxxxxxxxx");
    request.setAttribute("UnionId", ParamUtils.getParameter(request, "UnionId", "-1")); */
}
private List mkRtn(String cmd, String forward, StudentUnionDept form)
{
    List rtn = new ArrayList();
    rtn.add(cmd);
    rtn.add(forward);
    rtn.add(form);
    return rtn;
}
public List main(javax.servlet.http.HttpServletRequest request)
{
    UserInfo userInfo = Tool.getUserInfo(request);
    String cmd = ParamUtils.getParameter(request, "cmd", "list");
    log.debug("cmd=" + cmd);
    StudentUnionDept form = getByParameterDb(request);
    if (cmd.equals("list"))
    {
        setList(request);
        return mkRtn("list", "success", form);
    }
    if (cmd.equals("listall"))
    {
        setList(request, true);
        return mkRtn(cmd, "success", form);
    }
    if (cmd.equals("excel"))
    {
        String filename = HeadConst.root_file_path + "/upload/temp/" + userInfo.getName() + ".xls";
        writeExcel(request, filename);
        return mkRtn(cmd, "excel", form);
    }
    if (cmd.equals("create"))
    {
        setForm(request, form);
        return mkRtn("save", "input", form);
    }
    if (cmd.equals("modify"))
    {
        form = form.getById(form.getId());
        setForm(request, form);
        return mkRtn("update", "input", form);
    }
    if (cmd.equals("delete"))
    {
        form.delete(form.getId());
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("deletelist"))
    {
        String idlist = ParamUtils.getParameter(request, "idlist", "-1");
        List cdt = new ArrayList();
        cdt.add("id in (" + idlist + ")");
        form.deleteByCondition(cdt);
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("save"))
    {
        form.insert();
        return mkRtn("list", "list", form);
    }
    if (cmd.equals("update"))
    {
        form.update();
        return mkRtn("list", "list", form);
    }
    request.setAttribute("msg", "未规定的cmd:" + cmd);
    return mkRtn("list", "failure", form);
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');

response.setHeader("Cache-Control", "no-cache, must-revalidate");
response.setHeader("Pragma", "no-cache");
log.debug("StudentUnionDeptAction");
int currpage = ParamUtils.getIntParameter(request, "page", 1);
List rtn = null;
UserInfo userInfo = Tool.getUserInfo(request);
if (userInfo==null) {
    rtn = mkRtn("login", "login", null);
}
else {
	String tmp = ParamUtils.getParameter(request,"cmd","");
	if(tmp.equals("upPic")){
		String ImageInfo = ParamUtils.getParameter(request,"ImageInfo","");
		String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
		if(!ImageInfo.equals("")){
			FileTool.delete(HeadConst.root_file_path+ImageInfo);
		}
		if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/frequency")){
			FileTool.createDir(HeadConst.root_file_path+"/main/upload/frequency");
		}
		CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/frequency/");
		cuf.setlimitSize(1024*1024L);
    	int flag = cuf.save(request);
    	if(flag==-1){//上传失败
	    	try{
	    		out.clear();
	    		out.print("{error:'上传失败',msg:''}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}else if(flag ==0){
    		out.clear();
	    	out.print("{error:'图片大小超过1M不 能上传！',msg:''}");
    	}
    	else{//上传成功
    		try{
    			out.clear();
	    		out.print("{error:'',msg:'上传成功',url:'/main/upload/frequency/"+cuf.getSaveTotalName()+"'}");
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}
    	return;
	}else if(tmp.equals("otherattach")){
		 String fileElementId = ParamUtils.getParameter(request,"fileElementId","");
		 Calendar c = Calendar.getInstance();
		CUploadFile cuf = new CUploadFile(fileElementId,new Date().getTime()+"","/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
		cuf.setlimitSize(1024*1024*5L);
		if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR))){
			FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR));
		}
		 if(!FileTool.exists(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1))){
			FileTool.createDir(HeadConst.root_file_path+"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1));
		}  
		 int fl = cuf.save(request);
	
		 if(fl==-1){//上传失败
		    	try{
		    		out.clear();
					out.print("{error:'上传失败',msg:''}");
		    	}catch(Exception e){
		    		e.printStackTrace();
		    	}
			}else if(fl==0){
				out.clear();
				out.print("{error:'附件大小超过10M不能上传',msg:''}");
			}
    	else{//上传成功
    		System.out.println("111111进入文件上传");
    		try{
    			ClientAttach attach = new ClientAttach();
    			attach.setDataBase("tuanwei");
    			attach.setAttachType(6);
    			//attach.setUploadType("application/msword");
    			attach.setUploadName(cuf.getRealName());
    			attach.setAttachSize(100);
    			attach.setUploadDate(new Date());
    			
    			attach.setGenerateName(cuf.getSavePath()+"/"+cuf.getSaveTotalName());
    			attach.setFromClass("StudentUnionDeptAction.jsp");
    			attach.setFromTable("StudentUnionDept");
				if(attach.insert()>0){
    				out.clear();
    				out.print("{\"name\":\""+cuf.getRealName()+"\",\"error\":\"\",\"ids\":\""+attach.getId()+"\",\"msg\":\"上传成功\",\"url\":\"/main/upload/"+c.get(Calendar.YEAR)+"/"+(c.get(Calendar.MONTH)+1)+"/"+cuf.getSaveTotalName()+"\"}");
	    			
	    		}else{
	    			out.clear();
	    			out.print("{error:'上传失败',msg:''}");
	    		}
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
    	}
    	return;
	}else if(tmp.equals("delAttach")){
		int tmpid = ParamUtils.getIntParameter(request,"did",-1);
		if(tmpid != -1){
			ClientAttach ca = new ClientAttach();
			ca.delete(tmpid);
			out.print("{\"error\":\"\",\"msg\":\"删除成功\"}");
		}
		else{
			out.print("{error:'删除失败',msg:''}");
		}
		return;
	}else{
    rtn = main(request);
}}
String cmd = (String)rtn.get(0);
String forwardKey = (String)rtn.get(1);
request.setAttribute("fromBean", rtn.get(2));
Map forwardMap = new HashMap();
forwardMap.put("login", "logon.jsp");
forwardMap.put("list", "StudentUnionDeptAction.jsp");
forwardMap.put("failure", "StudentUnionDeptForm.jsp");
forwardMap.put("success", "StudentUnionDeptList.jsp");
forwardMap.put("excel", "/upload/temp/" + userInfo.getName() + ".xls");
forwardMap.put("input", "StudentUnionDeptForm.jsp");
HttpTool.saveParameters(request, "Ext", allFormNames);
log.debug("cmd=" + cmd + ", forward=" + forwardKey);
if (forwardKey.equals("list")) {
    List paras = HttpTool.getSavedUrlForm(request, "Ext");
    List urls = (List)paras.get(0);
    urls.addAll((List)paras.get(2));
    String url = Tool.join("&", urls);
    out.println("<script>window.location='StudentUnionDeptAction.jsp?cmd=list&page=" + currpage + ((url.length() == 0) ? "" : "&" + url) + "';</script>");
}
else {
    pageContext.forward((String)forwardMap.get(forwardKey) + "?cmd=" + cmd + "&page=" + currpage);
}

      out.write('\r');
      out.write('\n');
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
