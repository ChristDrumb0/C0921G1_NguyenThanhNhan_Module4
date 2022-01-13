package vn.codegym.model;

import java.util.Arrays;

public class MedicalDeclaration {
    private String fullName;
    private String yOB;
    private String gender;
    private String nationality;
    private String idCard;
    private String transportation;
    private String transportNumber;
    private String seatNumber;
    private String departureDay;
    private String endDate;
    private String visitedLocation;
    private String province;
    private String district;
    private String ward;
    private String address;
    private String phone;
    private String email;
    private String[] symptoms;
    private String[] historyExposure;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String fullName, String yOB, String gender, String nationality,
                              String idCard, String transportation, String transportNumber, String seatNumber, String departureDay,
                              String endDate, String visitedLocation, String province, String district, String ward, String address,
                              String phone, String email, String[] symptoms, String[] historyExposure) {
        this.fullName = fullName;
        this.yOB = yOB;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.transportation = transportation;
        this.transportNumber = transportNumber;
        this.seatNumber = seatNumber;
        this.departureDay = departureDay;
        this.endDate = endDate;
        this.visitedLocation = visitedLocation;
        this.province = province;
        this.district = district;
        this.ward = ward;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.symptoms = symptoms;
        this.historyExposure = historyExposure;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYearOfBirth() {
        return yOB;
    }

    public void setYearOfBirth(String yOB) {
        this.yOB = yOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public String getTransportNumber() {
        return transportNumber;
    }

    public void setTransportNumber(String transportNumber) {
        this.transportNumber = transportNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getVisitedLocation() {
        return visitedLocation;
    }

    public void setVisitedLocation(String visitedLocation) {
        this.visitedLocation = visitedLocation;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String[] getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String[] symptoms) {
        this.symptoms = symptoms;
    }

    public String[] getHistoryExposure() {
        return historyExposure;
    }

    public void setHistoryExposure(String[] historyExposure) {
        this.historyExposure = historyExposure;
    }

    @Override
    public String toString() {
        return "MedicalDeclaration{" +
                "fullName='" + fullName + '\'' +
                ", yOB=" + yOB +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idCard='" + idCard + '\'' +
                ", transportation='" + transportation + '\'' +
                ", transportNumber='" + transportNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", departureDay='" + departureDay + '\'' +
                ", endDate='" + endDate + '\'' +
                ", visitedLocation='" + visitedLocation + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", symptoms=" + Arrays.toString(symptoms) +
                ", historyExposure=" + Arrays.toString(historyExposure) +
                '}';
    }
}
