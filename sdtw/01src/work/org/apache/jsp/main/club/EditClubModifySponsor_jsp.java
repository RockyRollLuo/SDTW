/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.65
 * Generated at: 2017-04-26 01:35:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.main.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.xietong.software.common.COptionConst;
import com.xietong.software.common.HeadConst;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.sdtw.db.Club;
import com.xietong.software.sdtw.db.ClubMembers;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.common.CEditConst;
import com.xietong.software.common.HtmlTool;
import com.xietong.software.base.Power;
import com.xietong.software.util.Tool;
import com.xietong.software.common.UserInfo;
import java.util.*;
import java.sql.*;

public final class EditClubModifySponsor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

UserInfo userInfo = Tool.getUserInfo(request);
if(userInfo==null){
	out.print(HtmlTool.msgBox(request, "请先登录","../index.jsp","../index.jsp"));
	return;
}
List PoliticsNameOptions = CEditConst.getPoliticsNameOptions(userInfo,"-1");
List MemberDutyOptions = CEditConst.getMemberDutyOptions(userInfo,"-1");
List AcademyNameOptions = CEditConst.getAcademyNameOptions(userInfo,"-1");
List MajorNameOptions = CEditConst.getMajorNameOptions(userInfo,"-1");
List GradeNameOptions = CEditConst.getGradeNameOptions(userInfo,"-1");
List sexOptions = CEditConst.getsexOptions(userInfo,"-1");
List ClubNameOptions = CEditConst.getClubNameOptions(userInfo,"-1");
//MemberName==mlist.get(j)&MemberClubname
String cmd = ParamUtils.getParameter(request,"cmd","");
int MemberClubname = ParamUtils.getIntParameter(request,"cid",-1);//社团id
int MemberName = ParamUtils.getIntParameter(request,"uid",-1);
ClubMembers members = new ClubMembers();
List cdt = new ArrayList();
List list = new ArrayList();
cdt.add("MemberClubname="+MemberClubname);
cdt.add("MemberName="+MemberName);
list = members.query(cdt);
if(list.size()>0){
	members = (ClubMembers)list.get(0);
}
String checkflag = ParamUtils.getParameter(request,"checkflag","");

cdt.clear();
cdt.add("id in("+MemberName+")");
List UserCnNameOptions = COptionConst.getUserCnNameOptions(userInfo,cdt);
	//CEditConst.getUserCnNameOptions(userInfo,"-1");

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(HeadConst.apache_url );
      out.write("/main/js/datepicker/WdatePicker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");

