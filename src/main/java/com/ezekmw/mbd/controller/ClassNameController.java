package com.ezekmw.mbd.controller;

import com.ezekmw.mbd.model.classNumber.ClassName;
import com.ezekmw.mbd.service.ClassNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassNameController {
    private final ClassNameService classNameService;
    @Autowired
    public ClassNameController(ClassNameService classNameService) {
        this.classNameService = classNameService;
    }
    @RequestMapping(value = "/class/names",method = RequestMethod.GET)
    public List<ClassName> getClassName(){
        return classNameService.getClassName();
    }
    @RequestMapping(value = "/class/names", method = RequestMethod.POST)
    public void addClassName(@RequestBody ClassName className){
        classNameService.submitClassName(className);
    }
}
