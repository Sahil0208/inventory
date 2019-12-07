package com.amdocs.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amdocs.inventory.model.ProductCharacteristic;

/**
 * The Interface ProductCharacteristicsRepository.
 */
@Repository
public interface ProductCharacteristicsRepository extends JpaRepository<ProductCharacteristic, Long> {

}
