package com.brandlogs.inventory_api.service;

import org.springframework.http.ResponseEntity;

import com.brandlogs.inventory_api.dto.VendorDto;

public interface VendorService {

	ResponseEntity<?> createVendor(VendorDto vendorRequest);
}
