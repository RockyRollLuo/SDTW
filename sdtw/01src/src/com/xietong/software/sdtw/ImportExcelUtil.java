package com.xietong.software.sdtw;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.xietong.software.common.CEditConst;
import com.xietong.software.sdtw.db.Academy;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.db.CampusActivity;
import com.xietong.software.sdtw.db.CampusParticipate;
import com.xietong.software.sdtw.db.Classes;
import com.xietong.software.sdtw.db.Club;
import com.xietong.software.sdtw.db.ClubActivities;
import com.xietong.software.sdtw.db.ClubType;
import com.xietong.software.sdtw.db.Grade;
import com.xietong.software.sdtw.db.Major;
import com.xietong.software.sdtw.db.Nations;
import com.xietong.software.sdtw.db.VolunteerZhikuDecalre;
import com.xietong.software.sdtw.db.VolunteerZhikuTeammember;
import com.xietong.software.util.Tool;

public class ImportExcelUtil {
	
	public List<String> readExcel(String path,HttpServletRequest request) throws IOException {
		if (path == null || "".equals(path)) {
			return null;
		} else {
			//获取后缀名
			String fileExt=getFileExt(path); 
			if(!"".equals(fileExt)){ 
				if(".xls".equals(fileExt)){
//					return readClubXls(path, request);
//					return readClubActivityXls(path, request);
//					return readCampusActivityXls(path, request);
					return readCampusPaXls(path, request);
				}/*else if(".xlsx".equals(fileExt)){
					return readXlsx(path,request);
				}*/
			}else{
				System.out.println("不是Excel文件");
			}
		}
		return null;
	}
	
	/***
	 * 读取zhiku_declare表teamlist分解完后存入zhiku_teammenber
	 * @return
	 */
	public int zhikuTeamList(){
		int retval=0;
		List<VolunteerZhikuDecalre> list=new ArrayList<VolunteerZhikuDecalre>();
		List cdt=new ArrayList();
		VolunteerZhikuDecalre vzd=new VolunteerZhikuDecalre();
		cdt.clear();
		list=vzd.query(cdt);
		
		for(int i=0;i<list.size();i++){
			String teamlist=(list.get(i)).getAddfilelist();
			int zhikuid=(list.get(i)).getId();//申请表id
			
			try{
				String[] teamary=teamlist.split(",");
				for(int j=0;j<teamary.length;j++){
					System.out.println("学生："+teamary[j]);
					String[] oneStuAry=teamary[j].split("|");
					
					String name=oneStuAry[0];
//					String sex=oneStuAry[1];
//					String academy=oneStuAry[2];
//					String grade=oneStuAry[3];
					String sno=oneStuAry[4];
					
					
					String phone=oneStuAry[5];
					String duty=oneStuAry[6];
					
					VolunteerZhikuTeammember vzt=new VolunteerZhikuTeammember();
					vzt.setZhikuDeclareId(zhikuid);
					vzt.setName(name);
//					vzt.setSex(sex);
//					vzt.setAcademy(academy);
//					vzt.setGrade(grade);
					vzt.setSno(sno);
					vzt.setPhone(phone);
					vzt.setDuty(duty);
					
					int num=0;
					num=vzt.insert();
					if(num>0){
						System.out.println("---第"+(i+1)+"条 第"+j+"个成员录入成功--");
					}else{
						System.out.println("---！！！第"+(i+1)+"条 第"+(j+1)+"个成员录入失败--");
					}
				}
			}catch(Exception ex){
				System.out.println("---第"+(i+1)+"条 录入失败--");
			}
			
		}
		return retval;
	}
	
	
	
