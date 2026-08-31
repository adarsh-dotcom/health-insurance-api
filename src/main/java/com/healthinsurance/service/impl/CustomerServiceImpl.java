package com.healthinsurance.service.impl;

import com.healthinsurance.dto.*;
import com.healthinsurance.entity.Customer;
import com.healthinsurance.repository.CustomerRepository;
import com.healthinsurance.service.CustomerService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer createCustomer(Customer customer) {

        // Created time automatically set hoga
        customer.setCreatedAt(LocalDateTime.now());

        return customerRepository.save(customer);
    }

    /*
     * ============================================================
     * SCENARIO 1 - EASY
     * ============================================================
     *
     * TASK:
     * Get all customers from the database.
     *
     * API EXAMPLE:
     *
     * GET /api/customers
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Fetch all customers using CustomerRepository.
     *
     * 2. You will receive a List<Customer>.
     *
     * 3. Create a List<CustomerResponse> for the final result.
     *
     * 4. Use a normal FOR loop.
     *
     * 5. For every Customer, create a CustomerResponse.
     *
     * 6. Copy the required customer information from Entity to DTO.
     *
     * 7. Add every CustomerResponse to the result list.
     *
     * 8. Return the result.
     *
     * PRACTICE:
     * - repository.findAll()
     * - for loop
     * - DTO mapping
     * - List
     *
     * DO NOT USE:
     * - Stream API
     * - complicated query
     *
     * GOAL:
     * Learn the basic:
     *
     * Database -> Entity -> Loop -> DTO -> Response
     */
    @Override
    public List<CustomerResponse> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponse> finalResponse = new ArrayList<>();

        for (Customer customer : customers) {

            CustomerResponse response = new CustomerResponse();

            response.setCustomerId(customer.getCustomerId());
            response.setCustomerCode(customer.getCustomerCode());
            response.setCustomerStatus(customer.getCustomerCode());
            response.setCity(customer.getCity());
            response.setState(customer.getState());

            finalResponse.add(response);

        }

        return finalResponse;


    }


    /*
     * ============================================================
     * SCENARIO 2 - EASY
     * ============================================================
     *
     * TASK:
     * Get one customer using customerId.
     *
     * API EXAMPLE:
     *
     * GET /api/customers/10
     *
     * INPUT:
     *
     * customerId = 10
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Search for the customer using customerId.
     *
     * 2. Repository findById() returns Optional<Customer>.
     *
     * 3. Check whether the customer exists.
     *
     * 4. If customer exists:
     *
     *       Convert Customer -> CustomerResponse
     *
     * 5. Return CustomerResponse.
     *
     * 6. If customer does not exist:
     *
     *       throw an appropriate exception.
     *
     * EXAMPLE:
     *
     * customerId = 1
     *
     * If customer 9999 1 not exist,
     * don't return null.
     *
     * PRACTICE:
     * - findById()
     * - Optional
     * - if condition
     * - exception handling
     * - DTO mapping
     *
     * CORE JAVA CONCEPT:
     *
     * Optional<Customer>
     *
     * means the result may or may not contain a Customer.
     */
    @Override
    public CustomerResponse getCustomerById(Long customerId) {

        Optional<Customer> byId = customerRepository.findById(customerId);


        if (byId.isEmpty()) {
            throw new RuntimeException("Customer Not Fount :" + customerId);
        }

        Customer customer = byId.get();

        CustomerResponse customerResponse = new CustomerResponse();

        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setCustomerCode(customer.getCustomerCode());
        customerResponse.setCity(customer.getCity());
        customerResponse.setState(customer.getState());
        customerResponse.setCustomerStatus(customer.getCustomerStatus());
        customerResponse.setFullName(customer.getFirstName().concat(customer.getLastName()));

        return customerResponse;


    }


    /*
     * ============================================================
     * SCENARIO 3 - EASY
     * ============================================================
     *
     * TASK:
     * Find customers by CITY.
     *
     * API EXAMPLE:
     *
     * GET /api/customers/city?city=Mumbai
     *
     * INPUT:
     *
     * city = "Mumbai"
     *
     * DATABASE:
     *
     * Mumbai
     * Mumbai
     * Pune
     * Delhi
     *
     * RESULT:
     *
     * Mumbai customers only.
     *
     * IMPORTANT:
     *
     * User may send:
     *
     *     "mumbai"
     *
     * Database may contain:
     *
     *     "Mumbai"
     *
     * These should be considered the same.
     *
     * Also handle extra spaces:
     *
     *     "  Mumbai  "
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all customers.
     *
     * 2. Normalize the input city.
     *
     * 3. Loop through all customers.
     *
     * 4. Read customer city.
     *
     * 5. Compare customer city with requested city.
     *
     * 6. Comparison should ignore case.
     *
     * 7. Matching customers should be added to result.
     *
     * PRACTICE:
     * - String.trim()
     * - equalsIgnoreCase()
     * - for loop
     * - if condition
     * - List
     */
    @Override
    public List<CustomerResponse> getCustomersByCity(String city) {

        List<Customer> customerList = customerRepository.findByCityIgnoreCase(city);
        List<CustomerResponse>  customerResponse = new ArrayList<>();


        for (Customer customer : customerList) {

            CustomerResponse response = new CustomerResponse();

            response.setCustomerId(customer.getCustomerId());
            response.setFullName(customer.getFirstName().concat(customer.getLastName()));
            response.setCity(customer.getCity());

            customerResponse.add(response);

        }
       return customerResponse;
    }


    /*
     * ============================================================
     * SCENARIO 4 - EASY
     * ============================================================
     *
     * TASK:
     * Find customers by STATE.
     *
     * API EXAMPLE:
     *
     * GET /api/customers/state?state=Maharashtra
     *
     * INPUT:
     *
     * state = "Maharashtra"
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all customers.
     *
     * 2. Loop through every customer.
     *
     * 3. Get customer's state.
     *
     * 4. Compare customer's state with input state.
     *
     * 5. Comparison should ignore uppercase/lowercase.
     *
     * 6. Add matching customers to result.
     *
     * EXAMPLE:
     *
     * Database:
     *
     * Adarsh  -> Maharashtra
     * Rahul   -> Maharashtra
     * Amit    -> Gujarat
     * Rohit   -> Delhi
     *
     * Input:
     *
     * Maharashtra
     *
     * Result:
     *
     * Adarsh
     * Rahul
     *
     * PRACTICE:
     * - for loop
     * - if
     * - else
     * - equalsIgnoreCase()
     * - DTO mapping
     */
    @Override
    public List<CustomerResponse> getCustomersByState(String state) {

        List<Customer> byStateIgnoreCase = customerRepository.findByStateIgnoreCase(state);

        List<CustomerResponse> finalResponse = new ArrayList<>();

        for (Customer customer: byStateIgnoreCase) {

            CustomerResponse response = new CustomerResponse();
            response.setCustomerId(customer.getCustomerId());
            response.setState(customer.getState());

            finalResponse.add(response);

        }

        return finalResponse;
    }


    /*
     * ============================================================
     * SCENARIO 5 - EASY -> MEDIUM
     * ============================================================
     *
     * TASK:
     * Find customers whose annual income is greater than
     * or equal to a given minimum income.
     *
     * API EXAMPLE:
     *
     * GET /api/customers/high-income?minimumIncome=1000000
     *
     * INPUT:
     *
     * minimumIncome = 10,00,000
     *
     * CUSTOMER DATA:
     *
     * Customer A -> 500,000
     * Customer B -> 1,000,000
     * Customer C -> 1,500,000
     *
     * RESULT:
     *
     * Customer B
     * Customer C
     *
     * IMPORTANT:
     *
     * annualIncome is BigDecimal.
     *
     * Therefore use:
     *
     * BigDecimal.compareTo()
     *
     * Do not use:
     *
     * annualIncome >= minimumIncome
     *
     * because BigDecimal is an Object.
     *
     * CONDITION:
     *
     * annualIncome >= minimumIncome
     *
     * means:
     *
     * include equal value also.
     *
     * PRACTICE:
     * - BigDecimal
     * - compareTo()
     * - for loop
     * - if
     * - filtering
     */
    @Override
    public List<CustomerResponse> getHighIncomeCustomers(BigDecimal minimumIncome) {




        throw new UnsupportedOperationException("Implement service logic");
    }

    @Override
    public List<CustomerResponse> getCustomersByAgeRange(Integer minAge, Integer maxAge) {
        return List.of();
    }


    /*
     * ============================================================
     * SCENARIO 6 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Find customers whose AGE is inside a given range.
     *
     * API EXAMPLE:
     *
     * GET /api/customers/age-range?minAge=25&maxAge=40
     *
     * INPUT:
     *
     * minAge = 25
     * maxAge = 40
     *
     * REQUIREMENT:
     *
     * Customer age must satisfy:
     *
     * age >= 25
     * AND
     * age <= 40
     *
     * IMPORTANT:
     *
     * Don't simply calculate:
     *
     * currentYear - birthYear
     *
     * because birthday may not have happened yet this year.
     *
     * Example:
     *
     * Date of birth:
     *
     * 15 December 1995
     *
     * Today:
     *
     * 10 August 2026
     *
     * Simple calculation:
     *
     * 2026 - 1995 = 31
     *
     * But the customer is actually:
     *
     * 30
     *
     * because the birthday is still coming.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get today's date.
     *
     * 2. Get customer's dateOfBirth.
     *
     * 3. Calculate initial age.
     *
     * 4. Check whether birthday has occurred this year.
     *
     * 5. If birthday hasn't occurred:
     *
     *       subtract 1 from age.
     *
     * 6. Check:
     *
     *       age >= minAge
     *       AND
     *       age <= maxAge
     *
     * 7. Add matching customers.
     *
     * PRACTICE:
     * - LocalDate
     * - Period or date arithmetic
     * - if
     * - nested conditions
     * - AND condition
     * - boundary conditions
     * - loop
     *
     * IMPORTANT:
     *
     * 25 and 40 are INCLUDED.
     */
