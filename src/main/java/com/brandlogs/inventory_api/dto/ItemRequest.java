package com.brandlogs.inventory_api.dto;

import com.brandlogs.inventory_api.model.ItemCategory;
import com.brandlogs.inventory_api.util.InventoryApiUtil;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemRequest {
	private String itemName;
	private String itemCode;
	private Double price;
	private int quantity;
	private ItemCategory category;
	public static ItemRequest valueOf(String name, ItemCategory category, int quantity, double price) {
		ItemRequest req = new ItemRequest();
		req.setCategory(category);
		req.setItemName(name);
		req.setPrice(price);
		req.setQuantity(quantity);
		
		req.setItemCode(InventoryApiUtil.referenceNumber());
		return req;
	}
	
	
}
