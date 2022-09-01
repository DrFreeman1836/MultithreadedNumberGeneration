package service.generate;

import storage.NumberStorageManager;

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
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
      if (Thread.interrupted()) {
        return;
      }

      int value = ThreadLocalRandom.current().nextInt(1, 500_001);
      managerStorageNumber.addNumber(value);

    }

  }


}
