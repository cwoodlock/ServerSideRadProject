package com.ships.services;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipService {
	@Autowired
	ShipRepository shipRepository;
	
	public Iterable<Ship> findAll() {
		return (List<Ship>) shipRepository.findAll();
	}

	public Ship saveShip(Ship ship) {
		return shipRepository.save(ship);
		
	}

		
}
