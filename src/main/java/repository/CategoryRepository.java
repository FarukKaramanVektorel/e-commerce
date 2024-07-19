package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import lombok.RequiredArgsConstructor;
import model.Category;
@RequiredArgsConstructor
public class CategoryRepository {

    private final SessionFactory sessionFactory;

   

    public void save(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(category);
        transaction.commit();
        session.close();
    }

    public Category findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createQuery("from Category", Category.class).list();
        session.close();
        return categories;
    }

    public void update(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(category);
        transaction.commit();
        session.close();
    }

    public void delete(Category category) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(category);
        transaction.commit();
        session.close();
    }
}

