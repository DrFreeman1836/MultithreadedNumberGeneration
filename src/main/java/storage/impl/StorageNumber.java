package storage.impl;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import storage.NumberStorageManager;

public class StorageNumber implements NumberStorageManager {

  private final Deque<Integer> queueNumbers = new ArrayDeque<>();

  @Override
  public synchronized void addNumber(Integer value) {
    queueNumbers.addFirst(value);
  }

  @Override
  public Integer getNumber() {
    return queueNumbers.peekLast();
  }

  @Override
  public void removeNumber() {
    queueNumbers.removeLast();
  }

  @Override
  public synchronized List<Integer> getListNumbers() {
    return queueNumbers.stream().toList();
  }
}
