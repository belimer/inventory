package com.brandlogs.inventory_api.service;

import org.springframework.http.ResponseEntity;

import com.brandlogs.inventory_api.dto.ItemDto;
import com.brandlogs.inventory_api.dto.ItemRequest;

public interface ItemService {

	ResponseEntity<?> getItems(long storeId,String date);
	ResponseEntity<?> createItems(ItemRequest itemRequest,long storeId,long vendorId);
}
