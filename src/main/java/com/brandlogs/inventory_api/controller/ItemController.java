package com.brandlogs.inventory_api.controller;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/brandlog/item")
public class ItemController {
	@RequestMapping(method = RequestMethod.POST, value = "/create/{stroreId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createItem(@PathVariable("storeId") long id) {
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{itemId}")
	public ResponseEntity<?> getItem(@PathVariable("itemId") long id){
		return ResponseEntity.ok().build();
	}
}
