package com.healthinsurance.repository;

import com.healthinsurance.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(
            value = """
                    select customer_id from customers
                    where customer_id = :customerId
                    """, nativeQuery = true
    )
    Long getCustomerId(@Param("customerId") Long customerId);



    List<Customer> findByCityIgnoreCase(String city);

    List<Customer> findByStateIgnoreCase(String state);


}
