import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String args[]) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        Connection conn = DriverManager.getConnection(url, "drew", "setrabp");
        Statement stmt = conn.createStatement();
        
        String query = "select testcol from test";
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String test = rs.getString("TESTCOL");
            System.out.println(test);
        }
        conn.close();
    }
}