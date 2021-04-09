// This class creates the studentPage in the GUI. 
// A user can chooso 4 options add, delete, create or update a student
// And the user can go back to the homepage

package Presentation.Student;

import Presentation.CreateNewScene;
import Presentation.PresentationInf;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StudentPage implements PresentationInf {
  private int buttonWidth = 120;
  private int buttonHeight = 50;

  // Method to create and return a gridpane with buttons for the studentpage
  public GridPane GUI() {
    CreateNewScene createNewScene = new CreateNewScene();

    // Create button list
    GridPane studentScreen = new GridPane();
    studentScreen.setHgap(20);
    studentScreen.setVgap(20);
    studentScreen.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Student");
    title.setStyle("-fx-font: 24 arial;");
    studentScreen.add(title, 0, 0, 2, 1);

    // Label for text
    Label text = new Label("Select what you would like to do");
    text.setStyle("-fx-font: 14 arial;");
    studentScreen.add(text, 0, 1, 2, 1);

    // Button to add student
    Button add = new Button("Add");
    studentScreen.add(add, 0, 2);
    CreateStudentForm createStudentForm = new CreateStudentForm();
    add.setOnAction(e -> createNewScene.changeScene(createStudentForm.GUI()));
    add.setMinSize(buttonWidth, buttonHeight);

    // Button to read student
    Button read = new Button("Read");
    studentScreen.add(read, 1, 2);
    ReadStudentForm readStudentForm = new ReadStudentForm();
    read.setOnAction(e -> createNewScene.changeScene(readStudentForm.GUI()));
    read.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button update = new Button("Update");
    studentScreen.add(update, 0, 3);
    UpdateStudentForm updateStudentForm = new UpdateStudentForm();
    update.setOnAction(e -> createNewScene.changeScene(updateStudentForm.GUI()));
    update.setMinSize(buttonWidth, buttonHeight);

    // Button to go to registration page
    Button delete = new Button("Delete");
    studentScreen.add(delete, 1, 3);
    DeleteStudentForm deleteStudentForm = new DeleteStudentForm();
    delete.setOnAction(e -> createNewScene.changeScene(deleteStudentForm.GUI()));
    delete.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button home = new Button("Homepage");
    studentScreen.add(home, 0, 4);
    home.setOnAction(e -> createNewScene.setHomePage());
    home.setMinSize(buttonWidth, buttonHeight);

    studentScreen.setAlignment(Pos.CENTER);

    return studentScreen;
  }
}
