package com.functionServer.model.functions;

import java.math.BigDecimal;

public abstract class FunctionAbstract implements FunctionInterface{
	
	
	protected BigDecimal operand1;
	
	protected BigDecimal operand2;
	
	public BigDecimal getOperand1() {
		return operand1;
	}

	public void setOperand1(BigDecimal operand1) {
		this.operand1 = operand1;
	}

	public BigDecimal getOperand2() {
		return operand2;
	}

	public void setOperand2(BigDecimal operand2) {
		this.operand2 = operand2;
	}


}