	/**
	 * 读取校园活动参与表
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private List<String> readCampusPaXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> identityMap = new HashMap<String, Integer>();
		Map<String, Integer> snoToid = new HashMap<String, Integer>();
		Map<String, Integer> snoTodeptid = new HashMap<String, Integer>();
		
		academyMap = getAcademyNameMap();
		identityMap = getIdentityMap();
		snoToid=getSnoToIdMap();
		snoTodeptid=getSnoToDeptidMap();
		Set set = new HashSet();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			
		 }
		 List list = new ArrayList(set);
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//			 for (int rowNum = 1; rowNum <= 3; rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 

						  HSSFCell val0 = hssfRow.getCell(0);
						  String val0str=val0==null?"":val0.toString();
						  if(val0str == null || "".equals(val0str)){
							  break ;
						  }
						  sum++;
						 List<String> row=new ArrayList<String>();
						 //列数
						 for(int i=0;i<5;i++){
							 HSSFCell val=hssfRow.getCell(i);
							 String valstr=(val==null?"":val.toString());
								
//							 System.out.println("第"+(rowNum-1)+"条，录入academyid:"+academyid);
							 
							 row.add(valstr);
						 }
						 
						 	
						CampusParticipate cp=new CampusParticipate();
						cp.setCampusActivityId(row.get(0));
						
						try{
							cp.setCheckFlag(Integer.parseInt(row.get(2)));
						}catch(Exception ex1){
							cp.setCheckFlag(-1);
						}
						try{
							cp.setFinalRounds(Integer.parseInt((row.get(3))));
						}catch(Exception ex2){
							cp.setFinalRounds(0);
						}
						cp.setStudentNo(row.get(1));
						cp.setStudentAcademy(""+snoTodeptid.get(row.get(1)));
						cp.setStudentName(""+snoToid.get(row.get(1)));
						
						cp.setHonor(row.get(4));
							
						int num = 0;
						num = cp.insert();
							
						   if(num<1){
	                    		 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	                    	 }else if(num==1){
	                    		 succ++;
	                    	 }
					 }
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     				 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	     			}
			 }
			
		 }
		 academyMap.clear();

		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
	
	/**
	 * 读取校园活动
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private List<String> readCampusActivityXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> identityMap = new HashMap<String, Integer>();
		
		academyMap = getAcademyNameMap();
		identityMap = getIdentityMap();
		Set set = new HashSet();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			
		 }
		 List list = new ArrayList(set);
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//			 for (int rowNum = 1; rowNum <= 3; rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 

						  HSSFCell val0 = hssfRow.getCell(0);
						  String val0str=val0==null?"":val0.toString();
						  if(val0str == null || "".equals(val0str)){
							  break ;
						  }
						  sum++;
						 List<String> row=new ArrayList<String>();
						 //列数
						 for(int i=0;i<12;i++){
							 HSSFCell val=hssfRow.getCell(i);
							 String valstr=(val==null?"":val.toString());
							 
							 if(i==3){
							 String academyid="-1";
								try{
									academyid=""+academyMap.get(valstr);
								}catch(Exception exp){
									academyid="-1";
								}
								if("".equals(academyid)||academyid==null||"null".equals(academyid)) academyid="-1";							 
//								System.out.println("第"+(rowNum-1)+"条，录入academyid:"+academyid);
							 }
							 
							 row.add(valstr);
						 }
						 
						 	
						CampusActivity ca=new CampusActivity();
						ca.setHonor(row.get(0));
						ca.setActivityName(row.get(1));
						ca.setActivitykindType(row.get(2));
						
						String academyid="-1";
						try{
							academyid=""+academyMap.get(row.get(3));
						}catch(Exception exp){
							academyid="-1";
						}
						if("".equals(academyid)||academyid==null||"null".equals(academyid)) academyid="-1";	
						ca.setOrgacadeMy(academyid);
						
						ca.setActivityLevel(row.get(4));
						ca.setTotalRounds(row.get(5));
						ca.setPersonNumber(row.get(6));
						ca.setActivityPrincipal(row.get(7));
						ca.setContact(row.get(8));
						ca.setActivityExplain(row.get(9));
						ca.setDeadline(row.get(10));
						ca.setActivityDate1(row.get(11));
							
							
							
						int num = 0;
						num = ca.insert();
							
						   if(num<1){
	                    		 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	                    	 }else if(num==1){
	                    		 succ++;
	                    	 }
					 }
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     				 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	     			}
			 }
			
		 }
		 academyMap.clear();

		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
	
	
	/***
	 * 读取社团活动
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private List<String> readClubActivityXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> identityMap = new HashMap<String, Integer>();
		Map<String,Integer> snoToIdMap=new HashMap<String,Integer>();
		Map<String,Integer> clubidToIdMap=new HashMap<String,Integer>();
		
		academyMap = getAcademyNameMap();
		identityMap = getIdentityMap();
		snoToIdMap=getSnoToIdMap();
		clubidToIdMap=getClubidToIdMap();
		Set set = new HashSet();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			
		 }
		 List list = new ArrayList(set);
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//			 for (int rowNum = 1; rowNum <= 2; rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 

						  HSSFCell val0 = hssfRow.getCell(0);
						  String val0str=val0==null?"":val0.toString();
						  if(val0str == null || "".equals(val0str)){
							  break ;
						  }
						  sum++;
						 List<String> row=new ArrayList<String>();
						 //列数
						 for(int i=0;i<14;i++){
							 HSSFCell val=hssfRow.getCell(i);
							 String valstr=val==null?"":val.toString();
//							 if(val == null || "".equals(valstr.trim())) {
//								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入"+i+"</font>");
//							 } 
							 str.add("<font color=\"green\">第"+(rowNum-1)+"条导入失败，请录入--"+i+""+valstr+"</font>");
							 
//							 System.out.println("第"+(rowNum-1)+"条，录入-"+i+"-:"+valstr);
							 
							 
							 row.add(valstr);
						 }
						 
						 	
							ClubActivities ca=new ClubActivities();
							ca.setActivityName(row.get(0));
							ca.setOrgacadeMy(""+academyMap.get(row.get(1)));
							ca.setClubId(row.get(2));
							ca.setTimeStart(row.get(3));
							ca.setTimeEnd(row.get(4));
							ca.setActivityPlace(row.get(5));
							ca.setPredictNumber(row.get(6));
							ca.setContant(row.get(7));
							ca.setContactsPhone(row.get(8));
							ca.setRemark(row.get(9));
							ca.setAddPerson(""+snoToIdMap.get(row.get(10)));
							ca.setModule(row.get(11));
							ca.setProjectId(row.get(12));
							ca.setBudgetAmountAll(row.get(13));
							
							ca.setClubName(""+clubidToIdMap.get(row.get(2)));//由clubid获取club.id
							ca.setCheckFlag(9);
							ca.setCommentAcademy("同意");
							ca.setCommentShelian("同意");
							ca.setActivityLevel("1");
							
							
							
							int num = 0;
//							if (userMap.get(val0str)!=null) {
//								num = club.update();
//							} else {
								num = ca.insert();
//							}
							
						   if(num<1){
	                    		 str.add("<font color=\"red\">第"+rowNum+" 条导入失败</font>");
	                    		 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	                    	 }else if(num==1){
	                    		 succ++;
	                    	 }
								
					 }
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     				 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	     			}
			 }
			
		 }
		 academyMap.clear();

		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
	
	/***
	 * 读取社团
	 * @param path
	 * @param request
	 * @return
	 * @throws IOException
	 */
	private List<String> readClubXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> identityMap = new HashMap<String, Integer>();
		Map<String,Integer> snoToIdMap=new HashMap<String,Integer>();
		
