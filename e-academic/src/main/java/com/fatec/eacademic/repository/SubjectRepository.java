package com.fatec.eacademic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.eacademic.model.Subject;

@Repository
public interface SubjectRepository extends JpaRepository < Subject, Long > {
    Subject findByName(String name); 

    Subject update(Subject s);

    void delete(Subject s);
}