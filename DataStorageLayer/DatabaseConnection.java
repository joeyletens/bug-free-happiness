package DataStorageLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

// + ExecuteSelectStatement(query : String) : ResultSet

// + EcecuteInsertStatementQuery : String) : boolean

// + ExecuteDeleteStatementQuery : String) : boolean

// + ExecuteUpdateStatementQuery : String) : boolean

public class DatabaseConnection {

  public Connection conn = null;

  public boolean OpenConnection() {

    try {
      // Dit zijn de instellingen voor de verbinding. Vervang de databaseName indien
      // deze voor jou anders is.
      String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Codecademy;integratedSecurity=true;";

      // Connection beheert informatie over de connectie met de database.

      conn = DriverManager.getConnection(connectionUrl);

      return true;

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  public void CloseConnection() throws SQLException {
    conn.close();
  }

}
