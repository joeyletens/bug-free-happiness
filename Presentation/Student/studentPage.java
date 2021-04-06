package Presentation.Student;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class studentPage {
  public static GridPane studentForm() {
    // TODO Auto-generated method stub
    GridPane studentScreen = new GridPane();

    // Create button list
    GridPane buttonList = new GridPane();
    buttonList.setHgap(10);
    buttonList.setVgap(10);
    buttonList.setPadding(new Insets(0, 10, 0, 10));

    // Button to add student
    Button studentBtn = new Button("Student");
    buttonList.add(studentBtn, 0, 0);

    // Button to read student
    Button registrationBtn = new Button("Registration");
    buttonList.add(registrationBtn, 0, 1);

    // Button to see the statistics
    Button statisticsBtn = new Button("Statistics");
    buttonList.add(statisticsBtn, 0, 2);

    // // Button to go to registration page
    // Button registrationBtn = new Button("Registration");
    // buttonList.add(registrationBtn, 0, 1);

    // // Button to see the statistics
    // Button statisticsBtn = new Button("Statistics");
    // buttonList.add(statisticsBtn, 0, 2);

    return studentScreen;
  }
}
