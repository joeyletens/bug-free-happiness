package Presentation;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewScene {
  private static Stage window = new Stage();

  // Starts the Application's GUI called by the main
  public void createWindow() {
    // Create window layout
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Jelmer Verhoeven 2154728 - Joey Letens 2159107");
    window.setMinWidth(250);
    window.setScene(new Scene(HomePage.getHomePage()));
    window.show();
  }

  // When called this method changes the GUI's current scene
  public static void changeScene(GridPane nextPage) {
    window.setScene(new Scene(nextPage));
  }

  public static void setHomePage() {
    window.setScene(new Scene(HomePage.getHomePage()));
  }
}
