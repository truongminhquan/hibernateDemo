package com.hibernate.entityManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;

	@Column(name = "name")
	private String name;

	@Column(name = "quantity_in_stock")
	private int quantity_in_stock;

	@Column(name = "unit_price")
	private int unit_price;

	public Product() {
		System.out.println("Constructor is being called");
	}

	public Product(String name, int quantity_in_stock, int unit_price) {
		this.name = name;
		this.quantity_in_stock = quantity_in_stock;
		this.unit_price = unit_price;
	}

	public Product(int product_id, String name, int quantity_in_stock, int unit_price) {
		this.product_id = product_id;
		this.name = name;
		this.quantity_in_stock = quantity_in_stock;
		this.unit_price = unit_price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	public int getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(int unit_price) {
		this.unit_price = unit_price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", name=" + name + ", quantity_in_stock=" + quantity_in_stock
				+ ", unit_price=" + unit_price + "]";
	}

}
