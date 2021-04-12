package Main;

import Presentation.CreateNewScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) {

    launch(Main.class);

  }

  @Override
  public void start(Stage arg0) throws Exception {
    // TODO Auto-generated method stub

    CreateNewScene createNewScene = new CreateNewScene();
    createNewScene.createWindow();

  }
}
