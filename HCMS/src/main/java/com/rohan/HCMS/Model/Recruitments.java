package com.rohan.HCMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruitments")
public class Recruitments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recruitment_id")
    private int recruitmentId;

    @Column(name = "department")
    private String department;

    @Column(name = "required_skills")
    private String requiredSkills;

    @Column(name = "vacancy_count")
    private int vacancyCount;

    @Column(name = "job_title")
    private String jobTitle;

    // Default constructor
    public Recruitments() {
    }

    // Parameterized constructor
    public Recruitments(String department, String requiredSkills, int vacancyCount, String jobTitle) {
        this.department = department;
        this.requiredSkills = requiredSkills;
        this.vacancyCount = vacancyCount;
        this.jobTitle = jobTitle;
    }

    // Getters and Setters
    public int getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(int recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRequiredSkills() {
        return requiredSkills;
    }

    public void setRequiredSkills(String requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    public int getVacancyCount() {
        return vacancyCount;
    }

    public void setVacancyCount(int vacancyCount) {
        this.vacancyCount = vacancyCount;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
