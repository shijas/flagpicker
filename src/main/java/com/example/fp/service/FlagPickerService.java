package com.example.fp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Service
public interface FlagPickerService {

	/**
	 * Service to fetch all continents if name is null or continent by name.
	 *
	 * @param name String
	 * @return continents List<Continent>
	 */
	public List<Continent> findContinentByName(String name);

	/**
	 * Service to find countries by name
	 *
	 * @param countryName List<String>
	 * @return countries List<Country>
	 */
	public List<Country> findContriesByName(List<String> countryNames);
}