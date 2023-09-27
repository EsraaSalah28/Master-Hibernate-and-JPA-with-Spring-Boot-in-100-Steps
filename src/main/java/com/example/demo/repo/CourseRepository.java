package com.example.demo.repo;

import com.example.demo.model.Course;
import com.example.demo.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CourseRepository {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    EntityManager em;

    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    public Course save(Course course) {

        if (course.getId()== null) {
            em.persist(course);
        } else {
            em.merge(course);
        }

        return course;
    }

    public void deleteById(int id) {
        Course course = findById(id);
        em.remove(course);
    }

    public void playWithEntityManager() {
        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);

        Course course2 = findById(1);

        course2.setName("JPA in 50 Steps - Updated");

    }

    public void getReviewsOfCourse() {
        Course course = findById(3);
        Review review1 = new Review("wow","5");
        Review review2 = new Review("notbad","3");
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        em.persist(review1);
        em.persist(review2);
    }
}

