package com.fatec.eacademic.service;
 
import com.fatec.eacademic.model.Course;
import com.fatec.eacademic.web.dto.CourseRegistrationDto;

public interface CourseService   {

    Course findByName(String name);
  
    Course save(CourseRegistrationDto registration);

    Course update(CourseRegistrationDto registration);

    void delete(CourseRegistrationDto registration);
}