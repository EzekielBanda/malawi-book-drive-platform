package com.ezekmw.mbd.model.users.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository <Student, Long>{
   Optional<Student >findStudentByEmailAddress(String email);
}
