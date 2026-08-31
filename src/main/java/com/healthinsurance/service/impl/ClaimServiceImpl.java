package com.healthinsurance.service.impl;

import com.healthinsurance.dto.*;
import com.healthinsurance.repository.ClaimRepository;
import com.healthinsurance.service.ClaimService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repository;

    public ClaimServiceImpl(ClaimRepository repository) {
        this.repository = repository;
    }

    /*
     * ============================================================
     * SCENARIO 1 - EASY
     * ============================================================
     *
     * METHOD:
     * getAllClaims()
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all Claim records from the database.
     *
     * 2. repository.findAll() will give you:
     *
     *       List<Claim>
     *
     * 3. Create an empty List<ClaimResponse>.
     *
     * 4. Use a loop:
     *
     *       for (Claim claim : claims)
     *
     * 5. For every Claim, create a ClaimResponse.
     *
     * 6. Copy these values:
     *
     *       claimId
     *       claimNumber
     *       claimType
     *       claimStatus
     *       claimedAmount
     *       approvedAmount
     *       rejectedAmount
     *       admissionDate
     *       dischargeDate
     *
     * 7. Also get data from connected objects:
     *
     *       claim.getPolicy().getCustomer()
     *       claim.getMember().getMemberName()
     *       claim.getHospital().getHospitalName()
     *
     * 8. Add the ClaimResponse to your result list.
     *
     * 9. Return the result list.
     *
     * PRACTICE:
     * - repository.findAll()
     * - for loop
     * - object navigation
     * - DTO mapping
     * - ArrayList
     */
    @Override
    public List<ClaimResponse> getAllClaims() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 2 - EASY
     * ============================================================
     *
     * METHOD:
     * getClaimById(Long claimId)
     *
     * EXAMPLE:
     *
     * User calls:
     *
     * GET /api/claims/10
     *
     * You need to find Claim ID = 10.
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Call repository.findById(claimId).
     *
     * 2. findById() returns Optional<Claim>.
     *
     * 3. Check whether the claim exists.
     *
     * 4. If claim does NOT exist:
     *
     *       throw RuntimeException
     *
     *    with a useful message like:
     *
     *       "Claim not found"
     *
     * 5. If claim exists:
     *
     *       convert Claim -> ClaimResponse
     *
     * 6. Return ClaimResponse.
     *
     * PRACTICE:
     * - Optional
     * - if condition
     * - findById()
     * - DTO mapping
     */
    @Override
    public ClaimResponse getClaimById(Long claimId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 3 - EASY
     * ============================================================
     *
     * METHOD:
     * getClaimsByPolicy(Long policyId)
     *
     * RELATIONSHIP:
     *
     * Claim
     *   |
     *   +---- Policy
     *
     * Every Claim has a Policy.
     *
     * Example:
     *
     * Claim 1 -> Policy 1
     * Claim 2 -> Policy 1
     * Claim 3 -> Policy 2
     * Claim 4 -> Policy 3
     *
     * If user asks:
     *
     * policyId = 1
     *
     * Result should contain:
     *
     * Claim 1
     * Claim 2
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all claims.
     *
     * 2. Create result list.
     *
     * 3. Loop through every claim.
     *
     * 4. For each claim:
     *
     *       claim.getPolicy().getPolicyId()
     *
     * 5. Compare it with:
     *
     *       policyId
     *
     * 6. If equal:
     *
     *       add claim to result
     *
     * 7. Convert every matching Claim into ClaimResponse.
     *
     * 8. Return result.
     *
     * PRACTICE:
     * - for loop
     * - if
     * - nested object
     * - Long comparison
     */
    @Override
    public List<ClaimResponse> getClaimsByPolicy(Long policyId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 4 - EASY -> MEDIUM
     * ============================================================
     *
     * METHOD:
     * getClaimsByCustomer(Long customerId)
     *
     * THIS IS IMPORTANT.
     *
     * Claim does NOT directly contain customerId.
     *
     * Relationship is:
     *
     * Claim
     *   |
     *   +---- Policy
     *           |
     *           +---- Customer
     *
     * So you need to go:
     *
     * claim
     *   -> policy
     *       -> customer
     *           -> customerId
     *
     * Example:
     *
     * Customer 1
     *    |
     *    +-- Policy 1
     *    |      |
     *    |      +-- Claim 1
     *    |      +-- Claim 2
     *    |
     *    +-- Policy 5
     *           |
     *           +-- Claim 10
     *
     * If customerId = 1,
     *
     * result:
     *
     * Claim 1
     * Claim 2
     * Claim 10
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all claims.
     *
     * 2. Loop through claims.
     *
     * 3. For every claim:
     *
     *       get Policy
     *
     * 4. From Policy:
     *
     *       get Customer
     *
     * 5. From Customer:
     *
     *       get customerId
     *
     * 6. Compare customerId with input customerId.
     *
     * 7. If equal:
     *
     *       add to result.
     *
     * 8. Handle null values safely.
     *
     * PRACTICE:
     * - nested objects
     * - nested conditions
     * - null checking
     * - loops
     */
    @Override
    public List<ClaimResponse> getClaimsByCustomer(Long customerId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 5 - MEDIUM
     * ============================================================
     *
     * METHOD:
     * getClaimsByStatus(String status)
     *
     * DATABASE EXAMPLES:
     *
     * SETTLED
     * APPROVED
     * PENDING
     * REJECTED
     *
     * User may send:
     *
     * "settled"
     *
     * but database contains:
     *
     * "SETTLED"
     *
     * Therefore comparison should be case-insensitive.
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all claims.
     *
     * 2. Loop through claims.
     *
     * 3. Get:
     *
     *       claim.getClaimStatus()
     *
     * 4. Compare it with input status.
     *
     * 5. Ignore upper/lower case.
     *
     * 6. Matching claims should be added to result.
     *
     * Example:
     *
     * Input:
     *
     *     "approved"
     *
     * Result:
     *
     * APPROVED claims only.
     *
     * PRACTICE:
     * - String
     * - trim()
     * - equalsIgnoreCase()
     * - if
     * - loop
     */
    @Override
    public List<ClaimResponse> getClaimsByStatus(String status) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 6 - MEDIUM
     * ============================================================
     *
     * METHOD:
     * getClaimsByHospital(Long hospitalId)
     *
     * RELATIONSHIP:
     *
     * Claim
     *   |
     *   +---- Hospital
     *
     * Every claim belongs to a hospital.
     *
     * Example:
     *
     * Claim 1 -> Hospital 10
     * Claim 2 -> Hospital 10
     * Claim 3 -> Hospital 20
     *
     * Input:
     *
     * hospitalId = 10
     *
     * Result:
     *
     * Claim 1
     * Claim 2
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all claims.
     *
     * 2. Loop through claims.
     *
     * 3. Get:
     *
     *       claim.getHospital().getHospitalId()
     *
     * 4. Compare with input hospitalId.
     *
     * 5. If equal:
     *
     *       add to result.
     *
     * PRACTICE:
     * - nested object
     * - Long comparison
     * - loop
     * - if
     */
    @Override
    public List<ClaimResponse> getClaimsByHospital(Long hospitalId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 7 - MEDIUM
     * ============================================================
     *
     * METHOD:
     * getClaimsByClaimType(String claimType)
     *
     * POSSIBLE TYPES:
     *
     * CASHLESS
     * REIMBURSEMENT
     *
     * User sends:
     *
     *     cashless
     *
     * Database:
     *
     *     CASHLESS
     *
     * You should still find the claim.
     *
     * WHAT YOU HAVE TO DO:
     *
     * 1. Get all claims.
     *
     * 2. Loop through claims.
     *
     * 3. Get:
     *
     *       claim.getClaimType()
     *
     * 4. Compare with input.
     *
     * 5. Ignore case.
     *
     * 6. Add matching claims.
     *
     * BONUS:
     *
     * If claimType is neither:
     *
     *     CASHLESS
     *     REIMBURSEMENT
     *
     * you can decide whether to:
     *
     * - return empty list
     * OR
     * - throw IllegalArgumentException
     *
     * PRACTICE:
     * - String normalization
     * - if/else
     * - loop
     * - validation
     */
    @Override
    public List<ClaimResponse> getClaimsByClaimType(String claimType) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 8 - MEDIUM -> HARD
     * ============================================================
     *
     * METHOD:
     * getHighValueClaims(BigDecimal amount)
     *
     * MAIN REQUIREMENT:
     *
     * Find claims where:
     *
     *     claimedAmount > input amount
     *
     * Example:
     *
     * Input:
     *
     *     amount = 100000
     *
     * Claim amounts:
     *
     *     50000   -> ignore
     *     100000  -> ignore
     *     150000  -> include
     *     250000  -> include
     *
     * IMPORTANT:
     *
     * Use BigDecimal.compareTo().
     *
     * Do NOT use:
     *
     *     >
     *
     * directly with BigDecimal.
     *
     *
     * ADDITIONAL CALCULATION:
     *
     * For every matching claim calculate:
     *
     * approvedPercentage =
     *
     * approvedAmount
     * ---------------- × 100
     * claimedAmount
     *
     * Example:
     *
     * claimedAmount = 200000
     * approvedAmount = 150000
     *
     * approvedPercentage =
     *
     * 150000 / 200000 × 100
     *
     * = 75%
     *
     * You don't necessarily need to add this field to the DTO.
     *
     * The purpose is to practice the calculation.
     *
     * NULL CASE:
     *
     * What if:
     *
     * claimedAmount = null
     *
     * or
     *
     * approvedAmount = null
     *
     * or
     *
     * claimedAmount = 0
     *
     * Your code should NOT crash.
     *
     * PRACTICE:
     * - BigDecimal.compareTo()
     * - BigDecimal.divide()
     * - BigDecimal.multiply()
     * - BigDecimal constants
     * - null checking
     * - loop
     * - calculation
     */
    @Override
    public List<ClaimResponse> getHighValueClaims(BigDecimal amount) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 9 - HARD
     * ============================================================
     *
     * METHOD:
     * getClaimsByDateRange(String startDate, String endDate)
     *
     * INPUT:
     *
     * startDate = "2026-06-01"
     *
     * endDate = "2026-06-30"
     *
     * STEP 1:
     *
     * Convert String into LocalDate.
     *
     * Example concept:
     *
     * "2026-06-01"
     *       ↓
     * LocalDate
     *
     * STEP 2:
     *
     * Validate:
     *
     * startDate <= endDate
     *
     * If:
     *
     * startDate = 2026-06-30
     * endDate   = 2026-06-01
     *
     * this is invalid.
     *
     * You should throw an exception.
     *
     * STEP 3:
     *
     * Get all claims.
     *
     * STEP 4:
     *
     * Loop through every claim.
     *
     * STEP 5:
     *
     * Get:
     *
     * claim.getAdmissionDate()
     *
     * STEP 6:
     *
     * Check whether admissionDate is inside the range.
     *
     * Example:
     *
     * Start = 01 June
     * End   = 30 June
     *
     * Admission:
     *
     * 05 June  -> INCLUDE
     * 15 June  -> INCLUDE
     * 30 June  -> INCLUDE
     * 01 July  -> EXCLUDE
     * 31 May   -> EXCLUDE
     *
     * STEP 7:
     *
     * Additional calculation:
     *
     * processingDays =
     *
     * dischargeDate - admissionDate
     *
     * Example:
     *
     * Admission = 10 June
     * Discharge = 15 June
     *
     * Processing/stay days = 5
     *
     * Use LocalDate date calculation.
     *
     * STEP 8:
     *
     * Handle null dates.
     *
     * What if:
     *
     * admissionDate = null
     *
     * or
     *
     * dischargeDate = null
     *
     * Don't allow NullPointerException.
     *
     * IMPORTANT:
     *
     * This scenario combines:
     *
     * - String parsing
     * - LocalDate
     * - date comparison
     * - date calculation
     * - loops
     * - if conditions
     * - validation
     * - null handling
     *
     * This is your first HARD scenario.
     */
    @Override
    public List<ClaimResponse> getClaimsByDateRange(
            String startDate,
            String endDate) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }
}