package com.learntrack.service;

import com.learntrack.model.Course;
import com.learntrack.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static com.learntrack.util.IdGenerator.*;

public class CourseService {
    public void CourseMenu(Scanner sc){
        try {
            Boolean isStudentSystem = true;
            ArrayList<Course> courseList = getCourseList();
            System.out.println("\n--- Welcome to LearnTrack's Course Management System ---");

            while (isStudentSystem){
                System.out.println("--- Course Management Menu ---");
                System.out.println("1. Add new course");
                System.out.println("2. View all courses");
                System.out.println("3. Activate/Deactivate a course");
                System.out.println("5. Back");
                System.out.print("Please select an option: ");
                int courseManagementChoice = sc.nextInt();
                switch (courseManagementChoice){
                    case 1:
                        Course course = addNewCourse(sc);
                        System.out.println("Student Created with Student ID: "+course.getId());
                        courseList.add(course);
                        break;
                    case 2:
                        viewAllCourses(courseList);
                        break;
                    case 3:
                        System.out.println("Deactivate Student");
                        System.out.print("Enter Student ID: ");
                        int courseId = sc.nextInt();
                        DeactivateStudent(courseList, courseId);
                        break;
                    case 5:
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

    public Course addNewCourse(Scanner sc){
        try {
            System.out.println("Please Provide Course information");
            System.out.print("Enter course name :");
            String courseName = sc.next();
            sc.nextLine();
            System.out.print("Enter course description :");
            String courseDescription = sc.nextLine();
            System.out.print("Enter course durationInWeeks :");
            int courseDuration = sc.nextInt();
            System.out.print("Enter if course is active (true/false):");
            boolean iscourseActive = sc.nextBoolean();
            Course course = new Course(getNextCourseId(), courseName, courseDescription, courseDuration, iscourseActive);
            return course;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewAllCourses(ArrayList<Course> courseList){
        try {
            System.out.println("Here is the list of students enrolled in LearnTrack's System");
            for(int i=0; i < courseList.size(); i++){
                System.out.println(courseList.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void DeactivateStudent(ArrayList<Course> courseList, int courseId){
        try {
            for(Course course : courseList) {
                if (course.getId() == courseId) {
                    course.setActive(false);
                    System.out.print("Course ID: "+ course.getId()+ " Name: "+course.getCourseName() +" Description "+ course.getDescription()  + " has been Deactivated");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
