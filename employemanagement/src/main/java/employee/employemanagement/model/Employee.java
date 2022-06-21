package employee.employemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeID;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "emp_sub_department")
	private String emp_sub_department;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String emp_sub_department, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.emp_sub_department = emp_sub_department;
	}

	public Department findDepartments(int id) {
		return department;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return String.format("Employee [employeeID = %d, firstName = %s, lastName = %s, department_ID= %d", employeeID,
				firstName, lastName, department.getDepartment_ID());
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}


    /**
     * @return String return the emp_sub_department
     */
    public String getEmp_sub_department() {
        return emp_sub_department;
    }

    /**
     * @param emp_sub_department the emp_sub_department to set
     */
    public void setEmp_sub_department(String emp_sub_department) {
        this.emp_sub_department = emp_sub_department;
    }

}
