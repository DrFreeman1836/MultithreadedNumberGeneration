package service.writing;

import dao.NumberDaoManager;
import dao.impl.NumberDao;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import storage.impl.StorageNumber;

public class ManagerWritingNumber {

  private ExecutorService exService;

  public ManagerWritingNumber() {
    exService = Executors.newFixedThreadPool(5);
  }

  public void startWriting(StorageNumber storageNumber, NumberDao numberDao) {

    for (int i = 0; i < 5; i++) {
      exService.submit(new WritingNumber(numberDao, storageNumber, 0, 300_000));
    }

  }

  public void stopWriting(){
    exService.shutdownNow();
  }

}
