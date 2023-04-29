package main.service.writing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import main.dao.impl.NumberDao;
import main.storage.impl.StorageNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerWritingNumber {

  private ExecutorService exService;

  private NumberDao numberDao;

  private StorageNumber storage;


  private int[] temp = {0, 100_000, 200_000, 300_000, 400_000, 500_000};

  @Autowired
  public ManagerWritingNumber(NumberDao numberDao, StorageNumber storage) {
    this.numberDao = numberDao;
    this.storage = storage;
    exService = Executors.newFixedThreadPool(5);
  }

  public void startWriting() {
    for (int i = 0; i < 5; i++) {
      exService.submit(new WritingNumber(numberDao, storage, temp[i+1], temp[i]));
    }
  }

  public void stopWriting(){
    exService.shutdownNow();
  }

}
