package storage;

import java.util.List;

public interface NumberStorageManager {

  /**
   * Add a number
   *
   * @param value
   */
  void addNumber(Integer value);

  /**
   * Delete and return a number
   *
   * @return
   */
  Integer getNumber();

  /**
   * Get a list of numbers
   *
   * @return
   */
  List<Integer> getListNumbers();

}
