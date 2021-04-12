package Presentation.Course;

import Presentation.CreateNewScene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class WebcastPage {
  // Create different variables
  private TextField email, title, contentId, progress;
  private Button backToCoursePage, createCourseBtn;
  private int buttonWidth = 30;
  private int buttonHeight = 10;

  public GridPane GUI() {
    GridPane form = new GridPane();
    form.setHgap(25);
    form.setVgap(10);
    form.setPadding(new Insets(15, 25, 15, 25));

    // Title
    form.add(new Label("VIEW: enter student and module details below"), 0, 0, 3, 1);

    // Add student email box
    form.add(new Label("Email:"), 0, 1);
    email = new TextField();
    form.add(email, 0, 2, 3, 1);

    // Add course title box
    form.add(new Label("Title:"), 0, 3);
    title = new TextField();
    form.add(title, 0, 4, 3, 1);

    // Add course contentId box
    form.add(new Label("ContentId:"), 0, 5);
    contentId = new TextField();
    form.add(contentId, 0, 6, 3, 1);

    // Add course progress made my student box
    form.add(new Label("Progress:"), 0, 7);
    progress = new TextField();
    form.add(progress, 0, 8, 3, 1);

    // Go back to Course page
    backToCoursePage = new Button("Back to Course page");
    CoursePage coursePage = new CoursePage();
    backToCoursePage.setOnAction(e -> CreateNewScene.changeScene((coursePage.GUI())));
    backToCoursePage.setMinSize(buttonWidth, buttonHeight);
    form.add(backToCoursePage, 0, 9);

    // Creates a new Course when pressed on the button
    createCourseBtn = new Button("Make progress");
    createCourseBtn.setMinSize(buttonWidth, buttonHeight);
    createCourseBtn.setOnAction(e -> {

      // CourseController courseController = new CourseController();
      // try {
      // courseController.read(email.getText());
      // } catch (SQLException e1) {
      // // TODO Auto-generated catch block
      // e1.printStackTrace();
      // }

    });
    form.add(createCourseBtn, 2, 9);
    return form;

  }
}
