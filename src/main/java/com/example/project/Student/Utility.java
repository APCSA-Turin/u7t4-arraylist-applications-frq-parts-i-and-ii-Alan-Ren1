package com.example.project.Student;
import java.util.ArrayList;

public class Utility {

    public static ArrayList<Student> sortStudents(ArrayList<Student> list) {
        int n = list.size();
        
        // Bubble sort implementation
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareStudents(list.get(j), list.get(j + 1)) > 0) {
                    // Swap students
                    Student temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
    }

    // Custom comparison method to replace Comparator
    private static int compareStudents(Student s1, Student s2) {
        // Compare by last name
        int lastNameComparison = s1.getLastName().compareTo(s2.getLastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        // Compare by first name if last names are the same
        int firstNameComparison = s1.getFirstName().compareTo(s2.getFirstName());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }

        // Compare by GPA in descending order (higher GPA comes first)
        return (s2.getGPA() > s1.getGPA()) ? 1 : (s2.getGPA() < s1.getGPA()) ? -1 : 0;
    }
}
