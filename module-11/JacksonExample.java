/*
Name: Jackson Webster
Class: CSD-420
Date: March 4, 2026
Module:  Assignment 11

Description:
This program shows a simple example of using the Jackson JSON API.
The program creates a Java object and converts it into JSON format.
The JSON result is then printed
to the console.
*/

import com.fasterxml.jackson.databind.ObjectMapper;


class Student {

    public String name;
    public int age;

}

public class JacksonExample {

    public static void main(String[] args) throws Exception {

        // Create an ObjectMapper which is used to work with JSON
        ObjectMapper mapper = new ObjectMapper();

        // Create a Student object
        Student s = new Student();
        s.name = "Alex";
        s.age = 20;

        // Convert the Java object into JSON
        String json = mapper.writeValueAsString(s);

        // Print the JSON result
        System.out.println(json);
    }
}