package Presentation.Statistics;

import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class StatisticsPage {
  // Standard button sizes
  private int buttonWidth = 180;
  private int buttonHeight = 50;

  // Class to return a borderpane of the HomePage, return a layout
  public GridPane GUI() {
    CreateNewScene createNewScene = new CreateNewScene();

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
    buttonList.add(text, 0, 1);

    // Button to add student
    Button averageProgressBtn = new Button("Average progress per module");
    buttonList.add(averageProgressBtn, 0, 2);
    // averageProgressBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(averageProgressPage.averageProgressCRUD())));
    averageProgressBtn.setMinSize(buttonWidth, buttonHeight);

    Button studentProgressBtn = new Button("Student progress per module");
    buttonList.add(studentProgressBtn, 0, 3);
    // studentProgressBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(studentProgressPage.studentProgressCRUD())));
    studentProgressBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to course page
    Button courseBtn = new Button("Top 3 most viewed webcast");
    buttonList.add(courseBtn, 0, 4);
    // courseBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(CoursePage.createCoursePage())));
    courseBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to go to webcast page
    Button webcastBtn = new Button("Students who passed a course");
    buttonList.add(webcastBtn, 0, 5);
    // webcastBtn.setOnAction(e -> CreateNewScene.changeScene(new
    // Scene(CoursePage.createCoursePage())));
    webcastBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the homePage
    Button homePageBtn = new Button("Homepage");
    buttonList.add(homePageBtn, 0, 6);
    homePageBtn.setOnAction(e -> CreateNewScene.setHomePage());
    homePageBtn.setMinSize(buttonWidth, buttonHeight);

    return buttonList;
  }
}
