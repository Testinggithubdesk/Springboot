package com.onlineshopping.service;

import java.util.List;

import com.onlineshopping.model.Customer;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.Purchase;

public interface OnlineshoppingService {
	
	public Customer CreateOrUpdateCustomer(Customer customer);

	public Product Addtocart(Product Productrequest);

	public List<Purchase> getitems(long productid, String quantity);

	public Product addproduct(Product product,long cid);

	public Purchase orderproduct(Purchase purchase) throws Exception;

	
}
