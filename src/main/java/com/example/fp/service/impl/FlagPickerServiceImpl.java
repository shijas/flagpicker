package com.example.fp.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.fp.dao.impl.FlagPickerDAOImpl;
import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Service
public class FlagPickerServiceImpl {
	
    private static final Logger LOGGER = LoggerFactory.getLogger(FlagPickerServiceImpl.class);

	@Autowired
	private FlagPickerDAOImpl flagPickerDAOImpl;
	
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
			return flagPickerDAOImpl.findAll();
		}
		LOGGER.info("Continents by name service call :: {}", name);
		return flagPickerDAOImpl.findByContinents(name);
	}
	
	/**
	 * Service to find countries by name
	 *
	 * @param countryName List<String>
	 * @return countries List<Country> 
	 */
	public List<Country> findContriesByName(List<String> countryNames) {
		LOGGER.info("Contry service to fetch by name");
		return flagPickerDAOImpl.findContries(countryNames);
	}
}