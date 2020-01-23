package com.functionServer.model.functions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.functionServer.controller.FunctionController;
import com.functionServer.response.FunctionResponse;
import com.functionServer.util.AppConstants;

public class MultiplyFunction extends FunctionAbstract{
	
	private static final Logger logger = LogManager.getLogger(MultiplyFunction.class);

	@Override
	public FunctionResponse run() throws Exception {
		// TODO Auto-generated method stub
		
		FunctionResponse response = new FunctionResponse();
		
		if(this.operand1 != null && this.operand2 !=null) {
			response.setResult(operand1.multiply(operand2));
			response.setSuccess(true);
			
		} else {
			response.setMessage(AppConstants.ERROR_OPERAND_NOT_VALID);
			logger.error("operation not performed");
		}
		return response;
	}
}
