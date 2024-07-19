package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lombok.RequiredArgsConstructor;
import model.CustomerInfo;
@RequiredArgsConstructor
public class CustomerInfoRepository {

    private final SessionFactory sessionFactory; 

    public void save(CustomerInfo customerInfo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(customerInfo);
        transaction.commit();
        session.close();
    }

    public CustomerInfo findById(Long id) {
        Session session = sessionFactory.openSession();
        CustomerInfo customerInfo = session.get(CustomerInfo.class, id);
        session.close();
        return customerInfo;
    }

    public List<CustomerInfo> findAll() {
        Session session = sessionFactory.openSession();
        List<CustomerInfo> customerInfos = session.createQuery("from CustomerInfo", CustomerInfo.class).list();
        session.close();
        return customerInfos;
    }

    public void update(CustomerInfo customerInfo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(customerInfo);
        transaction.commit();
        session.close();
    }

    public void delete(CustomerInfo customerInfo) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(customerInfo);
        transaction.commit();
        session.close();
    }
}
