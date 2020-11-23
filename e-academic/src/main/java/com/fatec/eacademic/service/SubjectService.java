package com.fatec.eacademic.service;
 
import com.fatec.eacademic.model.Subject;
import com.fatec.eacademic.web.dto.SubjectRegistrationDto;

public interface SubjectService   {

    Subject findByName(String name);

    Subject save(SubjectRegistrationDto registration);

    Subject update(SubjectRegistrationDto registration);

    void delete(SubjectRegistrationDto registration);
}