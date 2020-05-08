package com.hibernate.entityManager.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.hibernate.entityManager.model.Product;

public class ProductDAO {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public void showAll() {
		List<Product> list = entityManager.createQuery("SELECT p FROM Product p ORDER BY p.name", Product.class)
				.getResultList();
		list.forEach(item -> System.out.println(item.toString()));
	}

	public Product findById(int productId) {
		return entityManager.find(Product.class, productId);
	}

	public void save(Product pro) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(pro);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.out.println(ex);
		}
	}

	public void update(Product pro) {
		try {
			Product p = entityManager.find(Product.class, pro.getProduct_id());
			if (p != null) {
				entityManager.getTransaction().begin();
				p.setName(pro.getName());
				p.setQuantity_in_stock(pro.getQuantity_in_stock());
				p.setUnit_price(pro.getUnit_price());
				entityManager.getTransaction().commit();
			}
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.out.println(ex);
		}
	}

	public void delete(int productId) {
		try {
			Product p = entityManager.find(Product.class, productId);
			if (p != null) {
				entityManager.getTransaction().begin();
				entityManager.remove(p);
				entityManager.getTransaction().commit();
			}
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			System.out.println(ex);
		}
	}

	public void searchByName(String name) {
		List<Product> list = entityManager
				.createQuery("SELECT p " + "FROM Product p " + "WHERE p.name like :name", Product.class)
				.setParameter("name", "%" + name + "%").getResultList();

		list.forEach(item -> System.out.println(item.toString()));
	}

	public void close() {
		entityManager.close();
		entityManagerFactory.close();
	}
}
