package com.learntrack.service;

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
                System.out.print("Please select an option: ");
                int studentSystemChoice = sc.nextInt();
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
            System.out.print("Does Student have email (true/false):");
            boolean isEmailPresent = sc.nextBoolean();
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
            System.out.print("Enter Student ID: ");
            Student student = new Student();
            int studentId = sc.nextInt();
//        for(int i=0; i < studentList.size(); i++){ // replaced this with Advanced For Statement
//            Student searchedStudent = studentList.get(i);
//            if(searchedStudent.getId() == studentId){
//                System.out.println(studentList.get(i));
//            }
//        }

//         replaced above with Advanced For Statement
            for(Student searchedStudent : studentList) {
                if (searchedStudent.getId() == studentId) {
                    student = searchedStudent;
                }
            }
            return student;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void DeactivateStudent(ArrayList<Student> studentList, Scanner sc){
        try {
            System.out.println("Deactivate Student");
            System.out.print("Enter Student ID: ");
            int studentId = sc.nextInt();
            for(Student searchedStudent : studentList) {
                if (searchedStudent.getId() == studentId) {
                    searchedStudent.setActive(false);
                    System.out.print("Student ID: "+ searchedStudent.getId()+ " Name: "+searchedStudent.getFirstName() +" "+ searchedStudent.getLastName()  + " has been Deactivated");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
