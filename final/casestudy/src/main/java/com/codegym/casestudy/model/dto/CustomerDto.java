package com.codegym.casestudy.model.dto;

import com.codegym.casestudy.model.entity.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

public class CustomerDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "KH-[0-9]{4}",
            message = "Please follow structure: 'KH-XXXX' (Với X: 0-9)")
    private String code;

    @Pattern(regexp = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$",
            message = "must be Capitalize, not include number figure and a space between every words")
    private String name;

    private Date dayOfBirth;

    private boolean gender;

    @Pattern(regexp = "^\\d{11}|\\d{9}$",
            message = "Please follow structure: 'XXXXXXXXX' or 'XXXXXXXXXXX'  (X: 0-9)")
    private String idCard;

    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$",
            message = "Please follow structure: '090xxxxxxx' or '091xxxxxxx' or (84)+90xxxxxxx or (84)+91xxxxxxx  (x: 0-9)")
    private String phone;

    @Pattern(regexp = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$",
            message = "Please follow structure: 'email123@gmail.com'")
    private String email;

    @NotBlank(message = "Must not be Blank")
    private String address;


    private CustomerType customerType;

    public CustomerDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        //date of birth
        if (!Checkdate.checkAgeCustomer(customerDto.getDayOfBirth())) {
            errors.rejectValue("dayOfBirth", "birthday.checkAge", "Age must be below 100");
        }
    }
}
