package jpa.entitymodels;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Student")
public class Student {
	@Id
	@Column(name = "student_email")
	private String sEmail;
	
	@Column(name = "student_name")
	private String sName;
	
	@Column(name = "student_password")
	private String sPass;
	
	@ManyToMany(targetEntity=Course.class, cascade = {CascadeType.ALL})
	private List<Course> sCourse;

	public Student() {

	}

	public Student(String sEmail, String sName, String sPass, List sCourse) {

		this.sEmail = sEmail;
		this.sName = sName;
		this.sPass = sPass;
		this.sCourse = sCourse;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPass() {
		return sPass;
	}

	public void setsPass(String sPass) {
		this.sPass = sPass;
	}

	public List<Course> getsCourse() {
		return sCourse;
	}

	public void setsCourse(List<Course> sCourse) {
		this.sCourse = sCourse;
	}

	@Override
	public String toString() {
		return "Student [sEmail=" + sEmail + ", sName=" + sName + ", sPass=" + sPass + ", sCourse=" + sCourse + "]";
	}
	
	

	
}
