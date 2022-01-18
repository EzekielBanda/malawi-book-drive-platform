package com.ezekmw.mbd.service;

import com.ezekmw.mbd.model.users.registration.EmailValidator;
import com.ezekmw.mbd.model.users.registration.RegistrationRequest;
import com.ezekmw.mbd.model.users.student.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final StudentService studentService;
    private final EmailValidator emailValidator;

    public void register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmailAddress());
        if (!isValidEmail){
            throw new IllegalStateException("Email not valid");
        }
        studentService.createStudent(
                new Student(
                request.getFirstName(),
                request.getLastName(),
                request.getUserName(),
                request.getEmailAddress(),
                request.getPhoneNumber(),
                request.getPassword())
        );
    }

}
