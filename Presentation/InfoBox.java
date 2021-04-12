package Presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

// This class pop-ups when a user asks for data
// It gives a response if adding/deleting/updating succeeded or failed
// Show the fetched data from a select statement

public class InfoBox {
  // Display data resultset when called or display create/update/delete result
  public static void Display(String title, String message) {
    Stage window = new Stage();

    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setResizable(false);
    window.setMinWidth(250);

    Label label = new Label();
    label.setText(message);
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> window.close());

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(10, 10, 10, 10));
    layout.getChildren().addAll(label, closeButton);
    layout.setAlignment(Pos.CENTER);

    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.show();
  }
}
