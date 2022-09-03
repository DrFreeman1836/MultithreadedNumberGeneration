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
   * Return a number
   *
   * @return
   */
  Integer getNumber();

  /**
   * Delete a number
   *
   * @return
   */
  void removeNumber();

  /**
   * Get a list of numbers
   *
   * @return
   */
  List<Integer> getListNumbers();

}
