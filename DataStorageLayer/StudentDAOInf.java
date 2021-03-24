package DataStorageLayer;

import DomainModel.Student;

public interface StudentDAOInf {
  public boolean create(Student student);

  public String read(Student student);

  public boolean update(Student student);

  public boolean delete(Student student);
}