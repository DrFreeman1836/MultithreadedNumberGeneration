import service.generate.ManagerGenerate;
import storage.impl.StorageNumber;


public class Application {

  public static void main(String[] args) {

    //конфиги программы

    StorageNumber storageNumber = new StorageNumber();
    ManagerGenerate managerGenerate = new ManagerGenerate(5);//new thread
    managerGenerate.startGenerate(storageNumber);

    //запись в бд в новом потоке

    //проверка истечения времени
    //managerGenerate.stopGenerate();

    //вывод инфы

    //завершаем




//    Number n = Number.builder().number(100).date(new Date()).build();
//
//    Number n2 = Number.builder().number(100).date(new Date()).build();
//
//    NumberDaoManager manager = new NumberDao();
//
//    manager.save(n);
//    manager.save(n2);

    try {
      Thread.sleep(5_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    managerGenerate.stopGenerate();

    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    storageNumber.getListNumbers().forEach(System.out::println);
    System.out.println(storageNumber.getListNumbers().size());
    System.out.println("Всё");


  }

}
