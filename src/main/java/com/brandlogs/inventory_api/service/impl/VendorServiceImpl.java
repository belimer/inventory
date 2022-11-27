package com.brandlogs.inventory_api.service.impl;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.ApiResonse;
import com.brandlogs.inventory_api.dto.VendorDto;
import com.brandlogs.inventory_api.model.Vendor;
import com.brandlogs.inventory_api.repository.ItemRepository;
import com.brandlogs.inventory_api.repository.StoreRepository;
import com.brandlogs.inventory_api.repository.VendorRepository;
import com.brandlogs.inventory_api.service.VendorService;

@Service
public class VendorServiceImpl implements VendorService {
	@Autowired
	private VendorRepository vendorRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public ResponseEntity<?> createVendor(VendorDto vendorRequest) {
		Vendor newVendor= new Vendor();
		newVendor.setVendorName(vendorRequest.getVendorName());
		vendorRepository.save(newVendor);
		ApiResonse response = new ApiResonse();
		response.setStatus("OK");
		response.setMessage("Created Succcefully");
		response.setTransactionId(newVendor.getVendorId());
		response.setTimestamp(ZonedDateTime.now());
		return new ResponseEntity<ApiResonse>(response, HttpStatus.ACCEPTED.OK);	}

}
