package Presentation;

import Presentation.Student.CreateStudentForm;
import Presentation.Student.studentPage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class HomePage {

  public static BorderPane setHomePage() {

    // Create layouts
    BorderPane mainLayout = new BorderPane();
    HBox titleBox = new HBox(new Label("CodeCademy"));

    // Create button list
    GridPane buttonList = new GridPane();
    buttonList.setHgap(10);
    buttonList.setVgap(10);
    buttonList.setPadding(new Insets(0, 10, 0, 10));

    // Button to add student
    Button studentBtn = new Button("Student");
    buttonList.add(studentBtn, 0, 0);
    studentBtn.setOnAction(e -> CreateNewScene.changeScene(new Scene(studentPage.studentCRUD())));

    // Button to go to registration page
    Button registrationBtn = new Button("Registration");
    buttonList.add(registrationBtn, 0, 1);

    // Button to see the statistics
    Button statisticsBtn = new Button("Statistics");
    buttonList.add(statisticsBtn, 0, 2);

    // Set layout
    mainLayout.setTop(titleBox);
    mainLayout.setCenter(buttonList);

    return mainLayout;
  }

}
