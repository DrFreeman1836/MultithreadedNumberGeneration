package main.service.generate;

import main.storage.NumberStorageManager;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateNumbers implements Runnable {

  private NumberStorageManager managerStorageNumber;

  public GenerateNumbers(NumberStorageManager managerStorageNumber) {
    this.managerStorageNumber = managerStorageNumber;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
        int value = ThreadLocalRandom.current().nextInt(1, 500_001);
        managerStorageNumber.addNumber(value);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
        return;
      }
    }
  }


}
