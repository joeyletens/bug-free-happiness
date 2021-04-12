package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataStorageLayer.DatabaseConnection;
import Presentation.InfoBox;

// Studentcontroller creates, reads, deletes or updates a student class
// the class implements de ControllerInterface 

public class StudentController implements ControllerInterface {
  DatabaseConnection dao = new DatabaseConnection();
  StringBuilder message;

  @Override
  public boolean create() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void read(String email) throws SQLException {
    ResultSet rs = dao.ExecuteSelectStatement(email);
    if (rs == null) {
      // If resultset is empty display not found
      InfoBox.Display("Student not found", "Student with the email: \n" + email + "\nwas not found");
    } else {
      // If email is found display student data
      message = new StringBuilder();
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
  public void delete(String email) throws SQLException {
    boolean result = dao.ExecuteDeleteStatement(email);
    if (result) {
      InfoBox.Display("Deleted student", "Student (" + email + ") has been successfully deleted");
    } else {
      InfoBox.Display("Not deleted",
          "Student (" + email + ") was not deleted, \n" + "there was no student found with this email");
    }
  }

}
