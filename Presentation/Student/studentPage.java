package Presentation.Student;

import Presentation.CreateNewScene;
import Presentation.HomePage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class StudentPage {
  public static GridPane studentCRUD() {

    // Create button list
    GridPane studentScreen = new GridPane();
    studentScreen.setHgap(10);
    studentScreen.setVgap(10);
    studentScreen.setPadding(new Insets(0, 10, 0, 10));

    // Label for title
    Label title = new Label("Student");
    studentScreen.add(title, 0, 0);

    // Button to add student
    Button add = new Button("Add");
    studentScreen.add(add, 0, 1);
    add.setOnAction(e -> CreateNewScene.changeScene(new Scene(CreateStudentForm.studentForm())));

    // Button to read student
    Button read = new Button("Read");
    studentScreen.add(read, 0, 2);
    read.setOnAction(e -> CreateNewScene.changeScene(new Scene(ReadStudentForm.studentForm())));

    // Button to see the statistics
    Button update = new Button("Update");
    studentScreen.add(update, 0, 3);
    update.setOnAction(e -> CreateNewScene.changeScene(new Scene(UpdateStudentForm.studentForm())));

    // Button to go to registration page
    Button delete = new Button("Delete");
    studentScreen.add(delete, 0, 4);
    delete.setOnAction(e -> CreateNewScene.changeScene(new Scene(DeleteStudentForm.studentForm())));

    // Button to see the statistics
    Button home = new Button("Homepage");
    studentScreen.add(home, 0, 5);
    home.setOnAction(e -> CreateNewScene.changeScene(new Scene(HomePage.setHomePage())));

    return studentScreen;
  }
}
