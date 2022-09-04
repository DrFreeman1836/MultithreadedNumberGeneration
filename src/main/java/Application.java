import dao.impl.NumberDao;
import service.generate.ManagerGenerate;
import service.writing.ManagerWritingNumber;
import storage.impl.StorageNumber;


public class Application {

  public static void main(String[] args) {

    //конфиги программы

    StorageNumber storageNumber = new StorageNumber();
    NumberDao numberDao = new NumberDao();

    ManagerGenerate managerGenerate = new ManagerGenerate(5);
    managerGenerate.startGenerate(storageNumber);

    //запись в бд в новом потоке
    ManagerWritingNumber managerWritingNumber = new ManagerWritingNumber();
    managerWritingNumber.startWriting(storageNumber, numberDao);


    //проверка истечения времени
    //managerGenerate.stopGenerate();
    //managerWritingNumber.stopWriting();

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
    managerWritingNumber.stopWriting();

    try {
      Thread.sleep(1_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    storageNumber.getListNumbers().forEach(System.out::println);
    System.out.println(storageNumber.getListNumbers().size());
    System.out.println("===============");
    storageNumber.getList().forEach(System.out::println);
    System.out.println(storageNumber.getList().size());
    System.out.println("Всё");


  }

}
