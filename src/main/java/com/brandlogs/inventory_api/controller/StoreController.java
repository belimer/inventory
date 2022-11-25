package com.brandlogs.inventory_api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/brandlog/store")
public class StoreController {
	 @PostMapping("/create")
	public ResponseEntity<?> createStore() {
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{storeId}")
	public ResponseEntity<?> getStore(@PathVariable("storeId") long id){
		return ResponseEntity.ok().build();
	}
}
