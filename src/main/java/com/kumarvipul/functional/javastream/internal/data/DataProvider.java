package com.kumarvipul.functional.javastream.internal.data;

import com.kumarvipul.functional.javastream.model.Student;

import java.util.List;


public class DataProvider {

    public static final int DEFAULT_LIST_SIZE = 15;
    private static DataGenerator dataGenerator = new DataGenerator();

    public static List<Student> listOfStudent(int size){
        return dataGenerator.generateListOfStudent(size);
    }
    public static List<Student> listOfStudent(){
        return listOfStudent(DEFAULT_LIST_SIZE);
    }
}
