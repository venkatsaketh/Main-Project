package com.cts.PolicyMicroservice.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cts.PolicyMicroservice.exception.AuthorizationException;
import com.cts.PolicyMicroservice.feign.Auth;
import com.cts.PolicyMicroservice.model.Policy;
import com.cts.PolicyMicroservice.model.Provider;
import com.cts.PolicyMicroservice.repo.MemberPolicyRepository;
import com.cts.PolicyMicroservice.service.PolicyService;
import com.cts.PolicyMicroservice.service.TokenService;

@RestController
public class PolicyController 
{
	@Autowired
	Environment env;
	
	@Autowired
	private Auth authorizationClient;
	
	@Autowired
	private TokenService ts;
	@Autowired 
	private PolicyService policyser;
	
	@Autowired
	private MemberPolicyRepository repo;
	
	
	@GetMapping("/getAllPolicies")
	public ResponseEntity<?> getAllPolicies(@RequestHeader(name = "Authorization",required = true) String token)
	{
		ResponseEntity<?> responseEntity;
		List<Policy> ps =null;
		try {
			if (ts.getValidity(token)) {
				ps = policyser.getAll();
			} else {
				throw new AuthorizationException("Not allowed");
			}
		
		}
		catch(Exception e)
		{
			responseEntity= new ResponseEntity<String>(env.getProperty("string.null"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		responseEntity  = new ResponseEntity<List<Policy>>(ps,HttpStatus.OK);
		return responseEntity;
	}
	
	
	@GetMapping("/getChainOfProviders/{pid}")
	public ResponseEntity<?> getProviders(@RequestHeader(name = "Authorization",required = true) String token,@PathVariable int pid)
	 {
		ResponseEntity<?> responseEntity;
		Set<Provider> pr=null;
		System.out.println(authorizationClient.authorizeRequest(token));
		System.out.println(token);
		try {
			if (ts.getValidity(token)) {
				Policy p =  policyser.get(pid);
				 pr = p.getProviderList();
			} else {
				throw new AuthorizationException("Not allowed");
			}
		
		}
		catch(Exception e)
		{
			responseEntity= new ResponseEntity<String>(env.getProperty("string.null"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		System.out.println(pr);
		responseEntity = new ResponseEntity<Set<Provider>>(pr,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getEligibleBenefits/{pid}/{mid}")
	public ResponseEntity<?> getbenefits(@RequestHeader(name = "Authorization",required = true) String token,@PathVariable int pid, @PathVariable long mid)
	{
		ResponseEntity<?> responseEntity=null;
		List<String> res=null;
		try
		{if (ts.getValidity(token)) {
			res=repo.getBenefits(pid, mid);
		} else {
			throw new AuthorizationException("Not allowed");
		}
			
		}
		catch(Exception e)
		{
			responseEntity= new ResponseEntity<String>(env.getProperty("string.null"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		responseEntity = new ResponseEntity<List<String>>(res,HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/getEligibleClaimAmount/{pid}/{mid}")
	public ResponseEntity<?> getEligibleAmount(@RequestHeader(name = "Authorization",required = true) String token,@PathVariable int pid, @PathVariable long mid)
	{
		ResponseEntity<?> responseEntity=null;
		int res=0;
		try
		{
			if (ts.getValidity(token)) {
				res= repo.getAmount(pid,mid);
			} else {
				throw new AuthorizationException("Not allowed");
			}
			
		}
		catch(Exception e)
		{
			responseEntity= new ResponseEntity<String>(env.getProperty("string.null"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		responseEntity = new ResponseEntity<Integer>(res,HttpStatus.OK);
		return responseEntity;
		
	}
}
