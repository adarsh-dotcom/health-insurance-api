package com.healthinsurance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "policies")
public class Policy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Long policyId;
    @Column(name = "policy_number")
    private String policyNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private InsuranceProduct product;
    @Column(name = "policy_start_date")
    private LocalDate policyStartDate;
    @Column(name = "policy_end_date")
    private LocalDate policyEndDate;
    @Column(name = "sum_insured")
    private BigDecimal sumInsured;
    @Column(name = "annual_premium")
    private BigDecimal annualPremium;
    @Column(name = "payment_frequency")
    private String paymentFrequency;
    @Column(name = "policy_status")
    private String policyStatus;
    @Column(name = "renewal_status")
    private String renewalStatus;
    @Column(name = "agent_code")
    private String agentCode;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Policy() {
    }

    public Long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Long v) {
        policyId = v;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String v) {
        policyNumber = v;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer v) {
        customer = v;
    }

    public InsuranceProduct getProduct() {
        return product;
    }

    public void setProduct(InsuranceProduct v) {
        product = v;
    }

    public LocalDate getPolicyStartDate() {
        return policyStartDate;
    }

    public void setPolicyStartDate(LocalDate v) {
        policyStartDate = v;
    }

    public LocalDate getPolicyEndDate() {
        return policyEndDate;
    }

    public void setPolicyEndDate(LocalDate v) {
        policyEndDate = v;
    }

    public BigDecimal getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(BigDecimal v) {
        sumInsured = v;
    }

    public BigDecimal getAnnualPremium() {
        return annualPremium;
    }

    public void setAnnualPremium(BigDecimal v) {
        annualPremium = v;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String v) {
        paymentFrequency = v;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(String v) {
        policyStatus = v;
    }

    public String getRenewalStatus() {
        return renewalStatus;
    }

    public void setRenewalStatus(String v) {
        renewalStatus = v;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String v) {
        agentCode = v;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime v) {
        createdAt = v;
    }
}
