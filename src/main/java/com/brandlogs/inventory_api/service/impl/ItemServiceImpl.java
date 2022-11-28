package com.brandlogs.inventory_api.service.impl;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.ApiResonse;
import com.brandlogs.inventory_api.dto.ItemDto;
import com.brandlogs.inventory_api.dto.ItemRequest;
import com.brandlogs.inventory_api.model.Item;
import com.brandlogs.inventory_api.model.Store;
import com.brandlogs.inventory_api.model.Vendor;
import com.brandlogs.inventory_api.repository.ItemRepository;
import com.brandlogs.inventory_api.repository.StoreRepository;
import com.brandlogs.inventory_api.repository.VendorRepository;
import com.brandlogs.inventory_api.service.ItemService;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Override
	public ResponseEntity<?> getItems(long storeId, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<?> createItems(ItemRequest itemRequest,long vendorId) {
		// TODO Auto-generated method stub
//		Store store = storeRepository.findById(storeId).get();
		Vendor vendor = vendorRepository.findById(vendorId).get();
		logger.info(vendor.getVendorName());
		Item newItem = new Item();
		newItem.setCategory(itemRequest.getCategory());
		newItem.setItemCode(itemRequest.getItemCode());
		newItem.setItemName(itemRequest.getItemName());
		newItem.setQuantity(itemRequest.getQuantity());
		newItem.setPrice(itemRequest.getPrice());
		newItem.setVendor(vendor);
		
		
		itemRepository.save(newItem);
		ApiResonse response = new ApiResonse();
		response.setStatus("OK");
		response.setMessage("Created Succcefully");
		response.setTransactionId(newItem.getItemId());
		response.setTimestamp(ZonedDateTime.now());
		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);
	}

}
