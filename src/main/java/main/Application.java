package main;

import main.config.Config;
import main.config.Configuration;
import main.dao.impl.NumberDao;
import main.service.generate.GenerateNumbers;
import main.service.writing.WritingNumber;
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
    ManagerWritingNumber managerWritingNumber = context.getBean(ManagerWritingNumber.class);
    WritingNumber writingNumber = context.getBean(WritingNumber.class);
    ManagerGenerate managerGenerate = context.getBean(ManagerGenerate.class);
    GenerateNumbers generateNumbers = context.getBean(GenerateNumbers.class);

    long start = System.currentTimeMillis();
    if(Configuration.isClearDB()) numberDao.deleteAllNumber();

    managerGenerate.startGenerate();
    managerWritingNumber.startWriting();

    while (true){
      if(System.currentTimeMillis() - start >= Configuration.getWorkTime()){
        managerGenerate.stopGenerate();
        managerWritingNumber.stopWriting();
        break;
      }
    }


    System.out.println("Кол-во записей: " + numberDao.getCountNumbers());
    System.out.println("Максимальное значение: " + numberDao.getMaxNumber());
    System.out.println("Минимальное значение: " + numberDao.getMinNumber());
    System.out.println("Кол-во уникальных значений: " + numberDao.getCountUniqueNumber());

    dbConnection.closeConnection();
    context.close();
  }

}