//    @Override
//    public List<CustomerResponse> getCustomersByAgeRange(
//            int minAge,
//            int maxAge) {
//
//        // TODO: Implement the business logic yourself.
//
//        throw new UnsupportedOperationException("Implement service logic");
//    }


    /*
     * ============================================================
     * SCENARIO 7 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Find customers who have AT LEAST ONE ACTIVE POLICY.
     *
     * RELATIONSHIP:
     *
     * Customer
     *     |
     *     +---- Policy
     *              |
     *              +---- policyStatus
     *
     * Example:
     *
     * Customer A:
     *
     *     Policy 1 -> ACTIVE
     *     Policy 2 -> EXPIRED
     *
     * Customer B:
     *
     *     Policy 3 -> EXPIRED
     *
     * Customer C:
     *
     *     Policy 4 -> ACTIVE
     *
     * Result:
     *
     * Customer A
     * Customer C
     *
     * WHY?
     *
     * Customer A has at least one ACTIVE policy.
     * Customer C has at least one ACTIVE policy.
     * Customer B has no ACTIVE policy.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get customers.
     *
     * 2. For each customer, get their policies.
     *
     * 3. Use a second loop for policies.
     *
     * 4. Create a boolean variable:
     *
     *       hasActivePolicy
     *
     * 5. Initially:
     *
     *       false
     *
     * 6. If policy status is ACTIVE:
     *
     *       change flag to true
     *
     * 7. You can use break because you don't need to check
     *    remaining policies once ACTIVE is found.
     *
     * 8. After policy loop:
     *
     *       if hasActivePolicy == true
     *
     *    add customer to result.
     *
     * PRACTICE:
     * - nested for loop
     * - boolean variable
     * - break
     * - if
     * - relationship traversal
     *
     * IMPORTANT:
     *
     * One customer should appear only ONCE.
     */
    @Override
    public List<CustomerResponse> getCustomersWithActivePolicy() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }

    @Override
    public List<CustomerResponse> getCustomersWithNoActivePolicy() {
        return List.of();
    }


    /*
     * ============================================================
     * SCENARIO 8 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Find customers who DO NOT have any ACTIVE policy.
     *
     * This is the opposite of Scenario 7.
     *
     * Example:
     *
     * Customer A:    ACTIVE
     *
     * Customer B:
     *     EXPIRED
     *
     * Customer C:
     *     EXPIRED
     *     CANCELLED
     *
     * Result:
     *
     * Customer B
     * Customer C
     *
     * Customer A must NOT be returned.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get customers.
     *
     * 2. For each customer, check all policies.
     *
     * 3. Start with:
     *
     *       hasActivePolicy = false
     *
     * 4. If you find ACTIVE:
     *
     *       hasActivePolicy = true
     *
     *       break
     *
     * 5. After checking policies:
     *
     *       if hasActivePolicy == false
     *
     *    add customer.
     *
     * THINKING PRACTICE:
     *
     * Scenario 7:
     *
     *       if active -> ADD
     *
     * Scenario 8:
     *
     *       if NOT active -> ADD
     *
     * PRACTICE:
     * - nested loops
     * - boolean flag
     * - break
     * - logical NOT
     * - if condition
     * - relationship handling
     */
