package employee.employemanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Home {
    // displaying employee by id
	@GetMapping("/")
	public ModelAndView getHome(){
		ModelAndView model = new ModelAndView("home");
   		model.addObject("department");
		return model;
	}
	
}
