package com.xietong.software.sdtw.youthhonour;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.xietong.software.base.Power;
import com.xietong.software.base.SdtwConst;
import com.xietong.software.common.CEditConst;
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
import com.xietong.software.sdtw.db.YouthHonour;
import com.xietong.software.sdtw.db.Youthhonour_notice;
import com.xietong.software.util.OptionBean;
import com.xietong.software.util.ParamUtils;
import com.xietong.software.util.Tool;

public class YouthhonourUtil {
	public Map<Integer,String> youthhonourName=new HashMap<Integer,String>(){
	{ 
		put(1, "山东大学红旗团委"); 
		put(2, "山东大学十佳团支部"); 
		put(3, "山东大学先进团支部"); 
		put(4, "山东大学青年文明号"); 
		put(5, "山东大学共青团组织建设工作先进集体"); 
		put(6, "山东大学共青团宣传调研与网络建设工作先进集体"); 
		put(7, "山东大学学生创新创业工作先进集体"); 
		put(8, "山东大学学生校园文化活动先进集体"); 
		put(9, "山东大学学生社会实践工作先进集体"); 
		put(10, "山东大学学生志愿服务工作先进集体"); 
		
		put(11, "山东大学十佳共青团员"); 
		put(12, "山东大学优秀团干部"); 
		put(13, "山东大学模范团干部"); 
		put(14, "山东大学优秀团员"); 
		put(15, "山东大学青年岗位能手"); 
		put(16, "山东大学共青团宣传调研与网络建设工作先进个人"); 
		put(17, "山东大学学生创新创业活动先进个人"); 
		put(18, "山东大学学生学术文化活动组织工作先进个人（教师）"); 
		put(19, "山东大学学生学术文化活动组织工作先进个人（学生）"); 
		put(20, "山东大学学生校园文化活动先进个人"); 
		put(21, "山东大学学生志愿服务工作先进个人"); 
		put(22, "山东大学社会工作先进个人"); 
		put(23, "山东大学学生社团活动先进个人"); 
		put(24, "山东大学学生社团优秀指导教师"); 
		};
	};
	
	/***
	 * 获取学生能申请的荣誉名map
	 * @return
	 */
	public Map getStudentYouthhonourMap(){
		YouthhonourUtil yhUtil=new YouthhonourUtil();
		Map<Integer,String> studentYouthhonourMap=yhUtil.youthhonourName;
		int[] notStudentHonour=new int[]{1,4,5,6,7,8,9};
		for(int i=0;i<notStudentHonour.length;i++){
			studentYouthhonourMap.remove(notStudentHonour[i]);
		}
		return studentYouthhonourMap;
	}
	
	/***
	 * 团委获得某noticeid下某type全通过的list
	 * @param noticeid
	 * @param type
	 * @return
	 */
	public List getYouthHonourInType(int noticeid,int type){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("type in("+type+")");
		cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		list=yh.query(cdt);
		return list;
	}
	
	
	/***
	 * 获取YouthHonour的Map,key为deptid,value为List<YouthHonour>
	 * @param noticeid
	 * @param type
	 * @return Map<academyid,List<YouthHonour>>
	 */
	public Map getYouthhonourListByXy(int noticeid,int type){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("type in("+type+")");
		cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		list=yh.query(cdt);
		
		Map<String, List<YouthHonour>>map = new HashMap<String, List<YouthHonour>>();
		for(int i=0;i<list.size();i++){
			String academyid=((YouthHonour)list.get(i)).getBelongAcademy();
			List<YouthHonour> mlist=new ArrayList<YouthHonour>();
			if(map.get(academyid)==null){
				mlist.add((YouthHonour)list.get(i));
				map.put(academyid, mlist);
			}else{
				mlist=map.get(academyid);
				mlist.add((YouthHonour)list.get(i));
				map.put(academyid, mlist);
			}
		}
		return map;
	}
	
