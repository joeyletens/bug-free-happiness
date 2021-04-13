package Presentation.Course;

import ApplicationLogic.CourseController;
import DomainModel.Viewed;
import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class ProgressWebcastPage {
  // Create different variables
  private TextField email, contentId, progress;
  private Button backToCoursePage, createCourseBtn;
  private int buttonWidth = 30;
  private int buttonHeight = 10;

  public GridPane GUI() {
    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(10);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Title
    form.add(new Label("MAKE PROGRESS: enter student and module details below"), 0, 0, 3, 1);

    // Add student email box
    form.add(new Label("Email:"), 0, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Add course contentId box
    form.add(new Label("ContentId:"), 0, 3);
    contentId = new TextField();
    form.add(contentId, 0, 4, 3, 1);

    // Add course progress box
    form.add(new Label("Progress:"), 0, 5);
    progress = new TextField();
    form.add(progress, 0, 6, 3, 1);

    // Go back to Course page
    backToCoursePage = new Button("Back to Course page");
    CoursePage coursePage = new CoursePage();
    backToCoursePage.setOnAction(e -> CreateNewScene.changeScene((coursePage.GUI())));
    backToCoursePage.setMinSize(buttonWidth, buttonHeight);
    form.add(backToCoursePage, 0, 7);

    // Creates a new Course when pressed on the button
    createCourseBtn = new Button("Make progress");
    createCourseBtn.setMinSize(buttonWidth, buttonHeight);
    createCourseBtn.setOnAction(e -> {

      Viewed viewed = new Viewed(Integer.parseInt(contentId.getText()), email.getText());
      CourseController courseController = new CourseController();
      courseController.makeProgressInWebcast(Integer.parseInt(progress.getText()), viewed);

    });
    form.add(createCourseBtn, 2, 7);
    return form;

  }
}
