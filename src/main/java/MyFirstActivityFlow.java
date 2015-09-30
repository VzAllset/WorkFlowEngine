import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;

public class MyFirstActivityFlow {
	public static void main(String args[])
	{
		ProcessEngine processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
		RuntimeService runtimeService = processEngine.getRuntimeService();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		repositoryService.createDeployment().addClasspathResource("MyProcessDiagram.bpmn").deploy();
		String data = "0200B2200000001000000000000000800000000100000000010000011072218012345606A5DFGR021ABCDEFGHIJ 1234567890";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("data", data);
		//runtimeService.setVariable(runtimeService.startProcessInstanceByKey("myProcess").getId(), "data", data);
		runtimeService.startProcessInstanceByKey("myProcess",map);
	}
}
