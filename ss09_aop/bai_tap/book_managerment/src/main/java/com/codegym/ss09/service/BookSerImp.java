package com.codegym.ss09.service;

import com.codegym.ss09.entity.Book;
import com.codegym.ss09.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookSerImp implements IBookSer{

    @Autowired
    private IBookRepo bookRepo;

    @Override
    public void save(Book book) {
        bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id).get();
    }
}
