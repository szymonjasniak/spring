package javabeat.net.springboot.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javabeat.net.springboot.domain.Employee;
import javabeat.net.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
	private final EmployeeService employeeService;

	@Inject
	public EmployeeController(final EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@RequestMapping(value = "/allEmployee", method = RequestMethod.GET)
	public List<Employee> listEmployees() {
		List<Employee> employees = employeeService.getList();
		return employees;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public void addEmployee(@RequestParam(value = "employeeName", required = true) String employeeName,
			@RequestParam(value = "employeeId", required = false) String employeeId,
			@RequestParam(value = "employeeCity", required = false) String employeeCity) {
		Employee employee = new Employee(employeeId, employeeName, employeeCity);
		employeeService.save(employee);
	}
	
	
	
	@RequestMapping(value = "/allEmployees", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		List<Employee> employees = employeeService.getList();
		
		model.addAttribute("employeeList", employees);
		return "";
	}
	
}
