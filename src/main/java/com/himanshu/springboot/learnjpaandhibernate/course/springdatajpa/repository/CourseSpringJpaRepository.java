package com.himanshu.springboot.learnjpaandhibernate.course.springdatajpa.repository;

import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseSpringJpaRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);
    List<Course> findByName(String name);
}
