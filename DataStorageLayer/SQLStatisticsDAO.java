package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLStatisticsDAO {
  // Databse connection login and import
  private final String DB_USERNAME = "sa";
  private final String DB_PASSWORD = "QuattroIsLeuk";
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=QuatroCodecademy";
  private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  // The CRUD prepared statements
  private final String SQL_AVERAGEPROGRESS = "SELECT Module.Title, AVG((Viewed.Progress * 100)/Content.duration) AS AVG_Progress FROM Viewed RIGHT JOIN ContentItem AS Content ON Viewed.ContentId = Content.ContentId RIGHT JOIN Module AS Module ON Content.ContentId = Module.ContentId RIGHT JOIN Student ON Student.Email = Viewed.Email WHERE CourseName = ? GROUP BY Module.Title";
  private final String SQL_STUDENTPROGRESS = "SELECT Module.title, AVG((Viewed.Progress * 100)/Content.duration) AS AVG_Progress FROM Viewed RIGHT JOIN ContentItem AS Content ON Viewed.ContentId = Content.ContentId RIGHT JOIN Module AS Module ON Content.ContentId = Module.ContentId RIGHT JOIN Student ON Student.Email = Viewed.Email WHERE student.Email = ? AND Module.CourseName = ? GROUP BY Module.Title;";
  private final String SQL_TOPTHREE = "SELECT TOP 3 Webcast.Title, COUNT(Email) AS Views FROM Webcast LEFT JOIN Viewed ON Webcast.ContentId = Viewed.ContentId GROUP BY Webcast.Title ORDER BY COUNT(Email) DESC;";
  private final String SQL_PASSEDSTUDENT = "SELECT * FROM Course WHERE Course = ?";

  // Prepared statement and resultset pre defined
  private PreparedStatement ps;
  private ResultSet rs;
  Connection conn;

  // // excute the prepared statement
  public ResultSet ExecuteAverageProgress(String courseName) throws SQLException {
    try {
      // import and connect to database
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_AVERAGEPROGRESS);
      ps.setString(1, courseName);

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return rs;
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ResultSet ExecuteStudentProgress(String courseName, String email) throws SQLException {
    try {
      // import and connect to database
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_STUDENTPROGRESS);
      ps.setString(1, email);
      ps.setString(2, courseName);

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return rs;
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ResultSet ExecuteTopThree() throws SQLException {
    try {
      // import and connect to database
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_TOPTHREE);

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return rs;
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ResultSet ExecutePassedStudent(String courseName) throws SQLException {
    try {
      // import and connect to database
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_PASSEDSTUDENT);
      ps.setString(1, courseName);

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return rs;
      } else {
        return null;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
