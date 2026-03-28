# Design Notes

## Why I Used ArrayList Instead of Array

I used ArrayList because the number of students, courses, and enrollments can grow while the program is running. A normal array needs a fixed size in advance, but ArrayList can grow dynamically as new data is added.

ArrayList also makes this project easier to manage because adding, searching, and looping through records is simpler and cleaner in a menu-driven application.

## Where I Used Static Members and Why

Static members are used in IdGenerator.java for:

- student ID counter
- course ID counter
- shared student list
- shared course list
- shared enrollment list

I used static members to ensure that certain data is shared consistently across the entire application. This allows all parts of the system to work with the same instance of data rather than creating separate copies.

Specifically:

The ID generators are static so that a single, continuous sequence of IDs is maintained throughout the program.
The student, course, and enrollment lists are also static to act as shared in-memory data stores.

This design ensures that:

Data remains consistent across different modules.
All operations (add, view, update) reflect on the same dataset.
The data persists in memory for the entire lifecycle of the LearnTrack Management System, until the user exits the application.

## Where I Used Inheritance and What I Gained From It

Inheritance is used through Person as the base class, with Student and Trainer extending it.

This reduced repeated code because common fields like id, firstName, lastName, and email are defined once in Person and reused in child classes. It also helped demonstrate simple polymorphism through the overridden getDisplayName() method.
