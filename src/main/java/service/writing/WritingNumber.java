package service.writing;

import dao.impl.NumberDao;
import storage.impl.StorageNumber;

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
        if (Thread.interrupted()) {
          System.out.println("запись все");
          return;
        }
        Integer value = storage.getNumber();
        if(value == null) continue;
        if (value >= min && value <= max) {
          storage.removeNumber();
          storage.add(value);
          //numberDao.save(null);//exception
        }
      } catch (Exception ex) {
        ex.printStackTrace();
        return;
      }
    }
  }

}
