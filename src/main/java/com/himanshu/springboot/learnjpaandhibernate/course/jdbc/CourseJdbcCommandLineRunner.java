package com.himanshu.springboot.learnjpaandhibernate.course.jdbc;

import com.himanshu.springboot.learnjpaandhibernate.course.jdbc.repository.CourseJdbcRepository;
import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps", "in28minutes"));

        repository.deleteById(1);

    }
}
