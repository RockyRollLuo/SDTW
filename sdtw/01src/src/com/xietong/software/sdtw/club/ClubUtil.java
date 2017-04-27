package com.xietong.software.sdtw.club;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.sun.corba.se.spi.orb.StringPair;
import com.xietong.software.base.Power;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.XtUtil;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.db.ClientAttach;
import com.xietong.software.sdtw.db.Club;
import com.xietong.software.sdtw.db.ClubActivities;
import com.xietong.software.sdtw.db.ClubActivitiesBudgetAmount;
import com.xietong.software.sdtw.db.ClubActivityParticipate;
import com.xietong.software.sdtw.db.ClubActivityProject;
import com.xietong.software.sdtw.db.ClubMembers;
import com.xietong.software.sdtw.db.ClubTeacher;
import com.xietong.software.sdtw.db.Club_Regist;
import com.xietong.software.sdtw.db.PracticeDeclareTeammember;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.util.Tool;

public class ClubUtil {
	
	public List getClubListByUser(int uid){
		List list = new ArrayList();
		List cdt = new ArrayList();
		Club v = new Club();
		cdt.add("AddPerson="+uid);
		list = v.query(cdt);
		if(list.size()>0){
			return list;
		}else{
			return new ArrayList();
		}
	}
	public Map getCheckFlagMap(){
		Map checkFlagMap = new HashMap<String,String>();
		checkFlagMap.put(SdtwConst.CHECKFLAG_WSB, "未上报");
		checkFlagMap.put(SdtwConst.CHECKFLAG_WSB_JT, "未上报");
		checkFlagMap.put(SdtwConst.CHECKFLAG_SB, "上报");
		checkFlagMap.put(SdtwConst.CHECKFLAG_SB_JT, "结题上报");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XYTG, "学院通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XYTG_JT, "结题学院通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XYWTG, "学院未通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XYWTG_JT, "结题学院未通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XXTG, "团委通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XXTG_JT, "结题团委通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XXWTG, "团委未通过");
		checkFlagMap.put(SdtwConst.CHECKFLAG_XXWTG_JT, "结题团委未通过");
		return checkFlagMap;
	}
	public Map getCheckFlag_BGMap(){
		Map checkFlagMap = new HashMap<String,String>();
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_TJ, "提交");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_YDWTG, "原指导单位审核通过");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_YDWWTG, "原指导单位审核不通过");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_XDWTG, "新指导单位审核通过");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_XDWBTG, "新指导单位审核不通过");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_TWTG, "团委通过,变更成功");
		checkFlagMap.put(SdtwConst.CHANGE_CLUB_TWBTG, "团委不通过");
		return checkFlagMap;
	}
	public List getCheckFlagOptions(){
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		list.add(new OptionBean("审核通过", "1"));
		list.add(new OptionBean("审核未通过", "2"));
		return list;
	}
	
	public List getMemberDutyOptions() {
		List list = new ArrayList();
		list.add(new OptionBean("", "-1"));
		list.add(new OptionBean("团支书", "1"));
		list.add(new OptionBean("财务负责人", "2"));
		list.add(new OptionBean("其他", "3"));
		return list;
	}
	
	public List getApplicationRangeOptions(){
		List list = new ArrayList();
		list.add(new OptionBean("所有人员", "0"));
		list.add(new OptionBean("按学院", "1"));
		return list;
	}
	
	public List getUserCnNameOptions(List cdt){
		List list = new ArrayList();
		List optlist = new ArrayList();
		BaseUserCode user = new BaseUserCode();
		list = user.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				user = (BaseUserCode) list.get(i);
				optlist.add(new OptionBean(user.getCnName()+"_"+user.getName(), user.getId()+""));
			}
		}
		return optlist;
	}
	public List getClubList(int selectType,int uid,String ClubName,HttpServletRequest request){
		List list = new ArrayList();
		List cdt = new ArrayList();
		List cids = new ArrayList();
		List clubList = new ArrayList();
		ClubMembers members = new ClubMembers();
		cdt.add("(CheckFlag=1 )&& MemberName="+uid+"");
		list = members.query(cdt);
		if(list.size()>0)
			for(int i=0;i<list.size();i++){
				members = (ClubMembers)list.get(i);
				cids.add(members.getMemberClubname());
			}
		cdt.clear();
		Club v = new Club();
		if(!"".equals(ClubName.trim())){
			cdt.add("ClubName like '%"+ClubName+"%'");
		}
		if(selectType==0){
			cdt.add("CheckFlag="+SdtwConst.CHECKFLAG_XXTG+"");//出去已经注销的全部社团
		}
		if(selectType==1){
			cdt.add("id in("+XtUtil.getIdsStr(Tool.join(",", cids))+") && CheckFlag="+SdtwConst.CHECKFLAG_XXTG+"");//我加入社团
		}
		if(selectType==2){
			cdt.add("RecruitmentCheckflag=1&&CheckFlag="+SdtwConst.CHECKFLAG_XXTG+"");//正在招新社团
		}
		cdt.add("Iscancle!=1");
		int currpage = ParamUtils.getIntParameter(request, "page", 1);
	    com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(v.getCount(cdt), currpage, 10);
	    request.setAttribute("PageControl", pc);
	    cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
		clubList = v.query(cdt);
		return clubList;
	}
	/***
	 * 查找社团负责人
	 * @param ids
	 * @return
	 */
	/*public Map getClubMemberMap(String clubids){
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map <String,List<ClubMembers>>map = new HashMap<String, List<ClubMembers>>();
		ClubMembers members = new ClubMembers();
		cdt.add("memberClubname in("+clubids+")");
		cdt.add("isManager=1");
		cdt.add("checkflag=1");
		list = members.query(cdt);
		for(int i=0;i<list.size();i++){
			List clubmemberList = new ArrayList();
			members = (ClubMembers) list.get(i);
			if(map.get(members.getMemberClubname())==null){
				clubmemberList.add(members);
			}else{
				clubmemberList = map.get(members.getMemberClubname());
				
			}
			map.put(members.getMemberClubname(), clubmemberList);
		}
		return map;
	}*/
	public Map getClubMemberNumsMap(){
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map <String,Integer>map = new HashMap<String, Integer>();
		ClubMembers members = new ClubMembers();
		list = members.query(cdt);
		int num = 1;//会员人数
		int numsq = 1;
		for(int i=0;i<list.size();i++){
			members = (ClubMembers) list.get(i);
			if(members.getCheckFlag()!=1){
			if(map.get(members.getMemberClubname())==null){//申请人数
					map.put(members.getMemberClubname(), 1);
			}else{
				numsq = (int)(map.get(members.getMemberClubname()))+1;
				map.put(members.getMemberClubname(), numsq);
			}
			}
			if(members.getCheckFlag()==1){
				System.out.println(members.getId()+"   members.getCheckFlag()="+members.getCheckFlag());
			if(map.get(members.getMemberClubname()+"_1")==null){//会员人数
					map.put(members.getMemberClubname()+"_1", 1);
			}else {
				num = (int)(map.get(members.getMemberClubname()+"_1"))+1;//状态为_1为审核通过
				map.put(members.getMemberClubname()+"_1", num);
			}
			}
			
		}
		return map;
	}
	/***
	 * 判断是否加入社团Map
	 * @param cids
	 * @return
	 */
	public Map getCheckJoinClub(String cids){
		Map<String, ClubMembers>map = new HashMap<String, ClubMembers>();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("MemberClubname in("+cids+")");
		ClubMembers v = new ClubMembers();
		//cdt.add("(checkflag = "+SdtwConst.CHECKFLAG_XXTG+" ||ManagerGeneration=1)");
		list = v.query(cdt);
		if(list.size()>0)
			for(int i=0;i<list.size();i++){
				v = (ClubMembers) list.get(i);
				map.put(v.getMemberClubname()+"_"+v.getMemberName(), v);
				if((v.getCheckFlag()+"").equals("1")||v.getManagerGeneration()==1){
					map.put(v.getMemberClubname()+"_"+v.getMemberName()+"_Cy", v);
				}
			}
		return map;
	}
	/***
	 * 社团负责人
	 * @param cids
	 * @return
	 */
	public Map getCheckClubSponsor(String cids){
		Map<String, List<String>>map = new HashMap<String, List<String>>();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("MemberClubname in("+cids+")");
		cdt.add("IsManager=1");
		//cdt.add("(CheckFlag=1||ManagerGeneration=1)");
		ClubMembers v = new ClubMembers();
		//cdt.add("(checkflag = "+SdtwConst.CHECKFLAG_XXTG+" ||ManagerGeneration=1)");
		list = v.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				List<String> mlist = new ArrayList<String>();
				v = (ClubMembers) list.get(i);
				if(map.get(v.getMemberClubname())!=null){
					mlist = map.get(v.getMemberClubname());
					mlist.add(v.getMemberName());
					map.put(v.getMemberClubname(), mlist);
				}else{
					mlist.add(v.getMemberName());
					map.put(v.getMemberClubname(), mlist);
				}
			}
		}
		return map;
	}
	/***
	 * 社团指导教师
	 * @param cids
	 * @return
	 */
	public Map getCheckClubTeacher(String cids){
		Map<String, List<String>>map = new HashMap<String, List<String>>();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("ClubName in("+cids+")");
		cdt.add("checkflag=1");//是否可用  是
		//cdt.add("(CheckFlag="+SdtwConst.CHECKFLAG_XXTG+")");
		ClubTeacher v = new ClubTeacher();
		list = v.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				List<String> mlist = new ArrayList<String>();
				v = (ClubTeacher) list.get(i);
				if(map.get(v.getClubName())!=null){
					mlist = map.get(v.getClubName());
					mlist.add(v.getTeaName());
					map.put(v.getClubName(), mlist);
				}else{
					mlist.add(v.getTeaName());
					map.put(v.getClubName(), mlist);
				}
			}
		}
		return map;
	}
	public Map getClubmimbers(int clubid){
		ClubMembers members = new ClubMembers();
		Map<String, Object>map = new HashMap<String, Object>();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("memberClubname="+clubid);
		cdt.add("CheckFlag=1");
		list = members.query(cdt);
		if(list.size()>0){
			map.put("all", list.size());
			for(int i=0;i<list.size();i++){
				members = (ClubMembers) list.get(i);
				if (!"1".equals(members.getIdentity())) {
					
					if(map.get("Identity_"+members.getIdentity())==null){//学历
						map.put("Identity_"+members.getIdentity(), 1);
					}else{
						int num = (Integer)(map.get("Identity_"+members.getIdentity()))+1;
						map.put("Identity_"+members.getIdentity(), num);
					}
					if(map.get("Politics_"+members.getMemberPolitics())==null){
						map.put("Politics_"+members.getMemberPolitics(), 1);
					}else{
						int num = (Integer)map.get("Politics_"+members.getMemberPolitics())+1;
						map.put("Politics_"+members.getMemberPolitics(), num);
					}
					if(map.get("Sex_"+members.getMemberSex())==null){
						map.put("Sex_"+members.getMemberSex(), 1);
					}else{
						int num = (Integer)map.get("Sex_"+members.getMemberSex())+1;
						map.put("Sex_"+members.getMemberSex(), num);
					}
					List sponsorList = new ArrayList();
					//负责人
					if("1".equals(members.getIsManager())){
						if(map.get("IsManager_")==null){
							sponsorList.add(members);
						}else{
							sponsorList = (List) map.get("IsManager_");
							sponsorList.add(members);
						}
						map.put("IsManager_", sponsorList);
					}
					//财务负责人
					List caiwuList = new ArrayList();
					if("2".equals(members.getMemberDuty())){
						if(map.get("caiwu_")==null){
							caiwuList.add(members);
						}else{
							caiwuList = (List) map.get("caiwu_");
							caiwuList.add(members);
						}
						map.put("caiwu_", caiwuList);
					}
					//所有成员
					List allmembersList = new ArrayList();
					if(map.get("All_")==null){
						allmembersList.add(members.getMemberName()+"");
					}else{
						allmembersList = (List) map.get("All_");
						allmembersList.add(members.getMemberName()+"");
					}
					map.put("All_", allmembersList);
					
				}
			}
		}
		return map;
	}
	public Map getClubmimbersAll(int clubid){
		ClubMembers members = new ClubMembers();
		Map<String, Object>map = new HashMap<String, Object>();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("memberClubname="+clubid);
		//cdt.add("CheckFlag=1");
		list = members.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				members = (ClubMembers) list.get(i);
				//所有成员
				List allmembersList = new ArrayList();
					if(map.get("All_")==null){
						allmembersList.add(members.getMemberName()+"");
					}else{
						allmembersList = (List) map.get("All_");
						allmembersList.add(members.getMemberName()+"");
					}
					map.put("All_", allmembersList);
			}
		}
		return map;
	}
	public List getClubTeacher(int clubid){
		List list = new ArrayList();
		List cdt = new ArrayList();
		ClubTeacher teacher = new ClubTeacher();
		cdt.add("ClubName ="+clubid);
		cdt.add("CheckFlag=1");
		list = teacher.query(cdt);
		return list;
	}
	public Map getClubTeacher(int clubid,String oldteacherId,String newteacherId){
		List list = new ArrayList();
		List cdt = new ArrayList();
		List oldList = new ArrayList();
		List newList = new ArrayList();
		Map<String, List>map = new HashMap<String, List>();
		ClubTeacher teacher = new ClubTeacher();
		cdt.add("ClubName ="+clubid);
		list = teacher.query(cdt);
		if (list.size()>0)
		for (int i=0;i<list.size();i++) {
			teacher = (ClubTeacher) list.get(i);
			if ((teacher.getId()+"").equals(oldteacherId)) {
				//if(teacher.getCheckFlag()!=1)
				oldList.add(teacher);
			}
			if ((teacher.getId()+"").equals(newteacherId)) {
				//if(teacher.getCheckFlag()==1)
				newList.add(teacher);
			}
		}
		map.put("newList", newList);
		map.put("oldList", oldList);
		return map;
	}
	
	/**
	 * 判断是否申请社团注册
	 * true:未申请
	 * false：已申请
	 * @param userInfo
	 * @return
	 */
	public boolean getCheckClubRegistTime(UserInfo userInfo){
		if(userInfo.hasFunPower(Power.STUSER)){
     	   Club_Regist regist = new Club_Regist();
     	   List cdt = new ArrayList();
     	   List list = new ArrayList();
     	   cdt.add("ClubId='"+userInfo.getUserCode().getName()+"'");
     	   cdt.add("1=1 order by RegistTime desc");
     	   list = regist.query(cdt);
     	   if(list.size()>0){
     		   regist = (Club_Regist)list.get(0);
     		   String curSchoolYear = CurrentSemester.getSchoolYear(new Date());
     		   String curSemester = CurrentSemester.getSemester(new Date());
     		   
     		   String regSchoolYear = CurrentSemester.getSchoolYear(regist.getRegistTime());
     		   String regSemester = CurrentSemester.getSemester(regist.getRegistTime());
     		   
     		   if(curSchoolYear.equals(regSchoolYear)&&curSemester.equals(regSemester)){
     			   return false;
     		   }
     	   }
		}
		return true;
	}
	/***
	 * 判断是否申请注册社团且审核通过
	 * true:已申请且审核通过
	 * @param userInfo
	 * @return
	 */
	public boolean getCheckClubRegistTimeAndCHeckPass(UserInfo userInfo){
		if(userInfo.hasFunPower(Power.STUSER)){
     	   Club_Regist regist = new Club_Regist();
     	   List cdt = new ArrayList();
     	   List list = new ArrayList();
     	   cdt.add("ClubId='"+userInfo.getUserCode().getName()+"'");
     	   cdt.add("checkflag="+SdtwConst.CHECKFLAG_XXTG+"");
     	   cdt.add("1=1 order by RegistTime desc");
     	   list = regist.query(cdt);
     	   if(list.size()>0){
     		   regist = (Club_Regist)list.get(0);
     		   String curSchoolYear = CurrentSemester.getSchoolYear(new Date());
     		   String curSemester = CurrentSemester.getSemester(new Date());
     		   
     		   String regSchoolYear = CurrentSemester.getSchoolYear(regist.getRegistTime());
     		   String regSemester = CurrentSemester.getSemester(regist.getRegistTime());
     		   
     		   if(curSchoolYear.equals(regSchoolYear)&&curSemester.equals(regSemester)){
     			   return true;
     		   }
     	   }
		}
		return false;
	}
	public Map getCheckClubRegistTime(String clubids){
     	   Club_Regist regist = new Club_Regist();
     	   List cdt = new ArrayList();
     	   List list = new ArrayList();
     	   Map<String, Boolean> map = new HashMap<String, Boolean>();
     	   cdt.add("ClubName in("+clubids+")");
     	   cdt.add("CheckFlag="+SdtwConst.CHECKFLAG_XXTG+"");
     	   list = regist.query(cdt);
     	   if(list.size()>0){
     		   for(int i=0;i<list.size();i++){
     			   regist = (Club_Regist)list.get(i);
     			   String curSchoolYear = CurrentSemester.getSchoolYear(new Date());
     			   String curSemester = CurrentSemester.getSemester(new Date());
     			   
     			   String regSchoolYear = CurrentSemester.getSchoolYear(regist.getRegistTime());
     			   String regSemester = CurrentSemester.getSemester(regist.getRegistTime());
 				   if(curSchoolYear.equals(regSchoolYear)&&curSemester.equals(regSemester)){
 					  map.put(regist.getClubName(), true);
 				   }else{
 					  map.put(regist.getClubName(), false);
 				   }
     		   }
     	   }
		return map;
	}
	/***
	 * 获取社团活动
	 * 社团创建活动 --》指导单位审核
	 * 立项活动--》指导单位审核--》团委审核
	 * @return
	 */
	public List getclubActivities(String sno,HttpServletRequest request,int IsatSchool,int active){
		ClubActivities activities = new ClubActivities();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("ClubName in(select MemberClubname from Club_Members where MemberSno='"+sno+"')");
		cdt.add("IsatSchool="+IsatSchool);
		cdt.add("((Module='"+SdtwConst.MOUDLE_CLUB+"' && checkflag="+SdtwConst.CHECKFLAG_XYTG+")||(Module='"+SdtwConst.MOUDLE_CLUB_PROJECT+"' && checkflag>="+SdtwConst.CHECKFLAG_XXTG+"))");
		int currpage = ParamUtils.getIntParameter(request, "page", 1);
	    com.xietong.software.common.PageControl pc = new com.xietong.software.common.PageControl(activities.getCount(cdt), currpage, 10);
	    request.setAttribute("PageControl"+active, pc);
	    cdt.add("limit " + pc.getOffset() + "," + pc.getShownum());
		list = activities.query(cdt);
		//List clubActivities = new ArrayList();
		/*if(list.size()>0){
			for(int i=0;i<list.size();i++){
				activities = (ClubActivities)list.get(i);
				if(SdtwConst.MOUDLE_CLUB.equals(activities.getModule())){//社团创建活动
					if(SdtwConst.CHECKFLAG_XYTG.equals(activities.getCheckFlag()+"")){
						clubActivities.add(activities);
					}
				}
				if(SdtwConst.MOUDLE_CLUB_PROJECT.equals(activities.getModule())){
					if(SdtwConst.CHECKFLAG_XXTG.equals(activities.getCheckFlag()+"")){
						clubActivities.add(activities);
					}
				}
			}
		}*/
		return list;
	}
	/**
	 * 判断是否报名参加活动
	 * @param activityids
	 * @return
	 */
	public Map getCheckClubActivits(String activityids){
		Map<String, ClubActivityParticipate>map = new HashMap<String, ClubActivityParticipate>();
		ClubActivityParticipate ac = new ClubActivityParticipate();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("activityid in("+activityids+")");
		list = ac.query(cdt);
		for(int i=0;i<list.size();i++){
			ac = (ClubActivityParticipate) list.get(i);
			map.put(ac.getActivityid()+"_"+ac.getSname(), ac);
		}
		return map;
	}
	public static List getTellwayOptions() {
  	    List options = new ArrayList();
  	    options.add(new OptionBean("面谈" , "0"));
  	    options.add(new OptionBean("电话" , "1"));
  	    options.add(new OptionBean("信件" , "2"));
  	    return options;
  	}
	public Map getUserMap(String uids){
		List cdt = new ArrayList();
		cdt.add("id in("+uids+")");
		BaseUserCode user = new BaseUserCode();
		List userlist = new ArrayList();
		Map <String,BaseUserCode>userMap = new HashMap<String,BaseUserCode>();
		userlist = user.query(cdt);
		if(userlist.size()>0){
			for(int i=0;i<userlist.size();i++){
				user = (BaseUserCode)userlist.get(i);
				userMap.put(user.getId()+"",user);
			}
		}
		return userMap;
	}
	public List getClubActivityProject(String ids){
		ClubActivitiesBudgetAmount cap = new ClubActivitiesBudgetAmount();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("id in("+ids+")");
		list = cap.query(cdt);
		return list;
	}
	public ClientAttach getClientAttach(int activityId){
		ClientAttach attach = new ClientAttach();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("RelationId="+activityId);
		cdt.add("order by id desc");
		list = attach.query(cdt);
		if (list.size()>0) {
			attach = (ClientAttach)list.get(0);
		}
		return attach;
	}
	
	/***
	 * 社团指导教师表当前社团教师
	 * key 社团教师
	 * value Clubteacher
	 * @param cid社团id
	 * @param newTeacherIds 新指导教师ids
	 * @return
	 */
	public Map getClubTeacherMap(String cid,String newTeacherIds){
		ClubTeacher clubTeacher = new ClubTeacher();
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String, ClubTeacher> map = new HashMap<String, ClubTeacher>();
		cdt.add("ClubName="+cid);
		cdt.add("TeaName in("+newTeacherIds+")");
		list = clubTeacher.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				clubTeacher = (ClubTeacher) list.get(i);
				map.put(clubTeacher.getTeaName(), clubTeacher);
			}
		}
		return map;
		
	}
	
	/***
	 * 根据社团ids获取Baseusercode Map
	 * @param cids
	 * @return
	 */
	public Map getStuByUIds(String uids) {
		Map<String, BaseUserCode>map = new HashMap<String, BaseUserCode>();
		BaseUserCode v = new BaseUserCode();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("id in("+uids+")");
		list = v.query(cdt);
		if(list.size()>0){
			for(int i=0;i<list.size();i++) {
				v = (BaseUserCode)list.get(i);
				map.put(v.getId()+"", v);
			}
		}
		return map;
	}
	public int getClubmembersByUIds(String uids) {
		//Map<String, ClubMembers>map = new HashMap<String, ClubMembers>();
		ClubMembers v = new ClubMembers();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("id in("+uids+")");
		cdt.add("ManagerGeneration=1");
		v.setCheckFlag(1);
		v.setStartDate(new Date());
		int num = v.updateByCondition(cdt);
		return num;
	}
	/***
	 * 字符串去重
	 * @param T_Str
	 * @return
	 */
	public String returnStr(String uids,String Sponsor){
		 List<String> list  =   new  ArrayList<String>(); 
		 String[]uidArr = uids.split(",");
         for(int i=0;i<uidArr.length;i++){
        	 list.add(uidArr[i]);
         }
         Set set = new  HashSet(); 
         List newList = new  ArrayList(); 
         for (String cd:list) {
            if(set.add(cd)){
                newList.add(cd);
            }
        }
         List listSponsor = new ArrayList();
         listSponsor.add(Sponsor);
         newList.removeAll(listSponsor);
         System.out.println( "去重后的集合： " + newList); 
         return Tool.join(",", newList);
	}
	public ClubTeacher saveNewTeacher(HttpServletRequest request) {
		int Tid = ParamUtils.getIntParameter(request, "Tid", -1);
		String ClubName = ParamUtils.getParameter(request, "ClubName","-1");
		String TeaName = ParamUtils.getParameter(request, "TeaName","");
		String TeaSex = ParamUtils.getParameter(request, "TeaSex","");
		String TeaAge = ParamUtils.getParameter(request, "TeaAge","");
		String TeaNation = ParamUtils.getParameter(request, "TeaNation","");
		String TeaPolitics = ParamUtils.getParameter(request, "TeaPolitics","");
		String TeaBirthplace = ParamUtils.getParameter(request, "TeaBirthplace","");
		String TeaDuty = ParamUtils.getParameter(request, "TeaDuty","");
		String TeaAcademy = ParamUtils.getParameter(request, "TeaAcademy","");
		String TeaTel = ParamUtils.getParameter(request, "TeaTel","");
		String TeaPhone = ParamUtils.getParameter(request, "TeaPhone","");
		String TeaEmail = ParamUtils.getParameter(request, "TeaEmail","");
		String TeaAcademic = ParamUtils.getParameter(request, "TeaAcademic","");
		ClubTeacher v = new ClubTeacher();
		if (Tid!=-1 && v.getById(Tid)!=null){
			v = v.getById(Tid);
		}
		v.setClubName(ClubName);
		v.setTeaName(TeaName);
		v.setTeaSex(TeaSex);
		v.setTeaAge(TeaAge);
		v.setTeaNation(TeaNation);
		v.setTeaPolitics(TeaPolitics);
		v.setTeaBirthplace(TeaBirthplace);
		v.setTeaDuty(TeaDuty);
		v.setTeaAcademy(TeaAcademy);
		v.setTeaTel(TeaTel);
		v.setTeaPhone(TeaPhone);
		v.setTeaEmail(TeaEmail);
		v.setTeaAcademic(TeaAcademic);
		if (Tid!=-1 && v.getById(Tid)!=null){
			v.update();
		} else {
			v.insert();
		}
		return v;
	}
	/***
	 * Identity0 本科  1 研究生
	 * @param clubId
	 * @param type
	 * @param Identity
	 * @return
	 */
	public List getTeamList(int clubId,String Identity) {
		ClubMembers v = new ClubMembers();
		List cdt = new ArrayList();
		List list = new ArrayList();
		cdt.add("MemberClubname="+clubId);
		cdt.add("Identity="+Identity);
		cdt.add("ManagerGeneration=1");//元老，发起人
		list = v.query(cdt);
		return list;
	}
	public List getSponsorList(int clubid){
		List cdt = new ArrayList();
		List list = new ArrayList();
		ClubMembers v = new ClubMembers();
		cdt.add("memberClubname="+clubid);
		cdt.add("ManagerGeneration=1");
		cdt.add("CheckFlag=1");
		list = v.query(cdt);
		return list;
	}
	public Map getuserMap(String uids) {
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String, String>userMap = new HashMap<String, String>();
		BaseUserCode v = new BaseUserCode();
		cdt.add("id in("+uids+")");
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = (BaseUserCode) list.get(i);
				userMap.put(v.getId()+"", v.getCnName());
			}
		}
		return userMap;
		
	}
}
