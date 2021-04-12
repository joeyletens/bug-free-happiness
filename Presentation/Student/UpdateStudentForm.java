package Presentation.Student;

import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.SQLException;

import ApplicationLogic.StudentController;
import Presentation.CreateNewScene;
import javafx.geometry.*;

public class UpdateStudentForm {

  static TextField email, newEmail;
  static Button cancel, add;

  // UPDATE STUDENT DATA
  public static GridPane GUI() {

    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(15);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Create and add email textfield
    form.add(new Label("UPDATE: Enter student details below"), 0, 0, 3, 1);
    form.add(new Label("Email:"), 0, 1, 3, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Add newEmail textfield
    form.add(new Label("Email:"), 0, 3, 3, 1);
    newEmail = new TextField();
    form.add(newEmail, 0, 4, 3, 1);

    // Create back to student page button
    Button backToStudentPage = new Button("Back to student page");
    backToStudentPage.setOnAction(e -> CreateNewScene.changeScene(StudentPage.GUI()));
    form.add(backToStudentPage, 0, 5);

    // Creates a new student when pressed on the button
    Button createStudentBtn = new Button("Get data");
    createStudentBtn.setOnAction(e -> {
      StudentController studentController = new StudentController();
      try {
        studentController.update(email.getText(), newEmail.getText());
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    });
    form.add(createStudentBtn, 2, 5);

    return form;
  }

}
