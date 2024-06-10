package com.kihong.learn.java.phoneshop.service.impl;

import org.springframework.stereotype.Service;

import com.kihong.learn.java.phoneshop.entity.Color;
import com.kihong.learn.java.phoneshop.exception.ResourceNotFoundException;
import com.kihong.learn.java.phoneshop.repository.ColorRepository;
import com.kihong.learn.java.phoneshop.service.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
 private final ColorRepository colorRepository;
	
	@Override
	public Color Create(Color color) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Color getById(Long id) {
		return colorRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Color", id));
	}

}
