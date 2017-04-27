package com.xietong.software.sdtw.rzd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.sql.Connection;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.common.CEditConst;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.db.Honor;
import com.xietong.software.sdtw.db.StudentRzd;
import com.xietong.software.sdtw.db.StudentRzdState;
import com.xietong.software.system.DbConnectionManager;
import com.xietong.software.util.OptionBean;

public class StudentRzdUtil {
	
	public Map<Integer,String> rzdTypeMap=new HashMap<Integer,String>(){
		{ 
			put(1, "主题教育"); 
			put(2, "文化艺术"); 
			put(3, "体育健康"); 
			put(4, "科技创新"); 
			put(5, "社会实践"); 
			put(6, "志愿服务"); 
			put(7, "社会工作"); 
			put(8, "社团经历"); 
			put(9, "就业创业"); 
			put(10, "学术讲座"); 
		};
	};

	
	/**
	 * 提取各个表中的信息更新StudentRzd表
	 * @param userInfo
	 * @return
	 */
	public int updateStudentRzd(UserInfo userInfo){
		int stuid=userInfo.getId();//学生id
		int deptid=userInfo.getDeptId();//学生所在学院的deptid
		String stuNo=userInfo.getName();//学生学号
		
		Map academyMap=CEditConst.getAcademyNameMap(userInfo);//学院Map
		Map unionDutyMap=CEditConst.getStuDutyMap(userInfo);//学生会职务Map
		Map gradeMap=CEditConst.getGradeNameMap(userInfo);//年级Map
		Map memberDutyMap=CEditConst.getMemberDutyMap(userInfo);//社团职务map
		Map honorMap=getHonorMap();//荣誉map
		
		Connection con = null;
 		Statement stmt = null;
 		ResultSet rs = null;
 		int ret=0;
		try {
			con = DbConnectionManager.getConnection("jdbc/ds");
			stmt=con.createStatement();
			
			//一、1主题教育，2文化艺术，3体育健康，4科技创新，9就业创业，10学术讲座
			String sql1="SELECT * FROM campus_activity,campus_participate WHERE campus_activity.id=campus_participate.campusactivityid AND campus_participate.studentNo='"+stuNo+"' AND campus_participate.checkflag=1";
			rs=stmt.executeQuery(sql1);
			while(rs.next()){
				String activitykindtype=rs.getString("activitykindtype");
				int type=0;
				if("1".equals(activitykindtype)){
					type=1;
				}else if("2".equals(activitykindtype)){
					type=2;
				}else if("3".equals(activitykindtype)){
					type=3;
				}else if("4".equals(activitykindtype)){
					type=10;
				}else if("5".equals(activitykindtype)){
					type=4;
				}else if("6".equals(activitykindtype)){
					type=9;
				}
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("campus_participate.id");//参与的id
				v.setValue1(rs.getString("acticityname"));
				v.setValue2((String)academyMap.get(rs.getString("orgacademy")));
				v.setValue3(rs.getString("activitydate1").substring(0, 7).replace("-", "."));
				String honor=rs.getString("honor");
				String honorStr="参与";
				try{
					if(honor!=null||honor!="") 
						honorStr=(String) honorMap.get(Integer.parseInt(honor));
				}catch(Exception x){
					honorStr="参与";
				}
				v.setValue4(honorStr);
				
				//添加其它标志
				v.setType(type);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type="+type);
				cdt.add("activityid="+participateid);
				if(((List)sr.query(cdt)).size()<1){
					v.insert();
				}
				
			}
			
			
			//二、5社会实践
			rs=null;
			String sql2="SELECT * FROM Practice_Report,Practice_Declare_Teammember WHERE practice_report.id=practice_declare_teammember.reportid AND twcheckflag=1 AND practice_declare_teammember.sname='"+stuid+"'";
			rs=stmt.executeQuery(sql2);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("practice_report.id");
				String academy=rs.getString("practice_report.academy");
				String honorFlag=rs.getString("honor");
				String honor=(String)honorMap.get(honorFlag)==null?"参与":(String)honorMap.get(honorFlag);
				
				v.setValue1(rs.getString("report3"));
				v.setValue2((String)academyMap.get(academy)==null?"校团委":(String)academyMap.get(academy));
				v.setValue3(rs.getString("starttime").substring(0, 7).replace("-", "."));
				v.setValue4(honor);//
				
				//添加其它标志
				v.setType(5);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=5");
				cdt.add("activityid="+participateid);
				if(((List)sr.query(cdt)).size()<1){
					v.insert();
				}
			}
			
			//三、6志愿服务——志愿活动
			/***
			 * student_rzd.acativityid取值
			 * 志愿活动:1_volunteer_participate.id
			 * 志愿竞赛:2_volunteer_project_participate.id
			 * 山大志库:3_volunteer_zhiku_participate.id
			 */
			rs=null;
			String sql41="SELECT * FROM volunteer_activity,volunteer_participate WHERE volunteer_activity.id=volunteer_participate.activityid AND volunteer_participate.sno='"+stuNo+"' AND volunteer_participate.checkflag=1";
			rs=stmt.executeQuery(sql41);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("volunteer_participate.id");//参与的id
				v.setValue1(rs.getString("activityname"));
				
				String academyid=rs.getString("launchacademy");
				String value2="校团委";
				if(!"-1".equals(academyid)) 
					value2=(String)academyMap.get(academyid);
				v.setValue2(value2);
				v.setValue3(rs.getString("starttime").substring(0, 7).replace("-", ".")+rs.getString("endtime").substring(0, 7).replace("-", "."));
				String honor=rs.getString("honourname");
				String honorStr="参与";
				try{
					if(honor!="") 
						honorStr=(String) honorMap.get(Integer.parseInt(honor));
				}catch(Exception x){
					honorStr="参与";
				}
				v.setValue4(honorStr);
				
				//添加其它标志
				v.setType(6);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=6");
				cdt.add("activityid="+participateid);
				if(((List)sr.query(cdt)).size()<1){
					v.insert();
				}
			}
			//三、6志愿服务——山大志库
			rs=null;
			String sql42="SELECT * FROM volunteer_zhiku_declare,volunteer_zhiku_teammember WHERE volunteer_zhiku_declare.id=volunteer_zhiku_teammember.zhikudeclareid AND volunteer_zhiku_declare.checkflag=1 AND volunteer_zhiku_teammember.name='"+stuid+"'";
			rs=stmt.executeQuery(sql42);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("volunteer_zhiku_declare.id");//参与的id
				v.setValue1(rs.getString("volunteer_zhiku_declare.name"));
				
