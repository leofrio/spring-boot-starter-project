package com.firstSpringBoot.repository;

import com.firstSpringBoot.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {

    Course findByName(String courseName);
}
