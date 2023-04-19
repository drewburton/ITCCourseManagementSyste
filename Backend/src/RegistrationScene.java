import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class RegistrationScene {
	private Scene scene;
	private ObservableList<String> availableCourses = FXCollections.observableArrayList(
            "Math 101", "History 201", "Science 301", "English 401", "Computer Science 501");

    private ListView<String> courseListView = new ListView<>();
    private ListView<String> registeredCoursesListView = new ListView<>();	
    
	RegistrationScene(DatabaseAccess db) {
     Label availableCoursesLabel = new Label("Available Courses:");
     courseListView.setItems(availableCourses);
     courseListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

     Label registeredCoursesLabel = new Label("Registered Courses:");
     registeredCoursesListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

     Button registerButton = new Button("Register");
     registerButton.setOnAction(event -> registerCourses());
     
     Button unregisterButton = new Button("Unregister");
     unregisterButton.setOnAction(event -> unregisterCourses());

     // Set up UI layout
     VBox leftBox = new VBox(10, availableCoursesLabel, courseListView, registerButton);
     VBox rightBox = new VBox(10, registeredCoursesLabel, registeredCoursesListView, unregisterButton);
     VBox.setVgrow(courseListView, Priority.ALWAYS);
     VBox.setVgrow(registeredCoursesListView, Priority.ALWAYS);

     HBox centerBox = new HBox(10, leftBox, rightBox);
     centerBox.setPadding(new Insets(10));

     scene = new Scene(centerBox, 400, 300);
	}
	
	public Scene getScene() {
		return scene;
	}
	
    private void registerCourses() {
        ObservableList<String> selectedCourses = courseListView.getSelectionModel().getSelectedItems();
        registeredCoursesListView.getItems().addAll(selectedCourses);
        courseListView.getItems().removeAll(selectedCourses);
        courseListView.getSelectionModel().clearSelection();
    }
    
    private void unregisterCourses() {
    	ObservableList<String> selectedCourses = registeredCoursesListView.getSelectionModel().getSelectedItems();
        courseListView.getItems().addAll(selectedCourses);
        registeredCoursesListView.getItems().removeAll(selectedCourses);
        registeredCoursesListView.getSelectionModel().clearSelection();
    }
}
