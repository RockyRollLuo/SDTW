package com.xietong.software.common;

/**
 * 循环执行Sql语句 对Limit 的 控制,不同数据库有所不同，在使用时可先测试一下，Informix已经测试过了
 * @author wangguoying
 *
 */
public class LimitControl {
	private int PageNum = 5000;//每次读取的条数，例如：limit 0,5000
	private int ResideNum = 0;//最后一次的条数
	private int ForNum = 0;//循环的次数
	
	public void setPageNum(int pageNum){this.PageNum = pageNum;}
	public int getPageNum(){return this.PageNum;}
	
	public void setResideNum(int resideNum){this.ResideNum = resideNum;}
	public int getResideNum(){return this.ResideNum;}
	
	public void setForNum(int forNum){this.ForNum = forNum;}
	public int getForNum(){return this.ForNum;}
	
	
	public LimitControl(int allCount){
		int forNum = allCount / PageNum;
		int resideNum = allCount % PageNum;
		if(resideNum!=0) forNum = forNum + 1;
		setResideNum(resideNum);
		setForNum(forNum);
	}
	/**
	 * 
	 * @param allCount：总共条数
	 * @param pageNum：每次读取的条数
	 */
	public LimitControl(int allCount, int pageNum){
		int forNum = allCount / pageNum;
		int resideNum = allCount % pageNum;
		if(resideNum!=0) forNum = forNum + 1;
		setPageNum(pageNum);
		setResideNum(resideNum);
		setForNum(forNum);
	}
	
	public int getStartNum(int curPage){
		return curPage * this.PageNum ;
	}
	
	public int getEndNum(int curPage, String dbtype){
		if(curPage < this.ForNum -1){
			if(dbtype.equals("informix")){
				return this.PageNum;
			}else {
				return (curPage+1) * this.PageNum ;//oralce, mysql
			}
		}else{
			return this.ResideNum;
		}
	}
}
