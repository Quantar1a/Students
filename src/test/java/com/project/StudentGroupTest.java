package com.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class StudentGroupTest {
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;

    private StudentsGroup studentGroup;

    @BeforeEach
    public void setUp() {
        student1 = new Student("Luis");
        student1.addGrade("History", 4);
        student1.addGrade("History", 5);
        student1.addGrade("Biology", 3);

        student2 = new Student("Emma");
        student2.addGrade("History", 3);
        student2.addGrade("Biology", 4);
        student2.addGrade("Biology", 5);

        student3 = new Student("Henry");

        student4 = new Student("Albert");
        student4.addGrade("Chemistry", 5);


        List<Student> students = Arrays.asList(student1, student2);
        studentGroup = new StudentsGroup(students);
    }

    @Test
    public void testCalculateSubjectAverage() {
        assertEquals(4.0, studentGroup.calculateAvgLesson("History"));
        assertEquals(4.0, studentGroup.calculateAvgLesson("Biology"));
    }

    @Test
    public void testCalculateStudentAverage() {
        assertEquals(4.0, studentGroup.calculateAvgStudent(student1));
        assertEquals(4.0, studentGroup.calculateAvgStudent(student2));
    }

    @Test
    public void testCalculateGroupAverage() {
        assertEquals(4.0, studentGroup.calculateAvgGroup());
    }

    @Test
    public void studentDoesNotHaveGradeTest()
    {
        assertEquals(0.0, studentGroup.calculateAvgStudent(student3));
    }

    @Test
    public void studentWithOnlyOneGradeTest()
    {
        assertEquals(5.0, studentGroup.calculateAvgStudent(student4));
    }


    @Test
    public void checkWhenGradesHigherThanFive()
    {
        Student student6 = new Student("Marry");
        assertThrows(IllegalArgumentException.class, () -> {
            student6.addGrade("Math", 6);
        });
    }

    @Test
    public void checkWhenGradesLowerThanOne()
    {
        Student student5 = new Student("Steve");
        assertThrows(IllegalArgumentException.class, () -> {
            student5.addGrade("Math", 0);
        });
    }
}

