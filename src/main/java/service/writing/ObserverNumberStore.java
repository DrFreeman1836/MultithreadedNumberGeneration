package service.writing;

import dao.NumberDaoManager;

public class ObserverNumberStore {

  private NumberDaoManager numberManager;


  public ObserverNumberStore(NumberDaoManager numberManager) {
    this.numberManager = numberManager;
  }

  private void saveNewNumber(Integer value) {
    System.out.println("Сохранили новое число: " + value);
  }

  /**
   * Todo: реализовать слушателя хранилища чисел и запись в БД в 5 потоков
   */

}
