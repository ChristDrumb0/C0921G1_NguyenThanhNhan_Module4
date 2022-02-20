package com.codegym.casestudy.model.dto;

import com.codegym.casestudy.model.entity.employee.Division;
import com.codegym.casestudy.model.entity.employee.Education;
import com.codegym.casestudy.model.entity.employee.Position;
import com.codegym.casestudy.model.entity.employee.User;
import com.codegym.casestudy.service.imp.employee.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Component
public class EmployeeDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^([A-Z][a-z]+)(\\s[A-Z][a-z]+)+$",
            message = "must be Capitalize, not include number figure and a space between every words")
    private String name;

    private Date dayOfBirth;

    @Pattern(regexp = "^\\d{11}|\\d{9}$",
            message = "Please follow structure: 'XXXXXXXXX' or 'XXXXXXXXXXX'  (X: 0-9)")
    private String idCard;

    private double salary;

    @Pattern(regexp = "^((090)|(091)|(\\(84\\)\\+90)|(\\(84\\)\\+91))\\d{7}$",
            message = "Please follow structure: '090xxxxxxx' or '091xxxxxxx' or (84)+90xxxxxxx or (84)+91xxxxxxx  (x: 0-9)")
    private String phone;

//    @Pattern(regexp = "^[a-zA-Z0-9_]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$",
//            message = "Please follow structure: 'email23@gmail.com'")
    @Pattern(regexp = "^\\w{3,}(\\.?\\w+)*@[a-z]{2,7}(.[a-z]{2,5}){1,3}$",
            message = "Please follow structure: 'email123@gmail.com'")
    private String email;

    @NotBlank(message = "do not Blank")
    private String address;

    private User user;
    private Position position;
    private Division division;
    private Education education;

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }
    @Autowired
    MyUserDetailService myUserDetailService;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        //date of birth
        if (!Checkdate.checkAge(employeeDto.getDayOfBirth())) {
            errors.rejectValue("dayOfBirth", "birthday.checkAge", "Age must be from 18 to 65");
        }


        //check duplicate
//        String inputUserName = employeeDto.user.getUserName();
//        UserDetails user = myUserDetailService.loadUserByUsername(inputUserName);
//        if (user != null) {
//            errors.rejectValue("user","duplicate.userName","User name already exit");
//        }
    }
}
