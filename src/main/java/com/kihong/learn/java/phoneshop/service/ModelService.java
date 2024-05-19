package com.kihong.learn.java.phoneshop.service;

import java.util.List;

import com.kihong.learn.java.phoneshop.entity.Model;

public interface ModelService {
  
	 Model save(Model model);
	 List<Model> getByBrand(Integer brandId);
}
