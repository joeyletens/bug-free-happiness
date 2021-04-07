package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DomainModel.Student;

// + ExecuteSelectStatement(query : String) : ResultSet

// + ExecuteDeleteStatementQuery : String) : boolean

// + ExecuteUpdateStatementQuery : String) : boolean

public class DatabaseConnection {

  public static Connection conn = null;
  private static Statement stmt;
  private static ResultSet rs;

  // open a connection with the database
  public static boolean OpenConnection() {

    try {
      // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien
      // deze voor jou anders is.
      String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Codecademyw;integratedSecurity=true;";

      // Connection beheert informatie over de connectie met de database.

      conn = DriverManager.getConnection(connectionUrl);

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public static boolean CloseConnection() throws SQLException {
    try {
      conn.close();
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

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
