package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ApplicationLogic.RegistrationController;
import DomainModel.Registration;

// this class opens and closes database connection
// executes all 4 CRUD statements. 

public class SQLRegistrationDAO {

  // Databse connection login and import
  private final String DB_USERNAME = "sa";
  private final String DB_PASSWORD = "QuattroIsLeuk";
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=QuatroCodecademy";
  private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

  // The CRUD prepared statements
  private final String SQL_INSERT = "INSERT INTO Registration VALUES (?, ?, ?);";
  private final String SQL_SELECT = "SELECT * FROM Registration WHERE Email = ?;";
  private final String SQL_DELETE = "DELETE FROM Registration WHERE email = ? AND CourseName = ? AND RegistrationDate = ?;";
  private final String SQL_CHECK = "SELECT * FROM Registration WHERE email = ? AND CourseName = ? AND RegistrationDate = ?;";
  private final String SQL_UPDATE = "UPDATE Registration SET RegistrationDate = ? WHERE email = ? AND CourseName = ? AND RegistrationDate = ?;";

  // Prepared statement and resultset pre defined
  private PreparedStatement ps;
  private ResultSet rs;
  RegistrationController registrationController;
  Connection connSelect;

  // // Executes insert statement
  public boolean ExecuteInsertStatement(Registration registration) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and get connection
      Class.forName(JDBC_DRIVER);
      ps = conn.prepareStatement(SQL_INSERT);

      // Added paramter values to prepared statement
      ps.setString(1, registration.getApplicationDate());
      ps.setString(2, registration.getEmail());
      ps.setString(3, registration.getCourseName());

      // Execute the prepared statement
      ps.executeUpdate();
      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // // excute the prepared statement
  public ResultSet ExecuteSelectStatement(String email) throws SQLException {
    try {
      // import and connect to database
      Class.forName(JDBC_DRIVER);
      connSelect = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
      // Create prepatedStatement
      ps = connSelect.prepareStatement(SQL_SELECT);
      ps.setString(1, email);

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

  public boolean ExecuteDeleteStatement(Registration registration) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // Import, get connection, create prepared statement
      Class.forName(JDBC_DRIVER);

      // Check if exists
      if (ExecuteSelectStatement(registration.getEmail()) == null) {
        return false;
      }

      // prepare statement and insert query
      ps = conn.prepareStatement(SQL_DELETE);

      // Prepare statement
      ps.setString(1, registration.getEmail());
      ps.setString(2, registration.getCourseName());
      ps.setString(3, registration.getApplicationDate());

      // Execute delete statement
      ps.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean ExecuteUpdateStatement(Registration registration) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and get connection

      // Check if exists
      if (ExecuteSelectStatement(registration.getEmail()) == null) {
        return false;
      }

      // Create registration controller to get current date
      Class.forName(JDBC_DRIVER);
      registrationController = new RegistrationController();

      // Prepare statement
      ps = conn.prepareStatement(SQL_UPDATE);
      ps.setString(1, registrationController.getDate());
      ps.setString(2, registration.getEmail());
      ps.setString(3, registration.getCourseName());
      ps.setString(4, registration.getApplicationDate());

      // Execute the prepared statement
      ps.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean checkIfRegistrationExists(Registration registration) throws SQLException {
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
      // import and connect to database
      Class.forName(JDBC_DRIVER);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_CHECK);
      ps.setString(1, registration.getEmail());
      ps.setString(2, registration.getCourseName());
      ps.setString(3, registration.getApplicationDate());

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
