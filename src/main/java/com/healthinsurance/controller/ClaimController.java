package com.healthinsurance.controller;

import com.healthinsurance.dto.ClaimResponse;
import com.healthinsurance.service.ClaimService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    private final ClaimService service;
    public ClaimController(ClaimService service){this.service=service;}

    @GetMapping public List<ClaimResponse> getAllClaims(){return service.getAllClaims();}
    @GetMapping("/{claimId}") public ClaimResponse getClaimById(@PathVariable Long claimId){return service.getClaimById(claimId);}
    @GetMapping("/policy/{policyId}") public List<ClaimResponse> getClaimsByPolicy(@PathVariable Long policyId){return service.getClaimsByPolicy(policyId);}
    @GetMapping("/customer/{customerId}") public List<ClaimResponse> getClaimsByCustomer(@PathVariable Long customerId){return service.getClaimsByCustomer(customerId);}
    @GetMapping("/status/{status}") public List<ClaimResponse> getClaimsByStatus(@PathVariable String status){return service.getClaimsByStatus(status);}
    @GetMapping("/hospital/{hospitalId}") public List<ClaimResponse> getClaimsByHospital(@PathVariable Long hospitalId){return service.getClaimsByHospital(hospitalId);}
    @GetMapping("/type/{claimType}") public List<ClaimResponse> getClaimsByClaimType(@PathVariable String claimType){return service.getClaimsByClaimType(claimType);}
    @GetMapping("/high-value") public List<ClaimResponse> getHighValueClaims(@RequestParam BigDecimal amount){return service.getHighValueClaims(amount);}
    @GetMapping("/date-range") public List<ClaimResponse> getClaimsByDateRange(@RequestParam String startDate,@RequestParam String endDate){return service.getClaimsByDateRange(startDate,endDate);}
}
