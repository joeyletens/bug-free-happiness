package ApplicationLogic;

import java.sql.SQLException;

// interface for the StudentController and Registration controller
// Gives the classes create, read, update and delete (CRUD)
public interface ControllerInterface {
  public boolean create();

  public void read(String email) throws SQLException;

  public boolean update();

  public void delete(String email) throws SQLException;
}
