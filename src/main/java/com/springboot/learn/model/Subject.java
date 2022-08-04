package com.springboot.learn.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Subject {

    @Id
    private String subjectId;
    @Column(nullable = false)
    private String subjectName;
    private int subjectSem;


}
