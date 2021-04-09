package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DomainModel.Student;

// this class opens and closes database connection
// executes all 4 CRUD statements. 

public class DatabaseConnection {

  public static Connection conn = null;
  private static Statement stmt;
  private static ResultSet rs;

  // open a connection with the database
  public static boolean OpenConnection() {

    try {
      // database URL

      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=CodecademyStudent;integratedSecurity=true;";

      conn = DriverManager.getConnection(connectionUrl);

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // Closes connection with database
  public static boolean CloseConnection() throws SQLException {
    try {
      conn.close();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // Executes insert statement
  public static boolean ExecuteInsertStatement(String query, PreparedStatement ps) throws SQLException {
    OpenConnection();

    stmt = conn.createStatement();

    rs = stmt.executeQuery(query);

    CloseConnection();

    return true;
  }

  // excute the prepared statement
  public static ResultSet ExecuteSelectStatement(String query, PreparedStatement ps) throws SQLException {

    OpenConnection();

    stmt = conn.createStatement();

    rs = stmt.executeQuery(query);

    CloseConnection();

    return rs;

  }

  public boolean ExecuteDeleteStatement(Student student) throws SQLException {

    return true;
  }

  public boolean ExecuteUpdateStatement(Student student) throws SQLException {

    return true;
  }

}
