package com.ezekmw.mbd.controller;

import com.ezekmw.mbd.model.users.student.Student;
import com.ezekmw.mbd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController{
    private final StudentService service;
    @Autowired
    public UserController(StudentService service) {
        this.service = service;

    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudent(String student){
        return service.getStudent(student);
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public void registerStudent(@RequestBody Student student){
        service.createStudent(student);
    }

    @PutMapping(path = "/student/modified/{id}")
    public void updateStudent(@PathVariable("id") @RequestBody Long id,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String email){
        service.updateStudent(id, firstName,lastName,email);

    }

}
