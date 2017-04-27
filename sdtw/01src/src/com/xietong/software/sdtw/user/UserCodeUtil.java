package com.xietong.software.sdtw.user;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.xietong.software.common.CEditConst;
import com.xietong.software.common.UserInfo;
import com.xietong.software.sdtw.db.Academy;
import com.xietong.software.sdtw.db.Academy_Money_Nums;
import com.xietong.software.sdtw.db.BaseUserCode;
import com.xietong.software.sdtw.db.Classes;
import com.xietong.software.sdtw.db.Grade;
import com.xietong.software.sdtw.db.Major;
import com.xietong.software.sdtw.db.Nations;
import com.xietong.software.util.Tool;


public class UserCodeUtil {

	public List<String> readExcel(String path,HttpServletRequest request) throws IOException {
		if (path == null || "".equals(path)) {
			return null;
		} else {
			//获取后缀名
			String fileExt=getFileExt(path); 
			if(!"".equals(fileExt)){ 
				if(".xls".equals(fileExt)){
					return readXls(path,request);
				}/*else if(".xlsx".equals(fileExt)){
					return readXlsx(path,request);
				}*/
			}else{
				System.out.println("不是Excel文件");
			}
		}
		return null;
	}
	
	
	private List<String> readXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String, Integer> cityMap = new HashMap<String, Integer>();
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> majorMap = new HashMap<String, Integer>();
		Map<String,Integer>classesMap = new HashMap<String, Integer>();
		Map<String, Integer>sexMap = new HashMap<String, Integer>();
		Map<String, Integer> nationMap = new HashMap<String, Integer>();
		
