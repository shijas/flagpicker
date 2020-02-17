package com.example.fp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;
import com.example.fp.service.FlagPickerService;

@RestController
public class FlagPickerController {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerController.class);

	@Autowired
	FlagPickerService flagPickerService;

	@GetMapping("/continents")
	public List<Continent> fetchContinents(@RequestParam String name) {
		LOGGER.info("START: Continents REST service");
		return flagPickerService.findContinentByName(name);
	}
	
	@GetMapping("/coutries")
	public List<Country> fetchCountries(@RequestParam List<String> names) {
		LOGGER.info("START: Coutries REST service");
		return flagPickerService.findContriesByName(names);
	}

}
