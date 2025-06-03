package com.kumarvipul.functional.javastream.beginner;

import com.kumarvipul.functional.javastream.model.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utility class to perform various Stream operations on Student data.
 */
public class StreamOperations {

    /**
     * Filters and returns the list of students who scored more than 75.
     *
     * @param students List of students
     * @return List of students with grade > 75
     * @throws NullPointerException if the input list is null
     */
    public List<Student> filterStudentsWithGradeGt75(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .filter(st -> st.grade() > 75)
                .toList();
    }

    /**
     * Returns a list of student names sorted by grade in descending order.
     *
     * @param students List of students
     * @return List of student names sorted by grade (high to low)
     * @throws NullPointerException if the input list is null
     */
    public List<String> nameOfStudentsSortedByGradeDesc(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .sorted(Comparator.comparingDouble(Student::grade).reversed())
                .map(Student::name)
                .toList();
    }

    /**
     * Finds and returns the student with the highest grade.
     *
     * @param students List of students
     * @return Optional containing the student with the highest grade,
     *         or empty if the list is empty
     * @throws NullPointerException if the input list is null
     */
    public Optional<Student> studentWithHighestGrade(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .max(Comparator.comparingDouble(Student::grade));
        // Equivalent: .max((s1, s2) -> Double.compare(s1.grade(), s2.grade()));
    }

    /**
     * Returns the first 3 students from the given list.
     * If the list has fewer than 3 students, returns all of them.
     *
     * @param students List of students
     * @return List containing up to 3 students
     * @throws NullPointerException if the input list is null
     */
    public List<Student> first3StudentsFromList(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .limit(3)
                .toList();
    }

    /**
     * Calculates the average grade of all students.
     *
     * @param students List of students
     * @return Average grade as a double, or 0.0 if the list is empty
     * @throws NullPointerException if the input list is null
     */
    public double calculateAverageGrade(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .mapToDouble(Student::grade)
                .average()
                .orElse(0.0);
    }

    /**
     * Returns a list of student names sorted by age in ascending order.
     *
     * @param students List of students
     * @return List of student names sorted by age (youngest to oldest)
     * @throws NullPointerException if the input list is null
     */
    public List<String> nameOfStudentsSortedByAgeAsc(List<Student> students) {
        Objects.requireNonNull(students, "Student list cannot be null");
        return students.stream()
                .sorted(Comparator.comparingInt(Student::age))
                // Equivalent: .sorted((s1, s2) -> Integer.compare(s1.age(), s2.age()))
                .map(Student::name)
                .toList();
    }
}