if(!"".equals(checkflag)){
      out.write("\r\n");
      out.write("$('.ui-dialog-buttonset').find(\"button:eq(0)\").hide();\r\n");
      out.write("$('.ui-dialog-buttonset').find(\"button:eq(1)\").find(\"span:eq(0)\").html(\"关闭\");\r\n");
}

      out.write("\r\n");
      out.write("function formsubmit(){\r\n");
      out.write("\tvar formname=document.getElementById(\"formP\");\r\n");
      out.write("\tif ($('#MemberSex').val()==\"\"){\r\n");
      out.write("  \t\talert(\"性别不能为空！\");\r\n");
      out.write("  \t\t$('#MemberSex').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif ($('#MemberBrith').val()==\"\"){\r\n");
      out.write("  \t\talert(\"出生年月不能为空！\");\r\n");
      out.write("  \t\t$('#MemberBrith').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif ($('#MemberPolitics').val()==\"\"){\r\n");
      out.write(" \t\talert(\"政治面貌不能为空！\");\r\n");
      out.write("  \t\t$('#MemberPolitics').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif ($('#MemberBirthplace').val()==\"\"){\r\n");
      out.write(" \t\talert(\"籍贯不能为空！\");\r\n");
      out.write("  \t\t$('#MemberBirthplace').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#MemberPhone').val()==\"\"){\r\n");
      out.write("  \t\talert(\"手机不能为空！\");\r\n");
      out.write("  \t\t$('#MemberPhone').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t} else {\r\n");
      out.write(" \t\tvar myreg = /^(((13[0-9]{1})|(14[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\\d{8})$/;\r\n");
      out.write(" \t\tvar MemberPhone = $('#MemberPhone').val();\r\n");
      out.write(" \t\tif(!myreg.test(MemberPhone)){\r\n");
      out.write("        \talert(\"手机格式不正确！\");\r\n");
      out.write("        \t$('#MemberPhone').focus();\r\n");
      out.write("        \treturn false;\r\n");
      out.write("        } \r\n");
      out.write(" \t}\r\n");
      out.write("\t/* formname.managerDuty_final.value = $(\"select[name='managerDuty']\").val();\r\n");
      out.write("\t if(formname.managerDuty && formname.managerDuty.value==\"其他\"){\r\n");
      out.write("\t\t formname.managerDuty_final.value = \"其他-\" + $(\"input[name='managerDuty_other']\").val();\r\n");
      out.write("\t } */\r\n");
      out.write("\tif ($('#MemberAcademy').val()==\"\"){\r\n");
      out.write("  \t\talert(\"学院不能为空！\");\r\n");
      out.write("  \t\t$('#MemberAcademy').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#MemberMajor').val()==\"\"){\r\n");
      out.write("  \t\talert(\"专业不能为空！\");\r\n");
      out.write("  \t\t$('#MemberMajor').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#MemberGrade').val()==\"\"){\r\n");
      out.write("  \t\talert(\"年级不能为空！\");\r\n");
      out.write("  \t\t$('#MemberGrade').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#MemberEmail').val()==\"\"){\r\n");
      out.write("  \t\talert(\"E-mail不能为空！\");\r\n");
      out.write("  \t\t$('#MemberEmail').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t} else {\r\n");
      out.write(" \t\tvar MemberEmail = $('#MemberEmail').val();\r\n");
      out.write(" \t\tvar myreg = /^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$/;\r\n");
      out.write(" \t    if(!myreg.test(MemberEmail)){\r\n");
      out.write(" \t    \t$('#MemberEmail').focus();\r\n");
      out.write(" \t    \talert(\"邮箱格式不正确！\");\r\n");
      out.write(" \t    \treturn false;\r\n");
      out.write(" \t\t } \r\n");
      out.write("\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#Memberqq').val()==\"\"){\r\n");
      out.write("  \t\talert(\"QQ不能为空！\");\r\n");
      out.write("  \t\t$('#Memberqq').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\tif ($('#Memberwx').val()==\"\"){\r\n");
      out.write("  \t\talert(\"微信不能为空！\");\r\n");
      out.write("  \t\t$('#Memberwx').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\r\n");
      out.write("\tif ($('#MProfile').val()==\"\"){\r\n");
      out.write("  \t\talert(\"个人简介不能为空！\");\r\n");
      out.write("  \t\t$('#MProfile').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write(" \tif ($('#MExperience').val()==\"\"){\r\n");
      out.write("  \t\talert(\"社团工作经历不能为空！\");\r\n");
      out.write("  \t\t$('#MExperience').focus();\r\n");
      out.write("    \treturn false;\r\n");
      out.write(" \t}\r\n");
      out.write("\t\r\n");
      out.write("    //提交表单数据,包括disabled的输入域\r\n");
      out.write("    var len=formname.elements.length;\r\n");
      out.write("    var i;\r\n");
      out.write("    for (i=0;i<len;i++){\r\n");
      out.write("         formname.elements[i].disabled = false;\r\n");
      out.write("    } \r\n");
      out.write("    tijiao();\r\n");
      out.write("    return true;\r\n");
      out.write("}\r\n");
      out.write("function tijiao(){\r\n");
      out.write("\tvar url = \"");
      out.print(HeadConst.apache_url);
      out.write("/main/club/ClubMembersAction.jsp?cmd=updateUser&\"+$('form').serialize();\r\n");
      out.write("\t$.ajax({\r\n");
      out.write("\t\tcache:false,\r\n");
      out.write("\t\ttype:\"json\",\r\n");
      out.write("\t\turl:url,\r\n");
      out.write("\t\tdataType:'json',\r\n");
      out.write("\t\tasync:false,\r\n");
      out.write("\t\terror:function(request){\r\n");
      out.write("\t\t\talert('操作提示:发送请求失败！');\r\n");
      out.write("\t\t},\r\n");
      out.write("\t\tsuccess:function(data){\r\n");
      out.write("\t\t\tif(data.msg==\"ok\"){\r\n");
      out.write("\t\t\t\talert('操作成功');\r\n");
      out.write("\t\t\t\t$('#top_dialog').dialog('close');\r\n");
      out.write("\t\t\t}else{\r\n");
      out.write("\t\t\t\t//alert('操作失败');\r\n");
      out.write("\t\t\t\t$('#top_dialog').dialog('close');\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t});\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(HeadConst.apache_url );
      out.write("/main/club/ClubMembersAction.jsp\" id=\"formP\" method=\"post\">\r\n");
      out.write("<table background=\"#e3e5e8\" width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"4\" cellspacing=\"1\">\r\n");
      out.write("<input id=\"Id\" name=\"Id\" value=\"");
      out.print(members.getId());
      out.write("\" type=\"hidden\"/>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>学号：</td>\r\n");
      out.write("    <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("    <input type=\"text\" name=\"MemberSno\" id=\"MemberSno\" value=\"");
      out.print(members.getMemberSno() );
      out.write("\" />\r\n");
      out.write("\r\n");
      out.write("\t<td class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>姓名：</td>\r\n");
      out.write("    <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("   ");
      out.print(HtmlTool.renderSelect(UserCnNameOptions,""+members.getMemberName(),"MemberName","") );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    <td class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>性别：</td>\r\n");
      out.write("     <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("     ");
      out.print(HtmlTool.renderSelect(sexOptions,""+members.getMemberSex(),"MemberSex","") );
      out.write("\r\n");
      out.write("     </td>\r\n");
      out.write("     </tr>\r\n");
      out.write("     <tr>\r\n");
      out.write("    <td  class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>出生年月：</td>\r\n");
      out.write("     <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("     <input readonly=\"readonly\" class= \"date\" name =\"MemberBrith\" id= \"MemberBrith\" onfocus=\"WdatePicker({el:'MemberBrith',dateFmt:'yyyy-MM-dd'})\"  size= \"0\" value=\"");
      out.print(members.getMemberBrith());
      out.write("\"/>\r\n");
      out.write("     </td>\r\n");
      out.write("\r\n");
      out.write("\t<td class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>政治面貌：</td>\r\n");
      out.write("    <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("    ");
      out.print(HtmlTool.renderSelect(PoliticsNameOptions,""+members.getMemberPolitics(),"MemberPolitics","") );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    <td  class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>籍贯：</td>\r\n");
      out.write("     <td align=\"left\" colspan=\"3\" bgcolor=\"#FFFFFF\"><input type=\"text\" name=\"MemberBirthplace\" id=\"MemberBirthplace\" value=\"");
      out.print(members.getMemberBirthplace());
      out.write("\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\">&nbsp;所在社团：</td>\r\n");
      out.write("    <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("    ");
      out.print(HtmlTool.renderSelect(ClubNameOptions,members.getMemberClubname(),"MemberClubname",""+MemberClubname,true) );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    <td  class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>职务：</td>\r\n");
      out.write("     <td align=\"left\"  colspan=\"3\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("     ");
      out.print(HtmlTool.renderSelect(MemberDutyOptions,""+members.getMemberDuty(),"MemberDuty","",true) );
      out.write("\r\n");
      out.write("     </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>学院：</td>\r\n");
      out.write("    <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("    ");
      out.print(HtmlTool.renderSelect(AcademyNameOptions,""+members.getMemberAcademy(),"MemberAcademy","") );
      out.write("\r\n");
      out.write("    </td>\r\n");
      out.write("    <td  class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>专业：</td>\r\n");
      out.write("     <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("     ");
      out.print(HtmlTool.renderSelect(MajorNameOptions,""+members.getMemberMajor(),"MemberMajor","") );
      out.write("\r\n");
      out.write("     </td>\r\n");
      out.write("    <td  class=\"form_label\">&nbsp;<font color=\"red\">*&nbsp;</font>年级：</td>\r\n");
      out.write("     <td align=\"left\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("     ");
      out.print(HtmlTool.renderSelect(GradeNameOptions,""+members.getMemberGrade(),"MemberGrade","") );
      out.write("\r\n");
      out.write("     </td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\" rowspan=\"2\">&nbsp;<font color=\"red\">*&nbsp;</font>联系方式：</td>\r\n");
      out.write("\t<td bgcolor=\"#FFFFFF\">&nbsp;<font color=\"red\">*&nbsp;</font>手机：\r\n");
      out.write("\t<input type=\"text\" name=\"MemberPhone\" id=\"MemberPhone\"   value=\"");
      out.print(members.getMemberPhone());
      out.write("\"> </td>\r\n");
      out.write("\t<td bgcolor=\"#FFFFFF\">&nbsp;<font color=\"red\">*&nbsp;</font>E-mail：</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"3\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("\t<input type=\"text\" name=\"MemberEmail\" id=\"MemberEmail\"   value=\"");
      out.print(members.getMemberEmail());
      out.write("\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td bgcolor=\"#FFFFFF\">&nbsp;<font color=\"red\">*&nbsp;</font>QQ：\r\n");
      out.write("\t<input type=\"text\" name=\"Memberqq\" id=\"Memberqq\"  value=\"");
      out.print(members.getMemberqq());
      out.write("\"></td>\r\n");
      out.write("    <td bgcolor=\"#FFFFFF\">&nbsp;<font color=\"red\">*&nbsp;</font>微信：</td>\r\n");
      out.write("    <td align=\"left\" colspan=\"3\" bgcolor=\"#FFFFFF\">\r\n");
      out.write("    <input type=\"text\" name=\"Memberwx\" id=\"Memberwx\"  value=\"");
      out.print(members.getMemberwx());
      out.write("\"></td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\" >&nbsp;<font color=\"red\">*&nbsp;</font>个人简介：</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"5\" bgcolor=\"#FFFFFF\"><textarea name=\"MProfile\" id=\"MProfile\"  style=\"width: 80%;\" cols=\"130\" rows=\"4\">");
      out.print(members.getMProfile() );
      out.write("</textarea>\t</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td class=\"form_label\" >&nbsp;<font color=\"red\">*&nbsp;</font>社团工作经历：</td>\r\n");
      out.write("\t<td align=\"left\" colspan=\"5\" bgcolor=\"#FFFFFF\"><textarea name=\"MExperience\" id=\"MExperience\" style=\"width: 80%;\" cols=\"130\" rows=\"4\">");
      out.print(members.getMExperience() );
      out.write("</textarea></td>\r\n");
      out.write("</tr>\r\n");

String bt1 = "确定添加";
String bt2 = "取消添加";
if(members.getId()!=-1){
	bt1 = "确定修改";
	bt2 = "取消修改";
}
String state = ParamUtils.getParameter(request,"state","");
if(state.equals(SdtwConst.CHECKFLAG_WSB)||state.equals(SdtwConst.CHECKFLAG_XYWTG)||state.equals(SdtwConst.CHECKFLAG_XXWTG))
if((userInfo.getId()+"").equals(members.getAddPerson())||members.getAddPerson().equals("")){

      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write('\r');
      out.write('\n');
} 
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
