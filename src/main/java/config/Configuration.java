package config;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class Configuration {

  private static String url;
  private static String username;
  private static String password;
  private static int countThreads;
  private static int workTime;
  private static boolean clearDB;

  public static void setConfiguration() throws Exception {
    InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("config.xml");
    Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(input));
    XPath xpath = XPathFactory.newInstance().newXPath();
    url = (String) xpath.compile("//config//jdbc//url").evaluate(document, XPathConstants.STRING);
    username = (String) xpath.compile("//config//jdbc//username").evaluate(document, XPathConstants.STRING);
    password = (String) xpath.compile("//config//jdbc//password").evaluate(document, XPathConstants.STRING);
    countThreads = Integer.parseInt( (String) xpath.compile("//config//application//countThreads").evaluate(document, XPathConstants.STRING));
    workTime = Integer.parseInt( (String) xpath.compile("//config//application//workTime").evaluate(document, XPathConstants.STRING));
    clearDB = (boolean) xpath.compile("//config//application//clearDB").evaluate(document, XPathConstants.BOOLEAN);
    input.close();
  }

  public static String getUrl() {
    return url;
  }

  public static String getUsername() {
    return username;
  }

  public static String getPassword() {
    return password;
  }

  public static int getCountThreads() {
    return countThreads;
  }

  public static boolean isClearDB() {
    return clearDB;
  }
}
