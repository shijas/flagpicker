package com.example.fp;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
	public void getContinentsParamNull() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/continents").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk()).andExpect(content().string(equalTo(
				"[{\"continent\":\"Africa\",\"countries\":[{\"name\":\"Nigeria\",\"flag\":\"\\uD83C\\uDDF3\\uD83C\\uDDEC\"},{\"name\":\"Ethiopia\",\"flag\":\"\\uD83C\\uDDEA\\uD83C\\uDDF9\"},{\"name\":\"Egypt\",\"flag\":\"\\uD83C\\uDDEA\\uD83C\\uDDEC\"},{\"name\":\"DR Congo\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDE9\"},{\"name\":\"South Africa\",\"flag\":\"\\uD83C\\uDDFF\\uD83C\\uDDE6\"}]},{\"continent\":\"America\",\"countries\":[{\"name\":\"USA\",\"flag\":\"\\uD83C\\uDDFA\\uD83C\\uDDF8\"},{\"name\":\"Brazil\",\"flag\":\"\\uD83C\\uDDE7\\uD83C\\uDDF7\"},{\"name\":\"Mexico\",\"flag\":\"\\uD83C\\uDDF2\\uD83C\\uDDFD\"},{\"name\":\"Colombia\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDF4\"},{\"name\":\"Argentina\",\"flag\":\"\\uD83C\\uDDE6\\uD83C\\uDDF7\"}]},{\"continent\":\"Asia\",\"countries\":[{\"name\":\"China\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDF3\"},{\"name\":\"India\",\"flag\":\"\\uD83C\\uDDEE\\uD83C\\uDDF3\"},{\"name\":\"Indonesia\",\"flag\":\"\\uD83C\\uDDEE\\uD83C\\uDDE9\"},{\"name\":\"Pakistan\",\"flag\":\"\\uD83C\\uDDF5\\uD83C\\uDDF0\"},{\"name\":\"Bangladesh\",\"flag\":\"\\uD83C\\uDDE7\\uD83C\\uDDE9\"}]},{\"continent\":\"Europe\",\"countries\":[{\"name\":\"Russia\",\"flag\":\"\\uD83C\\uDDF7\\uD83C\\uDDFA\"},{\"name\":\"Germany\",\"flag\":\"\\uD83C\\uDDE9\\uD83C\\uDDEA\"},{\"name\":\"UK\",\"flag\":\"\\uD83C\\uDDEC\\uD83C\\uDDE7\"},{\"name\":\"France\",\"flag\":\"\\uD83C\\uDDEB\\uD83C\\uDDF7\"},{\"name\":\"Italy\",\"flag\":\"\\uD83C\\uDDEE\\uD83C\\uDDF9\"}]},{\"continent\":\"Oceania\",\"countries\":[{\"name\":\"Australia\",\"flag\":\"\\uD83C\\uDDE6\\uD83C\\uDDFA\"},{\"name\":\"Papua New Guinea\",\"flag\":\"\\uD83C\\uDDF5\\uD83C\\uDDEC\"},{\"name\":\"New Zealand\",\"flag\":\"\\uD83C\\uDDF3\\uD83C\\uDDFF\"},{\"name\":\"Fiji\",\"flag\":\"\\uD83C\\uDDEB\\uD83C\\uDDEF\"},{\"name\":\"Solomon Islands\",\"flag\":\"\\uD83C\\uDDF8\\uD83C\\uDDE7\"}]}]")));
	}

	@Test
	public void searchContinents() throws Exception {
		mvc.perform(
				MockMvcRequestBuilders.get("/continents").param("name", "meri").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(
						"[{\"continent\":\"America\",\"countries\":[{\"name\":\"USA\",\"flag\":\"\\uD83C\\uDDFA\\uD83C\\uDDF8\"},{\"name\":\"Brazil\",\"flag\":\"\\uD83C\\uDDE7\\uD83C\\uDDF7\"},{\"name\":\"Mexico\",\"flag\":\"\\uD83C\\uDDF2\\uD83C\\uDDFD\"},{\"name\":\"Colombia\",\"flag\":\"\\uD83C\\uDDE8\\uD83C\\uDDF4\"},{\"name\":\"Argentina\",\"flag\":\"\\uD83C\\uDDE6\\uD83C\\uDDF7\"}]}]")));
	}
	
	@Test
	public void getCountries() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/countries").param("names", "USA,India").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo(
						"[{\"name\":\"USA\",\"flag\":\"\\uD83C\\uDDFA\\uD83C\\uDDF8\"},{\"name\":\"India\",\"flag\":\"\\uD83C\\uDDEE\\uD83C\\uDDF3\"}]")));
	}

}
