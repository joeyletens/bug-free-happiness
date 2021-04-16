package Presentation.Statistics;

import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class StatisticsPage {
  // Standard button sizes
  private int buttonWidth = 160;
  private int buttonHeight = 50;

  // Class to return a borderpane of the HomePage, return a layout
  public GridPane GUI() {
    // Create button list
    GridPane buttonList = new GridPane();
    buttonList.setHgap(20);
    buttonList.setVgap(20);
    buttonList.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Statistics");
    title.setStyle("-fx-font: 24 arial;");
    buttonList.add(title, 0, 0);

    // Label for text
    Label text = new Label("Select what you would like to do or view");
    text.setStyle("-fx-font: 14 arial;");
    buttonList.add(text, 0, 1, 2, 1);

    // Button to add average progress button
    Button averageProgressBtn = new Button("Average progress per\nmodule");
    buttonList.add(averageProgressBtn, 0, 2);
    AverageProgress averageProgress = new AverageProgress();
    averageProgressBtn.setOnAction(e -> CreateNewScene.changeScene(averageProgress.GUI()));
    averageProgressBtn.setMinSize(buttonWidth, buttonHeight);

    // button to view student porgress per module
    Button studentProgressBtn = new Button("Student progress per\nmodule");
    buttonList.add(studentProgressBtn, 1, 2);
    StudentProgress studentProgress = new StudentProgress();
    studentProgressBtn.setOnAction(e -> CreateNewScene.changeScene(studentProgress.GUI()));
    studentProgressBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to top 3 most viewed page
    Button topThreeBtn = new Button("Top 3 most viewed\nwebcast");
    buttonList.add(topThreeBtn, 0, 3);
    TopThree topThree = new TopThree();
    topThreeBtn.setOnAction(e -> CreateNewScene.changeScene(topThree.GUI()));
    topThreeBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to amount of student swho passed a course page
    Button passedStudentsBtn = new Button("Amout of students who\npassed a course");
    buttonList.add(passedStudentsBtn, 1, 3);
    PassedStudents passedStudents = new PassedStudents();
    passedStudentsBtn.setOnAction(e -> CreateNewScene.changeScene(passedStudents.GUI()));
    passedStudentsBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the homePage
    Button homePageBtn = new Button("Homepage");
    buttonList.add(homePageBtn, 0, 4);
    homePageBtn.setOnAction(e -> CreateNewScene.setHomePage());
    homePageBtn.setMinSize(buttonWidth, buttonHeight);

    return buttonList;
  }
}
