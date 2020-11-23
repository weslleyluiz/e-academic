
package com.fatec.eacademic.model;

import javax.persistence.*;
import java.util.Collection;
 
import com.fatec.eacademic.model.Subject;
import com.fatec.eacademic.model.Course;

@Entity
@Table()
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String email;
    private String password;
    private String cpf;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "teachers_subjects",
        joinColumns = @JoinColumn(
            name = "teacher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "subject_id", referencedColumnName = "id"))
    private Collection < Subject > subjects;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "teachers_courses",
        joinColumns = @JoinColumn(
            name = "teacher_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "course_id", referencedColumnName = "id"))
    private Collection < Course > courses;

    public Teacher() {}

    public Teacher(String name, String lastName, String email, String password, String cpf) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }

    public Teacher(String name, String lastName, String email, String password, String cpf, Collection < Subject > subjects,Collection < Course > courses) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.subjects = subjects;
        this.cpf = cpf;
        this.courses = courses;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Collection < Course > getCourses() {
        return courses;
    }

    public void setCourses(Collection < Course > courses) {
        this.courses = courses;
    }
    @Override
    public String toString() {
        return "Teacher{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", cpf='" + cpf + '\'' +
            ", password='" + "*********" + '\'' +
            ", subjects=" + subjects +
            ", courses=" + courses +
            '}';
    }
}