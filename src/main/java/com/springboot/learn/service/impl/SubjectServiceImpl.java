package com.springboot.learn.service.impl;

import com.springboot.learn.exception.ResourceNotFoundException;
import com.springboot.learn.model.Subject;
import com.springboot.learn.repository.SubjectRepository;
import com.springboot.learn.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        super();
        this.subjectRepository = subjectRepository;
    }



    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getById(String subjectId) {
        Optional<Subject> subject=subjectRepository.findById(subjectId);
        if(subject.isPresent())
        {
            return subject.get();
        }
        else {
            throw new ResourceNotFoundException("Subject","SubjectId",subjectId);

        }

    }

    public Optional<Subject> updateSubject(Subject subject, String subjectId) {
        Optional<Subject> existingSubject=subjectRepository.findById(subjectId);
        subjectRepository.findById(subjectId).orElseThrow(()->
                new ResourceNotFoundException("Subject","SubjectId",subjectId));
/*
        existingSubject.setSubjectId(subject.getSubjectId());
        existingSubject.setSubjectName(subject.getSubjectName());
        existingSubject.setSubjectSem(subject.getSubjectSem());
        subjectRepository.save(existingSubject);*/
        return existingSubject;

    }

    @Override
    public void deleteSubject(String subjectId) {
       subjectRepository.findById(subjectId).orElseThrow(()->
                new ResourceNotFoundException("Subject","SubjectId",subjectId));
        subjectRepository.deleteById(subjectId);
    }
}
