import config.Configuration;
import dao.impl.NumberDao;
import service.generate.ManagerGenerate;
import service.writing.ManagerWritingNumber;
import storage.impl.StorageNumber;
import util.DBConnection;


public class Application {

  public static void main(String[] args) throws Exception {

    Configuration.setConfiguration();

    StorageNumber storageNumber = new StorageNumber();
    NumberDao numberDao = new NumberDao();

    //генерирование
    ManagerGenerate managerGenerate = new ManagerGenerate(Configuration.getCountThreads());
    managerGenerate.startGenerate(storageNumber);

    //запись в бд
    ManagerWritingNumber managerWritingNumber = new ManagerWritingNumber();
    managerWritingNumber.startWriting(storageNumber, numberDao);

    //проверка истечения времени
//    while (true){
//
//    }

    //завершить потоки
    managerGenerate.stopGenerate();
    managerWritingNumber.stopWriting();

    //вывод инфы

    //завершаем
    DBConnection.closeConnection();


  }

}
