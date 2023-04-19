import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface LoginFunction {
	void login();
}

public class StudentSelectScene {
	private Scene scene;
	private List<String> globalIds = Arrays.asList(new String[]{"Smit1EZ", "John1OZ", "Will1AZ"});
	
	private TextField idTextField;
	private Label errorLabel;
	
	private DatabaseAccess db;
	
	StudentSelectScene(DatabaseAccess db, LoginFunction func) {
		this.db = db;
		
		idTextField = new TextField();
		idTextField.setPromptText("Enter your globalId");
		
		Button enterButton = new Button("Enter");
		enterButton.setOnAction(event -> func.login());
		
		Button exitButton = new Button("Exit");
		exitButton.setOnAction(event -> Platform.exit());
		
		errorLabel = new Label("Incorrect globalId. Please try again.");
		errorLabel.setVisible(false);

		// Set up UI layout
          HBox buttonBox = new HBox(10, enterButton, exitButton);

          VBox centerBox = new VBox(10, idTextField, buttonBox, errorLabel);
          centerBox.setPadding(new Insets(10));
          
          HBox.setHgrow(enterButton, Priority.ALWAYS);
          HBox.setHgrow(exitButton, Priority.ALWAYS);

          scene = new Scene(centerBox, 400, 300);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	public boolean verifyLogin() {
		return globalIds.contains(idTextField.getText()); 
	}
}
