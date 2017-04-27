//自动生成的程序，请不要修改，下次生成的时候会覆盖
package com.xietong.software.common;
import java.io.*;
import java.util.*;
import com.xietong.software.common.*;
import com.xietong.software.util.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
public class COptionConst {
    private static javax.servlet.ServletContext servletContext = null;
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
    public static List getUserNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getUserNameOptions(userInfo, cdt), defval);
    }
    public static List getUserNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseUserCode v = new com.xietong.software.sdtw.db.BaseUserCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseUserCode item = (com.xietong.software.sdtw.db.BaseUserCode)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getUserCnNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getUserCnNameOptions(userInfo, cdt), defval);
    }
    public static List getUserCnNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseUserCode v = new com.xietong.software.sdtw.db.BaseUserCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseUserCode item = (com.xietong.software.sdtw.db.BaseUserCode)it.next();
            options.add(new OptionBean("" + item.getCnName(), "" + item.getId()));
        }
        return options;
    }
    public static List getAcademyAliasNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getAcademyAliasNameOptions(userInfo, cdt), defval);
    }
    public static List getAcademyAliasNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Academy v = new com.xietong.software.sdtw.db.Academy();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Academy item = (com.xietong.software.sdtw.db.Academy)it.next();
            options.add(new OptionBean("" + item.getAcademyalias(), "" + item.getId()));
        }
        return options;
    }
    public static List getRoleNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getRoleNameOptions(userInfo, cdt), defval);
    }
    public static List getRoleNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseRoleCode v = new com.xietong.software.sdtw.db.BaseRoleCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseRoleCode item = (com.xietong.software.sdtw.db.BaseRoleCode)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getDeptNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getDeptNameOptions(userInfo, cdt), defval);
    }
    public static List getDeptNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseDeptCode v = new com.xietong.software.sdtw.db.BaseDeptCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseDeptCode item = (com.xietong.software.sdtw.db.BaseDeptCode)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getGradeNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getGradeNameOptions(userInfo, cdt), defval);
    }
    public static List getGradeNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Grade v = new com.xietong.software.sdtw.db.Grade();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Grade item = (com.xietong.software.sdtw.db.Grade)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getStuDeptNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getStuDeptNameOptions(userInfo, cdt), defval);
    }
    public static List getStuDeptNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.StudentUnionDept v = new com.xietong.software.sdtw.db.StudentUnionDept();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.StudentUnionDept item = (com.xietong.software.sdtw.db.StudentUnionDept)it.next();
            options.add(new OptionBean("" + item.getDeptName(), "" + item.getId()));
        }
        return options;
    }
    public static List getNoticeNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getNoticeNameOptions(userInfo, cdt), defval);
    }
    public static List getNoticeNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerZhiku v = new com.xietong.software.sdtw.db.VolunteerZhiku();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerZhiku item = (com.xietong.software.sdtw.db.VolunteerZhiku)it.next();
            options.add(new OptionBean("" + item.getNoticeName(), "" + item.getId()));
        }
        return options;
    }
    public static List getClubNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getClubNameOptions(userInfo, cdt), defval);
    }
    public static List getClubNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Club v = new com.xietong.software.sdtw.db.Club();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Club item = (com.xietong.software.sdtw.db.Club)it.next();
            options.add(new OptionBean("" + item.getClubName(), "" + item.getId()));
        }
        return options;
    }
    public static List getClassesNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getClassesNameOptions(userInfo, cdt), defval);
    }
    public static List getClassesNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Classes v = new com.xietong.software.sdtw.db.Classes();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Classes item = (com.xietong.software.sdtw.db.Classes)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getClubProjectNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getClubProjectNameOptions(userInfo, cdt), defval);
    }
    public static List getClubProjectNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.ClubActivityProject v = new com.xietong.software.sdtw.db.ClubActivityProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.ClubActivityProject item = (com.xietong.software.sdtw.db.ClubActivityProject)it.next();
            options.add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
        }
        return options;
    }
    public static List getMajorNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getMajorNameOptions(userInfo, cdt), defval);
    }
    public static List getMajorNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Major v = new com.xietong.software.sdtw.db.Major();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Major item = (com.xietong.software.sdtw.db.Major)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getVolunProjectNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getVolunProjectNameOptions(userInfo, cdt), defval);
    }
    public static List getVolunProjectNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerProject v = new com.xietong.software.sdtw.db.VolunteerProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerProject item = (com.xietong.software.sdtw.db.VolunteerProject)it.next();
            options.add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
        }
        return options;
    }
    public static List getClubTypeNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getClubTypeNameOptions(userInfo, cdt), defval);
    }
    public static List getClubTypeNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.ClubType v = new com.xietong.software.sdtw.db.ClubType();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.ClubType item = (com.xietong.software.sdtw.db.ClubType)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getInnovationProductionNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getInnovationProductionNameOptions(userInfo, cdt), defval);
    }
    public static List getInnovationProductionNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.InnovationCompetition v = new com.xietong.software.sdtw.db.InnovationCompetition();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.InnovationCompetition item = (com.xietong.software.sdtw.db.InnovationCompetition)it.next();
            options.add(new OptionBean("" + item.getProductionName(), "" + item.getId()));
        }
        return options;
    }
    public static List getMoudleNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getMoudleNameOptions(userInfo, cdt), defval);
    }
    public static List getMoudleNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseMoudle v = new com.xietong.software.sdtw.db.BaseMoudle();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseMoudle item = (com.xietong.software.sdtw.db.BaseMoudle)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getOrgNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getOrgNameOptions(userInfo, cdt), defval);
    }
    public static List getOrgNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.BaseOrgCode v = new com.xietong.software.sdtw.db.BaseOrgCode();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.BaseOrgCode item = (com.xietong.software.sdtw.db.BaseOrgCode)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getVolunActivityNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getVolunActivityNameOptions(userInfo, cdt), defval);
    }
    public static List getVolunActivityNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.VolunteerActivity v = new com.xietong.software.sdtw.db.VolunteerActivity();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.VolunteerActivity item = (com.xietong.software.sdtw.db.VolunteerActivity)it.next();
            options.add(new OptionBean("" + item.getActivityname(), "" + item.getId()));
        }
        return options;
    }
    public static List getProductionNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getProductionNameOptions(userInfo, cdt), defval);
    }
    public static List getProductionNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.InnovationCompetitionProject v = new com.xietong.software.sdtw.db.InnovationCompetitionProject();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.InnovationCompetitionProject item = (com.xietong.software.sdtw.db.InnovationCompetitionProject)it.next();
            options.add(new OptionBean("" + item.getProjectName(), "" + item.getId()));
        }
        return options;
    }
    public static List getAcademyNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getAcademyNameOptions(userInfo, cdt), defval);
    }
    public static List getAcademyNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Academy v = new com.xietong.software.sdtw.db.Academy();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Academy item = (com.xietong.software.sdtw.db.Academy)it.next();
            options.add(new OptionBean("" + item.getAcademyName(), "" + item.getId()));
        }
        return options;
    }
    public static List getActivitykindTypeOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getActivitykindTypeOptions(userInfo, cdt), defval);
    }
    public static List getActivitykindTypeOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.CampusActivityKind v = new com.xietong.software.sdtw.db.CampusActivityKind();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.CampusActivityKind item = (com.xietong.software.sdtw.db.CampusActivityKind)it.next();
            options.add(new OptionBean("" + item.getKindName(), "" + item.getId()));
        }
        return options;
    }
    public static List getNationNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getNationNameOptions(userInfo, cdt), defval);
    }
    public static List getNationNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.Nations v = new com.xietong.software.sdtw.db.Nations();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.Nations item = (com.xietong.software.sdtw.db.Nations)it.next();
            options.add(new OptionBean("" + item.getName(), "" + item.getId()));
        }
        return options;
    }
    public static List getStandardUpGradeNameOptions(UserInfo userInfo, String defval, List cdt) {
        return pushDefaultValue(getStandardUpGradeNameOptions(userInfo, cdt), defval);
    }
    public static List getStandardUpGradeNameOptions(UserInfo userInfo, List cdt) {
        List options = new ArrayList();
        com.xietong.software.sdtw.db.StandardupGrade v = new com.xietong.software.sdtw.db.StandardupGrade();
        List vs = v.query(cdt);
        for (Iterator it = vs.iterator(); it.hasNext();) {
            com.xietong.software.sdtw.db.StandardupGrade item = (com.xietong.software.sdtw.db.StandardupGrade)it.next();
            options.add(new OptionBean("" + item.getStandardUpGradeName(), "" + item.getId()));
        }
        return options;
    }
}
