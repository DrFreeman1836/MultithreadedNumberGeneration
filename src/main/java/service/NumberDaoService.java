package service;

import dao.NumberDaoManager;
import storage.NumberStorageManager;

public class NumberDaoService {

  private NumberDaoManager numberManager;

  private NumberStorageManager managerStorageNumber;

  public NumberDaoService(NumberDaoManager numberManager,
      NumberStorageManager managerStorageNumber) {
    this.numberManager = numberManager;
    this.managerStorageNumber = managerStorageNumber;
  }

  /**
   * Todo: реализовать слушателя хранилища чисел и запись в БД в 5 поток
   */

}
