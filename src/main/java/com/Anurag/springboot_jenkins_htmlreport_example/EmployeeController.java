package com.Anurag.springboot_jenkins_htmlreport_example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository erepo;
	@GetMapping("/test")
	public String test() {
		return "This is test only";
	}
	
	@PostMapping("/save")
	public String save(@RequestBody Employee employee) {
		erepo.save(employee);
		return "data successfully saved into table";
	}
	
	@GetMapping("/all")
	public List<Employee> alldata() 
	{
		return erepo.findAll();
	}
	
	@GetMapping("/by-name/{name}")
	public List<Employee> byname(@PathVariable String name) {
		return erepo.findByName(name);
	}
	
	@GetMapping("/by-country/{country}")
	public List<Employee> bycountry(@PathVariable String country) {
		return erepo.findByCountry(country);
	}
	
	@GetMapping("/by-pincode/{pincode}")
	public List<Employee> bypincode(@PathVariable int pincode) {
		return erepo.findByPincode(pincode);
	}
	
	@PutMapping("/update-id/{id}")
	public Employee update(@RequestBody Employee employee, @PathVariable int id) {
		Employee emp=erepo.findById(id).get(id);
	
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
	// partial update
	@PatchMapping("/partial/{id}")
	public Employee partial(@RequestBody Employee employee, @PathVariable int id) {
		Employee emp=erepo.findById(id).get(id);
		emp.setAge(employee.getAge());
		emp.setCity(employee.getCity());
		emp.setCountry(employee.getCountry());
		emp.setName(employee.getName());
		erepo.save(emp);
		return emp;
	}
}
