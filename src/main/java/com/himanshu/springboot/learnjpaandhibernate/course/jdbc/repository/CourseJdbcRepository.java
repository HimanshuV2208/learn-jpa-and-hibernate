package com.himanshu.springboot.learnjpaandhibernate.course.jdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY =
            """
            insert into course(id, name, author)
            values(1,'Learn AWS','in28minutes');
            """;

    public void insert(){
        springJdbcTemplate.update(INSERT_QUERY);
    }

}
