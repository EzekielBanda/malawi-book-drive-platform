package com.ezekmw.mbd.repository;

import com.ezekmw.mbd.model.users.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@org.springframework.stereotype.Repository
public interface StudentRepository extends JpaRepository <Student, Long>{
   Optional<Student >findStudentByEmailAddress(String email);
}
