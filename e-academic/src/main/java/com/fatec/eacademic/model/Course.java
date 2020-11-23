
package com.fatec.eacademic.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table()
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "course_subjects",
        joinColumns = @JoinColumn(
            name = "course_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "subject_id", referencedColumnName = "id"))
    private Collection < Subject > subjects;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

}