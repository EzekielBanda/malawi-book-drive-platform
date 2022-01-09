package com.ezekmw.mbd.model.users.student;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
    private @Id Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String emailAddress;
    private String password;

    public Student(String firstName, String lastName, String gender, LocalDate dob, String emailAddress, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.emailAddress = emailAddress;
        this.password = password;
    }
}
