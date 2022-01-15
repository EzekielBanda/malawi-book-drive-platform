package com.ezekmw.mbd.service;

import com.ezekmw.mbd.model.book.Book;
import com.ezekmw.mbd.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    //Retrieve the books
    public List<Book> getBook(){
        return bookRepository.findAll();
    }
    //Add new Book
    public void addNewBook(Book newBook){
        Optional<Book> bookOptional = bookRepository.findBookById(newBook.getId());
        newBook.setBookName(newBook.getBookName());
        newBook.setSubjectName(newBook.getSubjectName());
        newBook.setAuthor(newBook.getAuthor());
        newBook.setDatePublished(newBook.getDatePublished());

        if (bookOptional.isPresent()){
            throw new IllegalStateException("The Book you are trying to add is available");
        }
        bookRepository.save(newBook);
    }
    //Remove the book
    public void deleteBook(Long id){
        boolean exits = bookRepository.existsById(id);
        if (!exits){
            throw new IllegalStateException("The book with your trying to delete is not available");
        }
        bookRepository.deleteById(id);
    }
}
