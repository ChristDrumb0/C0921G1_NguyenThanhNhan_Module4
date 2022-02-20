package com.codegym.casestudy.service.imp.employee;

import com.codegym.casestudy.model.entity.employee.MyUserDetail;
import com.codegym.casestudy.model.entity.employee.User;
import com.codegym.casestudy.repository.employee.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    IUserRepo iUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = iUserRepo.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username " + username + " NOT EXIST");
        }
        return new MyUserDetail(user);
    }
}
