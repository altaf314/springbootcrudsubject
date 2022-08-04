package com.springboot.learn.service;

import com.springboot.learn.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectService {

    Subject saveSubject(Subject subject);
    List<Subject> getAllSubject();

    Subject getById(String subjectId);

    Optional<Subject> updateSubject(Subject subject, String subjectId);

    void deleteSubject(String subjectId);
}
