package service;

import storage.NumberStorageManager;

public class GenerateNumbers implements Runnable {

  private NumberStorageManager managerStorageNumber;

  private volatile boolean isWorking = true;

  public GenerateNumbers(NumberStorageManager managerStorageNumber) {
    this.managerStorageNumber = managerStorageNumber;
  }

  @Override
  public void run() {

    //

  }

  /**
   * Todo: реализовать генерацию чисел в заданное кол-во потоков
   */

}
