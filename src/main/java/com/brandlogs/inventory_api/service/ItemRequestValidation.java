package com.brandlogs.inventory_api.service;

import java.util.Arrays;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.brandlogs.inventory_api.dto.ItemDto;
import com.brandlogs.inventory_api.dto.ItemRequest;
import com.brandlogs.inventory_api.exception.InvalidDataException;
import com.brandlogs.inventory_api.model.ItemCategory;

@Service
public class ItemRequestValidation {
	@Autowired
	private ItemService itemService;

	public ResponseEntity<?> processRequest(ItemDto itemRequest, long storeId,long vendorId) throws InvalidDataException{
		String name = itemRequest.getItemName();
		String type = itemRequest.getCategory();
		String quatity = itemRequest.getQuantity();
		String price = itemRequest.getPrice();
		if (name.length() > 64) {
			throw new InvalidDataException("name exceeds max length of 64!");
		}

		if (Double.parseDouble(price) < 0.01 || Double.parseDouble(price) > 9999.99) {
			throw new InvalidDataException("price should be between 0.01 and 9999.99 !");
		}

		boolean anyMatches = Arrays.stream(ItemCategory.values())
				.anyMatch(typeOfItem -> type.toUpperCase().equals(typeOfItem.name().toUpperCase()));

		if (!anyMatches) {
			throw new InvalidDataException(
					"Invalid product type! Valid are FOOD, TECHNOLOGY, HOUSEHOLD, DRINKS");
		}
		if (Integer.parseInt(quatity) < 0) {
			throw new InvalidDataException("quantity should be greater than 0!");
		}
		ItemRequest req = ItemRequest.valueOf(name, ItemCategory.valueOf(type.toUpperCase()), Integer.parseInt(quatity),
				Double.parseDouble(price));
		return itemService.createItems(req, storeId,vendorId);
	}

}
