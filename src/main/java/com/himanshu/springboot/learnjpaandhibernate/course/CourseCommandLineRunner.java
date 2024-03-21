package com.himanshu.springboot.learnjpaandhibernate.course;

//import com.himanshu.springboot.learnjpaandhibernate.course.jdbc.repository.CourseJdbcRepository;
//import com.himanshu.springboot.learnjpaandhibernate.course.jpa.repository.CourseJpaRepository;
import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import com.himanshu.springboot.learnjpaandhibernate.course.springdatajpa.repository.CourseSpringJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    //private CourseJdbcRepository repository;
    //private CourseJpaRepository repository;
    private CourseSpringJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        //repository.insert(new Course(1, "Learn AWS", "in28minutes"));
        //repository.insert(new Course(2, "Learn Azure", "in28minutes"));
        //repository.insert(new Course(3, "Learn DevOps", "in28minutes"));
        repository.save(new Course(1, "Learn AWS", "in28minutes"));
        repository.save(new Course(2, "Learn Azure", "in28minutes"));
        repository.save(new Course(3, "Learn DevOps", "in28minutes"));

        repository.deleteById(1L);

        System.out.println(repository.findById(2L));
        System.out.println(repository.findById(3L));

        System.out.println(repository.findByAuthor("in28minutes"));
        System.out.println(repository.findByAuthor(""));

        System.out.println(repository.findByName("Learn Azure"));
        System.out.println(repository.findByName("Learn AWS"));

    }
}
