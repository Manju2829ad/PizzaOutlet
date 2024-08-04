package basepackage.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import basepackage.config.HibernateConfig;

public class HibernateUtil {
    public static SessionFactory getSessionFactory() {
        return HibernateConfig.getSessionFactory();
    }

    public static Session getSession() {
        return getSessionFactory().getCurrentSession();
    }

    public static void shutdown() {
        HibernateConfig.getSessionFactory().close();
    }
}