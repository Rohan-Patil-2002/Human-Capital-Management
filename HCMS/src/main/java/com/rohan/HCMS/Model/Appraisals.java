package com.rohan.HCMS.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appraisals")
public class Appraisals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appraisal_id")
    private int appraisalId;

    @ManyToOne
    @JoinColumn(name = "emp_id", referencedColumnName = "emp_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", referencedColumnName = "emp_id")
    private Employees reviewer;

    @Column(name = "form_data")
    private String formData;

    @Column(name = "status")
    private String status;

    @Column(name = "submitted_at")
    private LocalDateTime submittedAt;

    @Column(name = "reviewed_at")
    private LocalDateTime reviewedAt;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "rating")
    private double rating;

    // Default constructor
    public Appraisals() {
    }

    // Parameterized constructor
    public Appraisals(Employees employee, Employees reviewer, String formData, String status, LocalDateTime submittedAt, LocalDateTime reviewedAt, String remarks, double rating) {
        this.employee = employee;
        this.reviewer = reviewer;
        this.formData = formData;
        this.status = status;
        this.submittedAt = submittedAt;
        this.reviewedAt = reviewedAt;
        this.remarks = remarks;
        this.rating = rating;
    }

    // Getters and Setters
    public int getAppraisalId() {
        return appraisalId;
    }

    public void setAppraisalId(int appraisalId) {
        this.appraisalId = appraisalId;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }

    public Employees getReviewer() {
        return reviewer;
    }

    public void setReviewer(Employees reviewer) {
        this.reviewer = reviewer;
    }

    public String getFormData() {
        return formData;
    }

    public void setFormData(String formData) {
        this.formData = formData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }

    public LocalDateTime getReviewedAt() {
        return reviewedAt;
    }

    public void setReviewedAt(LocalDateTime reviewedAt) {
        this.reviewedAt = reviewedAt;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
