package com.example.demo;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepoTest {
    @Autowired
    StudentRepository repository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    EntityManager em;
    @Test
    @Transactional
    public void retrieveStudentAndPassportDetails() {
        Student student = em.find(Student.class, 200);
        logger.info("student -> {}", student);
        logger.info("passport -> {}",student.getPassport());
    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses() {
        Student student = em.find(Student.class, 200);
        logger.info("student -> {}", student);
        logger.info("passport -> {}",student.getCourseList());
    }
}
