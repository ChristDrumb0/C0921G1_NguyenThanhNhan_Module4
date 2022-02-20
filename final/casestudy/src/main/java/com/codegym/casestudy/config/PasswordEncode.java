package com.codegym.casestudy.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncode {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123"));
    }
}
