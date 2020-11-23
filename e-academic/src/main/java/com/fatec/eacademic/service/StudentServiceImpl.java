package com.fatec.eacademic.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
 
import com.fatec.eacademic.model.Student;
import com.fatec.eacademic.model.Subject;
import com.fatec.eacademic.repository.StudentRepository;

import com.fatec.eacademic.web.dto.StudentRegistrationDto;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public Student findByRa(String ra) {
        return studentRepository.findByRa(ra);
    }

    public Student findByEmail(String email) {
        return studentRepository.findByEmail(email);
    }


    public Student save(StudentRegistrationDto registration) {
        Student user = new Student();
        user.setName(registration.getName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setRa(registration.getRa());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setSubjects(Arrays.asList(new Subject()));
        return studentRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Student user = studentRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(), null);
    }
 
    public Student update(StudentRegistrationDto registration)
    {
        Student user = new Student();
        user.setRa(registration.getRa());
        if(findByRa(user.getRa()) != null){
            return studentRepository.update(user);
        }
        return user;
    }

    public void delete(StudentRegistrationDto registration)
    {
        Student user = new Student();
        user.setRa(registration.getRa()); 
        if(findByRa(user.getRa()) != null){ 
            studentRepository.delete(user);
        } 
    }
}