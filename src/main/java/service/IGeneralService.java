package service;

import java.util.List;

public interface IGeneralService<T> {

  List<T> show();

  boolean create(T t);

  boolean update(int id, T t);

  boolean delete(int id);

  T findById(int id);
}
