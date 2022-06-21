package employee.employemanagement.model;



import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {

	@Id
	@Column(name="department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int department_ID;  
	private String short_Name;
	private String department_Name;

	

	@OneToMany(mappedBy="department")
    private Set<SubDepartment> subdepartments;



	
	public Department() {
		
	}
	
	public Department(int departmentID){
		super();
		this.department_ID = departmentID;
	}
	
	public Department(int departmentID, String short_Name, String department_Name) {
		super();
		this.department_ID = departmentID;
		this.short_Name = short_Name;
		this.department_Name = department_Name;
		
	}

	// public SubDepartment findSubDepartment(int id) {
	// 	return subdepartment;
	// }




	public int getDepartment_ID() {
		return department_ID;
	}

	public void setDepartment_ID(int department_ID) {
		this.department_ID = department_ID;
	}

	public String getShort_Name() {
		return short_Name;
	}

	public void setShort_Name(String short_Name) {
		this.short_Name = short_Name;
	}

	public String getDepartment_Name() {
		return department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}






    /**
     * @return Set<SubDepartment> return the subdepartments
     */
    public Set<SubDepartment> getSubdepartments() {
        return subdepartments;
    }

    /**
     * @param subdepartments the subdepartments to set
     */
    public void setSubdepartments(Set<SubDepartment> subdepartments) {
        this.subdepartments = subdepartments;
    }

}