				String academyid=rs.getString("launchacademy");
				String value2="校团委";
				if(!"-1".equals(academyid)) 
					value2=(String)academyMap.get(academyid);
				if(value2==null) value2=rs.getString("volunteer_zhiku_declare.unit");
				v.setValue2(value2);
				v.setValue3(rs.getString("volunteer_zhiku_declare.addtime").substring(0, 7).replace("-", "."));
				String honor=rs.getString("volunteer_zhiku_teammember.duty");
				if("".equals(honor)) honor="参与"; 
				v.setValue4(honor);
				
				//添加其它标志
				v.setType(6);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=6");
				cdt.add("activityid="+participateid);
				if(((List)sr.query(cdt)).size()<1){
					v.insert();
				}
			}
			
			//四、7社会工作——学生会工作
			rs=null;
			String sql31="SELECT * FROM studentunionmember,studentunion,studentuniondept WHERE (studentunionmember.deptid=studentuniondept.id OR studentunionmember.deptid=-1) AND studentunionmember.unionid=studentunion.id  AND sno='"+stuNo+"'";
			rs=stmt.executeQuery(sql31);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("studentunionmember.id");//参与的id
				String academy=rs.getString("academy");
				if("".equals(academy)||academy==null){//校学生会
					if("-1".equals(rs.getString("deptid"))){
						v.setValue1("校学生会");//1.校学生会主席团
					}else{
						v.setValue1("校学生会"+rs.getString("deptname"));//2.校学生会部门
					}
				}else{
					if("-1".equals(rs.getString("deptid"))){
						v.setValue1((String)academyMap.get(academy)+"学生会");//3.学院学生会主席团	
					}else{
						v.setValue1((String)academyMap.get(academy)+rs.getString("deptname"));//4.学院学生会部门
					}
				}
				v.setValue2((String)academyMap.get(academy)==null?"校团委":(String)academyMap.get(academy));
				v.setValue3(((String)gradeMap.get(rs.getString("schoolyear"))).replace("级","")+".09");
				v.setValue4((String)unionDutyMap.get(rs.getString("duty")));
				
				//添加其它标志
				v.setType(7);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=7");
				cdt.add("activityid="+participateid);
				ret=0;
				if(((List)sr.query(cdt)).size()<1){
					ret=v.insert();
				}
			}
			//四、7社会工作——班级工作
			rs=null;
			String sql32="SELECT classes.name,classes.academy,schoolyear,duty FROM studentclassduty,classes WHERE studentclassduty.classname=classes.id AND sno='"+stuNo+"'";
			rs=stmt.executeQuery(sql32);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("studentclassduty.id");//参与的id
				String academy=rs.getString("classes.academy");
				String dutyFlag=rs.getString("duty");
				String duty="班委";
				if("0".equals(dutyFlag)) duty="班长";
				else if("1".equals(dutyFlag)) duty="团支书";
				else duty="班委";
				v.setValue1(rs.getString("studentclassduty.name"));
				v.setValue2((String)academyMap.get(academy)==null?"校团委":(String)academyMap.get(academy));
				v.setValue3(((String)gradeMap.get(rs.getString("schoolyear"))).replace("级","")+".09");
				v.setValue4(duty);
				
				//添加其它标志
				v.setType(7);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=7");
				cdt.add("activityid="+participateid);
				ret=0;
				if(((List)sr.query(cdt)).size()<1){
					ret=v.insert();
				}
			}
			
			
			//五、8社团经历
			rs=null;
			String sql5="SELECT * FROM club,club_members WHERE club.id=club_members.memberClubname AND club_members.memberName='"+stuid+"'";
			rs=stmt.executeQuery(sql5);
			while(rs.next()){
				StudentRzd v=new StudentRzd();
				int participateid=rs.getInt("club_members.id");//参与的id
				v.setValue1(rs.getString("clubname"));
				v.setValue2((String)academyMap.get(rs.getString("academy")));
				v.setValue3(rs.getString("addtime").substring(0, 7).replace("-", "."));
				String duty=rs.getString("memberduty");
				String dutyStr="成员";
				if(duty!=""){
					dutyStr=(String)memberDutyMap.get(duty);
				}
				v.setValue4(dutyStr);
				
				//添加其它标志
				v.setType(8);
				v.setActivityId(participateid);
				v.setStuid(stuid);
				v.setDeptid(""+deptid);
				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
				v.setCheckflag(SdtwConst.RZDCHECK_TG);
				//存储前判断是否已存过,通过参与表中的id和rzd的type
				List cdt=new ArrayList();
				StudentRzd sr=new StudentRzd();
				cdt.add("stuid="+stuid);
				cdt.add("type=8");
				cdt.add("activityid="+participateid);
				if(((List)sr.query(cdt)).size()<1){
					v.insert();
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rs != null) {
			    try { rs.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
			if (stmt != null) {
			    try {stmt.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
			if (con != null) {
			    try { con.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
	    }
		return 1;
	}
	
	/***
	 * 获得某学生在系统中提取出的全部rzd条目	
	 * @param stuid
	 * @return
	 */
	public Map<Integer, List<StudentRzd>> getAllRzdByType2(UserInfo userInfo){
		int stuid=userInfo.getId();//学生id
		int deptid=userInfo.getDeptId();//学生所在学院的deptid
		String stuNo=userInfo.getUserCode().getName();//学生学号
		Map academyMap=CEditConst.getAcademyNameMap(userInfo);//学院Map
		Map unionDutyMap=CEditConst.getStuDutyMap(userInfo);//学生会职务Map
		Map gradeMap=CEditConst.getGradeNameMap(userInfo);//年级Map
		Map memberDutyMap=CEditConst.getMemberDutyMap(userInfo);//社团职务map
		Map honorMap=getHonorMap();//荣誉map
		Map<Integer,List<StudentRzd>> map=new HashMap<Integer,List<StudentRzd>>();
		Connection con = null;
 		Statement stmt = null;
 		ResultSet rs = null;
		try {
			con =(Connection) DbConnectionManager.getConnection("jdbc/ds");
			stmt=con.createStatement();
			
			//一、1主题教育，2文化艺术，3体育健康，4科技创新，9就业创业，10学术讲座
//			String sql1="SELECT * FROM campus_activity,campus_participate WHERE campus_activity.id=campus_participate.campusactivityid AND campus_participate.studentNo='"+stuNo+"' AND campus_participate.checkflag=1";
//			rs=stmt.executeQuery(sql1);
//			while(rs.next()){
//				String activitykindtype=rs.getString("activitykindtype");
//				int type=0;
//				if("1".equals(activitykindtype)){
//					type=1;
//				}else if("2".equals(activitykindtype)){
//					type=2;
//				}else if("3".equals(activitykindtype)){
//					type=3;
//				}else if("4".equals(activitykindtype)){
//					type=10;
//				}else if("5".equals(activitykindtype)){
//					type=4;
//				}else if("6".equals(activitykindtype)){
//					type=9;
//				}
//				StudentRzd v=new StudentRzd();
//				v.setValue1(rs.getString("acticityname"));
//				v.setValue2((String)academyMap.get(rs.getString("orgacademy")));
//				v.setValue3(rs.getString("activitydate1").substring(0, 7).replace("-", "."));
//				String honor=rs.getString("honor");
//				String honorStr="参与";
//				try{
//					if(honor!=null||honor!="") 
//						honorStr=(String) honorMap.get(Integer.parseInt(honor));
//				}catch(Exception x){
//					honorStr="参与";
//				}
//				v.setValue4(honorStr);//存的是标志
//				
//				List mlist=new ArrayList();
//				if(map.get(type)==null){
//					mlist.add(v);
//					map.put(type, mlist);
//				}else{
//					mlist=map.get(type);
//					mlist.add(v);
//					map.put(type, mlist);
//				}
//			}
			
			
			//二、5社会实践
//			rs=null;
//			String sql2="SELECT * FROM campus_activity,campus_participate WHERE campus_activity.id=campus_participate.campusactivityid AND campus_participate.studentNo='"+stuNo+"' AND campus_participate.checkflag=1";
//			rs=stmt.executeQuery(sql2);
//			while(rs.next()){
//				StudentRzd v=new StudentRzd();
//				v.setValue1(rs.getString(""));
//				v.setValue2(rs.getString(""));
//				v.setValue3(rs.getString("").substring(0, 7).replace("-", "."));
//				v.setValue4(rs.getString(""));//
//				
//				List mlist=new ArrayList();
//				if(map.get(5)==null){
//					mlist.add(v);
//					map.put(5, mlist);
//				}else{
//					mlist=map.get(5);
//					mlist.add(v);
//					map.put(5, mlist);
//				}
//			}
			
			//三、6志愿服务
//			rs=null;
//			String sql4="SELECT * FROM campus_activity,campus_participate WHERE campus_activity.id=campus_participate.campusactivityid AND campus_participate.studentNo='"+stuNo+"' AND campus_participate.checkflag=1";
//			rs=stmt.executeQuery(sql4);
//			while(rs.next()){
//				StudentRzd v=new StudentRzd();
//				v.setValue1(rs.getString(""));
//				v.setValue2(rs.getString(""));
//				v.setValue3(rs.getString("").substring(0, 7).replace("-", "."));
//				v.setValue4(rs.getString(""));//
//				
//				List mlist=new ArrayList();
//				if(map.get(6)==null){
//					mlist.add(v);
//					map.put(6, mlist);
//				}else{
//					mlist=map.get(6);
//					mlist.add(v);
//					map.put(6, mlist);
//				}
//			}
			
			//四、7社会工作
//			rs=null;
//			String sql3="SELECT * FROM studentunionmember,studentunion,studentuniondept WHERE (studentunionmember.deptid=studentuniondept.id OR studentunionmember.deptid=-1) AND studentunionmember.unionid=studentunion.id  AND sno='"+stuNo+"'";
//			rs=stmt.executeQuery(sql3);
//			while(rs.next()){
//				StudentRzd v=new StudentRzd();
//				String academy=rs.getString("academy");
//				if("".equals(academy)||academy==null){
//					if("-1".equals(rs.getString("deptid"))){
//						v.setValue1(rs.getString("校学生会"));
//					}else{
//						v.setValue1("校学生会"+rs.getString("deptname"));
//					}
//				}else{
//					v.setValue1((String)academyMap.get("academy")+rs.getString("deptname"));
//				}
//				v.setValue2((String)academyMap.get(rs.getString("academy"))==null?"校团委":(String)academyMap.get(rs.getString("academy")));
//				v.setValue3((String)gradeMap.get(rs.getString("schoolyear"))+".09");
//				v.setValue4((String)unionDutyMap.get(rs.getString("duty")));//
//				
//				List mlist=new ArrayList();
//				if(map.get(7)==null){
//					mlist.add(v);
//					map.put(7, mlist);
//				}else{
//					mlist=map.get(7);
//					mlist.add(v);
//					map.put(7, mlist);
//				}
//			}
			
			//五、8社团经历
//			rs=null;
//			String sql5="SELECT * FROM club,club_members WHERE club.id=club_members.memberClubname AND club_members.memberName='"+stuid+"'";
//			rs=stmt.executeQuery(sql5);
//			while(rs.next()){
//				StudentRzd v=new StudentRzd();
//				int participateid=rs.getInt("club_members.id");//参与的id
//				v.setValue1(rs.getString("clubname"));
//				v.setValue2((String)academyMap.get(rs.getString("academy")));
//				v.setValue3(rs.getString("addtime").substring(0, 7).replace("-", "."));
//				String duty=rs.getString("memberduty");
//				String dutyStr="成员";
//				if(duty!=""||duty!=null){
//					dutyStr=(String)memberDutyMap.get(duty);
//				}
//				v.setValue4(dutyStr);
//				
//				//添加其它标志并存储，存储前判断是否已存过,通过参与表中的id和rzd的type
//				v.setType(8);
//				v.setActivityId(participateid);
//				v.setStuid(stuid);
//				v.setDeptid(""+deptid);
//				v.setModifyflag(SdtwConst.RZDMODIFY_YCZ);
//				v.setCheckflag(SdtwConst.RZDCHECK_TG);
//				List cdt=new ArrayList();
//				StudentRzd sr=new StudentRzd();
//				cdt.add("stuid="+stuid);
//				cdt.add("type=8");
//				cdt.add("activityid="+participateid);
//				if(((List)sr.query(cdt)).size()==0){
//					v.insert();
//				}
//				
//				List mlist=new ArrayList();
//				if(map.get(8)==null){
//					mlist.add(v);
//					map.put(8, mlist);
//				}else{
//					mlist=map.get(8);
//					mlist.add(v);
//					map.put(8, mlist);
//				}
//			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			if (rs != null) {
			    try { rs.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
			if (stmt != null) {
			    try {stmt.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
			if (con != null) {
			    try { con.close(); }
			    catch (Exception e) { e.printStackTrace(); }
			}
	    }
		return map;
	}
		

	/***
	 * 获得某学生的全部rzd条目
	 * @param stuid
	 * @return Map<type,List<StudentRzd>>
	 */
	public Map<Integer, List<StudentRzd>> getAllRzdByType(int stuid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		cdt.add("stuid="+stuid);
		cdt.add("1=1 ORDER BY checkflag,modifyflag");
		StudentRzd v=new StudentRzd();
		list=v.query(cdt);
		
		Map<Integer,List<StudentRzd>> map=new HashMap<Integer,List<StudentRzd>>();
		for(int i=0;i<list.size();i++){
			List mlist=new ArrayList();
			
			StudentRzd rzd=(StudentRzd)list.get(i);
			int type=rzd.getType();
			
			if(map.get(type)==null){
				mlist.add(rzd);
				map.put(type, mlist);
			}else{
				mlist=(List<StudentRzd>)map.get(type);
				mlist.add(rzd);
				map.put(type, mlist);
			}
		}
		return map;
	}
	
	/***
	 * 获取某学生全部可打印Rzd条目
	 * @param stuid
	 * @return
	 */
	public Map<Integer, List<StudentRzd>> getPrintRzdByType(int stuid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		cdt.add("stuid="+stuid);
		cdt.add("checkflag="+SdtwConst.RZDCHECK_TG);
		StudentRzd v=new StudentRzd();
		list=v.query(cdt);
		
		Map<Integer,List<StudentRzd>> map=new HashMap<Integer,List<StudentRzd>>();
		for(int i=0;i<list.size();i++){
			List mlist=new ArrayList();
			
			StudentRzd rzd=(StudentRzd)list.get(i);
			int type=rzd.getType();
			
			if(map.get(type)==null){
				mlist.add(rzd);
				map.put(type, mlist);
			}else{
				mlist=(List<StudentRzd>)map.get(type);
				mlist.add(rzd);
				map.put(type, mlist);
			}
		}
		return map;
	}
	
	/***
	 * 通过idlist获取选定打印的Map
	 * @param idlist
	 * @return
	 */
	public Map<Integer, List<StudentRzd>> getPrintRzdByType(String idlist,int stuid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		cdt.add("id in("+idlist+")");
		cdt.add("stuid="+stuid);//防止在url上直接改动idlist,打印出别人的rzd
		cdt.add("checkflag="+SdtwConst.RZDCHECK_TG);
		StudentRzd v=new StudentRzd();
		list=v.query(cdt);
		
		Map<Integer,List<StudentRzd>> map=new HashMap<Integer,List<StudentRzd>>();
		for(int i=0;i<list.size();i++){
			List mlist=new ArrayList();
			
			StudentRzd rzd=(StudentRzd)list.get(i);
			int type=rzd.getType();
			
			if(map.get(type)==null){
				mlist.add(rzd);
				map.put(type, mlist);
			}else{
				mlist=(List<StudentRzd>)map.get(type);
				mlist.add(rzd);
				map.put(type, mlist);
			}
		}
		return map;
	}	
	
	/***
	 * 获取某学生的打印记录
	 * @param stuid
	 * @return
	 */
	public List getStudentRzdStateList(int stuid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		StudentRzdState v=new StudentRzdState();
		cdt.add("stuid="+stuid);
		list=v.query(cdt);
		return list;
	}
	
	/***
	 * 获得honor map
	 * @return Map<honorid,honorname>
	 */
	public Map getHonorMap(){
		Map map=new HashMap();
		List list=new ArrayList();
		List cdt=new ArrayList();
		Honor honor=new Honor();
		cdt.add("1=1");
		list=honor.query(cdt);
		for(int i=0;i<list.size();i++){
			Honor v=(Honor)list.get(i);
			map.put(v.getId(), v.getHonorName());
		}
		return map;
	}
	
	/**
	 * 通过学号获取userid
	 * @param stuNo
	 * @return
	 */
	public int getUseridByStuNo(String stuNo){
		int id=0;
		BaseUserCode buc=new BaseUserCode();
		List cdt=new ArrayList();
		List list=new ArrayList();
		cdt.add("Name like '%"+stuNo+"%'");
		list=buc.query(cdt);
		if(list.size()>0){
			id=((BaseUserCode)list.get(0)).getId(); 
		}
		return id;
	}
	
	public List getCheckOptions(){
		List list=new ArrayList();
		list.add(new OptionBean("未审核", ""+SdtwConst.RZDCHECK_WSH));
		list.add(new OptionBean("通过", ""+SdtwConst.RZDCHECK_TG));
		list.add(new OptionBean("不通过", ""+SdtwConst.RZDCHECK_WTG));
		return list;
	}
	
	public Map getCheckMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.RZDCHECK_WSH, "未审核");
		map.put(SdtwConst.RZDCHECK_WTG, "不通过");
		map.put(SdtwConst.RZDCHECK_TG, "通过");
		return map;
	}
	
	public Map getModifyMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.RZDMODIFY_YCZ, "系统生成");
		map.put(SdtwConst.RZDMODIFY_WTJ, "未提交");
		map.put(SdtwConst.RZDMODIFY_YTJ, "已提交");
		return map;
	}

}
