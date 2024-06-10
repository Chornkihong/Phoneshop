package com.kihong.learn.java.phoneshop.service;

import com.kihong.learn.java.phoneshop.entity.Color;

public interface ColorService {
   Color Create(Color color);
   Color getById(Long id);
  
}
