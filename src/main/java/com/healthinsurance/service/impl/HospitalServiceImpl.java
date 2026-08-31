package com.healthinsurance.service.impl;

import com.healthinsurance.dto.HospitalResponse;
import com.healthinsurance.repository.HospitalRepository;
import com.healthinsurance.service.HospitalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository repository;

    public HospitalServiceImpl(HospitalRepository repository) {
        this.repository = repository;
    }


    /*
     * ============================================================
     * SCENARIO 1 - EASY
     * ============================================================
     *
     * TASK:
     * Get all hospitals from the database.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Call repository.findAll().
     *
     * 2. You will receive:
     *
     *       List<Hospital>
     *
     * 3. Create:
     *
     *       List<HospitalResponse>
     *
     * 4. Use a normal for loop.
     *
     * 5. For every Hospital:
     *
     *       Hospital -> HospitalResponse
     *
     * 6. Copy the required fields.
     *
     * 7. Add the response object into the result list.
     *
     * 8. Return the final list.
     *
     * PRACTICE:
     * - findAll()
     * - for loop
     * - DTO mapping
     * - List
     *
     * DO NOT use Stream API for this exercise.
     */
    @Override
    public List<HospitalResponse> getAllHospitals() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 2 - EASY
     * ============================================================
     *
     * TASK:
     * Find one hospital using hospitalId.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals/10
     *
     * INPUT:
     *
     * hospitalId = 10
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Call repository.findById(hospitalId).
     *
     * 2. findById() returns Optional<Hospital>.
     *
     * 3. Check whether the hospital exists.
     *
     * 4. If hospital exists:
     *
     *       Hospital -> HospitalResponse
     *
     * 5. Return HospitalResponse.
     *
     * 6. If hospital does not exist:
     *
     *       throw an appropriate exception.
     *
     * IMPORTANT:
     *
     * Do not return null when hospital is not found.
     *
     * PRACTICE:
     * - findById()
     * - Optional
     * - if condition
     * - exception handling
     * - DTO mapping
     */
    @Override
    public HospitalResponse getHospitalById(Long hospitalId) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 3 - EASY
     * ============================================================
     *
     * TASK:
     * Find all hospitals that are part of the insurance network.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals/network
     *
     * DATABASE EXAMPLE:
     *
     * Hospital A -> NETWORK
     * Hospital B -> NON_NETWORK
     * Hospital C -> NETWORK
     * Hospital D -> NON_NETWORK
     *
     * RESULT:
     *
     * Hospital A
     * Hospital C
     *
     * REQUIREMENT:
     *
     * networkStatus must be:
     *
     *       NETWORK
     *
     * IMPORTANT:
     *
     * The database may contain:
     *
     *       NETWORK
     *
     * while the input/value may be:
     *
     *       network
     *
     * Comparison should ignore case.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all hospitals.
     *
     * 2. Create result list.
     *
     * 3. Loop through hospitals.
     *
     * 4. Read networkStatus.
     *
     * 5. Check whether status is NETWORK.
     *
     * 6. Add matching hospitals to result.
     *
     * PRACTICE:
     * - for loop
     * - if
     * - String comparison
     * - equalsIgnoreCase()
     * - DTO mapping
     */
    @Override
    public List<HospitalResponse> getNetworkHospitals() {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 4 - EASY
     * ============================================================
     *
     * TASK:
     * Find hospitals by city.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals/city?city=Mumbai
     *
     * INPUT:
     *
     * city = "Mumbai"
     *
     * DATABASE:
     *
     * Hospital A -> Mumbai
     * Hospital B -> Pune
     * Hospital C -> Mumbai
     *
     * RESULT:
     *
     * Hospital A
     * Hospital C
     *
     * IMPORTANT:
     *
     * User might send:
     *
     *       " mumbai "
     *
     * Database:
     *
     *       "Mumbai"
     *
     * These should match.
     *
     * Therefore:
     *
     * 1. Remove leading/trailing spaces.
     *
     * 2. Compare without considering upper/lower case.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all hospitals.
     *
     * 2. Normalize the input city.
     *
     * 3. Loop through hospitals.
     *
     * 4. Get hospital city.
     *
     * 5. Compare hospital city with requested city.
     *
     * 6. Add matching hospitals.
     *
     * PRACTICE:
     * - trim()
     * - equalsIgnoreCase()
     * - String handling
     * - for loop
     * - if condition
     */
    @Override
    public List<HospitalResponse> getHospitalsByCity(String city) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 5 - MEDIUM
     * ============================================================
     *
     * TASK:
     * Find hospitals by STATE.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals/state?state=Maharashtra
     *
     * INPUT:
     *
     * state = "Maharashtra"
     *
     * DATABASE:
     *
     * Hospital A -> Maharashtra
     * Hospital B -> Gujarat
     * Hospital C -> Maharashtra
     *
     * RESULT:
     *
     * Hospital A
     * Hospital C
     *
     * REQUIREMENT:
     *
     * State must match the requested state.
     *
     * Comparison should be case-insensitive.
     *
     * WHAT YOU NEED TO DO:
     *
     * 1. Get all hospitals.
     *
     * 2. Create result list.
     *
     * 3. Loop through all hospitals.
     *
     * 4. Read hospital state.
     *
     * 5. Compare with input state.
     *
     * 6. If matched:
     *
     *       add hospital to result.
     *
     * 7. Convert Entity -> DTO.
     *
     * PRACTICE:
     * - for loop
     * - if
     * - String comparison
     * - DTO mapping
     * - filtering
     */
    @Override
    public List<HospitalResponse> getHospitalsByState(String state) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }


    /*
     * ============================================================
     * SCENARIO 6 - MEDIUM -> HARD
     * ============================================================
     *
     * TASK:
     * Find hospitals whose rating is greater than or equal to
     * the requested minimum rating.
     *
     * API EXAMPLE:
     *
     * GET /api/hospitals/rating?minimumRating=4.0
     *
     * INPUT:
     *
     * minimumRating = 4.0
     *
     * DATABASE:
     *
     * Hospital A -> 4.5
     * Hospital B -> 3.5
     * Hospital C -> 4.0
     * Hospital D -> 4.8
     *
     * RESULT:
     *
     * Hospital A -> 4.5
     * Hospital C -> 4.0
     * Hospital D -> 4.8
     *
     * Hospital B is excluded.
     *
     *
     * CONDITION:
     *
     * rating >= minimumRating
     *
     *
     * ADDITIONAL CALCULATION:
     * ------------------------
     *
     * While processing the matching hospitals, calculate:
     *
     *       TOTAL RATING
     *
     * and:
     *
     *       NUMBER OF MATCHING HOSPITALS
     *
     * Then calculate:
     *
     *       averageRating =
     *
     *       totalRating / numberOfHospitals
     *
     *
     * EXAMPLE:
     *
     * Matching hospitals:
     *
     * 4.5
     * 4.0
     * 4.8
     *
     * Total:
     *
     * 4.5 + 4.0 + 4.8
     *
     * = 13.3
     *
     * Count:
     *
     * 3
     *
     * Average:
     *
     * 13.3 / 3
     *
     * = 4.4333...
     *
     *
     * IMPORTANT:
     *
     * You need two variables:
     *
     * totalRating
     *
     * count
     *
     * Every time a hospital matches:
     *
     * totalRating increases.
     *
     * count increases by 1.
     *
     *
     * EDGE CASE:
     * ----------
     *
     * What if NO hospital matches?
     *
     * Example:
     *
     * minimumRating = 5.0
     *
     * Database has:
     *
     * 3.5
     * 4.0
     * 4.5
     *
     * Then:
     *
     * count = 0
     *
     * You must NOT perform:
     *
     * totalRating / 0
     *
     * because it will cause an error.
     *
     * Handle this case properly.
     *
     *
     * NULL CASE:
     * ----------
     *
     * What if one hospital has:
     *
     * rating = null
     *
     * Your code should not throw:
     *
     * NullPointerException
     *
     *
     * PRACTICE:
     * - double/Double comparison
     * - for loop
     * - if condition
     * - accumulator
     * - counter
     * - average calculation
     * - division
     * - zero handling
     * - null handling
     *
     *
     * CHALLENGE:
     * ----------
     *
     * The API response currently may only contain hospital data.
     *
     * You don't necessarily need to add averageRating to the
     * HospitalResponse unless the DTO supports it.
     *
     * The main objective is to practice the calculation.
     */
    @Override
    public List<HospitalResponse> getHospitalsByMinimumRating(
            Double minimumRating) {

        // TODO: Implement the business logic yourself.

        throw new UnsupportedOperationException("Implement service logic");
    }
}