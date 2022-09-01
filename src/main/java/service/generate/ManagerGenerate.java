package service.generate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import storage.impl.StorageNumber;

public class ManagerGenerate {

  private  final int countThread;

  private ExecutorService exService;

  public ManagerGenerate(int countThread) {
    this.countThread = countThread;
    exService = Executors.newFixedThreadPool(countThread);
  }

  public void startGenerate(StorageNumber storage){

    for(int i = 0; i < countThread; i++){
      exService.submit(new GenerateNumbers(storage));
    }

  }

  public void stopGenerate(){
    exService.shutdownNow();
  }

}
