package com.brandlogs.inventory_api.exception;

public class StoreNotFoundException  extends RuntimeException {
    public StoreNotFoundException(long id) {
        super("Could not find store with id  " + id);
    }


}
