package com.kihong.learn.java.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kihong.learn.java.phoneshop.dto.BrandDTO;
import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.service.BrandService;
import com.kihong.learn.java.phoneshop.service.util.Mapper;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	@RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<?> create (@RequestBody BrandDTO brandDTO){
	   Brand brand = Mapper.toBrand(brandDTO);
	   brand = brandService.Create(brand);
	   //return ResponseEntity.ok(brand); //return in postman id and name
	   return ResponseEntity.ok(Mapper.toBrandDTO(brand));//return in postman only name
   }
}
