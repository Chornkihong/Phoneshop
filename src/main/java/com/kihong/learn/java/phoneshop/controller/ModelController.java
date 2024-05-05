package com.kihong.learn.java.phoneshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kihong.learn.java.phoneshop.dto.ModelDTO;
import com.kihong.learn.java.phoneshop.entity.Model;
import com.kihong.learn.java.phoneshop.mapper.ModelMapper;
import com.kihong.learn.java.phoneshop.service.ModelService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/models")
public class ModelController {
	private final ModelService modelService;
	private final ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody ModelDTO modelDTO) {
		Model model = modelMapper.toModel(modelDTO);
		model = modelService.save(model);
		return ResponseEntity.ok(modelMapper.toModelDTO(model));
	}
}
