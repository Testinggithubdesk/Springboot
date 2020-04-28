package com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineshopping.model.Customer;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.Purchase;
import com.onlineshopping.service.OnlineshoppingService;

@RestController
@RequestMapping("/onlineshopping")
public class TestRestController {

	@Autowired
	OnlineshoppingService onlineShopSer;

	@GetMapping
	public String getMessage() {
	return "Online Electronics shopping portalt";
	}
	
	
	@PostMapping
	public  ResponseEntity<Customer> CreateOrUpdatee(Customer customer) {
		
		Customer createcust=onlineShopSer.CreateOrUpdateCustomer(customer);
		
		return new ResponseEntity<Customer>(createcust, HttpStatus.OK);
	}
	
	@PostMapping("/addproduct/{cid}")
	public ResponseEntity<Product> addproduct(Product product,@PathVariable("cid")long cid){
		
		Product addprod=onlineShopSer.addproduct(product,cid);
		
		return new ResponseEntity<Product>(addprod,HttpStatus.OK);
		
	}
	
	@PostMapping("/orderproduct")
	public ResponseEntity<Purchase> orderproduct(Purchase purchase) throws Exception {
		
		Purchase order=onlineShopSer.orderproduct(purchase);
		
		return new ResponseEntity<Purchase>(order,HttpStatus.OK);
	}
	
	
	
	

}
