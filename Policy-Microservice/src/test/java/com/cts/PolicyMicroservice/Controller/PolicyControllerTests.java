package com.cts.PolicyMicroservice.Controller;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.PolicyMicroservice.controller.PolicyController;
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
    public void testGetAmount()
    {
    	ResponseEntity<?> responseEntity = null;
    	when(ts.getValidity("token")).thenReturn(true);
    	when(repo.getAmount(1, 1)).thenReturn(50000);
    	responseEntity = con.getEligibleAmount("token", 1, 1);
    	assertNotNull(responseEntity);
    }
    
    
}
