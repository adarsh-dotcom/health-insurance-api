package com.healthinsurance.repository;

import com.healthinsurance.entity.PremiumPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PremiumPaymentRepository extends JpaRepository<PremiumPayment, Long> {
}
