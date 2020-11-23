package com.fatec.eacademic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.eacademic.model.Course;

@Repository
public interface CourseRepository extends JpaRepository < Course, Long > {
    Course findByName(String name); 
    Course update(Course c);
    void delete(Course c); 
}