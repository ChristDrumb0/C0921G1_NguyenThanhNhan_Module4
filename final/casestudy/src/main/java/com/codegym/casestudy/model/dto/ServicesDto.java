package com.codegym.casestudy.model.dto;

import com.codegym.casestudy.model.entity.service.RentType;
import com.codegym.casestudy.model.entity.service.ServiceType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Pattern;

public class ServicesDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "(HO|RO|VL)-[0-9]{4}",
            message = "Please follow structure: 'KH-XXXX' (Với X: 0-9)")
    private String code;

    private String serviceName;

    private double area;

    private double cost;

    private int maxPeople;

    private String standardRoom;

    private String otherConvenienceDes;

    private double poolArea;

    private int floors;

    private RentType rentType;

    private ServiceType serviceType;

    public ServicesDto() {
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherConvenienceDes() {
        return otherConvenienceDes;
    }

    public void setOtherConvenienceDes(String otherConvenienceDes) {
        this.otherConvenienceDes = otherConvenienceDes;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
