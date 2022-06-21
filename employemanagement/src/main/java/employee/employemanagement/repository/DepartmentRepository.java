package employee.employemanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import employee.employemanagement.model.Department;
 
public interface DepartmentRepository extends CrudRepository<Department, Integer>{
    @Query("SELECT department_ID FROM Department department")
    List<String> findDepartments();
    
}
