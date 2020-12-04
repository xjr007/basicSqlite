package college;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SqliteDB {

	Connection c = null;
	Statement stat = null;
	
	SqliteDB() {
		// connect DB
		
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:collegedb.sqlite");
			System.out.println("Database connected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error connecting database");
		}
	}
	
	public void listStudents() {
		try {
			this.stat = c.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * FROM Students");
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String sname = rs.getString("sname");
				int age = rs.getInt("age");
				
				System.out.println(id + " " + fname + " " + sname + " " + age);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error getting students");
		}
	}
	
	// Close list students
	
	public void closeConnection() {
		try {
			c.close();
			System.out.println("Connection closed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void executeQuery(String query) {
		try {
			this.stat = c.createStatement();
			this.stat.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error executing query");
		}
	}

}
