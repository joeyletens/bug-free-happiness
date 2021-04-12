package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DomainModel.Student;

// this class opens and closes database connection
// executes all 4 CRUD statements. 

public class DatabaseConnection {

  private ResultSet rs;
  private final String DB_USERNAME = "sa";
  private final String DB_PASSWORD = "QuattroIsLeuk";
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=CodecademyStudent";
  private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
  public Connection conn = null;

  private final String SQL_INSERT = "INSERT INTO StudentVerticalSlice VALUES (?, ?, ? ,? , ?, ?, ?, ?, ?, ?);";
  private final String SQL_SELECT = "SELECT * FROM StudentVerticalSlice WHERE email = ?;";
  private final String SQL_DELETE = "DELETE FROM StudentVerticalSlice WHERE email = ?;";
  private PreparedStatement ps;

  // // Executes insert statement
  public boolean ExecuteInsertStatement(Student student) throws SQLException {
    try {
      // import and get connection
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
      ps = conn.prepareStatement(SQL_INSERT);

      // Added paramter values to prepared statement
      ps.setString(1, student.getEmail());
      ps.setString(2, student.getFirstName());
      ps.setString(3, student.getLastName());
      ps.setString(4, student.getDateOfBirth());
      ps.setString(5, student.getGender());
      ps.setString(6, student.getStreet());
      ps.setString(7, student.getHousenumber());
      ps.setString(8, student.getPostalCode());
      ps.setString(9, student.getCity());
      ps.setString(10, student.getCountry());

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
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      // Create prepatedStatement
      ps = conn.prepareStatement(SQL_SELECT);
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

  public boolean ExecuteDeleteStatement(String email) throws SQLException {
    try {
      // If entered email does not exist
      if (ExecuteSelectStatement(email) == null) {
        return false;
      }
      // Import, get connection, create prepared statement
      Class.forName(JDBC_DRIVER);
      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
      ps = conn.prepareStatement(SQL_DELETE);

      // Set email in prepared statement
      ps.setString(1, email);

      // Execute delete statement
      ps.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public boolean ExecuteUpdateStatement() throws SQLException {

    return true;
  }

}
