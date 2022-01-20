package com.codegym.form.service;

import com.codegym.form.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {

    Page<User> findAll(Pageable pageable);
    List<User> findAll();
    void save(User user);
}
