package employee.employemanagement.repository;




import org.springframework.data.repository.CrudRepository;

import employee.employemanagement.model.Employee;

// interface extending crud repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{




    

}
