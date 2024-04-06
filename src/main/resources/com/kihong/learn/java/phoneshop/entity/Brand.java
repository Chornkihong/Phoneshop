package com.kihong.learn.java.phoneshop.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity

public class Brand {
	private Integer id;
	private String  name;
	
	
}
