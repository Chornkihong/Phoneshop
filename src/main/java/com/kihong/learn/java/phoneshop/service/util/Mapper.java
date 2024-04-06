package com.kihong.learn.java.phoneshop.service.util;

import com.kihong.learn.java.phoneshop.dto.BrandDTO;
import com.kihong.learn.java.phoneshop.entity.Brand;

public class Mapper {
 //convert entity to dto or dto to entity
	public static Brand toBrand(BrandDTO dto) {
		
		Brand brand = new Brand();
		//brand.setId(dto.getId());
		brand.setName(dto.getName());
		return brand;
		
	}
	public static BrandDTO toBrandDTO(Brand brand) {
		BrandDTO dto= new BrandDTO();
		dto.setName(brand.getName());
		return dto;
	}
}
