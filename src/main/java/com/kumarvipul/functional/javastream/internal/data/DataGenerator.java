package com.kumarvipul.functional.javastream.internal.data;

import com.kumarvipul.functional.javastream.model.Student;

import java.util.List;

class DataGenerator {

    List<Student> generateListOfStudent(int size){
        return List.of(
                new Student(1001L, "Alice", "alice@example.com", 20, 2, 85.5),
                new Student(1002L, "Bob", "bob@example.com", 22, 3, 72.0),
                new Student(1003L, "Charlie", "charlie@example.com", 19, 1, 91.2),
                new Student(1004L, "Diana", "diana@example.com", 21, 3, 67.8),
                new Student(1005L, "Alex", "alex@example.com", 20, 2, 85.5),
                new Student(1006L, "Boby", "boby@example.com", 22, 3, 72.0),
                new Student(1007L, "Charles", "charles@example.com", 19, 1, 91.2),
                new Student(1008L, "Dina", "dina@example.com", 21, 3, 67.8)
        );
    }
}
