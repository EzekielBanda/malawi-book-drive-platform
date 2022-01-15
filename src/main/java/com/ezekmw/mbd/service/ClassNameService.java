package com.ezekmw.mbd.service;

import com.ezekmw.mbd.model.classNumber.ClassName;
import com.ezekmw.mbd.repository.ClassNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassNameService {
    private final ClassNameRepository classNameRepository;

    @Autowired
    public ClassNameService(ClassNameRepository classNameRepository) {
        this.classNameRepository = classNameRepository;
    }
    public List<ClassName> getClassName() {
        return classNameRepository.findAll();
    }
    //Adding class names
    public void submitClassName(ClassName className){
        classNameRepository.save(className);
    }
}
