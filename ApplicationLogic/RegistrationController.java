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
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = date.format(format);
    return formattedDate;
  }

  public void create(String email, String coursename) throws SQLException {
    // Create new registration
    Registration registration = new Registration(email, coursename, getDate());

    // Check if student, course or registration exist
    if (!studentDAO.CheckIfStudentExists(registration.getEmail())) {
      InfoBox.Display(notAdded, "This student does not exist");
    } else if (!courseDAO.checkIfCourseExists(registration.getCourseName())) {
      InfoBox.Display(notAdded, "This course does not exist");
    } else if (!dao.checkIfRegistrationExists(registration)) {
      InfoBox.Display(notAdded, "A registration with this email for\nthis course on this date already exists");
    } else {
      boolean result = dao.ExecuteInsertStatement(registration);
      if (result) {
        InfoBox.Display("Added registration on ", registration.getCourseName() + " for " + registration.getEmail());
      } else {
        InfoBox.Display(notAdded, "Failed to enroll student to course");
      }
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
      while (rs.next()) {
        selectList.append("===============================");
        selectList.append("Date: " + rs.getString(1) + "\n");
        selectList.append("Email: " + rs.getString(2) + "\n");
        selectList.append("Student: " + rs.getString(3) + "\n");
        selectList.append("===============================");
      }
      InfoBox.Display("Registrations found", selectList.toString());
    }
  }

  public void update(Registration registration) throws SQLException {
    // Check if registration exist
    boolean result = dao.checkIfRegistrationExists(registration);
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
    if (dao.ExecuteDeleteStatement(registration)) {
      InfoBox.Display("Deleted Registration", registration.getEmail() + " has been successfully deleted from\n"
          + registration.getCourseName() + " who registrered on " + registration.getApplicationDate());
    } else {
      InfoBox.Display("Registration not deleted", "Registraion does not exist");
    }
  }

}
