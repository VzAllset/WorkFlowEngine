package com.vzw.prepaid.Services;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import com.vzw.prepaid.Message;
import com.vzw.prepaid.ISO.ParseISOMessage;

public class TestCalling implements JavaDelegate {
	@Override
	public void execute(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		String data = String.valueOf(arg0.getVariable("data"));
		System.out.println("Data is +"+data);
		Message message = new ParseISOMessage().getMsgObject(data);
		arg0.setVariable("message", message);
		System.out.println("---->>>"+message.getProcessingCode());
		if(message != null && message.getProcessingCode().equalsIgnoreCase("000100"))
		{
			arg0.setVariable("newCustomerOrder", true);
		}
		else
		{
			arg0.setVariable("newCustomerOrder", false);
		}
		
	}
}
