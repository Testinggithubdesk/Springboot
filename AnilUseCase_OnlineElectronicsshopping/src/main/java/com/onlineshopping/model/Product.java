package com.onlineshopping.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "productid")
	private long productid;

	@Column(name = "productName")
	private String productName;

	@Column(name = "price")
	private Double price;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "custid")
	private Customer cust;

	public long getProductid() {
		return productid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Customer getCust() {
		return cust;
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public void setProductid(long productid) {
		this.productid = productid;
	}

}
