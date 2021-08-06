package com.cts.PolicyMicroservice.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.PolicyMicroservice.model.Policy;
import com.cts.PolicyMicroservice.repo.PolicyRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class PolicyServiceTest 
{
	@Mock
	private PolicyRepository policyrepo;
	
	@InjectMocks
	private PolicyService pser;
	
	@Test
	public void testGet()
	{
		Optional<Policy> x = Optional.of(new Policy(1,"ambulance allowance",50000,12));
		when(policyrepo.findById(1)).thenReturn(x);
		assertNotNull(pser.get(1));
	}
	
	@Test
	public void testGetAll()
	{
		Policy x = new Policy(1,"ambulance allowance",50000,12);
		Policy y = new Policy(2,"surgery waiver",60000,23);
		List<Policy> arr = Arrays.asList(x,y);
		when(policyrepo.findAll()).thenReturn(arr);
		assertNotNull(pser.getAll());
	}
	
	
}
