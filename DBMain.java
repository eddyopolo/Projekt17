package pro17;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBMain {

	private static Connection connect = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private static String database;
	public static int i;
	private static String tempArray[][] = new String[100][3];
	public static String ArtikelArray[][];

	public static String kdnr;
	public static String iden;
	public static int bmen;
	public static Object preis;
	public static String actioncode;
	public static String where_condition;

	public static void main(String mode, String action_code, String wherecondition, String KDNR, String IDEN, int BMEN, int Preis) {
		i = 0;
		kdnr = KDNR;
		iden = IDEN;
		bmen = BMEN;
		preis = Preis;
		actioncode = action_code;
		where_condition = wherecondition;
		if (mode.equalsIgnoreCase("read")) {
			if (action_code.equalsIgnoreCase("warenkorb")) {
				database = "warenkorb";
			} else if (action_code.equalsIgnoreCase("kunden")) {
				database = "kunden";
			} else if (action_code.equalsIgnoreCase("artikel")) {
				database = "artikel";
			}
			Start();
			Read();
		} else if (mode.equalsIgnoreCase("write")) {
			if (action_code.equalsIgnoreCase("warenkorb")) {
				database = "warenkorb";
			} else if (action_code.equalsIgnoreCase("kunden")) {
				database = "kunden";
			} else if (action_code.equalsIgnoreCase("artikel")) {
				database = "artikel";
			}
			Write();
		}
	}

	private static ResultSet Write() {
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.43.167/projekt17?" + "user=projekt17&password=projekt17");
			// connect =
			// DriverManager.getConnection("jdbc:mysql://192.168.2.160/projekt17?"
			// + "user=projekt17&password=projekt17");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			// in 1. klammer die felder danach erst die werte
			@SuppressWarnings("unused")
			int update_record = statement.executeUpdate("INSERT INTO `warenkorb`(`KDNR`, `IDEN`, `BMEN`, `PREIS`) VALUES ( '" + kdnr + "', '" + iden + "', '" + bmen + "', '" + preis + "')");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;

	}

	public static ResultSet Start() {

		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://192.168.43.167/projekt17?" + "user=projekt17&password=projekt17");
			// connect =
			// DriverManager.getConnection("jdbc:mysql://192.168.2.160/projekt17?"
			// + "user=projekt17&password=projekt17");

			// Statements allow to issue SQL queries to the database
			statement = connect.createStatement();

			// Result set get the result of the SQL query
			resultSet = statement.executeQuery("select * from projekt17." + database + " " + where_condition);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	protected static void Read() {
		// If we are getting success from server
		if (resultSet != null) {
			try {
				while (resultSet.next()) {
					if (i < tempArray.length) {
						if (actioncode.equalsIgnoreCase("artikel")) {
							tempArray[i][0] = (resultSet.getString("IDEN"));
							tempArray[i][1] = (resultSet.getString("BEZ"));
							tempArray[i][2] = (resultSet.getString("Preis"));
						}
						i++;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

			ArtikelArray = new String[i][3];
			for (int j = 0; j < ArtikelArray.length; j++) {
				if (actioncode.equalsIgnoreCase("artikel")) {
					ArtikelArray[j][0] = String.valueOf(tempArray[j][0]);
					ArtikelArray[j][1] = tempArray[j][1];
					ArtikelArray[j][2] = String.valueOf(tempArray[j][2]);
					System.out.println(String.valueOf(tempArray[j][0]));
				}
			}

			try {
				for (int l = 0; l < 3; l++) {
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// You need to close the resultSet
	private static void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}