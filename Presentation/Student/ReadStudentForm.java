package Presentation.Student;

import java.sql.SQLException;

import ApplicationLogic.StudentController;
import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ReadStudentForm {

  static TextField email;
  static Button cancel, add;

  // GET STUDENT DATA
  public static GridPane GUI() {

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
    backToStudentPage.setOnAction(e -> CreateNewScene.changeScene(StudentPage.GUI()));
    form.add(backToStudentPage, 0, 3);

    // Creates a new student when pressed on the button
    Button createStudentBtn = new Button("Get data");
    createStudentBtn.setOnAction(e -> {
      StudentController studentController = new StudentController();
      try {
        studentController.read(email.getText());
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });

    form.add(createStudentBtn, 2, 3);

    return form;
  }

}
