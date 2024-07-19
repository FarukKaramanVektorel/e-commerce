package util;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Category;
import model.Customer;
import model.CustomerInfo;
import model.CustomerPrice;
import model.Product;

public class HibernateConfig {

    private static SessionFactory sessionFactory;

    static {
        try {
        	Properties prop=new Properties();
    		prop.put("hibernate.connection.driver_class", "org.postgresql.Driver");
    		prop.put("hibernate.connection.url", "jdbc:postgresql://localhost:5432/commerce");
    		prop.put("hibernate.connection.username", "postgres");
    		prop.put("hibernate.connection.password", "1234");
    		prop.put("hibernate.show_sql", "true");		
    		prop.put("hibernate.hbm2ddl.auto", "update");  		
    		
    		Configuration cfg=new Configuration();
    		cfg.addProperties(prop);    
    		cfg.addAnnotatedClass(Category.class);
    		cfg.addAnnotatedClass(Customer.class);
    		cfg.addAnnotatedClass(Product.class);
    		cfg.addAnnotatedClass(Category.class);
    		cfg.addAnnotatedClass(CustomerInfo.class);
    		cfg.addAnnotatedClass(CustomerPrice.class);

            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}


