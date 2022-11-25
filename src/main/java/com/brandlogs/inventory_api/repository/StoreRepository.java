package com.brandlogs.inventory_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brandlogs.inventory_api.model.Store;

@Repository
public interface StoreRepository  extends JpaRepository<Store, Long>{

}
