package com.fatec.eacademic.model;

import javax.persistence.*;
import java.util.Collection;
import com.fatec.eacademic.model.Subject;

@Entity
@Table()
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String ra;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "students_subjects",
        joinColumns = @JoinColumn(
            name = "student_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "subject_id", referencedColumnName = "id"))
    private Collection < Subject > subjects;

    public Student() {}

    public Student(String name, String lastName, String email, String password, String ra) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ra = ra;
    }

    public Student(String name, String lastName, String email, String password, String ra, Collection < Subject > subjects) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
        this.ra = ra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection < Subject > getSubjects() {
        return subjects;
    }

    public void setSubjects(Collection < Subject > subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", ra='" + ra + '\'' +
            ", password='" + "*********" + '\'' +
            ", subjects=" + subjects +
            '}';
    }
}