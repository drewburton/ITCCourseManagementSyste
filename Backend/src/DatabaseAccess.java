import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		reopenConnectionIfClosed();
		
		String query = "select distinct department from courses";

		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    ObservableList<String> depts = FXCollections.observableArrayList();
		    while (rs.next()) {
		    	depts.add(rs.getString("department"));
		    }
		    if (depts.size() > 0) {
		    	depts.add(0, "");
		    }
		    return depts;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("depts retrieval SQL query failed");
			System.out.println(query);
			return FXCollections.observableArrayList();
		}
	}
	
	public Course getCourseInfo(String course) {
		reopenConnectionIfClosed();
		
		String query = "select title, isWritingIntensive, creditHours from (select department || ' ' || courseId fullId, title, isWritingIntensive, CreditHours from courses) where fullId = \'" + course + "\'";
		
		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    rs.next();
		    String title = rs.getString("title");
		    boolean isWI = rs.getInt("isWritingIntensive") != 0;
		    int creditHours = rs.getInt("creditHours");
		    	
		    return new Course(title, isWI, creditHours);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("session info retrieval SQL query failed");
			System.out.println(query);
			return null;
		}

	}
	
	public ObservableList<Session> getSessionList(String course) {
		// TODO: finish
		reopenConnectionIfClosed();
		
		String query = "";
		
		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    ObservableList<Session> sessions = FXCollections.observableArrayList();
		    while (rs.next()) {
		    	Session s = new Session(0, 0, 0, "", "", "");
		    	sessions.add(s);
		    }
		    return sessions;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("session info retrieval SQL query failed");
			System.out.println(query);
			return FXCollections.observableArrayList();
		}
	}
	
	public boolean registerCourse(String globalId, String course, Session session) {
		// TODO: implement
		return false;
	}

	public void unregisterCourse(String globalId, String course) {
		// TODO: implement
	}
	
	public ObservableList<String> getRegisteredCourses(String globalId) {
		// TODO: Test once sessions are inserted
		reopenConnectionIfClosed();
		
		String query = "select c.department || ' ' || c.courseId fullId from courses c, sessions s, enrollment e where "
				+ "e.StudentGlobalId = \'" + globalId + "\' and e.SessionId = s.SessionId and s.CourseId = c.CourseId";
		
		try {
			Statement stmt = dbConn.createStatement();
		    ResultSet rs = stmt.executeQuery(query);
		    ObservableList<String> courses = FXCollections.observableArrayList();
		    while (rs.next()) {
		    	courses.add(rs.getString("fullId"));
		    }
		    return courses;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("registered courses retrieval SQL query failed");
			System.out.println(query);
			return FXCollections.observableArrayList();
		}
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
