# LearnTrack-Student-Course-Management-System-Java

LearnTrack is a console-based Student, Course, and Enrollment Management System built using Core Java and in-memory `ArrayList` storage.

## Project Structure

```text
.
|-- pom.xml
|-- README.md
`-- src
    `-- com
        `-- learntrack
            |-- exception
            |-- main
            |-- model
            |-- service
            `-- util
```

## Implemented Features

- Student Management
- Add new student
- View all students
- Search student by ID
- Deactivate a student
- Course Management
- Add new course
- View all courses
- Activate or deactivate a course
- Enrollment Management
- Enroll a student in a course
- View enrollments for a student
- Mark enrollment as completed or cancelled
- Custom `EntityNotFoundException`
- Graceful handling for invalid numeric and menu input

## Run in IntelliJ IDEA

1. Open this folder in IntelliJ IDEA.
2. Wait for Maven project import from `pom.xml`.
3. Open `src/com/learntrack/main/Main.java`.
4. Run `com.learntrack.main.Main`.

## Run from Terminal

```bash
mvn -q compile
mvn -q exec:java -Dexec.mainClass=com.learntrack.main.Main
```
