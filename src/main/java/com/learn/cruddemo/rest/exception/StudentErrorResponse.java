package com.learn.cruddemo.rest.exception;

/**
 * Error response to be generated on time of an exception
 */
public class StudentErrorResponse {
    private int status;
    private String message;

    private double timestamp;

    public StudentErrorResponse() {

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(double timestamp) {
        this.timestamp = timestamp;
    }
}
