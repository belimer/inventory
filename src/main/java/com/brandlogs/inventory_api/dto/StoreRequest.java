package com.brandlogs.inventory_api.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class StoreRequest {
	private String storeName;
	private String location;

}
