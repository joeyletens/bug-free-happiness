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
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=CodecademyStudent";
  private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  // The CRUD prepared statements
  private final String SQL_AVERAGEPROGRESS = "";
  private final String SQL_STUDENTPROGRESS = "";
  private final String SQL_TOPTHREE = "";
  private final String SQL_PASSEDSTUDENT = "";

  // Prepared statement and resultset pre defined
  private PreparedStatement ps;
  private ResultSet rs;

  // // excute the prepared statement
  public ResultSet ExecuteAverageProgress(String courseName) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_AVERAGEPROGRESS);

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
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_STUDENTPROGRESS);

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
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

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
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_PASSEDSTUDENT);

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
