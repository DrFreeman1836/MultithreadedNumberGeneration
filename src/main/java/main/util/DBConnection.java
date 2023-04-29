package main.util;

import javax.annotation.PostConstruct;
import main.config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.springframework.stereotype.Component;
import javax.annotation.PreDestroy;


@Component
public class DBConnection {

  private Connection connection;

  @PostConstruct
  private void initConnection() {
    try {
      connection = DriverManager.getConnection
          (Configuration.getUrl(), Configuration.getUsername(), Configuration.getPassword());
      createTable();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public synchronized Connection getConnection() {
    return connection;
  }

  @PreDestroy
  public void closeConnection() {
    try {
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  private void createTable() {
    try (Statement statement = connection.createStatement()) {
      statement.execute("create table if not exists number("
          + "id bigint not null auto_increment,"
          + "value int not null,"
          + "date timestamp not null,"
          + "primary key (id)"
          + ")");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
