package com.example.universityservice.service;

import com.example.universityservice.model.Course;
import com.example.universityservice.model.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class StudentServiceTests {

    private Course course1;
    private Course course2;
    private Course course3;
    private Course course4;
    private Student ranga;
    private Student satish;

    private StudentService studentService;

    @Before
    public void setUp() {
        this.studentService = new StudentService();
        
        this.course1 = new Course("Course1", "Spring", "10 Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        this.course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        this.course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        this.course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        this.ranga = new Student("Student1", "Ranga Karanam",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        this.satish = new Student("Student2", "Satish T",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void insertRetreiveStudent() {
        Student returnedStudent = this.studentService.retrieveStudent(ranga.getId());
        assertEquals(returnedStudent.getId(), ranga.getId());
    }

}
