package com.ezekmw.mbd.model.users.student;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Id Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String emailAddress;
    private String phoneNumber;
    private String password;

    public Student(String firstName, String lastName, String gender, LocalDate dob, String emailAddress,String phoneNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
