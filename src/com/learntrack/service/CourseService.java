package com.learntrack.service;

import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.model.Course;

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
                System.out.println("4. Back");
                int courseManagementChoice = readInt(sc, "Please select an option: ");
                try {
                    switch (courseManagementChoice){
                        case 1:
                            Course course = addNewCourse(sc);
                            System.out.println("Course Created with Course ID: "+course.getId());
                            courseList.add(course);
                            break;
                        case 2:
                            viewAllCourses(courseList);
                            break;
                        case 3:
                            updateCourseStatus(courseList, sc);
                            break;
                        case 4:
                            isStudentSystem = false;
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

    public Course addNewCourse(Scanner sc){
        try {
            System.out.println("Please Provide Course information");
            System.out.print("Enter course name :");
            String courseName = sc.next();
            sc.nextLine();
            System.out.print("Enter course description :");
            String courseDescription = sc.nextLine();
            int courseDuration = readInt(sc, "Enter course durationInWeeks :");
            boolean iscourseActive = readBoolean(sc, "Enter if course is active (true/false):");
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


    public void updateCourseStatus(ArrayList<Course> courseList, Scanner sc){
        try {
            int courseId = readInt(sc, "Enter Course ID: ");
            Course course = findCourseById(courseList, courseId);
            System.out.println("1. Activate Course");
            System.out.println("2. Deactivate Course");
            int courseStatusChoice = readInt(sc, "Please select an option: ");
            if (courseStatusChoice == 1) {
                course.setActive(true);
                System.out.print("Course ID: "+ course.getId()+ " Name: "+course.getCourseName() +" has been Activated");
            } else if (courseStatusChoice == 2) {
                course.setActive(false);
                System.out.print("Course ID: "+ course.getId()+ " Name: "+course.getCourseName() +" has been Deactivated");
            } else {
                System.out.println("Invalid Choice");
            }
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Course findCourseById(ArrayList<Course> courseList, int courseId) {
        for(Course course : courseList) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        throw new EntityNotFoundException("Course with ID " + courseId + " was not found.");
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

    private boolean readBoolean(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.next().trim().toLowerCase();
            if ("true".equals(value)) {
                return true;
            }
            if ("false".equals(value)) {
                return false;
            }
            System.out.println("Invalid input. Please enter true or false.");
        }
    }
}