	/***
	 * 获取YouthHonour的Map,key为deptid_type,value为List<YouthHonour>
	 * @param noticeid
	 * @return Map<academyid_type,List<YouthHonour>>
	 */
	public Map getYouthhonourListByXyType(int noticeid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour v=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		list=v.query(cdt);
		
		Map<String, List<YouthHonour>> map = new HashMap<String,List<YouthHonour>>();
		for(int i=0;i<list.size();i++){
			YouthHonour yh=(YouthHonour)list.get(i);
			String deptid=yh.getBelongAcademy();
			int type=yh.getType();
			String mykey=deptid+"_"+type;
			
			List<YouthHonour> mlist=new ArrayList<YouthHonour>();
			if(map.get(mykey)==null){
				mlist.add(yh);
				map.put(mykey, mlist);
			}else{
				mlist=map.get(mykey);
				mlist.add(yh);
				map.put(mykey, mlist);
			}
			
		}
		return map;
	}
	
	/***
	 * 由type,academyid获得List<YouthHonour>
	 * @param noticeid
	 * @return Map<type,Map<academyid,List<YoutHonour>>>
	 */
	public Map getYouthhonourByXyByType(int noticeid,UserInfo userInfo){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		if(userInfo.hasFunPower(Power.ADMINPOWER)){
			cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		}
		if(userInfo.hasFunPower(Power.UserAdminPower)){
			cdt.add("aycheckflag="+SdtwConst.XYCHECK_TG);
		}
		list=yh.query(cdt);
		
		Map map = new HashMap();//Map<type,Map<academyid,List>>
		for(int i=0;i<list.size();i++){
			YouthHonour v=(YouthHonour)list.get(i);
			int type=v.getType();
			String academyid=v.getBelongAcademy();
			
			if(map.get(type)==null){//新建Map<type>
				Map mmap=new HashMap();
				if(mmap.get(academyid)==null){
					List mmlist=new ArrayList();
					mmlist.add(v);
					mmap.put(academyid, mmlist);
				}else{
					List mmlist=(List)mmap.get(academyid);
					mmlist.add(v);
					mmap.put(academyid,mmlist);
				}
				map.put(type, mmap);
			}else{//添加Map<type>
				Map mmap=(Map)map.get(type);
				if(mmap.get(academyid)==null){
					List mmlist=new ArrayList();
					mmlist.add(v);
					mmap.put(academyid, mmlist);
				}else{
					List mmlist=(List)mmap.get(academyid);
					mmlist.add(v);
					mmap.put(academyid,mmlist);
				}
				map.put(type, mmap);
			}
		}
		return map;
	}
	
	
	/***
	 * 获取YouthHonour的Map,key为deptid,value为Map<type,List<YouthHonour>>
	 * @param noticeid
	 * @return Map<academyid,Map<type,List<YouthHonour>>>
	 */
	public Map getYouthhonourListByTypeByXy(int noticeid,UserInfo userInfo){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		if(userInfo.hasFunPower(Power.ADMINPOWER)){
			cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		}else if(userInfo.hasFunPower(Power.UserAdminPower)){
			cdt.add("aycheckflag="+SdtwConst.XYCHECK_TG);
		}
		list=yh.query(cdt);
		
		Map<String, Map<Integer,List<YouthHonour>>> map = new HashMap<String,Map<Integer,List<YouthHonour>>>();
		for(int i=0;i<list.size();i++){
			String academyid=((YouthHonour)list.get(i)).getBelongAcademy();
			int type=((YouthHonour)list.get(i)).getType();
			
			Map<Integer,List<YouthHonour>> mmap=new HashMap<Integer,List<YouthHonour>>();
			
			if(map.get(academyid)==null){
				List<YouthHonour> mlist=new ArrayList<YouthHonour>();
				mlist.add((YouthHonour)list.get(i));
				mmap.put(type, mlist);
				map.put(academyid, mmap);
			}else{
				List<YouthHonour> mlist=new ArrayList<YouthHonour>();
				mmap=map.get(academyid);
				
				if(mmap.get(type)==null){//mmap中无此type
					mlist.add((YouthHonour)list.get(i));
					mmap.put(type, mlist);
					
				}else{//mmap中有此type
					mlist=mmap.get(type);
					mlist.add((YouthHonour)list.get(i));
					mmap.put(type, mlist);
				}
				map.put(academyid, mmap);
				
			}
		}
		return map;
	}
	
	
	
	
	/***
	 * 获取YouthHonour的Map,key为type,value为list<YouthHonour>
	 * @param noticeid
	 * @团委审核通过的
	 * @return Map<type,List<YouthHonour>>
	 */
	public Map getYouthhonourListByType(int noticeid){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		list=yh.query(cdt);
		
		Map<Integer, List<YouthHonour>> map = new HashMap<Integer, List<YouthHonour>>();
		for(int i=0;i<list.size();i++){
			int type=((YouthHonour)list.get(i)).getType();
			
			if(map.get(type)==null){
				List<YouthHonour> mlist=new ArrayList<YouthHonour>();
				mlist.add((YouthHonour)list.get(i));
				map.put(type, mlist);
			}else{
				List<YouthHonour> mlist=new ArrayList<YouthHonour>();
				mlist=(List<YouthHonour>)map.get(type);
				mlist.add((YouthHonour)list.get(i));
				map.put(type, mlist);
			}
		}
		return map;
	}
	
	
	
