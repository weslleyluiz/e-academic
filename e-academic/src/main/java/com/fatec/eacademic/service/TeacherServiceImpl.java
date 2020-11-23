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
 
import com.fatec.eacademic.model.Teacher;
import com.fatec.eacademic.model.Course;
import com.fatec.eacademic.model.Subject;

import com.fatec.eacademic.repository.TeacherRepository;

import com.fatec.eacademic.web.dto.TeacherRegistrationDto;

public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository ;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Teacher findByCpf(String cpf) {
        return teacherRepository.findByCpf(cpf);
    }

    @Override
    public Teacher findByEmail(String mail) {
        return teacherRepository.findByEmail(mail);
    }

    public Teacher save(TeacherRegistrationDto registration) {
        Teacher user = new Teacher();
        user.setName(registration.getName());
        user.setLastName(registration.getLastName());
        user.setEmail(registration.getEmail());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setCpf(registration.getCpf());  
        user.setSubjects(Arrays.asList(new Subject()));
        user.setCourses(Arrays.asList(new Course()));
        return teacherRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Teacher user = teacherRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
            user.getPassword(),
            null);
    } 
    public Teacher update(TeacherRegistrationDto registration)
    {
        Teacher user = new Teacher();
        user.setCpf(registration.getCpf());
        if(findByCpf(user.getCpf()) != null){
            return teacherRepository.update(user);
        }
        return user;
    }

    public void delete(TeacherRegistrationDto registration)
    {
        Teacher user = new Teacher();
        user.setCpf(registration.getCpf()); 
        if(findByCpf(user.getCpf()) != null){ 
            teacherRepository.delete(user);
        } 
    }
}