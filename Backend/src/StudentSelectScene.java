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
	void login(String globalId);
}

public class StudentSelectScene {
	private Scene scene;
	
	private DatabaseAccess db;

	private ListView<String> idListView;
	
	StudentSelectScene(DatabaseAccess db) {
		this.db = db;
	}
	
	public void setScene(LoginFunction func) {
		Label idLabel = new Label("Choose a globalId");
		
		idListView = new ListView<>();
		idListView.setItems(db.getGlobalIds());
	    idListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

		Button enterButton = new Button("Enter");
		enterButton.setOnAction(event -> func.login(idListView.getSelectionModel().getSelectedItem()));
		
		Button exitButton = new Button("Exit");
		exitButton.setOnAction(event -> Platform.exit());
		
		// Set up UI layout
         HBox buttonBox = new HBox(10, enterButton, exitButton);

         VBox centerBox = new VBox(10, idLabel, idListView, buttonBox);
         centerBox.setPadding(new Insets(10));
          
         HBox.setHgrow(enterButton, Priority.ALWAYS);
         HBox.setHgrow(exitButton, Priority.ALWAYS);

         scene = new Scene(centerBox, 400, 300);
	}
	
	public Scene getScene() {
		return scene;
	}
}
