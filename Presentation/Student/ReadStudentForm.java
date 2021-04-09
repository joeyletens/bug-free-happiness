package Presentation.Student;

import Presentation.CreateNewScene;
import Presentation.PresentationInf;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ReadStudentForm implements PresentationInf {

  TextField email;
  Button cancel, add;

  // GET STUDENT DATA
  public GridPane GUI() {
    CreateNewScene createNewScene = new CreateNewScene();
    // TODO Auto-generated method stub

    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(15);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Create and add email textfield
    form.add(new Label("READ: Enter student email below"), 0, 0, 3, 1);
    form.add(new Label("Email:"), 0, 1, 3, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Create back to student page button
    Button backToStudentPage = new Button("Back to student page");
    StudentPage studentPage = new StudentPage();
    backToStudentPage.setOnAction(e -> createNewScene.changeScene(studentPage.GUI()));
    form.add(backToStudentPage, 0, 3);

    // Creates a new student when pressed on the button

    Button createStudentBtn = new Button("Get data");
    createStudentBtn.setOnAction(e -> {

    });
    form.add(createStudentBtn, 2, 3);

    return form;
  }

}
