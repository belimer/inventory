package com.brandlogs.inventory_api.service.impl;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.AddItemsToStoreResponseDTO;
import com.brandlogs.inventory_api.dto.ApiResonse;
import com.brandlogs.inventory_api.dto.StoreDto;
import com.brandlogs.inventory_api.exception.StoreNotFoundException;
import com.brandlogs.inventory_api.model.Item;
import com.brandlogs.inventory_api.model.Store;
import com.brandlogs.inventory_api.repository.ItemRepository;
import com.brandlogs.inventory_api.repository.StoreRepository;
import com.brandlogs.inventory_api.service.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private ItemRepository itemRepository;
//	@Override
//	public ResponseEntity<?> createStore(StoreDto store) {
//		Store newStore = new Store();
//		newStore.setLocation(store.getLocation());
//		newStore.setStoreName(store.getStoreName());
//		storeRepository.save(newStore);
//		ApiResonse response = new ApiResonse();
//		response.setStatus("OK");
//		response.setMessage("Created Succcefully");
//		response.setTransactionId(newStore.getStoreId());
//		response.setTimestamp(ZonedDateTime.now());
//		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);
//	}
//	@Override
//	public ResponseEntity<?> createStore(L store) {
//		
//		Store newStoreItem = new Store();
//		newStoreItem.setItem(item);
//		storeRepository.save(newStoreItem);
//		ApiResonse response = new ApiResonse();
//		response.setStatus("OK");
//		response.setMessage("Created Succcefully");
//		response.setTransactionId(100);
//		response.setTimestamp(ZonedDateTime.now());
//		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);
//	}

	@Override
	public ResponseEntity<?> createStore(StoreDto store) {
//		
		Store newStoreItem = new Store();
		newStoreItem.setLocation(store.getLocation());
		newStoreItem.setStoreName(store.getStoreName());
		storeRepository.save(newStoreItem);
		ApiResonse response = new ApiResonse();
		response.setStatus("OK");
		response.setMessage("Created Succcefully");
		response.setTransactionId(100);
		response.setTimestamp(ZonedDateTime.now());
		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);
	}

	@Override
	public AddItemsToStoreResponseDTO addItems(long storeId, @NotEmpty List<Long> itemsIDs) {
		 Store store = storeRepository.findById(storeId).orElseThrow(
	                () -> new StoreNotFoundException(storeId)
	        );
	        List<String> addedItemsNames = new ArrayList<>();
	        Set<Item> storeItems = store.getItems();
	        for (Long itemId : itemsIDs) {
	            Optional<Item> itemOptional = itemRepository.findById(itemId);
	            if (itemOptional.isPresent()) {
	                Item item = itemOptional.get();
	                storeItems.add(item);
	                addedItemsNames.add(item.getItemName());
	            }
	        }
	        System.out.println(addedItemsNames);
	        storeRepository.save(store);
	        return new AddItemsToStoreResponseDTO(store.getStoreId(), addedItemsNames);
	}

}
