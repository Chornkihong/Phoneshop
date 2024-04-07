package com.kihong.learn.java.phoneshop.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.exception.ApiException;
import com.kihong.learn.java.phoneshop.exception.ResourceNotFoundException;
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
	@Override
	public Brand getById(Integer id) {
		// approach 1
	     //Optional<Brand> brandOptional = brandRepository.findById(id);
	     //if(brandOptional.isPresent()) {
	    	 //return brandOptional.get();
	     //}
		//throw new  HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id="+id+" not found"); //or
		//throw new  HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id=%d not found".formatted(id)); //or
	     //throw new  HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand with id=%d not found", id));
	    //end approach 1
		
		//approach 2
		return brandRepository.findById(id)
				//.orElseThrow(()-> new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand with id=%d not found", id)));
	    .orElseThrow(()->new ResourceNotFoundException("Brand",id) );
	}
	@Override
	public Brand Update(Integer id, Brand brandUpdate) {
		 Brand brand = getById(id);
		  brand.setName(brandUpdate.getName()); //@TODO Improve update
		return brandRepository.save(brand);
	}
	
	

}
