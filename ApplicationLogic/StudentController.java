package ApplicationLogic;

import java.sql.SQLException;

import DataStorageLayer.MySQLStudentDAO;
import DomainModel.Student;

// Studentcontroller creates, reads, deletes or updates a student class
// the class implements de ControllerInterface 

public class StudentController implements ControllerInterface {

  // Used to create a new student gets called by the GUI
  public static boolean create(Student student) throws SQLException {
    // TODO Auto-generated method stub
    // if (DataStorageLayer.MySQLStudentDAO.create(student)) {
    // Presentation.InfoBox("Added successful", student.getFirstName() + " " +
    // student.getLastName());
    // return true;
    // } else {
    // Presentation.InfoBox("Added failed", "Oh no");
    // }
    return false;
  }

  // Used to read a new student gets called by the GUI
  public static void read(String email) {
    // TODO Auto-generated method stub

  }

  // Used to update a new student gets called by the GUI
  public static boolean update(String email) {
    // TODO Auto-generated method stub
    return false;
  }

  // Used to delete a new student gets called by the GUI
  public static boolean delete(String email) {
    // TODO Auto-generated method stub
    return false;
  }

}
