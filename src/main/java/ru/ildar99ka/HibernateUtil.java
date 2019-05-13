package ru.ildar99ka;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ildar99ka.models.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties properties = new Properties();
        try (
                InputStream is = HibernateUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(Objects.requireNonNull(is));
        } catch (
                IOException e) {
            System.out.println("ресурс db.properties отсутствует");
            e.printStackTrace();
            e.getMessage();
        }
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.connection.url", properties.getProperty("db.url"));
        configuration.setProperty("hibernate.connection.username", properties.getProperty("db.username"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("db.password"));
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("db.driverClassName"));
        configuration.setProperty("hibernate.dialect", properties.getProperty("db.hibernateDialect"));
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Cart.class);
        return configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