		academyMap = getAcademyNameMap();
		identityMap = getIdentityMap();
		snoToIdMap=getSnoToIdMap();
		Set set = new HashSet();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			
		 }
		 List list = new ArrayList(set);
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//			 for (int rowNum = 1; rowNum <= 2; rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 

						  HSSFCell val0 = hssfRow.getCell(0);
						  String val0str=val0==null?"":val0.toString();
						  if(val0str == null || "".equals(val0str)){
							  break ;
						  }
						  sum++;
						 List<String> row=new ArrayList<String>();
						 //列数
						 for(int i=0;i<18;i++){
							 HSSFCell val=hssfRow.getCell(i);
							 String valstr=val==null?"":val.toString();
//							 if(val == null || "".equals(valstr.trim())) {
//								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入"+i+"</font>");
//							 } 
							 str.add("<font color=\"green\">第"+(rowNum-1)+"条导入失败，请录入--"+i+""+valstr+"</font>");
							 
//							 System.out.println("第"+(rowNum-1)+"条，录入-"+i+"-:"+valstr);
							 
							 
							 row.add(valstr);
						 }
						 
						 	
							Club club=new Club();
							club.setClubName(row.get(0));
							club.setClubId(row.get(1));
							club.setClubType(row.get(2));
							club.setTenet(row.get(3));
							club.setClubProfile(row.get(4));
							
							//存的academy的id
							club.setAcademy(""+academyMap.get(row.get(5)));
							
							club.setTeacher(row.get(6));
							//chairman就用addperson
