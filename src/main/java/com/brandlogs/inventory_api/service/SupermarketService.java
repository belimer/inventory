package com.brandlogs.inventory_api.service;

import org.springframework.http.ResponseEntity;

import com.brandlogs.inventory_api.dto.SupermarketDto;

public interface SupermarketService {

	ResponseEntity<?> createSupermarket(SupermarketDto supermarketRequest);
}
