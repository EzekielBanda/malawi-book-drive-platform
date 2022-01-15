package com.ezekmw.mbd.repository;

import com.ezekmw.mbd.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
@Transactional
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Optional<Book> findBookById(Long id);
}
