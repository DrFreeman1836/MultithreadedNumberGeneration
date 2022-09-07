import config.Configuration;
import dao.impl.NumberDao;
import service.generate.ManagerGenerate;
import service.writing.ManagerWritingNumber;
import storage.impl.StorageNumber;
import util.DBConnection;


public class Application {

  public static void main(String[] args) throws Exception {

    long start = System.currentTimeMillis();
    Configuration.setConfiguration();

    StorageNumber storageNumber = new StorageNumber();
    NumberDao numberDao = new NumberDao();
    if(Configuration.isClearDB()) numberDao.deleteAllNumber();

    ManagerGenerate managerGenerate = new ManagerGenerate(Configuration.getCountThreads());
    managerGenerate.startGenerate(storageNumber);

    ManagerWritingNumber managerWritingNumber = new ManagerWritingNumber();
    managerWritingNumber.startWriting(storageNumber, numberDao);

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

    DBConnection.closeConnection();

  }

}
