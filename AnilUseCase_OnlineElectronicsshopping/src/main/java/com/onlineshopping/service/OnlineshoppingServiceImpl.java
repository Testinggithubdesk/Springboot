 package com.onlineshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineshopping.model.Customer;
import com.onlineshopping.model.Product;
import com.onlineshopping.model.Purchase;
import com.onlineshopping.repositroy.OnlineshoppingPurchase;
import com.onlineshopping.repositroy.OnlineshoppingRepository;
import com.onlineshopping.repositroy.ProductRepository;

@Service
@Transactional
public class OnlineshoppingServiceImpl implements OnlineshoppingService {

	@Autowired
	OnlineshoppingRepository OnlineshopRepository;

	@Autowired
	OnlineshoppingPurchase OnlineshoppingPurchase;
	
	
	
	@Autowired
	ProductRepository prepository;

	@Override
	public Customer CreateOrUpdateCustomer(Customer customer) {

		
		return OnlineshopRepository.save(customer);
	}

	@Override
	public Product Addtocart(Product Productrequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> getitems(long productid, String quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addproduct(Product product,long cid) {
		
		Optional<Customer> checkcust=OnlineshopRepository.findById(cid);
		
		
		if(checkcust.isPresent()) {
			
			//Customer getcust=checkcust.get();
			//List<Product> prodList=getcust.getproductid();
			//prodList.stream().forEach(lst->lst.get);
			
			product=prepository.save(product);
			
		}else {
			
			System.out.println("CID/Customer not Available ! please Register");
		}
		
		
		
		
		return product;
	}

	@Override
	public Purchase orderproduct(Purchase purchase) throws Exception {
		Optional<Customer> checkcust=OnlineshopRepository.findById(purchase.getCid());
		
		if(checkcust.isPresent()) {
			Optional<Product> checkprod=prepository.findById(purchase.getPid());
			if(checkprod.isPresent()) {
				Product product=checkprod.get();
				purchase.setPname(product.getProductName());
				purchase.setPrice(product.getPrice());
				return OnlineshoppingPurchase.save(purchase);
			}else {
				System.out.println("Product Not available");
					throw new ClassNotFoundException("Product Not available");
			}
			}else {
			System.out.println("Cid Not found");
			throw new ClassNotFoundException("Product Not available");
		}
		
	}
	
	/*
	 * @Override public Customer CreateOrUpdateCustomer(Customer customer) throws
	 * RecordsNotFoundException { Optional<Customer>
	 * custById=customerRepository.findById(customer.getCustid());
	 * System.out.println("Customer availability check:  "+(custById.isPresent()));
	 * if (custById.isPresent()) { Customer newcustomer=custById.get();
	 * newcustomer.setFirstname(customer.getFirstname());
	 * newcustomer.setLastname(customer.getLastname());
	 * newcustomer.setEmail(customer.getEmail());
	 * newcustomer.setMobile(customer.getMobile());
	 * newcustomer=customerRepository.save(newcustomer); return newcustomer; }else {
	 * AccountNumberEntity ac=new AccountNumberEntity();
	 * //ac.setCust(customer.getCustid()); ac.setAcno(generateaccountNumber());
	 * ac.setOpeningbalance(5000.00); customer=customerRepository.save(customer);
	 * return customer; }
	 */
		
	
}
