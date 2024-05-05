package com.kihong.learn.java.phoneshop.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.exception.ResourceNotFoundException;
import com.kihong.learn.java.phoneshop.repository.BrandRepository;
import com.kihong.learn.java.phoneshop.service.BrandService;
import com.kihong.learn.java.phoneshop.service.Spec.BrandFilter;
import com.kihong.learn.java.phoneshop.service.Spec.BrandSpec;
import com.kihong.learn.java.phoneshop.service.util.PageUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {
	@Autowired
	private final BrandRepository brandRepository;

	@Override
	public Brand Create(Brand brand) {
		return brandRepository.save(brand);
	}

	@Override
	public Brand getById(Integer id) {
		// approach 1
		// Optional<Brand> brandOptional = brandRepository.findById(id);
		// if(brandOptional.isPresent()) {
		// return brandOptional.get();
		// }
		// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id="+id+"
		// not found"); //or
		// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Brand with id=%d not
		// found".formatted(id)); //or
		// throw new HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand
		// with id=%d not found", id));
		// end approach 1

		// approach 2
		return brandRepository.findById(id)
				// .orElseThrow(()-> new
				// HttpClientErrorException(HttpStatus.NOT_FOUND,String.format("Brand with id=%d
				// not found", id)));
				.orElseThrow(() -> new ResourceNotFoundException("Brand", id));
	}

	@Override
	public Brand Update(Integer id, Brand brandUpdate) {
		Brand brand = getById(id);
		brand.setName(brandUpdate.getName()); // @TODO Improve update
		return brandRepository.save(brand);
	}

//	@Override
//	public List<Brand> getBrand() {
//		return brandRepository.findAll();
//	}
	// V1
	/*
	 * @Override public List<Brand> getBrand(String name) { return
	 * brandRepository.findByNameContaining(name); }
	 * 
	 * @Override public List<Brand> getBrand(Map<String, String> params) {
	 * BrandFilter brandFilter = new BrandFilter(); if (params.containsKey("name"))
	 * { String name = params.get("name"); brandFilter.setName(name); } if
	 * (params.containsKey("id")) { String id = params.get("id");
	 * brandFilter.setId(Integer.parseInt(id)); }
	 * 
	 * BrandSpec brandSpec = new BrandSpec(brandFilter); return
	 * brandRepository.findAll(brandSpec); }
	 */
	// end V1

	@Override
	public List<Brand> getBrand(String name) {
		return brandRepository.findByNameContaining(name);
	}

	@Override
	public Page<Brand> getBrand(Map<String, String> params) {
		BrandFilter brandFilter = new BrandFilter();
		if (params.containsKey("name")) {
			String name = params.get("name");
			brandFilter.setName(name);
		}
		if (params.containsKey("id")) {
			String id = params.get("id");
			brandFilter.setId(Integer.parseInt(id));
		}
		//TODO add a function for pageable
		int pageLimit =PageUtil.DEFAULT_PAGE_LIMIT;
		if (params.containsKey(PageUtil.PAGE_LIMIT)) {
			pageLimit = Integer.parseInt(params.get(PageUtil.PAGE_LIMIT));
		}
		int pageNumber = 1;
		if (params.containsKey(PageUtil.PAGE_NUMBER)) {
			pageNumber = Integer.parseInt(params.get(PageUtil.PAGE_NUMBER));
		}
		BrandSpec brandSpec = new BrandSpec(brandFilter);
		Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
		Page<Brand> page = brandRepository.findAll(brandSpec, pageable);
		return page;
	}

}
