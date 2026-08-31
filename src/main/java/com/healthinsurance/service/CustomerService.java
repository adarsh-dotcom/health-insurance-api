package com.healthinsurance.service;

import com.healthinsurance.dto.CustomerResponse;
import com.healthinsurance.entity.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer);
    List<CustomerResponse> getAllCustomers();

    CustomerResponse getCustomerById(Long customerId);

    List<CustomerResponse> getCustomersByCity(String city);

    List<CustomerResponse> getCustomersByState(String state);

    List<CustomerResponse> getHighIncomeCustomers(BigDecimal minimumIncome);

    List<CustomerResponse> getCustomersByAgeRange(Integer minAge, Integer maxAge);

    List<CustomerResponse> getCustomersWithActivePolicy();

    List<CustomerResponse> getCustomersWithNoActivePolicy();

    List<CustomerResponse> getCustomersWithHighClaimAmount(BigDecimal amount);

    List<CustomerResponse> getCustomerRiskAnalysis(String city, BigDecimal minimumIncome);

    Customer getCustoer(Long id);
}
