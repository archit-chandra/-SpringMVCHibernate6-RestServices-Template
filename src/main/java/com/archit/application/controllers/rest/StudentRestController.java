package com.archit.application.controllers.rest;

import com.archit.application.exceptions.StudentErrorResponse;
import com.archit.application.exceptions.StudentNotFoundException;
import com.archit.application.models.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check the studentId against the list size
        if (studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }
        return students.get(studentId);
    }

    // add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        // create a StudentErrorResponse
        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        // return ResponseEntity
        // Jackson will convert it to JSON
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
