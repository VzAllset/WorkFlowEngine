package com.vzw.prepaid.Services;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class NewCustomerOrder implements JavaDelegate
{

	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("hurrah ::::: "+arg0.getVariable("myVariable"));
		arg0.setVariable("validOrder", "true");
	}

}
