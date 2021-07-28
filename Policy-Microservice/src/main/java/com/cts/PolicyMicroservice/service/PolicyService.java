package com.cts.PolicyMicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.PolicyMicroservice.model.Policy;
import com.cts.PolicyMicroservice.repo.PolicyRepository;

@Service
public class PolicyService 
{
    @Autowired
	private PolicyRepository policyrepo;
  
     public Policy get(int id)
     {
    	 return policyrepo.findById(id).get();
     }
}
