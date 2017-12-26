package com.hellokoding.auth.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hellokoding.auth.model.Drzave;
import com.hellokoding.auth.repository.DrzaveRepository;

@RestController
public class StatesAngularJSController {

	@Autowired
	DrzaveRepository drzaveRepository;	

	@RequestMapping(value = "/getAllStates", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Drzave> getAllCustomers(Model model) {

		List<Drzave> listOfStates = drzaveRepository.findAll();
		model.addAttribute("state", new Drzave());
		model.addAttribute("listOfStates", listOfStates);
		return listOfStates;
	}

//	@RequestMapping(value = "/", method = RequestMethod.GET, headers = "Accept=application/json")
//	public String goToHomePage() {
//		return "redirect:/getAllCustomers";
//	}

	@RequestMapping(value = "/getState/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public void getStateById(@PathVariable Long id) {
		drzaveRepository.findOne(id);

	}

	@RequestMapping(value = "/addState", method = RequestMethod.POST) //, headers = "Accept=application/json"
	public Drzave addStateAJSr(@RequestBody Drzave drzave) {
//		Drzave a = drzave;
//		return customerService.addCustomer(customer);
		System.out.println(drzave);
		return drzaveRepository.save(drzave);

	}
	
	@RequestMapping(value = "/deleteState/{id}", method = RequestMethod.GET, headers = "Accept=application/json") // DELETE
	public void deleteCustomer(@PathVariable("id") Long id) {
		drzaveRepository.delete(id);
	}	

//	@RequestMapping(value = "/addCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
//	public Customer updateCustomer(@RequestBody Customer customer) {
//		return customerService.updateCustomer(customer); 
//
//	}	
//
//	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
//	public void deleteCustomer(@PathVariable("id") int id) {
//		customerService.deleteCustomer(id);
//	}	
}
