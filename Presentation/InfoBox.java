package Presentation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InfoBox {
  // Display data resultset when called or display create/update/delete result
  public static void Display(String title, String message) {
    // empty
    Stage window = new Stage();

    // Create window layout
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Database result");
    window.setMinWidth(250);

    // Create label and button
    Label titleLabel = new Label(title);
    Label dataLabel = new Label(message);
    Button closeButton = new Button("Close the window");
    closeButton.setOnAction(e -> window.close());

    // Create vertical layout
    VBox layout = new VBox(10);
    layout.getChildren().addAll(titleLabel, dataLabel, closeButton);
    layout.setAlignment(Pos.CENTER);

    // create pop-up
    window.setScene(new Scene(layout));
    window.showAndWait();
  }
}
