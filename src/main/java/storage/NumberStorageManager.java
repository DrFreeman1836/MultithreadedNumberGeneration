package storage;

import java.util.List;

public interface NumberStorageManager {

  /**
   * Add a number to the top
   *
   * @param value
   */
  void addNumber(Integer value);

  /**
   * Delete and return the top number
   *
   * @return
   */
  Integer getFirstNumber();

  /**
   * Get a list of numbers
   *
   * @return
   */
  List<Integer> getListNumbers();

}
