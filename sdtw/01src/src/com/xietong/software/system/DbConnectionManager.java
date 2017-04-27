// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DbConnectionManager.java

package com.xietong.software.system;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbConnectionManager
{
	private static ComboPooledDataSource cpds  = null;
    public DbConnectionManager()
    {
    }

    public static Connection getConnection(String jndiName)
        throws SQLException
    {
        Connection con = null;
        try
        {
        	
            Context initCtx = new InitialContext();
            Context envCtx = (Context)initCtx.lookup("java:comp/env");
            DataSource ds = (DataSource)envCtx.lookup(jndiName);
            con = ds.getConnection();
            
        	//业务代码
            if(con == null)
                System.err.println("WARNING: ConnectionManager.getConnection() failed to obtain a connection.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
    }
}
