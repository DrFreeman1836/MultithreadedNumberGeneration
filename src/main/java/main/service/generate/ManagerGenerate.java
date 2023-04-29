package main.service.generate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import main.config.Configuration;
import main.storage.impl.StorageNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerGenerate {

  private int countThread = Configuration.getCountThreads();

  private GenerateNumbers generateNumbers;

  private ExecutorService exService;

  @Autowired
  public ManagerGenerate(GenerateNumbers generateNumbers) {
    this.generateNumbers = generateNumbers;
    exService = Executors.newFixedThreadPool(countThread);
  }

  public void startGenerate() {
    for (int i = 0; i < countThread; i++) {
      exService.submit(generateNumbers);
    }
  }

  public void stopGenerate() {
    exService.shutdownNow();
  }

}
