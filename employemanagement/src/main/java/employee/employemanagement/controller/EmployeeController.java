package employee.employemanagement.controller;

import employee.employemanagement.model.Employee;
import employee.employemanagement.repository.DepartmentRepository;
import employee.employemanagement.repository.EmployeeRepository;
import employee.employemanagement.repository.SubDeptRepo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Optional;

import employee.employemanagement.service.EmployeeService;

@RestController
public class EmployeeController {
	
	static final Logger logger  = LogManager.getLogger(EmployeeController.class.getName());

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SubDeptRepo subdepartmentrepo;


	// Get emp-add page
	@GetMapping("/add-emp")
	public ModelAndView addEmpPage(){
		ModelAndView model = new ModelAndView("addEmp");
   		model.addObject("department", departmentRepository.findAll());
   		model.addObject("subdepartment", subdepartmentrepo.findAll());
		return  model;
	} 

	// displaying list of all employees
	@GetMapping("/employees")
	public ModelAndView getAllEmployee(){
		ModelAndView model = new ModelAndView("list-emp");
		List<Employee> list = (List<Employee>)employeeRepository.findAll();
		model.addObject("employees", list);
		return model;
	}

		// // displaying list of all employees
		// @GetMapping("/employees/test")
		// public List<Employee> getAllEmployees(){
			
		// 	List<Employee> list = (List<Employee>)employeeRepository.findAll();
		
		// 	return list;
		// }

	// postman getAllEmployees , delete after complete task 
	@GetMapping("/employees/test")
	public List<Employee> getemp(){
		List<Employee> list = (List<Employee>)employeeRepository.findAll();
		return list;
	}

	
	// displaying department by id
	@GetMapping("/employees/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}
	
	// inserting employee
	@PostMapping("/employees")
	public ModelAndView addEmployees( Employee employee){
		System.out.println(employee);
		employeeService.addEmployee(employee);

		
		ModelAndView model = new ModelAndView("list-emp");
		List<Employee> list = (List<Employee>)employeeRepository.findAll(); 
		model.addObject("employees", list);
		return model;
	}

	//updating employee by id
	@PutMapping("/employees/update/{id}")
	public void updateEmployee(@RequestBody Employee e, @PathVariable int id){
		employeeService.updateEmployee(e, id);
	}

	// deleting employee by id
	@GetMapping("/employee/delete/{id}")
	public ModelAndView deleteUser(@PathVariable("id") int id, Model model) {
    Employee user = employeeRepository.findById(id)
    .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	employeeRepository.delete(user);

	ModelAndView mvw = new ModelAndView("list-emp");
	List<Employee> list = (List<Employee>)employeeRepository.findAll(); 
	mvw.addObject("employees", list);
    return mvw;
}

	// updating/ patching employee by id
	@PatchMapping("employees/{id}")
	public void patchEmployeeByID(@RequestBody Employee e, @PathVariable int id) {
		employeeService.patchEmployee(e, id);
	}
}
