package basepackage.service;


import java.util.List;

import basepackage.dao.ToppingDao;
import basepackage.model.Topping;


import java.util.List;

import basepackage.dao.ToppingDao;
import basepackage.model.Topping;

public class ToppingServiceImp implements ToppingService {

    private ToppingDao toppingDao;

    public ToppingServiceImp(ToppingDao toppingDao) {
        this.toppingDao = toppingDao;
    }

    @Override
    public List<Topping> getAllToppings() {
        return toppingDao.getAllToppings();
    }

    @Override
    public Topping getToppingById(Long id) {
        return toppingDao.getToppingById(id);
    }

    @Override
    public void saveTopping(Topping topping) {
        toppingDao.saveTopping(topping);
    }

    @Override
    public void deleteTopping(Long id) {
        toppingDao.deleteTopping(id);
    }
}