package com.healthinsurance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ClaimResponse {

    private Long claimId;
    private String claimNumber;
    private String customerName;
    private String memberName;
    private String hospitalName;
    private String claimType;
    private String claimStatus;
    private BigDecimal claimedAmount;
    private BigDecimal approvedAmount;
    private BigDecimal rejectedAmount;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    public ClaimResponse() {
    }

    public ClaimResponse(Long claimId, String claimNumber, String customerName, String memberName, String hospitalName, String claimType, String claimStatus, BigDecimal claimedAmount, BigDecimal approvedAmount, BigDecimal rejectedAmount, LocalDate admissionDate, LocalDate dischargeDate) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.customerName = customerName;
        this.memberName = memberName;
        this.hospitalName = hospitalName;
        this.claimType = claimType;
        this.claimStatus = claimStatus;
        this.claimedAmount = claimedAmount;
        this.approvedAmount = approvedAmount;
        this.rejectedAmount = rejectedAmount;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public BigDecimal getClaimedAmount() {
        return claimedAmount;
    }

    public void setClaimedAmount(BigDecimal claimedAmount) {
        this.claimedAmount = claimedAmount;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal approvedAmount) {
        this.approvedAmount = approvedAmount;
    }

    public BigDecimal getRejectedAmount() {
        return rejectedAmount;
    }

    public void setRejectedAmount(BigDecimal rejectedAmount) {
        this.rejectedAmount = rejectedAmount;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
