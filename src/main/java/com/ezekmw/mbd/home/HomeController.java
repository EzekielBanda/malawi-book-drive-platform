package com.ezekmw.mbd.home;

import com.ezekmw.mbd.controller.ModelController;
import com.ezekmw.mbd.service.BookService;
import com.ezekmw.mbd.model.users.student.Student;
import com.ezekmw.mbd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/home")
public class HomeController extends ModelController{
    private final StudentService studentService;
    @Autowired
    public HomeController(StudentService service, BookService bookService, StudentService studentService) {
        super(service, bookService);
        this.studentService = studentService;
    }

    @GetMapping
    public String homePage(){
        return "Welcome to Malawi Book Drive";
    }
    @GetMapping("getstudent")
    public List<Student> getStudent(String student){

        return studentService.getStudent(student);
    }

}
