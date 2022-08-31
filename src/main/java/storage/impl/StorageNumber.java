package storage.impl;

import java.util.List;
import java.util.Stack;
import storage.NumberStorageManager;

public class StorageNumber implements NumberStorageManager {

  private final Stack<Integer> numberStack = new Stack<>();

  @Override
  public void addNumber(Integer value) {
    numberStack.push(value);
  }

  @Override
  public Integer getFirstNumber() {
    return numberStack.pop();
  }

  @Override
  public List<Integer> getListNumbers() {
    return numberStack.stream().toList();
  }
}
