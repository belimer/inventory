package com.brandlogs.inventory_api.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/brandlog/supermarket")
public class SupermarketController {
	@PostMapping("/create")
	public ResponseEntity<?> createSupermarket() {
		return ResponseEntity.ok().build();
	}
	@GetMapping("/{supermaketId}")
	public ResponseEntity<?> getSupermarket(@PathVariable("supermaketId") long id){
		return ResponseEntity.ok().build();
	}
}
