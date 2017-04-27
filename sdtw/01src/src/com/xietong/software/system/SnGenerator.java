// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SnGenerator.java

package com.xietong.software.system;

import java.sql.*;
import java.util.*;

// Referenced classes of package com.xietong.software.system:
//            DbConnectionManager

public class SnGenerator
{

    private static Map database = new HashMap();

    public SnGenerator(String jndiName)
        throws SQLException
    {
        Connection con = null;
        java.sql.PreparedStatement pstmt = null;
        try
        {
            con = DbConnectionManager.getConnection(jndiName);
            setMaxsn(con);
        }
        catch(SQLException sqle)
        {
            sqle.printStackTrace();
        }
        finally
        {
            try
            {
                con.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static int getSn(String tn)
    {
        int iCurrentSn = 0;
        if(tn == null)
        {
            return iCurrentSn;
        } else
        {
            Integer iTmp = (Integer)database.get(tn);
            iCurrentSn = iTmp.intValue();
            int iSn = iCurrentSn + 1;
            database.put(tn, new Integer(iSn));
            return iCurrentSn;
        }
    }

    public static int getSn(Connection con, String tn)
    {
        return getSn(tn);
    }

    private void setMaxsn(Connection con)
        throws SQLException
    {
        Statement pstmt = con.createStatement();
        Vector vrs = new Vector();
        String tname = "";
        int sn;
        for(ResultSet rs = pstmt.executeQuery("SELECT TNAME FROM TAB"); rs.next(); database.put(tname, new Integer(sn)))
        {
            tname = rs.getString(1);
            String cname = getFirstCol(con, tname);
            sn = getMaxsn(con, tname, cname);
        }

        Object obj = null;
    }

    private String getFirstCol(Connection con, String tname)
        throws SQLException
    {
        Statement pstmt = con.createStatement();
        String cname = "";
        ResultSet rs = pstmt.executeQuery("SELECT CNAME FROM COL WHERE TNAME='" + tname + "' ORDER BY COLNO");
        if(rs.next())
            cname = rs.getString(1);
        rs = null;
        return cname;
    }

    private int getMaxsn(Connection con, String tname, String cname)
        throws SQLException
    {
        String Select = "SELECT MAX(" + cname + ") FROM " + tname;
        Statement sel = con.createStatement();
        ResultSet rs = sel.executeQuery(Select);
        int sn;
        if(rs.next())
            sn = rs.getInt(1) + 1;
        else
            sn = 1;
        rs = null;
        return sn;
    }

}