	/***
	 * 获得某学院团委审核通过的类型
	 * @param noticeid
	 * @param type
	 * @return
	 */
	public List getYouthHonourInType(int noticeid,int type,int academyid,String XYorTW){
		List list=new ArrayList();
		List cdt=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("belongacademy='"+academyid+"'");
		cdt.add("noticeid="+noticeid);
		cdt.add("type in("+type+")");
		
		if("TW".equals(XYorTW)){
			//团委查看团委审核通过了的
			cdt.add("twcheckflag="+SdtwConst.TWCHECK_TG);
		}else if("XY".equals(XYorTW)){
			//学院查看本学院审核通过了的
			cdt.add("aycheckflag="+SdtwConst.XYCHECK_TG);
		}
		list=yh.query(cdt);
		return list;
	}
	
	/**
	 * 获得一条某学院的是否上报标志
	 * @param noticeid
	 * @param academyid
	 * @return
	 */
	public int getOneXyReportFlag(int noticeid,int academyid){
		int flag=SdtwConst.XYREPORT_WSB;
		List cdt=new ArrayList();
		List list=new ArrayList();
		YouthHonour yh=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("belongacademy='"+academyid+"' limit 1");
		list=yh.query(cdt);
		if(list.size()>0){
			flag=((YouthHonour)list.get(0)).getXyReport();
		}
		return flag;
	}
	
	/***
	 * 学生获取noticelist
	 * @return 
	 */
	public List getNoticeList(){
		Youthhonour_notice v=new Youthhonour_notice();
		List list = new ArrayList();
		List cdt = new ArrayList();
		cdt.add("1=1 ORDER BY id DESC");
		list=v.query(cdt);
		return list;
	}
	
	/***
	 * 获取一条youthhonour
	 * @param userid
	 * @param noticeid
	 * @param type
	 * @return YouthHonour
	 */
	public YouthHonour getOneYouthhonour(int noticeid,int type,String userid){
		YouthHonour v=new YouthHonour();
		List list=new ArrayList();
		List cdt=new ArrayList();
		cdt.add("noticeid="+noticeid);
		cdt.add("type="+type);
		cdt.add("addaccount='"+userid+"'");
		list=v.query(cdt);
		
		if(list.size()>0){
			return (YouthHonour)list.get(0);
		}else{
			return null; 
		}
	}

	public YouthHonour getOneYouthhonour(int id){
		YouthHonour v=new YouthHonour();
		List list=new ArrayList();
		List cdt=new ArrayList();
		cdt.add("id="+id);
		list=v.query(cdt);
		return (YouthHonour)list.get(0);
	}
	
