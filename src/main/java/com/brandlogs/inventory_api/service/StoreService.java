package com.brandlogs.inventory_api.service;

import org.springframework.http.ResponseEntity;

import com.brandlogs.inventory_api.dto.StoreDto;

public interface StoreService {
	
	ResponseEntity<?> createStore(StoreDto store);

}
