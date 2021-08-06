package com.cts.PolicyMicroservice.Controller;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.hibernate.boot.registry.BootstrapServiceRegistry;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.PolicyMicroservice.controller.PolicyController;
import com.cts.PolicyMicroservice.exception.AuthorizationException;
import com.cts.PolicyMicroservice.feign.Auth;
import com.cts.PolicyMicroservice.model.Policy;
import com.cts.PolicyMicroservice.model.Provider;
import com.cts.PolicyMicroservice.repo.MemberPolicyRepository;
import com.cts.PolicyMicroservice.service.PolicyService;
import com.cts.PolicyMicroservice.service.TokenService;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class PolicyControllerTests 
{
	@Mock
	private PolicyService policyser;
	@Mock
	private TokenService ts;
	@InjectMocks
	private PolicyController con;
	@Mock
	Policy po;
	@Mock
	private MemberPolicyRepository repo;
	@Mock
	private Auth authorizationClient;
	@Mock
	Environment env;
    @Test
	public void testGetProviders()
	{
    	 ResponseEntity<?> responseEntity = null;
    	 when(ts.getValidity("token")).thenReturn(true);
    	 when(policyser.get(1)).thenReturn(po);
    	 Set<Provider> s = new HashSet<>();
    	 s.add(new Provider(1,"medicover","Hyd"));
    	 when(po.getProviderList()).thenReturn(s);
    	 responseEntity = con.getProviders("token", 1);
    	 assertNotNull(responseEntity);
	}
    
    @Test
	public void testGetProvidersIfNull()
	{
    	 ResponseEntity<?> responseEntity = null;
    	 when(ts.getValidity("token")).thenReturn(true);
    	 when(policyser.get(1)).thenReturn(po);
    	 Set<Provider> s = null;
    	 when(po.getProviderList()).thenReturn(s);
    	 responseEntity = con.getProviders("token", 1);
    	 assertNull(responseEntity.getBody());
	}
    @Test
    public void testGetBenefits()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	List<String> x = new ArrayList<>();
    	x.add("ambulance allowance");
    	when(repo.getBenefits(1, 1)).thenReturn(x);
    	responseEntity = con.getbenefits("token", 1, 1);
    	assertNotNull(responseEntity);
    }
    @Test
    public void testGetBenefitsIfNull()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	List<String> x = null;
    	when(repo.getBenefits(1, 1)).thenReturn(x);
    	responseEntity = con.getbenefits("token", 1, 1);
    	assertNull(responseEntity.getBody());
    }
    
    
    @Test
    public void testGetAmount()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	when(repo.getAmount(1, 1)).thenReturn(50000);
    	responseEntity = con.getEligibleAmount("token", 1, 1);
    	assertNotNull(responseEntity);
    }
    
    @Test
    public void testGetAmountIfNull()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	when(repo.getAmount(1, 1)).thenReturn(0);
    	responseEntity = con.getEligibleAmount("token", 1, 1);
    	assertEquals(responseEntity.getBody(),0);
    }
    
    @Test//(expected = AuthorizationException.class)
    public void testAuthForGetProviders()
    {
    	ResponseEntity<?> responseEntity = null;
   	    when(ts.getValidity("token")).thenReturn(false);
   	   
	    responseEntity = con.getProviders("token", 1);
	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }
    
    @Test
    public void testGetAllPolicies()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	List<Policy> arr = new ArrayList<>();
    	Policy a1 = new Policy(1,"xyz",1234,12);
    	Policy a2 = new Policy(2,"xyze",134,18);
    	arr.add(a2);
    	arr.add(a1);
    	when(policyser.getAll()).thenReturn(arr);
    	responseEntity = con.getAllPolicies("token");
    	assertNotNull(responseEntity);
    }
    
    @Test
    public void testGetAllPoliciesIfNull()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	
    	when(policyser.getAll()).thenReturn(null);
    	responseEntity = con.getAllPolicies("token");
    	assertNull(responseEntity.getBody());
    }
    
    @Test//(expected = AuthorizationException.class)
    public void testAuthForGetAllProviders()
    {
    	ResponseEntity<?> responseEntity = null;
   	    when(ts.getValidity("token")).thenReturn(false);
   	   
	    responseEntity = con.getAllPolicies("token");
	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }
    
    @Test//(expected = AuthorizationException.class)
    public void testAuthForGetbenefits()
    {
    	ResponseEntity<?> responseEntity = null;
   	    when(ts.getValidity("token")).thenReturn(false);
   	   
	    responseEntity = con.getbenefits("token",1,1);
	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }
    
    @Test//(expected = AuthorizationException.class)
    public void testAuthForGetAmount()
    {
    	ResponseEntity<?> responseEntity = null;
   	    when(ts.getValidity("token")).thenReturn(false);
   	   
	    responseEntity = con.getEligibleAmount("token",1,1);
	    assertEquals(HttpStatus.INTERNAL_SERVER_ERROR,responseEntity.getStatusCode());
    }
}
