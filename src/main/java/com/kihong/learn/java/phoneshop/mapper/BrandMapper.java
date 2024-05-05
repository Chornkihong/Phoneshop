package com.kihong.learn.java.phoneshop.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.kihong.learn.java.phoneshop.dto.BrandDTO;
import com.kihong.learn.java.phoneshop.entity.Brand;

@Mapper
public interface BrandMapper {
    //mapstruct use for convert dto <-> entity
	BrandMapper INSTANCE=Mappers.getMapper(BrandMapper.class);
	Brand toBrand(BrandDTO dtp);
	BrandDTO toBrandDTO(Brand brand);
	
}
