package com.firstSpringBoot.repository;

import com.firstSpringBoot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findByName(String courseName);
}
