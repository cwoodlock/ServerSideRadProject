/*
 Colm Woodlock
 G00341460
 */
package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ships.model.Ship;

public interface ShipRepository extends CrudRepository<Ship, Integer> {
	
}