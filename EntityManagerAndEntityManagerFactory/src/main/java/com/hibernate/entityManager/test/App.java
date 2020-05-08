package com.hibernate.entityManager.test;

import com.hibernate.entityManager.dao.ProductDAO;
import com.hibernate.entityManager.model.Product;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ProductDAO productDAO = new ProductDAO();
		// Show list of product
		System.out.println("========================");
		System.out.println("***List Products***");
		productDAO.showAll();
		System.out.println("========================");

		// Find product by id 1
//		System.out.println("========================");
//		System.out.println("***Find product by id 1***");
//		System.out.println(productDAO.findById(1));
//		System.out.println("========================");

		// Insert a product
//		System.out.println("========================");
//		System.out.println("***List Products after insert a product***");
//		Product p = new Product("Chocolate", 10, 10);
//		productDAO.save(p);
//		productDAO.showAll();
//		System.out.println("========================");

		// Update a product
//		System.out.println("========================");
//		System.out.println("***List Products after update a product***");
//		p.setName("Chocolate v2");
//		p.setProduct_id(23);
//		productDAO.update(p);
//		productDAO.showAll();
//		System.out.println("========================");

		// Delete a product
//		System.out.println("========================");
//		System.out.println("***List Products after delete a product***");
//		productDAO.delete(p.getProduct_id());
//		productDAO.showAll();
//		System.out.println("========================");

		// Search a product by name
//		System.out.println("========================");
//		System.out.println("***List Products by name***");
//		productDAO.searchByName("I");
//		System.out.println("========================");
		// close
		productDAO.close();
	}
}
