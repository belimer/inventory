package com.brandlogs.inventory_api.service.impl;

import java.time.ZonedDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.ApiResonse;
import com.brandlogs.inventory_api.dto.StoreDto;
import com.brandlogs.inventory_api.model.Store;
import com.brandlogs.inventory_api.repository.StoreRepository;
import com.brandlogs.inventory_api.service.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreRepository storeRepository;
	@Override
	public ResponseEntity<?> createStore(StoreDto store) {
		Store newStore = new Store();
		newStore.setLocation(store.getLocation());
		newStore.setStoreName(store.getStoreName());
		storeRepository.save(newStore);
		ApiResonse response = new ApiResonse();
		response.setStatus("OK");
		response.setMessage("Created Succcefully");
		response.setTransactionId(newStore.getStoreId());
		response.setTimestamp(ZonedDateTime.now());
		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);
	}

}
