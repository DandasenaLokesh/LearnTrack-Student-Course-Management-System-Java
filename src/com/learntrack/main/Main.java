package com.learntrack.main;

import com.learntrack.model.Course;
import com.learntrack.service.CourseService;
import com.learntrack.service.EnrollmentService;
import com.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean islearnTrackSystemActive = true;
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();
        System.out.println("Welcome to LearnTrack System");
        while(islearnTrackSystemActive){
            System.out.println("\n===== LearnTrack Management System =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");
            int isLearnTrackSystemChoice = sc.nextInt();
            switch (isLearnTrackSystemChoice){
                case 1:
                    studentService.studentMenu(sc);
                    break;
                case 2:
                    courseService.CourseMenu(sc);
                    break;
                case 3:
                    enrollmentService.EnrollmentMenu(sc);
                    break;
                case 4:
                    islearnTrackSystemActive = false;
                    System.out.println("Exiting LearnTrack Management System");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }
}
