package DataStorageLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataStorageLayer.DatabaseConnection.*;
import DomainModel.Student;

public class MySQLStudentDAO implements StudentDAOInf {

  public static ResultSet executeCommand = null;
  public static PreparedStatement add = null;

  @Override
  public static boolean create(Student student) throws SQLException {

    // 2. prepare statement
    String ps = "INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // 3. add the variables
    add.setString(1, student.getEmail());
    add.setString(2, student.getFirstName());
    add.setString(3, student.getLastName());
    add.setString(4, student.getDateOfBirth());
    add.setString(5, student.getGender());
    add.setString(6, student.getStreet());
    add.setString(7, student.getHousenumber());
    add.setString(8, student.getPostalCode());
    add.setString(9, student.getCity());
    add.setString(10, student.getCountry());

    return true;

  }

  @Override
  public static String read(Student student) {

    String query = "SELECT * FROM Student WHERE email = '?'";

    add.setString(1, student.getEmail());

    return null;

  }

  @Override
  public static boolean update(Student student) {
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
  public static boolean delete(Student student) {
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
