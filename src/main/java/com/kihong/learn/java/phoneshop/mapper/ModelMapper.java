package com.kihong.learn.java.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.kihong.learn.java.phoneshop.dto.ModelDTO;
import com.kihong.learn.java.phoneshop.entity.Model;
import com.kihong.learn.java.phoneshop.service.BrandService;

@Mapper(componentModel = "spring",uses = {BrandService.class})
public interface ModelMapper {
   
	
	ModelMapper INSTANCE =Mappers.getMapper(ModelMapper.class);
	
	 @Mapping(target = "brand",source = "brandId")
	   Model toModel (ModelDTO modelDTO); 
	   @Mapping(target = "brandId",source ="brand.id")
	   ModelDTO toModelDTO(Model model);
	 
//	 default Brand toBrand(Integer brid) {
//		 Brand brand = new Brand();
//		 brand.setId(brid);
//		 return brand;
//	 }
		
}
