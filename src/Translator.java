
/*
 * This class handles all communication between the tee sheet and the database.
 * It will receive the tee times as an object to send to the database
 * It will receive a day(int) and return an ArrayList of TeeTimes that match the day
 * 
 */

import java.util.ArrayList;

public class Translator {
	/**
	 * getTeeTimes - Retrieves an ArrayList of TeeTime objects from the connection
	 * class and returns the ArrayList sorted by time.
	 * 
	 * @param day - Day to retrieve
	 * @return - An ArrayList of TeeTimes for the day requested
	 */
	public static ArrayList<TeeTime> getTeeTimes(int day) {
		Connection con = Connection.getInstance();
		ArrayList<TeeTime> teeArray = con.getTeeTimes(day);
		int s = teeArray.size();
		TeeTime temp;
		for (int i = 0; i < s; i++) {
			for (int j = 1; j < (s - i); j++) {
				System.out.println(j);
				if (teeArray.get(j - 1).getTime() > teeArray.get(j).getTime()) {
					temp = teeArray.get(j - 1);
					teeArray.set(j - 1, teeArray.get(j));
					teeArray.set(j, temp);
				}
			}
		}
		return teeArray;
	} // End getTeeTimes

	public static boolean goodLogin(String userName, String password) {
		Connection login = Connection.getInstance();
		ArrayList<Login> temp = login.getLogin();
		boolean good = false;
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getUserName().equals(userName) && temp.get(i).getPassword().equals(password)) {
				good = true;
				return good;
			}
		}
		return good;
	}

	public static String getUid(String userName, String password) {
		Connection login = Connection.getInstance();
		ArrayList<Login> temp = login.getLogin();
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).getUserName().equals(userName) && temp.get(i).getPassword().equals(password)) {
				return temp.get(i).getUID();
			}
		}
		return "";
	}

	// Method for adding a TeeTime given a day and time
	public static void addTeeTime(TeeTime teeTime) {
		Connection con = Connection.getInstance();
		con.addTeeTime(teeTime);
	}

	// Method for editing an existing TeeTime given that
	public static void editTeeTime(TeeTime teeTime) {
		
	}

	/**
	 * timeIsAvailable - Gives a time to check the database against to see if the
	 * time is available for the number of golfers
	 * 
	 * @param timeToCheck - The time of the tee time to check as an int
	 * @param tempGolfers - The number of golfers to check at that time as an int
	 * @return a boolean true only if the number to add plus what exists, does not
	 *         exceed four
	 */
	public static boolean timeIsAvailable(int timeToCheck, int tempGolfersToAdd) {
		/*
		 * Method to query database for time and add it to four and such here, something
		 * like... int existingGolfers = Connection.checkTeeTime(timeToCheck);
		 * if((existingGolfers + tempGolfers) > 4) return false;
		 */

		return true;
	} // End timeIsAvailable

} // End class
