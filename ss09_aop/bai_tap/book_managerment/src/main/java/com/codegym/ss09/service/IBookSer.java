package com.codegym.ss09.service;

import com.codegym.ss09.entity.Book;

import java.util.List;

public interface IBookSer {
    void save(Book book);

    List<Book> findAll();

    Book findById(Integer id);

}
