package com.himanshu.springboot.learnjpaandhibernate.course.jpa;

import com.himanshu.springboot.learnjpaandhibernate.course.models.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }

    public Course selectById(long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(long id) {
        Course toDelete = entityManager.find(Course.class, id);
        entityManager.remove(toDelete);
    }

}
