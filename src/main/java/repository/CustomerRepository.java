package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lombok.RequiredArgsConstructor;
import model.Customer;
@RequiredArgsConstructor
public class CustomerRepository {

    private final SessionFactory sessionFactory;  

    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customer);
        transaction.commit();
        session.close();
    }

    public Customer findById(Long id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public List<Customer> findAll() {
        Session session = sessionFactory.openSession();
        List<Customer> customers = session.createQuery("from Customer", Customer.class).list();
        session.close();
        return customers;
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customer);
        transaction.commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(customer);
        transaction.commit();
        session.close();
    }
}

