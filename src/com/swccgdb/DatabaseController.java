package com.swccgdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	Connection tmp = DriverManager.getConnection("jdbc:sqlite:swccg_db.sqlite");
	tmp.setAutoCommit(false);
	return tmp;
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
    public String getCardInfo(String cardname)
    {
	System.out.println(cardname);
	Connection conn =  null;
	ResultSet rs = null;
	String result = null;
	
	try
	{
	    conn = openConnection();
	    String stmt = "select * from swd where cardname = ?";
	    PreparedStatement ps = conn.prepareStatement(stmt);
	    ps.setString(1,cardname);
	    rs = ps.executeQuery();
	    
	    String uniqueness = rs.getString("uniqueness");
	    String name = rs.getString("cardname");
	    String grouping = rs.getString("grouping");
	    String cardtype = rs.getString("cardtype");
	    String subtype = rs.getString("subtype");
	    String modeltype = rs.getString("modeltype");
	    String destiny = rs.getString("destiny");
	    String power = rs.getString("power");
	    String ferocity = rs.getString("ferocity");
	    String creaturedv = rs.getString("creaturedefensevalue");
	    String creaturedvname = rs.getString("creaturedefensevaluename");
	    String objectivefront = rs.getString("objectivefront");
	    String objectiveback = rs.getString("objectiveback");
	    String objectivefrontname = rs.getString("objectivefrontname");
	    String objectivebackname = rs.getString("objectivebackname");
	    String deploy = rs.getString("deploy");
	    String forfeit = rs.getString("forfeit");
	    String armor = rs.getString("armor");
	    String ability = rs.getString("ability");
	    String hyperspeed = rs.getString("hyperspeed");
	    String landspeed = rs.getString("landspeed");
	    String politics = rs.getString("politics");
	    String maneuver = rs.getString("maneuver");
	    String forceapt = rs.getString("forceaptitude");
	    String lore = rs.getString("lore");
	    String gametext = rs.getString("gametext");
	    String jeditestnumber = rs.getString("jeditestnumber");
	    String lsicons = rs.getString("lightsideicons");
	    String dsicons = rs.getString("darksideicons");
	    String lstext = rs.getString("lightsidetext");
	    String dstext = rs.getString("darksidetext");
	    String parsec = rs.getString("parsec");
	    String icons = rs.getString("icons");

	    if(cardtype.equals("Character"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n" +
		    "Power: " + power + " Ability: " + ability + " Armor: " + armor + "\n" + 
		    "Deploy: " + deploy + " Forfeit: " + forfeit + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Effect"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Interrupt"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Defensive Shield"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Admiral's Order"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Jedi Test"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    grouping + "\n" +
		    cardtype + " - " + jeditestnumber + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Creature"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + "\n" +
		    "Icons: " + icons + "\n" +
		    "Ferocity: " + ferocity + " " + creaturedvname + ": " + creaturedv + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Device"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Epic Event"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Podracer"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + "\n" +
		    "Icons: " + icons + "\n\n" +
		    gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Weapon"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + "\n" +
		    "Icons: " + icons + "\n";
		if(!deploy.equals(""))
		    result += "Deploy: " + deploy + " Forfeit: " + forfeit + "\n\n";

		result += "\n" + gametext;
		
		return result;
	    }
	    
	    if(cardtype.equals("Starship"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + modeltype + "\n" +
		    "Icons: " + icons + "\n" +
		    "Power: " + power;
		
		if(subtype.equals("Capital"))
		    result += " Armor: " + armor + " Hyperspeed: " + hyperspeed;
		else
		    result += " Maneuver: " + maneuver + " Hyperspeed: " + hyperspeed;
		
		result += "\n\n" + gametext;
		return result;
	    }
	    
	    if(cardtype.equals("Vehicle"))
	    {
		result = 
		    uniqueness + name + "\t" + destiny + "\n" +
		    lore + "\n\n" + 
		    grouping + "\n" +
		    cardtype + " - " + subtype + " - " + modeltype + "\n" +
		    "Icons: " + icons + "\n" +
		    "Power: " + power;
		
		if(!armor.equals(""))
		    result += " Armor: " + armor + " Landspeed: " + landspeed;
		else
		    result += " Maneuver: " + maneuver + " Landspeed: " + landspeed;
		
		result += "\n\n" + gametext;
		return result;
	    }
	    
	    if(cardtype.equals("Objective"))
	    {
		result = 
		    objectivefrontname + " / " + objectivebackname + "\n" +
		    grouping + "\n" + 
		    "Icons: " + icons + "\n\n" + 
		    gametext;
		return result;
	    }
	    
	    if(cardtype.equals("Location"))
	    {
		result = 
		    uniqueness + name + "\n" + 
		    grouping + "\n" + 
		    "Icons: " + icons + "\n\n" + 
		    "[Light] " + lsicons + "\n" +
		    lstext + "\n\n" + 
		    "[Dark] " + dsicons + "\n" +
		    dstext;
		    
		    
		return result;
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
	return result;
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
	Connection conn =  null;
	ResultSet rs = null;
	String[] result = null;
	
	try
	{
	    conn = openConnection();
	    String stmt = "select * from SWD where cardname = ?";
	    PreparedStatement ps = conn.prepareStatement(stmt);
	    ps.setString(1, cardname);
	    rs = ps.executeQuery();

	    result = new String[14];
	    result[0] = rs.getString("expansion");
	    result[1] = rs.getString("rarity");
	    result[2] = rs.getString("abbreviation");
	    result[3] = rs.getString("counterpart");
	    result[4] = rs.getString("pulls");
	    result[5] = rs.getString("ispulled");
	    result[6] = rs.getString("information");
	    result[7] = rs.getString("characteristics");
	    result[8] = rs.getString("combo");
	    result[9] = rs.getString("rules");
	    result[10] = rs.getString("cancels");
	    result[11] = rs.getString("iscanceledby");
	    result[12] = rs.getString("matching");
	    result[13] = rs.getString("matchingweapon");
	    
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
	return result;
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
     * This function is to export a deck to a holotable formatted file
     */
    public void exportToHolotable(String deck, String path)
    {
	
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
    public List<String> getCardNames(String cardname)
    {
	Connection conn =  null;
	ResultSet rs = null;
	
	List<String> results = new ArrayList<String>();
	
	try
	{
	    conn = openConnection();
	    String stmt = "select cardname from SWD order by cardname asc;";
	    PreparedStatement ps = conn.prepareStatement(stmt);
	    rs = ps.executeQuery();

	    while(rs.next())
	    {
		String item = rs.getString("cardname");
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
