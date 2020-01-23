package com.functionServer.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.functionServer.util.AppConstants;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FunctionControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void multiplyNullValueOperatorTest() throws Exception {
		
		String jsonBody = "{\"operand1\": null, \"operand2\": null}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(AppConstants.FUNCTIONS_PATH + "/multiply").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"Error: One of the operand is invalid\",\"success\":false,\"result\":null}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		assertEquals(expectedResult, response.getContentAsString());
		
	}
	
	@Test
	public void multiplyPositiveValueOperatorTest() throws Exception {
		
		String jsonBody = "{\"operand1\": 10, \"operand2\": 30}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(AppConstants.FUNCTIONS_PATH + "/multiply").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"success\":true,\"result\":300}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		assertEquals(expectedResult, response.getContentAsString());
		
	}
	
	@Test
	public void multiplyNegativeValueOperatorTest() throws Exception {
		
		String jsonBody = "{\"operand1\": 10, \"operand2\": -15}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(AppConstants.FUNCTIONS_PATH + "/multiply").accept(
				MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"success\":true,\"result\":-150}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		assertEquals(expectedResult, response.getContentAsString());
		
	}

}
