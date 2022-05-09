package entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class TeacherEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teachID;
	private String salary;
	private String TeacherName;
	
//	@ManyToOne
//	@JoinColumn(name="foreignkey_dept")
//	private DepartmentEntity department;
	
	public TeacherEntity() {
		
	}

//	public TeacherEntity(int teachID, String salary, String teacherName, DepartmentEntity department) {
//		super();
//		this.teachID = teachID;
//		this.salary = salary;
//		TeacherName = teacherName;
//		this.department = department;
//	}
	
	@ManyToMany(targetEntity = CohortEntity.class)
	private Set CohortSet;
	
	public TeacherEntity(int teachID, String salary, String teacherName, Set cohort) {
		super();
		this.teachID = teachID;
		this.salary = salary;
		TeacherName = teacherName;
		this.CohortSet = cohort;
	}

	public int getTeachID() {
		return teachID;
	}

	public void setTeachID(int teachID) {
		this.teachID = teachID;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getTeacherName() {
		return TeacherName;
	}

	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}

	public Set getCohortSet() {
		return CohortSet;
	}

	public void setCohortSet(Set cohortSet) {
		CohortSet = cohortSet;
	}
	
	

//	public DepartmentEntity getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(DepartmentEntity department) {
//		this.department = department;
//	}
	
	

}
