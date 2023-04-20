import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseAccess {
	private Connection dbConn;
	private final String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
	
	DatabaseAccess() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        dbConn = DriverManager.getConnection(url, "drew", "setrabp");
	}
	
	public void closeConnection() throws SQLException {
		dbConn.close();
	}
	
	public ObservableList<String> getGlobalIds() {
		reopenConnectionIfClosed();
		
		String query = "select globalId from students";
		
		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    ObservableList<String> globalIds = FXCollections.observableArrayList();
		    while (rs.next()) {
		    	globalIds.add(rs.getString("globalId"));
		    }
		    return globalIds;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("globalId retrieval SQL query failed");
			System.out.println(query);
			return FXCollections.observableArrayList();
		}
	}
	
	public ObservableList<String> getCourses(String search, String depts, boolean isWI) {
		reopenConnectionIfClosed();
		
		String query = "select fullCourseId from (select department || ' ' || courseId fullCourseId, IsWritingIntensive, department from courses)";
		if (!search.equals("") || (depts != null && !depts.equals("")) || isWI) {
			query += " where ";
		}
		if (!search.equals("")) {
			query += "fullCourseId like \'%" + search + "%\' and ";
		}
		if (depts != null && !depts.equals("")) {
			query += "department = \'" + depts + "\' and ";
		}
		if (isWI) {
			query += "IsWritingIntensive <> 0";
		}
		
		if (query.endsWith("and ")) {
			query = query.substring(0, query.length() - 4);
		}
		
		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    ObservableList<String> sessions = FXCollections.observableArrayList();
		    while (rs.next()) {
		    	sessions.add(rs.getString("fullCourseId"));
		    }
		    return sessions;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("course search SQL query failed");
			System.out.println(query);
			return FXCollections.observableArrayList();
		}
	}
	
	public ObservableList<String> getDepts() {
		ObservableList<String> depts = FXCollections.observableArrayList("", "CPS", "MAT", "BIO");
		return depts;
	}
	
	public List<Session> getSessionList(String course) {
//		"select Department || ' ' || CourseId fullId from courses where fullId = course;"
		return null;
	}
	
	private void reopenConnectionIfClosed() {
		try {
			if (dbConn == null || !dbConn.isValid(1000)) {
				dbConn = DriverManager.getConnection(url, "drew", "setrabp");
				System.out.println("reopening connection");
			}
		} catch (SQLException e) {
			System.out.println("cannot reopen connection");
		}
	}
}
