package com.brandlogs.inventory_api.util;

import org.apache.commons.lang3.RandomStringUtils;

public class InventoryApiUtil {
	public static String referenceNumber() {
//        String ref= String.format("REF%s", LocalDateTime.now().format(DATE_TIME_FORMATTER));
	 String ref =RandomStringUtils.randomAlphanumeric(8);
        if (ref.length() <= 8) {
            return ref;
        } else {
            return ref.substring(0, 8);
        }
    }
}
