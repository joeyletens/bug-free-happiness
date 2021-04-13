package Presentation.Statistics;

import ApplicationLogic.StatisticsController;
import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class AverageProgress {

  private TextField courseName;
  private Button backToStatisticsPage, createStatisticsBtn;
  private int buttonWidth = 30;
  private int buttonHeight = 10;
  StatisticsController statisticsController = new StatisticsController();

  public GridPane GUI() {
    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(10);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Title
    form.add(new Label("VIEW: Enter statistics details below"), 0, 0, 3, 1);

    // Add course name box
    form.add(new Label("Course name:"), 0, 1);
    courseName = new TextField();
    form.add(courseName, 0, 2, 3, 1);

    // Go back to Statistics page
    backToStatisticsPage = new Button("Back to statistics page");
    StatisticsPage statisticsPage = new StatisticsPage();
    backToStatisticsPage.setOnAction(e -> CreateNewScene.changeScene((statisticsPage.GUI())));
    backToStatisticsPage.setMinSize(buttonWidth, buttonHeight);
    form.add(backToStatisticsPage, 0, 3);

    // Creates a new Statistics when pressed on the button
    createStatisticsBtn = new Button("View");
    createStatisticsBtn.setMinSize(buttonWidth, buttonHeight);
    createStatisticsBtn.setOnAction(e -> {
      statisticsController.averageProgressPerModule(courseName.getText());
    });
    form.add(createStatisticsBtn, 3, 3);
    return form;

  }
}
