package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.enteties.Book;

@Component
public class BooksSevice {

    // this we have for dummy database which stores all our books
    private static List<Book> list = new ArrayList<>();

    static {

        list.add(new Book(121, "Spring boot", "John"));
        list.add(new Book(122, "Spring MVC", "Paul"));
        list.add(new Book(123, "Angular", "Alex"));
        list.add(new Book(124, "React", "Sam"));

    }

    // get all the books
    public List<Book> getAllBooks() {

        return list;
    }

    // get single book by id
    public Book getBookById(int id) {

        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;
    }

    // for creating new book
    public Book addBook(Book book) {
        list.add(book);
        return book;

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

        list = list.stream().filter(e -> e.getId() != id).collect(Collectors.toList());

    }


    // for updating the books record
    

}
