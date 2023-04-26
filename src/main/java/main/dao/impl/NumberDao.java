package main.dao.impl;

import java.sql.Timestamp;
import main.dao.NumberDaoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import main.util.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class NumberDao implements NumberDaoManager {

  private final DBConnection connection;

  @Autowired
  public NumberDao(DBConnection connection) {
    this.connection = connection;
  }

  private static final String INSERT = "insert into number (value, date) values (?, ?)";
  @Override
  public void save(Integer value) {
    try (PreparedStatement preparedStatement = connection.getConnection()
        .prepareStatement(INSERT)) {
      preparedStatement.setInt(1, value);
      preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  private static final String SELECT_COUNT = "select count(*) from number";
  @Override
  public int getCountNumbers() {
    try (Statement statement = connection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(SELECT_COUNT)) {
      rs.next();
      return rs.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  private static final String SELECT_MIN = "select min(value) from number";
  @Override
  public int getMinNumber() {
    try (Statement statement = connection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(SELECT_MIN)) {
      rs.next();
      return rs.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  private static final String SELECT_MAX = "select max(value) from number";
  @Override
  public int getMaxNumber() {
    try (Statement statement = connection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(SELECT_MIN)) {
      rs.next();
      return rs.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  private static final String SELECT_UNIQUE = "select count(distinct value) from number";
  @Override
  public int getCountUniqueNumber() {
    try (Statement statement = connection.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(SELECT_MIN)) {
      rs.next();
      return rs.getInt(1);
    } catch (SQLException e) {
      e.printStackTrace();
      return 0;
    }
  }

  private static final String DELETE = "delete from number";
  @Override
  public void deleteAllNumber() {
    try (Statement statement = connection.getConnection().createStatement()) {
      statement.execute(DELETE);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
