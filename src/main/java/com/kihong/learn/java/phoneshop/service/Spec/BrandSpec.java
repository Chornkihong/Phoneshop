package com.kihong.learn.java.phoneshop.service.Spec;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.kihong.learn.java.phoneshop.entity.Brand;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;

@Data
public class BrandSpec implements Specification<Brand> {
    private final BrandFilter brandFilter;
	@Override
	public Predicate toPredicate(Root<Brand> brand, CriteriaQuery<?> query, CriteriaBuilder cb) {
		List<Predicate> predicates = new ArrayList<>();
		
       if(brandFilter.getName()!=null) {
//    	   Predicate name = brand.get("name").in(brandFilter.getName()); v1
    	    Predicate name = cb.like(cb.upper(brand.get("name")),"%"+ brandFilter.getName().toUpperCase()+"%");
    	   predicates.add(name);
       }
       
       if(brandFilter.getId()!=null) {
    	   Predicate id = brand.get("id").in(brandFilter.getId()); //v1
    	   //cb.like(null, null)
    	   predicates.add(id);
       }
//      Predicate[] pre = predicates.toArray(new Predicate[0]);
//		return cb.and(pre); or 
         return cb.and(predicates.toArray(Predicate[]::new)); //for java 8 up
	}

}
