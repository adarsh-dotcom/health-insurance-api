package com.healthinsurance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyResponse {

    private Long policyId;
    private String policyNumber;
    private String customerName;
    private String productName;
    private BigDecimal sumInsured;
    private BigDecimal annualPremium;
    private LocalDate policyStartDate;
    private LocalDate policyEndDate;
    private String policyStatus;
    private String renewalStatus;

    public PolicyResponse() {
    }

    public PolicyResponse(Long policyId, String policyNumber, String customerName, String productName, BigDecimal sumInsured, BigDecimal annualPremium, LocalDate policyStartDate, LocalDate policyEndDate, String policyStatus, String renewalStatus) {
        this.policyId = policyId;
        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.productName = productName;
        this.sumInsured = sumInsured;
        this.annualPremium = annualPremium;
        this.policyStartDate = policyStartDate;
        this.policyEndDate = policyEndDate;
        this.policyStatus = policyStatus;
        this.renewalStatus = renewalStatus;
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long policyId) {
        this.policyId = policyId;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal sumInsured) {
        this.sumInsured = sumInsured;
    }

    public BigDecimal getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(BigDecimal annualPremium) {
        this.annualPremium = annualPremium;
    }

    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDate policyStartDate) {
        this.policyStartDate = policyStartDate;
    }

    public LocalDate getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDate policyEndDate) {
        this.policyEndDate = policyEndDate;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
    }

    public String getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(String renewalStatus) {
        this.renewalStatus = renewalStatus;
    }
}
