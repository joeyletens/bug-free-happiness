package ApplicationLogic;

import java.sql.SQLException;

import DomainModel.Student;

// interface for the StudentController and Registration controller
// Gives the classes create, read, update and delete (CRUD)
public interface ControllerInterface {
  public void create(Student student) throws SQLException;

  public void read(String email) throws SQLException;

  public void update(String email, String newEmail) throws SQLException;

  public void delete(String email) throws SQLException;
}
