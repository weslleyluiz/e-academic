package com.fatec.eacademic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.eacademic.model.Student;

@Repository
public interface StudentRepository extends JpaRepository < Student, Long > {
    Student findByEmail(String email);

    Student findByRa(String ra);

    Student update(Student s);
    
    void delete(Student s);  
}