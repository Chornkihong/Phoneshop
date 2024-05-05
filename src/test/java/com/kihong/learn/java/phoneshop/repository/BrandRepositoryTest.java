package com.kihong.learn.java.phoneshop.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.kihong.learn.java.phoneshop.entity.Brand;

@DataJpaTest
public class BrandRepositoryTest {
	@Autowired
	private BrandRepository brandRepository;
   
	@Test
	public void testFindByNameContaining() {
		//given
		  Brand brand = new Brand();
		  brand.setName("Apple");
		  brandRepository.save(brand);
		  
		  Brand brand2 = new Brand();
		  brand2.setName("AOppo");
		  brandRepository.save(brand2);
		  
		//when
		    List<Brand> brands = brandRepository.findByNameContaining("A");
		//then
		    assertEquals(2, brands.size());
		    assertEquals("Apple",brands.get(0).getName());
		    assertEquals(1,brands.get(0).getId());
		
	}
}
