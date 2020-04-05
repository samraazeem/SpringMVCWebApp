package demo.samra;

//import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/store")

public class EmployeeController {
	@RequestMapping(method=RequestMethod.POST)
	public String saveEmployee(final Model model, final Employee employee){
		System.out.println("eno:"+employee.getEno());
		System.out.println("name:"+employee.getName());
		System.out.println("salary:"+employee.getSalary());
		model.addAttribute("employee", employee);
		
		return "display";
	}

}
