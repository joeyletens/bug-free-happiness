package ApplicationLogic;

import java.sql.ResultSet;
import java.sql.SQLException;

import DataStorageLayer.SQLStatisticsDAO;
import Presentation.InfoBox;

public class StatisticsController {
  SQLStatisticsDAO dao = new SQLStatisticsDAO();
  StringBuilder selectList;
  ResultSet rs;

  public void averageProgressPerModule(String courseName) {
    // for a selected course give the average progress per module
    try {
      rs = dao.ExecuteAverageProgress(courseName);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (rs == null) {
      // If resultset is empty display not found
      InfoBox.Display("", "");
    } else {
      // else read through the whole list
      selectList = new StringBuilder();
      try {
        while (rs.next()) {
          selectList.append("===============================");
          selectList.append("Date: " + rs.getString(1) + "\n");
          selectList.append("Email: " + rs.getString(2) + "\n");
          selectList.append("Student: " + rs.getString(3) + "\n");
          selectList.append("===============================");
        }
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      InfoBox.Display("Registrations found", selectList.toString());
    }
  }

  public void studentProgressPerModule(String courseName, String email) {
    // for a selected course and student give the progress per module in percentage
  }

  public void topThreeMostViewedWebcasts() {
    // give the three most viewed webcasts
  }

  public void studentsWhoPassedACourse(String courseName) {
    // amount of students who passed a certain course
  }
}
