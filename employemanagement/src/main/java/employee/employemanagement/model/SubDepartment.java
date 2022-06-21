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
@Table(name="subdepartment")
public class SubDepartment {
	
    @Id
	@Column(name="sub_department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

 
	private int sub_department_id;  
	private String sub_department_name;


    @ManyToOne
    @JoinColumn(name="department_id", nullable=false)
    private Department department;


	
	public SubDepartment() {
	
	} 
	
	public SubDepartment(int sub_department_id){
		super();
		this.sub_department_id = sub_department_id;
	}
	
	public SubDepartment(int sub_department_id,  String sub_department_name) {
		super();
		this.sub_department_id = sub_department_id;
		this.sub_department_name = sub_department_name;
	}
	

	public int get_sub_department_id() {
		return sub_department_id;
	}

	public void set_sub_department_id(int sub_department_id) {
		this.sub_department_id = sub_department_id;
	}


	public String getDepartment_Name() {
		return sub_department_name;
	}

	public void set_sub_department_name(String sub_department_name) {
		this.sub_department_name = sub_department_name;
	}

    /**
     * @return int return the sub_department_id
     */
    public int getSub_department_id() {
        return sub_department_id;
    }

    /**
     * @param sub_department_id the sub_department_id to set
     */
    public void setSub_department_id(int sub_department_id) {
        this.sub_department_id = sub_department_id;
    }

    /**
     * @return String return the sub_department_name
     */
    public String getSub_department_name() {
        return sub_department_name;
    }

    /**
     * @param sub_department_name the sub_department_name to set
     */
    public void setSub_department_name(String sub_department_name) {
        this.sub_department_name = sub_department_name;
    }

 




    /**
     * @param department the department to set
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

}
