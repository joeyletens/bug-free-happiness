package Presentation.Student;

import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.sql.SQLException;

import ApplicationLogic.StudentController;
import Presentation.CreateNewScene;
import javafx.geometry.*;

// DELETE STUDENT FROM DATABASE
public class DeleteStudentForm {

  static TextField email;
  static Button cancel, add;

  public static GridPane GUI() {

    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(15);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Create and add email textfield
    form.add(new Label("DELETE: Enter student email below"), 0, 0, 3, 1);
    form.add(new Label("Email:"), 0, 1, 3, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Create back to student page button
    Button backToStudentPage = new Button("Back to student page");
    backToStudentPage.setOnAction(e -> CreateNewScene.changeScene(StudentPage.GUI()));
    form.add(backToStudentPage, 0, 3);

    // deletes a new student when pressed on the button

    Button deleteStudentBtn = new Button("Delete");
    deleteStudentBtn.setOnAction(e -> {
      StudentController studentController = new StudentController();
      try {
        studentController.delete(email.getText());
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    });
    form.add(deleteStudentBtn, 2, 3);

    return form;
  }

}
