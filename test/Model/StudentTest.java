package Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @org.junit.jupiter.api.Test
    void enrollCourseTest() {
        Course courseA = new Course(1,44, "Math", "Advanced Algebra",3);
        Student studentA = new Student(1,"Bob");
        studentA.enrollCourse(courseA);
        assertEquals(1, studentA.getEnrolledCourses().size());
    }

    @org.junit.jupiter.api.Test
    void setGradeTest1() {
        Course courseA = new Course(1,44, "Math", "Advanced Algebra",3);
        Student studentA = new Student(1,"Bob");
        studentA.enrollCourse(courseA);
        studentA.setGrade(courseA, 90);
        assertEquals(true, studentA.setGrade(courseA, 90));
    }

    @org.junit.jupiter.api.Test
    void setGradeTest2() {
        Course courseB = new Course(1,44, "Science", "Physics",3);
        Student studentB = new Student(1,"Sam");
        studentB.setGrade(courseB, 90);
        assertEquals(false, studentB.setGrade(courseB, 90));
    }

    @org.junit.jupiter.api.Test
    void gpaCalculatorTest() {
        Course courseB = new Course(4,04, "Science", "Physics",3);
        Course courseA = new Course(5,05, "Math", "Advanced Algebra",3);
        Course courseC = new Course(6, 06, "Gym", "Physical Fitness", 2);
        Student studentC = new Student(1,"Mike");
        studentC.enrollCourse(courseB);
        studentC.enrollCourse(courseA);
        studentC.enrollCourse(courseC);
        studentC.setGrade(courseB, 3.7);
        studentC.setGrade(courseA, 2.3);
        studentC.setGrade(courseC, 4.0);
        assertEquals(3.25, studentC.caculateGPA());
    }


}