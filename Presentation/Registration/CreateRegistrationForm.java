package Presentation.Registration;

import java.sql.SQLException;

import ApplicationLogic.RegistrationController;
import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CreateRegistrationForm {

  private TextField email, courseName;
  private Button backToRegistrationPage, createRegistrationBtn;
  private int buttonWidth = 30;
  private int buttonHeight = 10;

  public GridPane GUI() {
    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(10);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Title
    form.add(new Label("CREATE: Enter registration details below"), 0, 0, 3, 1);

    // Add student email box
    form.add(new Label("Email:"), 0, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Add course name box
    form.add(new Label("Course name:"), 0, 3);
    courseName = new TextField();
    form.add(courseName, 0, 4, 3, 1);

    // Go back to registration page
    backToRegistrationPage = new Button("Back to registration page");
    RegistrationPage registrationPage = new RegistrationPage();
    backToRegistrationPage.setOnAction(e -> CreateNewScene.changeScene((registrationPage.GUI())));
    backToRegistrationPage.setMinSize(buttonWidth, buttonHeight);
    form.add(backToRegistrationPage, 0, 5);

    // Creates a new Registration when pressed on the button

    createRegistrationBtn = new Button("Enroll");
    createRegistrationBtn.setMinSize(buttonWidth, buttonHeight);
    createRegistrationBtn.setOnAction(e -> {

      RegistrationController registrationController = new RegistrationController();
      try {
        registrationController.create(email.getText(), courseName.getText());
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

    });
    form.add(createRegistrationBtn, 3, 5);
    return form;

  }
}
