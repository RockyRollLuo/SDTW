package com.xietong.software.common;

import java.util.List;

public interface DaoBase
{
    public String getDBNAME();
    public String getPKey();
    public String[] getAllFields();
    public String[] getDateFields();
    public String getDbType();
    public String toDbCh(String str);
    public String fromDbCh(String str);
    public List query(List cdt);
    public int getCount(List cdt);
    public void setTableName(String str);
    //public int getId();
}
