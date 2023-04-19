import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
