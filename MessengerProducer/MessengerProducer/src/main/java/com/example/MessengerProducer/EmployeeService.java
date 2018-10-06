package com.example.MessengerProducer;



import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeService 
{
	@Autowired
	EmployeeDao employeeDao;
	ArrayList<Employee> emplist = new ArrayList<Employee>();
	/*@GetMapping(value="/select/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(path="/select",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public Employee readEmployee(@PathVariable("id")int id)
	{
	Employee emp= new Employee();
	emp.setAge(12);
	emp.setName("ABC");
	emp.setSalary(1234);
	System.out.println(id);
	return emp;
	}*/
	
	/*@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee insertEmployee(@RequestBody Employee emp)
	{
	System.out.println(emp);
	return emp;
	}*/
	
	
	@GetMapping(value="/select/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	//@RequestMapping(path="/select",method=RequestMethod.GET,produces=MediaType.APPLICATION_XML_VALUE)
	public Employee readEmployee(@PathVariable("id")Long id)
	{
		return employeeDao.getOne(id);
	}
	
	
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee addEmployee(@RequestBody Employee emp)
	{
		employeeDao.save(emp);
		emplist.add(emp);
		return emp;
	}
	
	@PutMapping(value="/update/{id}",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@PathVariable("id")Long id,@RequestBody Employee emp)
	{
		Optional<Employee> e= employeeDao.findById(id);
		if(e.isPresent())
		{
			employeeDao.save(emp);
			System.out.println("Success update");
		}
		else
		{
			System.out.println("ID not exist");
		}
		
	}
	
	@GetMapping(value="/delete/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public void delEmployee(@PathVariable("id")Long id)
	{
		employeeDao.deleteById(id);
		
		System.out.println("Success");
	}
}
