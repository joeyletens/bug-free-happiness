package Presentation.Student;

import Presentation.CreateNewScene;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ReadStudentForm {

  static TextField email;
  static Button cancel, add;

  // GET STUDENT DATA
  public static GridPane studentForm() {
    // TODO Auto-generated method stub

    GridPane form = new GridPane();
    form.setHgap(10);
    form.setVgap(10);
    form.setPadding(new Insets(0, 10, 0, 10));

    // Create and add email textfield
    form.add(new Label("READ: Enter student email below"), 0, 0);
    form.add(new Label("Email:"), 0, 1);
    email = new TextField();
    form.add(email, 1, 1);

    // Create back to student page button
    Button backToStudentPage = new Button("Back to student page");
    backToStudentPage.setOnAction(e -> CreateNewScene.changeScene(new Scene(StudentPage.studentCRUD())));
    form.add(backToStudentPage, 0, 2);

    // Creates a new student when pressed on the button

    Button createStudentBtn = new Button("Get data");
    createStudentBtn.setOnAction(e -> {

      ApplicationLogic.StudentController.read(email.getText());

    });
    form.add(createStudentBtn, 1, 2);

    return form;
  }

}
