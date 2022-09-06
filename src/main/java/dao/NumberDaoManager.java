package dao;


public interface NumberDaoManager {

  /**
   * Save a number
   *
   * @param value
   */
  void save(Integer value);

  /**
   *
   * @return
   */
  int countNumbers();

  /**
   *
   * @return
   */
  int getMinNumber();

  /**
   *
   * @return
   */
  int getMaxNumber();

  /**
   *
   * @return
   */
  int getCountUniqueNumber();

  /**
   *
   */
  void deleteAllNumber();

}