package com.ezekmw.mbd.service;

import com.ezekmw.mbd.repository.StudentRepository;
import com.ezekmw.mbd.model.users.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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
    //Modify Student details
    @Transactional
    public void updateStudent(Long id, String firstName, String lastName, String emailAddress) {
        Student student = repository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id "
        +id +" does not exist"));

        if (firstName != null && firstName.length()>0 && !Objects.equals(student.getFirstName(),firstName)){
            student.setFirstName(firstName);
        }
        if (lastName != null && lastName.length()>0 && !Objects.equals(student.getLastName(),lastName)){
            student.setLastName(lastName);
        }
        if (emailAddress != null && emailAddress.length()>0 && !Objects.equals(student.getEmailAddress(),emailAddress)){
            Optional<Student>studentOptional = repository.findStudentByEmailAddress(emailAddress);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("Email already taken");
            }
            student.setEmailAddress(emailAddress);
        }


    }
}
