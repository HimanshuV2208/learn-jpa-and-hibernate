package com.himanshu.springboot.learnjpaandhibernate.course;

//import com.himanshu.springboot.learnjpaandhibernate.course.jdbc.repository.CourseJdbcRepository;
import com.himanshu.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    //private CourseJdbcRepository repository;
    private CourseJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        repository.insert(new Course(2, "Learn Azure", "in28minutes"));
        repository.insert(new Course(3, "Learn DevOps", "in28minutes"));

        repository.deleteById(1);

        System.out.println(repository.selectById(2));
        System.out.println(repository.selectById(3));

    }
}
