package com.ezekmw.mbd.model.classNumber;

import com.ezekmw.mbd.model.users.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "classes")
public class ClassName {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id Long classNameId;
    @Column(name = "class_name")
    private String className;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "className",fetch = FetchType.EAGER)
//    private List<Student> studentList = new ArrayList<>();
    //public ClassName(){}
    @OneToMany
    @JoinColumn(name = "student_id")
    private Set<Student> studentList;

    public Long getClassNameId() {
        return classNameId;
    }

    public void setClassNameId(Long classNameId) {
        this.classNameId = classNameId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(Set<Student> studentList) {
        this.studentList = studentList;
    }
}
