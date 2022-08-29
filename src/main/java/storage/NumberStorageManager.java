package storage;

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

}
