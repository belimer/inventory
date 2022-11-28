package com.brandlogs.inventory_api.service;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.http.ResponseEntity;

import com.brandlogs.inventory_api.dto.AddItemsToStoreResponseDTO;
import com.brandlogs.inventory_api.dto.StoreDto;

public interface StoreService {
	
	ResponseEntity<?> createStore(StoreDto store);

	AddItemsToStoreResponseDTO addItems(long storeId, @NotEmpty List<Long> itemsIDs);

}
