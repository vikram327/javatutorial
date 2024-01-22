package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;




@RestController
@RequestMapping("/employees")
@CrossOrigin(origins="http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	public EmployeeController() {
		
		System.out.println("in ctr of"+getClass());
	}
	@GetMapping
	public List<Employee> listAllEmps(){
		
		return empService.getAllEmps();
	}
	//URL: http://localhost:8000/employees/
	//Method:POST
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee newEmp) {
		
		return empService.addEmpsDetails(newEmp);
		
	}
	@DeleteMapping("/{empId}")
	public String deleteEmpDetails(@PathVariable Long empId) {
		return empService.deleteEmpDetails(empId);
	}
	@GetMapping("/{Id}")
	public String updateEmpDetails(@PathVariable Long empId) {
		return empService.upadteEmpDetails(empId);
	}
	
}
