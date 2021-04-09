package Presentation;

import Presentation.Course.CoursePage;
import Presentation.Course.WebcastPage;
import Presentation.Statistics.StatisticsPage;
import Presentation.Student.StudentPage;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

// Class to create the GUI's homepage
public class HomePage {

  // Standard button sizes
  private int buttonWidth = 120;
  private int buttonHeight = 50;
  private BorderPane mainLayout;

  // Class to return a borderpane of the HomePage, return a layout
  public BorderPane getHomePage() {
    CreateNewScene createNewScene = new CreateNewScene();

    // Create button list
    GridPane buttonList = new GridPane();
    buttonList.setHgap(20);
    buttonList.setVgap(20);
    buttonList.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("CodeCademy");
    title.setStyle("-fx-font: 24 arial;");
    buttonList.add(title, 0, 0, 3, 1);

    // Label for text
    Label text = new Label("Select what you would like to do or view");
    text.setStyle("-fx-font: 14 arial;");
    buttonList.add(text, 0, 1, 3, 1);

    // Button to add student
    Button studentBtn = new Button("Student");
    buttonList.add(studentBtn, 0, 2);
    StudentPage studentPage = new StudentPage();
    studentBtn.setOnAction(e -> createNewScene.changeScene(studentPage.GUI()));
    studentBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to course page
    Button courseBtn = new Button("Course");
    buttonList.add(courseBtn, 1, 2);
    CoursePage coursePage = new CoursePage();
    courseBtn.setOnAction(e -> createNewScene.changeScene(coursePage.GUI()));
    courseBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to webcast page
    Button webcastBtn = new Button("Webcasts");
    buttonList.add(webcastBtn, 0, 3);
    WebcastPage webcastPage = new WebcastPage();
    webcastBtn.setOnAction(e -> createNewScene.changeScene(webcastPage.GUI()));
    webcastBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button statisticsBtn = new Button("Statistics");
    buttonList.add(statisticsBtn, 1, 3);
    StatisticsPage statisticsPage = new StatisticsPage();
    statisticsBtn.setOnAction(e -> createNewScene.changeScene(statisticsPage.GUI()));
    statisticsBtn.setMinSize(buttonWidth, buttonHeight);

    // Set layout
    mainLayout.setCenter(buttonList);

    return mainLayout;
  }

}
