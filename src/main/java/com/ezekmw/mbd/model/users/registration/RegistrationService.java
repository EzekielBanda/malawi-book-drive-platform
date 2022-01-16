//package com.ezekmw.mbd.model.users.registration;
//
//import com.ezekmw.mbd.model.users.student.AppUserRole;
//import com.ezekmw.mbd.model.users.student.Repository;
//import com.ezekmw.mbd.model.users.student.Student;
//import com.ezekmw.mbd.service.StudentService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class RegistrationService {
//
//    private final StudentService studentService;
//    private final EmailValidator emailValidator;
//
//    public void register(RegistrationRequest request) {
//        boolean isValidEmail = emailValidator.test(request.getEmailAddress());
//        if (!isValidEmail){
//            throw new IllegalStateException("Email not valid");
//        }
//        studentService.createStudent(
//                new Student(
//                request.getFirstName(),
//                request.getLastName(),
//                request.getGender(),
//                request.getDob(),
//                request.getEmailAddress(),
//                request.getPhoneNumber(),
//                request.getPassword(),
//                AppUserRole.USER)
//        );
//    }
//
//}
