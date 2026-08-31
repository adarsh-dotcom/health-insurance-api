package com.healthinsurance.controller;

import com.healthinsurance.dto.PremiumPaymentResponse;
import com.healthinsurance.service.PremiumPaymentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PremiumPaymentController {
    private final PremiumPaymentService service;
    public PremiumPaymentController(PremiumPaymentService service){this.service=service;}

    @GetMapping public List<PremiumPaymentResponse> getAllPayments(){return service.getAllPayments();}
    @GetMapping("/{paymentId}") public PremiumPaymentResponse getPaymentById(@PathVariable Long paymentId){return service.getPaymentById(paymentId);}
    @GetMapping("/policy/{policyId}") public List<PremiumPaymentResponse> getPaymentsByPolicy(@PathVariable Long policyId){return service.getPaymentsByPolicy(policyId);}
    @GetMapping("/status/{status}") public List<PremiumPaymentResponse> getPaymentsByStatus(@PathVariable String status){return service.getPaymentsByStatus(status);}
    @GetMapping("/failed") public List<PremiumPaymentResponse> getFailedPayments(){return service.getFailedPayments();}
    @GetMapping("/pending") public List<PremiumPaymentResponse> getPendingPayments(){return service.getPendingPayments();}
    @GetMapping("/late") public List<PremiumPaymentResponse> getLatePayments(){return service.getLatePayments();}
}
