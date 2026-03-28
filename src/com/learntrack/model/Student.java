package com.learntrack.model;

public class Student extends Person{
    private String batch;
    private boolean active;

    public Student(int id, String firstName, String lastName, String email, String batch, Boolean active) {
        super(id, firstName, lastName, email);
        this.batch = batch;
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String batch, boolean active) {
        super(id, firstName, lastName);
        this.batch = batch;
        this.active = active;
    }

    public Student() {
        super();
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Student(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", Name='" + getFirstName() + " "+ getLastName()+ '\'' +
                ", email='" + getEmail() + '\'' +
                ", batch='" + batch + '\'' +
                ", active=" + active +
                '}';
    }
}