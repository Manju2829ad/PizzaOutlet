package basepackage.config;

import basepackage.dao.ToppingDaoImp;
import basepackage.service.ToppingService;
import basepackage.service.ToppingServiceImp;

public class AppConfig {
    public static ToppingService getToppingService() {
        return new ToppingServiceImp(new ToppingDaoImp());
        
        
    }
}