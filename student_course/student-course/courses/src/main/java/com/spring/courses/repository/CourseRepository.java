package com.spring.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.courses.model.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long>{

}
