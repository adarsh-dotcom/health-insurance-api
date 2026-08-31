package com.healthinsurance.service;

import com.healthinsurance.dto.PremiumPaymentResponse;

import java.util.List;

public interface PremiumPaymentService {

    List<PremiumPaymentResponse> getAllPayments();

    PremiumPaymentResponse getPaymentById(Long paymentId);

    List<PremiumPaymentResponse> getPaymentsByPolicy(Long policyId);

    List<PremiumPaymentResponse> getPaymentsByStatus(String status);

    List<PremiumPaymentResponse> getFailedPayments();

    List<PremiumPaymentResponse> getPendingPayments();

    List<PremiumPaymentResponse> getLatePayments();
}