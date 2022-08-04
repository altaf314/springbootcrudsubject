package com.springboot.learn.controller;

import com.springboot.learn.model.Subject;
import com.springboot.learn.service.SubjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        super();
        this.subjectService = subjectService;
    }
    //http://localhost:8067/subject
    @PostMapping
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject)
    {
        return new ResponseEntity<Subject>(subjectService.saveSubject(subject), HttpStatus.CREATED);
    }
    //http://localhost:8067/subject
    @GetMapping
   public List<Subject> getAllSubject()
   {
       return subjectService.getAllSubject();
   }
   //http://localhost:8067/subject/18CS82
   @GetMapping("{subId}")
   public  ResponseEntity<Subject> getSubjectById(@PathVariable("subId") String subjectId)
   {
       return  new ResponseEntity<>(subjectService.getById(subjectId),HttpStatus.OK);
   }
  /*  @PutMapping("{subjId}")
   public ResponseEntity<Subject> updateSubject(@PathVariable("subjId") String subjectId,@RequestBody Subject subject)
    {
      return new ResponseEntity<>(subjectService.updateSubject(subject,subjectId),HttpStatus.OK);

    }*/

    http://localhost:8067/subject/18CS82
    @DeleteMapping("{subjId}")
    public ResponseEntity<String> deleteSubject(@PathVariable("subjId") String subjectId) {
        subjectService.deleteSubject(subjectId);
        return new ResponseEntity<String>("Subject deleted Successfully",HttpStatus.OK);
    }


}
