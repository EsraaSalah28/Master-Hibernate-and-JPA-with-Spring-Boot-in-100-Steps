package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Student {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @ManyToMany(mappedBy = "students",fetch = FetchType.EAGER)
    private List<Course> courseList= new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void addCourse(Course c){
        this.courseList.add(c);
    }
}
