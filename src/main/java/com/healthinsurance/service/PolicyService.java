package com.healthinsurance.service;

import com.healthinsurance.dto.PolicyResponse;

import java.math.BigDecimal;
import java.util.List;

public interface PolicyService {

    List<PolicyResponse> getAllPolicies();

    PolicyResponse getPolicyById(Long policyId);

    List<PolicyResponse> getPoliciesByCustomer(Long customerId);

    List<PolicyResponse> getPoliciesByStatus(String status);

    List<PolicyResponse> getPoliciesByProduct(Long productId);

    List<PolicyResponse> getPoliciesByPremiumRange(
            BigDecimal minPremium,
            BigDecimal maxPremium);

    List<PolicyResponse> getExpiringPolicies(int days);

    List<PolicyResponse> getPoliciesByRenewalStatus(
            String renewalStatus);
}