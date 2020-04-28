package com.onlineshopping.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineshopping.model.Purchase;

@Repository
public interface OnlineshoppingPurchase extends JpaRepository<Purchase, Long> {

}
