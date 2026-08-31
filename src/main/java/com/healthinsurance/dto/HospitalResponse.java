package com.healthinsurance.dto;


public class HospitalResponse {

    private Long hospitalId;
    private String hospitalCode;
    private String hospitalName;
    private String city;
    private String state;
    private String hospitalType;
    private String networkStatus;
    private Double rating;

    public HospitalResponse() {
    }

    public HospitalResponse(Long hospitalId, String hospitalCode, String hospitalName, String city, String state, String hospitalType, String networkStatus, Double rating) {
        this.hospitalId = hospitalId;
        this.hospitalCode = hospitalCode;
        this.hospitalName = hospitalName;
        this.city = city;
        this.state = state;
        this.hospitalType = hospitalType;
        this.networkStatus = networkStatus;
        this.rating = rating;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getHospitalType() {
        return hospitalType;
    }

    public void setHospitalType(String hospitalType) {
        this.hospitalType = hospitalType;
    }

    public String getNetworkStatus() {
        return networkStatus;
    }

    public void setNetworkStatus(String networkStatus) {
        this.networkStatus = networkStatus;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
