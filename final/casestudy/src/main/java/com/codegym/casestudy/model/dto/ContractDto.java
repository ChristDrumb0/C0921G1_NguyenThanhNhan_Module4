package com.codegym.casestudy.model.dto;

import com.codegym.casestudy.model.entity.customer.Customer;
import com.codegym.casestudy.model.entity.employee.Employee;
import com.codegym.casestudy.model.entity.service.Services;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Date;

public class ContractDto implements Validator {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date startDate;
    private Date endDate;
    private double deposit;
    private double totalFee;

    private Employee employee;
    private Customer customer;
    private Services service;

    public ContractDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        Date startDate = contractDto.getStartDate();
        Date endDate = contractDto.getEndDate();
        if (!Checkdate.checkStartDate(startDate)) {
            errors.rejectValue("startDate","startDate.future","Start date must be before present");
        }
        if (!Checkdate.checkEndDate(endDate,startDate)) {
            errors.rejectValue("endDate","endDate.past","End date must be later than Start date");
        }
    }
}
