package com.learntrack.model;

import com.learntrack.model.Person;

public class Trainer extends Person {
    private String batch;
    String studentId;
    String courseId;
    String enrollmentId;

    public Trainer(int id, String firstName, String lastName, String email) {
        super(id, firstName, lastName, email);
    }
}