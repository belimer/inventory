package com.brandlogs.inventory_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long itemId;
	@Column(name = "item_name")
	private String itemName;
	
	@JoinColumn(name = "vendor_id", nullable = false, updatable = false)
	@ManyToOne
	private Vendor vendor;
	
	@JoinColumn(name = "store_id", nullable = false, updatable = false)
	@ManyToOne
	private Store store;
	
	@Column(name = "item_code")
	private String itemCode;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "quantity")
	private long quantity;
	@Column(name = "category")
	@Enumerated(EnumType.STRING)
	private ItemCategory category;

}
