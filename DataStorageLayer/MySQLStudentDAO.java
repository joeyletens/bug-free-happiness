package DataStorageLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DomainModel.Student;

public class MySQLStudentDAO implements StudentDAOInf {

  public ResultSet executeCommand = null;
  public PreparedStatement add = null;

  @Override
  public boolean create(Student student) throws SQLException {

    try {

      // 1. Get a connection to database
      DatabaseConnection.OpenConnection();

      // 2. prepare statement
      String ps = "INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

      // 3. add the variables
      add.setString(1, student.getEmail());
      add.setString(2, student.getFirstName());
      add.setString(3, student.getLastName());
      add.setString(4, student.getDateOfBirth());
      add.setString(5, student.getGender());
      add.setString(6, student.getAddress());
      add.setString(7, student.getPostalCode());
      add.setString(8, student.getCity());
      add.setString(9, student.getCountry());

      // 4. execute SQL query CHANGE TO send to method in DatabaseConnection with a
      // INSERT INTO preparedStatement
      executeCommand = add.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    DatabaseConnection.CloseConnection();

    return true;
  }

  @Override
  public String read(Student student) throws SQLException {
    try {

      // 1. Get a connection to database
      DatabaseConnection.OpenConnection();

      // 2. prepare statement
      String ps = "SELECT Student WHERE email = '?'";

      // 3. add the variables
      add.setString(1, student.getEmail());

      // 4. execute SQL query

    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    }

    DatabaseConnection.CloseConnection();

    return null;
  }

  @Override
  public boolean update(Student student) throws SQLException {
    try {

      // 1. Get a connection to database
      DatabaseConnection.OpenConnection();

      // 2. prepare statement
      String ps = "UPDATE Student SET email = '?'";

      // 3. add the variables
      add.setString(1, student.getEmail());

      // 4. execute SQL query
      executeCommand = add.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    DatabaseConnection.CloseConnection();

    return true;
  }

  @Override
  public boolean delete(Student student) throws SQLException {
    try {

      // 1. Get a connection to database
      DatabaseConnection.OpenConnection();

      // 2. prepare statement
      String ps = "DELETE FROM Student WHERE email = '?'";

      // 3. add the variables
      add.setString(1, student.getEmail());

      // 4. execute SQL query
      executeCommand = add.executeQuery();

    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    }

    DatabaseConnection.CloseConnection();

    return true;
  }

}
