package com.cts.PolicyMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.PolicyMicroservice.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer> {

}
