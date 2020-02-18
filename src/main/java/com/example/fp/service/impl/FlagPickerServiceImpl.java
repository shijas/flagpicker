package com.example.fp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fp.dao.FlagPickerRepository;
import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Service
public class FlagPickerService {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerService.class);

	@Autowired
	private FlagPickerRepository flagPickerRepository;

	/**
	 * Service to fetch all continents if name is null 
	 * or continent by name.
	 *
	 * @param name String
	 * @return continents List<Continent> 
	 */
	public List<Continent> findContinentByName(String name) {
		if (name == null) {
			LOGGER.info("Continents service to fetch all");
			return flagPickerRepository.findAll();
		}
		LOGGER.info("Continents by name service call :: {}", name);
		return flagPickerRepository.findByContinents(name);
	}
	
	/**
	 * Service to find countries by name
	 *
	 * @param countryName List<String>
	 * @return countries List<Country> 
	 */
	public List<Country> findContriesByName(List<String> countryNames) {
		LOGGER.info("Contry service to fetch by name");
		return flagPickerRepository.findContries(countryNames);
	}
}