import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String args[]) throws Exception {
        String query = "select FirstName || ' ' || LastName as NAME, SALARY from instructors";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        Connection conn = DriverManager.getConnection(url, "drew", "setrabp");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            String name = rs.getString("NAME");
            int salary = rs.getInt("SALARY");
            System.out.println(name + " earns " + salary);
        }
        conn.close();
    }
}