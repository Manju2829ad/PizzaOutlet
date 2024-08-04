package basepackage.service;


import java.util.List;

import basepackage.dao.ToppingDao;
import basepackage.model.Topping;


import java.util.List;

import basepackage.model.Topping;

public interface ToppingService {
    List<Topping> getAllToppings();
    Topping getToppingById(Long id);
    void saveTopping(Topping topping);
    void deleteTopping(Long id);
}