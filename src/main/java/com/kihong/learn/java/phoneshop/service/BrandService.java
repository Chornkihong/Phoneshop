package com.kihong.learn.java.phoneshop.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.kihong.learn.java.phoneshop.entity.Brand;

public interface BrandService {
   Brand Create(Brand brand);
   Brand getById(Long id);
   Brand Update(Long id,Brand brandUpdate); 
//   List<Brand> getBrand();
   List<Brand> getBrand(String name);
   //List<Brand> getBrand(Map<String, String> params);
   Page<Brand> getBrand(Map<String, String> params);
}
