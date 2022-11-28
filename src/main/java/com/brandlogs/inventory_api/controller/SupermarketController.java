package com.brandlogs.inventory_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandlogs.inventory_api.dto.StoreDto;
import com.brandlogs.inventory_api.dto.SupermarketDto;
import com.brandlogs.inventory_api.service.SupermarketService;

@RestController
@RequestMapping("api/brandlog/supermarket")
public class SupermarketController {
	@Autowired
	private SupermarketService supermarketService;
	@PostMapping("/create")
	public ResponseEntity<?> createSupermarket(@RequestBody SupermarketDto req) {
		return supermarketService.createSupermarket(req);
	}
	
	@GetMapping("/{supermaketId}")
	public ResponseEntity<?> getSupermarket(@PathVariable("supermaketId") long id){
		return ResponseEntity.ok().build();
	}
}
