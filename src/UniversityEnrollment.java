// src/UniversityEnrollment.java
import java.util.ArrayList;
import java.util.List;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

class Course {
    private String name;
    private int capacity;
    private List<String> prerequisites;
    private List<String> enrolledStudents;

    public Course(String name, int capacity, List<String> prerequisites) {
        this.name = name;
        this.capacity = capacity;
        this.prerequisites = prerequisites;
        this.enrolledStudents = new ArrayList<>();
    }

    public void enroll(String studentName, List<String> completedCourses) throws CourseFullException, PrerequisiteNotMetException {
        if (enrolledStudents.size() >= capacity) {
            throw new CourseFullException("Course is full. Cannot enroll.");
        }

        for (String prerequisite : prerequisites) {
            if (!completedCourses.contains(prerequisite)) {
                throw new PrerequisiteNotMetException("Complete " + prerequisite + " before enrolling in " + name + ".");
            }
        }

        enrolledStudents.add(studentName);
        System.out.println(studentName + " enrolled successfully in " + name + ".");
    }
}

public class UniversityEnrollment {
    public static void main(String[] args) {
        List<String> prerequisites = new ArrayList<>();
        prerequisites.add("Core Java");

        Course advancedJava = new Course("Advanced Java", 2, prerequisites);

        List<String> completedCourses = new ArrayList<>(); // Empty, no prerequisites completed

        try {
            advancedJava.enroll("John Doe", completedCourses);
        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
