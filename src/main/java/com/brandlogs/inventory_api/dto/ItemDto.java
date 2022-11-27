package com.brandlogs.inventory_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
//@Accessors(fluent = true, chain = true)
public class ItemDto {
	private String itemName;
	private String price;
	private String quantity;
	private String category;
}
