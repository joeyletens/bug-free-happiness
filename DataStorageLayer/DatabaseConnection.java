package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// this class opens and closes database connection
// executes all 4 CRUD statements. 

public class DatabaseConnection {

  public Connection conn = null;
  private Statement stmt;
  private ResultSet rs;
  private final String DB_USERNAME = "sa";
  private final String DB_PASSWORD = "QuattroIsLeuk";
  private final String DB_URL = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=CodecademyStudent";

  // open a connection with the database
  public boolean openConnection() {

    try {
      // database URL
      // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  // Closes connection with database
  // public final boolean CloseConnection() throws SQLException {
  // try {
  // conn.close();
  // return true;
  // } catch (Exception e) {
  // e.printStackTrace();
  // return false;
  // }
  // }

  // // Executes insert statement
  // public final boolean ExecuteInsertStatement(String query, PreparedStatement
  // ps) throws SQLException {
  // OpenConnection();

  // stmt = conn.createStatement();

  // rs = stmt.executeQuery(query);

  // CloseConnection();

  // return true;
  // }

  // // excute the prepared statement
  // public final ResultSet ExecuteSelectStatement(String query,
  // PreparedStatement ps) throws SQLException {

  // OpenConnection();

  // stmt = conn.createStatement();

  // rs = stmt.executeQuery(query);

  // CloseConnection();

  // return rs;

  // }

  // public boolean ExecuteDeleteStatement(Student student) throws SQLException {

  // return true;
  // }

  // public boolean ExecuteUpdateStatement(Student student) throws SQLException {

  // return true;
  // }

}
