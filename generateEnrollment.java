import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


class Enrollments {
    public int enrollment1;
    public int enrollment2;
    public int enrollment3;
    public int enrollment4;
    public int enrollment5;
}

public class Main {
		private Connection dbConn;
	
	DatabaseAccess() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        dbConn = DriverManager.getConnection(url, "drew", "setrabp");
	}
	String query = "select * from section";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return rs.getString("testCol");	
	
	public static List<Integer> pickNRandom(List<Integer> lst, int n) {
    List<Integer> copy = new ArrayList<Integer>(lst);
    Collections.shuffle(copy);
    return n > copy.size() ? copy.subList(0, copy.size()) : copy.subList(0, n);
}
    public static void main(String[] args) {
	Map students = new Map();
    	String[] globalIds={"Smit1EZ", "John1OZ", "Will1AZ", "Jone1IZ", "Brow1SZ", "Garc1MZ", "Mill1CZ", "Davi1AZ", "Rodr1HZ", "Mart1EZ", "Hern1AZ", "Lope1EZ", "Gonz1EZ", "Pere1MZ", "Tayl1EZ", "Ande1AZ", "Wils1SZ", "Moor1CZ", "Jack1AZ", "Mart1SZ", "Lee1VZ", "Lewi1MZ", "Walk1LZ", "Hall1GZ", "Alle1CZ", "Youn1PZ", "King1LZ", "Wrig1RZ", "Scot1ZZ", "Gree1NZ", "Bake1LZ", "Adam1EZ", "Nels1HZ", "Cart1LZ", "Mitc1AZ", "Pere1AZ", "Robe1EZ", "Turn1SZ", "Phil1NZ", "Camp1ZZ", "Park1LZ", "Evan1HZ", "Edwa1VZ", "Coll1AZ", "Stew1SZ", "Sanc1AZ", "Morr1BZ", "Roge1BZ", "Reed1CZ", "Cook1SZ", "Bell1PZ", "Murp1EZ", "Bail1AZ", "Rive1CZ", "Coop1NZ", "Rich1GZ", "Cox1EZ", "Howa1KZ", "Ward1SZ", "Torr1MZ", "Pete1WZ", "Gray1KZ", "Rami1NZ", "Jame1AZ", "Wats1EZ", "Broo1SZ", "Kell1AZ", "Sand1AZ", "Pric1GZ", "Benn1AZ", "Wood1MZ", "Barn1CZ", "Ross1RZ", "Hend1EZ", "Cole1SZ", "Jenk1AZ", "Perr1AZ", "Powe1HZ", "Long1GZ", "Patt1VZ", "Hugh1IZ", "Flor1EZ", "Wash1QZ", "Butl1NZ", "Simm1IZ", "Fost1SZ", "Gonz1PZ", "Brya1LZ", "Alex1AZ"};
    	int[] sectionIds=new int[51];
	    for(int i=0;i<51;i++){
	    	sectionIds[i]=i;
	    }
	    
for(int i=0;i<globalIds.length;i++){
	String studentGlobalId=globalIds[i];
	Enrollment enr = new Enrollemnt();
	List<Integer> sections = pickNRandom(sectionIds, 5);
	enr.enrollment1=sections[0];
	enr.enrollment2=sections[1];
	enr.enrollment3=sections[2];
	enr.enrollment4=sections[3];
	enr.enrollment5=sections[4];
	

	
	
	//executeQuery();
}









    }
}
