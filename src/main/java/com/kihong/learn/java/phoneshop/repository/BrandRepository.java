package com.kihong.learn.java.phoneshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.kihong.learn.java.phoneshop.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>,JpaSpecificationExecutor<Brand> {
  List<Brand> findByNameContaining(String name);
}
