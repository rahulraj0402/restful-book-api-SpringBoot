package com.api.book.bootrestbook.services;

// import java.util.ArrayList;
import java.util.List;

// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.enteties.Book;

@Component
public class BooksSevice {

    // this we have for dummy database which stores all our books
    // private static List<Book> list = new ArrayList<>();

    // static {

    // list.add(new Book(121, "Spring boot", "John"));
    // list.add(new Book(122, "Spring MVC", "Paul"));
    // list.add(new Book(123, "Angular", "Alex"));
    // list.add(new Book(124, "React", "Sam"));

    // }

    @Autowired
    private BookRepository bookRepository;

    // get all the books
    public List<Book> getAllBooks() {

        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {

        Book book = null;
        try {
            // book = list.stream().filter(e -> e.getId() == id).findFirst().get();
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // for creating new book
    public Book addBook(Book book) {
        // list.add(book);

        Book result = bookRepository.save(book);
        return result;

    }

    // for deleting the student by id
    public void deleteBook(int id) {

        // list.stream().filter(book-> {
        // if (book.getId()!=id) {
        // return true;
        // }else{
        // return false;
        // }
        // }).collect(Collectors.toList());

        // list = list.stream().filter(e -> e.getId() !=
        // id).collect(Collectors.toList());

        this.bookRepository.deleteById(id);

    }

    // for updating the books record
    public Book updateBook(Book book, int bookid) {
        // used the stream api
        // list = list.stream()
        // .map(b -> {
        // if (b.getId() == bookid) {
        // b.setTitle(book.getTitle());
        // b.setAuthor(book.getAuthor());
        // }
        // return b;
        // }).collect(Collectors.toList());

        book.setId(bookid);
        bookRepository.save(book);

        return book;
    }

}
