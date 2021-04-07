package Presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewScene extends Application {
  private static Stage window = new Stage();

  // Starts the Application's GUI called by the main
  @Override
  public void start(Stage arg0) throws Exception {

    // Create window layout
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Jo jo Joey");
    window.setMinWidth(250);

    window.setScene(new Scene(HomePage.setHomePage()));
    window.show();
  }

  // When called this method changes the GUI's current scene
  public static void changeScene(Scene scene) {
    window.setScene(scene);
  }
}
