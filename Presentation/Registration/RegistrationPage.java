package Presentation.Registration;

import static Presentation.CreateNewScene.changeScene;

import Presentation.CreateNewScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class RegistrationPage {
  // Method to create and return a gridpane with buttons for the studentpage
  int buttonWidth = 120;
  int buttonHeight = 50;

  public GridPane GUI() {
    // Create button list
    GridPane registrationScreen = new GridPane();
    registrationScreen.setHgap(20);
    registrationScreen.setVgap(20);
    registrationScreen.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Registration");
    title.setStyle("-fx-font: 24 arial;");
    registrationScreen.add(title, 0, 0, 2, 1);

    // Label for text
    Label text = new Label("Select what you would like to do");
    text.setStyle("-fx-font: 14 arial;");
    registrationScreen.add(text, 0, 1, 2, 1);

    // Button to add student
    Button add = new Button("Add");
    registrationScreen.add(add, 0, 2);
    CreateRegistrationForm createRegistrationForm = new CreateRegistrationForm();
    add.setOnAction(e -> changeScene(createRegistrationForm.GUI()));
    add.setMinSize(buttonWidth, buttonHeight);

    // Button to read student
    Button read = new Button("Read");
    registrationScreen.add(read, 1, 2);
    ReadRegistrationForm readRegistrationForm = new ReadRegistrationForm();
    read.setOnAction(e -> CreateNewScene.changeScene(readRegistrationForm.GUI()));
    read.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button update = new Button("Update");
    registrationScreen.add(update, 0, 3);
    UpdateRegistrationForm updateRegistrationForm = new UpdateRegistrationForm();
    update.setOnAction(e -> CreateNewScene.changeScene(updateRegistrationForm.GUI()));
    update.setMinSize(buttonWidth, buttonHeight);

    // Button to go to registration page
    Button delete = new Button("Delete");
    registrationScreen.add(delete, 1, 3);
    DeleteRegistrationForm deleteRegistrationForm = new DeleteRegistrationForm();
    delete.setOnAction(e -> CreateNewScene.changeScene(deleteRegistrationForm.GUI()));
    delete.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button home = new Button("Homepage");
    registrationScreen.add(home, 0, 4);
    home.setOnAction(e -> CreateNewScene.setHomePage());
    home.setMinSize(buttonWidth, buttonHeight);

    registrationScreen.setAlignment(Pos.CENTER);

    return registrationScreen;
  }
}
