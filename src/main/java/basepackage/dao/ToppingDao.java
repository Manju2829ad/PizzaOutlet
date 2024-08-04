package basepackage.dao;

import java.util.List;
import java.util.logging.LogManager;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import basepackage.model.Topping;

import basepackage.util.HibernateUtil;
public interface ToppingDao {

    List<Topping> getAllToppings();

    Topping getToppingById(Long id);

    void saveTopping(Topping topping);

    void deleteTopping(Long id);
}