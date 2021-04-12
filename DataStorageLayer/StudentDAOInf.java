package DataStorageLayer;

import DomainModel.Student;

public interface StudentDAOInf {
  public boolean create(Student student);

  public String read();

  public boolean update();

  public boolean delete();
}