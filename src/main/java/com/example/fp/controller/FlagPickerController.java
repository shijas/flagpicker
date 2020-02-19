package com.example.fp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;
import com.example.fp.service.impl.FlagPickerServiceImpl;

import io.micrometer.core.annotation.Timed;

@RestController
public class FlagPickerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerController.class);

	@Autowired
	FlagPickerServiceImpl flagPickerServiceImpl;

	/**
	 * Method to fetch all continents if name is null or continent by name.
	 *
	 * @param name String
	 * @return continents List<Continent>
	 */
	@GetMapping("/continents")
	@Timed
	public List<Continent> fetchContinents(@RequestParam(required = false) String name) {
		List<Continent> continents = new ArrayList<>();
		LOGGER.info("START: Continents REST Controller :: {}", name);
		try {
			continents = flagPickerServiceImpl.findContinentByName(name);
		} catch (Exception e) {
			LOGGER.error("Exception occured {}", e.getMessage());
		}
		return continents;
	}

	/**
	 * Service to find countries by name
	 *
	 * @param name String
	 * @return countries List<Country>
	 */
	@GetMapping("/countries")
	@Timed
	public List<Country> fetchCountries(@RequestParam(required = true) String names) {
		LOGGER.info("START: Coutries REST Controller {}", names);
		List<String> countryList = Arrays.asList(names.split(","));
		List<Country> countries = new ArrayList<>();
		try {
			countries = flagPickerServiceImpl.findContriesByName(countryList);
		} catch (Exception e) {
			LOGGER.error("Exception occured {}", e.getMessage());
		}
		return countries;
	}

}
