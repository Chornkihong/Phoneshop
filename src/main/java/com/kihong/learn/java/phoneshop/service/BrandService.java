package com.kihong.learn.java.phoneshop.service;

import com.kihong.learn.java.phoneshop.entity.Brand;

public interface BrandService {
   Brand Create(Brand brand);
   Brand getById(Integer id);
   Brand Update(Integer id,Brand brandUpdate);
}
