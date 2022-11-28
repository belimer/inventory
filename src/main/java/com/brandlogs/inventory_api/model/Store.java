package com.brandlogs.inventory_api.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "stores")
public class Store extends Record{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storeId;
	@Column(name = "store_name")
	private String storeName;
	@Column(name = "location")
	private String location;
	   @OneToMany(
	            cascade = CascadeType.ALL,
	            orphanRemoval = true
	    )
	    @JoinColumn(name = "store_id")
	    private Set<Item> items = new HashSet<>();
}
