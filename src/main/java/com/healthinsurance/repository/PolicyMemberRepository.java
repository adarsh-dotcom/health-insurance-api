package com.healthinsurance.repository;

import com.healthinsurance.entity.PolicyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyMemberRepository extends JpaRepository<PolicyMember, Long> {
}
