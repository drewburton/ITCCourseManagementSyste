import java.sql.SQLException;

import javafx.application.Application;
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