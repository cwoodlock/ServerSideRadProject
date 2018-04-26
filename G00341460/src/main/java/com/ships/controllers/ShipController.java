/*
 Colm Woodlock
 G00341460
 */
package com.ships.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {
	
	//shipService is a bean which will handle the data
	@Autowired
	private ShipService shipService;
	
	//This will display all the ships in the table
	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String showShips(Model model) {
		List<Ship> ships = (List<Ship>) shipService.findAll();
		model.addAttribute("ships", ships);
		
		
		return "showShips";
	}
	
	//Get method to add a new ship to the table
	@RequestMapping(value = "/addShip", method = RequestMethod.GET)
	public String addShip(@ModelAttribute("shipAdd")Ship c, HttpServletRequest h){
		return "addShip";
	}
	
	//Post method to add a new ship to the table
	@RequestMapping(value = "/addShip", method = RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("shipAdd") Ship ship, BindingResult result, Model model) {
		
		if (result.hasErrors()) { //Check if there are any erros
			return "addShip";
		} else {
			shipService.saveShip(ship);												// it saves the data of the ship in the database
			return "redirect:showShips";
		}
	}
}
