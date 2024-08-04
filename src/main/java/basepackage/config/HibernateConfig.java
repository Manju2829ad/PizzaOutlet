package basepackage.config;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;

import basepackage.model.DeluxePizza;
import basepackage.model.NonVeg;
import basepackage.model.Pizza;
import basepackage.model.Topping;
import basepackage.model.VegPizza;

public class HibernateConfig {
    private static final HikariConfig hikariConfig = new HikariConfig();
    private static final HikariDataSource dataSource;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Register MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found", e);
        }

        // HikariCP configuration
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/pizzamania2");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("1234");
        
//        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
//        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        dataSource = new HikariDataSource(hikariConfig);
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();

        configuration.addAnnotatedClass(Pizza.class);
        configuration.addAnnotatedClass(Topping.class);
        configuration.addAnnotatedClass(DeluxePizza.class);
        configuration.addAnnotatedClass(NonVeg.class);
        configuration.addAnnotatedClass(VegPizza.class);

        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        builder.applySetting("hibernate.connection.datasource", dataSource);
        builder.applySetting("hibernate.current_session_context_class", "org.hibernate.context.internal.ThreadLocalSessionContext");

        ServiceRegistry registry = builder.build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(registry);

        return sessionFactory;
    }
}