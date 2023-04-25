import java.sql.SQLException;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The measurement units for graphics in Java are all in pixels
 */
public class CourseManagement extends Application {
	private static HashMap<String, String> passwordMap = new HashMap<>();

    
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
    	if (passwordMap.isEmpty())
    		parsePasswords();
    	
    	DatabaseAccess db;
		try {
			db = new DatabaseAccess();
		} catch (Exception e1) {
			e1.printStackTrace();
			return;
		}
	
		RegistrationScene registrationScene = new RegistrationScene(db);
		StudentSelectScene studentSelectScene = new StudentSelectScene();
		
		registrationScene.setScene(new ReturnFunction() {
			public void returnToLogin() {
				primaryStage.setScene(studentSelectScene.getScene());
			}
		});
		studentSelectScene.setScene(new LoginFunction() {
			public boolean login(String globalId, String password) {
				if (globalId != null && passwordMap.containsKey(globalId) && passwordMap.get(globalId).equals(password)) {
					registrationScene.setCurrentGlobalId(globalId);
					primaryStage.setScene(registrationScene.getScene());
					return true;
				}
				return false;
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
    
    private static void parsePasswords() {
    	File f = new File(System.getProperty("user.dir") + "\\src\\LoginInfo.txt");
    	try (Scanner s = new Scanner(f)) {
    		while (s.hasNextLine()) {
    			String[] loginInfo = s.nextLine().split(",");
    			passwordMap.put(loginInfo[0], loginInfo[1]);
    		}
    	} catch (FileNotFoundException e) {
    		System.out.println("Could not parse password file");
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