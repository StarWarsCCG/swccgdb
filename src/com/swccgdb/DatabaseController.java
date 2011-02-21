package com.swccgdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController
{
    DatabaseController()
    {
    }

    private Connection openConnection() throws Exception
    {
	Class.forName("org.sqlite.JDBC");
	return DriverManager.getConnection("jdbc:sqlite:swccg_db.sqlite");
    }
    
    private static void createDB()
    {
	Connection conn2 = null;
	try
	{
    	    Class.forName("org.sqlite.JDBC");
    	    conn2 = DriverManager.getConnection("jdbc:sqlite:swccg_usrinfo.sqlite");
    	    
    	    
    	    
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
		conn2.close();
	    }
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
    }
    
    public static void main(String[] args)
    {
	createDB();
    }
    
    public java.awt.List getFilteredList(String[] args)
    {
	
	
	return null;
    }
    
    public void updateInventory(String cardname)
    {
	
    }
    
    public int getInventory(String cardname)
    {
	return 0;
    }
    
    public int getNeeds(String cardname)
    {
	return 0;
    }
    
    public void updateNeeds(String cardname)
    {
	
    }
    
    public String[] getCardInfo(String cardname)
    {
	
	return null;
    }
    
    public String[] getCardExtras(String cardname)
    {
	return null;
    }
    
    public int updateCardExtras(String cardname)
    {
	return 0;
    }
    
    public int updateCardInfo(String cardname)
    {
	return 0;
    }
    
    public int addCard(String cardname,String[] info)
    {
	return 0;
    }
    
    public int removeCard(String cardname)
    {
	return 0;
    }
    
    public java.awt.List getCardNames(String cardname)
    {
	Connection conn =  null;
	ResultSet rs = null;
	
	java.awt.List results = null;
	
	try
	{
	    conn = openConnection();
	    Statement stat = conn.createStatement();
	    
	    rs = stat.executeQuery("select cardname from SWD order by cardname asc;");
	    results = new java.awt.List();
	    while(rs.next())
	    {
		String item = rs.getString("cardname");
		System.out.println(item);
		results.add(item);
	    }
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	finally
	{
	    try
	    {
		rs.close();
		conn.close();
	    }
	    catch (SQLException e)
	    {
		e.printStackTrace();
	    }
	}
	
	return results;
    }
}
