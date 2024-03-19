package com.himanshu.springboot.learnjpaandhibernate.course.jdbc.repository;

import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    private static final String INSERT_QUERY = """
            insert into course(id, name, author)
            values(?,?,?);
            """;

    private static final String DELETE_QUERY = """
            delete from course where id = ?
            """;

    private static final String SELECT_QUERY = """
            select * from course where id = ?
            """;

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course selectById(long id) {
        //We need to map the ResultSet to a bean
        //ResultSet -> Bean => RowMappers
        //This is done by RowMappers
        //In our case, table row names match the bean property names
        //So we can use BeanPropertyRowMapper
        return springJdbcTemplate.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class), id);
    }

}
