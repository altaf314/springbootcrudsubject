package com.springboot.learn.repository;

import com.springboot.learn.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository  extends JpaRepository<Subject,String> {
}
