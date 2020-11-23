package com.fatec.eacademic.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.fatec.eacademic.model.Course;
import com.fatec.eacademic.repository.CourseRepository;

import com.fatec.eacademic.web.dto.CourseRegistrationDto;

public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    public Course findByName(String name) {
        return courseRepository.findByName(name);
    }

    public Course save(CourseRegistrationDto registration) {
        Course course = new Course();
        course.setName(registration.getName());
        course.setDescription(registration.getDescription()); 
        return courseRepository.save(course);
    }
    
    public Course update(CourseRegistrationDto registration)
    {
        Course course = new Course();
        course.setName(registration.getName());
        if(findByName(course.getName()) != null){
            return courseRepository.update(course);
        }
        return course;
    }

    public void delete(CourseRegistrationDto registration)
    {
        Course course = new Course();
        course.setName(registration.getName());
        if(findByName(course.getName()) != null){
            courseRepository.delete(course);
        } 
    }
}