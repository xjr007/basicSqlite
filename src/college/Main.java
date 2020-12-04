package college;

public class Main {

	public static void main(String [] args) {
		SqliteDB db = new SqliteDB();
		
		String query1 = "INSERT INTO Students (fname, sname, age) VALUES ('Jason', 'Derulo', 22);";
		
		db.executeQuery(query1);
		db.listStudents();
		db.closeConnection();
	}
}
