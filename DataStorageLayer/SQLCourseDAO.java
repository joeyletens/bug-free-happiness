package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DomainModel.Viewed;

public class SQLCourseDAO {

  // Databse connection login and import
  private final String DB_USERNAME = "sa";
  private final String DB_PASSWORD = "QuattroIsLeuk";
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=CodecademyStudent";
  private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  // The CRUD prepared statements
  private final String SQL_CHECKCOURSE = "SELECT * FROM Course WHERE coursename = ?;";
  private final String SQL_CHECKREGISTRATION = "SELECT * FROM Registration WHERE email = ? ;";
  private final String SQL_CONTENTGETPROGRESS = "SELECT * FROM Viewed WHERE ContentId = ? AND Email = ? ORDER BY timestamp ASC;";
  private final String SQL_CONTENTMAKEPROGRESS = "UPDATE Viewed SET Progress ? WHERE ContentId = ? AND Email = ? ORDER BY timestamp ASC;";

  // Prepared statement and resultset pre defined
  private PreparedStatement ps;
  private ResultSet rs;

  // This method checks if a course exists for the registration
  public boolean checkIfCourseExists(String courseName) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CHECKCOURSE);
      ps.setString(1, courseName);

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // This method checks if a registration exists for the module
  public boolean checkIfRegistrationExists(Viewed viewed) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CHECKREGISTRATION);
      ps.setString(1, viewed.getEmail());

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // This method return a student's progress in a specific module
  public float returnModuleProgress(Viewed viewed) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CONTENTGETPROGRESS);
      ps.setString(1, viewed.getEmail());
      ps.setInt(2, viewed.getContentId());

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return ((Number) rs.getObject(3)).intValue();
      } else {
        return -1;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  // this method returns a student's progress in a specific webcast
  public float returnWebcastProgress(Viewed viewed) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CONTENTGETPROGRESS);
      ps.setString(1, viewed.getEmail());
      ps.setInt(2, viewed.getContentId());

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return ((Number) rs.getObject(3)).intValue();
      } else {
        return -1;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  // With this method a studentcan make progrss
  public boolean makeModuleProgress(int progress, Viewed viewed) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Get current progress
      int currentProgress = (int) returnModuleProgress(viewed) + progress;

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CONTENTMAKEPROGRESS);
      ps.setInt(1, currentProgress);
      ps.setString(2, viewed.getEmail());
      ps.setInt(3, viewed.getContentId());

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public boolean makeWebcastProgress(int progress, Viewed viewed) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Get current progress
      int currentProgress = (int) returnModuleProgress(viewed) + progress;

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CONTENTMAKEPROGRESS);
      ps.setInt(1, currentProgress);
      ps.setString(2, viewed.getEmail());
      ps.setInt(3, viewed.getContentId());

      // execute select and put it in a resultset
      rs = ps.executeQuery();

      // Check if result is not empty
      if (rs.next()) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

}
