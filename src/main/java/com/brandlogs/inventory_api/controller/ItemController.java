package com.brandlogs.inventory_api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brandlogs.inventory_api.dto.ItemDto;
import com.brandlogs.inventory_api.exception.InvalidDataException;
import com.brandlogs.inventory_api.service.ItemRequestValidation;

@RestController
@RequestMapping("api/brandlog/item")
public class ItemController {
	@Autowired
	private ItemRequestValidation itemRequestValidation;

	@RequestMapping(method = RequestMethod.POST, value = "/create/{store}/{vendor}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createItem(@RequestBody @Valid ItemDto itemRequest, @PathVariable("store") long storeId,
			@PathVariable("vendor") long vendorId) throws InvalidDataException {
		return itemRequestValidation.processRequest(itemRequest, storeId, vendorId);
	}

	@GetMapping("/{itemId}")
	public ResponseEntity<?> getItem(@PathVariable("itemId") long id) {
		return ResponseEntity.ok().build();
	}
}
