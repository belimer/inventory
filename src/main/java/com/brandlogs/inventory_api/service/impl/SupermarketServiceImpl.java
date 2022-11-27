package com.brandlogs.inventory_api.service.impl;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.SupermarketDto;
import com.brandlogs.inventory_api.service.SupermarketService;

@Service
@Transactional
public class SupermarketServiceImpl  implements SupermarketService{

	@Override
	public ResponseEntity<?> createSupermarket(SupermarketDto supermarketRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
