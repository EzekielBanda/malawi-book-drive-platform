package com.ezekmw.mbd.model.book;

import com.ezekmw.mbd.model.users.student.Student;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Id long id;
    private String bookName;
    private String subjectName;
    private String author;
    private String edition;
    private LocalDate datePublished;

    public Book(String bookName, String subjectName, String author, String edition,LocalDate datePublished) {
        this.bookName = bookName;
        this.subjectName = subjectName;
        this.author = author;
        this.edition = edition;
        this.datePublished = datePublished;
    }
}
