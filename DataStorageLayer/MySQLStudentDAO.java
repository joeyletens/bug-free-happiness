package DataStorageLayer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DomainModel.Student;

// This is the student DAO
// Here are the queries made which are used to manage the database

public class MySQLStudentDAO implements StudentDAOInf {

  public static ResultSet executeCommand = null;
  private static PreparedStatement ps;
  private static ResultSet rs;

  // This creates a new student with a prepared statement
  public static boolean create(Student student) throws SQLException {
    // create query
    String query = "INSERT INTO Student VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
      // open connection
      DatabaseConnection.OpenConnection();
      ps = DatabaseConnection.conn.prepareStatement(query);
      // add values to query
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
      // execute and close prepared statement
      ps.executeUpdate();
      ps.close();
      // finally close connection
      DatabaseConnection.CloseConnection();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  // Method to send a request to the database to read data with a specifict email
  public static ResultSet read(String email) throws SQLException {

    String query = "SELECT * FROM Student WHERE email = '?'";
    try {
      ps.setString(1, email);
      rs = ps.executeQuery();
      ps.close();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
      return null;
    }

    return rs;
  }

  // Method to choose which user you want to update their data
  public static boolean update(Student student) {

    // 2. prepare statement
    String ps = "UPDATE Student SET email = '?'";

    // 3. add the variables
    // add.setString(1, student.getEmail());

    return true;
  }

  // Oh no a method to deleted a student via their email
  public static boolean delete(Student student) {

    // 2. prepare statement
    String ps = "DELETE FROM Student WHERE email = '?'";

    // // 3. add the variables
    // add.setString(1, student.getEmail());

    return true;

  }
}
