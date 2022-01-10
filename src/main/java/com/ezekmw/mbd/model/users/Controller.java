package com.ezekmw.mbd.model.users;

import com.ezekmw.mbd.model.users.student.Service;
import com.ezekmw.mbd.model.users.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    private final Service service;
    @Autowired
    public Controller(Service service) {
        this.service = service;
    }
    @RequestMapping(value = "/student",method = RequestMethod.GET)
    public List<Student> getStudent(){
        return service.getStudent();
    }

    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public void registerStudent(@RequestBody Student student){
        service.createStudent(student);
    }

}
