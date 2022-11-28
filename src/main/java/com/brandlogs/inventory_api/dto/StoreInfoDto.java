package com.brandlogs.inventory_api.dto;

import java.util.List;

import com.brandlogs.inventory_api.model.Item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreInfoDto {
	private String name;
    private String location;
    private List<Item> items;
}
