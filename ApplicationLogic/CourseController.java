package ApplicationLogic;

import java.sql.SQLException;

import DataStorageLayer.SQLCourseDAO;
import DomainModel.Viewed;
import Presentation.InfoBox;

public class CourseController {
  SQLCourseDAO dao = new SQLCourseDAO();

  public void getModuleProgress(Viewed viewed) {
    // This method return a students progress in a certain module and display it
    int result = -1;
    try {
      result = (int) dao.returnModuleProgress(viewed);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Check if result is larger than -1 if true return result
    if (result < 0) {
      InfoBox.Display("No progress found", "Student is not enrolled to course\nor could not find module");
    } else {
      InfoBox.Display("Module progress", "Student made " + result + "% progress");
    }
  }

  public void getWebcastProgress(Viewed viewed) {
    // This method returns the progress made by a student and displays it
    int result = -1;
    try {
      result = (int) dao.returnWebcastProgress(viewed);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Check if result is larger than -1 if true return result
    if (result < 0) {
      InfoBox.Display("No progress found", "Student is not enrolled to course\nor could not find webcast");
    } else {
      InfoBox.Display("Webcast progress", "Student made " + result + "% progress");
    }
  }

  public void makeProgressInModule(int progress, Viewed viewed) {
    // lets a student make progress in a module
    boolean result = false;
    try {
      result = dao.makeModuleProgress(progress, viewed);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Check if result is larger than true if true return result
    if (!result) {
      InfoBox.Display("No progress made", "Student is not enrolled to course\nor could not find module");
    } else {
      InfoBox.Display("Module progress made", "Student has successfully made progress");
    }
  }

  public void makeProgressInWebcast(int progress, Viewed viewed) {
    // lets a student make progress in a webcast
    boolean result = false;
    try {
      result = dao.makeWebcastProgress(progress, viewed);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // Check if result is larger than true if true return result
    if (!result) {
      InfoBox.Display("No progress made", "Could not find webcast or student");
    } else {
      InfoBox.Display("Webcast progress made", "Student has successfully made progress");
    }
  }

  public boolean checkIfStudentIsRegisteredToCourse() {
    // This method returns a boolean value to check if the student is registrered to
    // a course

    return false;
  }

}
