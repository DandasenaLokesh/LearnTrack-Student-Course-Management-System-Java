package com.learntrack.service;

import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.model.Course;
import com.learntrack.model.Enrollment;
import com.learntrack.model.Student;
import com.learntrack.util.Status;

import java.util.ArrayList;
import java.util.Scanner;

import static com.learntrack.util.IdGenerator.getCourseList;
import static com.learntrack.util.IdGenerator.getEnrollmentList;
import static com.learntrack.util.IdGenerator.getStudentList;

public class EnrollmentService {
    public void enrollmentMenu(Scanner sc){
        try {
            Boolean isEnrollmentSystemActive = true;
            ArrayList<Enrollment> enrollmentList = getEnrollmentList();
            System.out.println("\n--- Welcome to LearnTrack's Enrollment System ---");

            while (isEnrollmentSystemActive){
                System.out.println("--- Enrollment Menu ---");
                System.out.println("1. Enroll a student in a course");
                System.out.println("2. View enrollments for a student");
                System.out.println("3. Mark enrollment as completed/cancelled");
                System.out.println("4. Back");
                int studentSystemChoice = readInt(sc, "Please select an option: ");
                try {
                    switch (studentSystemChoice){
                        case 1:
                            enrollStudent(sc, enrollmentList);
                            break;
                        case 2:
                            viewEnrollmentsForStudent(sc, enrollmentList);
                            break;
                        case 3:
                            markEnrollment(sc, enrollmentList);
                            break;
                        case 4:
                            isEnrollmentSystemActive = false;
                            break;
                        default:
                            System.out.println("Invalid Choice");
                    }
                } catch (EntityNotFoundException exception) {
                    System.out.println(exception.getMessage());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enrollStudent(Scanner sc, ArrayList<Enrollment> enrollmentList){
        try {
            int studentId = readInt(sc, "Enter Student's id :");
            int courseId = readInt(sc, "Enter Course id where student want to enroll :");
            Student student = findStudentById(studentId);
            Course course = findCourseById(courseId);

            if (!student.getActive()) {
                System.out.println("Student " + studentId + " is inactive.");
                return;
            }

            if (!course.getActive()) {
                System.out.println("Course " + courseId + " is inactive.");
                return;
            }

            for(Enrollment enrollment:enrollmentList){
                if((studentId == enrollment.getStudentId()) && (courseId == enrollment.getCourseId())){
                    System.out.println("Student "+studentId+" is Already Enrolled in the course "+courseId);
                    return;
                }
            }
            Enrollment enrollment = new Enrollment(courseId+"_"+studentId, studentId, courseId);
            enrollmentList.add(enrollment);
            System.out.println("Student "+studentId+" had Enrolled with the course "+courseId+" Successfully");
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewEnrollmentsForStudent(Scanner sc, ArrayList<Enrollment> enrollmentList){
        try {
            int studentId = readInt(sc, "Enter Student ID: ");
            findStudentById(studentId);
            boolean hasEnrollment = false;
            for(int i=0; i < enrollmentList.size(); i++){
                if (enrollmentList.get(i).getStudentId() == studentId) {
                    System.out.println(enrollmentList.get(i));
                    hasEnrollment = true;
                }
            }
            if (!hasEnrollment) {
                System.out.println("No enrollments found for Student ID: " + studentId);
            }
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void markEnrollment(Scanner sc, ArrayList<Enrollment> enrollmentList){
        try {
            System.out.println("Mark enrollment as completed/cancelled");
            int studentId = readInt(sc, "Enter Student ID: ");
            findStudentById(studentId);
            System.out.println("Here is the List of cources Studen is Enrolled");
            boolean hasEnrollment = false;
            for(Enrollment enrollment : enrollmentList) {
                if (enrollment.getStudentId() == studentId) {
                    System.out.println(enrollment.getCourseId());
                    hasEnrollment = true;
                }
            }
            if (!hasEnrollment) {
                System.out.println("No enrollments found for Student ID: " + studentId);
                return;
            }
            int courseId = readInt(sc, "enter the Course Id: ");
            Enrollment enrollment = findEnrollment(enrollmentList, studentId, courseId);
            System.out.println("Enter Enrollment status completed/cancelled");
            System.out.println("1. completed");
            System.out.println("2. cancelled");
            int updatedStatus = readInt(sc, "Please select an option: ");
            if(updatedStatus == 1 ){
                enrollment.setStatus(Status.COMPLETED);
                System.out.println("Enrollment marked as COMPLETED.");
            } else if (updatedStatus == 2) {
                enrollment.setStatus(Status.CANCELLED);
                System.out.println("Enrollment marked as CANCELLED.");
            } else {
                System.out.println("Invalid Choice");
            }
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Student findStudentById(int studentId) {
        ArrayList<Student> studentList = getStudentList();
        for (Student student : studentList) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        throw new EntityNotFoundException("Student with ID " + studentId + " was not found.");
    }

    private Course findCourseById(int courseId) {
        ArrayList<Course> courseList = getCourseList();
        for (Course course : courseList) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with ID " + courseId + " was not found.");
    }

    private Enrollment findEnrollment(ArrayList<Enrollment> enrollmentList, int studentId, int courseId) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getStudentId() == studentId && enrollment.getCourseId() == courseId) {
                return enrollment;
            }
        }
        throw new EntityNotFoundException("Enrollment not found for Student ID " + studentId + " and Course ID " + courseId);
    }

    private int readInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.next());
            } catch (NumberFormatException exception) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
