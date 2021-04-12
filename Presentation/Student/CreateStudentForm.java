package Presentation.Student;

import java.sql.SQLException;

import ApplicationLogic.StudentController;

import DomainModel.Student;
import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CreateStudentForm {

  private static TextField email, firstName, lastName, dateOfBirth, postalCode, street, houseNumber, city, country;
  private static Button backToStudentPage, createStudentBtn;
  private static int buttonWidth = 30;
  private static int buttonHeight = 10;

  public static GridPane GUI() {
    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(10);
    form.setPadding(new Insets(15, 25, 15, 25));

    form.add(new Label("CREATE: Enter student details below"), 0, 0, 5, 1);
    form.add(new Label("Email:"), 0, 1);

    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    form.add(new Label("First name:"), 0, 3);
    firstName = new TextField();
    form.add(firstName, 0, 4, 3, 1);

    form.add(new Label("Last name:"), 0, 5);
    lastName = new TextField();
    form.add(lastName, 0, 6, 3, 1);

    form.add(new Label("Date of birth: dd/mm/yyyy"), 0, 7, 3, 1);
    dateOfBirth = new TextField("01/01/2021");
    form.add(dateOfBirth, 0, 8, 3, 1);

    ChoiceBox<String> gender = new ChoiceBox<>();
    gender.getItems().addAll("Male", "Female", "Other");
    form.add(new Label("Gender:"), 0, 9);
    form.add(gender, 0, 10, 3, 1);

    form.add(new Label("Postalcode:"), 3, 1);
    postalCode = new TextField();
    form.add(postalCode, 3, 2, 3, 1);

    form.add(new Label("Street:"), 3, 3);
    street = new TextField();
    form.add(street, 3, 4, 3, 1);

    form.add(new Label("Housenumber:"), 3, 5);
    houseNumber = new TextField();
    form.add(houseNumber, 3, 6, 3, 1);

    form.add(new Label("City:"), 3, 7);
    city = new TextField();
    form.add(city, 3, 8, 3, 1);

    form.add(new Label("Country:"), 3, 9);
    country = new TextField();
    form.add(country, 3, 10, 3, 1);

    backToStudentPage = new Button("Back to student page");
    backToStudentPage.setOnAction(e -> CreateNewScene.changeScene((StudentPage.GUI())));
    backToStudentPage.setMinSize(buttonWidth, buttonHeight);
    form.add(backToStudentPage, 0, 11, 3, 1);

    // Creates a new student when pressed on the button

    createStudentBtn = new Button("Add");
    createStudentBtn.setMinSize(buttonWidth, buttonHeight);
    createStudentBtn.setOnAction(e -> {
      // nothing
      Student student = new Student(email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.getText(),
          gender.getValue(), postalCode.getText(), street.getText(), houseNumber.getText(), city.getText(),
          country.getText());

      StudentController studentController = new StudentController();
      try {
        studentController.create(student);
      } catch (SQLException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

    });
    form.add(createStudentBtn, 3, 11, 3, 1);
    return form;

  }
}
