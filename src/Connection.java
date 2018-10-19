import java.sql.*;
import java.util.ArrayList;

/*
 * Class to connect to the MySQL Database 
 * Similar to the facade class that has a singleton connection that is established 
 * at the beginning of the program. 
 */
public class Connection
{
	private java.sql.Connection connection;
	private static Connection singleton;

	private Connection()
	{
		String host = "jdbc:mysql://sql9.freesqldatabase.com/sql9255339";
		String dbuser = "sql9255339";
		String dbpass = "S8EkeFyZuD";
		try
		{
			this.connection = DriverManager.getConnection(host, dbuser, dbpass);
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getInstance()
	{
		if (singleton == null)
		{
			singleton = new Connection();
		}
		return singleton;
	}

	public java.sql.Connection getConnection()
	{
		return this.connection;
	}

	public ArrayList<Login> getLogin()
	{
		try
		{
			java.sql.Connection con = this.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			// Create an array of all usernames
			ArrayList<Login> userArray = new ArrayList<>();
			while (rs.next())
			{
				String userName = rs.getString("username");
				String password = rs.getString("password");
				String uid = rs.getString("uid");
				Login tempLogin = new Login(userName, password, uid);
				userArray.add(tempLogin);
			}
			System.out.println(userArray);
			return userArray;
		} catch (SQLException error)
		{
			System.out.println(error.getMessage());
			return null;
		}
	}

	public ArrayList<TeeTime> getTeeTimes(int dayToGet)
	{
		try
		{
			java.sql.Connection con = this.getConnection();
			// Prepared statement
			// Select tee times from database
			PreparedStatement stmt = con.prepareStatement("select * from teetime where day = ?");
			stmt.setInt(1, dayToGet);
			ResultSet rs = stmt.executeQuery();
			// Create an array of all tee times
			ArrayList<TeeTime> teeTimeArray = new ArrayList<>();
			while (rs.next())
			{
				String uid = rs.getString("uid");
				String name = rs.getString("name");
				int golfers = rs.getInt("golfers");
				int time = rs.getInt("time");
				String rate = rs.getString("rate");
				int day = rs.getInt("day");
				TeeTime temp = new TeeTime(name, golfers, time, rate, day, uid);
				teeTimeArray.add(temp);
			}
			System.out.println(teeTimeArray);
			return teeTimeArray;
		} catch (SQLException error)
		{
			System.out.println(error.getMessage());
			return null;
		}
	}

	public void addTeeTime(TeeTime teeTime)
	{
		try
		{
			java.sql.Connection con = this.getConnection();
			// Prepared statement
			// Insert teeTime into database
			PreparedStatement stmt = con.prepareStatement("insert into teetime values(\"" + teeTime.getUid() + "\", \""
					+ teeTime.getName() + "\", " + teeTime.getGolfers() + ", " + teeTime.getTime() + ", "
					+ teeTime.getDay() + ",\"" + teeTime.getRate() + "\");");
			stmt.executeUpdate();
		} catch (SQLException error)
		{
			System.out.println(error.getMessage());
		}
	}

}
// End class