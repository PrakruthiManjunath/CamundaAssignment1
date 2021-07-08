package com.example.camunda2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.camunda2.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/process/{activityName}")
	public void getByName(@PathVariable String activityName)
	{
		employeeService.triggerProcess(activityName);
	}
	
	@GetMapping("/process/getEmployee/{varName}")
	public String getEmployeeData(@PathVariable String varName)
	{
		return employeeService.getEmployeeData(varName);
	}


}
