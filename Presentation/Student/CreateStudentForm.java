package Presentation.Student;

import java.sql.SQLException;

import ApplicationLogic.StudentController;

import DomainModel.Student;
import Presentation.CreateNewScene;
import Presentation.InfoBox;
import UnitTest.ValidationMethods.DateTools;
import UnitTest.ValidationMethods.MailTools;
import UnitTest.ValidationMethods.PostalCode;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CreateStudentForm {

  private static TextField email, firstName, lastName, dateDay, dateMonth, dateYear, postalCode, street, houseNumber,
      city, country;
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

    form.add(new Label("Date of birth: "), 0, 7, 3, 1);
    dateDay = new TextField("dd");
    form.add(dateDay, 0, 8, 1, 1);
    dateMonth = new TextField("mm");
    form.add(dateMonth, 1, 8, 1, 1);
    dateYear = new TextField("yyyy");
    form.add(dateYear, 2, 8, 1, 1);

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
      // Validates all email, date and postalcode
      if (firstName.getText().equals("") || lastName.getText().equals("") || street.getText().equals("")
          || houseNumber.getText().equals("") || city.getText().equals("") || country.getText().equals("")) {
        InfoBox.Display("Empty fields", "ERROR: some text fields are empty");
      } else if (!MailTools.validateMailAddress(email.getText())) {
        InfoBox.Display("Incorrect email", "email is not in a correct form");
      } else if (!DateTools.validateDate(Integer.parseInt(dateDay.getText()), Integer.parseInt(dateMonth.getText()),
          Integer.parseInt(dateYear.getText()))) {
        InfoBox.Display("Invalid date", "The date is invalid");
      } else if (PostalCode.formatPostalCode(postalCode.getText()) == null) {
        InfoBox.Display("Invalid postalcode", "postalcode is in an incorrect form");
      } else {

        // Create dateOfBirth string
        StringBuilder dateOfBirth = new StringBuilder();
        dateOfBirth.append(dateDay.getText()).append("-").append(dateMonth.getText()).append("-")
            .append(dateYear.getText());

        // create a new student object
        Student student = new Student(email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.toString(),
            gender.getValue(), PostalCode.formatPostalCode(postalCode.getText()), street.getText(),
            houseNumber.getText(), city.getText(), country.getText());

        // Calls the studentcontroller
        StudentController studentController = new StudentController();
        try {
          studentController.create(student);
        } catch (SQLException e1) {
          // TODO Auto-generated catch block
          e1.printStackTrace();
        }
      }
    });
    form.add(createStudentBtn, 3, 11, 3, 1);
    return form;

  }
}
