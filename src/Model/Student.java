package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Student {
    int id;
    String name;
    HashMap<Integer, Double> grades;
    List<Course> enrolledCourses;
    double gpa;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public String getStudentName() {
        return name;
    }

    public void displayCourses() {
        System.out.println(getStudentName() + "'s Enrolled Courses:");
        System.out.println();
        for(Course course : enrolledCourses) {
            System.out.println("Course Id: " + course.getId());
            System.out.println("Course Name: " + course.getName());
            System.out.println("Course Credits: " + course.getCredit());
            System.out.println();
        }
    }

    public double caculateGPA() {
        if (!grades.isEmpty()) {
            double averageGrade = 0;
            Integer totalCredits = 0;
            Integer creditHours = 0;
            for (Integer course : grades.keySet()) {
                for (Course i : enrolledCourses) {
                    if (i.getId() == course) {
                        creditHours = i.getCredit();
                        totalCredits += creditHours;
                        ///System.out.println("creditHours = " + creditHours);
                        break;
                    } else {
                        continue;
                    }
                }
                ///System.out.println("grades.get(course) = " + grades.get(course));
                averageGrade += grades.get(course)*creditHours;
                ///System.out.println("averageGrade = " + averageGrade);
            }
            averageGrade = averageGrade / totalCredits;
            gpa = averageGrade;
            System.out.println("GPA = " + gpa);
        }
        return gpa;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public boolean setGrade(Course course, double grade) {
        if (enrolledCourses.contains(course)) {
            grades.put(course.getId(),grade);
            return true;
        }
        return false;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public static void main(String[] args) {
        Student student1 = new Student(1,"Mary");
        Course course1 = new Course(1,01, "English","Grammar and Spelling", 3);
        Course course2 = new Course(2, 02, "Math", "Geometry", 3);
        Course course3 = new Course(3, 03, "Gym", "Physical Fitness", 2);

        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student1.enrollCourse(course3);

        student1.setGrade(course1,3.3);
        student1.setGrade(course2, 2.0);
        student1.setGrade(course3, 4.0);

        student1.getEnrolledCourses();

        student1.displayCourses();
        student1.caculateGPA();
    }
}