	public Map getXyReportMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.XYREPORT_WSB, "学院未上报");
		map.put(SdtwConst.XYREPORT_YSB, "学院已上报");
		return map;
	}
	
	public Map getTwReportMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.TWREPORT_WGB, "结果未公布");
		map.put(SdtwConst.TWREPORT_YGB, "结果已公布");
		return map;
	}
	
	public Map getXyCheckMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.XYCHECK_WSH, "学院未审核");
		map.put(SdtwConst.XYCHECK_WTG, "学院未通过");
		map.put(SdtwConst.XYCHECK_TG, "学院通过");
		return map;
	}
	
	public Map getTwCheckMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.TWCHECK_WSH, "团委未审核");
		map.put(SdtwConst.TWCHECK_WTG, "团委未通过");
		map.put(SdtwConst.TWCHECK_TG, "团委通过");
		return map;
	}
	
	public Map getStuModifyMap(){
		Map map = new HashMap<String,String>();
		map.put(SdtwConst.MODIFY_WTJ, "未提交");//可修改
		map.put(SdtwConst.MODIFY_YTJ, "已提交");//不可修改
		map.put(SdtwConst.MODIFY_SQXG, "申请修改");//提交状态，不可修改
		return map;
	} 
	
	
	/***
	 * 某一类型荣誉,某noticeid的申请数,即学生提交数
	 * @param type 1~24
	 * @param noticeid
	 * @param academyid 0:tuanwei
	 * @return ApplyNum
	 */
	public int getApplyNum(int type,int noticeid,int academyid){
		int count=0;
		List cdt = new ArrayList();
		YouthHonour v=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("type in("+type+")");
		cdt.add("modifyflag in ("+SdtwConst.MODIFY_YTJ+","+SdtwConst.MODIFY_SQXG+")");
		
		if(academyid==0){
			cdt.add("xyreport="+SdtwConst.XYREPORT_YSB);
		}else{
			cdt.add("belongacademy='"+academyid+"'");
		}
		count=v.getCount(cdt);
		return count;
	}

	/***
	 * 学院审核通过数
	 * @param type
	 * @param noticeid
	 * @param academyid 0表示所有学院
	 * @return xyPassNum
	 */
	public int getXyPassNum(int type,int noticeid,int academyid){
		int count=0;
		List cdt = new ArrayList();
		YouthHonour v=new YouthHonour();
		cdt.add("noticeid="+noticeid);
		cdt.add("type in("+type+")");
		cdt.add("aycheckflag in("+SdtwConst.XYCHECK_TG+")");
		
		if(academyid==0){//团委只看已上报的学院
			cdt.add("xyreport="+SdtwConst.XYREPORT_YSB);
		}else{
			cdt.add("belongacademy in("+academyid+")");
		}
		count=v.getCount(cdt);
		return count;
	}
	
	/**
	 * 团委通过数
	 * @param type
	 * @param noticeid
	 * @param academyid 0:tuanwei
	 * @return twPassNum
	 */
	public int getTwPassNum(int type,int noticeid,int academyid){
		int count=0;
		List cdt = new ArrayList();
		YouthHonour v=new YouthHonour();
		cdt.add("noticeid ="+noticeid);
		cdt.add("type in("+type+")");
		
		cdt.add("TwCheckFlag in("+SdtwConst.TWCHECK_TG+")");
		
		if(academyid==0){//团委
			cdt.add("xyreport="+SdtwConst.XYREPORT_YSB);
		}else{
			cdt.add("belongacademy in("+academyid+")");
		}
		count=v.getCount(cdt);
		return count;
	}
	
	/***
	 * 或得团委或学院的申请数，学院通过数，团委通过数的Map
	 * @param noticeid
	 * @param academyid,academy=0表示团委
	 * @return Map<type,int{applyNum,xyPassNum,twPassNum}>
	 */
	public Map getAllCountByType(int noticeid,int academyid){
		List cdt=new ArrayList();
		List list=new ArrayList();
		YouthHonour v=new YouthHonour();
		cdt.add("noticeid ="+noticeid);
		if(academyid!=0)
			cdt.add("belongacademy in("+academyid+")");
		list=v.query(cdt);
		
		Map map=new HashMap();
		for(int i=0;i<list.size();i++){
			YouthHonour yh=(YouthHonour)list.get(i);
			int type=yh.getType();
			int modifyflag=yh.getModifyFlag();
			int xyreport=yh.getXyReport();
			int xycheckflag=yh.getAyCheckFlag();
			int twcheckflag=yh.getTwCheckFlag();
			int twreport=yh.getTwReport();
			
			if(map.get(type)==null){
				int[] num={0,0,0};
				//applyNum
				if((academyid==0)&&(xyreport==SdtwConst.XYREPORT_YSB)&&(modifyflag==SdtwConst.MODIFY_YTJ)) num[0]+=1;
				if((academyid!=0)&&(modifyflag==SdtwConst.MODIFY_YTJ||modifyflag==SdtwConst.MODIFY_SQXG)) num[0]+=1;
				//xyPassNum
				if((academyid==0)&&(xyreport==SdtwConst.XYREPORT_YSB)&&(xycheckflag==SdtwConst.XYCHECK_TG)) num[1]+=1;
				if((academyid!=0)&&(xycheckflag==SdtwConst.XYCHECK_TG)) num[1]+=1;	
				//twPassNum
				if((academyid==0)&&(xyreport==SdtwConst.XYREPORT_YSB)&&(twcheckflag==SdtwConst.TWCHECK_TG)) num[2]+=1;
				if((academyid!=0)&&(twcheckflag==SdtwConst.TWCHECK_TG)) num[2]+=1;	
				
				map.put(type, num);
			}else{
				int[] num=(int[])map.get(type);
				//applyNum
				if((academyid==0)&&(modifyflag==SdtwConst.MODIFY_YTJ)&&(xyreport==SdtwConst.XYREPORT_YSB)) num[0]+=1;
				if((academyid!=0)&&(modifyflag==SdtwConst.MODIFY_YTJ||modifyflag==SdtwConst.MODIFY_SQXG)) num[0]+=1;
				//xyPassNum
				if((academyid==0)&&(xyreport==SdtwConst.XYREPORT_YSB)&&(xycheckflag==SdtwConst.XYCHECK_TG)) num[1]+=1;
				if((academyid!=0)&&(xycheckflag==SdtwConst.XYCHECK_TG)) num[1]+=1;	
				//twPassNum
				if((academyid==0)&&(xyreport==SdtwConst.XYREPORT_YSB)&&(twcheckflag==SdtwConst.TWCHECK_TG)) num[2]+=1;
				if((academyid!=0)&&(twcheckflag==SdtwConst.TWCHECK_TG)) num[2]+=1;	
				map.put(type, num);
			}
		}
		//补0
		for(int i=1;i<25;i++){
			if(map.get(i)==null){
				int[] num={0,0,0};
				map.put(i, num);
			}
		}
		return map;
	}
	
	
	/***
	 * 获取所有五四表彰内容Options
	 * @return
	 */
	public List getYouthhonourOptions(){
		List list = new ArrayList();
		for(Map.Entry<Integer, String> entry:youthhonourName.entrySet()){
			list.add(new OptionBean(entry.getValue(), entry.getKey()+""));
		}
		return list;
	}
	
	/***
	 * 获取clublevel社团级别
	 * @return
	 */
	public List getClubLevelOptions(){
		List list = new ArrayList();
		list.add(new OptionBean("校级精品社团", "1"));
		list.add(new OptionBean("校级优秀社团", "2"));
		list.add(new OptionBean("校级一般社团", "3"));
		list.add(new OptionBean("院级精品社团", "4"));
		list.add(new OptionBean("院级优秀社团", "5"));
		list.add(new OptionBean("院级一般社团", "6"));
		return list;
	}
	
}