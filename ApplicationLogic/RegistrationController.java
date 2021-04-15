package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    Registration registration = new Registration(email, coursename, getDate());
    boolean result = dao.ExecuteInsertStatement(registration);
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
      ArrayList<String> registrations = new ArrayList<>();
      while (rs.next()) {
        selectList.append("===============================\n").append("Date: " + rs.getString(1) + "\n")
            .append("Student: " + rs.getString(3) + "\n").append("===============================\n");
        registrations.add(selectList.toString());
      }
      StringBuilder createView = new StringBuilder();
      for (int i = 0; i < registrations.size(); i++) {
        createView.append(registrations.get(i) + "\n");
      }

      InfoBox.Display("Registrations found", createView.toString());
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
