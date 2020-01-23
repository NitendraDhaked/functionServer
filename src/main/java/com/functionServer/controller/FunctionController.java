package com.functionServer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.functionServer.model.functions.FunctionInterface;
import com.functionServer.model.functions.MultiplyFunction;
import com.functionServer.response.FunctionResponse;
import com.functionServer.util.AppConstants;

@RestController
@RequestMapping(AppConstants.FUNCTIONS_PATH)
public class FunctionController {
	
	
	private static final Logger logger = LogManager.getLogger(FunctionController.class);
	
	@PostMapping("/multiply")
	public FunctionResponse multiply(@RequestBody MultiplyFunction function) {
		
		
		FunctionResponse response = new FunctionResponse();

		if(function != null) {
			//logger.info("Input data: " + operation.toString());
			response = this.execLogic(function);
		}else {
			logger.error("function is null");
			response.setMessage("Function logic is not performed");
		}
		
		return response;
	}
	
	
	private FunctionResponse execLogic(FunctionInterface function){
				
		FunctionResponse response = null;
		try {
			logger.info("calling function logic.");

			response = function.run();
		}catch(Exception ex) {
			logger.error("Error in calling function: ", ex);
			response.setMessage("Something went wrong while calling function");
		}
		
		return response;
		
		
	}

}
