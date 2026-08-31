package com.healthinsurance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "insurance_products")
public class InsuranceProduct {

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "coverage_type")
    private String coverageType;

    @Column(name = "base_sum_insured")
    private BigDecimal baseSumInsured;

    @Column(name = "base_premium")
    private BigDecimal basePremium;

    @Column(name = "min_age")
    private Integer minAge;

    @Column(name = "max_age")
    private Integer maxAge;

    @Column(name = "waiting_period_months")
    private Integer waitingPeriodMonths;

    @Column(name = "room_rent_limit")
    private BigDecimal roomRentLimit;

    @Column(name = "co_payment_percent")
    private BigDecimal coPaymentPercent;

    @Column(name = "product_status")
    private String productStatus;

    public InsuranceProduct() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public void setCoverageType(String coverageType) {
        this.coverageType = coverageType;
    }

    public BigDecimal getBaseSumInsured() {
        return baseSumInsured;
    }

    public void setBaseSumInsured(BigDecimal baseSumInsured) {
        this.baseSumInsured = baseSumInsured;
    }

    public BigDecimal getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(BigDecimal basePremium) {
        this.basePremium = basePremium;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }

    public Integer getWaitingPeriodMonths() {
        return waitingPeriodMonths;
    }

    public void setWaitingPeriodMonths(Integer waitingPeriodMonths) {
        this.waitingPeriodMonths = waitingPeriodMonths;
    }

    public BigDecimal getRoomRentLimit() {
        return roomRentLimit;
    }

    public void setRoomRentLimit(BigDecimal roomRentLimit) {
        this.roomRentLimit = roomRentLimit;
    }

    public BigDecimal getCoPaymentPercent() {
        return coPaymentPercent;
    }

    public void setCoPaymentPercent(BigDecimal coPaymentPercent) {
        this.coPaymentPercent = coPaymentPercent;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
