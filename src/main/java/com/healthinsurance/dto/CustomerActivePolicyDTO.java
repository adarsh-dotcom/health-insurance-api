package com.healthinsurance.dto;

public class CustomerActivePolicyDTO {

    private String firstName;
    private String policyNumber;
    private String policyStatus;


    public CustomerActivePolicyDTO(String firstName, String policyNumber, String policyStatus) {
        this.firstName = firstName;
        this.policyNumber = policyNumber;
        this.policyStatus = policyStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }
}
