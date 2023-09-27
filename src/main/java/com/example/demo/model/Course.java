package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "course")
    private List<Review>reviews = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "COURSE_STUDENT"
            ,joinColumns =@JoinColumn(name = "COURSE_ID")
            ,inverseJoinColumns =@JoinColumn(name="STUDENT_ID"))
     private List<Student> students= new ArrayList<>();
    @UpdateTimestamp
    private LocalDateTime  lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course(String s) {
        s=name;
    }

    void addStudent(Student s){
        this.students.add(s);
    }


    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +

                '}';
    }
}
