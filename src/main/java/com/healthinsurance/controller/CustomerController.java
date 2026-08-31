package com.healthinsurance.controller;

import com.healthinsurance.dto.CustomerResponse;
import com.healthinsurance.entity.Customer;
import com.healthinsurance.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<Customer> createCustomer(
            @RequestBody Customer customer) {

        Customer savedCustomer = service.createCustomer(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedCustomer);
    }


    @GetMapping("/getById")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id){

        Customer getById = service.getCustoer(id);
        return ResponseEntity.status(HttpStatus.OK).body(getById);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return service.getAllCustomers();
    }

//    @GetMapping("/{customerId}")
//    public CustomerResponse getCustomerById(@PathVariable Long customerId) {
//        return service.getCustomerById(customerId);
//    }

    @GetMapping("/getCityByCustomer/{city}")
    public List<CustomerResponse> getCustomersByCity(@PathVariable String city) {
        return service.getCustomersByCity(city);
    }

        @GetMapping("/getCustomerByState/{state}")
    public List<CustomerResponse> getCustomersByState(@PathVariable String state) {
        return service.getCustomersByState(state);
    }

    @GetMapping("/high-income")
    public List<CustomerResponse> getHighIncomeCustomers(@RequestParam BigDecimal minimumIncome) {
        return service.getHighIncomeCustomers(minimumIncome);
    }

    @GetMapping("/age-range")
    public List<CustomerResponse> getCustomersByAgeRange(@RequestParam Integer minAge, @RequestParam Integer maxAge) {
        return service.getCustomersByAgeRange(minAge, maxAge);
    }

    @GetMapping("/with-active-policy")
    public List<CustomerResponse> getCustomersWithActivePolicy() {
        return service.getCustomersWithActivePolicy();
    }

    @GetMapping("/without-active-policy")
    public List<CustomerResponse> getCustomersWithNoActivePolicy() {
        return service.getCustomersWithNoActivePolicy();
    }

    @GetMapping("/high-claim")
    public List<CustomerResponse> getCustomersWithHighClaimAmount(@RequestParam BigDecimal amount) {
        return service.getCustomersWithHighClaimAmount(amount);
    }

    @GetMapping("/risk-analysis")
    public List<CustomerResponse> getCustomerRiskAnalysis(@RequestParam String city, @RequestParam BigDecimal minimumIncome) {
        return service.getCustomerRiskAnalysis(city, minimumIncome);
    }
}
