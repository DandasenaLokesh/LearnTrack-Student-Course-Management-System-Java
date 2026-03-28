package com.airtribe.learntrack.util;

import com.airtribe.learntrack.model.Course;
import com.airtribe.learntrack.model.Enrollment;
import com.airtribe.learntrack.model.Student;

import java.util.ArrayList;

public class IdGenerator {
    private static int studentIdCounter = 1;
    private static int courseIdCounter = 1001;
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static ArrayList<Course> courseList = new ArrayList<>();
    private static ArrayList<Enrollment> enrollmentList = new ArrayList<>();

    public static int getNextStudentId() {
        return studentIdCounter++;
    }

    public static int getNextCourseId() {
        return courseIdCounter++;
    }

    public static int getStudentIdCounter() {
        return studentIdCounter;
    }

    public static int getCourseIdCounter() {
        return courseIdCounter;
    }

    public static ArrayList<Student> getStudentList() {
        return studentList;
    }

    public static void setStudentList(ArrayList<Student> studentList) {
        IdGenerator.studentList = studentList;
    }

    public static ArrayList<Course> getCourseList() {
        return courseList;
    }

    public static void setCourseList(ArrayList<Course> courseList) {
        IdGenerator.courseList = courseList;
    }

    public static ArrayList<Enrollment> getEnrollmentList() {
        return enrollmentList;
    }

    public static void setEnrollmentList(ArrayList<Enrollment> enrollmentList) {
        IdGenerator.enrollmentList = enrollmentList;
    }
}
