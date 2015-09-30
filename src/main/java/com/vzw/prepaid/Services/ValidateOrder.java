package com.vzw.prepaid.Services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.vzw.prepaid.Message;

public class ValidateOrder implements JavaDelegate
{

	@Override
	public void execute(DelegateExecution arg0) throws Exception 
	{
		Message message = (Message)arg0.getVariable("message");
		System.out.println("Inside validateOrder :"+message.getMsgTypeIndicator());
		System.out.println();
		// TODO Auto-generated method stub
		if(arg0.getVariable("validOrder")!=null && arg0.getVariable("validOrder")=="true")
		{
			System.out.println("Order is valid..");
			arg0.setVariable("isValidOrder", true);
		}
		else
		{
			System.out.println("Order is invalid..");
			arg0.setVariable("isValidOrder", false);
		}
	}

}
