package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataStorageLayer.DatabaseConnection;
import Presentation.InfoBox;

// Studentcontroller creates, reads, deletes or updates a student class
// the class implements de ControllerInterface 

public class StudentController implements ControllerInterface {
  DatabaseConnection dao = new DatabaseConnection();
  StringBuilder message = new StringBuilder();

  @Override
  public boolean create() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void read(String email) throws SQLException {
    ResultSet rs = dao.ExecuteSelectStatement(email);
    if (rs == null) {
      InfoBox.Display("Student not found", "Student with the email: \n" + email + "\nwas not found");
    } else {
      message.append("Email: " + rs.getString(1) + "\n");
      message.append("Name: " + rs.getString(2) + " " + rs.getString(3) + "\n");
      message.append("Date of birth: " + rs.getString(4) + "\n");
      message.append("Gender : " + rs.getString(5) + "\n");

      InfoBox.Display("Student was found", message.toString());
    }
  }

  @Override
  public boolean update() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean delete() {
    // TODO Auto-generated method stub
    return false;
  }

}
