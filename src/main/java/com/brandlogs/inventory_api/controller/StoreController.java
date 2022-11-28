package com.brandlogs.inventory_api.controller;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brandlogs.inventory_api.dto.AddItemsToStoreResponseDTO;
import com.brandlogs.inventory_api.dto.StoreDto;
import com.brandlogs.inventory_api.dto.StoreInfoDto;
import com.brandlogs.inventory_api.service.StoreService;

@RestController
@RequestMapping("api/brandlog/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	 @PostMapping("/create")
	public ResponseEntity<?> createStore(@RequestBody StoreDto req) {
		return storeService.createStore(req);
	}
	 
	 @PostMapping("/addItems")
	    public ResponseEntity<AddItemsToStoreResponseDTO> addItemToSupermarket(@RequestParam long
	                                                                                         storeId,
	                                                                                 @RequestParam @NotEmpty
	                                                                                         List<Long> itemsIDs) {
		 AddItemsToStoreResponseDTO addItemsToSupermarketResponseDTO =
	        		storeService.addItems(storeId, itemsIDs);
	        return new ResponseEntity<>(addItemsToSupermarketResponseDTO, HttpStatus.OK);
	    }
	 
	  @GetMapping("/{storeId}")
	    public ResponseEntity<StoreInfoDto> getStore(@PathVariable Long storeId) {
	        return new ResponseEntity<>(storeService.getStoreInfo(storeId), HttpStatus.OK);
	    }
}
