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

    /**
     * This opens the database connection to swccg_db.sqlite
     * 
     * @return
     * @throws Exception
     */
    private Connection openConnection() throws Exception
    {
	Class.forName("org.sqlite.JDBC");
	return DriverManager.getConnection("jdbc:sqlite:swccg_db.sqlite");
    }
    
/*    private static void createDB()
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
*/    
    /**
     * This function returns a java.awt.List containing all of the
     * cards that match the filters.
     * 
     * String[] - number of items expected = ?
     * 
     * @param filters - an array containing all of the possible filter terms
     */
    public java.awt.List getFilteredList(String[] filters)
    {
	
	
	return null;
    }
    
    /**
     * This function is used to change the number in the users inventory 
     * of a particular card.
     * 
     * @param cardname
     * @param num
     */
    public void updateInventory(String cardname, int num)
    {
	
    }
    
    /**
     * This function returns an integer representing the number of cards
     * a user has in his inventory.
     * 
     * @param cardname
     * @return int
     */
    public int getInventory(String cardname)
    {
	return 0;
    }
    
    /**
     * This funtion returns an int representing the number of cards
     * the user needs.
     * 
     * @param cardname
     * @return int
     */
    public int getNeeds(String cardname)
    {
	return 0;
    }
    
    /**
     * This updates the needs field with the provided int
     * 
     * @param cardname
     * @param num
     */
    public void updateNeeds(String cardname, int num)
    {
	
    }
    
    /**
     * return an array of Strings with each of the fields for the card information
     * (Destiny, lore, gametext, etc.
     * 
     * String[] - number of items expected = ?
     * 
     * @param cardname
     * @return
     */
    public String[] getCardInfo(String cardname)
    {
	
	return null;
    }
    
    /**
     * returns an array of Strings with the extras (cards pulled, pulls, rules, etc.)
     * 
     * String[] - number of items expected = ?
     * 
     * @param cardname
     * @return
     */
    public String[] getCardExtras(String cardname)
    {
	return null;
    }
    
    /**
     * Updates the extras for each card.
     * 
     * String[] - number of items expected = ?
     * 
     * @param cardname
     * @param values
     * @return
     */
    public int updateCardExtras(String cardname, String[] values)
    {
	return 0;
    }
    
    /**
     * Updates the database with the information in values
     * 
     * String[] - number of items expected = ?
     * 
     * @param cardname
     * @param values
     * @return
     */
    public int updateCardInfo(String cardname, String[] values)
    {
	return 0;
    }
    
    /**
     * Allocates a new row for a card. It should assign an id, and all of the
     * information in info to that card
     * 
     * @param cardname
     * @param info
     * @return
     */
    public int addCard(String cardname,String[] info)
    {
	return 0;
    }
    
    /**
     * Removes an entry from the database. Should this remove the id as well?
     * 
     * @param cardname
     * @return
     */
    public int removeCard(String cardname)
    {
	return 0;
    }
    
    /**
     * returns a list of all card names. could be optimized to remove it from java.awt.List, but
     * I dont want to have to loop through all of them twice. Is there a better way?
     * 
     * note, need to change execute query to prepared statement for security reasons
     * 
     * @param cardname
     * @return
     */
    public java.awt.List getCardNames(String cardname)
    {
	Connection conn =  null;
	ResultSet rs = null;
	
	java.awt.List results = null;
	
	try
	{
	    conn = openConnection();
	    Statement stat = conn.createStatement();
	    
	    rs = stat.executeQuery("select cardname from SWD where cardname like \"%" + cardname + "%\" order by cardname asc;");
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
