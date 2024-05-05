package com.kihong.learn.java.phoneshop.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kihong.learn.java.phoneshop.dto.BrandDTO;
import com.kihong.learn.java.phoneshop.dto.PageDTO;
import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.mapper.BrandMapper;
import com.kihong.learn.java.phoneshop.service.BrandService;

@RestController
@RequestMapping("brands")
public class BrandController {
	@Autowired
	private BrandService brandService;
	
	@RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<?> create (@RequestBody BrandDTO brandDTO){
		//v1
	   //Brand brand = Mapper.toBrand(brandDTO);
		//end v1
		//v2
		  Brand brand =BrandMapper.INSTANCE.toBrand(brandDTO);
		//end v2
	   brand = brandService.Create(brand);
	   //return ResponseEntity.ok(brand); //return in postman id and name
	   return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));//return in postman only name
   }
	@GetMapping("{id}")
	public ResponseEntity<?> getOneBrand(@PathVariable("id") Integer brandId){
		Brand brand = brandService.getById(brandId);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(brand));
	}
    @PutMapping("{id}")
	public ResponseEntity<?> update (@PathVariable("id") Integer brandId,@RequestBody BrandDTO brandDTO){
		Brand brand =BrandMapper.INSTANCE.toBrand(brandDTO);
		Brand updatedBrand = brandService.Update(brandId, brand);
		return ResponseEntity.ok(BrandMapper.INSTANCE.toBrandDTO(updatedBrand));
	}
    //getall brand v1
//    @GetMapping
//	public ResponseEntity<?> getBrands(){
//    	brandService.getBrand();
//		return ResponseEntity.ok(brandService.getBrand());
//	}
    //end v1
    //get allbrand v2
//    @GetMapping
//    public ResponseEntity<?> getBrands(){
//    	List<BrandDTO> list = brandService.getBrand()
//    	 		.stream()
//    	 		.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//    	 		.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
    
//   @GetMapping("filter")
//    public ResponseEntity<?> getBrands(@RequestParam("name")String name){
//    	List<BrandDTO> list = brandService.getBrand(name)
//    	 		.stream()
//    	 		.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//    	 		.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
   
//   @GetMapping()
//   public ResponseEntity<?> getBrands( String name){
//   	List<BrandDTO> list = brandService.getBrand(name)
//   	 		.stream()
//   	 		.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
//   	 		.collect(Collectors.toList());
//		return ResponseEntity.ok(list);
//	}
   
  @GetMapping
   public ResponseEntity<?> getBrands(@RequestParam Map<String, String> params){
	   Page<Brand> brands = brandService.getBrand(params);
	   PageDTO page = new PageDTO(brands);
	   /*
		List<BrandDTO> list = brandService.getBrand(params)
	   	 		.stream()
	   	 		.map(brand->BrandMapper.INSTANCE.toBrandDTO(brand))
	   	 		.collect(Collectors.toList());
	   	 		*/
			return ResponseEntity.ok(page);
	}
    
}
