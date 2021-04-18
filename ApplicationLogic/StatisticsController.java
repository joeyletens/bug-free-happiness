package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataStorageLayer.SQLStatisticsDAO;
import Presentation.InfoBox;

public class StatisticsController {
  SQLStatisticsDAO dao = new SQLStatisticsDAO();
  StringBuilder selectList;
  ResultSet rs;

  // for a selected course give the average progress per module
  public void averageProgressPerModule(String courseName) {

    try {
      rs = dao.ExecuteAverageProgress(courseName);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // If resultset is empty display not found
    if (rs == null) {
      InfoBox.Display("No result", "Could not find course, modules or students");
    } else {
      // else read through the whole list
      selectList = new StringBuilder();
      try {
        selectList.append("Average progess results for ").append(courseName)
            .append("\n===============================\n").append("Title: " + rs.getString(1) + "\n")
            .append("Average: " + rs.getString(2) + "\n").append("===============================");
        while (rs.next()) {
          selectList.append("===============================\n").append("Title: " + rs.getString(1) + "\n")
              .append("Average: " + rs.getString(2) + "\n").append("===============================");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      InfoBox.Display("Average progress", selectList.toString());
    }
  }

  // for a selected course and student give the progress per module in percentage
  public void studentProgressPerModule(String courseName, String email) {
    try {
      rs = dao.ExecuteStudentProgress(courseName, email);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // If resultset is empty display not found
    if (rs == null) {
      InfoBox.Display("No result", "Could not find course, modules or students");
    } else {
      // else read through the whole list GET MODULE TITLE AND AVERAGE SCORE
      selectList = new StringBuilder();
      try {
        selectList.append("Average student progess results for ").append(courseName)
            .append("\n===============================\n").append("Title: " + rs.getString(1) + "\n")
            .append("Average: " + rs.getString(2) + "\n").append("===============================\n");
        while (rs.next()) {
          selectList.append("===============================\n").append("Title: " + rs.getString(1) + "\n")
              .append("Average: " + rs.getString(2) + "\n").append("===============================\n");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      InfoBox.Display("Average progress", selectList.toString());
    }
  }

  // give the three most viewed webcasts
  public void topThreeMostViewedWebcasts() {
    try {
      rs = dao.ExecuteTopThree();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // If resultset is empty display not found
    if (rs == null) {
      InfoBox.Display("No result", "Could not find any modules");
    } else {
      // else read through the whole list GET TITLE
      selectList = new StringBuilder();
      try {

        selectList.append("Top three most viewed courses").append("\n===============================\n")
            .append("Title: " + rs.getString(1) + "\n").append("Views: " + rs.getString(2) + "\n");

        while (rs.next()) {
          selectList.append("\n===============================\n").append("Title: " + rs.getString(1) + "\n")
              .append("Views: " + rs.getString(2) + "\n");

        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      InfoBox.Display("Top 3 webcasts", selectList.toString());
    }
  }

  public void studentsWhoPassedACourse(String courseName) {
    // amount of students who passed a certain course
    try {
      rs = dao.ExecutePassedStudent(courseName);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    // If resultset is empty display not found
    if (rs == null) {
      InfoBox.Display("No result", "Could not find any modules");
    } else {
      // else read through the whole list GET AMOUNT
      try {
        InfoBox.Display("Top 3 webcasts", "Amount of students who passed: \n" + courseName + " are " + rs.getString(1));
      } catch (SQLException e) {
        InfoBox.Display("No result", "Could not find any modules");
        e.printStackTrace();
      }
    }
  }
}
