package com.project;

import com.project.Interfaces.AverageGrade;
import com.project.Interfaces.AverageGroupGrade;

import java.util.List;
import java.util.Map;

public class StudentsGroup implements AverageGrade, AverageGroupGrade
{
    private List<Student> students;
    public StudentsGroup(List<Student> students)
    {
        this.students = students;
    }

    @Override
    public double calculateAvgLesson(String lesson)
    {
        double total = 0;
        int count = 0;

        for (Student student : students)
        {
            List<Integer> grades = student.getGrades(lesson);
            for (int grade : grades)
            {
                total += grade; count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    @Override
    public double calculateAvgStudent(Student student)
    {
        double total = 0;
        int count = 0;
        for (Map.Entry<String, List<Integer>> entry : student.getAllGrades().entrySet())
        {
            for (int grade : entry.getValue())
            {
                total += grade; count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    @Override
    public double calculateAvgGroup()
    {
        double total = 0;
        int count = 0;
        for (Student student : students)
        {
            total += calculateAvgStudent(student);
            count++;
        }
        return count == 0 ? 0 : total / count;
    }
}
