package Presentation.Course;

import Presentation.CreateNewScene;
import javafx.geometry.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class CoursePage {
  private int buttonWidth = 120;
  private int buttonHeight = 50;

  // Method to create and return a gridpane with buttons for the coursespage
  public GridPane GUI() {
    // Create course screen
    GridPane courseScreen = new GridPane();
    courseScreen.setHgap(20);
    courseScreen.setVgap(20);
    courseScreen.setPadding(new Insets(20, 30, 20, 30));

    // Label for title
    Label title = new Label("Course");
    title.setStyle("-fx-font: 24 arial;");
    courseScreen.add(title, 0, 0, 2, 1);

    // Label for text
    Label text = new Label("Select what you would like to do or view");
    text.setStyle("-fx-font: 14 arial;");
    courseScreen.add(text, 0, 1, 2, 1);

    // To view different modules
    Button modulesBtn = new Button("View Modules");
    courseScreen.add(modulesBtn, 0, 2);
    ModulesPage modulesPage = new ModulesPage();
    modulesBtn.setOnAction(e -> CreateNewScene.changeScene(modulesPage.GUI()));
    modulesBtn.setMinSize(buttonWidth, buttonHeight);

    // To view different webcasts
    Button webcastsBtn = new Button("View webcasts");
    courseScreen.add(webcastsBtn, 1, 2);
    WebcastPage webcastPage = new WebcastPage();
    webcastsBtn.setOnAction(e -> CreateNewScene.changeScene(webcastPage.GUI()));
    webcastsBtn.setMinSize(buttonWidth, buttonHeight);

    // Button to see the statistics
    Button home = new Button("Homepage");
    courseScreen.add(home, 0, 3, 3, 1);
    home.setOnAction(e -> CreateNewScene.setHomePage());
    home.setMinSize(buttonWidth, buttonHeight);

    // Set layout and return the courseScreen
    courseScreen.setAlignment(Pos.CENTER);
    return courseScreen;
  }
}
