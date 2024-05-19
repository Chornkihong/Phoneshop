package com.kihong.learn.java.phoneshop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kihong.learn.java.phoneshop.entity.Model;
import com.kihong.learn.java.phoneshop.repository.ModelRepository;
import com.kihong.learn.java.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service

public class ModelServiceImpl implements ModelService {
	private final ModelRepository modelRepository;

	@Override
	public Model save(Model model) {
		
		return modelRepository.save(model);
	}

	@Override
	public List<Model> getByBrand(Integer brandId) {
		return modelRepository.findByBrandId(brandId);
	}

}
