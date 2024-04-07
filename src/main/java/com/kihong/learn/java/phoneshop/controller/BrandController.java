package com.kihong.learn.java.phoneshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(Mapper.toBrandDTO(brand));
	}
    @PutMapping("{id}")
	public ResponseEntity<?> update (@PathVariable("id") Integer brandId,@RequestBody BrandDTO brandDTO){
		Brand brand =Mapper.toBrand(brandDTO);
		Brand updatedBrand = brandService.Update(brandId, brand);
		return ResponseEntity.ok(Mapper.toBrandDTO(updatedBrand));
	}
}
