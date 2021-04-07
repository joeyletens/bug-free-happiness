package Presentation;

import Presentation.Student.CreateStudentForm;
import Presentation.Student.StudentPage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

// Class to create the GUI's homepage
public class HomePage {

  // Standard button sizes
  private static int buttonWidth = 100;
  private static int buttonHeight = 50;

  // Class to return a borderpane of the HomePage, return a layout
  public static BorderPane setHomePage() {

    // Create layouts
    BorderPane mainLayout = new BorderPane();

    // Create button list
    GridPane buttonList = new GridPane();
    buttonList.setHgap(20);
    buttonList.setVgap(20);
    buttonList.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("CodeCademy");
    title.setStyle("-fx-font: 24 arial;");
    buttonList.add(title, 0, 0, 3, 1);

    // Label for text
    Label text = new Label("Select what you would like to change/view/delete/create");
    text.setStyle("-fx-font: 14 arial;");
    buttonList.add(text, 0, 1, 3, 1);

    // Button to add student
    Button studentBtn = new Button("Student");
    buttonList.add(studentBtn, 0, 2);
    studentBtn.setOnAction(e -> CreateNewScene.changeScene(new Scene(StudentPage.studentCRUD())));
    studentBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to registration page
    Button registrationBtn = new Button("Registration");
    buttonList.add(registrationBtn, 1, 2);
    registrationBtn.setOnAction(e -> CreateNewScene.changeScene(new Scene(CreateStudentForm.studentForm())));
    registrationBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button statisticsBtn = new Button("Statistics");
    buttonList.add(statisticsBtn, 2, 2);
    statisticsBtn.setMinSize(buttonWidth, buttonHeight);

    // Set layout
    mainLayout.setCenter(buttonList);

    return mainLayout;
  }

}
