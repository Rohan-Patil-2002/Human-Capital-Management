package com.rohan.HCMS.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "skill")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "employee", "archivedEmployee"})
public class Skill {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "skill_id")
    private int skillId;

    @Column(name = "skill_name")
    private String skillName;

    @Column(name = "skill_version")
    private String skillVersion;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employees employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ae_id", referencedColumnName = "ae_id")
    private ArchivedEmployee archivedEmployee;

    //Default constructor
	public Skill() {
	}

	//Parameterized constructor
	public Skill(int skillId, String skillName, String skillVersion, Employees employee, ArchivedEmployee archivedEmployee) {
		this.skillId = skillId;
		this.skillName = skillName;
		this.skillVersion = skillVersion;
		this.employee = employee;
		this.archivedEmployee =archivedEmployee;
	}

	//Setters and Getters
	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillVersion() {
		return skillVersion;
	}

	public void setSkillVersion(String skillVersion) {
		this.skillVersion = skillVersion;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}
	
	public ArchivedEmployee getArchivedEmployee() {
		return archivedEmployee;
	}

	public void setArchivedEmployee(ArchivedEmployee archivedEmployee) {
		this.archivedEmployee = archivedEmployee;
	}

	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillVersion=" + skillVersion
				+ ", employee=" + employee + ", archivedEmployee=" + archivedEmployee + "]";
	}
}