//							club.setChairman(row.get(7));
							club.setChairman(""+snoToid(row.get(11)));
							club.setFeasibility(row.get(8));
							club.setCommentTea(row.get(9));
							club.setCommentAcademy(row.get(10));
							//
							club.setAddPerson(""+snoToid(row.get(11)));
							club.setCheckFlag(row.get(12));
							club.setCommenttw(row.get(13));
							club.setClubqq(row.get(14));
							club.setClubeMail(row.get(15));
							club.setClubPubAccount(row.get(16));
							club.setCity(row.get(17));
					
							int num = 0;
//							if (userMap.get(val0str)!=null) {
//								num = club.update();
//							} else {
								num = club.insert();
//							}
							
						   if(num<1){
	                    		 str.add("<font color=\"red\">第"+rowNum+" 条导入失败</font>");
	                    		 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	                    	 }else if(num==1){
	                    		 succ++;
	                    	 }
								
					 }
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     				 System.out.println("第"+(rowNum-1)+" 条导入失败</font>");
	     			}
			 }
			
		 }
		 academyMap.clear();

		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
		
	public Map<String,Integer> getGradeMap() {
		List cdt = new ArrayList();
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		List<Grade> academyList = new ArrayList<Grade>();
		Grade academy = new Grade();
		cdt.clear();
		cdt.add("isenable=1");
		academyList = academy.query(cdt);
		if (academyList.size()>0) {
			for(int i=0;i<academyList.size();i++) {
				academy = academyList.get(i);
				academyMap.put(academy.getRxDate()+"", academy.getId());
			}
		}
		return academyMap;
	}
	public Map<String, Integer> getCityMap() {
		Map<String, Integer> cityMap = new HashMap<String, Integer>();
		cityMap.put("济南", 0);
		cityMap.put("青岛", 1);
		return cityMap;
	}
	public Map<String,Integer> getAcademyMap() {
		List cdt = new ArrayList();
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		List<Academy> academyList = new ArrayList<Academy>();
		Academy academy = new Academy();
		cdt.clear();
		//cdt.add("flag=1");
		academyList = academy.query(cdt);
		if (academyList.size()>0) {
			for(int i=0;i<academyList.size();i++) {
				academy = academyList.get(i);
				academyMap.put(academy.getModiPerson(), academy.getId());
			}
		}
		return academyMap;
	}
	
	/***
	 * 由clubid获得club.id
	 * @return
	 */
	public Map<String,Integer> getClubidToIdMap() {
		List cdt = new ArrayList();
		Map<String,Integer> map = new HashMap<String, Integer>();
		List<Club> list = new ArrayList<Club>();
		Club v=new Club(); 
		cdt.clear();
		//cdt.add("flag=1");
		list =v.query(cdt);
		if (list.size()>0) {
			for(int i=0;i<list.size();i++) {
				v = list.get(i);
				map.put(v.getClubId(), v.getId());
			}
		}
		return map;
	}
	
	/***
	 * 由academyname获取id
	 * @return
	 */
	public Map<String,Integer> getAcademyNameMap() {
		List cdt = new ArrayList();
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		List<Academy> academyList = new ArrayList<Academy>();
		Academy academy = new Academy();
		cdt.clear();
		//cdt.add("flag=1");
		academyList = academy.query(cdt);
		if (academyList.size()>0) {
			for(int i=0;i<academyList.size();i++) {
				academy = academyList.get(i);
				academyMap.put(academy.getAcademyName(), academy.getId());
			}
		}
		return academyMap;
	}
	
	
	/***
	 * 由学号获得base_usercode.id
	 * @return
	 */
	public Map getSnoToIdMap() {
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String,Integer> map=new HashMap<String,Integer>();
		BaseUserCode v=new BaseUserCode();
		cdt.clear();
		list=v.query(cdt);
		for(int i=0;i<list.size();i++){
			BaseUserCode v1=(BaseUserCode)list.get(i);
			map.put(v1.getName(), v1.getId());
		}
		return map;
	}
	/**
	 * 由学号获得deptid
	 * @return
	 */
	public Map getSnoToDeptidMap() {
		List cdt = new ArrayList();
		List list = new ArrayList();
		Map<String,Integer> map=new HashMap<String,Integer>();
		BaseUserCode v=new BaseUserCode();
		cdt.clear();
		list=v.query(cdt);
		for(int i=0;i<list.size();i++){
			BaseUserCode v1=(BaseUserCode)list.get(i);
			map.put(v1.getName(), v1.getDeptId());
		}
		return map;
	}
	
	
	public int snoToid(String sno){
		int id=0;
		List cdt=new ArrayList();
		List list=new ArrayList();
		BaseUserCode v=new BaseUserCode();
		cdt.add("name='"+sno+"'");
		list=v.query(cdt);
		if(list.size()>0){
			v=(BaseUserCode)list.get(0);
			id=v.getId();
		}
		return id;
	}
	
	public Map<String, Integer> getMajorMap() {
		List cdt = new ArrayList();
		List<Major> list = new ArrayList();
		Map<String, Integer> majorMap = new HashMap<String, Integer>();
		Major v = new Major();
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = list.get(i);
				majorMap.put(v.getCode(), v.getId());
			}
		}
		return majorMap;
	}
	public Map<String, Integer> getClassMap() {
		List cdt = new ArrayList();
		List<Classes> list = new ArrayList();
		Map<String, Integer> classMap = new HashMap<String, Integer>();
		Classes v = new Classes();
		cdt.add("IsEnable=1");
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = list.get(i);
				classMap.put(v.getName(), v.getId());
			}
		}
		return classMap;
	}
	public Map<String, Classes> getClassMap2() {
		List cdt = new ArrayList();
		List<Classes> list = new ArrayList();
		Map<String, Classes> classMap = new HashMap<String, Classes>();
		Classes v = new Classes();
		cdt.add("IsEnable=1");
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = list.get(i);
				classMap.put(v.getName(), v);
			}
		}
		return classMap;
	}
	public Map<String, Integer> getSexMap() {
		Map<String, Integer> sexMap = new HashMap<String, Integer>();
		sexMap.put("男", 0);
		sexMap.put("女", 1);
		return sexMap;
	}
	public Map<String, Integer> getNationMap() {
		List cdt = new ArrayList();
		List<Nations> list = new ArrayList();
		Map<String, Integer> nationMap = new HashMap<String, Integer>();
		Nations v = new Nations();
		list = v.query(cdt);
		if (list.size()>0) {
			for (int i=0;i<list.size();i++) {
				v = list.get(i);
				nationMap.put(v.getName(), v.getId());
			}
		}
		return nationMap;
	}
	public Map<String, Integer> getPoliticsNameMap() {
		Map map = CEditConst.getPoliticsNameMap(null);
		Map<String, Integer>politicsNameMap = new HashMap<String, Integer>();
		for (Iterator it = map.keySet().iterator();it.hasNext();) {
			int key = (Integer)it.next();
			String val = (String)map.get(key+"");
			politicsNameMap.put(val, key);
		}
		return politicsNameMap;
	}
	

	
	public Map<String, Integer>getIdentityMap() {
		Map<String, Integer>identityMap = new HashMap<String, Integer>();
		identityMap.put("本科", 0);
		identityMap.put("研究生", 1);
		return identityMap;
	}
	
	/**
	 * 通过社团类型获取clubtype.id
	 * @return
	 */
	public Map getClubTypeMap(){
		List cdt = new ArrayList();
		Map map = new HashMap();
		List list = new ArrayList();
		ClubType v=new ClubType();
		cdt.clear();
		list = v.query(cdt);
		if (list.size()>0) {
			for(int i=0;i<list.size();i++) {
				ClubType v1=(ClubType)list.get(i);
				map.put(v1.getName(), v1.getId());
			}
		}
		return map;
	}

	
	
	
	
	
	/**
	 * 获取后缀
	 */
	public static String getFileExt(String fn) {
		String[] fns = Tool.split(".", fn);
		if (fns.length < 2) {
			return "";
		} else {
			return "." + fns[fns.length - 1];
		}
	}
}
