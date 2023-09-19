package com.example.demo.jdbc;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    JdbcTemplate  jdbcTemplate;
    public List<Person> findAll(){
      return jdbcTemplate.query("select * from Person where  id =1 ",new BeanPropertyRowMapper<Person>(Person.class));

    }
}




