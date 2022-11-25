package com.brandlogs.inventory_api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supermarkets")
public class Supermarket {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long supermarketId;
}
