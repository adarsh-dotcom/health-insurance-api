package com.healthinsurance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claim_id")
    private Long claimId;
    @Column(name = "claim_number")
    private String claimNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private PolicyMember member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id", nullable = false)
    private Hospital hospital;
    @Column(name = "claim_type")
    private String claimType;
    @Column(name = "claim_status")
    private String claimStatus;
    @Column(name = "admission_date")
    private LocalDate admissionDate;
    @Column(name = "discharge_date")
    private LocalDate dischargeDate;
    @Column(name = "claimed_amount")
    private BigDecimal claimedAmount;
    @Column(name = "approved_amount")
    private BigDecimal approvedAmount;
    @Column(name = "rejected_amount")
    private BigDecimal rejectedAmount;
    @Column(name = "settlement_date")
    private LocalDate settlementDate;
    @Column(name = "settlement_mode")
    private String settlementMode;
    private String diagnosis;
    private String remarks;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Claim() {
    }

    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long v) {
        claimId = v;
    }

    public String getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(String v) {
        claimNumber = v;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy v) {
        policy = v;
    }

    public PolicyMember getMember() {
        return member;
    }

    public void setMember(PolicyMember v) {
        member = v;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital v) {
        hospital = v;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String v) {
        claimType = v;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String v) {
        claimStatus = v;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate v) {
        admissionDate = v;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate v) {
        dischargeDate = v;
    }

    public BigDecimal getClaimedAmount() {
        return claimedAmount;
    }

    public void setClaimedAmount(BigDecimal v) {
        claimedAmount = v;
    }

    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    public void setApprovedAmount(BigDecimal v) {
        approvedAmount = v;
    }

    public BigDecimal getRejectedAmount() {
        return rejectedAmount;
    }

    public void setRejectedAmount(BigDecimal v) {
        rejectedAmount = v;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate v) {
        settlementDate = v;
    }

    public String getSettlementMode() {
        return settlementMode;
    }

    public void setSettlementMode(String v) {
        settlementMode = v;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String v) {
        diagnosis = v;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String v) {
        remarks = v;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime v) {
        createdAt = v;
    }
}
