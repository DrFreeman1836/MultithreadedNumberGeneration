package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

  private static volatile SessionFactory sessionFactory;

  private SessionFactoryUtil() {
    try {
      Configuration configuration = new Configuration().configure();
      configuration.addAnnotatedClass(Number.class);
      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
          configuration.getProperties());
      sessionFactory = configuration.buildSessionFactory(builder.build());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      synchronized (SessionFactoryUtil.class) {
        if (sessionFactory == null) {
          new SessionFactoryUtil();
        }
      }
    }
    return sessionFactory;
  }

}
