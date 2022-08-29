import dao.NumberManager;
import dao.impl.NumberDao;
import java.util.Date;
import model.Numbers;

public class Application {

  public static void main(String[] args) {

    Numbers n = Numbers.builder().number(100).date(new Date()).build();

    Numbers n2 = Numbers.builder().number(100).date(new Date()).build();

    NumberManager manager = new NumberDao();

    manager.save(n);
    manager.save(n2);


  }

}
