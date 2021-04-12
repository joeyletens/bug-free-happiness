package Presentation.Course;

import Presentation.CreateNewScene;
import Presentation.PresentationInf;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CoursePage implements PresentationInf {

  private int buttonWidth = 120;
  private int buttonHeight = 50;

  // Method to create and return a gridpane with buttons for the studentpage
  public GridPane GUI() {
    CreateNewScene createNewScene = new CreateNewScene();

    // Create button list
    GridPane courseScreen = new GridPane();
    courseScreen.setHgap(20);
    courseScreen.setVgap(20);
    courseScreen.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Course");
    title.setStyle("-fx-font: 24 arial;");
    courseScreen.add(title, 0, 0, 2, 1);

    // Label for text
    Label text = new Label("Select what you would like to do or view");
    text.setStyle("-fx-font: 14 arial;");
    courseScreen.add(text, 0, 1, 2, 1);

    // To view different modules
    Button modulesBtn = new Button("View Modules");
    courseScreen.add(modulesBtn, 0, 2);
    // modulesBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(modulesBtnStudentForm.studentForm())));
    modulesBtn.setMinSize(buttonWidth, buttonHeight);

    // To sign out a studentS
    Button signoutBtn = new Button("Sign out");
    courseScreen.add(signoutBtn, 0, 3);
    // signoutBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(signoutBtnStudentForm.studentForm())));
    signoutBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button home = new Button("Homepage");
    courseScreen.add(home, 1, 3);
    home.setOnAction(e -> createNewScene.setHomePage());
    home.setMinSize(buttonWidth, buttonHeight);

    courseScreen.setAlignment(Pos.CENTER);

    return courseScreen;
  }
}
