package com.kihong.learn.java.phoneshop.service;

import com.kihong.learn.java.phoneshop.entity.Product;

public interface ProductService {
	Product create(Product product);	
	Product getById(Long id);
}
