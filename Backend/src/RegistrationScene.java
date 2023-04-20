import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;

@FunctionalInterface
interface ReturnFunction {
	void returnToLogin();
}

public class RegistrationScene {
	private DatabaseAccess db;
	private Scene scene;

    private ListView<String> courseListView = new ListView<>();
    private ListView<String> registeredCoursesListView = new ListView<>();	
    private TextField searchTextField;
    private ComboBox<String> deptComboBox;
    private CheckBox WICheckBox;
    
    private String globalId;
  
	RegistrationScene(DatabaseAccess db) {
		this.db = db;
	}
	
	public void setScene(ReturnFunction func) {
		Label searchLabel = new Label("Search Courses:");
		searchTextField = new TextField();
		Button searchButton = new Button("Search");
		searchButton.setOnAction(event -> search());
		
		Label deptLabel = new Label("Select Department:");
		deptComboBox = new ComboBox<>(db.getDepts());
		
		Label WILabel = new Label("Writing Intensive:");
		WICheckBox = new CheckBox();
		
	     Label availableCoursesLabel = new Label("Available Courses:");
	     courseListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
	     courseListView.getSelectionModel().selectedItemProperty().addListener((ob, old, nu) ->	showCourseInfo(nu));     
	     Label registeredCoursesLabel = new Label("Registered Courses:");
	     registeredCoursesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

	     Label courseInfoLabel = new Label("Course Info:");
	     TextArea courseInfoArea = new TextArea();
	     
	     Button registerButton = new Button("Register");
	     registerButton.setOnAction(event -> registerCourses());
	     
	     Button unregisterButton = new Button("Unregister");
	     unregisterButton.setOnAction(event -> unregisterCourses());

	     Button returnButton = new Button("Return");
	     returnButton.setOnAction(event -> func.returnToLogin());
	     
	     // Set up UI layout
	     HBox searchBox = new HBox(10, searchLabel, searchTextField, searchButton);
	     searchBox.setPadding(new Insets(5));
	     HBox deptBox = new HBox(10, deptLabel, deptComboBox);
	     deptBox.setPadding(new Insets(5));
	     HBox WIBox = new HBox(10, WILabel, WICheckBox);
	     WIBox.setPadding(new Insets(5));
	     
	     VBox coursesBox = new VBox(10, availableCoursesLabel, courseListView);
	     VBox registeredBox = new VBox(10, registeredCoursesLabel, registeredCoursesListView);
	     VBox courseInfoBox = new VBox(10, courseInfoLabel, courseInfoArea);
	     VBox.setVgrow(courseListView, Priority.ALWAYS);
	     VBox.setVgrow(registeredCoursesListView, Priority.ALWAYS);
	     VBox.setVgrow(courseInfoArea, Priority.ALWAYS);
	     HBox buttonsBox = new HBox(10, registerButton, unregisterButton);
	     
	     VBox searchGroup = new VBox(searchBox, deptBox, WIBox);
	     
	     HBox coursesGroup = new HBox(10, coursesBox, registeredBox, courseInfoBox);
	     VBox buttonsGroup = new VBox(10, coursesGroup, buttonsBox);
	     //coursesGroup.setPadding(new Insets(10));
	     
	     VBox fullGroup = new VBox(10, searchGroup, buttonsGroup, returnButton);
	     
	     scene = new Scene(fullGroup, 800, 600);	
	}
	
	public Scene getScene() {
		return scene;
	}

	public void setCurrentGlobalId(String globalId) {
		// todo: update registered courses for that globalId
		this.globalId = globalId;
	}
	
    private void registerCourses() {
    	// todo: access database and add enrollment
        ObservableList<String> selectedCourses = courseListView.getSelectionModel().getSelectedItems();
        registeredCoursesListView.getItems().addAll(selectedCourses);
        courseListView.getSelectionModel().clearSelection();
    }
    
    private void unregisterCourses() {
    	// todo: access database and remove enrollment
    	ObservableList<String> selectedCourses = registeredCoursesListView.getSelectionModel().getSelectedItems();
        registeredCoursesListView.getItems().removeAll(selectedCourses);
        registeredCoursesListView.getSelectionModel().clearSelection();
    }
    
    private void search() {
    	String textFieldContents = searchTextField.getText();
    	String comboBoxContents = deptComboBox.getValue();
    	boolean isWI = WICheckBox.isSelected();
	    courseListView.setItems(db.getCourses(textFieldContents, comboBoxContents, isWI));
    }
    
    private void showCourseInfo(String course) {
    	List<Session> sessions = db.getSessionList(course);
    }
}
