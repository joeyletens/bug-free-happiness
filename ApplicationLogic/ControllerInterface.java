package ApplicationLogic;

public interface ControllerInterface<T> {
  public boolean create(T identifier);

  public T read(T identifier);

  public boolean update(T identifier);

  public boolean delete(T identifier);
}
