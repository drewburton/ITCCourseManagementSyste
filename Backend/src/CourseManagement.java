import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The measurement units for graphics in Java are all in pixels
 */
public class CourseManagement extends Application {
	private ObservableList<String> availableCourses = FXCollections.observableArrayList(
            "Math 101", "History 201", "Science 301", "English 401", "Computer Science 501");

    private ListView<String> courseListView = new ListView<>();
    private ListView<String> registeredCoursesListView = new ListView<>();
    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
    	Connection conn;
		try {
			conn = connectToDatabase();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return;
		}
		
	       // Set up UI components
        Label availableCoursesLabel = new Label("Available Courses:");
        courseListView.setItems(availableCourses);
        courseListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Label registeredCoursesLabel = new Label("Registered Courses:");
        registeredCoursesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        Button registerButton = new Button("Register");
        registerButton.setOnAction(event -> registerCourses());

        // Set up UI layout
        VBox leftBox = new VBox(10, availableCoursesLabel, courseListView);
        VBox rightBox = new VBox(10, registeredCoursesLabel, registeredCoursesListView);
        VBox.setVgrow(courseListView, Priority.ALWAYS);
        VBox.setVgrow(registeredCoursesListView, Priority.ALWAYS);

        HBox centerBox = new HBox(10, leftBox, rightBox);
        centerBox.setPadding(new Insets(10));

        BorderPane root = new BorderPane(centerBox, null, null, registerButton, null);
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Course Registration App");
        primaryStage.setScene(scene);
        primaryStage.show();
        
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
    
    private void registerCourses() {
        ObservableList<String> selectedCourses = courseListView.getSelectionModel().getSelectedItems();
        registeredCoursesListView.getItems().addAll(selectedCourses);
        courseListView.getItems().removeAll(selectedCourses);
        courseListView.getSelectionModel().clearSelection();
    }
}