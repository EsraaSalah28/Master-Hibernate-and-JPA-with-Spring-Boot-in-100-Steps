package com.example.demo.repo;

import com.example.demo.model.Passport;
import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public Student save(Student student) {

        if (student.getId()== null) {
            em.persist(student);
        } else {
            em.merge(student);
        }

        return student;
    }

    public void deleteById(int id) {
        Student student = findById(id);
        em.remove(student);
    }

    public void saveStudentWithPassport() {
        Passport passport= new Passport("12345");
        em.persist(passport);

        Student student = new Student("youssef");
        student.setPassport(passport);
        em.persist(student);


    }
}
