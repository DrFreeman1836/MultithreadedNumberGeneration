import dao.NumberDaoManager;
import dao.impl.NumberDao;
import model.Number;

import java.util.Date;

public class Application {

  public static void main(String[] args) {

    Number n = Number.builder().number(100).date(new Date()).build();

    Number n2 = Number.builder().number(100).date(new Date()).build();

    NumberDaoManager manager = new NumberDao();

    manager.save(n);
    manager.save(n2);




    try {
      Thread.sleep(2000000000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

}
