package basepackage.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import basepackage.model.Topping;
import basepackage.util.HibernateUtil;

public class ToppingDaoImp implements ToppingDao {

    @Override
    public List<Topping> getAllToppings() {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Query<Topping> query = session.createQuery("FROM Topping", Topping.class);
        List<Topping> toppings = query.getResultList();
        transaction.commit();
        session.close();
        return toppings;
    }

    @Override
    public Topping getToppingById(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Topping topping = session.get(Topping.class, id);
        transaction.commit();
        session.close();
        return topping;
    }

    @Override
    public void saveTopping(Topping topping) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(topping);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteTopping(Long id) {
        Session session = HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
        Topping topping = session.get(Topping.class, id);
        session.delete(topping);
        transaction.commit();
        session.close();
    }
}