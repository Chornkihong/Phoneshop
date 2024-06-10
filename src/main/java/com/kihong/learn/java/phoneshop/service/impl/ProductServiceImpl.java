package com.kihong.learn.java.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.kihong.learn.java.phoneshop.entity.Product;
import com.kihong.learn.java.phoneshop.exception.ResourceNotFoundException;
import com.kihong.learn.java.phoneshop.repository.ProductRepository;
import com.kihong.learn.java.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
   
	private final ProductRepository productRepository;
	  
	@Override
	public Product create(Product product) {
		String name= "%s %s"
				.formatted(product.getModel().getName(),product.getColor().getName());
		product.setName(name);
		return productRepository.save(product);
	}

	@Override
	public Product getById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Product",id));			
	}

}
