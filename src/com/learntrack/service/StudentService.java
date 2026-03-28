package com.learntrack.service;

import com.learntrack.exception.EntityNotFoundException;
import com.learntrack.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

import static com.learntrack.util.IdGenerator.getNextStudentId;
import static com.learntrack.util.IdGenerator.getStudentList;

public class StudentService {
    public void studentMenu(Scanner sc){
        try {
            Boolean isStudentSystem = true;
            ArrayList<Student> studentList = getStudentList();
            System.out.println("\n--- Welcome to LearnTrack's Student System ---");

            while (isStudentSystem){
                System.out.println("--- Student Menu ---");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student by ID");
                System.out.println("4. Deactivate Student");
                System.out.println("5. Back");
                int studentSystemChoice = readInt(sc, "Please select an option: ");
                try {
                    switch (studentSystemChoice){
                        case 1:
                            Student newStudent = addNewStudent(sc);
                            System.out.println("Student Created with Student ID: "+newStudent.getId());
                            studentList.add(newStudent);
                            break;
                        case 2:
                            viewAllStudents(studentList);
                            break;
                        case 3:
                            Student searchedStudent = searchStudentByID(studentList, sc);
                            System.out.println("Here is the Student Details: " + searchedStudent);
                            break;
                        case 4:
                            DeactivateStudent(studentList, sc);
                            break;
                        case 5:
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

    public Student addNewStudent(Scanner sc){
        try {
            System.out.println("Please Provide Student information");
            System.out.print("Enter Student's First Name :");
            String studentFirstName = sc.next();
            System.out.print("Enter Student's Last Name :");
            String studentLastName = sc.next();
            System.out.print("Enter Student's Batch :");
            String studentBatch = sc.next();
            boolean isEmailPresent = readBoolean(sc, "Does Student have email (true/false):");
            Student student;
            if(isEmailPresent){
                System.out.print("Enter Student's email :");
                String studentEmail = sc.next();
                student = new Student(getNextStudentId(), studentFirstName, studentLastName, studentEmail, studentBatch, true);
            }else {
                student = new Student(getNextStudentId(), studentFirstName, studentLastName, studentBatch, true);
            }
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void viewAllStudents(ArrayList<Student> studentList){
        try {
            System.out.println("Here is the list of students enrolled in LearnTrack's System");
            for(int i=0; i < studentList.size(); i++){
                System.out.println(studentList.get(i));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Student searchStudentByID(ArrayList<Student> studentList, Scanner sc){
        try {
            int studentId = readInt(sc, "Enter Student ID: ");
            return findStudentById(studentList, studentId);
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void DeactivateStudent(ArrayList<Student> studentList, Scanner sc){
        try {
            System.out.println("Deactivate Student");
            int studentId = readInt(sc, "Enter Student ID: ");
            Student searchedStudent = findStudentById(studentList, studentId);
            searchedStudent.setActive(false);
            System.out.print("Student ID: "+ searchedStudent.getId()+ " Name: "+searchedStudent.getFirstName() +" "+ searchedStudent.getLastName()  + " has been Deactivated");
        } catch (EntityNotFoundException exception) {
            throw exception;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Student findStudentById(ArrayList<Student> studentList, int studentId) {
        for(Student searchedStudent : studentList) {
            if (searchedStudent.getId() == studentId) {
                return searchedStudent;
            }
        }
        throw new EntityNotFoundException("Student with ID " + studentId + " was not found.");
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
