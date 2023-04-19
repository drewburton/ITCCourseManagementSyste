import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DatabaseAccess {
	private Connection dbConn;
	
	DatabaseAccess() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        dbConn = DriverManager.getConnection(url, "drew", "setrabp");
	}
	
	public void closeConnection() throws SQLException {
		dbConn.close();
	}
	
	public ObservableList<String> getGlobalIds() {
		List<String> globalIds = Arrays.asList(new String[]{"Smit1EZ", "John1OZ", "Will1AZ"});
		return FXCollections.observableList(globalIds);
	}
	
	public ObservableList<String> getCourses() {
		ObservableList<String> availableCourses = FXCollections.observableArrayList(
	            "Math 101", "History 201", "Science 301", "English 401", "Computer Science 501");
		return availableCourses;
	}
	
	public ObservableList<String> getDepts() {
		ObservableList<String> depts = FXCollections.observableArrayList("", "CPS", "MAT", "BIO");
		return depts;
	}
}
