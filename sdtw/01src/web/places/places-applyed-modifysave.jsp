<%@ page contentType="text/html;charset=GBK" %>
<%@ page import="java.util.Random"%>
<jsp:useBean id="tsd" scope="page" class="pub.db_tuanwei" />
<jsp:useBean id="gb2312" scope="page" class="pub.ISOtoGb2312" />
<jsp:useBean id="mytime" scope="page" class="pub.mytime"/>

<%
int retval=0;
String useraccount= (String)session.getAttribute("useraccount");
String addtime = mytime.getTime();

String placeapplycode = request.getParameter("placeapplycode");
//表中填写的数据
String applicant = gb2312.convert(request.getParameter("applicant"));
String activityprincipal =gb2312.convert( request.getParameter("activityprincipal"));
String principalduty = gb2312.convert(request.getParameter("principalduty"));
String principalphone =gb2312.convert( request.getParameter("principalphone"));
//String palcename =gb2312.convert( request.getParameter("palcename"));//场地名称只用于在填表的时候显示，并不存入申请表，只存入placecode,以免placename被人修改
String activitytime =gb2312.convert( request.getParameter("activitytime"));
String distributionperiod = gb2312.convert(request.getParameter("distributionperiod"));
String rehearsalperiod =gb2312.convert( request.getParameter("rehearsalperiod"));
String activitycontents = gb2312.convert(request.getParameter("activitycontents"));
String speaker = gb2312.convert(request.getParameter("speaker"));

String basicprocedures = gb2312.convert(request.getParameter("basicprocedures"));
String meetingmarks = gb2312.convert(request.getParameter("meetingmarks"));
String backgroundcontents = gb2312.convert( request.getParameter("backgroundcontents"));
String sponsorship=gb2312.convert(request.getParameter("sponsorship"));
String propaganda = gb2312.convert(request.getParameter("propaganda"));
String otherpropaganda = gb2312.convert(request.getParameter("otherpropaganda"));
String tablenums =request.getParameter("tablenums");
String chairnums =request.getParameter("chairnums");
String wiredmicrophonenums =request.getParameter("wiredmicrophonenums");
String wirelessmicrophonenums =request.getParameter("wirelessmicrophonenums");

String batterynums =request.getParameter("batterynums");
String usefloor =request.getParameter("usefloor");
String useaudio =request.getParameter("useaudio");
String uselighting =request.getParameter("uselighting");
String usestagelight =request.getParameter("usestagelight");
String usecomputerlight =request.getParameter("usecomputerlight");
String useprojector =request.getParameter("useprojector");
String useac =request.getParameter("useac");
String usebanner =request.getParameter("usebanner");
String bannercontent = gb2312.convert(request.getParameter("bannercontent"));

String useposter =request.getParameter("useposter");
String postercontent = gb2312.convert(request.getParameter("postercontent"));
String vehiclenums =request.getParameter("vehiclenums");
String promiser = gb2312.convert(request.getParameter("promiser"));
String promiserphone = gb2312.convert(request.getParameter("promiserphone"));
String promiseracademy = gb2312.convert(request.getParameter("promiseracademy"));
String promiserclass = gb2312.convert(request.getParameter("promiserclass"));
String tutor = gb2312.convert(request.getParameter("tutor"));
String tutorduty = gb2312.convert(request.getParameter("tutorduty"));
String tutorphone = gb2312.convert(request.getParameter("tutorphone"));
// String tutoragree =request.getParameter("tutoragree");
// String guideunitagree =request.getParameter("guideunitagree");
// String tuanweiagree =request.getParameter("tuanweiagree");
String remarks = gb2312.convert(request.getParameter("remarks"));




//将申请表的内容存入places_applytable
String update_places_applytable="UPDATE places_applytable SET "
        + " applicant='" + applicant
        + "',activityprincipal='" + activityprincipal 
        + "',principalduty='" + principalduty 
        + "',principalphone='" + principalphone 
        + "',activitytime='" + activitytime 
        + "',distributionperiod='" + distributionperiod 
        + "',rehearsalperiod='" + rehearsalperiod 
        + "',activitycontents='" + activitycontents 
        + "',speaker='" + speaker 
        + "',basicprocedures='" + basicprocedures 
        + "',meetingmarks='" + meetingmarks 
        + "',backgroundcontents='" + backgroundcontents 
        + "',sponsorship='" + sponsorship 
        + "',propaganda='" + propaganda 
        + "',otherpropaganda='" + otherpropaganda 
        + "',tablenums='" + tablenums 
        + "',chairnums='" + chairnums 
        + "',wiredmicrophonenums='" + wiredmicrophonenums 
        + "',wirelessmicrophonenums='" + wirelessmicrophonenums 
        + "',batterynums='" + batterynums 
        + "',usefloor='" + usefloor 
        + "',useaudio='" + useaudio 
        + "',uselighting='" + uselighting 
        + "',usestagelight='" + usestagelight 
        + "',usecomputerlight='" + usecomputerlight 
        + "',useprojector='" + useprojector 
        + "',useac='" + useac
        + "',usebanner='" + usebanner
        + "',bannercontent='" + bannercontent
        + "',useposter='" + useposter
        + "',postercontent='" + postercontent
        + "',vehiclenums='" + vehiclenums
        + "',promiser='" + promiser
        + "',promiserphone='" + promiserphone 
        + "',promiseracademy='" + promiseracademy
        + "',promiserclass='" + promiserclass
        + "',tutor='" + tutor
        + "',tutorduty='" + tutorduty
        + "',tutorphone='" + tutorphone
        + ",remarks='" + remarks
        
        +"' WHERE placeapplycode='"+placeapplycode+"'";
 

try{

    retval=tsd.executeUpdate(update_places_applytable);
      
}
catch (Exception ex){
    out.print(ex.getMessage());
}
finally {
    tsd.disconnectToDB(); 
}

%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<% request.setCharacterEncoding("GBK"); %>
<link href="../pubcss/common-student.css" rel="stylesheet" type="text/css"/>
<script src="../pubjs/jquery.min.js"></script>
</head>

<%
String strposition = "场地管理 >> 申请状态查询>>";
String strfunction = "修改场地申请表";
String strhelpwords= "修改场地申请表。";
%>
<%@ include file="../pubpro/pagetop-positionandhelp.jsp" %>
<table class="frame-table" align="center">
    <%if (retval==1) {%>
        <tr height="35"><th>修改成功</th></tr>
        <tr height="77"><td>申请表修改成功</td></tr>
    <%} else {%>
        <tr height="35"><th>修改失败</th></tr>
        <tr height="77"><td>申请表修改失败，请重新添加</td></tr>
    <%} %>
    <tr height="35px"> 
        <th><a href="places-applyed-list.jsp">返回已申请场地列表</a></th>
    </tr>    
</table>
</html>
