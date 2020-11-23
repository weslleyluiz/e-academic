
package com.fatec.eacademic.model;

import javax.persistence.*;
import java.util.Collection;
import com.fatec.eacademic.model.Course;
@Entity
@Table()
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "subjects_course",
        joinColumns = @JoinColumn(
            name = "subject_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(
            name = "course_id", referencedColumnName = "id"))
    private Collection < Course > courses;
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