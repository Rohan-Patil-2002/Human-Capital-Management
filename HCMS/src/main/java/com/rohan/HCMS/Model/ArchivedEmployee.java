package com.rohan.HCMS.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "archivedEmployee")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "department", "skills"})
public class ArchivedEmployee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ae_id")
    private int aeId;

    @Column(name = "ae_name")
    private String aeName;

    @Column(name = "ae_pass")
    private String aePass;

    @Column(name = "ae_email")
    private String aeEmail;

    @Column(name = "ae_phone_no")
    private String aePhoneNo;

    @Column(name = "ae_salary")
    private double aeSalary;

    @Column(name = "ae_gender")
    private String aeGender;

    @Column(name = "ae_age")
    private int aeAge;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", referencedColumnName = "dept_id")
    private Department department;
    
    @OneToMany(mappedBy = "archivedEmployee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Skill> skills;

	public ArchivedEmployee() {
	}

	public ArchivedEmployee(int aeId, String aeName, String aePass, String aeEmail, String aePhoneNo, double aeSalary,
			String aeGender, int aeAge, Department department, List<Skill> skills) {
		this.aeId = aeId;
		this.aeName = aeName;
		this.aePass = aePass;
		this.aeEmail = aeEmail;
		this.aePhoneNo = aePhoneNo;
		this.aeSalary = aeSalary;
		this.aeGender = aeGender;
		this.aeAge = aeAge;
		this.department = department;
		this.skills = skills;
	}

	public int getAeId() {
		return aeId;
	}

	public void setAeId(int aeId) {
		this.aeId = aeId;
	}

	public String getAeName() {
		return aeName;
	}

	public void setAeName(String aeName) {
		this.aeName = aeName;
	}

	public String getAePass() {
		return aePass;
	}

	public void setAePass(String aePass) {
		this.aePass = aePass;
	}

	public String getAeEmail() {
		return aeEmail;
	}

	public void setAeEmail(String aeEmail) {
		this.aeEmail = aeEmail;
	}

	public String getAePhoneNo() {
		return aePhoneNo;
	}

	public void setAePhoneNo(String aePhoneNo) {
		this.aePhoneNo = aePhoneNo;
	}

	public double getAeSalary() {
		return aeSalary;
	}

	public void setAeSalary(double aeSalary) {
		this.aeSalary = aeSalary;
	}

	public String getAeGender() {
		return aeGender;
	}

	public void setAeGender(String aeGender) {
		this.aeGender = aeGender;
	}

	public int getAeAge() {
		return aeAge;
	}

	public void setAeAge(int aeAge) {
		this.aeAge = aeAge;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "ArchivedEmployee [aeId=" + aeId + ", aeName=" + aeName + ", aePass=" + aePass + ", aeEmail=" + aeEmail
				+ ", aePhoneNo=" + aePhoneNo + ", aeSalary=" + aeSalary + ", aeGender=" + aeGender + ", aeAge=" + aeAge
				+ ", department=" + department + ", skills=" + skills + "]";
	}
}
