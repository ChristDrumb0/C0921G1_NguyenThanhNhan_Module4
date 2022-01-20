package com.codegym.form.service;

import com.codegym.form.model.User;
import com.codegym.form.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements IUserService{
    @Autowired
    IUserRepo repo;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }
}
