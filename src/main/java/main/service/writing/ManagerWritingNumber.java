package main.service.writing;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerWritingNumber {

  private ExecutorService exService;

  private WritingNumber writingNumber;


  private int[] temp = {0, 100_000, 200_000, 300_000, 400_000, 500_000};

  @Autowired
  public ManagerWritingNumber(WritingNumber writingNumber) {
    this.writingNumber = writingNumber;
    exService = Executors.newFixedThreadPool(5);
  }

  public void startWriting() {
    for (int i = 0; i < 5; i++) {
      WritingNumber wn = writingNumber;
      wn.setMax(temp[i+1]);
      wn.setMin(temp[i]);
      exService.submit(wn);
    }
  }

  public void stopWriting(){
    exService.shutdownNow();
  }

}
