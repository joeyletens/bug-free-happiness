package ApplicationLogic;

// interface for the StudentController and Registration controller
// Gives the classes create, read, update and delete (CRUD)
public interface ControllerInterface {
  public boolean create();

  public String read();

  public boolean update();

  public boolean delete();
}
