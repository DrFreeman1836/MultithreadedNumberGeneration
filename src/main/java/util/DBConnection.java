package util;

import config.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static volatile Connection connection;

  private DBConnection() {
    try {
      connection= DriverManager.getConnection(Configuration.getUrl(), Configuration.getUsername(), Configuration.getPassword());
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  public static Connection getConnection() {
    if (connection == null) {
      synchronized (DBConnection.class) {
        if (connection == null) {
          new DBConnection();
        }
      }
    }
    return connection;
  }

  public static void closeConnection(){
    try{
      connection.close();
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}