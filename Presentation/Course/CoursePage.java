package Presentation.Course;

import Presentation.CreateNewScene;
import Presentation.HomePage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CoursePage {

  private static int buttonWidth = 120;
  private static int buttonHeight = 50;

  // Method to create and return a gridpane with buttons for the studentpage
  public static GridPane createCoursePage() {

    // Create button list
    GridPane CourseScreen = new GridPane();
    CourseScreen.setHgap(20);
    CourseScreen.setVgap(20);
    CourseScreen.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Course");
    title.setStyle("-fx-font: 24 arial;");
    CourseScreen.add(title, 0, 0, 2, 1);

    // Label for text
    Label text = new Label("Select what you would like to do or view");
    text.setStyle("-fx-font: 14 arial;");
    CourseScreen.add(text, 0, 1, 2, 1);

    // To view different modules
    Button modulesBtn = new Button("View Modules");
    CourseScreen.add(modulesBtn, 0, 2);
    // modulesBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(modulesBtnStudentForm.studentForm())));
    modulesBtn.setMinSize(buttonWidth, buttonHeight);

    // To sign up a new student
    Button signupBtn = new Button("Sign-up");
    CourseScreen.add(signupBtn, 1, 2);
    // signupBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(signupBtnStudentForm.studentForm())));
    signupBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button home = new Button("Homepage");
    CourseScreen.add(home, 0, 3);
    home.setOnAction(e -> CreateNewScene.changeScene(new Scene(HomePage.setHomePage())));
    home.setMinSize(buttonWidth, buttonHeight);

    CourseScreen.setAlignment(Pos.CENTER);

    return CourseScreen;
  }
}
