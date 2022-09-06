package service.writing;

import dao.impl.NumberDao;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import storage.impl.StorageNumber;

public class ManagerWritingNumber {

  private ExecutorService exService;

  private int[] temp = {0, 100_000, 200_000, 300_000, 400_000, 500_000};

  public ManagerWritingNumber() {
    exService = Executors.newFixedThreadPool(5);
  }

  public void startWriting(StorageNumber storageNumber, NumberDao numberDao) {
    for (int i = 0; i < 5; i++) {
      exService.submit(new WritingNumber(numberDao, storageNumber, temp[i+1], temp[i]));
    }
  }

  public void stopWriting(){
    exService.shutdownNow();
  }

}
