package com.ezekmw.mbd.controller;

import com.ezekmw.mbd.model.book.Book;
import com.ezekmw.mbd.service.BookService;
import com.ezekmw.mbd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "/api/v1")
public class ModelController extends UserController {
    private final BookService bookService;
    @Autowired
    public ModelController(StudentService service, BookService bookService) {
        super(service);
        this.bookService = bookService;
    }
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public List<Book> getBook(){
        return bookService.getBook();
    }
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void createBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }
    @DeleteMapping(path = "/book/{id}")
    public void removeBook(@PathVariable("id")@RequestBody Long id){
        bookService.deleteBook(id);
    }
}
