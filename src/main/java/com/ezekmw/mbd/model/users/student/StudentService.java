package com.ezekmw.mbd.model.users.student;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class StudentService {
    private final Repository repository;
    @Autowired
    public StudentService(Repository repository) {
        this.repository = repository;
    }
    public List<Student> getStudent(){
        return repository.findAll();
    }
    public void createStudent(Student student){
        Optional<Student> studentOptional =repository.findStudentByEmailAddress(student.getEmailAddress());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("The is already Taken");
        }
        repository.save(student);
    }
}
