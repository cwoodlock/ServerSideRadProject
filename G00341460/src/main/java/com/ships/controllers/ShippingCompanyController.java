package com.ships.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.ShippingCompany;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {
	
	@Autowired //bean called shipService will handle the data
	ShippingCompanyService shippingCompanyService;
	
	//Method to display shipping companies in table
	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String listShippingCompany(Model model) {
		
		List<ShippingCompany> shippingCompanies = shippingCompanyService.findAll();			
		model.addAttribute("shippingCompanies", shippingCompanies);							
		
		return "showShippingCompanies";
	}
	
	//method to display addShipingCompany page
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addShippingCompanyGET(Model model) {

		ShippingCompany shippingCompany = new ShippingCompany();							
		model.addAttribute("shippingCompany", shippingCompany);								
		
		return "addShippingCompany";
	}
	
	//method to insert new shipping company into table
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String addShippingCompanyPOST(@Valid @ModelAttribute("shippingCompany") ShippingCompany shippingCompany, BindingResult result, Model model) {
		
		
		if (result.hasErrors()){
			return "addShippingCompany";
		} else {
			shippingCompanyService.save(shippingCompany);										
			return "redirect:showShippingCompanies";
		}
			
	}
	
}