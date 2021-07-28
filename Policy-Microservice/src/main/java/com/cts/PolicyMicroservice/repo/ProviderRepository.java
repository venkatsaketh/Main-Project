package com.cts.PolicyMicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.PolicyMicroservice.model.Provider;
@Repository
public interface ProviderRepository extends JpaRepository<Provider, Integer> {

}
