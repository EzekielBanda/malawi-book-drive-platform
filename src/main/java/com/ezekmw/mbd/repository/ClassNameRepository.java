package com.ezekmw.mbd.repository;

import com.ezekmw.mbd.model.classNumber.ClassName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassNameRepository extends JpaRepository<ClassName, Long> {

}
