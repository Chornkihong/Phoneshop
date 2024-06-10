package com.kihong.learn.java.phoneshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kihong.learn.java.phoneshop.dto.ProductDTO;
import com.kihong.learn.java.phoneshop.entity.Product;
import com.kihong.learn.java.phoneshop.service.ColorService;
import com.kihong.learn.java.phoneshop.service.ModelService;

@Mapper(componentModel = "spring",uses = {ModelService.class,ColorService.class})
public interface ProductMapper {
	@Mapping(target = "model",source = "modelId")
	@Mapping(target = "color",source = "colorId")
   Product toProduct(ProductDTO productDTO);
}
