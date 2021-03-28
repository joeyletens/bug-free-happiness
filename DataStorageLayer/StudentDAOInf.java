package DataStorageLayer;

import java.sql.SQLException;

import DomainModel.Student;

public interface StudentDAOInf {
  public boolean create(Student student) throws SQLException;

  public String read(Student student) throws SQLException;

  public boolean update(Student student) throws SQLException;

  public boolean delete(Student student) throws SQLException;
}