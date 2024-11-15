package com.project;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private Map<String, List<Integer>> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new HashMap<>();
    }

    //Get students name
    public String getName() {
        return name;
    }

    //Add grade to student's grades
    //Grades must be between 1 and 5
    public void addGrade(String lesson, int grade) {
        if (grade < 1 || grade > 5) {
            throw new IllegalArgumentException("Оцінка має бути від 1 до 5.");
        }
        grades.putIfAbsent(lesson, new ArrayList<>());
        grades.get(lesson).add(grade);
    }

    //Get list of grades for a specific lesson
    public List<Integer> getGrades(String subject) {
        return grades.getOrDefault(subject, new ArrayList<>());
    }

    //Get average grade for all subjects
    public Map<String, List<Integer>> getAllGrades() {
        return grades;
    }
}