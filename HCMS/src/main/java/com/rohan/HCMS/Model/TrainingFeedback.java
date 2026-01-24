package com.rohan.HCMS.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "training_feedback")
public class TrainingFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "feedback_id")
    private int feedbackId;

    @ManyToOne
    @JoinColumn(name = "training_id", referencedColumnName = "training_id")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "participant_id", referencedColumnName = "emp_id")
    private Employees participant;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private double rating;

    // Default constructor
    public TrainingFeedback() {
    }

    // Parameterized constructor
    public TrainingFeedback(Training training, Employees participant, String feedback, double rating) {
        this.training = training;
        this.participant = participant;
        this.feedback = feedback;
        this.rating = rating;
    }

    // Getters and Setters
    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Employees getParticipant() {
        return participant;
    }

    public void setParticipant(Employees participant) {
        this.participant = participant;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
