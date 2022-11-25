package com.brandlogs.inventory_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
public class Item extends Record {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long itemId;
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "store_id")
	private Store store;
	
	@Column(name = "price")
	private double price;
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private ItemCategory category;

}
