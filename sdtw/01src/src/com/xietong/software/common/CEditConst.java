//自动生成的程序，请不要修改，下次生成的时候会覆盖
package com.xietong.software.common;
import java.io.*;
import java.util.*;
import com.xietong.software.common.*;
import com.xietong.software.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class CEditConst {
    private static javax.servlet.ServletContext servletContext = null;
    private static Log log = LogFactory.getLog(CEditConst.class);
    private static Map dictionary = new HashMap();
    public static synchronized String refresh() {
        String rtn = Tool.join("\r\n", dictionary.keySet());
        dictionary.clear();
        return rtn;
    }
    public static synchronized void setRefreshFlag(String db, String clsName) {
        String[] names = (String[])classMap.get(clsName);
        log.debug(db + "." + clsName + " setRefreshFlag!");
        if (names == null) {
            return;
        }
        for (int i = 0; i < names.length; i ++) {
            String name = db + "." + names[i];
            log.debug(name + " setFlag!");
            if (dictionary.containsKey(name + "options")) {
                dictionary.remove(name + "options");
            }
            if (dictionary.containsKey(name + "map")) {
                dictionary.remove(name + "map");
            }
        }
    }
    public static List removeFirstItem(List opt) {
        List options = new ArrayList();
        for (int i = 1; i < opt.size(); i ++) {
            options.add(opt.get(i));
        }
        return options;
    }
    public static List pushDefaultValue(List opt, String defval) {
        List rtn = new ArrayList();
        if (defval != null) {
            rtn.add(new OptionBean("", defval));
        }
        rtn.addAll(opt);
        return rtn;
    }
    private static Map classMap = null;
    public static void init(javax.servlet.ServletContext sc) {
        servletContext = sc;
        classMap = new HashMap();
        classMap.put("com.xietong.software.sdtw.db.Nations", new String[]{"NationName"});
        classMap.put("com.xietong.software.sdtw.db.CampusActivityKind", new String[]{"ActivitykindType"});
        classMap.put("com.xietong.software.sdtw.db.BaseUserCode", new String[]{"UserName", "UserCnName"});
        classMap.put("com.xietong.software.sdtw.db.Club", new String[]{"ClubName"});
        classMap.put("com.xietong.software.sdtw.db.ClubActivityProject", new String[]{"ClubProjectName"});
        classMap.put("com.xietong.software.sdtw.db.Grade", new String[]{"GradeName"});
        classMap.put("com.xietong.software.sdtw.db.Classes", new String[]{"ClassesName"});
        classMap.put("com.xietong.software.sdtw.db.BaseRoleCode", new String[]{"RoleName"});
        classMap.put("com.xietong.software.sdtw.db.Academy", new String[]{"AcademyAliasName", "AcademyName"});
        classMap.put("com.xietong.software.sdtw.db.BaseMoudle", new String[]{"MoudleName"});
        classMap.put("com.xietong.software.sdtw.db.InnovationCompetitionProject", new String[]{"ProductionName"});
        classMap.put("com.xietong.software.sdtw.db.StudentUnionDept", new String[]{"StuDeptName"});
        classMap.put("com.xietong.software.sdtw.db.BaseDeptCode", new String[]{"DeptName"});
        classMap.put("com.xietong.software.sdtw.db.ClubType", new String[]{"ClubTypeName"});
        classMap.put("com.xietong.software.sdtw.db.Major", new String[]{"MajorName"});
        classMap.put("com.xietong.software.sdtw.db.VolunteerProject", new String[]{"VolunProjectName"});
        classMap.put("com.xietong.software.sdtw.db.InnovationCompetition", new String[]{"InnovationProductionName"});
        classMap.put("com.xietong.software.sdtw.db.StandardupGrade", new String[]{"StandardUpGradeName"});
        classMap.put("com.xietong.software.sdtw.db.VolunteerActivity", new String[]{"VolunActivityName"});
        classMap.put("com.xietong.software.sdtw.db.VolunteerZhiku", new String[]{"NoticeName"});
        classMap.put("com.xietong.software.sdtw.db.BaseOrgCode", new String[]{"OrgName"});
    }
    public static synchronized void prepareNationName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".NationName"};
        if (dictionary.containsKey("NationNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("NationName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Nations v = new com.xietong.software.sdtw.db.Nations();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Nations item = (com.xietong.software.sdtw.db.Nations)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareActivitykindType(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ActivitykindType"};
        if (dictionary.containsKey("ActivitykindTypeoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ActivitykindType refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.CampusActivityKind v = new com.xietong.software.sdtw.db.CampusActivityKind();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.CampusActivityKind item = (com.xietong.software.sdtw.db.CampusActivityKind)it.next();
            options[0].add(new OptionBean("" + item.getKindName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getKindName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareUserCnName(UserInfo userInfo) {
        prepareUserName(userInfo);
    }
    public static synchronized void prepareUserName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".UserName", "tuanwei" + ".UserCnName"};
        if (dictionary.containsKey("UserCnNameoptions")) {
            return;
        }
        List[] options = {new ArrayList(), new ArrayList()};
        Map[] map = {new HashMap(), new HashMap()};
        log.debug("UserName,UserCnName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.BaseUserCode v = new com.xietong.software.sdtw.db.BaseUserCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseUserCode item = (com.xietong.software.sdtw.db.BaseUserCode)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
            options[1].add(new OptionBean("" + item.getCnName(), "" + item.getId()));
            map[1].put("" + item.getId(), "" + item.getCnName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareClubName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ClubName"};
        if (dictionary.containsKey("ClubNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ClubName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Club v = new com.xietong.software.sdtw.db.Club();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Club item = (com.xietong.software.sdtw.db.Club)it.next();
            options[0].add(new OptionBean("" + item.getClubName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getClubName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareClubProjectName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ClubProjectName"};
        if (dictionary.containsKey("ClubProjectNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ClubProjectName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.ClubActivityProject v = new com.xietong.software.sdtw.db.ClubActivityProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.ClubActivityProject item = (com.xietong.software.sdtw.db.ClubActivityProject)it.next();
            options[0].add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getProjectName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareGradeName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".GradeName"};
        if (dictionary.containsKey("GradeNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("GradeName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Grade v = new com.xietong.software.sdtw.db.Grade();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Grade item = (com.xietong.software.sdtw.db.Grade)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareClassesName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ClassesName"};
        if (dictionary.containsKey("ClassesNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ClassesName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Classes v = new com.xietong.software.sdtw.db.Classes();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Classes item = (com.xietong.software.sdtw.db.Classes)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareRoleName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".RoleName"};
        if (dictionary.containsKey("RoleNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("RoleName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.BaseRoleCode v = new com.xietong.software.sdtw.db.BaseRoleCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseRoleCode item = (com.xietong.software.sdtw.db.BaseRoleCode)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareAcademyName(UserInfo userInfo) {
        prepareAcademyAliasName(userInfo);
    }
    public static synchronized void prepareAcademyAliasName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".AcademyAliasName", "tuanwei" + ".AcademyName"};
        if (dictionary.containsKey("AcademyNameoptions")) {
            return;
        }
        List[] options = {new ArrayList(), new ArrayList()};
        Map[] map = {new HashMap(), new HashMap()};
        log.debug("AcademyAliasName,AcademyName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Academy v = new com.xietong.software.sdtw.db.Academy();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Academy item = (com.xietong.software.sdtw.db.Academy)it.next();
            options[0].add(new OptionBean("" + item.getAcademyalias(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getAcademyalias());
            options[1].add(new OptionBean("" + item.getAcademyName(), "" + item.getId()));
            map[1].put("" + item.getId(), "" + item.getAcademyName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareMoudleName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".MoudleName"};
        if (dictionary.containsKey("MoudleNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("MoudleName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.BaseMoudle v = new com.xietong.software.sdtw.db.BaseMoudle();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseMoudle item = (com.xietong.software.sdtw.db.BaseMoudle)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareProductionName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ProductionName"};
        if (dictionary.containsKey("ProductionNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ProductionName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.InnovationCompetitionProject v = new com.xietong.software.sdtw.db.InnovationCompetitionProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.InnovationCompetitionProject item = (com.xietong.software.sdtw.db.InnovationCompetitionProject)it.next();
            options[0].add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getProjectName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareStuDeptName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".StuDeptName"};
        if (dictionary.containsKey("StuDeptNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("StuDeptName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.StudentUnionDept v = new com.xietong.software.sdtw.db.StudentUnionDept();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.StudentUnionDept item = (com.xietong.software.sdtw.db.StudentUnionDept)it.next();
            options[0].add(new OptionBean("" + item.getDeptName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getDeptName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareDeptName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".DeptName"};
        if (dictionary.containsKey("DeptNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("DeptName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.BaseDeptCode v = new com.xietong.software.sdtw.db.BaseDeptCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseDeptCode item = (com.xietong.software.sdtw.db.BaseDeptCode)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareClubTypeName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".ClubTypeName"};
        if (dictionary.containsKey("ClubTypeNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("ClubTypeName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.ClubType v = new com.xietong.software.sdtw.db.ClubType();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.ClubType item = (com.xietong.software.sdtw.db.ClubType)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareMajorName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".MajorName"};
        if (dictionary.containsKey("MajorNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("MajorName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.Major v = new com.xietong.software.sdtw.db.Major();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Major item = (com.xietong.software.sdtw.db.Major)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareVolunProjectName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".VolunProjectName"};
        if (dictionary.containsKey("VolunProjectNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("VolunProjectName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerProject v = new com.xietong.software.sdtw.db.VolunteerProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerProject item = (com.xietong.software.sdtw.db.VolunteerProject)it.next();
            options[0].add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getProjectName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareInnovationProductionName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".InnovationProductionName"};
        if (dictionary.containsKey("InnovationProductionNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("InnovationProductionName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.InnovationCompetition v = new com.xietong.software.sdtw.db.InnovationCompetition();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.InnovationCompetition item = (com.xietong.software.sdtw.db.InnovationCompetition)it.next();
            options[0].add(new OptionBean("" + item.getProductionName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getProductionName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareStandardUpGradeName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".StandardUpGradeName"};
        if (dictionary.containsKey("StandardUpGradeNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("StandardUpGradeName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.StandardupGrade v = new com.xietong.software.sdtw.db.StandardupGrade();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.StandardupGrade item = (com.xietong.software.sdtw.db.StandardupGrade)it.next();
            options[0].add(new OptionBean("" + item.getStandardUpGradeName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getStandardUpGradeName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareVolunActivityName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".VolunActivityName"};
        if (dictionary.containsKey("VolunActivityNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("VolunActivityName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerActivity v = new com.xietong.software.sdtw.db.VolunteerActivity();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerActivity item = (com.xietong.software.sdtw.db.VolunteerActivity)it.next();
            options[0].add(new OptionBean("" + item.getActivityname(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getActivityname());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareNoticeName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".NoticeName"};
        if (dictionary.containsKey("NoticeNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("NoticeName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerZhiku v = new com.xietong.software.sdtw.db.VolunteerZhiku();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerZhiku item = (com.xietong.software.sdtw.db.VolunteerZhiku)it.next();
            options[0].add(new OptionBean("" + item.getNoticeName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getNoticeName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static synchronized void prepareOrgName(UserInfo userInfo) {
        String[] names = {"tuanwei" + ".OrgName"};
        if (dictionary.containsKey("OrgNameoptions")) {
            return;
        }
        List[] options = {new ArrayList()};
        Map[] map = {new HashMap()};
        log.debug("OrgName refresh!");
        List cdt = new ArrayList();
        com.xietong.software.sdtw.db.BaseOrgCode v = new com.xietong.software.sdtw.db.BaseOrgCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseOrgCode item = (com.xietong.software.sdtw.db.BaseOrgCode)it.next();
            options[0].add(new OptionBean("" + item.getName(), "" + item.getId()));
            map[0].put("" + item.getId(), "" + item.getName());
        }
        for (int i = 0; i < names.length; i ++) {
            dictionary.put(names[i] + "map", map[i]);
            dictionary.put(names[i] + "options", options[i]);
        }
    }
    public static List getUserNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getUserNameOptions(userInfo), defval);
    }
    public static List getUserNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".UserNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareUserName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getUserNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".UserNamemap";
        if (!dictionary.containsKey(name)) {
            prepareUserName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getUserNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map UserNamemap = getUserNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((UserNamemap.get(arr[i]) != null) ? (String)UserNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getUserCnNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getUserCnNameOptions(userInfo), defval);
    }
    public static List getUserCnNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".UserCnNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareUserCnName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getUserCnNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".UserCnNamemap";
        if (!dictionary.containsKey(name)) {
            prepareUserCnName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getUserCnNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map UserCnNamemap = getUserCnNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((UserCnNamemap.get(arr[i]) != null) ? (String)UserCnNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareMsgProp(UserInfo userInfo) {
        if (dictionary.containsKey("MsgPropoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"短消息草稿","短消息收藏"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("MsgPropmap", map);
        dictionary.put("MsgPropoptions", options);
    }
    public static List getMsgPropOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMsgPropOptions(userInfo), defval);
    }
    public static List getMsgPropOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("MsgPropoptions")) {
            prepareMsgProp(userInfo);
        }
        return (List)dictionary.get("MsgPropoptions");
    }
    public static Map getMsgPropMap(UserInfo userInfo) {
        if (!dictionary.containsKey("MsgPropmap")) {
            prepareMsgProp(userInfo);
        }
        return (Map)dictionary.get("MsgPropmap");
    }
    public static List getMsgPropLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MsgPropmap = getMsgPropMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MsgPropmap.get(arr[i]) != null) ? (String)MsgPropmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareYesNo(UserInfo userInfo) {
        if (dictionary.containsKey("YesNooptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"否","是"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("YesNomap", map);
        dictionary.put("YesNooptions", options);
    }
    public static List getYesNoOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getYesNoOptions(userInfo), defval);
    }
    public static List getYesNoOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("YesNooptions")) {
            prepareYesNo(userInfo);
        }
        return (List)dictionary.get("YesNooptions");
    }
    public static Map getYesNoMap(UserInfo userInfo) {
        if (!dictionary.containsKey("YesNomap")) {
            prepareYesNo(userInfo);
        }
        return (Map)dictionary.get("YesNomap");
    }
    public static List getYesNoLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map YesNomap = getYesNoMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((YesNomap.get(arr[i]) != null) ? (String)YesNomap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareMsgGrade(UserInfo userInfo) {
        if (dictionary.containsKey("MsgGradeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"普通","重要"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("MsgGrademap", map);
        dictionary.put("MsgGradeoptions", options);
    }
    public static List getMsgGradeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMsgGradeOptions(userInfo), defval);
    }
    public static List getMsgGradeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("MsgGradeoptions")) {
            prepareMsgGrade(userInfo);
        }
        return (List)dictionary.get("MsgGradeoptions");
    }
    public static Map getMsgGradeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("MsgGrademap")) {
            prepareMsgGrade(userInfo);
        }
        return (Map)dictionary.get("MsgGrademap");
    }
    public static List getMsgGradeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MsgGrademap = getMsgGradeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MsgGrademap.get(arr[i]) != null) ? (String)MsgGrademap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getAcademyAliasNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAcademyAliasNameOptions(userInfo), defval);
    }
    public static List getAcademyAliasNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".AcademyAliasNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareAcademyAliasName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getAcademyAliasNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".AcademyAliasNamemap";
        if (!dictionary.containsKey(name)) {
            prepareAcademyAliasName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getAcademyAliasNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map AcademyAliasNamemap = getAcademyAliasNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((AcademyAliasNamemap.get(arr[i]) != null) ? (String)AcademyAliasNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void preparesex(UserInfo userInfo) {
        if (dictionary.containsKey("sexoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"男","女"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("sexmap", map);
        dictionary.put("sexoptions", options);
    }
    public static List getsexOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getsexOptions(userInfo), defval);
    }
    public static List getsexOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("sexoptions")) {
            preparesex(userInfo);
        }
        return (List)dictionary.get("sexoptions");
    }
    public static Map getsexMap(UserInfo userInfo) {
        if (!dictionary.containsKey("sexmap")) {
            preparesex(userInfo);
        }
        return (Map)dictionary.get("sexmap");
    }
    public static List getsexLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map sexmap = getsexMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((sexmap.get(arr[i]) != null) ? (String)sexmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareStudentRzdTypeName(UserInfo userInfo) {
        if (dictionary.containsKey("StudentRzdTypeNameoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"1","2","3","4","5","6","7","8","9","10"};
        String[] val = {"主题教育","文化艺术","体育健康","科技创新","社会实践","志愿服务","社会工作","社团经历","就业创业","学术讲座"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("StudentRzdTypeNamemap", map);
        dictionary.put("StudentRzdTypeNameoptions", options);
    }
    public static List getStudentRzdTypeNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getStudentRzdTypeNameOptions(userInfo), defval);
    }
    public static List getStudentRzdTypeNameOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("StudentRzdTypeNameoptions")) {
            prepareStudentRzdTypeName(userInfo);
        }
        return (List)dictionary.get("StudentRzdTypeNameoptions");
    }
    public static Map getStudentRzdTypeNameMap(UserInfo userInfo) {
        if (!dictionary.containsKey("StudentRzdTypeNamemap")) {
            prepareStudentRzdTypeName(userInfo);
        }
        return (Map)dictionary.get("StudentRzdTypeNamemap");
    }
    public static List getStudentRzdTypeNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map StudentRzdTypeNamemap = getStudentRzdTypeNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((StudentRzdTypeNamemap.get(arr[i]) != null) ? (String)StudentRzdTypeNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getRoleNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getRoleNameOptions(userInfo), defval);
    }
    public static List getRoleNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".RoleNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareRoleName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getRoleNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".RoleNamemap";
        if (!dictionary.containsKey(name)) {
            prepareRoleName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getRoleNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map RoleNamemap = getRoleNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((RoleNamemap.get(arr[i]) != null) ? (String)RoleNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareConsumeType(UserInfo userInfo) {
        if (dictionary.containsKey("ConsumeTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0荣誉","1","2"};
        String[] val = {"购书","退货","清空"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ConsumeTypemap", map);
        dictionary.put("ConsumeTypeoptions", options);
    }
    public static List getConsumeTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getConsumeTypeOptions(userInfo), defval);
    }
    public static List getConsumeTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ConsumeTypeoptions")) {
            prepareConsumeType(userInfo);
        }
        return (List)dictionary.get("ConsumeTypeoptions");
    }
    public static Map getConsumeTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ConsumeTypemap")) {
            prepareConsumeType(userInfo);
        }
        return (Map)dictionary.get("ConsumeTypemap");
    }
    public static List getConsumeTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ConsumeTypemap = getConsumeTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ConsumeTypemap.get(arr[i]) != null) ? (String)ConsumeTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareChuangKuDutyName(UserInfo userInfo) {
        if (dictionary.containsKey("ChuangKuDutyNameoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"成员","负责人"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ChuangKuDutyNamemap", map);
        dictionary.put("ChuangKuDutyNameoptions", options);
    }
    public static List getChuangKuDutyNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getChuangKuDutyNameOptions(userInfo), defval);
    }
    public static List getChuangKuDutyNameOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ChuangKuDutyNameoptions")) {
            prepareChuangKuDutyName(userInfo);
        }
        return (List)dictionary.get("ChuangKuDutyNameoptions");
    }
    public static Map getChuangKuDutyNameMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ChuangKuDutyNamemap")) {
            prepareChuangKuDutyName(userInfo);
        }
        return (Map)dictionary.get("ChuangKuDutyNamemap");
    }
    public static List getChuangKuDutyNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ChuangKuDutyNamemap = getChuangKuDutyNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ChuangKuDutyNamemap.get(arr[i]) != null) ? (String)ChuangKuDutyNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getDeptNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getDeptNameOptions(userInfo), defval);
    }
    public static List getDeptNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".DeptNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareDeptName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getDeptNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".DeptNamemap";
        if (!dictionary.containsKey(name)) {
            prepareDeptName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getDeptNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map DeptNamemap = getDeptNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((DeptNamemap.get(arr[i]) != null) ? (String)DeptNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareCkProjectStage(UserInfo userInfo) {
        if (dictionary.containsKey("CkProjectStageoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4"};
        String[] val = {"已经注册公司","公司正在筹备阶段","项目已经开始实施","项目论证阶段","其他阶段"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("CkProjectStagemap", map);
        dictionary.put("CkProjectStageoptions", options);
    }
    public static List getCkProjectStageOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getCkProjectStageOptions(userInfo), defval);
    }
    public static List getCkProjectStageOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectStageoptions")) {
            prepareCkProjectStage(userInfo);
        }
        return (List)dictionary.get("CkProjectStageoptions");
    }
    public static Map getCkProjectStageMap(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectStagemap")) {
            prepareCkProjectStage(userInfo);
        }
        return (Map)dictionary.get("CkProjectStagemap");
    }
    public static List getCkProjectStageLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map CkProjectStagemap = getCkProjectStageMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((CkProjectStagemap.get(arr[i]) != null) ? (String)CkProjectStagemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareApplyLevelType(UserInfo userInfo) {
        if (dictionary.containsKey("ApplyLevelTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3"};
        String[] val = {"一级","二级","三级","先进"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ApplyLevelTypemap", map);
        dictionary.put("ApplyLevelTypeoptions", options);
    }
    public static List getApplyLevelTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getApplyLevelTypeOptions(userInfo), defval);
    }
    public static List getApplyLevelTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ApplyLevelTypeoptions")) {
            prepareApplyLevelType(userInfo);
        }
        return (List)dictionary.get("ApplyLevelTypeoptions");
    }
    public static Map getApplyLevelTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ApplyLevelTypemap")) {
            prepareApplyLevelType(userInfo);
        }
        return (Map)dictionary.get("ApplyLevelTypemap");
    }
    public static List getApplyLevelTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ApplyLevelTypemap = getApplyLevelTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ApplyLevelTypemap.get(arr[i]) != null) ? (String)ApplyLevelTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareLenOfSchool(UserInfo userInfo) {
        if (dictionary.containsKey("LenOfSchooloptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"两年制 ","三年制 ","四年制 "};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("LenOfSchoolmap", map);
        dictionary.put("LenOfSchooloptions", options);
    }
    public static List getLenOfSchoolOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getLenOfSchoolOptions(userInfo), defval);
    }
    public static List getLenOfSchoolOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("LenOfSchooloptions")) {
            prepareLenOfSchool(userInfo);
        }
        return (List)dictionary.get("LenOfSchooloptions");
    }
    public static Map getLenOfSchoolMap(UserInfo userInfo) {
        if (!dictionary.containsKey("LenOfSchoolmap")) {
            prepareLenOfSchool(userInfo);
        }
        return (Map)dictionary.get("LenOfSchoolmap");
    }
    public static List getLenOfSchoolLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map LenOfSchoolmap = getLenOfSchoolMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((LenOfSchoolmap.get(arr[i]) != null) ? (String)LenOfSchoolmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getGradeNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getGradeNameOptions(userInfo), defval);
    }
    public static List getGradeNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".GradeNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareGradeName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getGradeNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".GradeNamemap";
        if (!dictionary.containsKey(name)) {
            prepareGradeName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getGradeNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map GradeNamemap = getGradeNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((GradeNamemap.get(arr[i]) != null) ? (String)GradeNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getStuDeptNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getStuDeptNameOptions(userInfo), defval);
    }
    public static List getStuDeptNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".StuDeptNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareStuDeptName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getStuDeptNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".StuDeptNamemap";
        if (!dictionary.containsKey(name)) {
            prepareStuDeptName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getStuDeptNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map StuDeptNamemap = getStuDeptNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((StuDeptNamemap.get(arr[i]) != null) ? (String)StuDeptNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareClubModifyType(UserInfo userInfo) {
        if (dictionary.containsKey("ClubModifyTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0"};
        String[] val = {"变更指导单位"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ClubModifyTypemap", map);
        dictionary.put("ClubModifyTypeoptions", options);
    }
    public static List getClubModifyTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getClubModifyTypeOptions(userInfo), defval);
    }
    public static List getClubModifyTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ClubModifyTypeoptions")) {
            prepareClubModifyType(userInfo);
        }
        return (List)dictionary.get("ClubModifyTypeoptions");
    }
    public static Map getClubModifyTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ClubModifyTypemap")) {
            prepareClubModifyType(userInfo);
        }
        return (Map)dictionary.get("ClubModifyTypemap");
    }
    public static List getClubModifyTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ClubModifyTypemap = getClubModifyTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ClubModifyTypemap.get(arr[i]) != null) ? (String)ClubModifyTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareCheckType(UserInfo userInfo) {
        if (dictionary.containsKey("CheckTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"1","2"};
        String[] val = {"学院审核及学校审核","仅学校审核"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("CheckTypemap", map);
        dictionary.put("CheckTypeoptions", options);
    }
    public static List getCheckTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getCheckTypeOptions(userInfo), defval);
    }
    public static List getCheckTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("CheckTypeoptions")) {
            prepareCheckType(userInfo);
        }
        return (List)dictionary.get("CheckTypeoptions");
    }
    public static Map getCheckTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("CheckTypemap")) {
            prepareCheckType(userInfo);
        }
        return (Map)dictionary.get("CheckTypemap");
    }
    public static List getCheckTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map CheckTypemap = getCheckTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((CheckTypemap.get(arr[i]) != null) ? (String)CheckTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getNoticeNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getNoticeNameOptions(userInfo), defval);
    }
    public static List getNoticeNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".NoticeNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareNoticeName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getNoticeNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".NoticeNamemap";
        if (!dictionary.containsKey(name)) {
            prepareNoticeName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getNoticeNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map NoticeNamemap = getNoticeNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((NoticeNamemap.get(arr[i]) != null) ? (String)NoticeNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareDeclarerRoleType(UserInfo userInfo) {
        if (dictionary.containsKey("DeclarerRoleTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","0"};
        String[] val = {"学院申报","个人申报"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("DeclarerRoleTypemap", map);
        dictionary.put("DeclarerRoleTypeoptions", options);
    }
    public static List getDeclarerRoleTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getDeclarerRoleTypeOptions(userInfo), defval);
    }
    public static List getDeclarerRoleTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("DeclarerRoleTypeoptions")) {
            prepareDeclarerRoleType(userInfo);
        }
        return (List)dictionary.get("DeclarerRoleTypeoptions");
    }
    public static Map getDeclarerRoleTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("DeclarerRoleTypemap")) {
            prepareDeclarerRoleType(userInfo);
        }
        return (Map)dictionary.get("DeclarerRoleTypemap");
    }
    public static List getDeclarerRoleTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map DeclarerRoleTypemap = getDeclarerRoleTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((DeclarerRoleTypemap.get(arr[i]) != null) ? (String)DeclarerRoleTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getClubNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getClubNameOptions(userInfo), defval);
    }
    public static List getClubNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareClubName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getClubNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubNamemap";
        if (!dictionary.containsKey(name)) {
            prepareClubName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getClubNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ClubNamemap = getClubNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ClubNamemap.get(arr[i]) != null) ? (String)ClubNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareMemberDuty(UserInfo userInfo) {
        if (dictionary.containsKey("MemberDutyoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3"};
        String[] val = {"会长","团支书","财务负责人","其他"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("MemberDutymap", map);
        dictionary.put("MemberDutyoptions", options);
    }
    public static List getMemberDutyOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMemberDutyOptions(userInfo), defval);
    }
    public static List getMemberDutyOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("MemberDutyoptions")) {
            prepareMemberDuty(userInfo);
        }
        return (List)dictionary.get("MemberDutyoptions");
    }
    public static Map getMemberDutyMap(UserInfo userInfo) {
        if (!dictionary.containsKey("MemberDutymap")) {
            prepareMemberDuty(userInfo);
        }
        return (Map)dictionary.get("MemberDutymap");
    }
    public static List getMemberDutyLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MemberDutymap = getMemberDutyMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MemberDutymap.get(arr[i]) != null) ? (String)MemberDutymap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareCkProjectType(UserInfo userInfo) {
        if (dictionary.containsKey("CkProjectTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"创新类","创业类"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("CkProjectTypemap", map);
        dictionary.put("CkProjectTypeoptions", options);
    }
    public static List getCkProjectTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getCkProjectTypeOptions(userInfo), defval);
    }
    public static List getCkProjectTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectTypeoptions")) {
            prepareCkProjectType(userInfo);
        }
        return (List)dictionary.get("CkProjectTypeoptions");
    }
    public static Map getCkProjectTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectTypemap")) {
            prepareCkProjectType(userInfo);
        }
        return (Map)dictionary.get("CkProjectTypemap");
    }
    public static List getCkProjectTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map CkProjectTypemap = getCkProjectTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((CkProjectTypemap.get(arr[i]) != null) ? (String)CkProjectTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareAssLevel(UserInfo userInfo) {
        if (dictionary.containsKey("AssLeveloptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","0","0","0"};
        String[] val = {"A","B","C","D"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("AssLevelmap", map);
        dictionary.put("AssLeveloptions", options);
    }
    public static List getAssLevelOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAssLevelOptions(userInfo), defval);
    }
    public static List getAssLevelOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("AssLeveloptions")) {
            prepareAssLevel(userInfo);
        }
        return (List)dictionary.get("AssLeveloptions");
    }
    public static Map getAssLevelMap(UserInfo userInfo) {
        if (!dictionary.containsKey("AssLevelmap")) {
            prepareAssLevel(userInfo);
        }
        return (Map)dictionary.get("AssLevelmap");
    }
    public static List getAssLevelLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map AssLevelmap = getAssLevelMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((AssLevelmap.get(arr[i]) != null) ? (String)AssLevelmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void preparePracticeReportTeamType(UserInfo userInfo) {
        if (dictionary.containsKey("PracticeReportTeamTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"项目化团队","体验式团队","综合型团队 "};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("PracticeReportTeamTypemap", map);
        dictionary.put("PracticeReportTeamTypeoptions", options);
    }
    public static List getPracticeReportTeamTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getPracticeReportTeamTypeOptions(userInfo), defval);
    }
    public static List getPracticeReportTeamTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("PracticeReportTeamTypeoptions")) {
            preparePracticeReportTeamType(userInfo);
        }
        return (List)dictionary.get("PracticeReportTeamTypeoptions");
    }
    public static Map getPracticeReportTeamTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("PracticeReportTeamTypemap")) {
            preparePracticeReportTeamType(userInfo);
        }
        return (Map)dictionary.get("PracticeReportTeamTypemap");
    }
    public static List getPracticeReportTeamTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map PracticeReportTeamTypemap = getPracticeReportTeamTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((PracticeReportTeamTypemap.get(arr[i]) != null) ? (String)PracticeReportTeamTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getClassesNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getClassesNameOptions(userInfo), defval);
    }
    public static List getClassesNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ClassesNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareClassesName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getClassesNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ClassesNamemap";
        if (!dictionary.containsKey(name)) {
            prepareClassesName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getClassesNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ClassesNamemap = getClassesNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ClassesNamemap.get(arr[i]) != null) ? (String)ClassesNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getClubProjectNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getClubProjectNameOptions(userInfo), defval);
    }
    public static List getClubProjectNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubProjectNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareClubProjectName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getClubProjectNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubProjectNamemap";
        if (!dictionary.containsKey(name)) {
            prepareClubProjectName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getClubProjectNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ClubProjectNamemap = getClubProjectNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ClubProjectNamemap.get(arr[i]) != null) ? (String)ClubProjectNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getMajorNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMajorNameOptions(userInfo), defval);
    }
    public static List getMajorNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".MajorNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareMajorName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getMajorNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".MajorNamemap";
        if (!dictionary.containsKey(name)) {
            prepareMajorName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getMajorNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MajorNamemap = getMajorNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MajorNamemap.get(arr[i]) != null) ? (String)MajorNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getVolunProjectNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getVolunProjectNameOptions(userInfo), defval);
    }
    public static List getVolunProjectNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".VolunProjectNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareVolunProjectName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getVolunProjectNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".VolunProjectNamemap";
        if (!dictionary.containsKey(name)) {
            prepareVolunProjectName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getVolunProjectNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map VolunProjectNamemap = getVolunProjectNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((VolunProjectNamemap.get(arr[i]) != null) ? (String)VolunProjectNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareOrgCityName(UserInfo userInfo) {
        if (dictionary.containsKey("OrgCityNameoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"济南","青岛"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("OrgCityNamemap", map);
        dictionary.put("OrgCityNameoptions", options);
    }
    public static List getOrgCityNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getOrgCityNameOptions(userInfo), defval);
    }
    public static List getOrgCityNameOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("OrgCityNameoptions")) {
            prepareOrgCityName(userInfo);
        }
        return (List)dictionary.get("OrgCityNameoptions");
    }
    public static Map getOrgCityNameMap(UserInfo userInfo) {
        if (!dictionary.containsKey("OrgCityNamemap")) {
            prepareOrgCityName(userInfo);
        }
        return (Map)dictionary.get("OrgCityNamemap");
    }
    public static List getOrgCityNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map OrgCityNamemap = getOrgCityNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((OrgCityNamemap.get(arr[i]) != null) ? (String)OrgCityNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareIdentity(UserInfo userInfo) {
        if (dictionary.containsKey("Identityoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"本科","研究生"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("Identitymap", map);
        dictionary.put("Identityoptions", options);
    }
    public static List getIdentityOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getIdentityOptions(userInfo), defval);
    }
    public static List getIdentityOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("Identityoptions")) {
            prepareIdentity(userInfo);
        }
        return (List)dictionary.get("Identityoptions");
    }
    public static Map getIdentityMap(UserInfo userInfo) {
        if (!dictionary.containsKey("Identitymap")) {
            prepareIdentity(userInfo);
        }
        return (Map)dictionary.get("Identitymap");
    }
    public static List getIdentityLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map Identitymap = getIdentityMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((Identitymap.get(arr[i]) != null) ? (String)Identitymap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareProductionType(UserInfo userInfo) {
        if (dictionary.containsKey("ProductionTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3"};
        String[] val = {"自然科学类学术论文","哲学社会科学类社会调查报告和学术论文","科技发明制作A类","科技发明制作B类"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ProductionTypemap", map);
        dictionary.put("ProductionTypeoptions", options);
    }
    public static List getProductionTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getProductionTypeOptions(userInfo), defval);
    }
    public static List getProductionTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ProductionTypeoptions")) {
            prepareProductionType(userInfo);
        }
        return (List)dictionary.get("ProductionTypeoptions");
    }
    public static Map getProductionTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ProductionTypemap")) {
            prepareProductionType(userInfo);
        }
        return (Map)dictionary.get("ProductionTypemap");
    }
    public static List getProductionTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ProductionTypemap = getProductionTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ProductionTypemap.get(arr[i]) != null) ? (String)ProductionTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareAudit(UserInfo userInfo) {
        if (dictionary.containsKey("Auditoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"正在审核","<font color=red>审核通过</font>","审核未通过"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("Auditmap", map);
        dictionary.put("Auditoptions", options);
    }
    public static List getAuditOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAuditOptions(userInfo), defval);
    }
    public static List getAuditOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("Auditoptions")) {
            prepareAudit(userInfo);
        }
        return (List)dictionary.get("Auditoptions");
    }
    public static Map getAuditMap(UserInfo userInfo) {
        if (!dictionary.containsKey("Auditmap")) {
            prepareAudit(userInfo);
        }
        return (Map)dictionary.get("Auditmap");
    }
    public static List getAuditLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map Auditmap = getAuditMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((Auditmap.get(arr[i]) != null) ? (String)Auditmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getClubTypeNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getClubTypeNameOptions(userInfo), defval);
    }
    public static List getClubTypeNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubTypeNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareClubTypeName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getClubTypeNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ClubTypeNamemap";
        if (!dictionary.containsKey(name)) {
            prepareClubTypeName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getClubTypeNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ClubTypeNamemap = getClubTypeNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ClubTypeNamemap.get(arr[i]) != null) ? (String)ClubTypeNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void preparePoliticsName(UserInfo userInfo) {
        if (dictionary.containsKey("PoliticsNameoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"01","02","03","04","05","06","07","08","09","10","11","12","13"};
        String[] val = {"中共党员","中共预备党员","中国共产主义青年团团员","民革会员","民盟盟员","民建会员","民进会员","农工党党员","致公党党员","九三学社社员","台湾民主自治同盟盟员","无党派民主人士","群众"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("PoliticsNamemap", map);
        dictionary.put("PoliticsNameoptions", options);
    }
    public static List getPoliticsNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getPoliticsNameOptions(userInfo), defval);
    }
    public static List getPoliticsNameOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("PoliticsNameoptions")) {
            preparePoliticsName(userInfo);
        }
        return (List)dictionary.get("PoliticsNameoptions");
    }
    public static Map getPoliticsNameMap(UserInfo userInfo) {
        if (!dictionary.containsKey("PoliticsNamemap")) {
            preparePoliticsName(userInfo);
        }
        return (Map)dictionary.get("PoliticsNamemap");
    }
    public static List getPoliticsNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map PoliticsNamemap = getPoliticsNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((PoliticsNamemap.get(arr[i]) != null) ? (String)PoliticsNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareApplicationRangeType(UserInfo userInfo) {
        if (dictionary.containsKey("ApplicationRangeTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"学院","校区"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ApplicationRangeTypemap", map);
        dictionary.put("ApplicationRangeTypeoptions", options);
    }
    public static List getApplicationRangeTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getApplicationRangeTypeOptions(userInfo), defval);
    }
    public static List getApplicationRangeTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ApplicationRangeTypeoptions")) {
            prepareApplicationRangeType(userInfo);
        }
        return (List)dictionary.get("ApplicationRangeTypeoptions");
    }
    public static Map getApplicationRangeTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ApplicationRangeTypemap")) {
            prepareApplicationRangeType(userInfo);
        }
        return (Map)dictionary.get("ApplicationRangeTypemap");
    }
    public static List getApplicationRangeTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ApplicationRangeTypemap = getApplicationRangeTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ApplicationRangeTypemap.get(arr[i]) != null) ? (String)ApplicationRangeTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getInnovationProductionNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getInnovationProductionNameOptions(userInfo), defval);
    }
    public static List getInnovationProductionNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".InnovationProductionNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareInnovationProductionName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getInnovationProductionNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".InnovationProductionNamemap";
        if (!dictionary.containsKey(name)) {
            prepareInnovationProductionName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getInnovationProductionNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map InnovationProductionNamemap = getInnovationProductionNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((InnovationProductionNamemap.get(arr[i]) != null) ? (String)InnovationProductionNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareHonorType(UserInfo userInfo) {
        if (dictionary.containsKey("HonorTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4","5","6","7"};
        String[] val = {"志愿者活动","社会实践项目立项团委荣誉","社会实践项目立项学院荣誉","校园文化活动","志愿竞赛活动荣誉","社会实践-个人申报","社会实践-集体申报","创新竞赛活动荣誉"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("HonorTypemap", map);
        dictionary.put("HonorTypeoptions", options);
    }
    public static List getHonorTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getHonorTypeOptions(userInfo), defval);
    }
    public static List getHonorTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("HonorTypeoptions")) {
            prepareHonorType(userInfo);
        }
        return (List)dictionary.get("HonorTypeoptions");
    }
    public static Map getHonorTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("HonorTypemap")) {
            prepareHonorType(userInfo);
        }
        return (Map)dictionary.get("HonorTypemap");
    }
    public static List getHonorTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map HonorTypemap = getHonorTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((HonorTypemap.get(arr[i]) != null) ? (String)HonorTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareActivityLevel(UserInfo userInfo) {
        if (dictionary.containsKey("ActivityLeveloptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"院级","校级"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ActivityLevelmap", map);
        dictionary.put("ActivityLeveloptions", options);
    }
    public static List getActivityLevelOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getActivityLevelOptions(userInfo), defval);
    }
    public static List getActivityLevelOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ActivityLeveloptions")) {
            prepareActivityLevel(userInfo);
        }
        return (List)dictionary.get("ActivityLeveloptions");
    }
    public static Map getActivityLevelMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ActivityLevelmap")) {
            prepareActivityLevel(userInfo);
        }
        return (Map)dictionary.get("ActivityLevelmap");
    }
    public static List getActivityLevelLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ActivityLevelmap = getActivityLevelMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ActivityLevelmap.get(arr[i]) != null) ? (String)ActivityLevelmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareZkProjectType(UserInfo userInfo) {
        if (dictionary.containsKey("ZkProjectTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4","5","6","7","8"};
        String[] val = {"阳光助残","关爱农民工子女","邻里守望与为老服务","环境保护与节水护水","扶贫开发与应急救援","文化宣传与网络文明","禁毒教育与法律服务","理论研究与基础建设","其他领域"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("ZkProjectTypemap", map);
        dictionary.put("ZkProjectTypeoptions", options);
    }
    public static List getZkProjectTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getZkProjectTypeOptions(userInfo), defval);
    }
    public static List getZkProjectTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("ZkProjectTypeoptions")) {
            prepareZkProjectType(userInfo);
        }
        return (List)dictionary.get("ZkProjectTypeoptions");
    }
    public static Map getZkProjectTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("ZkProjectTypemap")) {
            prepareZkProjectType(userInfo);
        }
        return (Map)dictionary.get("ZkProjectTypemap");
    }
    public static List getZkProjectTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ZkProjectTypemap = getZkProjectTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ZkProjectTypemap.get(arr[i]) != null) ? (String)ZkProjectTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareCkProjectGroup(UserInfo userInfo) {
        if (dictionary.containsKey("CkProjectGroupoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4","5","6","7","8","9"};
        String[] val = {"制造业","信息技术服务","商务服务","公共服务","公益创业","现代农业","节能环保","新材料","生物医药","互联网项目"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("CkProjectGroupmap", map);
        dictionary.put("CkProjectGroupoptions", options);
    }
    public static List getCkProjectGroupOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getCkProjectGroupOptions(userInfo), defval);
    }
    public static List getCkProjectGroupOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectGroupoptions")) {
            prepareCkProjectGroup(userInfo);
        }
        return (List)dictionary.get("CkProjectGroupoptions");
    }
    public static Map getCkProjectGroupMap(UserInfo userInfo) {
        if (!dictionary.containsKey("CkProjectGroupmap")) {
            prepareCkProjectGroup(userInfo);
        }
        return (Map)dictionary.get("CkProjectGroupmap");
    }
    public static List getCkProjectGroupLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map CkProjectGroupmap = getCkProjectGroupMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((CkProjectGroupmap.get(arr[i]) != null) ? (String)CkProjectGroupmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getMoudleNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMoudleNameOptions(userInfo), defval);
    }
    public static List getMoudleNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".MoudleNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareMoudleName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getMoudleNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".MoudleNamemap";
        if (!dictionary.containsKey(name)) {
            prepareMoudleName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getMoudleNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MoudleNamemap = getMoudleNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MoudleNamemap.get(arr[i]) != null) ? (String)MoudleNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getOrgNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getOrgNameOptions(userInfo), defval);
    }
    public static List getOrgNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".OrgNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareOrgName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getOrgNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".OrgNamemap";
        if (!dictionary.containsKey(name)) {
            prepareOrgName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getOrgNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map OrgNamemap = getOrgNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((OrgNamemap.get(arr[i]) != null) ? (String)OrgNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getVolunActivityNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getVolunActivityNameOptions(userInfo), defval);
    }
    public static List getVolunActivityNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".VolunActivityNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareVolunActivityName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getVolunActivityNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".VolunActivityNamemap";
        if (!dictionary.containsKey(name)) {
            prepareVolunActivityName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getVolunActivityNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map VolunActivityNamemap = getVolunActivityNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((VolunActivityNamemap.get(arr[i]) != null) ? (String)VolunActivityNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareUnionType(UserInfo userInfo) {
        if (dictionary.containsKey("UnionTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"1","2","3","4"};
        String[] val = {"校学生会","校研究生会","院学生会","院研究生会"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("UnionTypemap", map);
        dictionary.put("UnionTypeoptions", options);
    }
    public static List getUnionTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getUnionTypeOptions(userInfo), defval);
    }
    public static List getUnionTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("UnionTypeoptions")) {
            prepareUnionType(userInfo);
        }
        return (List)dictionary.get("UnionTypeoptions");
    }
    public static Map getUnionTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("UnionTypemap")) {
            prepareUnionType(userInfo);
        }
        return (Map)dictionary.get("UnionTypemap");
    }
    public static List getUnionTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map UnionTypemap = getUnionTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((UnionTypemap.get(arr[i]) != null) ? (String)UnionTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void preparePracticeReportProjectType(UserInfo userInfo) {
        if (dictionary.containsKey("PracticeReportProjectTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"重点立项 ","一般立项  ","自筹经费立项 "};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("PracticeReportProjectTypemap", map);
        dictionary.put("PracticeReportProjectTypeoptions", options);
    }
    public static List getPracticeReportProjectTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getPracticeReportProjectTypeOptions(userInfo), defval);
    }
    public static List getPracticeReportProjectTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("PracticeReportProjectTypeoptions")) {
            preparePracticeReportProjectType(userInfo);
        }
        return (List)dictionary.get("PracticeReportProjectTypeoptions");
    }
    public static Map getPracticeReportProjectTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("PracticeReportProjectTypemap")) {
            preparePracticeReportProjectType(userInfo);
        }
        return (Map)dictionary.get("PracticeReportProjectTypemap");
    }
    public static List getPracticeReportProjectTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map PracticeReportProjectTypemap = getPracticeReportProjectTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((PracticeReportProjectTypemap.get(arr[i]) != null) ? (String)PracticeReportProjectTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getProductionNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getProductionNameOptions(userInfo), defval);
    }
    public static List getProductionNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ProductionNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareProductionName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getProductionNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ProductionNamemap";
        if (!dictionary.containsKey(name)) {
            prepareProductionName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getProductionNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ProductionNamemap = getProductionNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ProductionNamemap.get(arr[i]) != null) ? (String)ProductionNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareAttachType(UserInfo userInfo) {
        if (dictionary.containsKey("AttachTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14"};
        String[] val = {"学生社团附件","公告附件","志愿活动附件","社团校外活动会长（带队队长）承诺书、社团校外活动校外活动安全指导书","社团校外活动校外活动安全监督书","五四评比表彰","团支部达标升级文件通知","团支部达标升级文件上报","团校培训管理","团校培训作业","团校培训结题","团建课题","团建课题资料","社会实践结题书表-集体申请","社会实践结题书表-个人申请"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("AttachTypemap", map);
        dictionary.put("AttachTypeoptions", options);
    }
    public static List getAttachTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAttachTypeOptions(userInfo), defval);
    }
    public static List getAttachTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("AttachTypeoptions")) {
            prepareAttachType(userInfo);
        }
        return (List)dictionary.get("AttachTypeoptions");
    }
    public static Map getAttachTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("AttachTypemap")) {
            prepareAttachType(userInfo);
        }
        return (Map)dictionary.get("AttachTypemap");
    }
    public static List getAttachTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map AttachTypemap = getAttachTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((AttachTypemap.get(arr[i]) != null) ? (String)AttachTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getAcademyNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAcademyNameOptions(userInfo), defval);
    }
    public static List getAcademyNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".AcademyNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareAcademyName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getAcademyNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".AcademyNamemap";
        if (!dictionary.containsKey(name)) {
            prepareAcademyName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getAcademyNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map AcademyNamemap = getAcademyNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((AcademyNamemap.get(arr[i]) != null) ? (String)AcademyNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareTotalRounds(UserInfo userInfo) {
        if (dictionary.containsKey("TotalRoundsoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"一","二","三"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("TotalRoundsmap", map);
        dictionary.put("TotalRoundsoptions", options);
    }
    public static List getTotalRoundsOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getTotalRoundsOptions(userInfo), defval);
    }
    public static List getTotalRoundsOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("TotalRoundsoptions")) {
            prepareTotalRounds(userInfo);
        }
        return (List)dictionary.get("TotalRoundsoptions");
    }
    public static Map getTotalRoundsMap(UserInfo userInfo) {
        if (!dictionary.containsKey("TotalRoundsmap")) {
            prepareTotalRounds(userInfo);
        }
        return (Map)dictionary.get("TotalRoundsmap");
    }
    public static List getTotalRoundsLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map TotalRoundsmap = getTotalRoundsMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((TotalRoundsmap.get(arr[i]) != null) ? (String)TotalRoundsmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareAcademyType(UserInfo userInfo) {
        if (dictionary.containsKey("AcademyTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"1","2","3"};
        String[] val = {"学院 ","职能部门 ","附属单位 "};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("AcademyTypemap", map);
        dictionary.put("AcademyTypeoptions", options);
    }
    public static List getAcademyTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getAcademyTypeOptions(userInfo), defval);
    }
    public static List getAcademyTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("AcademyTypeoptions")) {
            prepareAcademyType(userInfo);
        }
        return (List)dictionary.get("AcademyTypeoptions");
    }
    public static Map getAcademyTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("AcademyTypemap")) {
            prepareAcademyType(userInfo);
        }
        return (Map)dictionary.get("AcademyTypemap");
    }
    public static List getAcademyTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map AcademyTypemap = getAcademyTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((AcademyTypemap.get(arr[i]) != null) ? (String)AcademyTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareBelongId(UserInfo userInfo) {
        if (dictionary.containsKey("BelongIdoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0"};
        String[] val = {"社团创建"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("BelongIdmap", map);
        dictionary.put("BelongIdoptions", options);
    }
    public static List getBelongIdOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getBelongIdOptions(userInfo), defval);
    }
    public static List getBelongIdOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("BelongIdoptions")) {
            prepareBelongId(userInfo);
        }
        return (List)dictionary.get("BelongIdoptions");
    }
    public static Map getBelongIdMap(UserInfo userInfo) {
        if (!dictionary.containsKey("BelongIdmap")) {
            prepareBelongId(userInfo);
        }
        return (Map)dictionary.get("BelongIdmap");
    }
    public static List getBelongIdLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map BelongIdmap = getBelongIdMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((BelongIdmap.get(arr[i]) != null) ? (String)BelongIdmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getActivitykindTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getActivitykindTypeOptions(userInfo), defval);
    }
    public static List getActivitykindTypeOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".ActivitykindTypeoptions";
        if (!dictionary.containsKey(name)) {
            prepareActivitykindType(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getActivitykindTypeMap(UserInfo userInfo) {
        String name = "tuanwei" + ".ActivitykindTypemap";
        if (!dictionary.containsKey(name)) {
            prepareActivitykindType(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getActivitykindTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map ActivitykindTypemap = getActivitykindTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((ActivitykindTypemap.get(arr[i]) != null) ? (String)ActivitykindTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareCancleCheckFlag(UserInfo userInfo) {
        if (dictionary.containsKey("CancleCheckFlagoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"申请","审核通过","审核未通过"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("CancleCheckFlagmap", map);
        dictionary.put("CancleCheckFlagoptions", options);
    }
    public static List getCancleCheckFlagOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getCancleCheckFlagOptions(userInfo), defval);
    }
    public static List getCancleCheckFlagOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("CancleCheckFlagoptions")) {
            prepareCancleCheckFlag(userInfo);
        }
        return (List)dictionary.get("CancleCheckFlagoptions");
    }
    public static Map getCancleCheckFlagMap(UserInfo userInfo) {
        if (!dictionary.containsKey("CancleCheckFlagmap")) {
            prepareCancleCheckFlag(userInfo);
        }
        return (Map)dictionary.get("CancleCheckFlagmap");
    }
    public static List getCancleCheckFlagLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map CancleCheckFlagmap = getCancleCheckFlagMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((CancleCheckFlagmap.get(arr[i]) != null) ? (String)CancleCheckFlagmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getNationNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getNationNameOptions(userInfo), defval);
    }
    public static List getNationNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".NationNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareNationName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getNationNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".NationNamemap";
        if (!dictionary.containsKey(name)) {
            prepareNationName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getNationNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map NationNamemap = getNationNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((NationNamemap.get(arr[i]) != null) ? (String)NationNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareMoudleOrFun(UserInfo userInfo) {
        if (dictionary.containsKey("MoudleOrFunoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"模块","功能点"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("MoudleOrFunmap", map);
        dictionary.put("MoudleOrFunoptions", options);
    }
    public static List getMoudleOrFunOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getMoudleOrFunOptions(userInfo), defval);
    }
    public static List getMoudleOrFunOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("MoudleOrFunoptions")) {
            prepareMoudleOrFun(userInfo);
        }
        return (List)dictionary.get("MoudleOrFunoptions");
    }
    public static Map getMoudleOrFunMap(UserInfo userInfo) {
        if (!dictionary.containsKey("MoudleOrFunmap")) {
            prepareMoudleOrFun(userInfo);
        }
        return (Map)dictionary.get("MoudleOrFunmap");
    }
    public static List getMoudleOrFunLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map MoudleOrFunmap = getMoudleOrFunMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((MoudleOrFunmap.get(arr[i]) != null) ? (String)MoudleOrFunmap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareModule(UserInfo userInfo) {
        if (dictionary.containsKey("Moduleoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1"};
        String[] val = {"社团创建","团委立项"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("Modulemap", map);
        dictionary.put("Moduleoptions", options);
    }
    public static List getModuleOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getModuleOptions(userInfo), defval);
    }
    public static List getModuleOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("Moduleoptions")) {
            prepareModule(userInfo);
        }
        return (List)dictionary.get("Moduleoptions");
    }
    public static Map getModuleMap(UserInfo userInfo) {
        if (!dictionary.containsKey("Modulemap")) {
            prepareModule(userInfo);
        }
        return (Map)dictionary.get("Modulemap");
    }
    public static List getModuleLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map Modulemap = getModuleMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((Modulemap.get(arr[i]) != null) ? (String)Modulemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static List getStandardUpGradeNameOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getStandardUpGradeNameOptions(userInfo), defval);
    }
    public static List getStandardUpGradeNameOptions(UserInfo userInfo) {
        String name = "tuanwei" + ".StandardUpGradeNameoptions";
        if (!dictionary.containsKey(name)) {
            prepareStandardUpGradeName(userInfo);
        }
        return (List)dictionary.get(name);
    }
    public static Map getStandardUpGradeNameMap(UserInfo userInfo) {
        String name = "tuanwei" + ".StandardUpGradeNamemap";
        if (!dictionary.containsKey(name)) {
            prepareStandardUpGradeName(userInfo);
        }
        return (Map)dictionary.get(name);
    }
    public static List getStandardUpGradeNameLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map StandardUpGradeNamemap = getStandardUpGradeNameMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((StandardUpGradeNamemap.get(arr[i]) != null) ? (String)StandardUpGradeNamemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareEvaluationType(UserInfo userInfo) {
        if (dictionary.containsKey("EvaluationTypeoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2"};
        String[] val = {"未审核","审核通过","审核未通过"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("EvaluationTypemap", map);
        dictionary.put("EvaluationTypeoptions", options);
    }
    public static List getEvaluationTypeOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getEvaluationTypeOptions(userInfo), defval);
    }
    public static List getEvaluationTypeOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("EvaluationTypeoptions")) {
            prepareEvaluationType(userInfo);
        }
        return (List)dictionary.get("EvaluationTypeoptions");
    }
    public static Map getEvaluationTypeMap(UserInfo userInfo) {
        if (!dictionary.containsKey("EvaluationTypemap")) {
            prepareEvaluationType(userInfo);
        }
        return (Map)dictionary.get("EvaluationTypemap");
    }
    public static List getEvaluationTypeLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map EvaluationTypemap = getEvaluationTypeMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((EvaluationTypemap.get(arr[i]) != null) ? (String)EvaluationTypemap.get(arr[i]) : "");
        }
        return labels;
    }
    public static synchronized void prepareStuDuty(UserInfo userInfo) {
        if (dictionary.containsKey("StuDutyoptions")) {
            return;
        }
        List options = new ArrayList();
        Map map = new HashMap();
        String[] key = {"0","1","2","3","4","5","6","7"};
        String[] val = {"主席","副主席","分管主席","秘书长","副秘书长","部长","副部长","干事"};
        for (int i = 0; i < key.length; i ++) {
            options.add(new OptionBean(val[i], key[i]));
            map.put(key[i], val[i]);
        }
        dictionary.put("StuDutymap", map);
        dictionary.put("StuDutyoptions", options);
    }
    public static List getStuDutyOptions(UserInfo userInfo, String defval) {
        return pushDefaultValue(getStuDutyOptions(userInfo), defval);
    }
    public static List getStuDutyOptions(UserInfo userInfo) {
        if (!dictionary.containsKey("StuDutyoptions")) {
            prepareStuDuty(userInfo);
        }
        return (List)dictionary.get("StuDutyoptions");
    }
    public static Map getStuDutyMap(UserInfo userInfo) {
        if (!dictionary.containsKey("StuDutymap")) {
            prepareStuDuty(userInfo);
        }
        return (Map)dictionary.get("StuDutymap");
    }
    public static List getStuDutyLabels(javax.servlet.http.HttpServletRequest request, String ids) {
        List labels = new ArrayList();
        if (ids.length() == 0) {
            return labels;
        }
        Map StuDutymap = getStuDutyMap(Tool.getUserInfo(request));
        String[] arr = Tool.split(",", ids);
        for (int i = 0; i < arr.length; i ++) {
            labels.add((StuDutymap.get(arr[i]) != null) ? (String)StuDutymap.get(arr[i]) : "");
        }
        return labels;
    }
}
