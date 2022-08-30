package util;

import model.Number;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {

    private static volatile SessionFactory sessionFactory;

//  private SessionFactoryUtil() {
//    try {
//      Configuration configuration = new Configuration().configure();
//      configuration.addAnnotatedClass(Number.class);
//      StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
//          configuration.getProperties());
//      sessionFactory = configuration.buildSessionFactory(builder.build());
//    } catch (Exception ex) {
//      ex.printStackTrace();
//    }
//  }
//
//  public static SessionFactory getSessionFactory() {
//    if (sessionFactory == null) {
//      synchronized (SessionFactoryUtil.class) {
//        if (sessionFactory == null) {
//          new SessionFactoryUtil();
//        }
//      }
//    }
//    return sessionFactory;
//  }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
//            try {

                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Number.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

//            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
//
//            MetadataSources sources = new MetadataSources(registry);
//
//            Metadata metadata = sources.getMetadataBuilder().build();
//
//            sessionFactory = metadata.getSessionFactoryBuilder().build();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
        }
        return sessionFactory;
    }

}
