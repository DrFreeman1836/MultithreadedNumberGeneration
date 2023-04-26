package main;

import main.config.Config;
import main.config.Configuration;
import main.dao.impl.NumberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import main.service.generate.ManagerGenerate;
import main.service.writing.ManagerWritingNumber;
import main.storage.impl.StorageNumber;
import main.util.DBConnection;


public class Application {

  public static void main(String[] args) throws Exception {

    Configuration.setConfiguration();
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    DBConnection dbConnection = context.getBean(DBConnection.class);
    NumberDao numberDao = context.getBean(NumberDao.class);
    StorageNumber storageNumber = context.getBean(StorageNumber.class);

    long start = System.currentTimeMillis();
    if(Configuration.isClearDB()) numberDao.deleteAllNumber();

//    ManagerGenerate managerGenerate = new ManagerGenerate(Configuration.getCountThreads());
//    managerGenerate.startGenerate(storageNumber);
//
//    ManagerWritingNumber managerWritingNumber = new ManagerWritingNumber();
//    managerWritingNumber.startWriting(storageNumber, numberDao);
//
//    while (true){
//      if(System.currentTimeMillis() - start >= Configuration.getWorkTime()){
//        managerGenerate.stopGenerate();
//        managerWritingNumber.stopWriting();
//        break;
//      }
//    }
//
//    System.out.println("Кол-во записей: " + numberDao.getCountNumbers());
//    System.out.println("Максимальное значение: " + numberDao.getMaxNumber());
//    System.out.println("Минимальное значение: " + numberDao.getMinNumber());
//    System.out.println("Кол-во уникальных значений: " + numberDao.getCountUniqueNumber());

    dbConnection.closeConnection();
    context.close();
  }

}
