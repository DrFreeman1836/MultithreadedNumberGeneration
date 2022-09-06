package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

    private static String url;
    private static String username;
    private static String password;
    private static volatile Connection connection;

  private DBConnection() {
    try {
      connection= DriverManager.getConnection(url, username, password);
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
/**
 String url="jdbc:firebirdsql://localhost:3050/D:/test.FDB?lc_ctype=utf8";
 String username="sysdba";
 String password="1q2w3e4r";
 */