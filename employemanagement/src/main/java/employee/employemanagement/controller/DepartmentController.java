package employee.employemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import employee.employemanagement.model.Department;
import employee.employemanagement.repository.DepartmentRepository;
import employee.employemanagement.service.DepartmentService;
 
@RestController
public class DepartmentController {
	
	static final Logger logger  = LogManager.getLogger(DepartmentController.class.getName());
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private DepartmentRepository departmentRepository;

	// Get add-dept page
	@GetMapping("/add-dept")
	public ModelAndView addEmpPage(){
		ModelAndView model = new ModelAndView("addDepartment");
   		model.addObject("department");
		return model;
	} 

	 
	// displaying list of all department
		@GetMapping("/departments")
		public ModelAndView getAllDepartment(){
		ModelAndView model = new ModelAndView("list-dept");
		List<Department> list = (List<Department>)departmentRepository.findAll(); 
		
		model.addObject("departments", list);
		return model;
		}

		// displaying list of all department
		@GetMapping("/departments/test")
		public List<Department> testgetalldept(){

		List<Department> list = (List<Department>)departmentRepository.findAll(); 
		System.out.println(list);
			return list;
		}


		// displaying department by id
		@GetMapping("/departments/{id}")
		public Optional<Department> getDepartment(@PathVariable int id){
			
			return departmentService.getDepartment(id);
		}
		
		// inserting department
		@PostMapping("/departments")
		public ModelAndView addDepartment(@ModelAttribute Department department){
			departmentService.addDepartment(department);
			ModelAndView model = new ModelAndView("list-dept");		
			List<Department> list = (List<Department>)departmentRepository.findAll(); 
		
			model.addObject("departments", list);
			
			return model;
		}

		//updating department by id
		@PutMapping("/departments/{id}")
		public void updateDepartment(@RequestBody Department d, @PathVariable int id){
			departmentService.updateDepartment(d, id);
		}
		
		// deleting all department
		@DeleteMapping("/departments")
		public void deleteAllDepartments(){
			departmentService.deleteAllDepartment();
		}

		// deleting department by id
		@DeleteMapping("/department/delete/{id}")
		public void deleteDepartmentByID(@RequestBody Department d, @PathVariable int id){
			departmentService.deleteDepartmentByID(id);
		}
		
		// deleting employee by id
		@GetMapping("/department/delete/{id}")
		public ModelAndView deleteDepartmentByID(@PathVariable("id") int id, Model model) {
    	Department department = departmentRepository.findById(id)
    	.orElseThrow(() -> new IllegalArgumentException("Invalid department Id:" + id));
		departmentRepository.delete(department);

		ModelAndView mvw = new ModelAndView("list-dept");		
		List<Department> list = (List<Department>)departmentRepository.findAll(); 
		mvw.addObject("departments", list);
    	return mvw;
}

		// updating/ patching department by id
		@PatchMapping("departments/{id}")
		public void patchDepartmentByID(@RequestBody Department d, @PathVariable int id) {
			departmentService.patchDepartment(d, id);
		}
}
