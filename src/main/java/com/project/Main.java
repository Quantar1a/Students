package com.project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        //Create students
        Student Alice = new Student("Alice");
        Student John = new Student("John");
        Student Kate = new Student("Kate");

        //Add grades to the Students
        Alice.addGrade("Math", 4);
        Alice.addGrade("Math", 5);
        Alice.addGrade("Math", 3);
        Alice.addGrade("English", 4);

        John.addGrade("Math", 5);
        John.addGrade("Math", 4);

        Kate.addGrade("Math", 5);
        Kate.addGrade("English", 5);

        //Create a list of students and add students to the list
        List<Student> students = new ArrayList<>();
        students.add(Alice);
        students.add(John);
        students.add(Kate);


        StudentsGroup studentsGroup = new StudentsGroup(students);

        //Calculate and print the average lesson grade for a specific lesson
        System.out.println("Average lesson grade: " + studentsGroup.calculateAvgLesson("Math"));

        //Calculate and print the average student grade for a specific student
        System.out.println("Average student grade: " + studentsGroup.calculateAvgStudent(Alice));

        //Calculate and print the average group grade
        System.out.println("Average group grade: " + studentsGroup.calculateAvgGroup());
    }
}
