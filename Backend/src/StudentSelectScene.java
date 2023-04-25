import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Timeline;

@FunctionalInterface
interface LoginFunction {
	boolean login(String globalId, String password);
}

public class StudentSelectScene {
	private Scene scene;
	
	public void setScene(LoginFunction func) {
		Label idLabel = new Label("Enter your username and password");
		
		TextField usernameTextField = new TextField();
		usernameTextField.setPromptText("username");

		PasswordField passwordField = new PasswordField();
		passwordField.setPromptText("password");
	
		Label errorLabel = new Label("Incorrect username or password");
		errorLabel.setTextFill(Color.RED);
		errorLabel.setVisible(false);
	
		Timeline timeline = new Timeline();
		KeyFrame showErrorLabel = new KeyFrame(Duration.seconds(3), event -> {
			errorLabel.setVisible(false);
			timeline.stop();
		});
		timeline.getKeyFrames().add(showErrorLabel);
		timeline.setCycleCount(3);
				
		Button loginButton = new Button("Login");
		loginButton.setOnAction(event -> {
			if (!func.login(usernameTextField.getText(), passwordField.getText())) {
				errorLabel.setVisible(true);
				timeline.play();
			}
		});
		
		Button exitButton = new Button("Exit");
		exitButton.setOnAction(event -> Platform.exit());
	

		
		// Set up UI layout
         HBox buttonBox = new HBox(10, loginButton, exitButton);

         VBox centerBox = new VBox(10, idLabel, usernameTextField, passwordField, buttonBox, errorLabel);
         centerBox.setAlignment(Pos.CENTER);
         centerBox.setPadding(new Insets(10));
          
         HBox.setHgrow(loginButton, Priority.ALWAYS);
         HBox.setHgrow(exitButton, Priority.ALWAYS);

         scene = new Scene(centerBox, 400, 300);
	}
	
	public Scene getScene() {
		return scene;
	}
}
