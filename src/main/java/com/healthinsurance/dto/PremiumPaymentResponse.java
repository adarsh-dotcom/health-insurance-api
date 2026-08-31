package com.healthinsurance.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PremiumPaymentResponse {

    private Long paymentId;
    private String paymentReference;
    private String policyNumber;
    private LocalDate paymentDate;
    private LocalDate dueDate;
    private BigDecimal amount;
    private String paymentMode;
    private String paymentStatus;
    private BigDecimal lateFee;

    public PremiumPaymentResponse() {
    }

    public PremiumPaymentResponse(Long paymentId, String paymentReference, String policyNumber, LocalDate paymentDate, LocalDate dueDate, BigDecimal amount, String paymentMode, String paymentStatus, BigDecimal lateFee) {
        this.paymentId = paymentId;
        this.paymentReference = paymentReference;
        this.policyNumber = policyNumber;
        this.paymentDate = paymentDate;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.paymentStatus = paymentStatus;
        this.lateFee = lateFee;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }
}
