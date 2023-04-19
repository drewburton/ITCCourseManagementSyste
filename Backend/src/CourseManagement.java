import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The measurement units for graphics in Java are all in pixels
 */
public class CourseManagement extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
    	Connection conn;
		try {
			conn = connectToDatabase();
			Scene scene = createScene(getTestCol(conn));
			primaryStage.setTitle("Course Management System"); // Set the stage title
			primaryStage.setScene(scene); // Place the scene in the stage
			primaryStage.show(); // Display the stage
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
		        
        try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Connection connectToDatabase() throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        String url = "jdbc:oracle:thin:@localhost:1521/pdborcl";
        Connection conn = DriverManager.getConnection(url, "drew", "setrabp");
        return conn;
        

    }
    
    public static String getTestCol(Connection conn) throws Exception {
        String query = "select testCol from test";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        return rs.getString("testCol");	
    }
    
    public static Scene createScene(String val) {
        // Create a TextField
        TextField textField = new TextField();

        // Set the text to "hello"
        textField.setText(val);

        // Make the TextField unmodifiable
        textField.setEditable(false);        
                
        // Create a pane to hold the circle
        StackPane pane = new StackPane();
        pane.getChildren().add(textField);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 200);
        return scene;
    }
}