package com.brandlogs.inventory_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brandlogs.inventory_api.dto.StoreDto;
import com.brandlogs.inventory_api.dto.VendorDto;
import com.brandlogs.inventory_api.service.StoreService;
import com.brandlogs.inventory_api.service.VendorService;

@RestController
@RequestMapping("api/brandlog/vendor")
public class VendorController {
	@Autowired
	private VendorService vendorService;
	 @PostMapping("/create")
	public ResponseEntity<?> createStore(@RequestBody VendorDto req) {
		return vendorService.createVendor(req);
	}
}
