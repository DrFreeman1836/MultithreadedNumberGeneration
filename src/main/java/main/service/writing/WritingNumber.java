package main.service.writing;

import main.dao.impl.NumberDao;
import main.storage.impl.StorageNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class WritingNumber implements Runnable {

  private NumberDao numberDao;

  private StorageNumber storage;

  private int max;

  private int min;


  @Autowired
  public WritingNumber(NumberDao numberDao, StorageNumber storage) {
    this.numberDao = numberDao;
    this.storage = storage;
  }

  public void setMax(int max) {
    this.max = max;
  }

  public void setMin(int min) {
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
