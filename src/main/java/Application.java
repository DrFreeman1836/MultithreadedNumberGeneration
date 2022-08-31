import dao.NumberDaoManager;
import dao.impl.NumberDao;
import model.Number;
import service.GenerateNumbers;
import storage.NumberStorageManager;
import storage.impl.StorageNumber;

import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Application {

  public static void main(String[] args) {

//    Number n = Number.builder().number(100).date(new Date()).build();
//
//    Number n2 = Number.builder().number(100).date(new Date()).build();
//
//    NumberDaoManager manager = new NumberDao();
//
//    manager.save(n);
//    manager.save(n2);
//
//
//
//
//    try {
//      Thread.sleep(2000000000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }

    NumberStorageManager storage = new StorageNumber();
    ExecutorService exService = Executors.newFixedThreadPool(4);

    for(int i = 0; i <= 3; i++){
      exService.submit(new GenerateNumbers(storage));
    }

    try {
      Thread.sleep(5_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    exService.shutdownNow();
    storage.getListNumbers().forEach(System.out::println);
    System.out.println(storage.getListNumbers().size());
    System.out.println("Всё");


  }

}
