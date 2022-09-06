package dao.impl;

import dao.NumberDaoManager;
import util.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;


public class NumberDao implements NumberDaoManager {

  @Override
  public void save(Integer value) {
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      statement.executeUpdate("INSERT INTO \"Number\" (\"numberr\") VALUES ('" + value + "')");
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public int countNumbers() {
    return 0;
  }

  @Override
  public int getMinNumber() {
    return 0;
  }

  @Override
  public int getMaxNumber() {
    return 0;
  }

  @Override
  public int getCountUniqueNumber() {
    return 0;
  }

  @Override
  public void deleteAllNumber() {

  }

}
