package com.archit.application.controllers.rest;

import com.archit.application.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Archit", "Chandra"));
        students.add(new Student("Ankush", "Chandra"));
        students.add(new Student("Richa", "Patel"));
        return students; // Jackson will convert this student object to JSON
    }
}
