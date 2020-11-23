package com.fatec.eacademic.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fatec.eacademic.model.Student;
import com.fatec.eacademic.web.dto.StudentRegistrationDto;

public interface StudentService extends UserDetailsService {

    Student findByRa(String ra);

    Student findByEmail(String email);

    Student save(StudentRegistrationDto registration);

    Student update(StudentRegistrationDto registration);

    void delete(StudentRegistrationDto registration);
}