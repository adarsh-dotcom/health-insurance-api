package com.healthinsurance.service;

import com.healthinsurance.dto.ClaimResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ClaimService {
    List<ClaimResponse> getAllClaims();

    ClaimResponse getClaimById(Long claimId);

    List<ClaimResponse> getClaimsByPolicy(Long policyId);

    List<ClaimResponse> getClaimsByCustomer(Long customerId);

    List<ClaimResponse> getClaimsByStatus(String status);

    List<ClaimResponse> getClaimsByHospital(Long hospitalId);

    List<ClaimResponse> getClaimsByClaimType(String claimType);

    List<ClaimResponse> getHighValueClaims(BigDecimal amount);

    List<ClaimResponse> getClaimsByDateRange(String startDate, String endDate);
}