//    @Override
//    public List<CustomerResponse> getCustomersWithoutActivePolicy() {
//
//        // TODO: Implement the business logic yourself.
//
//        throw new UnsupportedOperationException("Implement service logic");
//    }


    /*
     * ============================================================
     * SCENARIO 9 - MEDIUM -> HARD
     * ============================================================
     *
     * TASK:
     * Find customers whose TOTAL CLAIMED AMOUNT is greater than
     * a given amount.
     *
     * THIS SCENARIO HAS MULTIPLE TABLE RELATIONSHIPS.
     *
     * Relationship:
     *
     * Customer
     *     |
     *     +---- Policy
     *              |
     *              +---- Claim
     *
     * Example:
     *
     * Customer A
     *
     * Policy 1
     *     Claim 1 = 50,000
     *     Claim 2 = 30,000
     *
     * Policy 2
     *     Claim 3 = 40,000
     *
     * TOTAL:
     *
     * 50,000 + 30,000 + 40,000
     *
     * = 120,000
     *
     * If input amount is:
     *
     * 100,000
     *
     * Customer A should be returned.
     *
     * IMPORTANT:
     *
     * You are NOT checking one claim.
     *
     * You must calculate ALL claims belonging to ALL policies
     * of the customer.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Loop through customers.
     *
     * 2. For every customer create:
     *
     *       totalClaimedAmount
     *
     *    starting from zero.
     *
     * 3. Loop through customer's policies.
     *
     * 4. For every policy, loop through its claims.
     *
     * 5. Add claimedAmount to totalClaimedAmount.
     *
     * 6. After processing all policies:
     *
     *       totalClaimedAmount > amount
     *
     * 7. If condition is true:
     *
     *       add customer.
     *
     * IMPORTANT:
     *
     * Use BigDecimal.
     *
     * Do not use:
     *
     * double
     * float
     *
     * for money calculations.
     *
     * NULL CASE:
     *
     * If claimedAmount is null,
     * don't let the application crash.
     *
     * Decide how your business logic should handle it.
     *
     * PRACTICE:
     * - 3-level nested loops
     * - BigDecimal
     * - add()
     * - compareTo()
     * - accumulator
     * - null checking
     * - filtering
     *
     * THIS IS YOUR FIRST REAL BUSINESS LOGIC SCENARIO.
     */
    @Override
    public List<CustomerResponse> getCustomersWithHighClaimAmount(
            BigDecimal amount) {

        // TODO: Implement the business logic yourself.


        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 10 - HARD
     * ============================================================
     *
     * TASK:
     * Perform CUSTOMER RISK ANALYSIS.
     *
     * INPUTS:
     *
     * city
     * minimumIncome
     *
     * API EXAMPLE:
     *
     * GET /api/customers/risk-analysis
     *     ?city=Mumbai
     *     &minimumIncome=500000
     *
     *
     * STEP 1 - FILTER CUSTOMER
     * ------------------------
     *
     * Customer must satisfy BOTH:
     *
     *     city matches input
     *
     * AND
     *
     *     annualIncome >= minimumIncome
     *
     *
     * Example:
     *
     * city = Mumbai
     * minimumIncome = 500,000
     *
     *
     * STEP 2 - CALCULATE TOTAL POLICIES
     * ----------------------------------
     *
     * For every matching customer:
     *
     * count all policies belonging to that customer.
     *
     * Example:
     *
     * Customer A:
     *
     * Policy 1
     * Policy 2
     * Policy 3
     *
     * totalPolicies = 3
     *
     *
     * STEP 3 - CALCULATE TOTAL CLAIMED AMOUNT
     * ----------------------------------------
     *
     * Go through:
     *
     * Customer
     *    ↓
     * Policies
     *    ↓
     * Claims
     *
     * Add every claimedAmount.
     *
     * Example:
     *
     * Policy 1:
     *     Claim = 50,000
     *
     * Policy 2:
     *     Claim = 30,000
     *
     * Policy 3:
     *     Claim = 20,000
     *
     * totalClaimed = 100,000
     *
     *
     * STEP 4 - CALCULATE TOTAL SUM INSURED
     * -------------------------------------
     *
     * Add the sumInsured amount of all policies.
     *
     * Example:
     *
     * Policy 1 = 500,000
     * Policy 2 = 300,000
     * Policy 3 = 200,000
     *
     * totalSumInsured = 1,000,000
     *
     *
     * STEP 5 - CALCULATE CLAIM RATIO
     * -------------------------------
     *
     * Formula:
     *
     *             totalClaimed
     * Claim Ratio = ---------------- × 100
     *             totalSumInsured
     *
     * Example:
     *
     * totalClaimed = 100,000
     *
     * totalSumInsured = 1,000,000
     *
     * Claim Ratio:
     *
     * 100,000 / 1,000,000 × 100
     *
     * = 10%
     *
     *
     * STEP 6 - DETERMINE RISK
     * -----------------------
     *
     * Use normal Core Java if / else-if / else.
     *
     * If:
     *
     *     ratio < 20
     *
     * Risk:
     *
     *     LOW
     *
     *
     * If:
     *
     *     ratio >= 20
     *     AND
     *     ratio < 50
     *
     * Risk:
     *
     *     MEDIUM
     *
     *
     * If:
     *
     *     ratio >= 50
     *
     * Risk:
     *
     *     HIGH
     *
     *
     * EXAMPLE:
     *
     * Customer A:
     *
     * Income = 800,000
     * City = Mumbai
     * Policies = 2
     * Total Sum Insured = 1,000,000
     * Total Claimed = 100,000
     *
     * Claim Ratio = 10%
     *
     * Risk = LOW
     *
     *
     * IMPORTANT:
     *
     * This method may require a custom response object because
     * normal CustomerResponse may not contain:
     *
     * - totalPolicies
     * - totalClaimedAmount
     * - totalSumInsured
     * - claimRatio
     * - risk
     *
     * Check the DTOs already provided in the project.
     *
     * If there is already a suitable DTO, use it.
     *
     * Otherwise you need to decide how to represent the
     * calculated information.
     *
     *
     * NULL / EDGE CASES:
     *
     * Think about:
     *
     * 1. Customer has no policies.
     *
     * 2. Customer has no claims.
     *
     * 3. claimedAmount is null.
     *
     * 4. sumInsured is null.
     *
     * 5. totalSumInsured = 0.
     *
     * You must prevent:
     *
     * ArithmeticException
     *
     * NullPointerException
     *
     *
     * PRACTICE:
     *
     * - nested loops
     * - BigDecimal
     * - addition
     * - division
     * - multiplication
     * - compareTo()
     * - if
     * - else-if
     * - else
     * - boolean conditions
     * - accumulators
     * - counters
     * - null handling
     * - custom business calculation
     *
     *
     * THIS IS THE FINAL HARD SCENARIO.
     *
     * Do not use Stream API initially.
     *
     * Implement using normal Core Java loops.
     */
    @Override
    public List<CustomerResponse> getCustomerRiskAnalysis(
            String city,
            BigDecimal minimumIncome) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }

    @Override
    public Customer getCustoer(Long id) {
        Optional<Customer> byId = customerRepository.findById(id);

        return null;
    }
}