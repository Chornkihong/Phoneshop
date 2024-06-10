package com.kihong.learn.java.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kihong.learn.java.phoneshop.dto.ProductDTO;
import com.kihong.learn.java.phoneshop.entity.Product;
import com.kihong.learn.java.phoneshop.mapper.ProductMapper;
import com.kihong.learn.java.phoneshop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final ProductMapper productMapper;
	
	@PostMapping
   public ResponseEntity<?> create (@RequestBody ProductDTO productDTO){	
		Product product = productMapper.toProduct(productDTO);
		product= productService.create(product);
	   return ResponseEntity.ok(product);//return in postman only name
   }
    
}
