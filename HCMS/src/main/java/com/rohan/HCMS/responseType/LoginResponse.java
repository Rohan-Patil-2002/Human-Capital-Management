package com.rohan.HCMS.responseType;

import com.rohan.HCMS.Model.Employees;

public class LoginResponse {
    private String message;
    private Employees employee;

    public LoginResponse(String message, Employees employee) {
        this.message = message;
        this.employee = employee;
    }

    // Getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Employees getEmployee() {
        return employee;
    }

    public void setEmployee(Employees employee) {
        this.employee = employee;
    }
}

