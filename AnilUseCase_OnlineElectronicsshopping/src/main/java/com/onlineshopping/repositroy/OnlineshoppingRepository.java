package com.onlineshopping.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshopping.model.Customer;

@Repository
public interface OnlineshoppingRepository  extends JpaRepository<Customer, Long> {

}

