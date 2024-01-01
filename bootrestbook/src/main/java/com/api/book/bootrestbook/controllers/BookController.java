package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.enteties.Book;
import com.api.book.bootrestbook.services.BooksSevice;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class BookController {

    // since we want list of books which we will call from sercice
    // make a new object of BookService

    @Autowired
    BooksSevice booksSevice;

    // get all the books handler
    @GetMapping("/books")
    public List<Book> getBooks() {

        return this.booksSevice.getAllBooks();
    }

    // get a partcular book using bookId
    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int id) {

        return this.booksSevice.getBookById(id);
    }

    // add a new book handler
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        // here thw eequest body will convert the json to book object
        Book book2 = this.booksSevice.addBook(book);
        return book2;
    }


    // delete book handler
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int id) {

        this.booksSevice.deleteBook(id);
    }


    //update book handler
   @PutMapping("/books/{bookId}")
   public Book updateBook(@RequestBody Book book  , @PathVariable("bookId") int id){
        this.booksSevice.updateBook(book , id);
    return 
   }

}
