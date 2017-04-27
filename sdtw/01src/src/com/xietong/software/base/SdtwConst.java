package com.xietong.software.base;

public class SdtwConst {
	
	public static final int USER_TYPE_STU = 3;
	
	public static final String CHECKFLAG_WSB = "";//未上报
	public static final String CHECKFLAG_SB = "0";//上报
	public static final String CHECKFLAG_XYTG = "1";//学院通过
	public static final String CHECKFLAG_XYWTG = "2";//学院未通过
	public static final String CHECKFLAG_XXTG = "3";//团委通过
	public static final String CHECKFLAG_XXWTG = "4";//团委未通过
	
	public static final String CHECKFLAG_WSB_JT = "5";//社团结题未上报
	public static final String CHECKFLAG_SB_JT = "6";//社团结题上报
	public static final String CHECKFLAG_XYTG_JT = "7";//社团结题学院通过
	public static final String CHECKFLAG_XYWTG_JT = "8";//社团结题学院未通过
	public static final String CHECKFLAG_XXTG_JT = "9";//社团结题团委通过
	public static final String CHECKFLAG_XXWTG_JT = "10";//社团结题团委未通过
	
	public static final int CLUBTYPE_LL = 1;//理论学习类
	public static final int CLUBTYPE_GY = 2;//公益服务类
	public static final int CLUBTYPE_YY = 3;//应用实践类
	public static final int CLUBTYPE_TY = 4;//体育锻炼类
	public static final int CLUBTYPE_WY = 5;//文艺娱乐类
	public static final int CLUBTYPE_ZY = 6;//职业发展类
	public static final int CLUBTYPE_QT = 7;//其他
	
	public static final int STUSER = 4;//社团角色
	
	public static final String MOUDLE_CLUB = "club";//社团创建活动
	public static final String MOUDLE_CLUB_PROJECT = "club-project";//立项活动
	
	/**社团变更指导单位审核**/
	public static final String CHANGE_CLUB_TJ = "0";//提交
	public static final String CHANGE_CLUB_YDWTG = "1";//原指导单位审核通过
	public static final String CHANGE_CLUB_YDWWTG = "2";//原指导单位审核不通过
	public static final String CHANGE_CLUB_XDWTG = "3";//新指导单位审核通过
	public static final String CHANGE_CLUB_XDWBTG = "4";//新指导单位审核不通过
	public static final String CHANGE_CLUB_TWTG = "5";//团委通过
	public static final String CHANGE_CLUB_TWBTG = "6";//团委不通过

	
	public static final int HonorType_XYWH = 3;//校园文化活动
	
	/**五四评比表彰**/
	public static final int TWREPORT_WGB= -1;//结果未公布
	public static final int TWREPORT_YGB = 1;//结果已公布
	
	public static final int XYREPORT_WSB = -1;//学院未上报
	public static final int XYREPORT_YSB = 1;//学院已上报
	
	public static final int XYCHECK_WSH = -1;//学院未审核
	public static final int XYCHECK_WTG = 0;//学院未通过
	public static final int XYCHECK_TG = 1;//学院未通过

	public static final int TWCHECK_WSH = -1;//团委未审核
	public static final int TWCHECK_WTG = 0;//团委未通过
	public static final int TWCHECK_TG = 1;//团委通过
	
	public static final int MODIFY_WTJ = -1;//可修改，未提交
	public static final int MODIFY_YTJ = 0;//不可修改，已提交
	public static final int MODIFY_SQXG = 1;//不可修改，已提交，申请修改中
	
	/**学素质拓展培养认证单**/
	public static final int RZDMODIFY_YCZ=-1;//不可修改，系统中提取的信息
	public static final int RZDMODIFY_YTJ=0;//不修改，自己填写的信息
	public static final int RZDMODIFY_WTJ=1;//可修改，自己填写的信息
	
	public static final int RZDCHECK_WSH=-1;//未审核
	public static final int RZDCHECK_WTG=0;//审核不通过
	public static final int RZDCHECK_TG=1;//审核通过
	
	
	
}
