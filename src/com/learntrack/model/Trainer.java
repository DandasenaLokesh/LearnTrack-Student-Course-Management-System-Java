package com.learntrack.model;

import com.learntrack.model.Person;

public class Trainer extends Person {
    private String batch;
    private String studentId;
    private String courseId;
    private String enrollmentId;

    public Trainer(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }

    @Override
    public String getDisplayName() {
        return "Trainer: " + getFirstName() + " " + getLastName();
    }
}
