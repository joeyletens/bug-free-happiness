package Presentation.Student;

import java.text.Normalizer.Form;

import ApplicationLogic.StudentController;
import DataStorageLayer.MySQLStudentDAO.*;
import DomainModel.Student;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class CreateStudentForm {
  static TextField email, firstName, lastName, dateOfBirth, postalCode, street, houseNumber, city, country;
  static Button cancel, add;

  public static GridPane studentForm() {
    // TODO Auto-generated method stub

    GridPane form = new GridPane();
    form.setHgap(10);
    form.setVgap(10);
    form.setPadding(new Insets(0, 10, 0, 10));

    form.add(new Label("Enter student details below"), 0, 0);
    form.add(new Label("Email:"), 0, 1);
    email = new TextField();
    form.add(email, 1, 1);
    form.add(new Label("First name:"), 0, 2);
    firstName = new TextField();
    form.add(firstName, 1, 2);
    form.add(new Label("Last name:"), 0, 3);
    lastName = new TextField();
    form.add(lastName, 1, 3);
    form.add(new Label("Date of birth:"), 0, 4);
    lastName = new TextField();
    form.add(lastName, 1, 4);
    ChoiceBox<String> gender = new ChoiceBox<>();
    gender.getItems().addAll("Male", "Female", "Other");
    form.add(new Label("Gender:"), 0, 5);
    form.add(gender, 1, 5);
    form.add(new Label("Postalcode:"), 0, 6);
    postalCode = new TextField();
    form.add(postalCode, 1, 6);
    form.add(new Label("Street:"), 0, 7);
    street = new TextField();
    form.add(street, 1, 7);
    form.add(new Label("Housenumber:"), 0, 8);
    houseNumber = new TextField();
    form.add(houseNumber, 1, 8);
    form.add(new Label("City:"), 0, 9);
    city = new TextField();
    form.add(city, 1, 9);
    form.add(new Label("Country:"), 0, 10);
    country = new TextField();
    form.add(country, 1, 10);

    add = new Button("Add");
    add.setOnAction(e -> {

      Student student = new Student(email.getText(), firstName.getText(), lastName.getText(), dateOfBirth.getText(),
          gender.getValue(), street.getText(), houseNumber.getText(), postalCode.getText(), city.getText(),
          country.getText());
      StudentController.create(student);

      System.out.println("Student added");
    });

    return form;
  }

}
