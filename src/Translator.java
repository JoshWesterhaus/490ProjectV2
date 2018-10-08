/*
 * This class handles all communication between the tee sheet and the database.
 * It will receive the tee times as an object to send to the database
 * It will receive a day(int) and return an ArrayList of TeeTimes that match the day
 * 
 */

import java.util.ArrayList;

public class Translator
{
	/**
	 * getTestTeeTimes - Used as a tester class for the remainder of the program
	 * 
	 * @param day - Day to retrieve
	 * @return - An ArrayList of TeeTimes for the day requested
	 */
	public static ArrayList<TeeTime> getTestTeeTimes(int day)
	{
		// String name, int golfers, int time, String rate, int day, String uid

		// Create a bunch of tee times
		TeeTime test1 = new TeeTime("Smith", 4, 730, "Regular", 1, "Josh101");
		TeeTime test2 = new TeeTime("Johnson", 4, 750, "Regular", 1, "Josh101");
		TeeTime test3 = new TeeTime("Franks", 4, 1230, "Internet", 1, "Josh101");
		TeeTime test4 = new TeeTime("Williams", 4, 700, "Regular", 2, "Josh101");
		TeeTime test5 = new TeeTime("Stine", 4, 730, "Hotel", 2, "Josh101");
		TeeTime test6 = new TeeTime("Boyer", 2, 740, "Internet", 2, "Josh101");
		TeeTime test7 = new TeeTime("Cooper", 1, 740, "Regular", 2, "Josh101");

		// Add them to ArrayList

		ArrayList<TeeTime> test = new ArrayList<>();
		test.add(test1);
		test.add(test2);
		test.add(test3);
		test.add(test4);
		test.add(test5);
		test.add(test6);
		test.add(test7);

		// Get rid of the days that are not asked for
		for (int i = 0; i < test.size(); i++)
		{
			if (test.get(i).getDay() != day)
			{
				test.remove(i);
				i--;
			}
		}

		return test;

	} // End getTestTeeTimes

	public static boolean goodLogin(String userName, String password)
	{
		Connection login = Connection.getInstance();
		ArrayList<Login> temp = login.getLogin();
		boolean good = false;
		for (int i = 0; i < temp.size(); i++)
		{
			if (temp.get(i).getUserName().equals(userName) && temp.get(i).getPassword().equals(password))
			{
				good = true;
				return good;
			}
		}
		return good;
	}

	public static String getUid(String userName, String password)
	{
		Connection login = Connection.getInstance();
		ArrayList<Login> temp = login.getLogin();
		for (int i = 0; i < temp.size(); i++)
		{
			if (temp.get(i).getUserName().equals(userName) && temp.get(i).getPassword().equals(password))
			{
				return temp.get(i).getUID();
			}
		}
		return "";
	}
	
	// Method for getting TeeTimes given a day
	// public static ArrayList<TeeTimes> getTeeTimes(int day)
	
	// Method for adding a TeeTime given a day and time
	// public static void addTeeTime(TeeTime teeTime)
	
	// Method for editing an existing TeeTime given that
	// public static void editTeeTime(TeeTime teeTime)
	
	/**
	 * timeIsAvailable - Gives a time to check the database against to see if the
	 * time is available for the number of golfers
	 * 
	 * @param timeToCheck - The time of the tee time to check as an int
	 * @param tempGolfers - The number of golfers to check at that time as an int
	 * @return a boolean true only if the number to add plus what exists, does not
	 *         exceed four
	 */
	public static boolean timeIsAvailable(int timeToCheck, int tempGolfersToAdd)
	{
		/*
		 * Method to query database for time and add it to four and such here, something
		 * like... int existingGolfers = Connection.checkTeeTime(timeToCheck);
		 * if((existingGolfers + tempGolfers) > 4) return false;
		 */

		return true;
	} // End timeIsAvailable
	
} // End class
