package com.kihong.learn.java.phoneshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.repository.BrandRepository;
import com.kihong.learn.java.phoneshop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
     @Autowired
	private BrandRepository brandRepository;
	@Override
	public Brand Create(Brand brand) {
		return brandRepository.save(brand);
	}

}
