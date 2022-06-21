package employee.employemanagement.repository;
import org.springframework.data.repository.CrudRepository;

import employee.employemanagement.model.SubDepartment;

public interface SubDeptRepo extends CrudRepository<SubDepartment, Integer>{
    
}
