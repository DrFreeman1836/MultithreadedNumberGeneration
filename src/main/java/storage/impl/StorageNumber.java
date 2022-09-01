package storage.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import storage.NumberStorageManager;

public class StorageNumber implements NumberStorageManager {

  private final Deque<Integer> queueNumbers = new ArrayDeque<>();

  @Override
  public synchronized void addNumber(Integer value) {
    queueNumbers.add(value);
  }

  @Override
  public Integer getNumber() {
    return queueNumbers.remove();
  }

  @Override
  public List<Integer> getListNumbers() {
    return queueNumbers.stream().toList();
  }
}
