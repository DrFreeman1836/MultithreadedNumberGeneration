package dao.impl;

import dao.NumberManager;
import model.Numbers;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;

public class NumberDao implements NumberManager {

  public void save(Numbers number) {
    Session session = SessionFactoryUtil.getSessionFactory().openSession();
    Transaction tx1 = session.beginTransaction();
    session.save(number);
    tx1.commit();
    session.close();
  }

}
