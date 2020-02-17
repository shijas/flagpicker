package com.example.fp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fp.dao.FlagPickerRepository;
import com.example.fp.model.Continent;
import com.example.fp.model.Country;

@Service
public class FlagPickerService {

	@Autowired
	private FlagPickerRepository flagPickerRepository;

	public List<Continent> findContinentByName(String name) {
		if (name == null) {
			return flagPickerRepository.findAll();
		}
		return flagPickerRepository.findByContinents(name);
	}
	
	public List<Country> findContriesByName(List<String> countryNames) {
		return flagPickerRepository.findContries(countryNames);
	}
}