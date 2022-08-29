import dao.NumberManager;
import dao.impl.NumberDao;
import java.util.Date;
import model.Number;

public class Application {

  public static void main(String[] args) {

    Number n = new Number();
    n.setDate(new Date());
    n.setNumber(100);

    Number n2 = new Number();
    n2.setDate(new Date());
    n2.setNumber(100);

    NumberManager manager = new NumberDao();

    manager.save(n);
    manager.save(n2);


  }

}
