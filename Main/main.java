package Main;

import java.sql.SQLException;

import DataStorageLayer.DatabaseConnection;
import DataStorageLayer.MySQLStudentDAO;
import DomainModel.Student;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
  public static void main(String[] args) throws SQLException {

    Student student = new Student("email", "joey", "letens", "15/04/2021", "male", "4848kp", "sesam", "68", "breda",
        "netherlands");

    System.out.println("LALALALALAL");

    System.out.println(student);

    // DataStorageLayer.MySQLStudentDAO.create(student);

    launch(Presentation.CreateNewScene.class);

  }

  @Override
  public void start(Stage arg0) throws Exception {
    // TODO Auto-generated method stub

  }
}
