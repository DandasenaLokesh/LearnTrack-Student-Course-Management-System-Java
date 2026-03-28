package com.learntrack.service;

import com.learntrack.model.Enrollment;
import com.learntrack.model.Student;
import com.learntrack.util.Status;

import java.util.ArrayList;
import java.util.Scanner;

import static com.learntrack.util.IdGenerator.getEnrollmentList;
import static com.learntrack.util.IdGenerator.getNextStudentId;

public class EnrollmentService {
    public void EnrollmentMenu(Scanner sc){
        try {
            Boolean isStudentSystem = true;
            ArrayList<Enrollment> enrollmentList = getEnrollmentList();
            System.out.println("\n--- Welcome to LearnTrack's Enrollment System ---");

            while (isStudentSystem){
                System.out.println("--- Enrollment Menu ---");
                System.out.println("1. Enroll a student in a course");
                System.out.println("2. View enrollments for a student");
                System.out.println("3. Mark enrollment as completed/cancelled");
                System.out.println("4. Back");
                System.out.print("Please select an option: ");
                int studentSystemChoice = sc.nextInt();
                switch (studentSystemChoice){
                    case 1:
                        enrollStudent(sc, enrollmentList);
                        break;
                    case 2:
                        viewAllEnrollments(enrollmentList);
                        break;
                    case 3:
                        markEnrollment(sc, enrollmentList);
                        break;
                    case 4:
                        isStudentSystem = false;
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void enrollStudent(Scanner sc, ArrayList<Enrollment> enrollmentList){
        try {
            System.out.print("Enter Student's id :");
            int studentId = sc.nextInt();
            System.out.print("Enter Course id where student want to enroll :");
            int courseId = sc.nextInt();
            boolean isNewEnrollment = false;
            for(Enrollment enrollment:enrollmentList){
                if((studentId == enrollment.getStudentId()) && (courseId == enrollment.getCourseId())){
                    System.out.println("Student "+studentId+" is Already Enrolled in the course "+courseId);
                } else {
                    isNewEnrollment = true;
                }
            }
            Enrollment enrollment = new Enrollment(courseId+"_"+studentId, studentId, courseId);
            enrollmentList.add(enrollment);
            System.out.println("Student "+studentId+" had Enrolled with the course "+courseId+" Successfully");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewAllEnrollments(ArrayList<Enrollment> enrollmentList){
        try {
            System.out.println("Here is the list of students enrolled in LearnTrack's System");
            for(int i=0; i < enrollmentList.size(); i++){
                System.out.println(enrollmentList.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void markEnrollment(Scanner sc, ArrayList<Enrollment> enrollmentList){
        try {
            System.out.println("Mark enrollment as completed/cancelled");
            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            System.out.println("Here is the List of cources Studen is Enrolled");
            for(Enrollment enrollment : enrollmentList) {
                if (enrollment.getStudentId() == studentId) {
                    System.out.println(enrollment.getCourseId());
                }
            }
            System.out.print("enter the Course Id: ");
            int courseId = sc.nextInt();
            System.out.println("Enter Enrollment status completed/cancelled");
            System.out.println("1. completed");
            System.out.println("2. cancelled");
            System.out.print("Please select an option: ");
            int updatedStatus = sc.nextInt();
            for(Enrollment enrollment : enrollmentList) {
                if ((enrollment.getStudentId() == studentId) && (enrollment.getCourseId() == courseId)) {
                    if(updatedStatus == 1 ){
                        enrollment.setStatus(Status.COMPLETED);
                    } else {
                        enrollment.setStatus(Status.CANCELLED);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
