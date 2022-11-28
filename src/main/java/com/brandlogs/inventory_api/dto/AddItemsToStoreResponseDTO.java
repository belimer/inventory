package com.brandlogs.inventory_api.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemsToStoreResponseDTO {

    public AddItemsToStoreResponseDTO(Long storeId, List<String> addedItemsNames) {
        this.storeId = storeId;
        this.addedItemsNames = addedItemsNames;
    }

    private Long storeId;
    private List<String> addedItemsNames;

}
