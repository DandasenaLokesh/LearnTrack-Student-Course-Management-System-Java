package com.learntrack.main;

import com.learntrack.service.CourseService;
import com.learntrack.service.EnrollmentService;
import com.learntrack.service.StudentService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLearnTrackSystemActive = true;
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();
        System.out.println("Welcome to LearnTrack System");
        while(isLearnTrackSystemActive){
            System.out.println("\n===== LearnTrack Management System =====");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            int isLearnTrackSystemChoice = readInt(sc, "Please select an option: ");
            switch (isLearnTrackSystemChoice){
                case 1:
                    studentService.studentMenu(sc);
                    break;
                case 2:
                    courseService.courseMenu(sc);
                    break;
                case 3:
                    enrollmentService.enrollmentMenu(sc);
                    break;
                case 4:
                    isLearnTrackSystemActive = false;
                    System.out.println("Exiting LearnTrack Management System");
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
        sc.close();
    }

    private static int readInt(Scanner sc, String message) {
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
