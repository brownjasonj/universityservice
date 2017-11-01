package com.example.universityservice.controller;

import com.example.universityservice.model.Course;
import com.example.universityservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class StudentController {
    // We are using Spring Autowiring to wire the student service into the StudentController.
    @Autowired
    private StudentService studentService;

    // : Exposing a Get Service with studentId as a path variable
    @GetMapping("/students/{studentId}/courses")
    private List<Course> getStudenCourses(@PathVariable String studentId) {
        return studentService.retrieveCourses(studentId);
    }

    // Exposing a Get Service for retrieving specific course of a student.
    @GetMapping("/students/{studentId}/courses/{courseId}")
    private Course getStudentCourse(@PathVariable String studentId, @PathVariable String courseId) {
        return studentService.retrieveCourse(studentId, courseId);
    }

    @PostMapping("/students/{studentId}/courses")
    public ResponseEntity<Void> registerStudentForCourse(
            @PathVariable String studentId, @RequestBody Course newCourse) {

        Course course = studentService.addCourse(studentId, newCourse);

        if (course == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
