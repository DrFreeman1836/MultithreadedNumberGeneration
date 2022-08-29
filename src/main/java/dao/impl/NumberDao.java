package dao.impl;

import dao.NumberDaoManager;
import model.Number;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.SessionFactoryUtil;

public class NumberDao implements NumberDaoManager {

  public void save(Number number) {
    Session session = SessionFactoryUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.save(number);
    transaction.commit();
    session.close();
  }

}
