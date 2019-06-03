package dao;

import models.Card;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class CardDao {

    public Card findById (int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Card.class, id);
    }

    public void save(Card card){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(card);
        tx1.commit();
        session.close();
    }

    public void delete (Card card){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(card);
        tx1.commit();
        session.close();
    }

    public void update (Card card){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(card);
        tx1.commit();
        session.close();
    }
}
