package dao.impl;

import dao.NumberDaoManager;
import util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class NumberDao implements NumberDaoManager {

  @Override
  public void save(Integer value) {
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      String dateNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:MM:ss.SSS"));
      statement.executeUpdate("INSERT INTO \"NUMBERS\" (\"value\", \"date\") VALUES ('" + value + "', '" + dateNow +"')");
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @Override
  public int getCountNumbers() {
    int count = 0;
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      ResultSet set = statement.executeQuery("SELECT COUNT(*) FROM \"NUMBERS\"");
      set.next();
      count = set.getInt(1);
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
    return count;
  }

  @Override
  public int getMinNumber() {
    int min = 0;
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      ResultSet set = statement.executeQuery("SELECT MIN(\"value\") FROM \"NUMBERS\"");
      set.next();
      min = set.getInt(1);
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
    return min;
  }

  @Override
  public int getMaxNumber() {
    int max = 0;
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      ResultSet set = statement.executeQuery("SELECT MAX(\"value\") FROM \"NUMBERS\"");
      set.next();
      max = set.getInt(1);
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
    return max;
  }

  @Override
  public int getCountUniqueNumber() {
    int count = 0;
    try {
      Statement statement = DBConnection.getConnection().createStatement();
      ResultSet set = statement.executeQuery("SELECT COUNT(DISTINCT(\"value\")) FROM \"NUMBERS\"");
      set.next();
      count = set.getInt(1);
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
    return count;
  }

  @Override
  public void deleteAllNumber() {
    try {
      PreparedStatement statement = DBConnection.getConnection().prepareStatement("DELETE FROM \"NUMBERS\"");
      statement.executeUpdate();
      statement.close();
    }catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}
