package service.writing;

import dao.NumberDaoManager;
import storage.impl.StorageNumber;

public class ObserverNumberStore {

  private NumberDaoManager numberManager;

  private StorageNumber storageNumber;

  public ObserverNumberStore(NumberDaoManager numberManager, StorageNumber storageNumber) {
    this.numberManager = numberManager;
    this.storageNumber = storageNumber;
  }

  private void saveNewNumber(Integer value) {
    System.out.println("Сохранили новое число: " + value);
  }

  /**
   * Todo: реализовать запись в БД в 5 потоков
   */

}
