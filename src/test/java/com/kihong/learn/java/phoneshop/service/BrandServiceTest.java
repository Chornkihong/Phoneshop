package com.kihong.learn.java.phoneshop.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.kihong.learn.java.phoneshop.entity.Brand;
import com.kihong.learn.java.phoneshop.exception.ResourceNotFoundException;
import com.kihong.learn.java.phoneshop.repository.BrandRepository;
import com.kihong.learn.java.phoneshop.service.impl.BrandServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BrandServiceTest {

	@Mock
	private BrandRepository brandRepository;

	private BrandService brandService;

	@BeforeEach
	public void setUp() { // this function for brandservice is null(runtime error)
		brandService = new BrandServiceImpl(brandRepository);
	}
	/*
	 * @Test public void testCreate() {
	 * 
	 * //given Brand brand = new Brand(); brand.setName("Apple"); brand.setId(1);
	 * //when
	 * 
	 * when(brandRepository.save(any(Brand.class))).thenReturn(brand); Brand
	 * brandReturn = brandService.Create(new Brand());
	 * 
	 * //then assertEquals(1,brandReturn.getId());
	 * assertEquals("Apple",brandReturn.getName()); }
	 */

	// best way
	@Test
	public void testCreate() {

		// given
		Brand brand = new Brand();
		brand.setName("Apple");		
		// when
           brandService.Create(brand);
		// then
		verify(brandRepository,times(1)).save(brand);
	}
	public void testGetByIdSuccess() {
		
		//given
		Brand brand = new Brand(); 
		brand.setName("Apple");
		brand.setId(1L);
		
		//when
		when(brandRepository.findById(1L)).thenReturn(Optional.of(brand));
		Brand brandReturn = brandService.getById(1L);
		//then
		
		assertEquals(1,brandReturn.getId());
		assertEquals("Apple",brandReturn.getName());
		
	}
	
	public void testGetByIdFail() {
		//given
		Brand brand = new Brand(); 
		brand.setName("Apple");
		brand.setId(1L);
		//when
		when(brandRepository.findById(2L)).thenReturn(Optional.empty());
         //Brand brandReturn = brandService.getById(2);
		assertThatThrownBy(() -> brandService.getById(2L))
		      .isInstanceOf(ResourceNotFoundException.class)
		      .hasMessage("Brand with id =2 not found");
		     
		//then
         
	}
}
