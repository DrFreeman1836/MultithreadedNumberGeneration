package main.service.generate;

import main.storage.NumberStorageManager;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class GenerateNumbers implements Runnable {

  private NumberStorageManager managerStorageNumber;

  @Autowired
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
