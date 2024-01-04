package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<Book>> getBooks() {

        List<Book> list = this.booksSevice.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    // get a partcular book using bookId
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

        Book book = this.booksSevice.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    // add a new book handler
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        // here thw eequest body will convert the json to book object
        Book book2 = null;

        try {
            book2 = this.booksSevice.addBook(book);
            System.out.println(book);
            return ResponseEntity.of(Optional.of(book2));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // delete book handler
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        try {
            this.booksSevice.deleteBook(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // update book handler
    @PutMapping("/books/{bookId}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookId") int id) {
        try {
            this.booksSevice.updateBook(book, id);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
