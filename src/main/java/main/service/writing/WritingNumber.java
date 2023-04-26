package main.service.writing;

import main.dao.impl.NumberDao;
import main.storage.impl.StorageNumber;

public class WritingNumber implements Runnable {

  private NumberDao numberDao;

  private StorageNumber storage;

  private int max;

  private int min;


  public WritingNumber(NumberDao numberDao, StorageNumber storage, int max, int min) {
    this.numberDao = numberDao;
    this.storage = storage;
    this.max = max;
    this.min = min;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);
        Integer value = storage.getNumber();
        if(value == null) continue;
        if (value > min && value <= max) {
          storage.removeNumber();
          numberDao.save(value);
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        return;
      }
    }
  }

}
