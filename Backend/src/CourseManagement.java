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

    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
    	DatabaseAccess db;
		try {
			db = new DatabaseAccess();
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
	
		RegistrationScene registrationScene = new RegistrationScene(db);
		StudentSelectScene studentSelectScene = new StudentSelectScene(db);
		
		registrationScene.setScene(new ReturnFunction() {
			public void returnToLogin() {
				primaryStage.setScene(studentSelectScene.getScene());
			}
		});
		studentSelectScene.setScene(new LoginFunction() {
			public void login(String globalId) {
				if (globalId != null) {
					registrationScene.setCurrentGlobalId(globalId);
					primaryStage.setScene(registrationScene.getScene());
				}
			}
		});
		
        primaryStage.setTitle("Course Registration App");
        primaryStage.setScene(studentSelectScene.getScene());
        primaryStage.show();
        
        try {
        	db.closeConnection();
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
}