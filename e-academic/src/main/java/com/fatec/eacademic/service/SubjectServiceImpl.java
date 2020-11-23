package com.fatec.eacademic.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;
 
import com.fatec.eacademic.model.Subject;
import com.fatec.eacademic.repository.SubjectRepository;

import com.fatec.eacademic.web.dto.SubjectRegistrationDto;

public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

     
    public Subject findByName(String name) {
        return subjectRepository.findByName(name);
    }

    public Subject save(SubjectRegistrationDto registration) {
        Subject subject = new Subject();
        subject.setName(registration.getName());
        subject.setDescription(registration.getDescription()); 
        return subjectRepository.save(subject);
    }
    
    public Subject update(SubjectRegistrationDto registration)
    {
        Subject subject = new Subject();
        subject.setName(registration.getName());
        if(findByName(subject.getName()) != null){
            return subjectRepository.update(subject);
        }
        return subject;
    }

    public void delete(SubjectRegistrationDto registration)
    {
        Subject subject = new Subject();
        subject.setName(registration.getName());
        if(findByName(subject.getName()) != null){
            subjectRepository.delete(subject);
        } 
    }

}