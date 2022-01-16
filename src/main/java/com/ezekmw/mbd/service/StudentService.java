package com.ezekmw.mbd.service;

import com.ezekmw.mbd.repository.StudentRepository;
import com.ezekmw.mbd.model.users.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class StudentService {

    private final StudentRepository repository;
    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public List<Student> getStudent(String student){
        return repository.findAll();
    }

    //Create new Student
    public String createStudent(Student student){
        Optional<Student> studentOptional =repository.findStudentByEmailAddress(student.getEmailAddress());
        if (studentOptional.isPresent()){
            throw new IllegalStateException("The email  address is already Taken");
        }
        repository.save(student);
        return null;
    }
}
