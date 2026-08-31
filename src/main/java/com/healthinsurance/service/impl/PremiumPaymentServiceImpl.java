package com.healthinsurance.service.impl;

import com.healthinsurance.dto.PremiumPaymentResponse;
import com.healthinsurance.repository.PremiumPaymentRepository;
import com.healthinsurance.service.PremiumPaymentService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PremiumPaymentServiceImpl implements PremiumPaymentService {

    private final PremiumPaymentRepository repository;

    public PremiumPaymentServiceImpl(PremiumPaymentRepository repository) {
        this.repository = repository;
    }


    /*
     * ============================================================
     * SCENARIO 1 - EASY
     * ============================================================
     *
     * TASK:
     * Get all premium payments.
     *
     * API:
     *
     * GET /api/premium-payments
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Call repository.findAll().
     *
     * 2. You will receive:
     *
     *       List<PremiumPayment>
     *
     * 3. Create a result list:
     *
     *       List<PremiumPaymentResponse>
     *
     * 4. Use a normal for loop.
     *
     * 5. For every payment:
     *
     *       PremiumPayment -> PremiumPaymentResponse
     *
     * 6. Copy payment information into the response.
     *
     * 7. Access the related Policy.
     *
     *       Payment -> Policy
     *
     * 8. Get policy number from the Policy entity.
     *
     * 9. Add the response to the result list.
     *
     * 10. Return the result list.
     *
     * PRACTICE:
     * - findAll()
     * - for loop
     * - Entity -> DTO
     * - nested entity
     * - List
     *
     * DO NOT use Stream API.
     */
    @Override
    public List<PremiumPaymentResponse> getAllPayments() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 2 - EASY
     * ============================================================
     *
     * TASK:
     * Get one payment using paymentId.
     *
     * API:
     *
     * GET /api/premium-payments/{paymentId}
     *
     * EXAMPLE:
     *
     * GET /api/premium-payments/10
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Call:
     *
     *       repository.findById(paymentId)
     *
     * 2. Handle Optional.
     *
     * 3. If payment exists:
     *
     *       Payment -> PaymentResponse
     *
     * 4. Return response.
     *
     * 5. If payment doesn't exist:
     *
     *       throw appropriate not-found exception.
     *
     * DO NOT:
     *
     * return null silently.
     *
     * PRACTICE:
     * - findById()
     * - Optional
     * - if condition
     * - exception handling
     * - DTO mapping
     */
    @Override
    public PremiumPaymentResponse getPaymentById(Long paymentId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 3 - EASY
     * ============================================================
     *
     * TASK:
     * Get all payments belonging to a particular policy.
     *
     * API:
     *
     * GET /api/premium-payments/policy/{policyId}
     *
     * EXAMPLE:
     *
     * policyId = 100
     *
     *
     * RELATIONSHIP:
     *
     * PremiumPayment
     *       |
     *       +---- Policy
     *                |
     *                +---- policyId
     *
     *
     * EXAMPLE DATA:
     *
     * Payment 1 -> Policy 100
     * Payment 2 -> Policy 100
     * Payment 3 -> Policy 200
     * Payment 4 -> Policy 300
     *
     *
     * INPUT:
     *
     * policyId = 100
     *
     * RESULT:
     *
     * Payment 1
     * Payment 2
     *
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all payments.
     *
     * 2. Create result list.
     *
     * 3. Loop through payments.
     *
     * 4. Access payment.getPolicy().
     *
     * 5. Get policy ID.
     *
     * 6. Compare policy ID with input.
     *
     * 7. Add matching payment.
     *
     * 8. Convert entity to DTO.
     *
     * IMPORTANT:
     *
     * Check whether Policy is null before accessing policy ID.
     *
     * PRACTICE:
     * - nested entity access
     * - Long comparison
     * - loop
     * - if
     * - null checking
     */
    @Override
    public List<PremiumPaymentResponse> getPaymentsByPolicy(Long policyId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 4 - EASY
     * ============================================================
     *
     * TASK:
     * Find payments according to payment status.
     *
     * API:
     *
     * GET /api/premium-payments/status?status=SUCCESS
     *
     * POSSIBLE STATUS:
     *
     * SUCCESS
     * FAILED
     * PENDING
     * OVERDUE
     *
     *
     * REQUIREMENT:
     *
     * Status comparison must be case-insensitive.
     *
     *
     * EXAMPLE:
     *
     * Database:
     *
     * SUCCESS
     * FAILED
     * SUCCESS
     * PENDING
     *
     *
     * Input:
     *
     * success
     *
     *
     * Result:
     *
     * All SUCCESS payments.
     *
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Normalize input.
     *
     * 2. Get all payments.
     *
     * 3. Loop through payments.
     *
     * 4. Read payment status.
     *
     * 5. Compare using case-insensitive logic.
     *
     * 6. Add matching payments.
     *
     * PRACTICE:
     * - String.trim()
     * - equalsIgnoreCase()
     * - loop
     * - if
     * - filtering
     */
    @Override
    public List<PremiumPaymentResponse> getPaymentsByStatus(String status) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 5 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Get all FAILED payments.
     *
     * API:
     *
     * GET /api/premium-payments/failed
     *
     *
     * REQUIREMENT:
     *
     * Only payments whose status is FAILED should be returned.
     *
     *
     * EXAMPLE:
     *
     * Payment 1 -> SUCCESS
     * Payment 2 -> FAILED
     * Payment 3 -> PENDING
     * Payment 4 -> FAILED
     *
     *
     * RESULT:
     *
     * Payment 2
     * Payment 4
     *
     *
     * ADDITIONAL CALCULATION:
     *
     * While looping, maintain:
     *
     *       failedPaymentCount
     *
     *
     * Example:
     *
     * FAILED
     * FAILED
     * SUCCESS
     * FAILED
     *
     * failedPaymentCount = 3
     *
     *
     * IMPORTANT:
     *
     * The main API result remains the list of failed payments.
     *
     * The purpose of the counter is to practice Core Java
     * accumulation logic.
     *
     *
     * PRACTICE:
     * - loop
     * - counter
     * - if
     * - String comparison
     * - DTO mapping
     */
    @Override
    public List<PremiumPaymentResponse> getFailedPayments() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 6 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Get all PENDING payments.
     *
     * API:
     *
     * GET /api/premium-payments/pending
     *
     *
     * REQUIREMENT:
     *
     * Only return payments whose status is PENDING.
     *
     *
     * ADDITIONAL CALCULATION:
     *
     * Calculate:
     *
     *       totalPendingAmount
     *
     *
     * Formula:
     *
     *       totalPendingAmount =
     *
     *       payment1.amount
     *       + payment2.amount
     *       + payment3.amount
     *       + ...
     *
     *
     * EXAMPLE:
     *
     * Payment 1 -> PENDING -> 10,000
     * Payment 2 -> SUCCESS -> 20,000
     * Payment 3 -> PENDING -> 15,000
     * Payment 4 -> PENDING -> 5,000
     *
     *
     * Total pending amount:
     *
     * 10,000 + 15,000 + 5,000
     *
     * = 30,000
     *
     *
     * WHAT YOU NEED TO PRACTICE:
     *
     * Create an accumulator:
     *
     *       BigDecimal totalPendingAmount
     *
     *
     * Every time you find a PENDING payment:
     *
     *       add payment amount
     *
     *
     * IMPORTANT:
     *
     * BigDecimal should be used for money calculations.
     *
     * Do not use double for payment amounts.
     *
     *
     * NULL CASE:
     *
     * What if payment amount is null?
     *
     * Handle it safely.
     *
     *
     * PRACTICE:
     * - BigDecimal
     * - add()
     * - accumulator
     * - loop
     * - if
     * - null handling
     */
    @Override
    public List<PremiumPaymentResponse> getPendingPayments() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 7 - HARD
     * ============================================================
     *
     * TASK:
     * Find LATE PAYMENTS and perform payment risk analysis.
     *
     * API:
     *
     * GET /api/premium-payments/late
     *
     *
     * A payment is considered LATE when:
     *
     *       status = OVERDUE
     *
     * OR
     *
     *       lateFee > 0
     *
     *
     * IMPORTANT:
     *
     * This is an OR condition.
     *
     *
     * Example:
     *
     * Payment A:
     *
     * status = OVERDUE
     * lateFee = 0
     *
     * Result:
     *
     * INCLUDED
     *
     *
     * Payment B:
     *
     * status = SUCCESS
     * lateFee = 500
     *
     * Result:
     *
     * INCLUDED
     *
     *
     * Payment C:
     *
     * status = SUCCESS
     * lateFee = 0
     *
     * Result:
     *
     * EXCLUDED
     *
     *
     * ============================================================
     * PART 1 - FIND LATE PAYMENTS
     * ============================================================
     *
     * Loop through all payments.
     *
     * Check:
     *
     *       status == OVERDUE
     *
     * OR
     *
     *       lateFee > 0
     *
     *
     * ============================================================
     * PART 2 - CALCULATE DAYS OVERDUE
     * ============================================================
     *
     * Compare:
     *
     *       dueDate
     *
     * and
     *
     *       paymentDate
     *
     *
     * Example:
     *
     * dueDate:
     *
     * 2026-08-01
     *
     * paymentDate:
     *
     * 2026-08-10
     *
     * daysOverdue:
     *
     * 9 days
     *
     *
     * You can use LocalDate and date arithmetic.
     *
     *
     * IMPORTANT:
     *
     * If paymentDate is null because payment hasn't been made,
     * think about what date should be used to determine whether
     * it is currently overdue.
     *
     * This is intentionally part of the business-logic exercise.
     *
     *
     * ============================================================
     * PART 3 - CALCULATE TOTAL OUTSTANDING
     * ============================================================
     *
     * Formula:
     *
     *       outstandingAmount =
     *
     *       paymentAmount + lateFee
     *
     *
     * Example:
     *
     * paymentAmount = 20,000
     *
     * lateFee = 1,000
     *
     * outstandingAmount = 21,000
     *
     *
     * Use BigDecimal.
     *
     * Do not use double.
     *
     *
     * ============================================================
     * PART 4 - SEVERITY CLASSIFICATION
     * ============================================================
     *
     * After calculating days overdue, classify the payment.
     *
     *
     * LOW:
     *
     * daysOverdue <= 7
     *
     *
     * MEDIUM:
     *
     * daysOverdue >= 8
     *
     * AND
     *
     * daysOverdue <= 30
     *
     *
     * HIGH:
     *
     * daysOverdue > 30
     *
     *
     * Example:
     *
     * 3 days  -> LOW
     * 7 days  -> LOW
     * 8 days  -> MEDIUM
     * 20 days -> MEDIUM
     * 30 days -> MEDIUM
     * 31 days -> HIGH
     * 60 days -> HIGH
     *
     *
     * ============================================================
     * PART 5 - EDGE CASES
     * ============================================================
     *
     * Think about:
     *
     * 1. lateFee = null
     *
     * 2. paymentAmount = null
     *
     * 3. dueDate = null
     *
     * 4. paymentDate = null
     *
     * 5. paymentDate before dueDate
     *
     * 6. status = null
     *
     *
     * Your service should not unexpectedly throw
     * NullPointerException.
     *
     *
     * ============================================================
     * PRACTICE
     * ============================================================
     *
     * This scenario is designed to practice:
     *
     * - for loop
     * - OR condition
     * - String comparison
     * - BigDecimal.add()
     * - BigDecimal.compareTo()
     * - LocalDate
     * - date difference
     * - nested if
     * - if / else-if / else
     * - temporary variables
     * - null handling
     * - business classification
     * - Core Java logic
     *
     *
     * DO NOT use Stream API.
     *
     * First solve everything using normal Java loops.
     */
    @Override
    public List<PremiumPaymentResponse> getLatePayments() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }
}