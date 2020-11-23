package com.fatec.eacademic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.eacademic.model.Teacher; 

@Repository
public interface TeacherRepository extends JpaRepository < Teacher, Long > {
    Teacher findByEmail(String email);

    Teacher findByCpf(String cpf); 
    
    Teacher update(Teacher t);

    void delete(Teacher t);  
}