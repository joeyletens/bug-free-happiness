package Presentation;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateNewScene extends Application {
  private Stage window;

  // Starts the Application's GUI called by the main
  @Override
  public void start(Stage arg0) throws Exception {

    // Create window layout
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Jo jo Joey");
    window.setMinWidth(250);

    HomePage firstLayout = new HomePage();
    window.setScene(new Scene(firstLayout.getHomePage()));
    window.show();
  }

  // When called this method changes the GUI's current scene
  public void changeScene(GridPane nextPage) {
    window.setScene(new Scene(nextPage));
  }

  public void setHomePage() {
    HomePage firstLayout = new HomePage();
    window.setScene(new Scene(firstLayout.getHomePage()));
  }
}
