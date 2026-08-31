package com.healthinsurance.controller;

import com.healthinsurance.dto.PolicyResponse;
import com.healthinsurance.service.PolicyService;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyService service;
    public PolicyController(PolicyService service){this.service=service;}

    @GetMapping public List<PolicyResponse> getAllPolicies(){return service.getAllPolicies();}
    @GetMapping("/{policyId}") public PolicyResponse getPolicyById(@PathVariable Long policyId){return service.getPolicyById(policyId);}
    @GetMapping("/customer/{customerId}") public List<PolicyResponse> getPoliciesByCustomer(@PathVariable Long customerId){return service.getPoliciesByCustomer(customerId);}
    @GetMapping("/status/{status}") public List<PolicyResponse> getPoliciesByStatus(@PathVariable String status){return service.getPoliciesByStatus(status);}
    @GetMapping("/product/{productId}") public List<PolicyResponse> getPoliciesByProduct(@PathVariable Long productId){return service.getPoliciesByProduct(productId);}
    @GetMapping("/premium-range") public List<PolicyResponse> getPoliciesByPremiumRange(@RequestParam BigDecimal minPremium,@RequestParam BigDecimal maxPremium){return service.getPoliciesByPremiumRange(minPremium,maxPremium);}
    @GetMapping("/expiring") public List<PolicyResponse> getExpiringPolicies(@RequestParam Integer days){return service.getExpiringPolicies(days);}
    @GetMapping("/renewal-status/{renewalStatus}") public List<PolicyResponse> getPoliciesByRenewalStatus(@PathVariable String renewalStatus){return service.getPoliciesByRenewalStatus(renewalStatus);}
}
