package com.archit.application.controllers.rest;

import com.archit.application.models.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    /**
     * @PostConstruct runs only once when this bean is constructed
     * define @PostConstruct to load student data
     * This is temporary solution to initialize the test data when
     * not implemented  and coded to load data from service/database
     */
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Archit", "Chandra"));
        students.add(new Student("Ankush", "Chandra"));
        students.add(new Student("Richa", "Patel"));
    }


    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students; // Jackson will convert this student object to JSON
    }
}
