package com.kumarvipul.functional.javastream.beginner;

import com.kumarvipul.functional.javastream.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StreamOperationsTest {

    private StreamOperations streamOps;
    private List<Student> students;

    @BeforeEach
    void setUp() {
        streamOps = new StreamOperations();
        students = List.of(
                new Student(1, "Alice", "alice@example.com", 20, 2023, 85.5),
                new Student(2, "Bob", "bob@example.com", 22, 2022, 67.0),
                new Student(3, "Charlie", "charlie@example.com", 21, 2023, 92.0),
                new Student(4, "Daisy", "daisy@example.com", 23, 2024, 74.5)
        );
    }

    // --- filterStudentsWithGradeGt75 ---

    @Test
    void testFilterStudentsWithGradeGt75() {
        var result = streamOps.filterStudentsWithGradeGt75(students);
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.grade() > 75));
    }

    @Test
    void testFilterStudentsWithGradeGt75_EmptyList() {
        assertTrue(streamOps.filterStudentsWithGradeGt75(List.of()).isEmpty());
    }

    @Test
    void testFilterStudentsWithGradeGt75_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.filterStudentsWithGradeGt75(null));
    }

    // --- nameOfStudentsSortedByGradeDesc ---

    @Test
    void testNameOfStudentsSortedByGradeDesc() {
        var result = streamOps.nameOfStudentsSortedByGradeDesc(students);
        assertEquals(List.of("Charlie", "Alice", "Daisy", "Bob"), result);
    }

    @Test
    void testNameOfStudentsSortedByGradeDesc_EmptyList() {
        assertTrue(streamOps.nameOfStudentsSortedByGradeDesc(List.of()).isEmpty());
    }

    @Test
    void testNameOfStudentsSortedByGradeDesc_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.nameOfStudentsSortedByGradeDesc(null));
    }

    // --- studentWithHighestGrade ---

    @Test
    void testStudentWithHighestGrade() {
        Optional<Student> result = streamOps.studentWithHighestGrade(students);
        assertTrue(result.isPresent());
        assertEquals("Charlie", result.get().name());
    }

    @Test
    void testStudentWithHighestGrade_EmptyList() {
        Optional<Student> result = streamOps.studentWithHighestGrade(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    void testStudentWithHighestGrade_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.studentWithHighestGrade(null));
    }

    // --- first3StudentsFromList ---

    @Test
    void testFirst3StudentsFromList() {
        var result = streamOps.first3StudentsFromList(students);
        assertEquals(3, result.size());
        assertEquals(List.of("Alice", "Bob", "Charlie"), result.stream().map(Student::name).toList());
    }

    @Test
    void testFirst3StudentsFromList_LessThan3() {
        var result = streamOps.first3StudentsFromList(List.of(students.get(0), students.get(1)));
        assertEquals(2, result.size());
    }

    @Test
    void testFirst3StudentsFromList_EmptyList() {
        assertTrue(streamOps.first3StudentsFromList(List.of()).isEmpty());
    }

    @Test
    void testFirst3StudentsFromList_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.first3StudentsFromList(null));
    }

    // --- calculateAverageGrade ---

    @Test
    void testCalculateAverageGrade() {
        double expectedAvg = (85.5 + 67.0 + 92.0 + 74.5) / 4;
        double result = streamOps.calculateAverageGrade(students);
        assertEquals(expectedAvg, result, 0.001);
    }

    @Test
    void testCalculateAverageGrade_EmptyList() {
        double result = streamOps.calculateAverageGrade(List.of());
        assertEquals(0.0, result);
    }

    @Test
    void testCalculateAverageGrade_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.calculateAverageGrade(null));
    }

    // --- nameOfStudentsSortedByAgeAsc ---

    @Test
    void testNameOfStudentsSortedByAgeAsc() {
        var result = streamOps.nameOfStudentsSortedByAgeAsc(students);
        assertEquals(List.of("Alice", "Charlie", "Bob", "Daisy"), result);
    }

    @Test
    void testNameOfStudentsSortedByAgeAsc_EmptyList() {
        assertTrue(streamOps.nameOfStudentsSortedByAgeAsc(List.of()).isEmpty());
    }

    @Test
    void testNameOfStudentsSortedByAgeAsc_NullInput() {
        assertThrows(NullPointerException.class, () -> streamOps.nameOfStudentsSortedByAgeAsc(null));
    }
}
