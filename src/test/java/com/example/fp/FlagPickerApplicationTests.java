package com.example.fp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.fp.model.Continent;
import com.example.fp.service.FlagPickerService;

@SpringBootTest
class FlagPickerApplicationTests {
	
	@Autowired
	FlagPickerService flagPickerService;

	@Test
	void contextLoads() {
		
	}

	@Test
	public void fetchContinents() {
		List<Continent> continents = flagPickerService.findContinentByName("meri");
		System.out.println("in continents " + continents.get(0).getCountries().get(0).getName());
		assertEquals("USA", continents.get(0).getCountries().get(0).getName());
	}
	
}
