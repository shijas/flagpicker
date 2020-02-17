package com.example.fp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class FlagPickerControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void getContinents() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/continents").param("name", "America").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(
						"[{\"continent\":\"America\",\"countries\":[{\"name\":\"USA\",\"flag\":\"\\uD83C\\uDDFA\\uD83C\\uDDF8\"},{\"name\":\"Brazil\",\"flag\":\"\\uD83C\\uDDE7\\uD83C\\uDDF7\"},{\"name\":\"Mexico\",\"flag\":\"\\uD83C\\uDDF2\\uD83C\\uDDFD\"},{\"name\":\"Colombia\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDF4\"},{\"name\":\"Argentina\",\"flag\":\"\\uD83C\\uDDE6\\uD83C\\uDDF7\"}]}]")));
	}

	@Test
	public void getCountries() throws Exception {
		List<String> countryList = new ArrayList<>();
		countryList.add("USA");
		mvc.perform(MockMvcRequestBuilders.get("/countries").param("name", "USA").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(
						"[{\"continent\":\"America\",\"countries\":[{\"name\":\"USA\",\"flag\":\"\\uD83C\\uDDFA\\uD83C\\uDDF8\"},{\"name\":\"Brazil\",\"flag\":\"\\uD83C\\uDDE7\\uD83C\\uDDF7\"},{\"name\":\"Mexico\",\"flag\":\"\\uD83C\\uDDF2\\uD83C\\uDDFD\"},{\"name\":\"Colombia\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDF4\"},{\"name\":\"Argentina\",\"flag\":\"\\uD83C\\uDDE6\\uD83C\\uDDF7\"}]}]")));
	}

}
