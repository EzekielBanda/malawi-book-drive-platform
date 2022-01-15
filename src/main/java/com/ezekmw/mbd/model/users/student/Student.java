package com.ezekmw.mbd.model.users.student;

import com.ezekmw.mbd.model.book.Book;
import com.ezekmw.mbd.model.classNumber.ClassName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "student")
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private @Id Long id;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "date_of_birth",nullable = false)
    private LocalDate dob;
    @Column(name = "email",nullable = false)
    private String emailAddress;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "password")
    private String password;


    @ManyToOne
    @JoinColumn(name = "class_name_id")
    private ClassName className;

    public Student(String firstName, String lastName, String gender, LocalDate dob, String emailAddress, String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;

    }
    public ClassName getClassName() {
        return className;
    }

    public void setClassName(ClassName className) {
        this.className = className;
    }

}
