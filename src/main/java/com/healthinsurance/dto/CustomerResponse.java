package com.healthinsurance.dto;


public class CustomerResponse {

    private Long customerId;
    private String customerCode;
    private String fullName;
    private String city;
    private String state;
    private String customerStatus;

    public CustomerResponse() {
    }

    public CustomerResponse(Long customerId, String customerCode, String fullName, String city, String state, String customerStatus) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.fullName = fullName;
        this.city = city;
        this.state = state;
        this.customerStatus = customerStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }
}
