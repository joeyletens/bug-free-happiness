package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import DataStorageLayer.SQLCourseDAO;
import DataStorageLayer.SQLRegistrationDAO;
import DataStorageLayer.SQLStudentDAO;
import DomainModel.Registration;
import Presentation.InfoBox;

public class RegistrationController {
  SQLRegistrationDAO dao = new SQLRegistrationDAO();
  SQLStudentDAO studentDAO = new SQLStudentDAO();
  SQLCourseDAO courseDAO = new SQLCourseDAO();
  StringBuilder message;
  String notAdded = "registration not added";
  ResultSet rs;
  StringBuilder selectList;

  // Returns todays date
  public String getDate() {
    LocalDate date = LocalDate.now(); // Create a date object
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String formattedDate = date.format(format);
    return formattedDate;
  }

  public void create(String email, String coursename) throws SQLException {
    // Create new registration
    boolean result = false;
    Registration registration = new Registration(email, coursename, getDate());
    if (courseDAO.checkIfCourseExists(coursename) && studentDAO.CheckIfStudentExists(email)) {
      result = dao.ExecuteInsertStatement(registration);
    }

    if (result) {
      InfoBox.Display("Added registration on ", registration.getCourseName() + " for " + registration.getEmail());
    } else {
      InfoBox.Display(notAdded, "Failed to enroll student to course");
    }
  }

  public void read(String email) throws SQLException {

    rs = dao.ExecuteSelectStatement(email);
    if (rs == null) {
      // If resultset is empty display not found
      InfoBox.Display("Registrations not found", "Student with the email: \n" + email + "\nhas no registration");
    } else {
      // else read through the whole list
      selectList = new StringBuilder();
      selectList.append("===============================\n").append("Date: " + rs.getString(1) + "\n")
          .append("Student: " + rs.getString(2) + "\n").append("Course: " + rs.getString(3) + "\n")
          .append("===============================\n");
      while (rs.next()) {
        selectList.append("===============================\n").append("Date: " + rs.getString(1) + "\n")
            .append("Student: " + rs.getString(2) + "\n").append("Course: " + rs.getString(3) + "\n")
            .append("===============================\n");

      }

      InfoBox.Display("Registrations found", selectList.toString());
    }
  }

  public void update(Registration registration) throws SQLException {
    // Check if registration exist
    boolean result = false;
    result = dao.ExecuteUpdateStatement(registration);
    if (result) {
      // If true update registration to todays date and display result
      InfoBox.Display("Updated Registration",
          "Date changed from: " + registration.getApplicationDate() + "\n" + "has been updated to: " + getDate());
    } else {
      // else return registration does not exist
      InfoBox.Display("Registration not updated", "The registration does not exist");
    }
  }

  public void delete(Registration registration) throws SQLException {
    boolean result = false;
    result = dao.ExecuteDeleteStatement(registration);
    if (result) {
      InfoBox.Display("Deleted Registration", registration.getEmail() + " has been successfully deleted from\n"
          + registration.getCourseName() + " who registrered on " + registration.getApplicationDate());
    } else {
      InfoBox.Display("Registration not deleted", "Registraion does not exist");
    }
  }

}
