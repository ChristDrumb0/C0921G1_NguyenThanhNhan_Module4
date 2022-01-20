package com.codegym.form.dto;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    @NotBlank(message = "Must not Blank")
    @Length(min = 5, max = 45, message = "First Name length: from 5 to 45 letters")
    private String firstName;
    @NotBlank(message = "Must not Blank")
    @Length(min = 5, max = 45, message = "Last Name length: from 5 to 45 letters")
    private String lastName;

    //PhoneNumber
    @Pattern(regexp = "0(\\d{9}|\\d{10})", message = "Phone number start with  0, the length from 10 - 11 digit, and no letter")
    private String phoneNumber;
    //Age
    //@Min(value = 18, message = "Tuoi phai >=18")
    @Min(18)
    private Integer age;

    //email
    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$", message = "email phai dung dinh dang: email@gmail.com")
    private String email;

    public UserDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
