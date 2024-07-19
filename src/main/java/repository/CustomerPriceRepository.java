package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lombok.RequiredArgsConstructor;
import model.CustomerPrice;
@RequiredArgsConstructor
public class CustomerPriceRepository {

    private final SessionFactory sessionFactory; 

    public void save(CustomerPrice customerPrice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customerPrice);
        transaction.commit();
        session.close();
    }

    public CustomerPrice findById(Long id) {
        Session session = sessionFactory.openSession();
        CustomerPrice customerPrice = session.get(CustomerPrice.class, id);
        session.close();
        return customerPrice;
    }

    public List<CustomerPrice> findAll() {
        Session session = sessionFactory.openSession();
        List<CustomerPrice> customerPrices = session.createQuery("from CustomerPrice", CustomerPrice.class).list();
        session.close();
        return customerPrices;
    }

    public void update(CustomerPrice customerPrice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customerPrice);
        transaction.commit();
        session.close();
    }

    public void delete(CustomerPrice customerPrice) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(customerPrice);
        transaction.commit();
        session.close();
    }
}

