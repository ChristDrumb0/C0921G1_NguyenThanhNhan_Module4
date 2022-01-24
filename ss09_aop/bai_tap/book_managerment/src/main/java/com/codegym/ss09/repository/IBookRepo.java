package com.codegym.ss09.repository;

import com.codegym.ss09.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer> {
}