		cityMap = getCityMap();
		academyMap = getAcademyMap();
		majorMap = getMajorMap();
		classesMap = getClassMap();
		sexMap = getSexMap();
		nationMap = getNationMap();
		//Map<String, Integer> politicsNameMap = new HashMap<String, Integer>();
		//politicsNameMap = getPoliticsNameMap();
		Map<String, Integer> identityMap = new HashMap<String, Integer>();
		identityMap = getIdentityMap();
		Map<String, Integer> gradeMap = new HashMap<String, Integer>();
		gradeMap = getGradeMap();
		Set set = new HashSet();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 HSSFCell rxsj = hssfRow.getCell(7);
					 String rxsjstr = rxsj==null?"":rxsj.toString();
					 if (!"".equals(rxsjstr.trim())) {
						 set.add(rxsjstr);
					 }
				 }catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
				}
		 }
		 List list = new ArrayList(set);
		 Map<String,BaseUserCode> userMap = new HashMap<String, BaseUserCode>();
			userMap = getBaseUserCodeMap(Tool.join(",", list));
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 boolean xhflag = true;
						 boolean xmflag = true;
						 boolean idcardflag = true;
						 boolean xshflag = true;
						 boolean zyhflag = true;
						 boolean bjhflag = true;
						// boolean rxsjflag = true;
						// boolean xbflag = true;
						// boolean mzflag = true;
						// boolean zzmmflag = true;
						 //boolean xzflag = true;
						 //boolean xlflag = true;
						 BaseUserCode v = new BaseUserCode();
						 //城市      学号	姓名	身份证号码	系所号	专业号	班级名	入校时间	性别		民族	政治面貌	备注
						 //城市*	学号*	姓名*	身份证号码*	系所号*	专业号*	班级名*	入校年级*	性别	            民族	政治面貌	备注

						  HSSFCell cs = hssfRow.getCell(0);
						  HSSFCell xh = hssfRow.getCell(1);
						  HSSFCell xm = hssfRow.getCell(2);
						  HSSFCell idcard = hssfRow.getCell(3);
						  HSSFCell xsh = hssfRow.getCell(4);
						  HSSFCell zyh = hssfRow.getCell(5);
						  HSSFCell bjh = hssfRow.getCell(6);
						  HSSFCell rxsj = hssfRow.getCell(7);
						  HSSFCell xb = hssfRow.getCell(8);
						 // HSSFCell csrq = hssfRow.getCell(9);
						  HSSFCell mz = hssfRow.getCell(9);
						  HSSFCell zzmm = hssfRow.getCell(10);
						 // HSSFCell xz = hssfRow.getCell(11);
						 // HSSFCell xl = hssfRow.getCell(12);
						  HSSFCell bz = hssfRow.getCell(12);
						 // HSSFCell mm = hssfRow.getCell(13);
						  
						  String csstr = cs==null?"":cs.toString();
						  String xhstr = xh==null?"":xh.toString();
						  String xmstr = xm==null?"":xm.toString();
						  String idcardstr = idcard==null?"":idcard.toString();
						  String xshstr = xsh==null?"":xsh.toString();
						  String zyhstr = zyh==null?"":zyh.toString();
						  String bjhstr = bjh==null?"":bjh.toString();
						  String rxsjstr = rxsj==null?"":rxsj.toString();
						  String xbstr = xb==null?"":xb.toString();
						  //String csrqstr = csrq.toString();
						  String mzstr = mz==null?"": mz.toString();
						  String zzmmstr = zzmm==null?"":zzmm.toString();
						 // String xzstr = xz==null?"":xz.toString();
						 // String xlstr = xl==null?"":xl.toString();
						  String bzstr = bz==null?"":bz.toString();
						 // String mmstr = mm==null?"":mm.toString();
						  if(cs == null || "".equals(cs))
		                    	 break ;
							 sum++;
							if(xh == null || "".equals(xhstr.trim())) {
								xhflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入学号</font>");
							}  
							if(xm == null || "".equals(xmstr.trim())) {
								xmflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入姓名</font>");
							} 
							if(idcard==null || "".equals(idcardstr.trim())) {
								idcardflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入身份证号码</font>");
							} else {
								if (idcardstr.lastIndexOf("x")>-1) {
									idcardstr = idcardstr.substring(0,idcardstr.length()-1)+"X";
								}
							}
							if(xsh==null || "".equals(xshstr.trim())) {
								xshflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入系所号</font>");
							} else {
								if(academyMap.get(xshstr)==null) {
									xshflag = false;
									str.add("<font color=\"red\">第"+rowNum+"条导入失败，系所号录入错误</font>");
								}
							} 
							if(zyh==null || "".equals(zyhstr.trim())) {
								zyhflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入专业号</font>");
							} else {
								if (majorMap.get(zyhstr)==null) {
									zyhflag = false;
									 str.add("<font color=\"red\">第"+rowNum+"条导入失败，专业号录入错误</font>");
								}
							}
							if(bjh==null || "".equals(bjhstr.trim())) {
								bjhflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入班级</font>");
							} else {
								if (classesMap.get(bjhstr)==null) {
									bjhflag = false;
									 str.add("<font color=\"red\">第"+rowNum+"条导入失败，班级录入错误</font>");
								}
							}
							if(rxsj==null || "".equals(rxsjstr.trim())) {
								//rxsjflag = false;
								 //str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入入学时间</font>");
								rxsjstr=Tool.ymOfDate(new Date());
							} 
							
							int xzstr=4;
							//String xlstr = "本科";
							
							if (xhflag&&xmflag&&idcardflag&&xshflag&&zyhflag&&bjhflag) {
								BaseUserCode usercode = new BaseUserCode();
								if (userMap.get(xhstr)!=null) {
									usercode = userMap.get(xhstr);
								}
								int bysj = Tool.StrToInt(rxsjstr)+xzstr;
								usercode.setOrgId(cityMap.get(csstr));
								usercode.setName(xhstr);
								usercode.setCnName(xmstr);
								usercode.setIDNum(idcardstr);
								usercode.setDeptId(academyMap.get(xshstr));
								usercode.setMajor(majorMap.get(zyhstr)+"");
								usercode.setZhiBu(classesMap.get(bjhstr)+"");
								usercode.setYearToSchool(rxsjstr);
								usercode.setTimeToSchool(Tool.stringToDateTime(rxsjstr+"-09-01 0:00:00"));
								usercode.setGraduateTime(Tool.stringToDateTime(bysj+"-07-01 0:00:00"));
								if("".equals(xbstr.trim())&&sexMap.get(xbstr)!=null)
								usercode.setGender(sexMap.get(xbstr));
								//usercode.setBirthday();
								if ("".equals(mzstr.trim())&&nationMap.get(mzstr)!=null)
								usercode.setNation(nationMap.get(mzstr)+"");
								if (zzmmstr.indexOf("团员")>-1) {
									zzmmstr = "03";//"中国共产主义青年团团员";
								} else if (zzmmstr.indexOf("预备")>-1) {
									zzmmstr = "02";//"中共预备党员";
								} else 	if (zzmmstr.indexOf("预备")<=-1&&zzmmstr.indexOf("党员")>-1) {
									zzmmstr = "01";//"中共党员";
								} else {
									zzmmstr = "13";//"群众";
								}
								usercode.setMemberPolitics(zzmmstr+"");
								usercode.setLenOfSchool("4");//学制
								usercode.setIdentity(0+"");//学历本科
								usercode.setOperLog(bzstr);
								usercode.setIsEnable(1);
								usercode.setRoles(3+"");
								usercode.setGrade(gradeMap.get(rxsjstr)+"");
								String pwd = idcardstr.substring(idcardstr.length()-6,idcardstr.length());
								usercode.setPwd(Tool.encrypt(pwd));
								//usercode.setPwd(Tool.encrypt(mmstr));
								int num = 0;
								if (userMap.get(xhstr)!=null) {
									num = usercode.update();
								} else {
									num = usercode.insert();
								}
								
							   if(num<1){
		                    		 str.add("<font color=\"red\">第"+rowNum+" 条导入失败</font>");
		                    	 }else if(num==1){
		                    		 succ++;
		                    	 }
								
							}
					 }
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     			}
			 }
			
		 }
		 userMap.clear();
		 cityMap.clear();
		 academyMap.clear();
		 majorMap.clear();
		 classesMap.clear();
		 sexMap.clear();
		 nationMap.clear();
		 gradeMap.clear();
		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
	public List<String> readClassesExcel(String path,HttpServletRequest request) throws IOException {
		if (path == null || "".equals(path)) {
			return null;
		} else {
			//获取后缀名
			String fileExt=getFileExt(path); 
			if(!"".equals(fileExt)){ 
				if(".xls".equals(fileExt)){
					return readClassesXls(path,request);
				}/*else if(".xlsx".equals(fileExt)){
					return readXlsx(path,request);
				}*/
			}else{
				System.out.println("不是Excel文件");
			}
		}
		return null;
	}
	
	private List<String> readClassesXls(String path,HttpServletRequest request)throws IOException {
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		List<String> str = new ArrayList<String>();//存放返回的信息
		int succ=0;//成功的条数
		int sum=0;//共几条
		
		Map<String,Integer> academyMap = new HashMap<String, Integer>();
		Map<String, Integer> majorMap = new HashMap<String, Integer>();
		Map<String, Integer> gradeMap = new HashMap<String, Integer>();
		Map<String,Classes>classesMap = new HashMap<String, Classes>();
		academyMap = getAcademyMap();
		majorMap = getMajorMap();
		gradeMap = getGradeMap();
		classesMap = getClassMap2();
		//读取Sheet
		 for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			 HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			 if (hssfSheet == null) {
			     continue;
		     }
			 //读取Row
			 for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				 try{
					 HSSFRow hssfRow = hssfSheet.getRow(rowNum);
					 if (hssfRow != null) {
						 boolean xshflag = true;
						 boolean rxnjflag = true;
						 boolean zyhflag = true;
						 boolean bjhflag = true;
						 Classes v = new Classes();
						 //系所号*	入学年级*	专业号*	班级名*
						  HSSFCell xsh = hssfRow.getCell(0);
						  HSSFCell rxnj = hssfRow.getCell(1);
						  HSSFCell zyh = hssfRow.getCell(2);
						  HSSFCell bjh = hssfRow.getCell(3);

						  String xshstr = xsh==null?"":xsh.toString();
						  String rxnjstr = rxnj==null?"":rxnj.toString();
						  String zyhstr = zyh==null?"":zyh.toString();
						  String bjhstr = bjh==null?"":bjh.toString();
						
						  if(xsh == null || "".equals(xsh))
		                    	 break ;
							 sum++;
						 if("".equals(xshstr.trim())) {
								xshflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入系所号</font>");
							} else {
								if(academyMap.get(xshstr)==null) {
									xshflag = false;
									str.add("<font color=\"red\">第"+rowNum+"条导入失败，系所号录入错误</font>");
								}
							} 
						 if("".equals(rxnjstr.trim())) {
								rxnjflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入入学年级</font>");
							} else {
								if(gradeMap.get(rxnjstr)==null) {
									rxnjflag = false;
									str.add("<font color=\"red\">第"+rowNum+"条导入失败，入学年级录入错误</font>");
								}
							}
							if("".equals(zyhstr.trim())) {
								 zyhflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入专业号</font>");
							}  else {
								if(majorMap.get(zyhstr)==null) {
									zyhflag = false;
									str.add("<font color=\"red\">第"+rowNum+"条导入失败，专业号录入错误</font>");
								}
							}
							if("".equals(bjhstr.trim())) {
								bjhflag = false;
								 str.add("<font color=\"red\">第"+rowNum+"条导入失败，请录入班级名称</font>");
							} 
							Classes c = new Classes();
							if (classesMap.get(bjhstr)!=null) {
								c = classesMap.get(bjhstr);
							}
							c.setAcademy(academyMap.get(xshstr));
							c.setGid(gradeMap.get(rxnjstr));
							c.setBeizhu(majorMap.get(zyhstr)+"");//专业号
							c.setIsEnable(1);
							c.setName(bjhstr);
							int num = 0;
							if (classesMap.get(bjhstr)!=null) {
								num = c.update();
							} else {
								num = c.insert();
							}
						   if(num<1){
	                    		 str.add("<font color=\"red\">第"+rowNum+" 条导入失败</font>");
	                    	 }else if(num==1){
	                    		 succ++;
	                    	 }
								
							}
			 
				 }catch(Exception e){
	                	 e.printStackTrace();
	     				str.add("<font color=\"red\">第"+rowNum+"条导入失败！</font>");
	     			}
			 }
			
		 }
		 academyMap.clear();
		 majorMap.clear();
		 classesMap.clear();
		 gradeMap.clear();
		 str.add(sum-succ+"条导入失败");
	     str.add(succ+"条导入成功");
	     str.add("共"+sum+"条数据");
		return str;
	}
	
	public Map<String, BaseUserCode> getBaseUserCodeMap(String yearIds) {
		BaseUserCode user = new BaseUserCode();
		List<BaseUserCode> userList = new ArrayList<BaseUserCode>();
		Map<String,BaseUserCode> userMap = new HashMap<String, BaseUserCode>();
		List cdt = new ArrayList();
		cdt.add("Enable=1");
		cdt.add("Roles=3");
		cdt.add("yearToSchool in("+yearIds+")");
		userList = user.query(cdt);
		if (userList.size()>0) {
			for (int i=0;i<userList.size();i++) {
				user = userList.get(i);
				userMap.put(user.getName()+"", user);
			}
		}
		return userMap;
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
