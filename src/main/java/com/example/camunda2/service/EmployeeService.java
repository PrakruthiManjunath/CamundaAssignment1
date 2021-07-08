package com.example.camunda2.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.camunda.bpm.engine.variable.VariableMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

	@Value("${employee}")
	public String employeeName;

	public Object triggerProcess(String activityName)
	{
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
	    ProcessInstantiationBuilder instance = engine.getRuntimeService().createProcessInstanceByKey(activityName);
	    instance.setVariable("employee", employeeName);
	    
	    ProcessInstanceWithVariables response = instance.executeWithVariablesInReturn();
	    
	    VariableMap variables = response.getVariables();
		System.out.println(variables.get("getEmployee"));
		//System.out.println("getEmp="+variables.get("getEmployee"));
		return  variables.get("getEmployee");
	}
	
	public String getEmployeeData(String varName)
	{
		System.out.println("Name of the Employee: " +varName);
		return varName;
	}

}
