package employee.employemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import employee.employemanagement.model.SubDepartment;
import employee.employemanagement.repository.DepartmentRepository;
import employee.employemanagement.repository.SubDeptRepo;

@RestController
public class SubDepController {
    

    @Autowired
	private SubDeptRepo subDepartmentRepo;

	@Autowired
	private DepartmentRepository departmentRepository;

    @GetMapping("/dept/sub-dept")
	public ModelAndView listSubDept(){
		ModelAndView model = new ModelAndView("manage-sub-dept");
		List<SubDepartment> list = (List<SubDepartment>)subDepartmentRepo.findAll(); 
		model.addObject("departments", list);
		return  model;
	}

	@GetMapping("/dept/sub-dept/add")
	public ModelAndView showAddSubDept(){
		ModelAndView model = new ModelAndView("add-subdept");
   		model.addObject("department", departmentRepository.findAll());
		return  model;
	} 

    @PostMapping("/dept/subdept/create")
	public ModelAndView AddSubDept(SubDepartment subdept){
		subDepartmentRepo.save(subdept);
		ModelAndView model = new ModelAndView("manage-sub-dept");
		List<SubDepartment> list = (List<SubDepartment>)subDepartmentRepo.findAll(); 
		model.addObject("departments", list);
		return  model;
	} 

	




	// Test purpose only
	@GetMapping("/subdepartment/test")
	public List<SubDepartment> test(){
		List<SubDepartment> list = (List<SubDepartment>)subDepartmentRepo.findAll(); 
		System.out.println(list);
		return  list;
	}



}
