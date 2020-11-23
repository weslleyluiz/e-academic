package com.fatec.eacademic.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fatec.eacademic.model.Teacher;
import com.fatec.eacademic.web.dto.TeacherRegistrationDto;

public interface TeacherService extends UserDetailsService {

    Teacher findByCpf(String cpf);

    Teacher findByEmail(String email);

    Teacher save(TeacherRegistrationDto registration);

    Teacher update(TeacherRegistrationDto registration);

    void delete(TeacherRegistrationDto registration);
}