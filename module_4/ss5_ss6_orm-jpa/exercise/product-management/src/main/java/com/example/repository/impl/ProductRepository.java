package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import config.ConnectionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> productList() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public boolean delete(int id) {
        Product product = findById(id);

        Transaction transaction = null;
        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :idInput").setParameter("idInput", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void create(Product product) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = (List<Product>) session.createQuery("FROM Product where name  like :nameInput").setParameter("nameInput", "%" + name + "%").getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
